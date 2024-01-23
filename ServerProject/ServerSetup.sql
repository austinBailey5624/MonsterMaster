DROP DATABASE IF EXISTS monsterMaster;
CREATE DATABASE monsterMaster;
USE monsterMaster;

DROP TABLE IF EXISTS primary_element;

CREATE TABLE primary_element(
	primary_element_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    primaryColor VARCHAR(50)
    );
    
INSERT INTO primary_element(primary_element_id, name, primaryColor)
VALUES
	(0,'Fire', 'Red'),   
    (1,'Water', 'Blue'),
    (2,'Earth', 'Green'),
    (3,'Air', 'Yellow'),
    (4,'Light', 'White'),
    (5,'Dark', 'Black'),
    (6,'Neutral', 'Grey'),
    (7,'Physical', 'Brown'),
    (8,'Magical', 'Purple');
    
--    SHOW COLUMNS FROM primary_element;
--  SELECT * from primary_element;

CREATE TABLE secondary_element(
	secondary_element_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    first_element_id INT NOT NULL,
    FOREIGN KEY(first_element_id) REFERENCES primary_element(primary_element_id),
    second_element_id INT NOT NULL,
    FOREIGN KEY(second_element_id) REFERENCES primary_element(primary_element_id)
    );
    
INSERT INTO secondary_element(secondary_element_id, name, first_element_id, second_element_id)
VALUES
	(0,'Pyro',0,0),
    (1,'Lava',0,1),
    (2,'Dino',0,2),
    (3,'Sand',0,3),
    (4,'Justice',0,4),
    (5,'Vengeance',0,5),
    (10,'Steam',1,0),
    (11,'Aqua',1,1),
    (12,'Amphibious',1,2),
    (13,'Weather',1,3),
    (14,'Ice',1,4),
    (15,'Deep',1,5),
    (20,'Fey',2,0),
    (21,'Plant',2,1),
    (22,'Terra',2,2),
    (23,'Pegasus',2,3),
    (24,'Compassion',2,4),
    (25,'Rotten',2,5),
    (30,'Phoenix',3,0),
    (31,'Seabreeze',3,1),
    (32,'Bird',3,2),
    (33,'Aero',3,3),
    (34,'Cocka',3,4),
    (35,'NightWing',3,5),
    (40,'Solar',4,0),
    (41,'Lunar',4,1),
    (42,'Guardian',4,2),
    (43,'Angel',4,3),
    (44,'Luxor',4,4),
    (45,'Redemption',4,5),
    (50,'Demon',5,0),
    (51,'Poison',5,1),
    (52,'Undead',5,2),
    (53,'Storm',5,3),
    (54,'Betrayer',5,4),
    (55,'Umbral',5,5);
--     
--  Select secondary_element_id, name FROM secondary_element;
--  select Count(*) from secondary_element;
 
 CREATE TABLE deity(
  deity_id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  element_id INT NOT NULL,
  FOREIGN KEY(element_id) REFERENCES primary_element(primary_element_id),
  entropic_nature ENUM('Lawful','Neutral','Chaotic')
  );
  
  INSERT INTO deity(deity_id, name, element_id, entropic_nature)
  VALUES
	(0, 'Anu', 4, 'Lawful'),
    (1, 'Velhu', 1, 'Lawful'),
    (2, 'Sid', 2, 'Lawful'),
    (3, 'Gabriel', 3, 'Lawful'),
    (4, 'Ahros', 0, 'Lawful'),
    (5, 'Pythion', 5, 'Lawful'),
    (10, 'Bennu', 4, 'Neutral'),
    (11, 'Neptune', 1, 'Neutral'),
    (12, 'Gaia', 2, 'Neutral'),
    (13, 'Bacchus', 3, 'Neutral'),
    (14, 'Mars', 0, 'Neutral'),
    (15, 'Thanatos', 5, 'Neutral'),
    (20, 'Acheron', 4, 'Chaotic'),
    (21, 'Illian', 1, 'Chaotic'),
    (22, 'Webspinner', 2, 'Chaotic'),
    (23, 'Muir', 3, 'Chaotic'),
    (24, 'Malacathe', 4, 'Chaotic'),
    (25, 'Enemy', 5, 'Chaotic');
    
    Select * from deity;
