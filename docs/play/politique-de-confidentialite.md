# Politique de confidentialité — Flux

*Dernière mise à jour : 2 novembre 2026*

Flux est une application Android et iOS qui affiche, en direct, le débit des données de votre téléphone, canal par canal (Wi-Fi, réseau mobile, USB, Bluetooth) et, sur Android, la part de chaque application. Cette politique explique ce que Flux fait, et ne fait pas, de vos données.

## En bref

- **Flux n'envoie aucune donnée.** Sur Android, l'application ne demande pas la permission d'accéder à Internet : elle ne peut techniquement rien transmettre, à personne.
- **Flux ne lit pas le contenu de votre trafic.** Elle ne lit que des compteurs d'octets fournis par le système (combien, et par où).
- **Flux n'enregistre rien par défaut.** Les mesures restent en mémoire pendant une capture et disparaissent après l'écran de résumé.
- **Pas de compte, pas d'inscription, pas de publicité, pas de suivi.**

## Ce que Flux lit sur votre téléphone

| Donnée | D'où elle vient | À quoi elle sert | Où elle va |
| --- | --- | --- | --- |
| Compteurs d'octets de chaque canal (Wi-Fi, mobile, USB, Bluetooth) | Le système (Android : `TrafficStats`, interfaces réseau ; iOS : interfaces réseau) | Calculer le débit et les volumes pendant une capture | En mémoire pendant la capture ; effacés à l'arrêt, sauf le résumé si vous activez l'historique |
| État des canaux (connecté, Bluetooth activé, VPN actif) | Le système | Afficher l'état de chaque canal | Jamais conservé |
| Consommation de données de chaque application (Android seulement, avec l'accès « Données d'utilisation ») | Les statistiques d'utilisation réseau qu'Android tient déjà pour chaque application | Montrer quelles applications consomment, pendant une capture ou sur les derniers jours | Lue à l'affichage ; conservée dans le résumé d'une capture seulement si vous activez l'historique |
| Noms et icônes des applications installées (Android) | Le système | Afficher les applications dans la liste | Jamais conservé (les icônes sont relues à l'affichage) |

Flux ne lit ni le contenu de vos communications, ni les sites visités, ni les identifiants de votre appareil, ni votre position, ni vos contacts.

## Ce que Flux garde sur votre téléphone

- **Vos réglages** (unités, thème, canaux affichés, arrêt automatique, écran allumé, historique activé ou non).
- **Pendant une capture** : son point de départ et les totaux en cours, pour que la capture survive si le système ferme l'application. Ces informations sont effacées à l'arrêt de la capture.
- **Si vous activez l'historique** (désactivé par défaut) : le résumé de chaque capture, c'est-à-dire la date, la durée, les volumes par canal et, sur Android, la part de chaque application (nom de l'application et volumes). Au plus 500 captures sont gardées. Vous pouvez supprimer une capture, tout effacer, ou désactiver l'historique, ce qui efface tout.

Ces données restent dans l'espace privé de l'application sur votre téléphone. Sur Android, la sauvegarde automatique vers le cloud est désactivée pour Flux. Sur iPhone, elles peuvent faire partie des sauvegardes de l'appareil (iCloud ou ordinateur) que vous choisissez de faire ; elles sont alors protégées par Apple comme le reste de votre sauvegarde.

## Ce que Flux ne fait pas

- Aucune donnée n'est transmise à l'éditeur de Flux, ni à un tiers.
- Aucun outil d'analyse, de mesure d'audience, de publicité ou de rapport de plantage n'est intégré.
- Aucune donnée n'est vendue, partagée ou utilisée à d'autres fins.

## Permissions demandées

**Android**

- *État du réseau* (`ACCESS_NETWORK_STATE`) : savoir quels canaux sont connectés. Accordée automatiquement.
- *Bluetooth* (Android 11 et avant) : savoir si le Bluetooth est activé. Flux ne se connecte à aucun appareil.
- *Service au premier plan* et *verrou de veille* : pour que la capture continue quand vous utilisez d'autres applications ou éteignez l'écran, avec une notification visible et un bouton STOP. Actifs seulement pendant une capture que vous avez lancée.
- *Notifications* (Android 13 et plus) : pour afficher la notification de capture en cours. Si vous refusez, la capture fonctionne quand même.
- *Accès aux données d'utilisation* (`PACKAGE_USAGE_STATS`) : facultatif, demandé seulement si vous ouvrez l'écran « Consommation par app ». Il sert uniquement à lire la consommation réseau de chaque application, telle qu'Android la compte. Flux ne lit pas quelles applications vous ouvrez ni combien de temps vous les utilisez.
- *Internet* : **non demandée**, volontairement.

**iOS**

Aucune permission n'est demandée. Flux lit les compteurs réseau du système. iOS ne permet pas la consommation par application ni la mesure continue en arrière-plan.

## Enfants

Flux ne collecte aucune donnée et ne contient ni publicité ni achat intégré. Elle peut être utilisée par tous les âges.

## Vos droits

Toutes les données que Flux manipule sont sur votre téléphone et sous votre contrôle : vous pouvez les consulter dans l'application, les supprimer (historique), ou désinstaller l'application, ce qui efface tout. Flux ne détenant aucune donnée vous concernant, il n'y a rien à demander à son éditeur ; nous répondons néanmoins volontiers à vos questions à l'adresse ci-dessous.

## Modifications

Si cette politique change, la nouvelle version sera publiée à la même adresse, avec sa date de mise à jour, et l'application la mentionnera dans ses notes de version.

## Contact

[VOTRE NOM OU RAISON SOCIALE]
[VOTRE E-MAIL]
