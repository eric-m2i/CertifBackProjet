

░█████╗░███╗░░██╗███████╗░█████╗░██╗░░██╗░█████╗░████████╗
██╔══██╗████╗░██║██╔════╝██╔══██╗██║░░██║██╔══██╗╚══██╔══╝
██║░░██║██╔██╗██║█████╗░░██║░░╚═╝███████║███████║░░░██║░░░
██║░░██║██║╚████║██╔══╝░░██║░░██╗██╔══██║██╔══██║░░░██║░░░
╚█████╔╝██║░╚███║███████╗╚█████╔╝██║░░██║██║░░██║░░░██║░░░
░╚════╝░╚═╝░░╚══╝╚══════╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░

# Sommaire

# Sommaire

1. [Projet de Chat en Ligne avec Spring et Angular](#projet-de-chat-en-ligne-avec-spring-et-angular)

2. [Fonctionnalités](#fonctionnalités)
   - [Canaux](#canaux)
   - [Messages](#messages)

3. [Technologies Utilisées](#technologies-utilisées)

4. [Structure du Projet](#structure-du-projet)

5. [API Reference](#api-reference)
   - [Récupérer la liste de tous les canaux](#1-récupérer-la-liste-de-tous-les-canaux)
   - [Récupérer les détails d'un seul canal](#2-récupérer-les-détails-dun-seul-canal)
   - [Créer un nouveau canal](#3-créer-un-nouveau-canal)
   - [Remplacer un canal existant](#4-remplacer-un-canal-existant)
   - [Remplacement partiel d'un canal existant](#5-remplacement-partiel-dun-canal-existant)
   - [Supprimer un canal existant](#6-supprimer-un-canal-existant)
   - [Récupérer la liste de tous les utilisateurs](#7-récupérer-la-liste-de-tous-les-utilisateurs)
   - [Récupérer les détails d'un utilisateur](#8-récupérer-les-détails-dun-utilisateur)
   - [Créer un nouvel utilisateur](#9-créer-un-nouvel-utilisateur)
   - [Récupérer la liste de tous les messages dans un canal](#10-récupérer-la-liste-de-tous-les-messages-dans-un-canal)
   - [Ajouter un nouveau message dans un canal](#11-ajouter-un-nouveau-message-dans-un-canal)

6. [Comment Exécuter le Projet Localement](#comment-exécuter-le-projet-localement)

7. [Documentation et Resources](#documentation-et-resources)

8. [Auteurs](#auteurs)

9. [Licence](#licence)
# Projet de Chat en Ligne avec Spring et Angular

Bienvenue dans le projet de chat en ligne basé sur Spring. Cette application de chat permet aux utilisateurs de créer des canaux, d'envoyer des messages et d'interagir avec d'autres utilisateurs de manière simple et intuitive.

## Fonctionnalités

### Canaux

- **Création de Canal :** Les utilisateurs peuvent créer de nouveaux canaux pour organiser les discussions.
- **Suppression de Canal :** Les utilisateurs peuvent supprimer des canaux existants.
- **Liste des Canaux :** Affichage de la liste des canaux disponibles.
- **Liste des Messages :** Affichage de tous les messages dans un canal spécifique.
- **Renommage de Canal :** Les utilisateurs peuvent renommer les canaux existants.

### Messages

- **Ajout de Message :** Les utilisateurs peuvent envoyer des messages dans les canaux.

## Technologies Utilisées

- **Spring Boot :** Utilisé comme framework principal pour le backend, offrant une gestion simplifiée du développement.
- **Spring Data JPA :** Utilisé pour la gestion de la persistance des données, facilitant les opérations avec la base de données.
- **Maven :** Utilisé comme système de gestion de projets, Maven simplifie la configuration et la gestion des dépendances, garantissant une structure de projet cohérente.
- **Java 17 :** Adopté comme version principale du langage de programmation, Java 17 offre des fonctionnalités modernes et des améliorations de performance, contribuant à la robustesse et à la sécurité de l'application.
- **Spring Service, Repository :** Utilisés pour la mise en œuvre des couches de services métier et d'accès aux données, ces composants de Spring facilitent la séparation des préoccupations et favorisent la maintenabilité du code.
- **Angular :** Moteur de template utilisé pour la génération des pages HTML, assurant une expérience utilisateur dynamique.
- **PostgreSQL :** Base de données relationnelle intégrée pour le développement, assurant la stabilité et la performance.

## Structure du Projet

Le projet est organisé en packages de la manière suivante :

- `com.projet.certifback.dao`: Contient les entités JPA (Java Persistence API) représentant les données.
- `com.projet.certifback.service`: Contient la logique métier de l'application.
- `com.projet.certifback.dao`: Contient les interfaces de repository pour accéder aux données.
- `com.projet.certifback.controller`

## API Reference

#### 1. Récupérer la liste de tous les canaux

```http
GET /api/channels
```

#### 2. Récupérer les détails d'un seul canal

```http
GET /api/channels/{channelId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `channelId` | `Long` | **Obligatoire**. Identifiant du canal à récupérer |

#### 3. Créer un nouveau canal

```http
POST /api/channels
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ChannelPostDTO` | `ChannelPostDTO` | **Obligatoire**. Données pour créer le canal |

#### 4. Remplacer un canal existant

```http
PUT /api/channels/{channelId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ChannelPostDTO` | `ChannelPostDTO` | **Obligatoire**. Données pour remplacer le canal |
| `channelId` | `Long` | **Obligatoire**. Identifiant du canal à remplacer |

#### 5. Remplacement partiel d'un canal existant

```http
PATCH /api/channels/{channelId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ChannelPostDTO` | `ChannelPostDTO` | **Obligatoire**. Données pour remplacer partiellement le canal |
| `channelId` | `Long` | **Obligatoire**. Identifiant du canal à remplacer partiellement |

#### 6. Supprimer un canal existant

```http
DELETE /api/channels/{channelId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `channelId` | `Long` | **Obligatoire**. Identifiant du canal à supprimer |

#### 7. Récupérer la liste de tous les utilisateur

```http
GET /api/users
```

#### 8. Récupérer la liste d'un utilisateur

```http
GET /api/users/{userId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `Long` | **Obligatoire**.  Identifiant du l'utilisateur |

#### 9. Création d'un utilisateur

```http
POST /api/users
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `UserPostDTO` | `UserPostDTO` | **Obligatoire**.  Données pour créer l'utilisateur |

#### 10. Récupérer la liste de tous les messages dans un canal

```http
GET /api/channels/{channelId}/messages
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `channelId` | `Long` | **Obligatoire**.  Identifiant du canal |

#### 11. Ajouter un nouveau message dans un canal

```http
POST {channelId}/{userId}/messages
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `channelId` | `Long` | **Obligatoire**.  Identifiant du canal à utiliser |
| `userId` | `Long` | **Obligatoire**.  Identifiant du l'utilisateur à utiliser |
| `messagePostDTO` | `messagePostDTO` | **Obligatoire**.  Données pour créer le message |

## Comment Exécuter le Projet Localement

1. Clonez le dépôt : `git clone https://github.com/vincentdevweb/Back-Projet`
2. Accédez au répertoire du projet : `cd Back-Projet`
3. Exécutez l'application : `./mvnw spring-boot:run`
4. Ouvrez votre navigateur à l'adresse : `http://localhost:8080`

## Documentation et Resources

Cette section fournit des informations détaillées sur l'utilisation du projet, y compris des guides d'installation, des exemples d'utilisation, et d'autres ressources utiles. Veuillez consulter la documentation pour obtenir des instructions complètes sur la configuration, l'exécution et l'exploitation du projet.

### Configuration Application

Le fichier de configuration `application.properties` se trouve dans le répertoire `./src/main/resources` et peut nécessiter des modifications pour adapter l'application à votre environnement. Assurez-vous de vérifier et de mettre à jour les paramètres appropriés tels que les informations de base de données, les ports, etc...

### Fichiers Supplémentaires

Certains fichiers importants sont disponibles dans le répertoire `./src/main/resources/personal` :

- `bdd.sql` : Le script SQL de la base de données utilisé par le projet.
- `uml.plantuml` : Le fichier UML utilisé pour modéliser la structure du projet.
- `postman_collection.json` : Le fichier Postman Collection qui contient des exemples de requêtes pour tester l'API.

### Documentation Technique

La dépendance Swagger a été intégrée pour faciliter l'accès à la documentation technique de l'API. Vous pouvez consulter la documentation en accédant à l'adresse suivante une fois L'API lancer: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)


## Auteurs

- Mat [GitHub/matstrza](https://github.com/matstrza/)
- Vincent [GitHub/vincentdevweb](https://github.com/vincentdevweb/)
- Eric [GitHub/eric-m2i](https://github.com/eric-m2i/)

## Licence

Ce projet est sous licence open source [MIT](LICENSE), ce qui signifie que vous êtes libre de l'utiliser, le modifier et le distribuer selon les termes de cette licence.


