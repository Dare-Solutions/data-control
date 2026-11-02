# Play Console — réponses aux formulaires

Ce que répondre dans Play Console › Contenu de l'application, et où déclarer les permissions sensibles. À ne faire qu'une fois ; les mises à jour passent ensuite par le pipeline.

| Formulaire | Réponse pour Flux |
| --- | --- |
| **Politique de confidentialité** | L'URL publique de `docs/play/politique-de-confidentialite.html` (voir README, « Héberger la politique »). |
| **Accès à l'application** | « Toutes les fonctionnalités sont accessibles sans accès spécial ». L'accès « Données d'utilisation » est un réglage du téléphone, pas un identifiant ; l'écran explique comment l'activer. |
| **Annonces** | Non, l'application ne contient pas d'annonces. |
| **Classification du contenu** | Questionnaire IARC, catégorie « Utilitaire, productivité, communication ou autre ». Répondre non à tout (violence, sexualité, langage, substances, jeux d'argent, interactions entre utilisateurs, partage de position, achats). Résultat attendu : PEGI 3 / Tous publics. |
| **Audience cible** | « 13 ans et plus » (ou plus restrictif). Ne pas cocher les tranches enfants : cela soumettrait l'app au programme Familles, avec des exigences supplémentaires, sans bénéfice ici. |
| **Application d'actualités** | Non. |
| **Applications de suivi des contacts et de l'état de santé (COVID-19)** | Non. |
| **Sécurité des données** | Aucune donnée collectée, aucune donnée partagée. (Au sens de Google, « collecter » = transmettre hors de l'appareil. Flux n'a pas la permission Internet.) Cocher que les données sont chiffrées en transit n'a pas lieu d'être ; cocher « l'utilisateur peut demander la suppression » : oui, via l'historique et la désinstallation. |
| **Applications gouvernementales** | Non. |
| **Fonctionnalités financières** | Aucune. |
| **Applications de santé** | Aucune fonctionnalité de santé. |

## Permissions à déclarer

Ces déclarations apparaissent dans « Contenu de l'application » (ou au moment de l'envoi de la version) parce que l'AAB les contient.

### Accès aux données d'utilisation (`PACKAGE_USAGE_STATS`)

- Fonctionnalité principale : « Gestion / surveillance de la consommation de données ».
- Description à fournir : *Flux affiche la consommation de données réseau de chaque application pendant une mesure lancée par l'utilisateur, à partir des statistiques réseau qu'Android tient déjà (NetworkStatsManager). L'accès est facultatif, demandé uniquement à l'ouverture de l'écran « Consommation par app », expliqué à l'écran avant la demande. Les chiffres sont affichés et ne sont conservés que dans le résumé d'une mesure si l'utilisateur active l'historique. Ils ne quittent jamais l'appareil : l'application n'a pas la permission Internet.*
- Une vidéo du parcours peut être demandée : filmer l'ouverture de l'écran, la page d'explication, le réglage Android, puis la liste des apps.

### Service au premier plan de type « usage spécial » (`FOREGROUND_SERVICE_SPECIAL_USE`)

- Description à fournir : *Pendant une mesure que l'utilisateur démarre (GO) et arrête (STOP), le service lit toutes les 2 secondes les compteurs d'octets réseau du système pour afficher le débit en direct et le volume cumulé, y compris quand l'application n'est plus à l'écran. Une notification permanente montre le débit et offre un bouton STOP. Le service s'arrête à STOP, à l'arrêt automatique choisi par l'utilisateur, ou quand l'application est fermée depuis les applications récentes. Aucun type de service existant ne correspond à une mesure réseau continue.*

### Autres permissions

`ACCESS_NETWORK_STATE`, `BLUETOOTH` (≤ Android 11), `FOREGROUND_SERVICE`, `POST_NOTIFICATIONS`, `WAKE_LOCK` : pas de formulaire, elles sont expliquées dans la politique de confidentialité.

## Tests fermés obligatoires (comptes personnels créés après novembre 2023)

Google exige un test fermé avec au moins 12 testeurs actifs pendant 14 jours avant de pouvoir demander l'accès à la production. Si votre compte est concerné :

1. Créez une piste « Test fermé » (Tests › Tests fermés) et une liste de testeurs (adresses e-mail ou groupe Google).
2. Le pipeline publie sur la piste interne ; promouvez la version vers le test fermé depuis la console (une fois), ou changez `track: internal` en `track: alpha` dans `deploy.yml` le temps du test.
3. Après 14 jours, demandez l'accès à la production (Tableau de bord › « Demander l'accès à la production ») et répondez au questionnaire.
