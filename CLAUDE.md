# Flux — règles de travail

Application Flutter (Android et iOS) qui affiche la consommation de données en direct. Lire `README.md` pour l'architecture et les limites connues.

## Avant de committer

- `flutter analyze` sans aucune remarque, `flutter test` tout vert, `dart format -l 120 lib test`.
- Écrire ou adapter un test pour chaque comportement nouveau ou corrigé.
- Textes de l'app en français, tutoiement proscrit, pas de jargon : l'app vise des utilisateurs de 10 à 55 ans.

## Promesses de l'app (ne jamais les contredire)

- Rien n'est enregistré par défaut ; l'historique est un choix explicite de l'utilisateur.
- Rien n'est envoyé : l'app Android ne demande pas la permission Internet. Ne jamais l'ajouter.
- Le contenu du trafic n'est jamais lu : seulement des compteurs.
- Toute nouvelle donnée gardée ou nouvelle permission doit être reflétée dans l'écran Confidentialité, `docs/play/politique-de-confidentialite.md` et `README.md`.

## Secrets

- Jamais de clé, mot de passe ou fichier JSON de compte de service dans le dépôt. Les secrets vivent dans GitHub Actions (voir `README.md`, « Publication sur Google Play »). Le dossier `.secrets/` est ignoré par git.
- Ne jamais lancer `git add -A` depuis un sous-dossier ; vérifier `git status` avant chaque commit.

## Publication (voir `.github/workflows/deploy.yml`)

- Travailler sur une branche `feature/...`, puis fusionner dans `main` : chaque envoi sur `main` publie automatiquement sur la piste **interne** de Google Play.
- À chaque fonctionnalité ou correction visible, mettre à jour `distribution/whatsnew/whatsnew-fr-FR` (500 caractères max., phrases courtes, du point de vue de l'utilisateur).
- Augmenter `version:` dans `pubspec.yaml` (nom de version seulement ; le code de version est calculé par le pipeline).
- Ne créer un tag `vX.Y.Z` (publication en **production**, progressive à 20 %) que sur instruction explicite de l'utilisateur. Élargir ensuite avec le workflow « Déploiement progressif ».
- Ne jamais réécrire l'historique de `main` ni forcer un push sans accord explicite.
