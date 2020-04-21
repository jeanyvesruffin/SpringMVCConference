# SPRING MVC

Remise à niveau Spring

## Components

Les components Spring sont composés de :

1.Controller


- Traite les requetes et reponses (Handles request/ response)
- Ne tiens pas compte de la logique Business (No business logic)
- Coordonne le dépot avec le service (Coordinate with service and repository)
- Sont annotés avec @Controller (Annoted with @Controller)
- Gère les exceptions et affiche le routage (Handles exceptions and view routing)

*Le controlleur interprete et transforme les interactions de l'utilisateur pour les transmettres au model *

*Le controlleur accède à la logique métier *

*Le controlleur détermine le type de vue ou de réponse *

*Le controlleur interpréte les exceptions *

2.Service

- Sont annotés avec @Service (Annoted with @Service)
- Décrit les verbes / actions du système (describes verbs/actions of system)
- La logique métier apparait ici (business logic belongs here)
- Garantit l'état de l'objet métier (Ensures business object state)
- Transactionnel (Transactional)
- Souvent les mêmes méthodes que le référentiel (Often same methods as repository
)


3.Repository

- Sont annotés avec @Repository (annotated with @ repository)
- Noms (données) du système (nouns (data) of the system)
- Interaction de base de données (database interaction)
- Mappage d'objets un à un (One to one object mapping)
- Souvent un mappage de table de base de données (often one to one database table  mapping)


#### Bug fixes server TOMCAT

Erreur 404 lors du démarrage TOMCAT

Cliquer sur propriete > General puis cliquer sur le bouton "Switch Location", celle-ci doit se mettre à jours.

Double-cliquer ensuite sur le server puis cocher dans la rubrique Server Locations sur la case > Use Tomcat installation (takes controle of Tomcat installation)

Votre server TOMCAT est maintenant operationnel à l'adresse URl: localhost:8080