INSERT INTO note (id, title, content, author, important) VALUES (1,'Compra de mañana','Hay que comprar arroz y pollo','0374bd29-7f2a-46dc-9546-b7558390b902',true);
INSERT INTO note (id, title, content, author, important) VALUES (2,'Recoger la habitación','Hay que recoger la habitacion','0374bd29-7f2a-46dc-9546-b7558390b902',true);
INSERT INTO note (id, title, content, author, important) VALUES (3,'Compra de la TV','Hay que comprar una TV Smart nueva','54447d3f-4606-4cea-b82e-f4d5634e44c8',true);
INSERT INTO note (id, title, content, author, important) VALUES (4,'Reservar entrada','Reservar entrada concierto','54447d3f-4606-4cea-b82e-f4d5634e44c8',true);

INSERT INTO note_tags (note_id, tags)VALUES (1, 'Comida');
INSERT INTO note_tags (note_id, tags)VALUES (1, 'Compra');
INSERT INTO note_tags (note_id, tags)VALUES (2, 'Recoger');
INSERT INTO note_tags (note_id, tags)VALUES (2, 'Casa');
INSERT INTO note_tags (note_id, tags)VALUES (3, 'Compra');
INSERT INTO note_tags (note_id, tags)VALUES (4, 'Evento');
INSERT INTO note_tags (note_id, tags)VALUES (4, 'Reserva');