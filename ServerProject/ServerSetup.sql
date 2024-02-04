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
    ('Pyrus',0,NULL, 5, NULL,1,'Minor demon, made of flame. Their arms are glowing iron blades, that they may never put down. They are cursed for their violence to never cease.'),
    ('Flarpup',0,NULL, 6, NULL,1,'Young flaming fox cubs dashing this way and that, famed both for their agility and their inability to slow down.'),
    ('Pyro Symbol',0,7, NULL,8, 1,'Magical symbols of the eternal flame, Pyro Symbols spark and burn to the touch. It is said they can see the future in the fire.'),
    ('Pyos',0,NULL,9,NULL,2,'Wingless drakes whose skin is lit aflame, the Pyos are known for their ferocity in combat and the red fire that spills from their jaws.'),
    ('Comet',0,NULL,10,NULL,3,'The adolescent comet has grown black horns from its wolflike body as a result of its propensity to bash its head into whatever its running at.'),
    ('Fire Opal',0,NULL,11,NULL,4,'A sentient red and orange stone, the is an enchanted rock that hovers at chest level. Large as a big pot, they are known for thier fierce loyalty to their masters, as well as their unquenchable heat.'),
    ('Pyro Elemental',0,NULL,12,NULL,4,'A large Pyro Symbol has attracted three smaller symbols to better channel its potent magics.'),
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

    
-- Select * from monster_type;-- 
    
    
CREATE TABLE traits(
	traits_id INT PRIMARY KEY AUTO_INCREMENT,
    traits_name VARCHAR(50) NOT NULL,
    monster_type_id INT,
    FOREIGN KEY(monster_type_id) REFERENCES monster_type(monster_type_id)
    );
    
CREATE TABLE trait(
	trait_id INT PRIMARY KEY AUTO_INCREMENT,
    trait_name VARCHAR(50) NOT NULL,
    description VARCHAR(750) NOT NULL,
    trait_type ENUM('Corporeality','Age','Traversal','Evolutionary','Inherited','Elemental Magic','Stat Modifiers') NOT NULL
    );
    
CREATE TABLE trait_intensity_lookup(
	intensity_id INT PRIMARY KEY AUTO_INCREMENT,
    traits_id INT NOT NULL,
    FOREIGN KEY(traits_id) REFERENCES traits(traits_id),
    trait_id INT NOT NULL,
    FOREIGN KEY(trait_id) REFERENCES trait(trait_id),
    intensity INT
    );
    
