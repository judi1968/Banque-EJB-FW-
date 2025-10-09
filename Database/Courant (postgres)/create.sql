CREATE DATABASE banque_courant;
\c banque_courant
CREATE TABLE mouvement_courant(
   id_mouvement SERIAL,
   id_personne INTEGER NOT NULL,
   montant_entrer DOUBLE PRECISION   NOT NULL,
   montant_sortie DOUBLE PRECISION   NOT NULL,
   date_mouvement TIMESTAMP NOT NULL,
   PRIMARY KEY(id_mouvement)
);
