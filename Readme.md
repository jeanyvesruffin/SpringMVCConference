# SPRING MVC

Remise à niveau Spring

## Commencer

Cloner le projet dans Eclipse pour executer et voir les différents TP réalisés

### Conditions préalables

Sous Windows:

L'utilisation de chocolotey comme gestionnaire de package a été utilisé.

 [Installer chocolatey](https://chocolatey.org/)

### L'installation

Executer, en mode administrateur, dans votre powerShell, les lignes de commandes suivantes, afin d'installer les packages nécessaires au lancement de votre environnement de développement.

**IDE Eclipse 4.15** 

```
choco install eclipse
```
**OpenJDK 14.0.0 14.0.0** 

```
choco install openjdk14
```
**Maven 3.6.3** 

```
choco install maven
```
**Apache Tomcat 9.0.30** 

```
choco install tomcat
```
**MySQL (Community Server) 8.0.19**

```
choco install mysql
```
**MySQL Connector - Java 8.0.15**

```
choco install mysql-connector-java
```
**MySQL Workbench 8.0.19**

```
choco install mysql.workbench
```
**Node JS 13.12.0**

```
choco install nodejs
```
**Git 2.26.0**

```
choco install git
```
**TcpView 3.05**

```
choco install tcpview
```
**telnet (Install) 0.9.0**

```
choco install telnet
```
**Spring Tool Suite 3.9.6**

```
choco install springtoolsuite
```

**PLUGINS ECLIPSE**

- EGit
- Eclipse Tomcat Plugin 9.1.4
- Java 14 Support for Eclipse 2020-03
- Maven (Java EE) Integration for Eclipse WTP (Luna/Mars) 1.2.0
- Spring Tools 3 (standalone Edition) 3.9.12.RELEASE
- Spring Tools 3 Add-On for Spring Tools 4 3.9.12.RELEASE
- Spring Tools 4 (aka Spring Tool Suite 4) 4.6.0.RELEASE
- ResourceBundle Editor


*En cours d'édition End with an example of getting some data out of the system or using it for a little demo*

## Components

Les components Spring sont composés de :

1.Controller 


- Traite les requetes et reponses (Handles request/ response)
- Ne tiens pas compte de la logique Business (No business logic)
- Coordonne le dépot avec le service (Coordinate with service and repository)
- Sont annotés avec @Controller (Annoted with @Controller)
- Gère les exceptions et affiche le routage (Handles exceptions and view routing)


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


## SPRING MVC Pattern ModelViewControler

**Les controlleurs**

Les controller utilisent les annotations springs suivants:

**@Controller, @GetMapping, @ModelAttribute, @PostMapping**

*Le controlleur interprete et transforme les interactions de l'utilisateur pour les transmettres au model*

*Le controlleur accède à la logique métier*

*Le controlleur détermine le type de vue ou de réponse*

*Le controlleur interpréte les exceptions*

**Les Models**

Les models sont de simple POJO et sont utilisés dans les controllers à l'aide de l'annnotation 

**@ModelAttribute**



## Traduction (internalization)

Pour ajouter l'internationalization (I18) nous utilisons, 2 beans, une instance de LocalResolver dans le fichier de configuration (ici ConferenceConfig) se qui correspondant à la langue local (defaut) et une instance de LocalChangeInterceptor pour lui indiquer que cela est une traduction à l'aide du param: "lang".

Nous surchargeons la méthode addInterceptor de l'interface WebMvcConfigurer pour ajouter un intercepteur au cycle de vie Spring MVC.

Nous indiquerons dans le fichier messages.properties du dossier resources les valeurs de language par defaut, ici le francais, puis dans un autre fichier message_en.properties les traductions en Anglais (utilisation d'un plugin est bien utile).

Enfin, dans notre fichier jsp registration nous ajoutons la librairie:

	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

Puis nous injectons les valeurs.

Entouré d'un tag, exemple <title></title>

	<title><spring:message code="registration"></spring:message></title>

Ou bien dans un tag, par exemple input, dans ce cas nous passerons par une variable ici submitText :

	<spring:message code="save.changes" var="submitText"></spring:message>
				<td colspan="2"><input type="submit" value="${submitText}">





## Remarques sur la création de l'application

1 . Ajout d'une librairie Spring sur la page jsp Registration , pour nous permettre la mise een oeuvre d'un formulaire ==>> voir le tag de début de fichier registration.jsp
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


Le pattern View est configuré a l'aide de View Resolver ou bien à travers des Static Reources configuré à l'aide de l'implementation WebMvcConfigurer.

L'étude de l'aspect View a été pratiqué pour mettre en place I18 et les Interceptors sur les traductions.


	


### Bug fixes 
#### Server TOMCAT

Erreur 404 lors du démarrage TOMCAT

Cliquer sur propriete > General puis cliquer sur le bouton "Switch Location", celle-ci doit se mettre à jours.

Double-cliquer ensuite sur le server puis cocher dans la rubrique Server Locations sur la case > Use Tomcat installation (takes controle of Tomcat installation)

Votre server TOMCAT est maintenant operationnel à l'adresse URl: localhost:8080

#### ResourcesBundle

**ATTENTION à la signature (orthographe) du bean localeResolver()**

	@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver slr = new SessionLocaleResolver();
			slr.setDefaultLocale(Locale.FRANCE);
			return slr;
		}

#### Java JSP

Deprecié il faut etre en java 1.8 pour que cela fonctionne