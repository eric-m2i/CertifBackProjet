DROP TABLE IF EXISTS Messages;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Channels;

CREATE TABLE Users (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(30) NOT NULL,
    prenom VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    pseudo VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Channels (
    id BIGSERIAL PRIMARY KEY,
    channel_name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255)
);

CREATE TABLE Messages (
    id BIGSERIAL PRIMARY KEY,
    contenu_message TEXT NOT NULL,
    date_heure TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL,
    channel_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (channel_id) REFERENCES Channels(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO CHANNELS (channel_name, description) VALUES ('GENERAL', 'Canal General ');
