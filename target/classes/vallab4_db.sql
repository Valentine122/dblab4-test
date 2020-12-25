CREATE SCHEMA IF NOT EXISTS vallab4db DEFAULT CHARACTER SET utf8 ;
USE vallab4db;

DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS vaccination;
DROP TABLE IF EXISTS Technic_info;
DROP TABLE IF EXISTS Technic_status;
DROP TABLE IF EXISTS Technic;
DROP TABLE IF EXISTS Bosch_service;

CREATE TABLE Bosch_service (
                               id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                               city VARCHAR(200) NOT NULL,
                               street VARCHAR(200) NOT NULL,
                               building_number INT NOT NULL)
    ENGINE = InnoDB;

CREATE TABLE Technic (
                         id INT NOT NULL AUTO_INCREMENT,
                         Bosch_service_id INT NOT NULL,
                         name VARCHAR(200) NOT NULL,
                         PRIMARY KEY (id, Bosch_service_id),
                         CONSTRAINT fk_Technic_Bosch_service1
                             FOREIGN KEY (Bosch_service_id)
                                 REFERENCES Bosch_service (id)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE worker (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(500) NOT NULL,
                        surname VARCHAR(500) NOT NULL,
                        date_of_employment DATE NOT NULL,
                        Technic_id INT NOT NULL,
                        Technic_Bosch_service_id INT NOT NULL,
                        status VARCHAR(20) NOT NULL,
                        CONSTRAINT fk_worker_Technic1
                            FOREIGN KEY (Technic_id , Technic_Bosch_service_id)
                                REFERENCES Technic (id , Bosch_service_id)
                                ON DELETE CASCADE
                                ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE payment (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         worker_id INT NOT NULL,
                         salary FLOAT NOT NULL,
                         amount_of_remuneration FLOAT NULL,
                         date_of_pay DATE NOT NULL,
                         CONSTRAINT fk_payment_worker1
                             FOREIGN KEY (worker_id)
                                 REFERENCES worker (id)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE Technic_status (
                                id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                Technic_id INT NOT NULL,
                                Technic_Bosch_service_id INT NOT NULL,
                                status VARCHAR(20) NOT NULL,
                                CONSTRAINT fk_Technic_status_Technic1
                                    FOREIGN KEY (Technic_id , Technic_Bosch_service_id)
                                        REFERENCES Technic (id , Bosch_service_id)
                                        ON DELETE CASCADE
                                        ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE vaccination (
                             id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             Technic_status_id INT NOT NULL,
                             name VARCHAR(100) NOT NULL,
                             date_of_vaccination DATE NOT NULL,
                             CONSTRAINT fk_vaccination_Technic_status1
                                 FOREIGN KEY (Technic_status_id)
                                     REFERENCES Technic_status (id)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE TABLE Technic_info (
                              Technic_status_id INT NOT NULL PRIMARY KEY,
                              Spare_parts VARCHAR(500) NULL,
                              info_phone_number VARCHAR(10) NULL,
                              CONSTRAINT fk_Technic_info_Technic_status1
                                  FOREIGN KEY (Technic_status_id)
                                      REFERENCES Technic_status (id)
                                      ON DELETE CASCADE
                                      ON UPDATE CASCADE)
    ENGINE = InnoDB;

CREATE INDEX index_Technic ON Technic (Bosch_service_id ASC);
CREATE INDEX index_worker ON worker (Technic_id ASC, Technic_Bosch_service_id ASC);
CREATE INDEX index_Technic_status ON  Technic_status (Technic_id ASC, Technic_Bosch_service_id ASC);

INSERT INTO Bosch_service (id, city, street, building_number) VALUES
(1, 'Lviv', 'Городоцька', 23),
(2, 'Ivano-Frankivsk', 'П. Куліша', 48),
(3, 'Lviv', 'І. Франка', 10),
(4, 'Kyev', 'Личаківська', 41),
(5, 'Donbass', 'Червоної Калини', 51),
(6, 'Lviv', 'Сихівська', 40),
(7, 'Lviv', 'Наукова', 34),
(8, 'Lviv', 'Кульпарківська', 103),
(9, 'Kyev', 'Широка', 44),
(10, 'Kyev', 'Сяйво', 28);

INSERT INTO Technic (id, Bosch_service_id, name) VALUES
(1, 1, 'BOSCH BCH6ZOOO'),
(2, 2, 'BOSCH KGN 56 LBF0N'),
(3, 3, 'BOSCH MES3500'),
(4, 4, 'BOSCH PHD1151'),
(5, 5, 'BOSCH TAT 3A011'),
(6, 6, 'BOSCH TDA 702421E'),
(7, 7, 'BOSCH TWK 7203'),
(8, 8, 'BOSCH TAT 343011'),
(9, 9, 'BOSCH TDA 705421E'),
(10, 10, 'BOSCH TWK 72123');

INSERT INTO worker (id, name, surname, date_of_employment, Technic_id, Technic_Bosch_service_id, status) VALUES
(1, 'Анастасія', 'Іванчук', '2001-11-11', 1, 1, 'FIRED'),
(2, 'Надія', 'Тарасенко', '2010-10-10', 2, 2, 'FIRED'),
(3, 'Поліна', 'Шевченко', '2015-09-01', 3, 3, 'FIRED'),
(4, 'Ангеліна', 'Кравчук', '2010-12-12', 4, 4, 'FIRED'),
(5, 'Аліна', 'Янукович', '2002-05-05', 5, 5, 'WORKING'),
(6, 'Валерія', 'Віденська', '2007-07-07', 6, 6, 'WORKING'),
(7, 'Софія', 'Домбровська', '2009-09-09', 7, 7, 'WORKING'),
(8, 'Кіра', 'Франко', '2001-09-11', 8, 8, 'WORKING'),
(9, 'Марія', 'Чуприк', '2016-09-16',  9, 9, 'WORKING'),
(10, 'Ксенія', 'Верес', '2015-03-01', 10, 10, 'ON VACATION');

INSERT INTO payment (id, worker_id, salary, amount_of_remuneration, date_of_pay) VALUES
(1, 5, 4500, 500, '2020-10-05'),
(2, 6, 5000, NULL, '2020-10-05'),
(3, 7, 4200, NULL, '2020-10-05'),
(4, 8, 3800, 1000, '2020-10-05'),
(5, 9, 5500, NULL, '2020-10-05');

INSERT INTO Technic_status (id, Technic_id, Technic_Bosch_service_id, status) VALUES
(1, 1, 1, 'working'),
(2, 2, 2, 'done'),
(3, 3, 3, 'working'),
(4, 4, 4, 'done'),
(5, 5, 5, 'working'),
(6, 6, 6, 'done'),
(7,  7, 7, 'working'),
(8,  8, 8, 'waiting'),
(9,  9, 9, 'waiting'),
(10, 10, 10, 'working');

INSERT INTO vaccination (id, Technic_status_id, name, date_of_vaccination) VALUES
(1, 3, 'Столбняк', '2017-09-21'),
(2, 6, 'Столбняк', '2017-09-21'),
(3, 7, 'Тупізм', '2018-09-21'),
(4, 8, 'Тупізм', '2018-09-21'),
(5, 9, 'Столбняк', '2017-09-21');

INSERT INTO Technic_info (Technic_status_id, Spare_parts, info_phone_number) VALUES
(3,  'cord','0671234567'),
(6,  'sensor screen', '0980987654'),
(7,  'hose', '0661272047'),
(8,  'rubberized legs', '0981475964'),
(9,  'round neck', '0670492740');