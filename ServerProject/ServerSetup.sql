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
    
    
    CREATE TABLE faction(
		faction_id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(50)
        );
        
	INSERT INTO faction(name)
    VALUES
		('Outdoorsmen'),
        ('Fighters Guild'),
        ('Church'),
        ('Mages'),
        ('Merchants'),
        ('Dwarves'),
        ('Missionaries'),
        ('Nobility'),
        ('Royalty'),
        ('Librarians'),
        ('Necromancers'),
        ('Astrologers'),
        ('Fox\'s Guild'),
        ('Gentlemen Thieves'),
        ('Bankers'),
        ('Investors'),
        ('Redeemers'),
        ('Gaia Worshippers'),
        ('Justicars'),
        ('Magistiars'),
        ('Sidden Monks');
    
    CREATE TABLE adventure(
     adventure_id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(50) NOT NULL,
     requirements_id INT,
     faction_id INT
     );
     
     INSERT INTO adventure(name)
     VALUES
		('Initial');
        
CREATE TABLE scenario(
	scenario_id INT PRIMARY KEY AUTO_INCREMENT, -- the unique key identifying the scenario
    adventure_id INT NOT NULL, -- the adventure to which the scenario belongs
    FOREIGN KEY(adventure_id) REFERENCES adventure(adventure_id),
    name VARCHAR(50)
    );
    
INSERT INTO scenario(adventure_id, name)
VALUES
	(1,'Initial, light or darkness'),
    (1,'Light:Forest, Fire or Water'),
    (1,'Darkness:Forest, Fire or Water'),
    (1,'Fire:Forest, Earth or Air'),
    (1,'Water:Forest, Earth or Air'),
    (1,'Forest Demon Bird'),
    (1,'Forest Demon Critter'),
    (1,'Forest Deep Pool'),
    (1,'Forest Deep Pool2'),
    (1,'Forgotten Shrine'),
    (1,'Forgotten Shrine 2'),
    (1,'Magic Glyph'),
    (1,'Magic Glyph2');
    
CREATE TABLE choice(
	choice_id INT PRIMARY KEY AUTO_INCREMENT,
    scenario_id INT NOT NULL,
    FOREIGN KEY(scenario_id) REFERENCES scenario(scenario_id),
    name VARCHAR(50)
    );
    
INSERT INTO choice(choice_id, scenario_id,name)
VALUES
	(-1,1,' ');
    
INSERT INTO choice(scenario_id, name)
VALUES
	(1,'Go towards the light'),
    (1,'Embrace the Darkness'),
    (2,'Search for twigs to make a fire'),
    (2,'Find a source of water to drink'),
    (3,'Stay and make the best of things'),
    (3,'Abandon your house and search for others'),
    (4,'Free demon from trap'),
    (4,'Save bird'),
    (4,'Kill demon'),
    (4,'Leave in darkness'),
    (5,'Free demon from trap'),
    (5,'Save critter from demon'),
    (5,'Kill demon, eat critter'),
    (5,'Leave in darkness'),
    (6,'Drink deeply from the pool'),
    (6,'Dive into the depths'),
    (6,'Search around the pool for others'),
    (6,'Wait patiently in the darkness'),
    (7,'Drink deeply from the pool'),
    (7,'Dive into the pool'),
    (7,'Make shelter besides the water source'),
    (7,'Wait patiently in the darkness'),
    (8,'Say a prayer to the lost gods'),
    (8,'Burn the shrine'),
    (8,'Look for worshippers'),
    (8,'Praise the sun!'),
    (9,'Say a prayer to the lost gods'),
    (9,'Burn the shrine'),
    (9,'Look for food'),
    (9,'Praise the sun!'),
    (10,'Attune to the glyph'),
    (10,'Study the glyph'),
    (10,'Look for others'),
    (10,'Recognize the phases of the moon in the glyph'),
    (11,'Attue to the glyph'),
    (11,'Study the glyph'),
    (11,'Look for food'),
    (11,'Recognize the phases of the moon in the glyph');
    
CREATE TABLE statement(
	statement_id INT PRIMARY KEY AUTO_INCREMENT,
    scenario_id INT NOT NULL,
    FOREIGN KEY(scenario_id) REFERENCES scenario(scenario_id),
    choice_id INT Default -1, -- 0 choice_id indicates the statement is for the scenario prompt
    FOREIGN KEY(choice_id) REFERENCES choice(choice_id),
    content VARCHAR(500) NOT NULL
    );
    
