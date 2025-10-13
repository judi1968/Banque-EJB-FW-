-- montant actuelle pour chaque personne;
CREATE OR REPLACE VIEW v_montant_personne AS
SELECT 
    id_personne,
    (SUM(montant_entrer) - SUM(montant_sortie)) AS montant_actuelle
FROM 
    mouvement_pret
GROUP BY id_personne;