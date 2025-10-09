CREATE DATABASE banque_depot;
USE banque_depot;
CREATE TABLE mouvement_depot(
   id_mouvement INT AUTO_INCREMENT,
   id_personne INT NOT NULL,
   montant_entrer DECIMAL(15,5)   NOT NULL,
   montant_sortie DECIMAL(15,5)   NOT NULL,
   date_mouvement DATETIME NOT NULL,
   PRIMARY KEY(id_mouvement)
);

CREATE TABLE parametre_augmentation(
   id INT AUTO_INCREMENT,
   pourcentage DECIMAL(15,5)   NOT NULL,
   nb_jour INT,
   date_parametre DATETIME NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE parametre_pas_pris_argent(
   id INT AUTO_INCREMENT,
   nb_jour INT NOT NULL,
   date_parametre DATETIME NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE parametre_min_argent_touche(
   id INT AUTO_INCREMENT,
   pourcentage DECIMAL(15,5)   NOT NULL,
   date_parametre DATETIME NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE parametre_prendre(
   id INT AUTO_INCREMENT,
   pourcentage DECIMAL(15,5)   NOT NULL,
   nb_jour INT,
   date_parametre DATETIME NOT NULL,
   PRIMARY KEY(id)
);
