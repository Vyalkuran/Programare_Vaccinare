INSERT INTO UTILIZATORI (email, parola) VALUES ('alexsebastian2006@yahoo.com', 'Vaccinnare80$'),
                                               ('seinescuraluca@gmail.com', 'Pfizer$20');

INSERT INTO AUTORITATI (utilizator_id, autoritate) values (1, 'UTILIZATOR_CREAT');

INSERT INTO JUDETE (denumire_judet) values ('CONSTANTA'),
                                           ('IASI'),
                                           ('CLUJ');

INSERT INTO ORASE (denumire_oras, id_judet) values ('Constanta', 1),
                                                   ('Eforie Nord', 1),
                                                   ('Ovidiu', 1),
                                                   ('Iasi', 2),
                                                   ('Pascani', 2),
                                                   ('Targu Frumos', 2),
                                                   ('Cluj-Napoca', 3),
                                                   ('Turda', 3);

INSERT INTO GRUPE_RISC (denumire_grupa_risc) values ('Grupa 1'),
                                               ('Grupa 2'),
                                               ('Grupa 3');