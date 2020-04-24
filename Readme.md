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


### Maven Dependency

* spring-boot-starter-web
* spring-boot-starter-tomcat
* thymeleaf-spring5
* spring-boot-starter-test
* hibernate-validator


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

*Le controlleur interprete et transforme les interactions de l'utilisateur pour utiliser les models*

*Le controlleur accède à la logique métier*

*Le controlleur détermine le type de vue ou de réponse*

*Le controlleur interpréte les exceptions*

**Les Models**

Les models sont de simple POJO et sont utilisés dans les controllers à l'aide de l'annnotation 

**@ModelAttribute**

## SPRING PRG Pattern Post-Redirect-Get

C'est une technique permettant lors d'un post de faire une redirection de type get automatiquement.
Dans notre exemple cela a pour effet de clear le formulaire lors d'un post

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


## Validation de la configuration

Se fait à l'aide de la dependance hibernate-validator.


Nous devons dans le package controller, dans les parametres passés aux méthodes nécessitant une validation (ex:PostMapping) :

* ajouter @Valid 
* lier (Binding) le resultat
* ajouter une condition si erreur du resultat

	if(result.hasErrors())

* Coder un tag form:error

			<form:errors path="*" cssClass="errorblock" element="div"/>
	
path="*" permet de voir tous les messages d'erreurs

## Thymeleaf

Thymeleaf est un moteur de template, sous licence Apache 2.0, écrit en Java pouvant générer du XML/XHTML/HTML5. Thymeleaf peut être utilisé dans un environnement web ou non web. Son but principal est d'être utilisé dans un environnement web pour la génération de vue pour les applications web basées sur le modèle MVC.

Pour mettre en place thymeleaf il est nécessaire de créer les beans suivants dans le fichier de configuration:

* @Bean SpringResourceTemplateResolver
* @Bean SpringTemplateEngine
* @Bean ViewResolver

**ATTENTION**

Soit nous utilisons Thymeleaf, soit nous utilisons les pages .jsp.
Pour utiliser les deux .... on verra ça plus tard, mais n'est pas recommandé .


**JOUER AVEC LES setOrder du fichier de configuration POUR PASSER DU MODE JSP AU MODE THYMELEAF**

Pour tester thymeleaf appeler l'url : http://localhost:8080/SpringMVCConference/thyme


## Remarques sur la création de l'application

Ajout d'une librairie Spring sur la page jsp Registration , pour nous permettre la mise een oeuvre d'un formulaire ==>> voir le tag de début de fichier registration.jsp
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


**Le pattern View (MVC)** est configuré a l'aide de View Resolver ou bien à travers des Static Reources configuré à l'aide de l'implementation WebMvcConfigurer.

L'étude de l'aspect View a été pratiqué pour mettre en place I18 et les Interceptors sur les traductions.


**setOrder des differents viewResolver**

Doivent spécifier l'ordre dans lequel ce résolveur de vue sera interrogé.

Les applications Web Spring peuvent avoir plusieurs résolveurs (**InternalResourceViewResolver ou ViewResolver**) de vues configurés, et cette propriété d'ordre a établi l'ordre dans lequel ils seront interrogés pour la résolution des vues.


**@NotEmpty**

Permet sur un attribut à l'obligé d'etre non null (pour un string), c'est un  type de validation


### Bug fixes 
#### Server TOMCAT

Erreur 404 lors du démarrage TOMCAT

Cliquer sur propriete > General puis cliquer sur le bouton "Switch Location", celle-ci doit se mettre à jours.

Double-cliquer ensuite sur le server puis cocher dans la rubrique Server Locations sur la case > Use Tomcat installation (takes controle of Tomcat installation)

Votre server TOMCAT est maintenant operationnel à l'adresse URl: localhost:8080

#### ResourcesBundle

**ATTENTION à la signature (orthographe) du bean localeResolver()**, ne pas oublier les "e"

	@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver slr = new SessionLocaleResolver();
			slr.setDefaultLocale(Locale.FRANCE);
			return slr;
		}

#### Java JSP

Deprecié il faut etre en java 1.8 pour que cela fonctionne