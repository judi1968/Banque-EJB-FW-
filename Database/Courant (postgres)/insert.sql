INSERT INTO direction (libelle, niveau) VALUES 
('Direction Courant', 1),
('Direction Dépôt', 1),
('Direction Prêt', 1);


INSERT INTO utilisateur (login, mdp, role, id_direction_fk) VALUES
('courant_insert_user', '1234', 2, 1), 
('courant_validation_user', '1234', 4, 1),    
('pret_insert_user', '1234', 4, 2); 


INSERT INTO action_role (nom_table, action, role) VALUES
('mouvement_courant_insert', 1, 2),
('mouvement_courant_valide', 2, 4);

