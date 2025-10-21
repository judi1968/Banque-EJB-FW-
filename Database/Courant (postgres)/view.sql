-- montant actuelle pour chaque personne;

CREATE OR REPLACE VIEW v_mouvement_courant_non_valide AS
SELECT
    * 
FROM 
    mouvement_courant 
WHERE id_mouvement NOT IN (SELECT id_mouvement_courant_fk FROM mouvement_courant_valide );



CREATE OR REPLACE VIEW v_mouvement_courant_valide AS
SELECT
    mc.* 
FROM 
    mouvement_courant mc
JOIN mouvement_courant_valide mcv ON mc.id_mouvement = mcv.id_mouvement_courant_fk


CREATE OR REPLACE VIEW v_montant_personne AS
SELECT 
    id_personne,
    (SUM(montant_entrer) - SUM(montant_sortie)) AS montant_actuelle
FROM 
    v_mouvement_courant_valide
GROUP BY id_personne;

