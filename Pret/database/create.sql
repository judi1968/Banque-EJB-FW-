-- Création de la base de données
CREATE DATABASE test_dotnet;
\c test_dotnet

-- Création de la table personne
CREATE TABLE personne (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    datenaissance DATE NOT NULL
);

-- Insertion des données
INSERT INTO personne (nom, prenom, datenaissance) VALUES
('rakoto', 'jean', '1990-05-10'),
('rabe', 'marie', '1992-08-20'),
('andriam', 'luc', '1985-12-15'),
('rasoa', 'sofia', '2000-03-05'),
('malala', 'tiana', '1995-07-22');
