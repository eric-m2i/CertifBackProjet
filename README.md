

░█████╗░███╗░░██╗███████╗░█████╗░██╗░░██╗░█████╗░████████╗
██╔══██╗████╗░██║██╔════╝██╔══██╗██║░░██║██╔══██╗╚══██╔══╝
██║░░██║██╔██╗██║█████╗░░██║░░╚═╝███████║███████║░░░██║░░░
██║░░██║██║╚████║██╔══╝░░██║░░██╗██╔══██║██╔══██║░░░██║░░░
╚█████╔╝██║░╚███║███████╗╚█████╔╝██║░░██║██║░░██║░░░██║░░░
░╚════╝░╚═╝░░╚══╝╚══════╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░

# Sommaire

1. [Projet de Chat en Ligne avec Spring et Angular](#projet-de-chat-en-ligne-avec-spring-et-angular)

2. [Fonctionnalités](#fonctionnalités)
   - [Canaux](#canaux)
   - [Messages](#messages)

3. [Technologies Utilisées](#technologies-utilisées)

4. [Structure du Projet](#structure-du-projet)

5. [API Reference](#api-reference)
   - [Récupérer la liste de tous les canaux](#1-récupérer-la-liste-de-tous-les-canaux)
   - [Créer un nouveau canal](#2-créer-un-nouveau-canal)
   - [Supprimer un canal existant](#3-supprimer-un-canal-existant)
   - [Récupérer la liste de tous les messages dans un canal](#4-récupérer-la-liste-de-tous-les-messages-dans-un-canal)
   - [Ajouter un nouveau message dans un canal](#5-ajouter-un-nouveau-message-dans-un-canal)

6. [Comment Exécuter le Projet Localement](#comment-exécuter-le-projet-localement)

7. [Auteurs](#auteurs)

8. [Licence](#licence)


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

#### 2. Récupérer la liste de tous les canaux

```http
POST /api/channels
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `channelName` | `String` | **Required**. Nom du canal à créer |

#### 3. Supprimer un canal existant

```http
DELETE /api/channels/{channelId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `channelId` | `Long` | **Required**. Identifiant du canal à supprimer |

#### 4. Récupérer la liste de tous les messages dans un canal

```http
GET /api/channels/{channelId}/messages
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `channelId` | `Long` | **Required**.  Identifiant du canal|

#### 5. Ajouter un nouveau message dans un canal

```http
POST /api/channels/{channelId}/messages
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `content` | `String` | **Required**.  Contenu du message|

## Comment Exécuter le Projet Localement

1. Clonez le dépôt : `git clone https://github.com/vincentdevweb/Back-Projet`
2. Accédez au répertoire du projet : `cd Back-Projet`
3. Exécutez l'application : `./mvnw spring-boot:run`
4. Ouvrez votre navigateur à l'adresse : `http://localhost:8080`

## Auteurs

- Mat [GitHub/matstrza](https://github.com/matstrza/)
- Vincent [GitHub/vincentdevweb](https://github.com/vincentdevweb/)
- Eric [GitHub/eric-m2i](https://github.com/eric-m2i/)

## Licence

Ce projet est sous licence open source [MIT](LICENSE), ce qui signifie que vous êtes libre de l'utiliser, le modifier et le distribuer selon les termes de cette licence.