--   SELECT scenario.scenario_id, choice.choice_id, scenario.name as 'ScenName', choice.name as 'ChioceName'
--   FROM scenario
--   RIGHT JOIN choice ON scenario.scenario_id = choice.scenario_id;

INSERT INTO statement(scenario_id, content)
VALUES
	(1,'You awaken in the darkness,'),
    (1,'With no memory or direction,'),
    (1,'Time passes but you cannot grasp it;'),
    (1,'A week, a month, a year comes and fades again.'),
    (1,'Then there is light'),
	(2,'The light reveals a forest all around you,'),
    (2,'Trees reaching into the heavens,'),
    (2,'Not fully revealed by the light,'),
    (2,'The black treeptops grasp at the stars.'),
    (3,'The light is temporary,'),
    (3,'And soon consumed by the darkness,'),
    (3,'Yet far above you, still there are stars.'),
    (3,'The starlight reveals you hidden in a copse of trees.');
    
INSERT INTO statement(scenario_id, choice_id, content)
VALUES
    (1,1,'Go towards the light'),
    (1,2,'Embrace the Darkness'),
    (2,1,'Search for twigs to make a fire'),
    (2,2,'Search for a source of water to drink'),
    (3,1,'Search for twigs to make a fire'),
    (3,2,'Search for a source of water to drink');
    
CREATE TABLE monster_type(
	monster_type_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    secondary_element_id INT NOT NULL,
    physical_evolution INT,
    balanced_evolution INT,
    magical_evolution INT,
	previous_evolution INT,
    monster_type_image VARCHAR(500)
    );
    
INSERT INTO monster_type(name, secondary_element_id,  physical_evolution, balanced_evolution, magical_evolution, previous_evolution,  description)
VALUES
	('Flarial',0,2,3,4,NULL,'Young spirits made of flame that snap and spit at anything that comes near. Their white eyes burn with anger at whatever they see.'),
    ('Pyrus',0,NULL, 5, NULL,1,'Minor demond, made of flame. Their arms are glowing iron blades, that they may never put down. They are cursed for their violence to never cease.'),
    ('Flarpup',0,NULL, 6, NULL,1,'Young flaming fox cubs dashing this way and that, famed both for their agility and their inability to slow down.'),
    ('Pyro Symbol',0,7, NULL,8, 1,'Magical symbols of the eternal flame, Pyro Symbols spark and burn to the touch. It is said they can see the future in the fire.'),
    ('Pyos',0,NULL,NULL,NULL,2,'Wingless drakes whose skin is lit aflame, the Pyos are known for their ferocity in combat and the red fire that spills from their jaws.'),
    ('Comet',0,NULL,NULL,NULL,3,'The adolescent comet has grown black horns from its wolflike body as a result of its propensity to bash its head into whatever its running at.'),
    ('Fire Opal',0,NULL,NULL,NULL,4,'A sentient red and orange stone, the is an enchanted rock that hovers at chest level. Large as a big pot, they are known for thier fierce loyalty to their masters, as well as their unquenchable heat.'),
    ('Pyro Elemental',0,NULL,NULL,NULL,4,'A large Pyro Symbol has attracted three smaller symbols to better channel its potent magics.'),
	('Pyres',0,NULL,NULL,NULL,5,'Greater demons with horns and wings, the flames of its breath and whip are legendary.'),
    ('Bollide',0,NULL,NULL,NULL,6,'When Comets have been consumed by thier anger, they form into a Bolides, huge comets whose speed only ceases at their deaths. Its very speed ignites the air, burning all in its path.'),
    ('Ruby',0,NULL,NULL, NULL,7, 'The Fire Opal has hardened and its power has increased tenfold, granting it a brighter sheen and allowing it to cast magic and attack physically with ever more vigor.'),     
    ('Primordial Pyro Elemental',0, NULL, NULL, NULL,8, 'The Primordial Pyro Elemental, has grown and now dominates 6 smaller symbols, one for each element. It channels these symbols to cast all manner of spells, making it a true master of elemental magic.');

ALTER TABLE monster_type
ADD FOREIGN KEY(physical_evolution) REFERENCES monster_type(monster_type_id);

ALTER TABLE monster_type
ADD FOREIGN KEY(balanced_evolution) REFERENCES monster_type(monster_type_id);

ALTER TABLE monster_type
ADD FOREIGN KEY(magical_evolution) REFERENCES monster_type(monster_type_id);