INSERT INTO trait(trait_name, trait_type, description)
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
    ('Magical','Evolutionary','Monsters that have grown mentally more acute as a result of their evolution and ancestry. Deal LogBase2(MagicalAttackCount)/(6-TraitValue) Bonus damage on magical Attacks'),
    ('Immolated','Inherited','Instead of taking fire damage, Absorb 20/40/60/80/100 % of it as health. Take 12/10/8/6/4 points of damage from rain and 15/13/10/8/6 points of damage in hail. Take severe damage from low temperature. Deal 1/2/4/8/16 points of bonus fire damage with each physical strike that connects. Instantly killed when used underwater, Immune to heatstroke, Targets who contact you take 2/4/6/8/12 Fire damage. Typically found on Pyro monsters. Must be combined with Light-Emitting and Unsumbergable. Cannot be combined with Cold or Fish'),
    ('Fish','Inherited','Increase speed by 10/15/20/25/35% and defense by 5/10/15/20/25% when underwater. Must be combined with Water-Breathing, cannot be combined with Immolated. Typically found on Aqua Monsters'),
    ('Natural','Inherited','Increase damage, health, and speed by 2/4/6/8/15% when in plains and the forest. Typically found on Terra Monsters'),
    ('Sandy','Inherited','Take 60/70/80/90/100% less damage from sandstorm. When sandstorm is active, accuracy penalty is reduced by 60/70/80/90/100%. Typically found on Sand Monsters.'),
    ('Dealt in kind','Inherited','Deal up to 5/10/15/20/25% bonus damage when health is below 10/15/20/25/35 %. Typically found on Justice and Vengeance Monsters.'),
    ('Steamy','Inherited','When in the steam caverns, Deal 30/40/50/60/80 % more damage and take 10/15/20/25/30 % less damage. Typically found on Steam Monsters.'),
    ('Wet','Inherited','gain 1/2/3/4/5 % additional damage for every 10 points of the Wet status effect, to a max of 5/12/18/24/35%. Typically found on Aqua Amphibious, and Plant Monsters. Cannot be combined with Sandy or Immolated'),
    ('Cloudy','Inherited','Immune to all weather affects other than sandstorm. When a weather effect is in place, deal 3/6/9/12/15 % more damage. Typically found on Weather, and Storm Monsters.'),
    ('Depths Dwelling','Inherited','When in deep water, Deal 30/40/50/60/80 % more damage and take 10/15/20/25/30 % less damage. Typically found on Deep Monsters.'),
    ('Forest Magic','Inherited','When in the forest, deal 3/6/9/12/15% bonus magical damage. Typically found on Fey Monsters'),
    ('Rooted','Inherited','Slowed down by 3/6/9/12/15%, receive 5/10/15/20/25% less damage. Typically found on Plant Monsters.'),
    ('Healer','Inherited','Damage Healed by this monster is increased by 15/30/45/60/75%. Typically found on Compassion Monsters.'),
    ('Toxic','Inherited','30/50/70/90/100% chance to deal 1/2/3/4/5 poison damage when attacking. Typically found on Rotten or Poison Monsters.'),
    ('Rebirth','Inherited','Three turns after being killed, resurrect with 10/20/30/40/50% of your health. Reduce Health by 30/25/20/17/15%. Typically found on Phoenix Monsters, as well as some Angel Monsters.'),
    ('Costal','Inherited','On the beach, deal 3/6/9/12/15 % extra damage. Typically found on a Seabreeze Monster.'),
    ('Flock','Inherited','For every team member with at least one rank in "flock", deal 1/2/3/4/5 % bonus damage, and take 1/2/3/4/5% less damage. Typically found on Bird, Aero, and Cocka Monsters.'),
    ('Vampire','Inherited','Absorb 10/15/20/35/50% of the physical damage you deal as health. Typically found on Nightwing Monsters.'),
    ('Diurnal','Inherited','2/4/6/8/10% additional damage in the sunshine. Typically found on Solar Monsters. Cannot be combined with Nocturnal.'),
    ('Nocturnal','Inherited','2/4/6/8/10% additional damage at night. Typically found on a Lunar, or a Umbral Monster. Cannot be combined with Diurnal'),
    ('Protector','Inherited','Increase defense by 1/2/3/4/5% for each attacker Taunted by you. Typically found on the physical branch of the Guardian subelement.'),
    ('Regenerator','Inherited','While you have temporary hit points, heal the hit points, and your own by 1/2/3/4/5 points at the end of your turn. Typically found on the magical branch of the Guardian subelement.'),
    ('Avenger','Inherited','Deal 3/6/9/12/15% bonus damage against Dark-Primary Monsters. Typically found on Angel and Vengeance Monsters.'),
    ('Connection','Inherited','Deal 1/2/3/4/5% bonus damage if the party is full. Typically found on Luxor Monsters.'),
    ('Guilt','Inherited','If you deal damage to a Light primary being, take 10/20/30/40/50% of the damage on yourself. Typically found on Redemption Monsters.'),
    ('Hypocrisy Hater','Inherited','Deal 4/8/12/16/25% more damage to Primary Light enemies, and an additional 2/4/6/8/10% to Luxor and Angel Enemies. Typically found on Demon, Betrayer, and some Umbral Monsters.'),
    ('Isolation','Inherited','Deal 10/20/30/40/60% more damage when the only fighter left in the party. Typically found on Umbral Monsters.'),
    ('Random Rainbow','Inherited','The skin of this monster is a hallucinogenic, and contact with it will deal (1/2/3/4/5) points of a random effect. Commonly seen on the balanced branch of the Amphibious subelement.'),
    ('Elemental Stone','Inherited','Deal 10/15/20/25/40% more damage for each stone equipped by the player'),
    ('Death Consuming','Inherited','Deal 2/4/6/8/10% more damage per corpse on the battle, typically found on Undead Monsters or some Nightwing Monsters.'),
    ('Pyromancy','Elemental Magic','Bonus (10*intensity)% fire damage on magical skills'),
    ('Aquamancy','Elemental Magic','Bonus (10*intensity)% water damage on magical skills'),
    ('Terramancy','Elemental Magic','Bonus (10*intensity)% earth damage on magical skills'),
    ('Aeromancy','Elemental Magic','Bonus (10*intensity)% air damage on magical skills'),
    ('Luxormancy','Elemental Magic','Bonus (10*intensity)% light damage on magical skills'),
    ('Umbramancy','Elemental Magic','Bonus (10*intensity)% dark damage on magical skills'),
    ('Calm','Stat Modifiers','A positive value will result in Calm: Deal and receive 20/40/60/80/100% additional Calm Damage. Typically found on Compassion Monsters. A negative value will result in Angry: Deal and receive 20/40/60/80/100% less Calm Damage. Cannot be combined with Calm. Typically found on Demon and Vengeance Monsters.'),
    ('Hot','Stat Modifiers','A positive value will result in Hot: Slightly increases the temperature of the battlefield each turn. Takes severe damage in cold conditions. Typically found on Pyro and Lava monsters. A negative value will result in Cold: Slightly decreases the temperature of the battlefield each turn. Takes severe damage in hot conditions. Typically found on Ice monsters.'),
    ('Strong','Stat Modifiers','A positive value will result in Strong: Deal 5/10/15/20/30% additional damage in melee combat. Typically found on Dinosaurs and Physical evolutions. A negative value will result in Weak: deal 5/10/15/20/30% less damage in melee combat. Typically found on Magical Evolutions.'),
    ('Wise','Stat Modifiers','A positive value will result in Wise: deal 5/10/15/20/30% additional magic damage. Increase experience gain by 2/4/6/8/12% Typically found on Magical Evolutions. A negative value will result in Dumb: 	deal 5/10/15/20/30% less magic damage. Decrease experience gain by 2/4/6/8/12% Typically found on Dinosaurs and Physical evolutions.'),
    ('Fast','Stat Modifiers','A positive value will result in Fast: Increase speed in turn calculation by 5/10/15/20/25% Typically found on Air primary monsters or Pegasus Monsters. A negative value will result in Slow: Reduce speed in turn calculation by 5/10/15/20/25% Typically found on Elder Physical monsters, or the Physical branch (turtles) of the Amphibious Secondary element.'),
    ('Hardy','Stat Modifiers','A positive value will result in Hardy: Gain 5/10/15/20/25% Extra health. Typically found on Elder Physical monsters, or the Physical branch (turtles) of the Amphibious Secondary element, or the Undead. A negative value will result in Faint: Reduce Health by 5/10/15/20/25%. Typically found on Phoenix monsters.'),
    ('Rich','Stat Modifiers','A positive value will result in Poor: Gain 10/20/25/30/35% less gold from battle. Instead, gain 5/10/13/17/20% bonus experience for just this monster, only if there are no Rich monsters in party.');
    
