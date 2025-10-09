CREATE DATABASE banque_pret;
\c banque_pret;
CREATE TABLE mouvement_pret(
   id_mouvement SERIAL,
   id_personne INTEGER NOT NULL,
   montant_entrer DOUBLE PRECISION NOT NULL,
   montant_sortie DOUBLE PRECISION NOT NULL,
   date_mouvement TIMESTAMP NOT NULL,
   PRIMARY KEY(id_mouvement)
);

CREATE TABLE parametre_prendre(
   id SERIAL,
   pourcentage DOUBLE PRECISION NOT NULL,
   nb_jour INTEGER,
   date_parametre TIMESTAMP NOT NULL,
   PRIMARY KEY(id)
);
