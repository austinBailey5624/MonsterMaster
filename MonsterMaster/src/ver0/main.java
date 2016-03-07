/***
 * 		@filename:		main.java
 * 		@author:		Austin Bailey
 * 		@dateBegun:		12/6/2015
 **/
package ver0;
import java.util.*;
import java.io.*;
public class main 
{
	static int tempi;
	static FileInputStream fileIn=null;
	static FileOutputStream fileOut=null;
	static Scanner myScanner= new Scanner(System.in);
	static String[][] typeNames=new String[6][6];
	static int pes;//primary element set, time saver
	static int ses;//secondary element set, time saver
	public static MonsterTree[][] define()
	{
		MonsterTree[][] bestiary = new MonsterTree[6][6];
		
		//primary Fire
		pes=0;
		ses=0;
		MonsterTree pyroTree = new MonsterTree(pes,ses,typeNames[0][0]);
		pyroTree.m_elders=new MonsterType[4];
		pyroTree.m_elders[0]=new MonsterType("Red Dragon",pes,ses,4,0,"The red dragon is as the name implies a red dragon. It breathes fire and captures princes. Yes, I said princes, not princesses, you sexist! It can only be defeated by a young blonde detective being given directions by a captured serial killer. If you didn't get the reference, google it. You won't be disappointed");
		pyroTree.m_elders[1]=new MonsterType("Benemoth",pes,ses,4,1,"The benemoth is a giant, human shaped colossus of flame.");
		pyroTree.m_elders[2]=new MonsterType("Bolide",pes,ses,4,2,"The Bolide is a grown up comet with large muscular legs that moves even faster.");
		pyroTree.m_elders[3]=new MonsterType("Flame Atronach",pes,ses,4,3,"The flame atronach is a giant circular flame symbol made of red steel surrouned by six smaller flame symbols that rotate around it, faster when its casting a spell");
		pyroTree.m_adults=new MonsterType[4];
		pyroTree.m_adults[0]=new MonsterType("Pyros",pes,ses,3,0,"A Pyros has the body of a man and the head of a bull, it wears a cape made of flame though the cape does not burn it. It has a flame crescent axe that seems to be made of red steel",pyroTree.m_elders[1]);
		pyroTree.m_adults[1]=new MonsterType("Flarus",pes,ses,3,1,"A greater Flarus has short legs and gian arms that extend to the floor. Its entire body is aflame, and short red horns can be seen ",pyroTree.m_elders[1]);
		pyroTree.m_adults[2]=new MonsterType("Comet",pes,ses,3,2,"The Comet is a four legged hound with an incredible amount of speed. It runs as fast as it can and slams into its enemy in combat, known as the 'comet dash'",pyroTree.m_elders[2]);
		pyroTree.m_adults[3]=new MonsterType("Flame Elemental",pes,ses,3,2,"The flame elemetal has is a chasis of black iron engulfed in flame",pyroTree.m_elders[3]);
		pyroTree.m_adolescents = new MonsterType[3];
		pyroTree.m_adolescents[0]=new MonsterType("Pyrus",pes,ses,2,0,"Pyrus is a three foot tall demon, engulfed in flame with an extending red snout like a dogs with black eyes and red iruses. His teeth shine in the light of his flames",pyroTree.m_adults[0],pyroTree.m_adults[1]);
		pyroTree.m_adolescents[1]=new MonsterType("Flarpup",pes,ses,2,1,"The Flarpup is a small dog with hair that looks like fire. It inflicts fire damage with its bite",pyroTree.m_adults[2]);
		pyroTree.m_adolescents[2]=new MonsterType("Flame Symbol",pes,ses,2,2,"A circular golden band a foot and a half in diameter two inches thick holds a red sphere at its base. When it becomes angry the ring lights aflame and the flame symbol can be seen glowing in its center, althouh there is nothing there",pyroTree.m_adults[3]);
		pyroTree.m_infants = new MonsterType[1];
		pyroTree.m_infants[0]=new MonsterType("Flarial",pes,ses,1,0,"An orange ball of flame with a red eye. It hovers in the air, a foot above the ground, a sphere a foot in diameter. The ends of the flame flow behind it, althogh no wind can be felt",pyroTree.m_adolescents[0],pyroTree.m_adolescents[1],pyroTree.m_adolescents[2]);
		pyroTree.m_eggs = new MonsterType[1];
		pyroTree.m_eggs[0]= new MonsterType("Pyro Egg",pes,ses,0,0,"An orange egg with the symbol of a red flame. When you touch it, it is warm, and you become angry, though you do not know why. Pull your hand away and you are burned, though by the egg or yourself you cannot tell",pyroTree.m_infants[0]);
		bestiary[0][0]=pyroTree;
		
		ses=1;
		MonsterTree lavaTree=new MonsterTree(pes,ses,typeNames[pes][ses]);
		lavaTree.m_elders= new MonsterType[3];
		lavaTree.m_elders[0]=new MonsterType("Vulcanous",pes,ses,4,0,"Vulcanous is a walking colossus filled with lava");
		lavaTree.m_elders[1]=new MonsterType("Vagrus",pes,ses,4,1,"Vagrus is a lava dragon that levitates and doesnt have wings. Its skill is lavabreath");
		lavaTree.m_elders[2]=new MonsterType("Vulcan",pes,ses,4,2,"Vulcan is named after the god Vulcan and can cast all sorts of magic. It is a flaming wheel whose spokes have the elemental glyphs written on them. Its greatest strength is the breadth of magic that it ca cast. Also live long and prosper");
		lavaTree.m_adults=new MonsterType[3];
		lavaTree.m_adults[0]=new MonsterType("Philottus",pes,ses,3,0,"Philottus is a walking smelter with a big hammer. It can cover its hammer with lava to do 2.5 times as much damage on its next attack, but the buff only lasts for one turn, as then the cast cools",lavaTree.m_elders[0]);
		lavaTree.m_adults[1]=new MonsterType("Cercyon",pes,ses,3,1,"Cercyon is a lavasnake that can wrap itself around its prey. Doing so cools it, thus damaging both itself and its victim",lavaTree.m_elders[1]);
		lavaTree.m_adults[2]=new MonsterType("Spither",pes,ses,3,2,"Spither is a lava elemental that is capable of casting both fire and water magic. The large center circle holds the lava crest, and the six outer circles alternate between the fire and water crests",lavaTree.m_elders[2]);
		lavaTree.m_adolescents=new MonsterType[3];
		lavaTree.m_adolescents[0]=new MonsterType("Crerops",pes,ses,2,0,"Creops is a man size titan with no face made of melting stone. lava flows to its heart at its center and back to the rock, his only weak point",lavaTree.m_adults[0]);
		lavaTree.m_adolescents[1]=new MonsterType("Erichthonius",pes,ses,2,1,"Erichthonius is a lizard the size of a wolf made of magma. It spits lava to attack",lavaTree.m_adults[1]);
		lavaTree.m_adolescents[2]=new MonsterType("Corynetes",pes,ses,2,2,"Corynetes is a floating sphere of lava, that pulses from yellow to orange hot. it has a cracked shell of earth around which the lava flows.",lavaTree.m_adults[2]);		
		lavaTree.m_infants=new MonsterType[1];
		lavaTree.m_infants[0]=new MonsterType("Philammon",pes,ses,1,0,"Philammon was the weakest of the suns of vulcan, and the monster derived from him resembles a green ball with orange eyes and horns",lavaTree.m_adolescents[0],lavaTree.m_adolescents[1],lavaTree.m_adolescents[2]);
		lavaTree.m_eggs=new MonsterType[1];
		lavaTree.m_eggs[0]=new MonsterType("Lava Egg",pes,ses,0,0,"The volcano egg is orange and very hot, with a glyph on its center of a mountain with lava pouring down it. It dries out quickly and is best left in water",lavaTree.m_infants[0]);
		bestiary[0][1]=lavaTree;
		
		ses=2;
		MonsterTree dinosaurTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		dinosaurTree.m_elders=new MonsterType[3];
		dinosaurTree.m_elders[0]=new MonsterType("Great White Tyrant",pes,ses,4,0,"A great White tyrant is a larger version of the tyrant that is as white as bone. It also  has arm claws now, although why it needs them when it has that huge jaw is anyones guess. Its a reference to Jurassic World");
		dinosaurTree.m_elders[1]=new MonsterType("EdgeWinger",pes,ses,4,1,"The EdgeWinger is an evolved SteelWinger, that shaved off the edges of the steel so that its really really sharp, and a much lighter weight, so it can fly again");
		dinosaurTree.m_elders[2]=new MonsterType("Broncheospikesaur",pes,ses,4,2,"A gigantic spikesaur that has a mass of hp and can taunt all enemies at once, but its physical attack is very weak");
		dinosaurTree.m_adults = new MonsterType[3];
		dinosaurTree.m_adults[0]=new MonsterType("Tyrant",pes,ses,3,0,"A tyrant is a giant raptor with big teeth and skimpy arms",dinosaurTree.m_elders[0]);
		dinosaurTree.m_adults[1]=new MonsterType("SteelWinger",pes,ses,3,1,"A larger winger with a steel beak and wings. The winger thought it would be cool to have steel, but it didnt account for the weight, which slowed it down and keeps it from flying",dinosaurTree.m_elders[1]);
		dinosaurTree.m_adults[2]=new MonsterType("Spikevorsaur",pes,ses,3,2,"A Spikevorsaure is a large herbivour that got wise and grew spikes. Now it taunts enemies, and when they attack, a portion of the damage inflicted is returned to the enemy",dinosaurTree.m_elders[2]);
		dinosaurTree.m_adolescents=new MonsterType[3];
		dinosaurTree.m_adolescents[0]=new MonsterType("Raptor",pes,ses,2,0,"A small velociraptor that is very fast and knows the move Dinobite",dinosaurTree.m_adults[0]);
		dinosaurTree.m_adolescents[1]=new MonsterType("Winger",pes,ses,2,1,"A winger is a flying dinosaur that looks like a bat except it has a cone head. Yeah, brutally honest.",dinosaurTree.m_adults[1]);
		dinosaurTree.m_adolescents[2]=new MonsterType("Herbisaur",pes,ses,2,2,"A Herbisaur is large for in adolescent, and has a lot of hp. It can make itself look like a target, effectively taunting them.",dinosaurTree.m_adults[2]);
		dinosaurTree.m_infants=new MonsterType[1];
		dinosaurTree.m_infants[0] = new MonsterType("Salamander",pes,ses,1,0,"The salamander is a small dinosaur that can breathe fire.",dinosaurTree.m_adolescents[0],dinosaurTree.m_adolescents[1],dinosaurTree.m_adolescents[2]);
		dinosaurTree.m_eggs=new MonsterType[1];
		dinosaurTree.m_eggs[0]=new MonsterType("Dino Egg",pes,ses,0,0,"Call John Hammond, it finally happened, were going to be millionares!!",dinosaurTree.m_infants[0]);
		bestiary[0][2]=dinosaurTree;
		
		ses=3;
		MonsterTree phoenixTree = new MonsterTree(pes,ses,typeNames[pes][ses]);	
		phoenixTree.m_elders=new MonsterType[1];
		phoenixTree.m_elders[0]=new MonsterType("Fenghuang",pes,ses,4,0,"The Fenghuang is the king of phoenixes. It is a symbol of hope for the fallen that they may rise again");
		phoenixTree.m_adults=new MonsterType[2];	
		phoenixTree.m_adults[0]=new MonsterType("Rock Cholk",pes,ses,3,0,"Large Chols are called Cholks. This one in particular loves its big rock, that it throws at people. It once paid a bill for a selfie, and was glad to do so",phoenixTree.m_elders[0]);
		phoenixTree.m_adults[1]=new MonsterType("FireEagle",pes,ses,3,1,"The Fire Eagle is an eagle on fire that can sream at its enemies",phoenixTree.m_elders[0]);
		phoenixTree.m_adolescents=new MonsterType[3];
		phoenixTree.m_adolescents[0]=new MonsterType("Chol",pes,ses,2,0,"The Chol is a violent Phoenix with a six foot wingspan. It has red plumage underneath its wings and on its torso and head. the top of its wings are an orange flame. Also, it can light its claws afire when it is angry and defending its flock",phoenixTree.m_adults[0]);
		phoenixTree.m_adolescents[1]=new MonsterType("Firebird",pes,ses,2,1,"The firebird is based in slavic folklore and is known for generating a bonfire for lost travlers, pointing them to safety",phoenixTree.m_adults[1]);
		phoenixTree.m_adolescents[2]=new MonsterType("Fawke",pes,ses,2,2,"The fawkes, or flaming hawkes are descended from a legendary phoenix who gave a boy a hat. They are colored from orange to yellow on their torso and underwing, followed by red on the upper wing. Alone among the phoenixes, they cannot light themselves aflame, or simply choose not to. They often cry for the wounded",phoenixTree.m_adults[1]);
		phoenixTree.m_infants=new MonsterType[1];
		phoenixTree.m_infants[0]=new MonsterType("Lesser Phoenix", pes,ses,1,0,"The Lesser Phoenix has yet to gain much plumage, although its eye sparkles with understanding when you speak to it, and when you caress it, its eye closes with love, and you feel hope.",phoenixTree.m_adolescents[0],phoenixTree.m_adolescents[1],phoenixTree.m_adolescents[2]);
		phoenixTree.m_eggs= new MonsterType[1];
		phoenixTree.m_eggs[0]= new MonsterType("Phoenix Egg", pes,ses,0,0,"The egg hovers slightly above the ground and is lit aflame by a fire that gives no heat",phoenixTree.m_infants[0]);
		bestiary[0][3]=phoenixTree;
		
		ses=4;
		MonsterTree justiceTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		justiceTree.m_elders=new MonsterType[2];
		justiceTree.m_elders[0]=new MonsterType("Zireal",pes,ses,4,0,"The Zireal is the angel of justice. Wears a white garb with a golden tassle. Blindfolded with a white cloth, but never misses. Weilds a sword in one hand and scales in the other");
		justiceTree.m_elders[1]=new MonsterType("Justicier",pes,ses,4,1,"The Justicier is a quiet robed figure, who can speak into the ears of the wicked. For her, the ends justify the means, and any means will be used to the betterment of mankind");
		justiceTree.m_adults=new MonsterType[2];
		justiceTree.m_adults[0]=new MonsterType("Ordinator",pes,ses,3,0,"The ordinator is a justicar who has served for its term as a city guard and now goes forth to right whatever wrong it sees. It stands in shining white steel platemail with a steel sheild edged in gold with a knee length white silk cape edgd in gold");
		justiceTree.m_adults[1]=new MonsterType("Anyr",pes,ses,3,1,"The Anyr is a judge that has been given the full authority of the church to act in the interest of the greater good in whatever way it thinks best. It can only be second guessed by a clergyman ranked bishop or higher. It has the ability to cast a spell that heals all light elementals and harms all dark elementals, but does not descriminate between friend and foe. It is loosely based on the amyr form Patrick Rothfuss' kingkiller chronicles. which you should read, by the way.");
		justiceTree.m_adolescents=new MonsterType[2];
		justiceTree.m_adolescents[0]=new MonsterType("Justicar",pes,ses,2,0,"The justicar appears as a lesser knight in shining chianmail and a golden crest upon its helm. It holds a wooden shield painted white in its left hand with an iron sword in its right. It has a cloth half cape edged in yellow. The justicar believes solidly in the rule of law and protects the weak. However, if it views the weak to be unvirtuous, it will leave them to suffer, believing that their karma will sort them out");
		justiceTree.m_adolescents[1]=new MonsterType("Ayurved",pes,ses,2,1,"The Ayurved is a healer that calls upon faith to direct the healing of its god. It is better at healing the virtuous, and refuses to touch the vile");
		justiceTree.m_infants=new MonsterType[1];
		justiceTree.m_infants[0]=new MonsterType("Angier",pes,ses,1,0,"The angier has a very sophomoric view of whats right and wrong, and when it percieves some slight against itself or its god, it runs up, quite childishly and demands satisfaction, regardless how much larger the villan is");
		justiceTree.m_eggs=new MonsterType[1];
		justiceTree.m_eggs[0]=new MonsterType("Justice Egg",pes,ses,0,0,"The egg white with a golden flame symbol in its center. When it is near you you are stronger in your convictions, and obsess over your sins, feeling regret and the desire to make things right");
		bestiary[0][4]=justiceTree;
		
		ses=5;
		MonsterTree vengenceTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		vengenceTree.m_elders=new MonsterType[1];
		vengenceTree.m_elders[0]=new MonsterType("Revenant",pes,ses,4,0,"The revenant wears black steel, outlined with sharp red lines. The full helm covers the entire head and has red horns, though wether these horns are a part of the helmet or the demon is unknown. It weilds a large sword that appears to be worn down and rusty, but shines when covered with the blood of the guilty. The helmet opens with a Y , where the top is curved");
		vengenceTree.m_adults=new MonsterType[2];
		vengenceTree.m_adults[0]=new MonsterType("Halfrec",pes,ses,3,0,"A Halfrec is a female vengence demon with bat wings. It is unforgiving, and believes itself to be doing what is right. They are slowly coming back after a 'buff' vampire slayer killed most of them",vengenceTree.m_elders[0]);
		vengenceTree.m_adults[1]=new MonsterType("D'Hoffry",pes,ses,3,1,"The D'Hoffry are male vengence angels with red wings. They are crueler than their cousins, the Halfrecs.",vengenceTree.m_elders[0]);
		vengenceTree.m_adolescents=new MonsterType[3];
		vengenceTree.m_adolescents[0]=new MonsterType("Jacobia",pes,ses,2,0,"The jacobia looks for all intents and purposes, a demon. It hates all the evil in the world with a passion. It represents the hotter, angrier side of vengence. It plans to kill them all but does not realize, after all the evil has been slain, it will still have one last murder to preform. It does bonus damage to creatures with a dark element, and less damage to creatures with a light element. Description inspiration: Death Note Season 1 episode 1",vengenceTree.m_adults[0]);		
		vengenceTree.m_adolescents[1]=new MonsterType("Letham",pes,ses,2,1,"A letham is a creature that once loved passionately and had its love taken away. It is patient and waits for the time to strike, resembling an emo teenager. Its name is an anagram of hamlet",vengenceTree.m_adults[0],vengenceTree.m_adults[1]);
		vengenceTree.m_adolescents[2]=new MonsterType("Lizebet",pes,ses,2,2,"It is a play on the Elizabethean revenge tragedy. She has an obsidian curving circlet on her forhead, coming to a point in the center of her brow. Her skin is ashen, her hair bloodred, her eyes, that only open when she casts spells, are yellow. She represents the quiet revenge, cold and calculated, and speaks seldom, then only in a whisper. To tell her allies why they failed her, at the summit of their deffeat",vengenceTree.m_adults[1]);
		vengenceTree.m_infants=new MonsterType[1];
		vengenceTree.m_infants[0]=new MonsterType("Spiten",pes,ses,1,0,"A spiten is a class of inferior imp that has needle like teeth, a bright red goblinesque body and black eyes.",vengenceTree.m_adolescents[0],vengenceTree.m_adolescents[1],vengenceTree.m_adolescents[2]);
		vengenceTree.m_eggs=new MonsterType[1];
		vengenceTree.m_eggs[0]=new MonsterType("Vengence Egg",pes,ses,0,0,"The egg is split in half, half red, half black, with a symmetric crest in the center. On the black side, the crest is in red, on the red side, the crest is in black. The crest itself looks like a flame, except wider than possible, and the end of the flame flicks into a cruel point. When it is near, you remember all the things that you love that were taken from you, the egg incites you to claim vengence. If broken, it casts a lesser curse on the breaker",vengenceTree.m_infants[0]);
		bestiary[0][5]=vengenceTree;
		
		//primary water
		pes=1;
		ses=0;
		MonsterTree steamTree = new MonsterTree(pes,ses,typeNames[0][1]);
		steamTree.m_elders = new MonsterType[1];
		steamTree.m_elders[0]=new MonsterType("Greater Steamlet",pes,ses,4,0,"The Greater steamlet is known only by the rare master that tries to collect them all, because its relatively useless and very hard to obtain. As you are reading this, you must have obtained it, so congradulations, you have found one of the most obscure elders. Sorry its not very useful in combat or anywhere else");
		steamTree.m_adults=new MonsterType[1];
		steamTree.m_adults[0]=new MonsterType("Steamlet",pes,ses,3,0,"The steamlet is a mature monster that no longer laughs at childish or raunchy jokes. As such, its soul is dead, and its not fun to be around, especially if its friends are older. It has uncommon yellow phosporous at its core",steamTree.m_elders[0]);
		steamTree.m_adolescents=new MonsterType[1];
		steamTree.m_adolescents[0]=new MonsterType("Lesser Steamlet",pes,ses,2,0,"The lesser steamlet is a slightly older steamlet that can breifly dissapate and come back together. Is it strategically advantageous? Probably only if your delaying for the ressurection of a phoenix. A larger amount of white phosporus is in its core",steamTree.m_adults[0]);
		steamTree.m_infants=new MonsterType[1];
		steamTree.m_infants[0]=new MonsterType("Minor Steamlet",pes,ses,1,0,"The lesser steamlet is a young demon made of steam. It cannot be harmed by physical attacks, but has very little health. A small amount of white phosporus drives its core, and if this phosporous is damaged, it will die quickly",steamTree.m_adolescents[0]);
		steamTree.m_eggs=new MonsterType[1];
		steamTree.m_eggs[0]=new MonsterType("Steam Egg", pes,ses,0,0,"Steam continually rises off of this egg. A nest of them are often put underneath a spa. They're not very nice to carry, because they drench whatever they are carried in in hot water. It also may be an obscure refrence to the foglets from the witcher series",steamTree.m_infants[0]);
		bestiary[1][0]=steamTree;
		
		ses=1;
		MonsterTree aquaTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		aquaTree.m_elders=new MonsterType[3];
		aquaTree.m_elders[0]=new MonsterType("Blue Dragon",pes,ses,4,0,"A blue dragon that lives under the sea. It is scaleless and can breath a water pulse at its enemies");
		aquaTree.m_elders[1]=new MonsterType("Aqua Atronach",pes,ses,4,1,"An Aqua Atronach is a collection of Elementals, a large one in the center with the five other elements represented as smaller elementals around the edge. When the Atronach wants to cast spells from other elements, it pulls that elemental into the center and channels its magic energy though both");
		aquaTree.m_adults = new MonsterType[3];
		aquaTree.m_adults[0]=new MonsterType("SliceFinn",pes,ses,3,0,"Slicefinn is a shark. A hammerhead shark whose front finn is sharpened steel",aquaTree.m_elders[0]);
//		aquaTree.m_adults[1]=new MonsterType("Kai",pes,ses,3,1,"The Kai is an old koi who has begun to turn golden",aquaTree.m_elders[0]);
		aquaTree.m_adults[1]=new MonsterType("Snugglerfish",pes,ses,3,1,"The Snugglerfish is a pair of cuddlefish that have attached and grown large. Its move is snuggle");
		aquaTree.m_adults[2]=new MonsterType("Aqua Elemental",pes,ses,3,2,"The Aqua Elemental is a large aqua symbol that has six crystallized water droplets on each of its six points",aquaTree.m_elders[1]);
		aquaTree.m_adolescents=new MonsterType[3];
		aquaTree.m_adolescents[0]=new MonsterType("EdgeFinn",pes,ses,2,0,"EdgeFinn is a larger version of the Minnow with a serrated crest and finns, as well as small, razor sharp teeth. unlike most fish, its eyes  face forward to stalk its prey, like the carnivores on land",aquaTree.m_adults[0]);
//		aquaTree.m_adolescents[1]=new MonsterType("Koi",pes,ses,2,1,"A large orange fish, whose face looks a bit like a chinese mystic, floating and calm",aquaTree.m_adults[1]);
		aquaTree.m_adolescents[1]=new MonsterType("Cuddlerfish",pes,ses,2,1,"A Cuddlerfish is shaped like a Cuttlefish but also loves cuddling. Thats why typically they come in pairs. They seperate infrequently, and when they do, both halves become very needy and inevitably float back together.",aquaTree.m_adults[1]);
		aquaTree.m_adolescents[2]= new MonsterType("Aquari",pes,ses,2,1,"A silver Taurus, with a sapphire sphere at its base. Etched on the Sapphire Sphere is the water Symbol. When it attacks, the crest apears in the center of the Taurus, and water drips from it. When one is near, calmness and complasency echoes in the mind.",aquaTree.m_adults[2]);
		aquaTree.m_infants=new MonsterType[1];
		aquaTree.m_infants[0]=new MonsterType("Minnow",pes,ses,1,0,"Minnow is a small blue fish with a green eye and finn. It floats in the air as if it were swimming in water. Why? How? Why did physics just suddenly stop working? BECAUSE I SAID SO. Thats why",aquaTree.m_adolescents[0],aquaTree.m_adolescents[1],aquaTree.m_adolescents[2]);
		aquaTree.m_eggs=new MonsterType[1];
		aquaTree.m_eggs[0]=new MonsterType("Aqua Egg",pes,ses,0,0,"The egg faintly glows cyan when left in water. It is a light blue perfect egg shape, with the water crest in dark blue emblazoned across it. When brought out of water it dries. If it dries enough to crack the monster inside may be close to death, however submerging it in water again and the shell will regenerate",aquaTree.m_infants[0]);
		bestiary[1][1]=aquaTree;
		
		ses=2;
		MonsterTree amphibiousTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		amphibiousTree.m_adults=new MonsterType[3];
		amphibiousTree.m_adults[0]=new MonsterType("Frogar",pes,ses,3,0,"The frogar is a giant toad witha spiked tongue that uses the tongue in combat. The tongue itself is as hard as iron. It wears a vest with an oriental 'Frog fu' symbol on it, which would make you think its great at martial arts, but its not. Its just trying to be cool");
		amphibiousTree.m_adults[1]=new MonsterType("Frogaudy",pes,ses,3,1,"The frogaudy is not only rainbow, it also sparkles. It found this fake diamond ring once, thought it was shiny and awesome, and its wardrobe has only gotten shinier since then. Now it has a golden hat and a monocole as well");
		amphibiousTree.m_adults[2]=new MonsterType("Esotoad", pes,ses,3,2,"The esotoads left arm is blue, and its right arm is green. With its left it has telekineic control over the water, with its right it has telekinetic control over the earth. It became too lazy to walk long ago, and now whenever it wants to go somewhere it will conjure a sphere of water to float in, or a mass of land to sit upon that it then guides to its destination");
		amphibiousTree.m_adolescents=new MonsterType[3];
		amphibiousTree.m_adolescents[0]=new MonsterType("Froget",pes,ses,2,0,"The Froget is a three foot tall frog that weilds a wooden spear. Its big black monochrome eyes stare into the deep darkness of the soul. Or so I've been told. I don't think its true actually, I just think its dumb.");
		amphibiousTree.m_adolescents[1]=new MonsterType("RainbowFrog",pes,ses,2,1,"The rainbow frog is a frog that is colored like a rainbow. It was nearly hunted to extinction by the leprechauns, but they gave up when they realized that it wasn't always sitting on a pot of gold. In fact, it never was. Poor dead rainbow Frogs...");
		amphibiousTree.m_adolescents[2]=new MonsterType("Frogami",pes,ses,2,2,"The frogami likes nothing better than to sit and meditate. It has mystic powers, and can see glimpses of the future. Licking its back is supposed to bring bad luck, which makes me wonder why anyone would do it, because its poisonous and causes hallucinations. And while your hallucinating, theres an angry magic frog annoyed that you licked its back. Or is that the hallucination? Little known fact: it was cut out of naruto because it was too cool for either jyria or Naruto to learn from");
		amphibiousTree.m_infants=new MonsterType[1];
		amphibiousTree.m_infants[0]=new MonsterType("Tapple",pes,ses,1,0,"The Tapple's parents were terrible at naming babies, so they asked the tapple what it would like to be called. It tried to say tadpole, but as it was a baby, it couldn't pronounce it properly. The name stuck. The tapple is blue-green and is very proud of its long double-finned tail. Its parents told it not to get too attached, but it did anyway");
		amphibiousTree.m_eggs = new MonsterType[1];
		amphibiousTree.m_eggs[0]= new MonsterType("Amphibious Egg",pes,ses,0,0,"The egg is a perfect sphere, blue and green with a lighter yolk in the center, seemingly unformed except for a black eve. the egg itself is happy in water or land, as the name implies");
		bestiary[1][2]=amphibiousTree;

		ses=3;
		MonsterTree weatherTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		weatherTree.m_elders=new MonsterType[2];
		weatherTree.m_elders[0]=new MonsterType("Thunderus",pes,ses,4,0,"The Thunderus is a lightening dragon that flies through the clouds. Its roar is frightening to behold");
		weatherTree.m_elders[1]=new MonsterType("Cumulonimbus",pes,ses,4,1,"The Cumulonimbus is a magical weather system that can cast two weather magics at once");
		weatherTree.m_adults=new MonsterType[5];
		weatherTree.m_adults[0]=new MonsterType("Nephol",pes,ses,3,0,"The nephol is a cloud dragon with a yellow head an claws and no wings because it can float. It breathes lightening at its enemies",weatherTree.m_elders[0]);
		weatherTree.m_adults[1]=new MonsterType("Cirricumulus",pes,ses,3,1,"The Cirricumulus is less concerned with rain and more concerned with air currents. It can cast air funnel which increases the damage of air-based attacks for the duration of the battle. In appearance its a greater wolf with a very long tail that is often wrapped around itself",weatherTree.m_elders[0]);
		weatherTree.m_adults[2]= new MonsterType("CumuloStratus",pes,ses,3,2,"The CumuloStratus can spread itself thin and use the water droplets that make up its mass as a lens to focus the sun on the battlefield, increasing fire and solar damage. However, it cannot attack while this is going on. In apperance it is rather formless, drifting high",weatherTree.m_elders[0],weatherTree.m_elders[1]);
		weatherTree.m_adults[3]= new MonsterType("Stratonimbus",pes,ses,3,3,"The StratoNimbus looks like an old goat when in corporeal form. It can change form to appear as a mist that surrounds the battlefield. When it does this, visibility is decreased for both sides, and water and ice attacks are strengthened",weatherTree.m_elders[1]);
		weatherTree.m_adults[4]=new MonsterType("NimbuloPonderant",pes,ses,3,4,"The Nimbuloponderant is a greater turtle that can cast heavy rain on the battlefield. The effect is the same as rain except 1.3 times stronger and weather attacks are strengthened",weatherTree.m_elders[1]);
		weatherTree.m_adolescents=new MonsterType[3];
		weatherTree.m_adolescents[0]=new MonsterType("Cumulus",pes,ses,2,0,"A towering cloud with a yellow wolfs head that has no compunction about gliding down and biting something with its thunderFang when annoyed",weatherTree.m_adults[0],weatherTree.m_adults[1],weatherTree.m_adults[2]);
		weatherTree.m_adolescents[1]=new MonsterType("Stratus",pes,ses,2,1,"The stratus is a cloud with a somber sheeps head that is very depressed and cries all the time. This is why it rains often when this particular cloud is out. It is highly against convective slavery, and even calls itself a free-convective.",weatherTree.m_adults[2],weatherTree.m_adults[3]);
		weatherTree.m_adolescents[2]= new MonsterType("Nimbus",pes,ses,2,2,"The nimbus basically looks like a floating turtle with glasses, except the shell is a cloud and the head is yellow with a lame curly loop for hair. Its glasses are black, how they float I don't know",weatherTree.m_adults[3],weatherTree.m_adults[4]);
		weatherTree.m_infants = new MonsterType[1];
		weatherTree.m_infants[0]=new MonsterType("Cirrus",pes,ses,1,0,"A small cloud that curves around like a snake. It has no mouth and a small blue diamond on its head, its body is covered by fog, and it is lighter than air.",weatherTree.m_adolescents[0],weatherTree.m_adolescents[1],weatherTree.m_adolescents[2]);
		weatherTree.m_eggs = new MonsterType[1];
		weatherTree.m_eggs[0] = new MonsterType("Weather Egg",pes,ses,0,0,"The weather egg has a grey surface with the weather crest (a circle with a cloud and thunderbold) emblazoned on the center. It will yeild if you push into it, it has a flexible shell, that seems to smoke, except the smoke is a very light color",weatherTree.m_infants[0]);
		bestiary[1][3]=weatherTree;
		
		ses=4;
		MonsterTree iceTree = new MonsterTree(pes,ses,typeNames[pes][ses]);	
		iceTree.m_elders=new MonsterType[5];
		iceTree.m_elders[0]=new MonsterType("Bearon",pes,ses,4,0,"The Beaorn is a great polar bear with silver plating chased blue.");
		iceTree.m_elders[1]=new MonsterType("Emperorguin",pes,ses,4,1,"The Emperorguin is the unquestioned leader of the guins and has red and yellow plumage to symbolize its authority. It has a passive ability that icreases the damage done by all ice attacks for the attackers side");
		iceTree.m_elders[2]=new MonsterType("WhiteRunner",pes,ses,4,2,"The white runner is one of the generals of the white army, and can move very quickly despite its monstrous size");
		iceTree.m_elders[3]=new MonsterType("Freezer",pes,ses,4,3,"The Freezer is a demon that can move swiftly through ice the same way fish swim through water. It is sneaky and will often appear behind enemies and stab them with its icicle");
		iceTree.m_elders[4]=new MonsterType("Ice Lich",pes,ses,4,4,"The Ice lich is the penultimate ice demon that has transformed itself into full lich form. As such, it is very hard to destroy");
		iceTree.m_adults=new MonsterType[5];
		iceTree.m_adults[0]=new MonsterType("Freki",pes,ses,3,0,"The freki is an ice wolf that has ice instead of fangs, its fur is white, and it is capable of using ice fang",iceTree.m_elders[0]);
		iceTree.m_adults[1]= new MonsterType("Kinguin",pes,ses,3,1,"The kinguin has distuinguished itself on the field of battle for the Emperorguin, and has been afforded territories as such. It has yellow plumage on its head that represents its crown, however it is nowhere near as robust as the Emperorguin's",iceTree.m_elders[1]);
		iceTree.m_adults[2]=new MonsterType("White Limper",pes,ses,3,2,"The white limper is an ice zombie that weilds a sword of ice and for some odd reason holds a grudge against people wearing black clothing, cloakes in particular",iceTree.m_elders[2]);
		iceTree.m_adults[3]=new MonsterType("Chiller",pes,ses,3,3,"the Chiller is a ice demon with a great ice trident, black horns and white-blue eyes that bore into the soul. Also a huge Michael Jackson fan, loves 'Thriller' in particular, but its rather tonedeaf, and thinks Michael is talking about it in the song.",iceTree.m_elders[3]);
		iceTree.m_adults[4]= new MonsterType("Ice Witch",pes,ses,3,4,"the Ice witch is exactly what it sounds like",iceTree.m_elders[4]);
		iceTree.m_adolescents=new MonsterType[3];
		iceTree.m_adolescents[0]=new MonsterType("FauxIce",pes,ses,2,0,"The FauxIce is a timid ice fox with a white pelt. It often makes ice sculptures of itself to decoy enemies. It can only do this once per battle though",iceTree.m_adults[0]);
		iceTree.m_adolescents[1]=new MonsterType("Princeguin",pes,ses,2,1,"The Princeguin is a young emperor penguin that has yet to prove its worth. In penguin society, blood means little, so though the Princeguin was born in the royal family, he still has work to do before being a contender for the throne",iceTree.m_adults[1]);
		iceTree.m_adolescents[2]=new MonsterType("IceBreaker",pes,ses,2,2,"The icebreaker is an ice demon with a staff that has a large snowflake on its crest. It casts cold magic, and is great at starting conversations with women, especilly at parties. It knows lots of good pick up lines and even more bad ones",iceTree.m_adults[2],iceTree.m_adults[3],iceTree.m_adults[4]);
		iceTree.m_infants=new MonsterType[1];
		iceTree.m_infants[0]=new MonsterType("Snoball",pes,ses,1,0,"The Snoball is a ball of snow, and no one can tell quite whats inside, as many different young snow creatures stay in the ball of snow until a teenager. It has the passive ability melt, which lessens the other teams fire abilities after it is slain",iceTree.m_adolescents[0],iceTree.m_adolescents[1],iceTree.m_adolescents[2]);
		iceTree.m_eggs=new MonsterType[1];
		iceTree.m_eggs[0]=new MonsterType("Ice Egg",pes,ses,0,0,"The Ice Egg has a snow glyph on its belly. The top and bottom of the egg are crested in frost, and the rest of the shell is a cool blue. When dropped in water, it will float to the surface and create an ice island around itself, it cannot do this indefinately, as cooling the matter around it takes energy from the baby inside, who cannot live in conditions much beyond freezing",iceTree.m_infants[0]);
		bestiary[1][4]=iceTree;
		
		ses=5;
		MonsterTree deepTree=new MonsterTree(pes,ses,typeNames[pes][ses]);
		deepTree.m_elders=new MonsterType[5];
		deepTree.m_elders[0]=new MonsterType("Kraken",pes,ses,4,0,"The Kraken is a sea monster that is capable of breaking ships with its limbs. Its a really dangerous giant squid. If you're having trouble picturing it, think Pirates of the Carribean, Dead mans chest");
		deepTree.m_elders[1]=new MonsterType("Hitokiristar",pes,ses,4,1,"The Hitokiristar is a ninja starfish that has other starfish underneath it, which it throws at its enemies");
		deepTree.m_elders[2]=new MonsterType("Abysstar",pes,ses,4,2,"The Abysstar moves through the water using magic that it puslates through its five arms. It can cast darkpressure on its enemies, who feel the hoplessness of being lost at the floor of the ocean being crushed by hundreds of thousands of pounds of water above them. It has many small places on the seafloor where it has placed  satanic rituals and it travels between them for unknown purposes");
		deepTree.m_elders[3]=new MonsterType("Hydoridolina",pes,ses,4,3,"The Hydoridolinia is actually a group of Hydroza and smaller jellyfish that comes together and is controlled by a single conscious mind.");
		deepTree.m_elders[4]=new MonsterType("Trachylina",pes,ses,4,4,"The Trachylina is an ascendent deep magical user that can use pressure pulse on all enemies");
		deepTree.m_adults=new MonsterType[6];
		deepTree.m_adults[0]=new MonsterType("Vasquid",pes,ses,3,0,"The Vasquid is a full-fledged giant sqid that is the size of a house when under water and considerably smaller when over land. Its tentacles are very strong and hard and can break even the most resilient bones. The only way to survive this fish is to dodge it",deepTree.m_elders[0]);
		deepTree.m_adults[1]=new MonsterType("Ninjastar",pes,ses,3,1,"The Ninjastar is a starish that gained sharp blades on its arms. To attack it throws itself at its enemies.",deepTree.m_elders[1]);
		deepTree.m_adults[2]=new MonsterType("Darkstar",pes,ses,3,2,"The Darkstar is a starish that became interested in black magic. its flesh has turned black in response, and it casts magic from the end of its five arms. Each end appears to be lit aflame with blue flame, but it is actual a chemical reaction",deepTree.m_elders[2]);
		deepTree.m_adults[3]=new MonsterType("Hydroza",pes,ses,3,3,"The Hydroza is a translucent (and nearly invisible in dark water) large jellyfish that constricts its prey and eats them alive. As the fish is translucent, it is the only known monster in which you can see a prey species being digested. It has poisonous spikes on the mandibles with which it attacks its prey",deepTree.m_elders[3]);
		deepTree.m_adults[4]=new MonsterType("Stauroza",pes,ses,3,4,"The Stauroza is a large opaque black jellyfish that has a white star on the inside of the top of its bell. It can direct this light like a flashlight onto unsuspecting prey that swim towards the light, unaware that the Stauroze is about to devour them",deepTree.m_elders[4]);
		deepTree.m_adults[5]=new MonsterType("Scyphozoa",pes,ses,3,5,"The bell of the Scyphozoa is rings of Black and dark blue. It can form glyphs with its arms, with which it casts spells. The skill related to it is inksign, which lowers accuracy to water types, and deals damage",deepTree.m_elders[4]);
		deepTree.m_adolescents=new MonsterType[3];
		deepTree.m_adolescents[0]=new MonsterType("Inker",pes,ses,2,0,"The inker is a baby giant squid (in other words, a squid) that squirts ink in the eyes of its enemies, lowering their accuracy",deepTree.m_adults[0]);
		deepTree.m_adolescents[1]=new MonsterType("Starish",pes,ses,2,1,"The Starish is called so because it is kinda like a star except its also a fish",deepTree.m_adults[1],deepTree.m_adults[2]);
		deepTree.m_adolescents[2]=new MonsterType("jelly",pes,ses,2,2,"The jelly is a small fish that is bell shaped and floats around. It wraps its tail around its enemies to sting them",deepTree.m_adults[3],deepTree.m_adults[4],deepTree.m_adults[5]);
		deepTree.m_infants = new MonsterType[1];
		deepTree.m_infants[0]=new MonsterType("Deepfish",pes,ses,1,0,"The deepfish is a small fish used to the echoes of the darkness. Its face is sunken, its scales are dark and ruddy, the spines of its fin are black, but the webbing is blue",deepTree.m_adolescents[0],deepTree.m_adolescents[1],deepTree.m_adolescents[2]);
		deepTree.m_eggs=new MonsterType[1];
		deepTree.m_eggs[0]=new MonsterType("Deep Egg",pes,ses,0,0,"The deep egg is used to being shrouded in the darkness of the deep, and is nearly unbreakable, as it is used to the pressure on the bottom of the seafloor. It can regulate its internal pressure. When another primary water elemental is in play, its defense rises by half again",deepTree.m_infants[0]);
		bestiary[1][5]=deepTree;

		//primary earth
		pes=2;
		ses=0;
		MonsterTree fairyTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		fairyTree.m_elders=new MonsterType[3];
		fairyTree.m_elders[0]=new MonsterType("Metafilthy Poshprechaun",pes,ses,4,0,"The Poshprechaun is metaphorically filthy because its stinking rich. Instead of the classic black suit and bow tie duds, they're solid gold thread");
		fairyTree.m_elders[1]=new MonsterType("Elder Elf",pes,ses,4,1,"The elder elf also has long facial hair and is bald");
		fairyTree.m_elders[2]=new MonsterType("Shamage",pes,ses,4,2,"The Shamage has mastered hermitic magic and has vast experience delievering babies, healing livesock and curing curses on the farmsfolk that it lives near. Or is very good at pretending to anyway, very convincing. At least enough to keep getting money from them. Bastard");
		fairyTree.m_adults=new MonsterType[3];
		fairyTree.m_adults[0]=new MonsterType("Poshprechaun",pes,ses,3,0,"The Poshprechaun has gotten some money, and now wears a blazer with tails, a monocole and a tophat with a sash. Its attacks damage is based on how  much money the owner has",fairyTree.m_elders[0]);
		fairyTree.m_adults[1]=new MonsterType("Tallf",pes,ses,3,1,"The is an elf that is tall",fairyTree.m_elders[1]);
		fairyTree.m_adults[2]=new MonsterType("Shaman",pes,ses,3,2,"The shaman has a necklace of bones and a hat because hes bald",fairyTree.m_elders[2]);
		fairyTree.m_adolescents= new MonsterType[3];
		fairyTree.m_adolescents[0]=new MonsterType("Poorprechaun",pes,ses,2,0,"The poorprechaun is a leprechaun who has lost its pot of gold. As the leprechauns are a people who base worth on how much gold one has, this little guy is a little down on his luck",fairyTree.m_adults[0]);
		fairyTree.m_adolescents[1]=new MonsterType("Aos si",pes,ses,2,1, "The Aos si is a lesser elf about 4 foot tall that wears sage and whose skin has a greenish hue",fairyTree.m_adults[1]);
		fairyTree.m_adolescents[2]=new MonsterType("Shaboy",pes,ses,2,2,"The shaboy is an inexperienced shaman, whose collar of bones is unfinished and has only peach fuzz where the requisite beard should be.",fairyTree.m_adults[2]);
		fairyTree.m_infants=new MonsterType[1];
		fairyTree.m_infants[0]= new MonsterType("Sprite",pes,ses,1,0,"The sprite is about nine inches tall, and three of those inches are a ridiculously large brown hat, wizard style with a black belt and a golden buckle. it has a mischeveous face with a big red ruddy nose and is always smiling. It is wearing a green frock and brown pointed boots with a black strap and gold buckle. The hem of the green frock is cut into right angles. It can fly, obviously, and enjoys casting mischevious magic. Its personality is similar to everyone's annoying little brother",fairyTree.m_adolescents[0],fairyTree.m_adolescents[1],fairyTree.m_adolescents[2]);
		fairyTree.m_eggs=new MonsterType[1];
		fairyTree.m_eggs[0]=new MonsterType("Fairy Egg",pes,ses,0,0,"The fairy egg has mystical fey energy surrounding it in whisps and sparkling. The top 1/4 is gree, the bottom 1/4 is red and in the middle is a gradient between the two. in the center of the egg is the fairy crest",fairyTree.m_infants[0]);
		bestiary[2][0]=fairyTree;
		
		ses=1;
		MonsterTree swampTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		swampTree.m_elders=new MonsterType[2];
		swampTree.m_elders[0]=new MonsterType("Slougtter",pes,ses,4,0,"The Sloughtter is a huge Slough in the shape of an otter. And it once killed a lot of people.");
		swampTree.m_elders[1]=new MonsterType("Wills of the Wisps",pes,ses,4,1,"The Wills o' the Wisps are a collection of Wills o' the Wisp. As an original Wills o' the Wisp is kinda flaky, the collection of them is frankly insane. It can inflict this on its enemies as well, at least when its cohescient");
		swampTree.m_adults=new MonsterType[2];
		swampTree.m_adults[0]=new MonsterType("Slough",pes,ses,3,0,"The Slough is an ogre that haunts in the swamp. It can sink underwater and often grabs enemies and pulls them down. It is covered in twigs and muck",swampTree.m_elders[0]);
		swampTree.m_adults[1]=new MonsterType("Wills o' the Wisp",pes,ses,3,1,"The Wills o' the Wisp is a rather unfortunate sprite that has lots of wills set in a single body. Its confusing to talk to, to say the least",swampTree.m_elders[1]);
		swampTree.m_adolescents=new MonsterType[2];
		swampTree.m_adolescents[0]=new MonsterType("Otter",pes,ses,2,0,"The Otter is an otter, as clearly the game designer ran out of ideas.",swampTree.m_adults[1]);//TODO fix this please, when you're more inventive
		swampTree.m_adolescents[1]=new MonsterType("Will o' the Wisp",pes,ses,2,1,"The Will o' the Wisp is a swamp sprite that floats around and guides the wayward home. If its in a good mood. Otherwise, it just confuses them.",swampTree.m_adults[0]);
		swampTree.m_infants=new MonsterType[1];
		swampTree.m_infants[0]=new MonsterType("Boggart",pes,ses,1,0,"The Boggart lives cheifly in bogs and haunts them",swampTree.m_adolescents[0],swampTree.m_adolescents[1]);
		swampTree.m_eggs=new MonsterType[1];
		swampTree.m_eggs[0]= new MonsterType("Swamp Egg",pes,ses,0,0,"The swamp egg is best left in brackish water",swampTree.m_infants[0]);
		bestiary[2][1]=swampTree;
		
		ses=2;
		MonsterTree teraTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		teraTree.m_elders=new MonsterType[6];
		teraTree.m_elders[0]=new MonsterType("Honey BadgeBear",pes,ses,4,0,"The only thing scarier than a Honey Badger is one that mutated into a huge bear that still has its markings. It really loves honey. Like crazy");
		teraTree.m_elders[1]=new MonsterType("Sagewolf",pes,ses,4,1,"The Sagewolf is an elder greenwolf with an eyepatch.");
		teraTree.m_elders[2]=new MonsterType("Flourisyana",pes,ses,4,2,"The Flourisyana is a large pale green wolf that has magic bladed flowers that it thows at enemies");
		teraTree.m_elders[3]=new MonsterType("Tenured Professtrig",pes,ses,4,1,"The professtrid has tenure, thus doesn't actually have to work anymore and can do whatever it wants. It also has a stare that can put someone in their place");
		teraTree.m_elders[4]=new MonsterType("Tree Hugger Hugger Tree",pes,ses,4,4,"The Tree Hugger Hugger Tree is a tree that loves hugging, especially tree huggers, which is fortunate, because only tree huggers hug trees.");
		teraTree.m_elders[5]=new MonsterType("Tera Atronach",pes,ses,4,5,"A large tera elemental surrounded by the elementals representing all other primary elements");
		teraTree.m_adults= new MonsterType[6];
		teraTree.m_adults[0]=new MonsterType("Honey Badger",pes,ses,3,0,"My only advice to you is not to mess with the honey badger. He was once locked up in vietcong prison for being a badass, and all they wanted him to do is poop. BUT HONEY BADGER DON'T CARE! HONEY BADGER DON'T GIVE A SHIT. credit for the idea belongs to: https://www.youtube.com/watch?v=4r7wHMg5Yjg",teraTree.m_elders[0]);
		teraTree.m_adults[1]=new MonsterType("Greenwolf",pes,ses,3,1,"The ChapparWolf has hardened the ends of its vines into bark. Its fur has begun turning green",teraTree.m_elders[1]);
		teraTree.m_adults[2]=new MonsterType("Flowering Aiyana",pes,ses,3,2,"The Aiyana now has flowers growing over its body. It attacks with fragrant fumes from its flowers. Its fur is all white",teraTree.m_elders[2]);
		teraTree.m_adults[3]=new MonsterType("Professtrig",pes,ses,3,1,"The trig went to college and became a professor which is why he has big white bushy eyebrows and moustache. His most damaging attack is assigning math homework which deals more damage the closer the intelligence is to 5 because if its much lower than that it doesn't care and much higher and its easy",teraTree.m_elders[3]);
		teraTree.m_adults[4]=new MonsterType("Hugger Tree",pes,ses,3,2,"The hugger tree is a tree with two dedicated branches toward hugging and protecting people. It looks like it has a smile carved in its bark, but it actually just grew that way",teraTree.m_elders[4]);
		teraTree.m_adults[5]=new MonsterType("Tera Elemental",pes,ses,3,2,"A large tera symbol surrounded by a dark symbol, a fire symbol and a water symbol",teraTree.m_elders[5]);
		teraTree.m_adolescents= new MonsterType[5];
		teraTree.m_adolescents[0]= new MonsterType("BadgeBadger",pes,ses,2,0,"The BadgeBadger is really pround of it badge. It shines it every day until it almost sparkles. How did it get the badge? Dont ask questions, this is a fantasy. Maybe it found it. Or less likely beat up a cop and stole it. And that's unlikely because there are no cops in this universe",teraTree.m_adults[0]);
		teraTree.m_adolescents[1]=new MonsterType("VineWolf",pes,ses,2,1,"The vinewolf's bulb sprounted into vines that encircle it. Often while hunting it will use  the vines to hold down its prey while it goes in for the kill. It can also wrap its vines around an unsuspecting opponent, at a great cost to the agility of both creatures",teraTree.m_adults[1]);
		teraTree.m_adolescents[2]= new MonsterType("Aiyana", pes,ses,2,2,"The aiyana is a calm relaxed wolf with a flower on its back. In the center of the flower is the yin yang, a symbol for balance. It often lays in the grass, and enjoys watching the plants grow and flower around it. It has a passive ability that strengthens all moves by plant types by 10%",teraTree.m_adults[2]);
		teraTree.m_adolescents[3]=new MonsterType("Trig",pes,ses,2,3,"A small nerdy twig that just loves math. It can recite all of the mathematical properties up to vector calclus off of the top of its head, it especially loves sine, cosine and tangent. It always remembers to bring an apple for the teacher. It cant see very well (as it lacks eyes) and thus keeps its bifocals on at all times",teraTree.m_adults[3],teraTree.m_adults[4]);
		teraTree.m_adolescents[4]=new MonsterType("Tera Symbol",pes,ses,2,5,"The Tera Symbol is a green taurus with the earth symbol it its center",teraTree.m_adults[5]);
		teraTree.m_infants=new MonsterType[3];
		teraTree.m_infants[0]=new MonsterType("Babadger", pes,ses,1,0,"The Babadger lures its enemies close with its cuteness, and then slashes them viciously when they're exposed. But its only enemies are its fellow babadger pups, which is why its parents seperate them at birth",teraTree.m_adolescents[0],teraTree.m_adolescents[4]);
		teraTree.m_infants[1]=new MonsterType("Bulbapup",pes,ses,1,1,"A small, energetic puppy with a large bulb on its back, resembling an onion. It loves to jump around, but when it does so it is rather comical, as the weight of the bulb often makes it fall over. Its bark is adoable. And its not a refrence to Bulbasaur from Pokemon. At all.",teraTree.m_adolescents[1],teraTree.m_adolescents[2],teraTree.m_adolescents[4]);
		teraTree.m_infants[2]=new MonsterType("Stiket",pes,ses,1,2,"The sticket pretends to be magical but isn't. Its very depressing huh? Its basically just a small stick that can move on its own. But its very good at listening, probably because it cant talk. If it could though it would always advise revenge by saying 'Sticket to em!'",teraTree.m_adolescents[3],teraTree.m_adolescents[4]);		
		teraTree.m_eggs=new MonsterType[1];
		teraTree.m_eggs[0]=new MonsterType("Tera Egg",pes,ses,0,0,"A brown Egg that looks a lot like a clod of dirt except for the glowing green earth crest etched onto its surface. It is heavy and when placed in the grass, the grass grows and circles around it, as if coushining it.",teraTree.m_infants[0],teraTree.m_infants[1],teraTree.m_infants[2]);
		bestiary[2][2]=teraTree;
		
		
		bestiary[2][3]=definePegasusMonsterTypes();
		bestiary[2][4]=defineCompassionMonsterTypes();
		bestiary[2][5]=defineRottenMonsterTypes();
		
		//primary Air
		bestiary[3][0]=defineSandsMonsterTypes();
		bestiary[3][1]=defineSeaBreezeMonsterTypes();
		bestiary[3][2]=defineBirdsMonsterTypes();
		bestiary[3][3]=defineAeroMonsterTypes();
		bestiary[3][4]=defineCockaMonsterTypes();
		bestiary[3][5]=defineNightWingMonsterTypes();

		
		//primary Light
		bestiary[4][0]=defineSolarMonsterTypes();
		bestiary[4][1]=defineLunarMonsterTypes();
		bestiary[4][2]=defineGuardianMonsterTypes();
		bestiary[4][3]=defineHolyMonsterTypes();
		bestiary[4][4]=defineLuxorMonsterTypes();
//		bestiary[4][5]=defineRedemptionMonsterTypes();
//		
//		//primary Dark
//		bestiary[5][0]=defineDemonicMonsterTypes();
//		bestiary[5][1]=definePoisonMonsterTypes();
//		bestiary[5][2]=defineUndeadMonsterTypes();
//		bestiary[5][3]=defineStormMonsterTypes();
//		bestiary[5][4]=defineBetrayerMonsterTypes();
//		bestiary[5][5]=defineUmbralMonsterTypes();
		return bestiary;
	}
	public static void plot()
	{
		System.out.println("A terrible, senseless war streches out in every direction/n"
						+ "Gore flies, and blood paints the walls\n"
						+ "You stand witness to a million atrocities each more soul wrenching than the last/n"
						+ "But worst is the knowledge that this should not be,\n"
						+ "That all the fighters are good men,\n"
						+ "Brought low by greedy kings"
						+ "But even this is not what chills your soul");
		myScanner.next();
		System.out.println("Above the chaos, on the crest of the mountain, looms a dark figure\n"
						+ "its skin is pale, as if its never seen the sunlight/n"
						+ "A dark satin cloak hangs from broad shoulders\n"
						+ "An obsidain ring clenches its finger\n"
						+ "Its surface an ocean at storm\n"
						+ "Its eyes are cut in slits and burn in red fire\n"		
						+ "Its mouth curls into a cruel grin\n"
						+ "And his laugh sounds like pain as it echoes through the world\n");
		myScanner.next();
		System.out.println("Oh my god son, are you alright? You were screaming!\n\n");
		System.out.println("1)yes father I'm fine just a nightmare\n2)Dad help it hurts!");
		int choice = myScanner.nextInt();
		
		
	}
	public static void defineTypes()
	{
		typeNames[0][0]="Pyro";//fire primary, Fire Secondary
		typeNames[0][1]="Lava";//fire primary, water secondary				WORK
		typeNames[0][2]="Dinosaur";//fire primary, earth secondary
		typeNames[0][3]="Phoenix";//fire primary, air secondary
		typeNames[0][4]="Justice";//fire primary, light secondary
		typeNames[0][5]="Vengence";//fire primary, dark secondary
		typeNames[1][0]="Steam";//Water primary, Fire Secondary		BAD
		typeNames[1][1]="Aqua";//Water Primary, Water Secondary
		typeNames[1][2]="Amphibious";//Water Primary, Earth Secondary		WORK
		typeNames[1][3]="Weather";//Water Primary, Air secondary
		typeNames[1][4]="Ice";//Water Primary, Light Secondary
		typeNames[1][5]="Deep";//Water Primary, Dark Secondary
		typeNames[2][0]="Fairy";//Earth Primary, Fire Secondary
		typeNames[2][1]="Swamp";//Earth Primary, Water Secondary
		typeNames[2][2]="Tera";//Earth Primary, Earth Secondary
		typeNames[2][3]="Pegasus";//Earth Primary, Wind Secondary			WORK
		typeNames[2][4]="Compassion";//Earth Primary, Light Secondary, focus healing
		typeNames[2][5]="Rotten";//Earth Primary, Dark Secondary
		typeNames[3][0]="Sands";//Wind Primary, Fire secondary, focus egypt, desert
		typeNames[3][1]="SeaBreeze";//Wind Primary, Water secondary focus 
		typeNames[3][2]="Birds";//Wind Primary, earth secondary
		typeNames[3][3]="Aero";//Wind Primary/secondary
		typeNames[3][4]="Cocka";//Wind Primary Light Secondary
		typeNames[3][5]="Nightwing";//Wind Primary Dark Secondary
		typeNames[4][0]="Solar";//Light Primary, Fire Secondary
		typeNames[4][1]="Lunar";//Light Primary, Water Secondary
		typeNames[4][2]="Guardian";//Light Primary, Earth Secondary-taunts enemies, support
		typeNames[4][3]="Holy";//Light Primary,  Air secondary
		typeNames[4][4]="Luxor";//Light Primary/secondary
		typeNames[4][5]="Redemption";//Light Primary, dark secondary
		typeNames[5][0]="Demonic";//Dark Primary, Fire Secondary
		typeNames[5][1]="Poison";//Dark Primary, Water Secondary
		typeNames[5][2]="Undead";//Dark Primary, Earth Secondary
		typeNames[5][3]="Storm";//Dark Primary, Air Secondary, dark version of weather
		typeNames[5][4]="Betrayer";//Dark Primary, light secondary, fallen angels etc
		typeNames[5][5]="Umbral";//Shadowed creatures
	}