INSERT INTO traits(traits_name, monster_type_id)
VALUES
	('Flarial Traits', 1),
    ('Pyrus Traits',2),
    ('Flarpup Traits',3),
    ('Pyro Symbol Traits',4),
    ('Pyos Traits',5),
    ('Comet Traits',6),
    ('Fire Opal Traits',7),
    ('Pyro Elemental Traits',8),
    ('Pyres Traits',9),
    ('Bollide Traits',10),
    ('Ruby Triats',11),
    ('Primordial Pyro Elemental Traits',12);
    
-- Select * from traits;
-- Select trait_id, name from trait;

INSERT INTO trait_intensity_lookup(traits_id, trait_id, intensity)
VALUES
	(1,1,1),
    (1,4,1),
    (1,11,1),
    (1,20,1),
    (1,12,1),
    (1,15,1),
    (1,56,1),
    (2,1,1),
    (2,5,1),
    (2,11,1),
    (2,20,2),
    (2,12,1),
    (2,16,2),
    (2,17,1),
    (2,56,2),
    (3,1,1),
    (3,5,1),
    (3,11,1),
    (3,15,1),
    (3,20,1),
    (3,19,1),
    (3,49,1),
    (3,56,1),
    (4,1,1),
    (4,5,1),
    (4,11,1),
    (4,15,1),
    (4,20,1),
    (4,19,1),
    (4,49,1),
    (4,56,1),
    (5,1,1),
    (5,6,1),
    (5,11,1),
    (5,12,2),
    (5,20,3),
    (5,17,2),
    (5,57,1),
    (5,58,-1),
    (5,56,3),
    (6,1,1),
    (6,6,1),
    (6,11,1),
    (6,16,2),
    (6,12,1),
    (6,20,3),
    (6,18,2),
    (6,59,2),
    (6,56,3),
    (7,1,1),
    (7,6,1),
    (7,11,1),
    (7,15,1),
    (7,20,1),
    (7,18,1),
    (7,19,1),
    (7,47,1),
    (7,56,1),
    (8,1,1),
    (8,6,1),
    (8,11,1),
    (8,15,1),
    (8,20,1),
    (8,19,2),
    (8,49,2),
    (8,51,1),
    (8,54,1),
    (8,58,1),
    (8,56,1);
    

Select subquery.traits_name, subquery.trait_name, trait_intensity_lookup.intensity
FROM ( Select traits.traits_id, traits.traits_name, trait.trait_id, trait.trait_name from traits cross join trait) AS subquery
Right Join trait_intensity_lookup on  subquery.traits_id = trait_intensity_lookup.traits_id AND subquery.trait_id = trait_intensity_lookup.trait_id;




    
    
