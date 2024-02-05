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
    description VARCHAR(750) NOT NULL,
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
    ('Primordial Pyro Elemental',0, NULL, NULL, NULL,8, 'The Primordial Pyro Elemental, has grown and now dominates 6 smaller symbols, one for each element. It channels these symbols to cast all manner of spells, making it a true master of elemental magic.'),
    ('Philammon',1,14,15,16,NULL,'A lesser son of Vulcan. though it is fire elemental, it is known for its somber mood, unlike other fire primaries'),
    ('Crerops',1,NULL,17,NULL,13,'Creops is a man size titan with a face of melting stone. Lava flows from its heart, a furnace controlling the stone and giving it life; its heart is also its weak spot. Small horns have sprouted from its head, that it uses mainly for defense.'),
    ('Oil Puddle',1,NULL,18,NULL,13,'The Philamon melted in the heat of the planet\'s mantle, dissolving into its constituent parts. After basking in the heat, it formed a sentient puddle of oil, giving off noxious, flammable fumes. It is fued by its anger, and enjoys being lit on fire.'),
    ('Corynetes',1,NULL,19,NULL,13,'A floating sphere of lava that glows and pulses from yellow to orange. It has a cracked shell of earth protecting it, within which the core dwells.'),
    ('Philottus',1,NULL,20,NULL,14,'An eight-foot tall fire monster with horns jutting from his head, made of lava and hunks of rock. His weak point is his molten heart, glowing near the center of his chest. It is protected by transparent rock. The more of this rock that is chipped away, the angrier and more dangerous he becomes. His horns have formed a kind of crown on his head, a claim of indomitable strength- defying a challenger to attack him.'),
    ('Lava Pool',1,NULL,21,NULL,15,'Spilling out from the earths molten core, this pool of lava is dangerous, spitting molten lava at all those around it, as if the pool itself is angry. It has feasted on the fumes and the heat of the core for an age, and now wishes to burn the overworld to make it another fiery home.'),
    ('Cercyon',1,NULL,22,NULL,16,'A floating lava-snake with two tails extending and circling around it. It has two tails so it can channel two different spells separately, one in each tendril. It has a molten core strongest at its center, that extends through each arm.'),
    ('Vulcanous',1,NULL,NULL,NULL,17,'A walking colossus of molten iron. Iron plates still red-hot protect the vulnerable molten core within, making the colossus near-impenetrable, except at the joints, which are still molten. Its rock hard horns now curl down each side giving it a terrifying appearance (like Durin\'s bane from the Tolkien universe).'),
    ('Magma Lake',1,NULL,NULL,NULL,18,'Heat and Noxious fumes erupt from this red lake, as if from the bowels of hell itself. It has come to overhwelm the surface world with its fiery wrath, and consumes all in its path, especially metals which strenthen iit. Ice is the only sure way of stopping it.'),
    ('Vagrus',1,NULL,NULL,NULL,19,'An actual lava dragon, snakelike with giant horns. A master of magic, it casts both fire and water in tandem with its breath, channeling the energies through its two massive horns. Unlike the Vulcanous, its core is a thin snake inside of it, allowing it to move more quickly, leaving it more vulnerable to attack, but also allowing it to channel energy from its surroundings more effectively.'),
    ('Salamander',2,24,25,26,NULL,'A limbless snake that dwells in hot places, typically deserts or volcanoes. It will bite when threatened. It is called a Salamander because of the myth that it can breathe fire, although it seems when angered, a small flame will light in the back of its throat. It is much weaker in colder climes, and its hide is behind only drakescale and dragonbone in terms of fire protection.'),
    ('Raptor',2,NULL,27,NULL,23,'Though weak on its own, Raptors, when working together can take down much larger prey. They are famed for their cunning and cruelty, often taking time to give the meat its \'savor\'.'),
    ('Winger',2,NULL,28,NULL,23,'A small flying dinosaur that resembles a bat, except for its cone-shaped head and large teeth. Wingers are known for their great vision and speed, often killing smaller prey before they knew they were under attack. The hooks in their wings, though small are devastatingly sharp and can rend through any armor with the slightest flaw.'),
    ('Herbisaur',2,NULL,29,NULL,23,'Large for an adolescent, the Herbisaur is a dinosaur that is slow target- but beefy. Its skin is so thick and tough that often predators will grow tired and seek different prey. Herbisaurs are named because they don\'t eat any meat, but they eat nearly everything else- all the time. Many use this to explain why they are so large at such a young age.'),
    ('Tyrant',2,NULL,30,NULL,24,'A giant monster with huge jaws capable of enveloping a human whole, the tyrant is the lord of the plains. Its skin is charcoal grey because it nests in the charred hides of its prey. Tyrants are known for their ability to breathe fire, which it often does to quickly kill enemies that are too fast to catch.'),
    ('Steel Winger',2,NULL,31,NULL,25,'A larger Winger with a steel beak and wings. The winger thought it would be cool to go steel, but it didn\'t account for the weight, which slows it down and in extreme cases keeps it from flying. The added defense is exceptional though, and the steel hooks in its claws and beak have an even greater penetrating effect than the raw bone of the Winger.'),
    ('Spikevorsaur',2,NULL,32,NULL,26,'A massive monster that has spikes protruding from every inch of its hide, The Spikevorsaur is a superb defensive combatant. Though slow, it can bellow at enemies, enraging the stupid and aggressive, to protect its fellow monsters. It uses the same call in mating, and female Spikevorsaurs favor a mate with large, pointy spikes, the redder the better.'),
    ('Great White Tyrant',2,NULL,NULL,NULL,27,'Decades of curing scale plate with the ashes of fallen enemies have turned the Tyrants scales and horns white- a manner of bone harder even than steel. Its gaze is said to so terrifying that its prey freezes in fear when they meet it. Why this superstition is though, no one knows, as a meeting with a Great White Tyrant rarely leaves any survivors.'),
    ('Edge Winger',2,NULL,NULL,NULL,28,'The EdgeWinger is and evolved SteelWinger, that shaved off the edges of the steel so that its really sharp- and light enough it can fly again. The edges of its wings (for which it is named) are so sharp that a thread, when dropped over them, is cut by its own weight. Natural bonesmiths revere the skeleton for its usefulness in making rare blades. It has enough weight and control in the sky that it can dive straight down at terrifying heights and speeds, slicing through it enemies without warning in an \'edge dive\'.'),
    ('Broncheospikesaur',2,NULL,NULL,NULL,29,'Most monsters draw within their bodies when they are old, leaving a bony outer shell to protect themselves. Not so the Broncheospikesaur. Its blood has developed regenerative capabilities and flows near the skin healing any minor damage. This doesn\'t make the Broncheospikesaur vulnerable, however, since it can near instantly regenerate any damage that penetrates its shell deep enough to strike blood. Its bleating roar is also famous for being able to enrage all opponents at once. That combined with the regeneration and the thorny skin make the Broncheospikesaur one of the most capable defensive monsters around.'),
    ('Kangarat',3,34,35,36,NULL,'The Kangarat is a small rodent that can spend its whole life without having to drink any water. It is wise in the ways of the desert, and knows where to hide during sandstorms. Unlike most furry creatures, it relishes having sand in its fur. It can tell the direction of the nearest water using its feet, and is a valued pet among the caravaneers that brave the desert.'),
    ('Slynx',3,NULL,37,NULL,33,'A Slynx is a mythical sand cat that has haunting eyes and can speak, but only speaks in riddles. Whenever asked a question, it answers with another question, usually pointing at the right answer. If the Slynx has no clue though, it will just repeat the question asked of it, it is about the size of a mountain lion'),
    ('Skorpi',3,NULL,38,NULL,33,'A Scorpi is a small scorpion that is red and very venomous. It is not, however, poisonous, and baked Skorpi casserole is one of the delicacies in the desert, although it is very hot- usually too hot for foreigners.'),
    ('Humpless',3,NULL,39,NULL,33,'A humpless is a sad camel without a hump. It can magically control the sand with its mind and keeps some in the gourd across its back. It is infamous for never getting any action, and that might be why its so sad. A charm shaped like a humpless us used to protect rich peoples daughters.'),
    ('Sphynx',3,NULL,40,NULL,34,'The Sphynx has the head of a man and the body of a lion, like the Slynx it evolved from, it speaks only in riddles, however, these riddles are more difficult. It lacks wings, although older Sphynx will grow them and use them for flight'),
    ('Scarpi',3,NULL,41,NULL,35,'A Scarpi is a large scorpion whose plates have turned into armor, although they do bear scars from its earlier encounters. It is named after the fabled storyteller who is credited with the creation of its myth. Indeed they were so rare that many didn\'t believe Scarpi when he told his stories. Obviously, the doubters were wrong.'),
    ('Unihump',3,NULL,42,NULL,36,'A Unihump is a camel with a single hump. It stores water in this hump obviously and can cast sandstorm with its mind. Its fur is designed to cause a slight breeze beneath the heat, cooling it to prepare it for long days in the hot sands. Though slow, it is beloved by the caravaneers of the desert for its hardy ability to carry lots of weight, and for its general good nature.'),
    ('Greater Sphynx',3,NULL,NULL,NULL,37,'The Greater Sphynx is a very large sphynx with haunting eyes that also speaks in riddles and analogies. Unlike its smaller cousings, it has large folded wings along its back. It cant fly with them, but when it spreads them out, it looks very intimidating. The feathers alternate between jade and turquoise, and as these are precious metals, the Greater Sphynx was once hunted for its wings. But then they killed and ate all the hunters after they failed their questions, so that was over quickly.'),
    ('Scorpious',3,NULL,NULL,NULL,38,'The Scorpious is a descendant of the giant Scorpion that killed Orion. Huge and black as night, its shiny carapace is highly valued in the eastern empire to use making armor and shields, for despite its black coloring, it is quite cool, even in the most desperate heat. Its terrible claws can burrow in the sand, making it disappear in moments, and reappear unexpectedly behind its prey.'),
    ('Bihump',3,NULL,NULL,NULL,39,'The Bihump has mystical powers and can control sand with its mind. A loyal beast, it will entomb any that threaten its caravaneer masters in sand. It can cast Fire and Air magic simultaneously, one spell from each hump, and due to its hardiness and wisdom is a prized fighter in the desert arenas. It can be rather slow at times, but it is always a deliberate, directed action that is slow. The beast uses each moment to its fullest.'),
    ('Angier',4,44,NULL,45,NULL,'The youngest justice monster, Angiers are very concerned with right and wrong, although their own moral compass is still undeveloped. This can lead to interesting situations, commonly Angiers pray at altars too long, forsaking food and water, thinking it is the \'right\' thing to do. Part of their journey is learning moderation in the principles they stick to blindly.'),
    ('Justicar',4,NULL,46,NULL,43,'The Justicar appears as a lesser knight in shining chainmail and a golden crest upon its helm. It holds a wooden shield painted white in its left hand with an iron sword in its right. It has a cloth half cape edged in yellow. The Justicar believes solidly in the rule of law and protects the weak. However, if it views the weak to be unvirtuous, it will leave them to suffer, believing that their karma will sort them out.'),
    ('Ayurved',4,NULL,47,NULL,43,'The Ayurved is a healer that calls upon faith to direct the healing of its god. It is better at healing the virtuous and refuses to touch the vile. The Angier it has grown from had its horns grow into scales on which it balances the morality of its target. It doesn\'t care whether the target is an enemy or a friend, it will only heal the virtuous and only harm the wicked.'),
    ('Ordinator',4,NULL,48,NULL,44,'The ordinator is a justicar who has served its term as a city guard and now goes forth to right whatever wrong it sees. It stands in shining white steel plate mail with a steel shield edged in gold with a knee-length white silk cape edged in gold.'),
    ('Anyr',4,NULL,49,NULL,45,'The Anyr is a judge that has been given the full authority of the church to act in the interest of the greater good in whatever way it thinks best. It can only be second-guessed by a clergyman ranked bishop or higher. It has the ability to cast a spell that heals all light elementals and harms all dark elementals but does not discriminate between friend and foe. It is loosely based on the amyr form Patrick Rothfuss\' kingkiller chronicles. which you should read, by the way.'),
    ('Zireal',4,NULL,NULL,NULL,46,'The Zireal is the angel of justice. Wears a white garb with a golden tassel. Blindfolded with a white cloth, but never misses. Wields a sword in one hand and a shield with scales in the other.'),
    ('Justicer',4,NULL,NULL,NULL,47,'The Justicier is a quiet robed figure, who can speak into the ears of the wicked. For her, the ends justify the means, and any means will be used for the betterment of mankind.'),
    ('Spiten',5,51,NULL,52,NULL,'Unsurprisingly, Spitens are known for being unforgiving and cruel. While not large enough to inflict the vengeance they desire, they still keep a list in their heads of all who wronged them- so their anger can be satisfied at a later date.'),
    ('Jacobia',5,NULL,53,NULL,50,'The Jacobia looks for all intents and purposes, a demon. It hates all the evil in the world with a passion. It represents the hotter, angrier side of vengeance. It plans to kill them all but does not realize, after all the evil has been slain, it will still have one last murder to perform. It does bonus damage to creatures with a dark element and less damage to creatures with a light element.'),
    ('Lizbet',5,NULL,54,NULL,50,'It is a play on the Elizabethan revenge tragedy. She has an obsidian curving circlet on her forehead, coming to a point in the center of her brow. Her skin is ashen, her hair bloodred, her eyes, that only open when she casts spells, are yellow. She represents the quiet revenge, cold and calculated, and speaks seldom, then only in a whisper. To tell her allies why they failed her, at the summit of their defeat.'),
    ('Letham',5,NULL,55,NULL,51,'A Letham is a creature that once loved passionately and had its love taken away. It looks like a human, except corrupted by anger and hate. It is slowly losing its sense of justice, and is beginning to admit to itself what it really wants. Its horns and claws are twisted and cruel- much like its soul.'),
    ('D\'Hoffry',5,NULL,56,NULL,52,'The D\'Hoffry are male vengeance angels with red wings. They are crueler than their cousins, the Lethams, but much less vicious and able than their stronger female relatives, the Halfrecs. It channels hot vengeance energy through its red wings. The feathers of the wings are sharp, and can cut into the flesh of the guilty- their blood is what gives the wings their color, while their screams are what give his face its countenance. It is willing now- to do what is required in pursuit of its goals- no matter the cost.'),
    ('Revenant',5,NULL,NULL,NULL,53,'The revenant wears Red steel, outlined with sharp blacklines. The full helm covers the entire head and has red horns, though whether these horns are a part of the helmet or the demon is unknown. Its claws appear sharp if worn down, but shine when covered with the blood of the guilty. The Revenants justified rage is old now- it has slain its enemy, though the cost was dear- it no longer recognizes itself, and on its path to vengence, it has become something worse even than the evil it slew.'),
    ('Halfrec',5,NULL,NULL,NULL,54,'A Halfrec is a female vengeance demon with dark wings coated in spikes and cruel hooks. It is unforgiving and believes itself to be doing what is right. They are slowly coming back after a buff vampire slayer killed most of them. Unlike their cousins the D\'Hoffrys, the Halfrecs can channel and control their hate for better use later instead of exploding. This magical energy is concentrated in its large intricate red horns, that glow with hot rage energy that can be directed as the Halfrec wishes. It is the very embodiment of the phrase: \'Hell hath no fury like a woman scorned\'.'),
    ('Minor Steamlet',10,58,NULL,59,NULL,'The minor steamlet is a young demon made of steam. It cannot be harmed by physical attacks but has very little health. A small amount of white phosporus drives its core, and if this phosporous is damaged, it will die quickly.'),
    ('Lesser Steamlet',10,NULL,60,NULL,57,'The lesser steamlet is a slightly older steamlet that can briefly dissipate and come back together. Is it strategically advantageous? Probably only if your delaying for the resurrection of a phoenix. A larger amount of white phosphorus is at its core, that allows it to live outside of its humid environment longer'),
    ('Scaldar',10,NULL,61,NULL,57,'A phantom of steam, seeming to appear and reappear at will, the Scaldar rejoices in wrapping itself around its enemies, burning them with its phantasmal body.'),
    ('Steamlet',10,NULL,62,NULL,58,'The Steamlet is a mature monster that no longer laughs at childish or raunchy jokes. As such, its soul is dead, and its not fun to be around, especially if its friends are older. It has uncommon yellow phosporous at its core.'),
    ('Excoriator',10,NULL,63,NULL,59,'This sentient ball of heat seeks out all non-steamlets who fail to fit in its domain. It delights particularly in burning and consuming the skin off of intruders, which it can consume with its corrosive vapors.'),
    ('Greater Steamlet',10,NULL,NULL,NULL,60,'The Greater steamlet is known only by the rare master that tries to collect them all, because its relatively useless and very hard to obtain. As you are reading this, you must have obtained it, so congradulations, you have found one of the most obscure elders. Sorry its not very useful in combat or anywhere else.'),
    ('Meldor',10,NULL,NULL,NULL,61,'This sentient ball of red vapor contains its own aerosol digestive system of corrosive vapors. When caught in its grasp, its victims skin melts.'),
    ('Minnow',11,65,66,67,NULL, 'A small fish with bright blue eyes, they are happiest in water. However they are magical and can follow their masters by floating in air with limited trouble. They have a hard bony plate on their foreheat that they use to strike any threat they can\'t run away from, and are known to master magic at a young age. Though friendly, they do not seek out company, preferring to isolate. Very thin, they are known to seemingly disappear when travelling directly at or away from an observer.'),
    ('EdgeFin',11,NULL,68,NULL,64, 'EdgeFinn is a larger version of the Minnow with a serrated crest and fins, as well as small, razor-sharp teeth. unlike most fish, its eyes face forward to stalk its prey, like the carnivores on land. It is known for hunting its prey with persistence, and it can smell blood three miles distant.'),
    ('Cuddlerfish',11,NULL,69,NULL,64,'A Cuddlerfish is shaped like a Cuttlefish but also loves cuddling. That\'s why typically they come in pairs. They separate infrequently, and when they do, both halves become very needy and inevitably float back together. They are the very picture of toxic codependence.'),
    ('Aqua Symbol',11,70,NULL,71,64,'A silver Taurus, with a sapphire sphere at its base. Etched on the Sapphire Sphere is the water Symbol. When it attacks, the crest appears in the center of the Taurus, and water drips from it. When one is near, calmness and complacency echoes in the mind.'),
    ('Slicefin',11,NULL,72,NULL,65,'Slicefinn is a shark. A hammerhead shark whose front finn is sharpened steel. It has a sensor on either end of its fin, that is both an eye and an underwater nose. As a result it can \'smell\' blood in three dimensions underwater, for eight miles in any direction'),
    ('Snugglerfish',11,NULL,73,NULL,66,'The toxic codependency of the cuddlefish has reached its apex, and the two cuddlerfish have fused into a single Snugglerfish. The Snugglerfish couldn\'t be happier though, each half truly fulfilled in its connection with the other. Who am I to judge?'),
    ('Torquoise',11,NULL,74,NULL,67,'A green-Blue stone formed over the centuries under the ocean, that channels magical power. They are famous for ornamenting pirate queens.'),
    ('Aqua Elemental',11,NULL,75,NULL,67,'The Aqua Elemental is a large aqua symbol that has six crystallized water droplets on each of its six points. Its incredible mastery of magic has attracted additional symbols, and it can cast magics of those elements as well, though it is still most comfortable casting water magic.'),
    ('Blue Dragon',11,NULL,NULL,NULL,68,'A blue dragon that lives under the sea. It has incredibly sensitive scales, which it uses to sense prey. Despite its massive girth, it is quick enough to keep itself well fed. Under the oceans, it only fears Krakens in deep water, alhough it will fight a Levithan only at great need. As the top of the underwater food chain, some grow lazy, and gather treasures from shipwrecks for their massive hoards.'),
    ('Leviathan',11,NULL,NULL,NULL,69,'A Leviathan is a giant sea monster that can shoot a very pressured stream of water at its enemies. It grew from a huge collection of Cuddlerfish that fused together. It haunts the oceans and is an unstoppable force below the waves.'),
    ('Sapphire',11,NULL,NULL,NULL,70,'Gleaming, and hewn from rock far beneath the ocean floor, a Sapphire is a bright blue stone that can serve as a channel for aquatic magic. It is highly prized for its shininess, though any treasure seeker that would wish to kill it should take heed. It is very dangerous when threatened, able to cast water magic, as well as having a near impregnatable carapace, and damaging the carapace would reduce the value of the stone.'),
    ('Primordial Aqua Elemental',11,NULL,NULL,NULL,71,'A collection of Elementals, with a large Aqua elemental in the center with the five other elements represented as smaller elementals around the edge. When the Atronach wants to cast spells from other elements, it pulls that elemental into the center and channels its magic energy through both. It is known as having the strongest magical capacity of any monster, and can cast toe-to-toe with even the strongest archmagi.');



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
    ('Primordial Pyro Elemental Traits',12),
    ('Philammon Traits',13),
    ('Crerops Traits',14),
    ('Oil Puddle Traits',15),
    ('Corynetes Traits',16),
    ('Philottus Traits',17),
    ('Lava Pool Traits',18),
    ('Cercyon Traits',19),
    ('Vulcanous Traits',20),
    ('Magma Lake Traits',21),
    ('Vagrus Traits',22),
    ('Salamander Traits',23),
    ('Raptor Traits',24),
    ('Winger Traits',25),
    ('Herbisaur Traits',26),
    ('Tyrant Traits',27),
    ('Steel Winger Traits',28),
    ('Spikevorsaur Traits',29),
    ('Great White Tyrant Traits',30),
    ('Edge Winger Traits',31),
    ('Broncheospikesaur Traits',32),
    ('Kangarat Traits',33),
    ('Slynx Traits',34),
    ('Skorpi Triats',35),
    ('Humpless Traits',36),
    ('Sphynx Triats',37),
    ('Scarpi Traits',38),
    ('Unihump Traits',39),
    ('Greater Sphynx Traits',40),
    ('Scorpious Traits',41),
    ('Bihump Traits',42),
    ('Angier Traits', 43),
    ('Justicar Traits',44),
    ('Ayruved Traits',45),
    ('Ordinator Traits',46),
    ('Anyr Triats',47),
    ('Zireal Triats',48),
    ('Justicer Traits',49),
    ('Spiten Traits',50),
    ('Jacobia Traits',51);
    
