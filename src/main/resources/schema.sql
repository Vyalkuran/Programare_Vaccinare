ALTER TABLE AUTORITATI DROP CONSTRAINT AUTHORITIES_FK1;
ALTER TABLE AUTORITATI DROP CONSTRAINT AUTHORITIES_UNIQUE;
ALTER TABLE BENEFICIARI DROP CONSTRAINT BENEFICIARI_CI_UNIQUE;
ALTER TABLE BENEFICIARI DROP CONSTRAINT BENEFICIARI_FK1;
ALTER TABLE BENEFICIARI DROP CONSTRAINT BENEFICIARI_FK2;
ALTER TABLE BENEFICIARI DROP CONSTRAINT BENEFICIARI_FK3;

DROP TABLE IF EXISTS UTILIZATORI;
DROP TABLE IF EXISTS AUTORITATI;
DROP TABLE IF EXISTS BENEFICIARI;
DROP TABLE IF EXISTS JUDETE;
DROP TABLE IF EXISTS ORASE;
DROP TABLE IF EXISTS GRUPE_RISC;

CREATE TABLE UTILIZATORI(
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(250) NOT NULL UNIQUE,
    parola VARCHAR(250) NOT NULL
);

CREATE TABLE AUTORITATI (
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilizator_id INT NOT NULL,
    autoritate VARCHAR(250) NOT NULL
);

CREATE TABLE BENEFICIARI (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nume VARCHAR(250) NOT NULL,
    prenume VARCHAR(250) NOT NULL,
    cnp VARCHAR(13) NOT NULL UNIQUE,
    serie VARCHAR(2) NOT NULL,
    numar_serie VARCHAR(6) NOT NULL,
    id_oras INT NOT NULL,
    email VARCHAR(250) UNIQUE,
    telefon VARCHAR(250) UNIQUE,
    id_grupa_risc INT NOT NULL,
    id_utilizator INT NOT NULL
);

CREATE TABLE JUDETE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    denumire_judet varchar(250) NOT NULL
);

CREATE TABLE ORASE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    denumire_oras varchar(250) NOT NULL,
    id_judet INT NOT NULL
);

CREATE TABLE GRUPE_RISC (
    id INT AUTO_INCREMENT PRIMARY KEY,
    denumire_grupa_risc varchar(250) NOT NULL
);

ALTER TABLE AUTORITATI ADD CONSTRAINT AUTHORITIES_UNIQUE UNIQUE (utilizator_id, autoritate);
ALTER TABLE AUTORITATI ADD CONSTRAINT AUTHORITIES_FK1 FOREIGN KEY (utilizator_id) REFERENCES UTILIZATORI (id);

ALTER TABLE BENEFICIARI ADD CONSTRAINT BENEFICIARI_CI_UNIQUE UNIQUE (serie, numar_serie);
ALTER TABLE BENEFICIARI ADD CONSTRAINT BENEFICIARI_FK1 FOREIGN KEY (id_oras) REFERENCES ORASE (id);
ALTER TABLE BENEFICIARI ADD CONSTRAINT BENEFICIARI_FK2 FOREIGN KEY (id_grupa_risc) REFERENCES GRUPE_RISC (id);
ALTER TABLE BENEFICIARI ADD CONSTRAINT BENEFICIARI_FK3 FOREIGN KEY (id_utilizator) references UTILIZATORI (id);