"""Élargit ou suspend le déploiement progressif de la piste production.

Usage : play_rollout.py <package> fraction <0.05..1>
        play_rollout.py <package> halt

La clé JSON du compte de service est lue dans PLAY_SERVICE_ACCOUNT_JSON.
Avec une fraction de 1, la version passe en déploiement complet.
"""

import json
import os
import sys

import requests
from google.oauth2 import service_account
from google.auth.transport.requests import Request

API = "https://androidpublisher.googleapis.com/androidpublisher/v3/applications"
SCOPE = "https://www.googleapis.com/auth/androidpublisher"


def main() -> int:
    if len(sys.argv) < 3:
        print(__doc__)
        return 2
    package, action = sys.argv[1], sys.argv[2]
    raw = os.environ.get("PLAY_SERVICE_ACCOUNT_JSON")
    if not raw:
        print("PLAY_SERVICE_ACCOUNT_JSON manquant", file=sys.stderr)
        return 2

    creds = service_account.Credentials.from_service_account_info(json.loads(raw), scopes=[SCOPE])
    creds.refresh(Request())
    s = requests.Session()
    s.headers["Authorization"] = f"Bearer {creds.token}"

    def call(method, path, **kw):
        r = s.request(method, f"{API}/{package}/{path}", timeout=60, **kw)
        if not r.ok:
            print(f"{method} {path} → {r.status_code}: {r.text}", file=sys.stderr)
            sys.exit(1)
        return r.json() if r.text else {}

    edit = call("POST", "edits")["id"]
    track = call("GET", f"edits/{edit}/tracks/production")
    releases = track.get("releases", [])
    current = next((r for r in releases if r.get("status") == "inProgress"), None)
    if current is None:
        print("Aucune version en cours de déploiement progressif en production.")
        call("DELETE", f"edits/{edit}")
        return 1

    name = current.get("name", "?")
    if action == "halt":
        current["status"] = "halted"
        print(f"Suspension de la version {name}.")
    else:
        fraction = float(sys.argv[3]) if len(sys.argv) > 3 else 0.5
        if fraction >= 1:
            current["status"] = "completed"
            current.pop("userFraction", None)
            print(f"Déploiement complet de la version {name}.")
        else:
            if not 0.05 <= fraction < 1:
                print("La fraction doit être entre 0,05 et 1.", file=sys.stderr)
                return 2
            current["userFraction"] = fraction
            print(f"Version {name} : {fraction:.0%} des utilisateurs.")

    call("PUT", f"edits/{edit}/tracks/production", json={"track": "production", "releases": [current]})
    call("POST", f"edits/{edit}:commit")
    print("Fait.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