--  Select * from traits;
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
    (7,61,1),
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
    (8,56,1),
    (9,1,1),
    (9,7,1),
    (9,11,1),
    (9,15,1),
    (9,20,4),
    (9,17,3),
    (9,57,2),
    (9,58,-2),
    (9,55,-2),
    (9,56,4),
    (10,1,1),
    (10,7,1),
    (10,11,1),
    (10,16,2),
    (10,20,4),
    (10,18,3),
    (10,59,3),
    (10,56,4),
    (11,1,1),
    (11,7,1),
    (11,11,1),
    (11,15,1),
    (11,20,2),
    (11,18,2),
    (11,19,2),
    (11,47,2),
    (11,56,2),
    (11,61,2),
    (12,1,1),
    (12,7,1),
    (12,20,2),
    (12,19,3),
    (12,49,3),
    (12,50,1),
    (12,51,1),
    (12,52,1),
    (12,53,1),
    (12,54,1),
    (12,55,-1),
    (12,58,2),
    (12,57,-1),
    (12,56,2),
    (13,2,1),
    (13,4,1),
    (13,11,1),
    (13,16,1),
    (13,56,1),
    (14,1,1),
    (14,5,1),
    (14,10,5),
    (14,16,2),
    (14,17,1),
    (14,56,2),
    (14,57,1),
    (15,2,1),
    (15,5,1),
    (15,11,1),
    (15,16,2),
    (15,18,1),
    (15,56,2),
    (16,2,1),
    (16,5,1),
    (16,10,5),
    (16,15,1),
    (16,19,1),
    (16,56,2),
    (17,1,1),
    (17,6,1),
    (17,10,5),
    (17,16,3),
    (17,17,2),
    (17,56,3),
    (17,57,2),
    (17,58,-1),
    (18,2,1),
    (18,6,1),
    (18,11,1),
    (18,16,3),
    (18,18,2),
    (18,55,-1),
    (18,56,3),
    (19,2,1),
    (19,6,1),
    (19,10,5),
    (19,15,1),
    (19,19,2),
    (19,56,3),
    (19,57,-1),
    (19,58,1),
    (20,1,1),
    (20,7,1),
    (20,10,5),
    (20,16,4),
    (20,17,3),
    (20,55,-1),
    (20,56,4),
    (20,57,3),
    (20,58,-2),
    (21,2,1),
    (21,7,1),
    (21,11,1),
    (21,16,5),
    (21,18,3),
    (21,55,-2),
    (21,56,4),
    (21,59,-1),
    (22,2,1),
    (22,7,1),
    (22,10,5),
    (22,15,1),
    (22,19,3),
	(22,55,-1),
    (22,56,4),
    (22,57,-2),
    (22,58,2);







    
    
