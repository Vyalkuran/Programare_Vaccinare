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

INSERT INTO VACCINURI (denumire_vaccin, perioada_rapel) values ('Astra Zeneca', 56),
                                                               ('Pfizer', 21),
                                                               ('Moderna', 28);

INSERT INTO CENTRE_VACCINARE (denumire_centru_vaccinare, id_vaccin, id_oras) values ('Pavilion 1', 2, 1),
                                                                                    ('Pavilion 2', 3, 1),
                                                                                    ('Casa de cultura', 1, 2),
                                                                                    ('Stadion Local', 2, 3),
                                                                                    ('Centrul Medical Judetean', 3, 4),
                                                                                    ('Casa de cultura', 2, 5),
                                                                                    ('Pavilion', 1, 6),
                                                                                    ('Steaua de Munte', 2, 7),
                                                                                    ('Sediul CIUMA NEAGRA', 1, 8);