ALTER TABLE monster_type
ADD FOREIGN KEY(previous_evolution) REFERENCES monster_type(monster_type_id);

    
Select * from monster_type;
    
    
CREATE TABLE traits(
	traits_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    monster_type_id INT,
    FOREIGN KEY(monster_type_id) REFERENCES monster_type(monster_type_id)
    );
    
CREATE TABLE trait(
	trait_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    trait_type ENUM('Corporeality','Age','Traversal','Evolutionary','Inherited','Elemental Magic','Status Increases') NOT NULL
    );
    
CREATE TABLE trait_intensity_lookup(
	intensity_id INT PRIMARY KEY AUTO_INCREMENT,
    traits_id INT NOT NULL,
    FOREIGN KEY(traits_id) REFERENCES traits(traits_id),
    trait_id INT NOT NULL,
    FOREIGN KEY(trait_id) REFERENCES trait(trait_id),
    intensity INT
    );
    
INSERT INTO trait(name, trait_type, description)
VALUES
	('Corporeal','Corporeality','Fully Existing in the physical space. Cannot be combined with Partially Corporeal or Incorporeal'),
    ('Partially Corporeal','Corporeality','Not fully existing in the physical space, such as a clout, a flame, or a liquid. Cannot be combined with Corporeal or Incorporeal.'),
    ('Incorporeal','Corporeality','Fully not existing in physical space, such as a ghost or a shadow. Cannot be combined with Corporeal or Partially Corporeal'),
    ('Infant','Age','Newly born monsters, typically bad at combat. Cannot be combined with Adolescent, Adult, Elder, or Ancient'),
    ('Adolescent','Age','Young, and eager to prove themselves, adolescent monsters have some strength at combat, but are easily overcome by Adults and Elders. Cannot be combined with Infant, Adult, Elder or Ancient'),
    ('Adult','Age','In their prime, Adult monsters are very strong and difficult to defeat with younger monsters, even when outnumbered. May not be combined with Infant, Adolescent, Elder or Ancient'),
    ('Elder','Age','Wise, but not as strong as they once were, Elder monsters use their experience to their advantage in combat. Cannot be combined with Infant, Adolescent, Adult or Ancient'),
    ('Ancient','Age','To reach this age and strength, a monster must be nearly immortal, and have survived many battles. Ancient Monsters are nearly impossible to control, and impossible to find. Cannot be combined with Infant, Adolescent, Adult, or Elder.'),
    ('Water Breathing','Traversal','Monsters that can travel through water with no issues. Cannot be combined with Submergeable or Unsubmergable'),
    ('Submergible','Traversal','Monsters that can be submerged without difficulty, but need assistance to travel through water. A value of 1 is almost unsubmergable, and takes damage from being underwater, a value of 5 is almost water-breathing and takes no damage. Cannot be combined with Water-Breathing or Unsubmergable'),
    ('Unsubmergible','Traversal','Monsters that cannot submerge under any circumstances. Cannot be combined with Water-Breathing or Submergable'),
    ('Light Emitting','Traversal','Monsters that emit light to reveal dark places. Slightly increases accuracy in battle. Cannot be combined with Light-Consuming. Typically found on Luxor Monsters'),
    ('Light Consuming','Traversal','Monsters that consume light and make travelling in dark places hazardous. Slightly decreases accuracy in battle. Note: you can "Shoot the moon" to see in the dark. Cannot be combined with Light Emitting. Typically found on Umbral Monsters'),
    ('Flying','Traversal','Monsters that can fly, when flying is available. Each point in the intensity makes it easier to carry someone else, also 5/10/15/20/25% chance to ignore melee damage (because you are flying). Typically found on Aero Monsters'),
    ('Floating','Traversal','Monsters that do not fly, but weigh nothing. They float, and neither make flight easier or more difficult'),
    ('Heavy','Traversal','Monsters that are so heavy, they make flight more difficult. Monsters with trait value 5 cannot fly under any circumstances'),
    ('Physical','Evolutionary','Monsters that have grown physically strong as a result of their evolution and ancestry. Deal LogBase2(PhysicalAttackCount)/(6-Intensity) Bonus damage on physical Attacks'),
    ('Balanced','Evolutionary','Monsters that have grown both physically and mentally stronger as a result of their evolution and ancestry. Deal LogBase2(MagicalAttackCount + PhysicalAttackCount)/(3*(6-traitValue)) Bonus damage on all attacks'),
    ('Magical','Evolutionary','Monsters that have grown mentally more acute as a result of their evolution and ancestry. Deal LogBase2(MagicalAttackCount)/(6-TraitValue) Bonus damage on magical Attacks');
    
    
    
    Select * from trait;
    