	public static MonsterTree definePegasusMonsterTypes()
	{
		pes=2;
		ses=3;
		MonsterTree pegasusTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		pegasusTree.m_elders=new MonsterType[2];
		pegasusTree.m_elders[0]=new MonsterType("Greater Pegasus",pes,ses,4,0,"This pegasus is fully awesome. If an ancient greek hero needs a flying steed, this guy shows up. But only if the hero is Bellerophon. BECAUSE HERCULES NEVER RODE PEGASUS DISNEY!!!");
		pegasusTree.m_elders[1]=new MonsterType("Flying Forest",pes,ses,4,1,"The flying forest is a group of wingtrees. It doesnt' have enough lift from its levitation though, so it has birds hang on and flap as hard as they can");
		pegasusTree.m_adults= new MonsterType[2];
		pegasusTree.m_adults[0]=new MonsterType("Pegasus",pes,ses,3,0,"Pegasus is glad that its no longer a lesser pegasus, because lets face it, those teenage years sucked. Now he can fly but he cant carry anyone. Especially heores in armor. Are you kidding me? Its already areodynamically impossible for a horse to fly and now you want to add a two hundred pound hero with 300 pounds of armor? not to mention loot? Not on my back",pegasusTree.m_elders[0]);
		pegasusTree.m_adults[1]=new MonsterType("Wing Tree",pes,ses,3,1,"The wingTree loved watching WW1 films and always wanted to be a wingman. However, its not a man, its a tree. So it settled for the next best thing. Somehow he got ahold of some avatior goggles, and put them on his trunk because he doesnt have eyes. But it makes him look cool, so no one calls him on it. Also it bears saying that this is the guy you want to bring with you to tree parties, he can make you look SOOO good in front of the female trees.",pegasusTree.m_elders[1]);
		pegasusTree.m_adolescents = new MonsterType[2];
		pegasusTree.m_adolescents[0]=new MonsterType("Lesser Pegasus",pes,ses,2,0,"Lesser Pegasus is a little depressed. I mean the baby pegases didn't mind that it was called minor becasuse its a baby. But Lesser pegasus knows what theyre saying, and its really akward and its just sad... But atleast its front hooves dont look like trees anymore! It also cant fly to its undending shame, all the other pegasus laugh at it... Its a hard life",pegasusTree.m_adults[0]);
		pegasusTree.m_adolescents[1]=new MonsterType("Sapwing",pes,ses,2,1,"The sapwing is a tree that wanted to be a bird. Now its converted its leaves into semi feathers and can hop along the ground some if it tries real hard.",pegasusTree.m_adults[1]);
		pegasusTree.m_infants = new MonsterType[1];
		pegasusTree.m_infants[0]= new MonsterType("Minor Pegases",pes,ses,1,0,"Half horse, half plant half bird... Or wait, is that too many halves? Its front two legs are treeish, while the torso, head and back legs are a horse and it has wings. Dont look at me, you've all seen Hercules! Its like that except the two front legs are treeish. And its the reaally cute baby form, obviously",pegasusTree.m_adolescents[0],pegasusTree.m_adolescents[1]);
		pegasusTree.m_eggs=new MonsterType[1];
		pegasusTree.m_eggs[0]=new MonsterType("Pegasus Egg",pes,ses,0,0,"The Pegasus egg shows a natural affinity for both the air and the earth. However, the part of it that is psyched about flying is on the bottom half, and the part that enjoys the ground is on the top half. So it balances upside down. People say it looks ridiculous, but eggs cant hear sooo...",pegasusTree.m_infants[0]);
		return pegasusTree;
	}
	public static MonsterTree defineCompassionMonsterTypes()
	{
		pes=2;
		ses=4;
		MonsterTree compassionTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		compassionTree.m_elders=new MonsterType[2];
		compassionTree.m_elders[0]=new MonsterType("Shaolin",pes,ses,4,0,"The Sholin is an elder monk that can despense wisdom to buff allies");
		compassionTree.m_elders[1]=new MonsterType("Mother Theres",pes,ses,4,1,"A female elder monk that can sacrifice herself to heal all alies to full health, even if they are fallen");
		compassionTree.m_adults=new MonsterType[2];
		compassionTree.m_adults[0]=new MonsterType("Bodisatva",pes,ses,3,0,"The Bodisatva is now an experienced mond, that has a healing palm that deals damage to enemies and heals allies",compassionTree.m_elders[0]);
		compassionTree.m_adults[1]=new MonsterType("Theresatva",pes,ses,3,1,"The Theresatva is self sacrificing, and can give half of her own vital energy to ressurect the fallen to half health",compassionTree.m_elders[1]);
		compassionTree.m_adolescents=new MonsterType[2];
		compassionTree.m_adolescents[0]=new MonsterType("Bodisat",pes,ses,2,0,"The Bodisat is a young monk that was trained by the shaolin, and can strike with a sacred palm",compassionTree.m_adults[0]);
		compassionTree.m_adolescents[1]=new MonsterType("Theresat",pes,ses,2,1,"The Theresat is a bald young female healer that heals through forgiveness. She heals quite a bit, but a third is applied to the opposing team",compassionTree.m_adults[1]);
		compassionTree.m_infants=new MonsterType[1];
		compassionTree.m_infants[0]=new MonsterType("Buddi",pes,ses,1,0,"A Buddi is a young enlighted being who can heal through compassion, and will heal both the virtuous and the vengeful, it looks like a buddhist mask",compassionTree.m_adolescents[0],compassionTree.m_adolescents[1]);
		compassionTree.m_eggs=new MonsterType[1];
		compassionTree.m_eggs[0]=new MonsterType("Compassion Egg",pes,ses,0,0,"The Compassion Egg has a bright green cross on its shell to show that is will grow into a healer",compassionTree.m_infants[0]);
		return compassionTree;
	}
	public static MonsterTree defineRottenMonsterTypes()
	{
		pes=2;
		ses=5;
		MonsterTree rottenTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		rottenTree.m_elders=new MonsterType[1];
		rottenTree.m_elders[0] = new MonsterType("BeePee",pes,ses,4,0,"The BeePee floods toxic sludge all over the opponents battlefield which ignites when hit with fire, dealing massive damage");
		rottenTree.m_adults = new MonsterType[1];
		rottenTree.m_adults[0] = new MonsterType("Flint",pes,ses,3,0,"The Flint coughs on its enemies and continually releases methane, it explodes when attacked by fire dealing a large amount of damage to all sides",rottenTree.m_elders[0]);
		rottenTree.m_adolescents = new MonsterType[1];
		rottenTree.m_adolescents[0] = new MonsterType("Smaugh",pes,ses,2,0,"The Smaugh is a Sewer demon covered in refuse",rottenTree.m_adults[0]);
		rottenTree.m_infants=new MonsterType[1];
		rottenTree.m_infants[0]=new MonsterType("Sewerat",pes,ses,1,0,"The Sewerat is a rather large rat that smells terrible.",rottenTree.m_adolescents[0]);
		rottenTree.m_eggs=new MonsterType[1];
		rottenTree.m_eggs[0]=new MonsterType("Rotten Egg",pes,ses,0,0,"The Rotten egg infects those around it with disease",rottenTree.m_infants[0]);
		return rottenTree;
	}
	public static MonsterTree defineSandsMonsterTypes()
	{
		pes=3;
		ses=0;
		MonsterTree sandTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		sandTree.m_elders=new MonsterType[3];
		sandTree.m_elders[0]=new MonsterType("Greater Sphynx",pes,ses,4,0,"The greater Sphynx is a very large sphyix with haunting eyes that also speaks in riddles and analogies but has large folded wings along its back. It cant fly with them, but when it spreads them out, it looks very intimidaing. The feathers also alternate between jade and torquoise, so the Greater Sphynx was once hunted for its wings. But then it killed and ate all the hunters, so that was over pretty quickly");
		sandTree.m_elders[1]=new MonsterType("Scorpious",pes,ses,4,1,"The Scorpious is a descendant of the giant Scorpion that killed Orion.");
		sandTree.m_elders[2]=new MonsterType("Bihump",pes,ses,4,2,"The Bihump has mystical powers and can cast greater sandstorm that does no damage to sand creatrues, small damage to fire and air primary creatures and more damage to all other creatures each turn");
		sandTree.m_adults=new MonsterType[3];
		sandTree.m_adults[0]=new MonsterType("Sphynx",pes,ses,3,0,"The Sphynx has the head of a man and the body of a lion, like the Slynx it evolved from, it speaks only in riddles, however these riddles are more difficult",sandTree.m_elders[0]);
		sandTree.m_adults[1]=new MonsterType("Scarpi",pes,ses,3,1,"A Scarpi is a large scorpion whose plates have turned into armor, although they do bear scars from its earlier encounters. It is named after the fabled storyteller who is credited for the creation of its myth. Obviously it wasn't a myth",sandTree.m_elders[1]);
		sandTree.m_adults[2]=new MonsterType("Unihump",pes,ses,3,2,"A unihump is a camel with a single hump. It stores water in this hump obviously and can cast sandstorm with its mind",sandTree.m_elders[2]);
		sandTree.m_adolescents=new MonsterType[3];
		sandTree.m_adolescents[0]=new MonsterType("Slynx",pes,ses,2,0,"A Slynx is a mythical sand cat that has haunting eyes and can speak, but only speaks in riddles. Whenever asked a question, it anwsers with another question, usually pointing at the right answer. If the Slynx has no clue though, it will just repeat the question asked of it, it is about the size of a mountain lion",sandTree.m_adults[0]);
		sandTree.m_adolescents[1]=new MonsterType("Skorpi",pes,ses,2,1,"A Scorpi is a small scorpion that is red and very poisonous",sandTree.m_adults[1]);
		sandTree.m_adolescents[2]=new MonsterType("Humpless",pes,ses,2,2,"A humpless is a sad camel without a hump. It can magically control the sand with its mind, and keeps some in the gourd across its back",sandTree.m_adults[2]);
		sandTree.m_infants=new MonsterType[1];
		sandTree.m_infants[0]=new MonsterType("Kangarat",pes,ses,1,0,"The Kangarat is a small rodent that can spend its whole life without having to drink any water. It takes no damage from sandstorm",sandTree.m_adolescents[0],sandTree.m_adolescents[1],sandTree.m_adolescents[2]);
		sandTree.m_eggs=new MonsterType[1];
		sandTree.m_eggs[0]=new MonsterType("Sands Egg",pes,ses,0,0,"The Sands Egg has a sandy shell with the sand logo printed on it",sandTree.m_infants[0]);
		return sandTree;
	}
	public static MonsterTree defineSeaBreezeMonsterTypes()
	{
		pes=3;
		ses=1;
		MonsterTree seaBreezeTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		seaBreezeTree.m_elders = new MonsterType[2];
		seaBreezeTree.m_elders[0]=new MonsterType("Heligull",pes,ses,4,0,"The Heligull's wings rotate above it like a helicopter. It dives deep into the water to find prey. It can hold its breath for up to 4 hours, and spends almost as much time above water as within");
		seaBreezeTree.m_elders[1]=new MonsterType("Soarfish",pes,ses,4,1,"The Soarfish has adapted gulls that allow it to breath both water and air. It has no need to go under water and preys on small birds. However it usually stays near the water to feed its children who cannot fly as well");
		seaBreezeTree.m_adults=new MonsterType[2];
		seaBreezeTree.m_adults[0]=new MonsterType("Peligull",pes,ses,3,0,"The pelligull is a large gull with  a great gullet. When there are fish near the surface of the water, it will dive in and open its large mouth. When it surfaces again it spits out the water but retains the fish in its mouth",seaBreezeTree.m_elders[0]);
		seaBreezeTree.m_adults[1]=new MonsterType("Flyfish",pes,ses,3,1,"The Flyfish can fly at low altitudes out of water and feasts on the small insects just above the waters surface.",seaBreezeTree.m_elders[1]);
		seaBreezeTree.m_adolescents=new MonsterType[2];
		seaBreezeTree.m_adolescents[0]=new MonsterType("Guller",pes,ses,2,0,"The guller is a small gull with wide wings",seaBreezeTree.m_adults[0]);
		seaBreezeTree.m_adolescents[1]=new MonsterType("Skipfish",pes,ses,2,1,"The skipfish can't quite fly yet, but it loved the feeling when it was younger in the baby gulls claws. It can skip out of the water on its fins that are becoming like wings",seaBreezeTree.m_adults[1]);
		seaBreezeTree.m_infants=new MonsterType[1];
		seaBreezeTree.m_infants[0]=new MonsterType("Gullfish",pes,ses,1,0,"The first fish a baby gull ever caught is still in its claws. Initially there was some fear between the baby gull and the fish, but they became fast friends when the fish found out how cool it is to fly",seaBreezeTree.m_adolescents[0],seaBreezeTree.m_adolescents[1]);
		seaBreezeTree.m_eggs=new MonsterType[1];
		seaBreezeTree.m_eggs[0]=new MonsterType("SeaBreeze Egg",pes,ses,0,0,"The SeaBreeze egg's parents often hold onto it for months at a time before they see dry land. SeaBreeze Monsters love flying above the ocean, so when a SeaBreeze egg is laid, it is caught by the father who holds it while they are flying, even when sleeping.",seaBreezeTree.m_infants[0]);
		return seaBreezeTree;
	}
	public static MonsterTree defineBirdsMonsterTypes()
	{
		pes=3;
		ses=2;
		MonsterTree birdTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		birdTree.m_elders=new MonsterType[2];
		birdTree.m_elders[0]=new MonsterType("Foursamcan",pes,ses,4,0,"The Foursamcan channels light from the sun that shines through its multicolored feathers to confuse its enemies");
		birdTree.m_elders[1]=new MonsterType("Seusstruse",pes,ses,4,1,"When a Fabstruse comes to the realization that leather never goes out of style, it becomes a Seusstruse. When the Seusstruse lays eggs, they are green, and when it has access to ham, it places the ham near the eggs because it loves green eggs and ham.");
		birdTree.m_adults=new MonsterType[2];
		birdTree.m_adults[0]=new MonsterType("Threesamcan",pes,ses,3,0,"The Threesamcan is a much larger version of the Tusamcan, and is even more colorful",birdTree.m_elders[0]);
		birdTree.m_adults[1]=new MonsterType("Fabstruse",pes,ses,3,1,"The Fabstruse is a very strange black and purple bird that loves fashion, but always seems to be behind on the trends. I mean leather Jacket? Sooo Eighties",birdTree.m_elders[1]);
		birdTree.m_adolescents=new MonsterType[2];
		birdTree.m_adolescents[0]=	new MonsterType("Tusamcan",pes,ses,2,0,"The TuscamCan is a colorful blue bird with a rainbow beak that tells little children to eat healthy while giving them pure sugar for breakfast",birdTree.m_adults[0]);
		birdTree.m_adolescents[1]= new MonsterType("Abstruse",pes,ses,2,1,"The Abstruse is a brightly colorful bird that complicated and interesting... Or completely ridculous depending on how you look at it. It looks like a peacock, except every single feather is a different color, and they're not organized in any particular manner. When it walks, it takes its long storklike legs and pulls them up way higher than they need to go, giving it a ridiculous looking gait. Its long neck is a gradient from green to blue, and it has a yellow feather crown on the crest of its head",birdTree.m_adults[1]);
		birdTree.m_infants=new MonsterType[1];
		birdTree.m_infants[0]=new MonsterType("Colour",pes,ses,1,0,"The Colour is a colorful hatchling.",birdTree.m_adolescents[0],birdTree.m_adolescents[1]);
		birdTree.m_eggs=new MonsterType[1];
		birdTree.m_eggs[0]=new MonsterType("Bird Egg",pes,ses,0,0,"The BirdEgg is a rainbow colored egg with the bird crest at its center",birdTree.m_infants[0]);
		return birdTree;
	}
	public static MonsterTree defineAeroMonsterTypes()
	{
		pes=3;
		ses=3;
		MonsterTree aeroTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		aeroTree.m_elders=new MonsterType[2];
		aeroTree.m_elders[0]=new MonsterType("Roc",pes,ses,4,0,"The Roc is a giant bald eagle with a thirty foot wingspan, it often sits on a golden dome");
		aeroTree.m_elders[1]=new MonsterType("Air Atronach",pes,ses,4,1,"Lightening often surrounds the Air Atronach whenever it is angry. It is surrounded by six elementals, three of which are aero, three of which determine the other types of spells it can cast");
		aeroTree.m_adults=new MonsterType[3];
		aeroTree.m_adults[0]=new MonsterType("Baldgul",pes,ses,3,0,"The Baldgul is a bald eagle that is actually bald. Not white feathers, no feathers",aeroTree.m_elders[0]);
		aeroTree.m_adults[1]=new MonsterType("Wings",pes,ses,3,1,"Byrdi hated the beatles, because the name made it hungry. And the problem with the rolling stones was, well, people would often try to kill it and another bird with a single one. But Once the beatles split up, it became Wings",aeroTree.m_elders[0]);
		aeroTree.m_adults[2]=new MonsterType("Aero Elemental",pes,ses,3,2,"The Aero Elemental is a suped up version of the AeroSymbol with more wings etc.",aeroTree.m_elders[1]);
		aeroTree.m_adolescents=new MonsterType[3];
		aeroTree.m_adolescents[0]=new MonsterType("toupeagle",pes,ses,2,0,"The toupeagle is a young eagle that went prematurely bald. Its very sensitive about its baldness and thus wears a toupee. Its a good toupee too, but it looks ridiculous because its not really on right because, well it has only wings and claws to work with",aeroTree.m_adults[0]);
		aeroTree.m_adolescents[1]=new MonsterType("Byrdi",pes,ses,2,1,"The Byrdi grew up in the seventies and fell in love with rock and roll. It gets dizzy when it acts out its favorite song",aeroTree.m_adults[1]);
		aeroTree.m_adolescents[2]=new MonsterType("AeroSymbol",pes,ses,2,3,"The AeroSymbol is a circle with six points that looks like the aero glyph. The six points are feathers",aeroTree.m_adults[2]);
		aeroTree.m_infants = new MonsterType[1];
		aeroTree.m_infants[0]=new MonsterType("Flapper",pes,ses,1,0,"The Flapper shows a ridiculous amount of leg, esspecially for this time period. It is very stylish, and wears a headband with a feather on it, even though its already a bird",aeroTree.m_adolescents[0],aeroTree.m_adolescents[1],aeroTree.m_adolescents[2]);
		aeroTree.m_eggs = new MonsterType[1];
		aeroTree.m_eggs[0]=new MonsterType("AeroEgg",pes,ses,0,0,"The aeroEgg hovers in the air, and is yellow with the bird crest on it. It was designed to hover just in case one of its parents accidentally knocks it out of the tree, so it can be rescued before it hits the ground",aeroTree.m_infants[0]);
		return aeroTree;
	}
	public static MonsterTree defineCockaMonsterTypes()
	{
		pes=3;
		ses=4;
		MonsterTree cockaTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		cockaTree.m_elders=new MonsterType[1];
		cockaTree.m_elders[0]=new MonsterType("CockaFour",pes,ses,4,0,"The Cockafour is the undisputed leader of the cockas. Its beak is lined with razors, and its dance can drive all birds crazy, and berserks all air primaries");
		cockaTree.m_adults=new MonsterType[3];
		cockaTree.m_adults[0]=new MonsterType("Cockadude",pes,ses,3,0,"The Cockadude is a super cool cocka who wears 8 bit glasses and raps",cockaTree.m_elders[0]);
		cockaTree.m_adults[1]=new MonsterType("Cockathree",pes,ses,3,1,"The Cockathree is a pretty awesome cocka that often dances with its feathers and raises its crest",cockaTree.m_elders[0]);
		cockaTree.m_adults[2]=new MonsterType("Lovebird",pes,ses,3,2,"The Lovebird is a totally pink cocka that is eternally smiling. It can flirt with an air primary monster to occupy it for one turn",cockaTree.m_elders[0]);
		cockaTree.m_adolescents=new MonsterType[3];
		cockaTree.m_adolescents[0]=new MonsterType("Cockarude",pes,ses,2,0,"The Cockarude is a cocka that his very rude and often signals with its middle feather. It wears a backwards baseball cap, how it got one I dont know",cockaTree.m_adults[0]);
		cockaTree.m_adolescents[1]=new MonsterType("Cockatwo",pes,ses,2,1,"The Cockatwo is a regular cocka. And by regular I mean very strange",cockaTree.m_adults[1]);
		cockaTree.m_adolescents[2]=new MonsterType("Smilebird",pes,ses,2,2,"The Smilebird is a cocka who is using its smile feathers to smile. It is also blushing a vey delicate shade of pink.",cockaTree.m_adults[2]);
		cockaTree.m_infants=new MonsterType[1];
		cockaTree.m_infants[0]=new MonsterType("Cockaone",pes,ses,1,0,"A baby cockatoo that has yet to leave its shell. Its cracked and eveything, but it hasn't left. It wears the top of the shell like a helmet",cockaTree.m_adolescents[0],cockaTree.m_adolescents[1],cockaTree.m_adolescents[2]);
		cockaTree.m_eggs = new MonsterType[1];
		cockaTree.m_eggs[0]=new MonsterType("CockaEgg",pes,ses,0,0,"The CockaEgg is a pure white egg with the cocka crest on it",cockaTree.m_infants[0]);
		return cockaTree;
	}
	public static MonsterTree defineNightWingMonsterTypes()
	{
		pes=3;
		ses=5;
		MonsterTree nightWingTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		nightWingTree.m_elders=new MonsterType[2];
		nightWingTree.m_elders[0]=new MonsterType("Vampelder",pes,ses,4,0,"The Vampelder is an older vampire that can assume human form. It can dissipate into a crowd of bats to attack its enemies");
		nightWingTree.m_elders[1]=new MonsterType("Lenoraven",pes,ses,4,1,"Because of the Lenoraven's intimite relationship with death, it can instantly kill a monster with less than 20% health");
		nightWingTree.m_elders[2]=new MonsterType("Knowlowlegabel",pes,ses,4,1,"The Knowlowlegabel knows only that it does not know. It can cast logical contradiction that injures monsters scaling with their intellect");
		nightWingTree.m_adults=new MonsterType[2];
		nightWingTree.m_adults[0]=new MonsterType("Vampire",pes,ses,3,0,"The vampire can float around like a shadow in the night. It can vampire bite that heals 1/2 of the damage inflicted. It takes extra damage from fire and light.",nightWingTree.m_elders[0]);
		nightWingTree.m_adults[1]=new MonsterType("Skulltrure",pes,ses,3,1,"The Skullture is a vulture with the head of a skull, like its younger cousin, the Scanvegiar, it feeds on death, and has an ability to deal double damage the turn after a monster dies",nightWingTree.m_elders[1]);
		nightWingTree.m_adults[2]=new MonsterType("Wisowl",pes,ses,3,1,"The wiseowl is an older version of the rationowl that can expose the weaknesses of its enemies so that they take 25% extra damage for the rest of the battle. This effect does not stack with identify weakness",nightWingTree.m_elders[2]);
		nightWingTree.m_adolescents=new MonsterType[3];
		nightWingTree.m_adolescents[0]=new MonsterType("ShadowWing",pes,ses,2,0,"The shadowing is a bat that has a vampire attack that heals for 1/4th of the attacks damage",nightWingTree.m_adults[0]);
		nightWingTree.m_adolescents[1]=new MonsterType("Scavengair",pes,ses,2,1,"The scavenger is a young vulture that feeds on death. For each creature that dies, it deals an additional 5% damage",nightWingTree.m_adults[1]);
		nightWingTree.m_adolescents[2]=new MonsterType("Rationowl",pes,ses,2,1,"The Rationowl is a thinker and percieves its enemies weaknesses before it strikes. It can cast identify which increases damage to an enemy by 15% for the rest of the battle",nightWingTree.m_adults[2]);
		nightWingTree.m_infants=new MonsterType[1];
		nightWingTree.m_infants[0]=new MonsterType("Foreshadowwing",pes,ses,1,0,"Its very hard to tell what manner of winged beast this is, as it is covered by shadows and appears to have four wings",nightWingTree.m_adolescents[0],nightWingTree.m_adolescents[1],nightWingTree.m_adolescents[2]);
		nightWingTree.m_eggs=new MonsterType[1];
		nightWingTree.m_eggs[0]=new MonsterType("NightWing Egg",pes,ses,0,0,"The NightWing egg is black and nearly hidden in the shadows of the cave where it is laid",nightWingTree.m_infants[0]);
		return nightWingTree;
	}
	public static MonsterTree defineSolarMonsterTypes()
	{
		pes=4;
		ses=0;
		//TODO redo solar tree
		MonsterTree solarTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		solarTree.m_elders = new MonsterType[3];
		solarTree.m_elders[0]=new MonsterType("Flarebear",pes,ses,4,0,"A Flarebear, as the name implies is a sun elemental bear");
		solarTree.m_elders[1]=new MonsterType("FlareTyrant",pes,ses,4,1,"A solar-elemental tyrant");
		solarTree.m_elders[2]=new MonsterType("Sol",pes,ses,4,2,"A Sol is as bright as the sun, only smaller");
		solarTree.m_adults = new MonsterType[3];
		solarTree.m_adults[0]=new MonsterType("FlareWulf",pes,ses,3,0,"A FlareWulf is a glowing wolf that can breathe a solar flare",solarTree.m_elders[0]);
		solarTree.m_adults[1]=new MonsterType("Solaire",pes,ses,3,1,"A Solaire is a larger diurnal with big teeth and horns",solarTree.m_elders[1]);
		solarTree.m_adults[2]=new MonsterType("Antares",pes,ses,3,2,"Named after the third brighest star in the night sky, the Sirius is a brighter vega with more magic",solarTree.m_elders[2]);
		solarTree.m_adolescents=new MonsterType[3];
		solarTree.m_adolescents[0]=new MonsterType("FireFaux",pes,ses,2,0,"A Firefaux is a fox that loves sitting in the sun and absorbing rays. It has a yellow coat, and is a reference to an awesome browser",solarTree.m_adults[0]);
		solarTree.m_adolescents[1]=new MonsterType("Diurnal",pes,ses,2,1,"A diurnal is a montser that is active only during the day. It looks like a saur made of flames",solarTree.m_adults[1]);
		solarTree.m_adolescents[2]=new MonsterType("Vega",pes,ses,2,2,"Named after the fifth brightest star in the sky, the vega is a spherical construct with rotating ray blades that resembles the sun",solarTree.m_adults[2]);
		solarTree.m_infants=new MonsterType[1];
		solarTree.m_infants[0]=new MonsterType("Tona",pes,ses,1,0,"A tona is a floating orb that gains energy from the suns rays. At night it floats to rest and stops glowing, appearing a simple stone",solarTree.m_adolescents[0],solarTree.m_adolescents[1],solarTree.m_adolescents[2]);
		solarTree.m_eggs = new MonsterType[1];
		solarTree.m_eggs[0]=new MonsterType("Solar egg",pes,ses,0,0,"The solar egg glows slightly in the night if left out in the sun all day, as if it absorbs the sun's rays",solarTree.m_infants[0]);
		return solarTree;
	}
	public static MonsterTree defineLunarMonsterTypes()
	{
		pes=4;
		ses=1;
		MonsterTree lunarTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		lunarTree.m_elders=new MonsterType[2];
		lunarTree.m_elders[0]=new MonsterType("Lona",pes,ses,4,0,"Lona's are stronger when they have a Luna present. They are great white Wolves with ice colored eyes, their eyes seem to speak of their souls, human");
		lunarTree.m_elders[1]=new MonsterType("Luna",pes,ses,4,1,"Luna is a large moon appearing stone with a single large silver band surrounding it, that shows six phases of the moon");
		lunarTree.m_adults=new MonsterType[2];
		lunarTree.m_adults[0]=new MonsterType("Selen",pes,ses,3,0,"Selen is a greater wolf, pure white. It can preform moon beam which deals mainly light damage with water secondary.",lunarTree.m_elders[0]);
		lunarTree.m_adults[1] = new MonsterType("Mayari",pes,ses,3,1,"Mayari depicts a half full moon emblazoned on a cylindrical stone. The silver band surrounding it has spawned six crescents, all facing outwards",lunarTree.m_elders[1]);
		lunarTree.m_adolescents=new MonsterType[2];
		lunarTree.m_adolescents[0] = new MonsterType("Chia",pes,ses,2,0,"Chia is a small wolf that can howl at the moon to increase its attack",lunarTree.m_adults[0]);
		lunarTree.m_adolescents[1] = new MonsterType("Chandra",pes,ses,2,1,"Chandra is a cylindrical stone whose radius is 4 times its height, it shows the waning phase of the moon, if you were to project the waning moon on the rock, the rock cooresponding to the dark side of the moon is black and the lit side of the moon is white. It is surrounded by a simple silver bar with six crescents",lunarTree.m_adults[1]);
		lunarTree.m_infants=new MonsterType[1];
		lunarTree.m_infants[0]=new MonsterType("Lunapup",pes,ses,1,0,"The Lunapup is a small wolf born from a lunar egg on the full moon.",lunarTree.m_adolescents[0],lunarTree.m_adolescents[1]);
		lunarTree.m_eggs=new MonsterType[1];
		lunarTree.m_eggs[0]=new MonsterType("Lunar egg",pes,ses,0,0,"The Lunar egg appears to be a stone during the day, however when moonlight shines upon it, it is clearly an egg with the lunar symbol embossed upon it. The brightness of the symbol is determined by the phase the moon is in.",lunarTree.m_infants[0]);
		return lunarTree;
	}
	public static MonsterTree defineGuardianMonsterTypes()
	{
		pes=4;
		ses=2;
		MonsterTree guardianTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		guardianTree.m_elders=new MonsterType[2];
		guardianTree.m_elders[0]=new MonsterType("Guardainus",pes,ses,4,0,"The Guardainus is a titan with a large amount of HP. He can cast a skill on a unit so that he dies instead of them when they are killed, transferring hp");
		guardianTree.m_elders[1]=new MonsterType("Halarial",pes,ses,4,1,"The Halarial is a greater angel. It can sacrifice itself to keep another from death for three turns");
		guardianTree.m_adults=new MonsterType[2];
		guardianTree.m_adults[0]=new MonsterType("Scardar",pes,ses,3,0,"The scardar has many scars, including one over his left eye, his visible skin is scarred and his shield is spiked which allows him to return a percentage of damage",guardianTree.m_elders[0]);
		guardianTree.m_adults[1]=new MonsterType("Halosses",pes,ses,3,1,"The Halosses is a fully adult angel cloaked in green. She can cast regen on an ally which heals it for some hp each turn",guardianTree.m_elders[1]);
		guardianTree.m_adolescents=new MonsterType[2];
		guardianTree.m_adolescents[0]=new MonsterType("Sheildar",pes,ses,2,0,"The Sheildar is an older Escutcheoner who has acquired metal guards, which is a plus. He can taunt enemies to force them to attack him",guardianTree.m_adults[0]);
		guardianTree.m_adolescents[1]=new MonsterType("Haloss",pes,ses,2,1,"The Haloss is a lesser angel that can cast shell on an ally, which acts as a temporary shield",guardianTree.m_adults[1]);
		guardianTree.m_infants=new MonsterType[1];
		guardianTree.m_infants[0]=new MonsterType("Escutcheoner",pes,ses,1,0,"The Escutcheoner is a small creature with a big shield that it is very proud of and shines on a daily basis. In combat he can attack as usual",guardianTree.m_adolescents[0],guardianTree.m_adolescents[1]);
		guardianTree.m_eggs=new MonsterType[1];
		guardianTree.m_eggs[0]=new MonsterType("Guardian Egg",pes,ses,0,0,"The guardian tree is hard as a rock, the guardian crest embossed on its center",guardianTree.m_infants[0]);
		return guardianTree;
	}
	public static MonsterTree defineHolyMonsterTypes()
	{
		pes=4;
		ses=3;
		MonsterTree holyTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		holyTree.m_elders=new MonsterType[2];
		holyTree.m_elders[0] = new MonsterType("Archangel",pes,ses,4,0,"The Archangel  can buff all angels on the owners side");
		holyTree.m_elders[1] = new MonsterType("Ultrangel",pes,ses,4,1,"The ultra angel is the epitome of an angel");
		holyTree.m_adults=new MonsterType[2];
		holyTree.m_adults[0]=new MonsterType("Onangel",pes,ses,3,0,"The Onangel has a passive buff that deals 15% bonus damage to dark elemental enemies",holyTree.m_elders[0]);
		holyTree.m_adults[1]=new MonsterType("Anangel",pes,ses,3,1,"The Anangel can promote its allies to do +20% damage versus dark primary enemies",holyTree.m_elders[1]);		
		holyTree.m_adolescents=new MonsterType[2];
		holyTree.m_adolescents[0]=new MonsterType("Hemiangel",pes,ses,2,0,"The Hemiangel has a cherubic body and shoots from a bow",holyTree.m_adults[0]);
		holyTree.m_adolescents[1]=new MonsterType("Semiangel",pes,ses,2,1,"The Semiangel can annoint light primary allies, buffing their attack by 20%",holyTree.m_adults[1]);
		holyTree.m_infants=new MonsterType[1];
		holyTree.m_infants[0]=new MonsterType("Demiangel",pes,ses,1,0,"The Demiangel is a small angel who left heaven in order to help the world (or its wings were not strong enough to keep it that high in the sky, depending on who you ask) its magical ability is to heal, however it refuses to heal anything with a dark or fire element",holyTree.m_adolescents[0],holyTree.m_adolescents[1]);
		holyTree.m_eggs = new MonsterType[1];
		holyTree.m_eggs[0]= new MonsterType("Holy Egg", pes,ses,0,0,"It is a golden egg. Unfortunately there are only a finite number of them because the people benefiting from the golden egg killed the goose that laid them thinking it must be made of more valuable materials. They were wrong.",holyTree.m_infants[0]);
		return holyTree;
	}
	public static MonsterTree defineLuxorMonsterTypes()
	{
		pes=4;
		ses=4;
		MonsterTree luxorTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		luxorTree.m_elders=new MonsterType[3];
		luxorTree.m_elders[0] = new MonsterType("Ascendenphage",pes,ses,4,0, "The Ascendenpage is a lage Argenphage whose armor glows a brilliant white, made of some opaque white metal, the symbols etched into the metal are likewise fancy");
		luxorTree.m_elders[1] = new MonsterType("Luminacier",pes,ses,4,1,"The Luminacier is a single Luminace surrounded by six smaller Candellas, representing faith, justice, mercy, compassion, forgiveness and redemption");
		luxorTree.m_elders[2] = new MonsterType("Light Atronach",pes,ses,4,2,"The light atronach is an ascendant light elemenal that is surrounded by six symbols, representing each of the six elements");
		luxorTree.m_adults=new MonsterType[3];
		luxorTree.m_adults[0] = new MonsterType("Argenphage",pes,ses,3,0,"The Argenphage is a larger phage with silver plates inlaid with complex designs. It is said that their eyes can see the balance of a soul",luxorTree.m_adults[0]);
		luxorTree.m_adults[1] = new MonsterType("Luminace",pes,ses,3,1,"The Luminace is a collection of three Candellas, representing faith, truth and service, the virtues of its holy order. It will often shirk from the control of a dark master, even rebelling at times",luxorTree.m_adults[1]);	
		luxorTree.m_adults[2] = new MonsterType("Light Elemental",pes,ses,3,2,"the light elemental is a large light symbol surrounded by three other symbols, water, air and earth. The elemental can channel any of the four energies",luxorTree.m_adults[2]);
		luxorTree.m_adolescents = new MonsterType[3];
		luxorTree.m_adolescents[0] = new MonsterType("Phage",pes,ses,2,0, "A phage is a glowing ball of light that is protected by golden armor. It is floating about three feet in the air and has three fingered golden claws that extend two feet from its shoulders. it has two asymmetric horns on its helmet that is not attached to its body, and light glows from the eye sockets",luxorTree.m_adults[0]);
		luxorTree.m_adolescents[1] = new MonsterType("Candella",pes,ses,2,1, "A Candella absorbs the light of the sun during the day and uses this light to attack its enemies at night. It can reveal the presence of monsters trying to stealth",luxorTree.m_adults[1]);
		luxorTree.m_adolescents[2] = new MonsterType("Light Symbol",pes,ses,2,2,"A Light symbol is the embodiment of the symbol of light and can cast lumimagia 1, the basic light attack spell",luxorTree.m_adults[2]);
		luxorTree.m_infants = new MonsterType[1];
		luxorTree.m_infants[0]=new MonsterType("Lumin",pes,ses,1,0,"A lesser lumin is a small hovering ball of light that can heal other light monsters",luxorTree.m_adolescents[0],luxorTree.m_adolescents[1],luxorTree.m_adolescents[2]);
		luxorTree.m_eggs = new MonsterType[1];
		luxorTree.m_eggs[0]=new MonsterType("Luxor Egg",pes,ses,0,0,"The luxor Egg glows a brilliant white and has the luxor symbol etched on its surface",luxorTree.m_infants[0]);
		return luxorTree;
	}
	public static MonsterTree defineRedemptionMonsterTypes()
	{
		MonsterTree redemptionTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		//TODO finish redemptionTree after demons are created
		return redemptionTree;
	}
	public static MonsterTree defineDemonicMonsterTypes()
	{
		MonsterTree demonicTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		pes=5;
		ses=0;
		demonicTree.m_elders = new MonsterType[3];
		demonicTree.m_elders[0] = new MonsterType("Astaroth",pes,ses,4,0,"Astaroth is a bright red demon with large black horns fifteen feet tall. He weilds a large corrupted axe that has a living eye where the blade meets the haft");
		demonicTree.m_elders[1] = new MonsterType("Asag",pes,ses,4,1,"Asag is also known as the fear. He appears as a giant demon with the body of a bear and the head of a stag.");
		demonicTree.m_elders[2] = new MonsterType("Shedu",pes,ses,4,2,"The Shedu is a phantom witch that speaks only curses, whose eyeless sockets see through the dark and not");
		demonicTree.m_adults = new MonsterType[3];
		demonicTree.m_adults[0] = new MonsterType("Incubus",pes,ses,3,0,"The Incubus can take many forms, sometimes appearing as a poet, or perhaps an athelete to sexually corrupt women, when they feel excited as their prey is near, often their eyes will revert to their true form, but only for an instant, giving the virtuous their only warning");
		demonicTree.m_adults[1] = new MonsterType("Succubus",pes,ses,3,1,"The succubus is a beautiful female demon meant to provoke lust in the hearts of men. They catch their prey more ofthen than the Incubus, as men have weaker hearts when it comes to resisting beauty");
		demonicTree.m_adults[2] = new MonsterType("Grimiore",pes,ses,3,2,"A sentient black book that has the demon crest embossed on the cover. The spells and hexes within are written in both the blood of the slain and the blood of the conqueror");
		demonicTree.m_adolescents = new MonsterType[3];
		demonicTree.m_adolescents[0] = new MonsterType("Scamp",pes,ses,2,0,"A scamp is a minor demon with claws and long ears, it screams at its enemies to initiate combat");
		demonicTree.m_adolescents[1] = new MonsterType("Imp",pes,ses,2,1,"An imp is a small red demon carrying a pitchfork. It is aggressive but is wise enough not to initiate combat against a stronger opponent");
		demonicTree.m_adolescents[2] = new MonsterType("Jinn",pes,ses,2,2,"A Jinn attacks its enemies with mystical enemies, preying on the weak of mind. It is ephemeral, which greatly reduces the efficacy of physical attacks");
		demonicTree.m_infants = new MonsterType[1];
		demonicTree.m_infants[0] = new MonsterType("Fiend",pes,ses,1,0,"The fiend is a minor demon, colored dark red with black horns");
		demonicTree.m_eggs = new MonsterType[1];
		demonicTree.m_eggs[0] = new MonsterType("Demonic Egg",pes,ses,0,0,"The demonic egg is is a rusty black with the demonic symbol embossed on its center, it is painful to touch");
		return demonicTree;
	}
	public static MonsterTree definePoisonMonsterTypes()
	{
		MonsterTree poisonTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		pes=5;
		ses=1;
		poisonTree.m_elders[0]= new MonsterType("Queen B",pes,ses,3,0,"Queen B is the younger sister of Queen A, however when they were in a beauty pagent, everyone chose Queen B, so she became the dominant Queen. She can summon Stingers to the empty allied positions");
		poisonTree.m_elders[1]=new MonsterType("King Rattle",pes,ses,3,1,"King Rattle has a large Rattle on the end of its tail. Not like a snakes, like a babies rattle, but really large. It also has a crown. Its scales are brown and it is very large");
		poisonTree.m_elders[2]=new MonsterType("Red Widow",pes,ses,3,2,"The Red Widow has gotten over her husbands death. The hourglass has turned black, and the rest of her has turned red. This color, and the scent given off from her hide, attracts insects to their doom. Her bright color does as well");
		poisonTree.m_elders[3]=new MonsterType("Cougar Spider",pes,ses,3,3,"The Cougar Spider is an older spider who still looks nice and knows how to treat men (spiders) right. She takes them to her web and then eats them.");
		poisonTree.m_adults=new MonsterType[3];
		poisonTree.m_adults[0]=new MonsterType("Wasplash",pes,ses,3,0,"The Wasplash is an oversized wasp with a stinger and it can latch onto a single enemy with the hooked blades on the end of its legs, stinging them multiple times",poisonTree.m_elders[0]);
		poisonTree.m_adults[1]=new MonsterType("Slyslyther",pes,ses,3,1,"The SlySlyther is a grown Slyther whose scales have turned black as night, it is very quiet and can sneak attack its enemies.",poisonTree.m_elders[1]);
		poisonTree.m_adults[2]=new MonsterType("Widow",pes,ses,3,2,"The Widow is a widowed spider that is really broken up about it, cries all the time. It looks like a black widow but larger and sad",poisonTree.m_elders[2],poisonTree.m_elders[3]);
		poisonTree.m_adolescents=new MonsterType[3];
		poisonTree.m_adolescents[0]=new MonsterType("Stinger",pes,ses,2,0,"The Stinger is an oversized wasp with a poisonous stinger",poisonTree.m_adults[0]);
		poisonTree.m_adolescents[1]=new MonsterType("Slyther",pes,ses,2,1,"The Slyther is a small snake that slides through the grass towards its prey. Its bite is venemous. Its green and has no rattle",poisonTree.m_adults[1]);
		poisonTree.m_adolescents[2]=new MonsterType("Creeper",pes,ses,2,2,"The creeper is a spider that can shoot webs at its enemies to slow them down.",poisonTree.m_adults[2]);
		poisonTree.m_infants = new MonsterType[1];
		poisonTree.m_infants[0] = new MonsterType("Fanger",pes,ses,1,0,"The fanger is a small scorpion that can lift its legs up and slither and has fangs",poisonTree.m_adolescents[0],poisonTree.m_adolescents[1],poisonTree.m_adolescents[2]);
		poisonTree.m_eggs = new MonsterType[1];
		poisonTree.m_eggs[0] = new MonsterType("Poison Egg",pes,ses,0,0,"The poison egg is black with a greenish hue. The symbol is embossed on its surface, and spikes extend from the shell, which defend itself. The spikes are of course dipped in poison",poisonTree.m_infants[0]);
		return poisonTree;
	}
	public static MonsterTree defineUndeadMonsterTypes()
	{
		pes=5;
		ses=2;
		MonsterTree undeadTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		undeadTree.m_elders = new MonsterType[1];
		undeadTree.m_elders[0] = new MonsterType("Skulltyrant",pes,ses,4,0,"The Skulltyrant is a large undead T-rex. Very Scary");
		undeadTree.m_elders[1] = new MonsterType("Specter",pes,ses,4,1,"The Specter can possess an enemy for three turns after which it dies");
		undeadTree.m_adults = new MonsterType[1];
		undeadTree.m_adults[0] = new MonsterType("Skullclar",pes,ses,3,0,"The Skullclar is a larger Skullsaur with wings and horns",undeadTree.m_elders[0]);
		undeadTree.m_adults[1] = new MonsterType("Phantom",pes,ses,3,1,"The Phantom is still incorporeal and weilds a curved scepter",undeadTree.m_elders[1]);
		undeadTree.m_adolescents = new MonsterType[1];
		undeadTree.m_adolescents[0] = new MonsterType("Skullsaur",pes,ses,2,0,"The Skullsaur is a undead veloceraptor looking thing that has a badass attack called deathclaw",undeadTree.m_adults[0]);
		undeadTree.m_adolescents[1] = new MonsterType("Ghostet",pes,ses,2,1,"The Ghostet is a weak phantom that takes reduced physical damage",undeadTree.m_adults[1]);
		undeadTree.m_infants = new MonsterType[1];
		undeadTree.m_infants[0] = new MonsterType("Stull",pes,ses,1,0,"The stull is a floating skull with glowing green orbs in its eye sockets",undeadTree.m_adolescents[0],undeadTree.m_adolescents[1]);
		undeadTree.m_eggs = new MonsterType[1];
		undeadTree.m_eggs[0] = new MonsterType("Undead Egg",pes,ses,0,0,"Lifeless and cold, the egg is the color and consistency of bone, with the undead crest embossed on the center",undeadTree.m_infants[0]);
		//TODO add more undead monsters
		return undeadTree;
	}
	public static MonsterTree defineStormMonsterTypes()
	{
		pes=5;
		ses=3;
		MonsterTree stormTree= new MonsterTree(pes,ses,typeNames[pes][ses]);
		stormTree.m_elders = new MonsterType[1];
		stormTree.m_elders[0] = new MonsterType("Thundragon",pes,ses,4,0,"The Thundragon is a fully formed dragon made of clouds. Its breath is a hurricane, its scream a thunderbolt");
		stormTree.m_adults = new MonsterType[1];
		stormTree.m_adults[0] = new MonsterType("Tempestor",pes,ses,3,0,"The Tempestor is a greater thunder wyvern with wings and rear claws. Its presence will darken the sky and call harsh gales",stormTree.m_elders[0]);
		stormTree.m_adolescents = new MonsterType[1];
		stormTree.m_adolescents[0] = new MonsterType("Thundroar",pes,ses,2,0,"The Thundroar is a dragonlike snake in the clouds. Lightening storms occur when multiple Thundroars battle in the heavens. It is said that thunder is caused by their roaring",stormTree.m_adults[0]);
		stormTree.m_infants = new MonsterType[1];
		stormTree.m_infants[0]= new MonsterType("Maltag", pes,ses,1,0,"Have you ever had a really bad day? So bad that even though there was a clear blue sky, it felt like a small dark cloud was following you around? This is that cloud",stormTree.m_adolescents[0]);
		stormTree.m_eggs = new MonsterType[1];
		stormTree.m_eggs[0] = new MonsterType("Storm Egg",pes,ses,0,0,"The storm egg is solid black and appears to be made of obsidian, excepting, of course, the symbol embossed on its center",stormTree.m_infants[0]);
		return stormTree;
	}
	public static MonsterTree defineBetrayerMonsterTypes()
	{
		pes=5;
		ses=4;
		MonsterTree betrayerTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		betrayerTree.m_elders = new MonsterType[1];
		betrayerTree.m_elders[0] = new MonsterType("Avengeant",pes,ses,4,0,"The Avengeant once served God, but gien will, disagreed with his descision. When he went to resolve the conflict, God couldn't stand being questioned and excommunicated the Avengent, who has hated God and those loyal to him ever since");
		betrayerTree.m_adults = new MonsterType[1];
		betrayerTree.m_adults[0] = new MonsterType("Black Knight",pes,ses,3,0,"The black knight is sheilded in dark plate, that has rituals etched into the steel",betrayerTree.m_elders[0]);
		betrayerTree.m_adolescents = new MonsterType[1];
		betrayerTree.m_adolescents[0] = new MonsterType("Dark Phage",pes,ses,2,0,"The dark phage is a corrupted phage that turned from the service of its creator",betrayerTree.m_adults[0]);
		betrayerTree.m_adolescents[1] = new MonsterType("Fallen HemiAngel",pes,ses,2,1,"The Fallen HemiAngel has larger wings both turned black",betrayerTree.m_adults[0]);
		betrayerTree.m_infants = new MonsterType[1];
		betrayerTree.m_infants[0] = new MonsterType("Fallen DemiAngel",pes,ses,1,0,"The fallen demiAngel is an angel that followed the light bringer when he fell from heaven. It was weak then, and has yet to grow",betrayerTree.m_adolescents[0],betrayerTree.m_adolescents[1]);
		betrayerTree.m_eggs = new MonsterType[1];
		betrayerTree.m_eggs[0] = new MonsterType("Betrayer Eggs",pes,ses,0,0,"The betrayer egg is half black and half white its center embossed with the betrayers symbol, a back being stabbed",betrayerTree.m_infants[0]);
		return betrayerTree;
	}
	public static MonsterTree defineUmbralMonsterTypes()
	{
		pes=5;
		ses=5;
		MonsterTree umbralTree = new MonsterTree(pes,ses,typeNames[pes][ses]);
		umbralTree.m_elders = new MonsterType[1];
//		umbralTree.m_adults[0] = new MonsterType("")
		umbralTree.m_adults = new MonsterType[1];
		umbralTree.m_adults[0] = new MonsterType("Obfuscay",pes,ses,3,0,"The Obfuscay consumes darkness and channels it back at its enemies, blinding them");
		umbralTree.m_adolescents = new MonsterType[1];
		umbralTree.m_adolescents[0] = new MonsterType("Shadeoss",pes,ses,2,0,"The Shadeoss is strongest in darkness. It appears to be the upper torso of a knight weilding a sword");
		umbralTree.m_adolescents[1] = new MonsterType("Screel",pes,ses,2,1,"The Screel is a dark scamp that attacks from the shadows");
		umbralTree.m_infants = new MonsterType[1];
		umbralTree.m_infants[0] = new MonsterType("Umbress",pes,ses,1,0,"The umbress appears to bea small floating black flame, with two purple eyes");
		umbralTree.m_eggs = new MonsterType[1];
		umbralTree.m_eggs[0] = new MonsterType("Umbral Egg",pes,ses,0,0,"The umbral egg sucks light and appears to cast dark tendrils from its shell, but if you look again theyre gone. It seems weak and fragile when exposed to light, but during the dusk, when the light is weak, the blinded eye  can be seen embossed on its surface",umbralTree.m_infants[0]);
		return umbralTree;
	}
	public static void printTypes()
	{
		System.out.println("Secondary Element                               Primary Element");
		System.out.println("                  |    Fire    |    Water   |    Earth   |     Air    |    Light   |    Dark    |");
		for(int i=0; i<6;i++)
		{
			if(i==0)
			{
				System.out.print("|      Fire       |");
			}
			else if(i==1)
			{
				System.out.print("|      Water      |");
			}
			else if(i==2)
			{
				System.out.print("|      Earth      |");
			}
			else if(i==3)
			{
				System.out.print("|       Air       |");
			}
			else if(i==4)
			{
				System.out.print("|      Light      |");
			}
			else if(i==5)
			{
				System.out.print("|       Dark      |");
			}
			for(int j=0; j<6;j++)
			{

				if(typeNames[j][i].length()==11||typeNames[j][i].length()==10)
				{
					System.out.print(" ");
				}
				else if(typeNames[j][i].length()==9||typeNames[j][i].length()==8)
				{
					System.out.print("  ");
				}
				else if(typeNames[j][i].length()==7||typeNames[j][i].length()==6)
				{
					System.out.print("   ");
				}
				else if(typeNames[j][i].length()==5||typeNames[j][i].length()==4)
				{
					System.out.print("    ");
				}
				else if(typeNames[j][i].length()<=3)
				{
					System.out.print("     ");
				}
				System.out.print(typeNames[j][i]);
				//if(typeNames[i][j].length==10||typeNames[i][j].length==9)
				if(typeNames[j][i].length()>=10)
				{
					//do nothing
				}
				else if(typeNames[j][i].length()>=8)
				{
					System.out.print(" ");
				}
				else if(typeNames[j][i].length()>=6)
				{
					System.out.print("  ");
				}
				else if(typeNames[j][i].length()>=4)
				{
					System.out.print("   ");
				}
				else if(typeNames[j][i].length()>=2)
				{
					System.out.print("    ");
				}
				if(typeNames[j][i].length()%2==0)
				{
					System.out.print(" ");
				}
				System.out.print("|");
			}
			System.out.println();
		}
	}
	public static void main2(String[] args)
	{
		//Instead of Cocka, consider divine type, more focused on physical where holy is more focused on magical
//		define();
//		defineTypes();
	//	printTypes();
		//PlayerCharacter p1 =new PlayerCharacter();
		try
		{
			fileOut=new FileOutputStream("out.txt");
			FileWriter fwr=new FileWriter("out.txt");
		}
		catch(Exception e)
		{
			
		}
		boolean hasStarted=false;
		boolean exit=false;
		while(!exit)
		{
			
			if(hasStarted)
			{
				System.out.println("Please enter either a 1 a 2 or a 3 without any additional characters or spaces");
			}
			System.out.println("Welcome to Monster Master\n\n\n\n\n1)New\n2)Load\n3)Exit\n4)Developer Options\nPlease use only numbers to input, elsewise there may be unexpected results");
			tempi=myScanner.nextInt();
			if(tempi==1)
			{
				PlayerCharacter p1 = new PlayerCharacter();
				System.out.println("Laughter, and a descent into darkness");
				System.out.println("Welcome to the golden company kid. Why Mr. Golden believes in you I have no idea, but his gut hasn't led us astray yet.");
				System.out.println("Brom is the only Master with us, you should look to him if you ");
				System.out.println("So you oppose the path of light then?");
				System.out.println("No, of course not. I've studied it obssessively, trying to obtain some insight into the greatest manipulation, an ancient text that still claims to control the minds of the faithful\nWere you successful?\n No, of course not. Most walkers are illiterate, they just listen to the preists who say whatever they want. Where the book delves into a great controversy and gives credit to both sides to a certain issue, the preists decide which is best, and convey that to the followers");
			}
			else if(tempi==2)
			{
//				fwr.write("");
			}
			else if(tempi==3)
			{
				exit=true;
			}
			else if(tempi==4)
			{
				System.out.println("Developer Options:\n1)look at types");
				tempi=myScanner.nextInt();
			}
			else
			{
				System.out.println("Sorry, I didn't understand your input, please input a 1 2  or 3");
			}
			hasStarted=true;
		}
//		defineTypes();
//		printTypes();
//		PlayerCharacter p1=new PlayerCharacter();
//		try
//		{
//			fileOut = new FileOutputStream("save1.txt");
//		}
//		catch(Exception e)
//		{
//			//System.out.print(e.);
//		}
//		fileOut.write(p1.getName()+"\n");
		//fileOut.write
//		p1.printCharacterDetails();
		System.out.println("Hello World!");
	}
	public static void main(String[] args)
	{
		MonsterTree[][]bestiary=define();
		System.out.println("There are " + MonsterType.monsterTypeNum + " Monster types with definitions so far");
	}
}