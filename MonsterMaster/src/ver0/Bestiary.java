package ver0;
import java.util.Scanner;
/**
 * @file	Bestiary.java
 * @author 	Austin Bailey <a604b997@gmail.com>
 * @dateBegun: 5/9/2016
 * @dateupdated:	5/9/2016
 */
public class Bestiary 
{
	public static MonsterType[][][][] bestiary=generateBestiary();
	public static String[][] typeNames=defineTypes();
	public static boolean exit;
	public static int tempi;
	public static int choice;
	public static String temps;
	public static String inputError="Sorry, we didn't understand your input, be sure that you are only entering one of the values provided";
	public static Scanner myScanner= new Scanner(System.in);
	public static MonsterType[][][][] generateBestiary()
	{
		Skill[] skillSet=Skill.getAllSkills();
		MonsterType[][][][] bestiary=new MonsterType[6][][][];
		bestiary[5]=new MonsterType[6][][];
		bestiary[4]=new MonsterType[6][][];
		bestiary[3]=new MonsterType[6][][];
		bestiary[2]=new MonsterType[6][][];
		bestiary[1]=new MonsterType[6][][];
		bestiary[0]=new MonsterType[6][][];
		bestiary[0][0]=new MonsterType[5][];
		bestiary[0][0][0]=new MonsterType[1];
		bestiary[0][0][1]=new MonsterType[1];
		bestiary[0][0][2]=new MonsterType[3];
		bestiary[0][0][3]=new MonsterType[4];
		bestiary[0][0][4]=new MonsterType[4];
		bestiary[0][0][4][0]=new MonsterType("Red Dragon",0,0,4,0,"The red dragon is as the name implies a red dragon. It breathes fire and captures princes. Yes, I said princes, not princesses, you sexist! It can only be defeated by a young blonde detective being given directions by a captured serial killer. If you didn't get the reference, google it. You won't be disappointed");
		bestiary[0][0][4][1]=new MonsterType("Benemoth",0,0,4,1,"The benemoth is a giant, human shaped colossus of flame.");
		bestiary[0][0][4][2]=new MonsterType("Bolide",0,0,4,2,"The Bolide is a grown up comet with large muscular legs that moves even faster.");
		bestiary[0][0][4][3]=new MonsterType("Flame Atronach",0,0,4,3,"The flame atronach is a giant circular flame symbol made of red steel surrouned by six smaller flame symbols that rotate around it, faster when its casting a spell");
		bestiary[0][0][3][0]=new MonsterType("Pyros",0,0,3,0,"A Pyros has the body of a man and the head of a bull, it wears a cape made of flame though the cape does not burn it. It has a flame crescent axe that seems to be made of red steel",bestiary[0][0][4][0],bestiary[0][0][4][1],skillSet[8]);
		bestiary[0][0][3][1]=new MonsterType("Flarus",0,0,3,1,"A greater Flarus has short legs and gian arms that extend to the floor. Its entire body is aflame, and short red horns can be seen ",bestiary[0][0][4][1]);
		bestiary[0][0][3][2]=new MonsterType("Comet",0,0,3,2,"The Comet is a four legged hound with an incredible amount of speed. It runs as fast as it can and slams into its enemy in combat, known as the 'comet dash'",bestiary[0][0][4][2]);
		bestiary[0][0][3][3]=new MonsterType("Flame Elemental",0,0,3,2,"The flame elemetal has is a chasis of black iron engulfed in flame",bestiary[0][0][4][3]);
		bestiary[0][0][2][0]=new MonsterType("Pyrus",0,0,2,0,"Pyrus is a three foot tall demon, engulfed in flame with an extending red snout like a dogs with black eyes and red iruses. His teeth shine in the light of his flames",bestiary[0][0][3][0],bestiary[0][0][3][1],skillSet[7]);
		bestiary[0][0][2][1]=new MonsterType("Flarpup",0,0,2,1,"The Flarpup is a small dog with hair that looks like fire. It inflicts fire damage with its bite",bestiary[0][0][3][2]);
		bestiary[0][0][2][2]=new MonsterType("Flame Symbol",0,0,2,2,"A circular golden band a foot and a half in diameter two inches thick holds a red sphere at its base. When it becomes angry the ring lights aflame and the flame symbol can be seen glowing in its center, althouh there is nothing there",bestiary[0][0][3][3]);
		bestiary[0][0][1][0]=new MonsterType("Flarial",0,0,1,0,"An orange ball of flame with a red eye. It hovers in the air, a foot above the ground, a sphere a foot in diameter. The ends of the flame flow behind it, althogh no wind can be felt",bestiary[0][0][2][0],bestiary[0][0][2][1],bestiary[0][0][2][2],skillSet[6]);
		bestiary[0][0][0][0]=new MonsterType("Pyro Egg",0,0,0,0,"An orange egg with the symbol of a red flame. When you touch it, it is warm, and you become angry, though you do not know why. Pull your hand away and you are burned, though by the egg or yourself you cannot tell",bestiary[0][0][1][0],skillSet[0]);
		bestiary[0][0][4][0].setEvolvesFrom(bestiary[0][0][3][0]);
		bestiary[0][0][4][1].setEvolvesFrom(bestiary[0][0][3][0]);
		bestiary[0][0][4][1].setEvolvesFrom2(bestiary[0][0][3][1]);
		bestiary[0][0][4][2].setEvolvesFrom(bestiary[0][0][3][2]);
		bestiary[0][0][4][3].setEvolvesFrom(bestiary[0][0][3][3]);
		bestiary[0][0][3][0].setEvolvesFrom(bestiary[0][0][2][0]);
		bestiary[0][0][3][1].setEvolvesFrom(bestiary[0][0][2][0]);
		bestiary[0][0][3][2].setEvolvesFrom(bestiary[0][0][2][1]);
		bestiary[0][0][3][3].setEvolvesFrom(bestiary[0][0][2][2]);
		bestiary[0][0][2][0].setEvolvesFrom(bestiary[0][0][1][0]);
		bestiary[0][0][2][1].setEvolvesFrom(bestiary[0][0][1][0]);
		bestiary[0][0][2][2].setEvolvesFrom(bestiary[0][0][1][0]);
		bestiary[0][0][1][0].setEvolvesFrom(bestiary[0][0][0][0]);
		bestiary[0][1]=new MonsterType[5][];
		bestiary[0][1][0]=new MonsterType[1];
		bestiary[0][1][1]=new MonsterType[1];
		bestiary[0][1][2]=new MonsterType[3];
		bestiary[0][1][3]=new MonsterType[3];
		bestiary[0][1][4]=new MonsterType[3];
		bestiary[0][1][4][0]=new MonsterType("Vulcanous",0,1,4,0,"Vulcanous is a walking colossus filled with lava");
		bestiary[0][1][4][1]=new MonsterType("Vagrus",0,1,4,1,"Vagrus is a lava dragon that levitates and doesnt have wings. Its skill is lavabreath");
		bestiary[0][1][4][2]=new MonsterType("Vulcan",0,1,4,2,"Vulcan is named after the god Vulcan and can cast all sorts of magic. It is a flaming wheel whose spokes have the elemental glyphs written on them. Its greatest strength is the breadth of magic that it ca cast. Also live long and prosper");
		bestiary[0][1][3][0]=new MonsterType("Philottus",0,1,3,0,"Philottus is a walking smelter with a big hammer. It can cover its hammer with lava to do 2.5 times as much damage on its next attack, but the buff only lasts for one turn, as then the cast cools",bestiary[0][1][4][0]);
		bestiary[0][1][3][1]=new MonsterType("Cercyon",0,1,3,1,"Cercyon is a lavasnake that can wrap itself around its prey. Doing so cools it, thus damaging both itself and its victim",bestiary[0][1][4][1]);
		bestiary[0][1][3][2]=new MonsterType("Spither",0,1,3,2,"Spither is a lava elemental that is capable of casting both fire and water magic. The large center circle holds the lava crest, and the six outer circles alternate between the fire and water crests",bestiary[0][1][4][2]);
		bestiary[0][1][2][0]=new MonsterType("Crerops",0,1,2,0,"Creops is a man size titan with no face made of melting stone. lava flows to its heart at its center and back to the rock, his only weak point",bestiary[0][1][3][0]);
		bestiary[0][1][2][1]=new MonsterType("Erichthonius",0,1,2,1,"Erichthonius is a lizard the size of a wolf made of magma. It spits lava to attack",bestiary[0][1][3][1]);
		bestiary[0][1][2][2]=new MonsterType("Corynetes",0,1,2,2,"Corynetes is a floating sphere of lava, that pulses from yellow to orange hot. it has a cracked shell of earth around which the lava flows.",bestiary[0][1][3][2]);		
		bestiary[0][1][1][0]=new MonsterType("Philammon",0,1,1,0,"Philammon was the weakest of the suns of vulcan, and the monster derived from him resembles a green ball with orange eyes and horns",bestiary[0][1][2][0],bestiary[0][1][2][1],bestiary[0][1][2][2]);
		bestiary[0][1][0][0]=new MonsterType("Lava Egg",0,1,0,0,"The volcano egg is orange and very hot, with a glyph on its center of a mountain with lava pouring down it. It dries out quickly and is best left in water",bestiary[0][1][1][0]);
		bestiary[0][1][4][0].setEvolvesFrom(bestiary[0][1][3][0]);
		bestiary[0][1][4][1].setEvolvesFrom(bestiary[0][1][3][1]);
		bestiary[0][1][4][2].setEvolvesFrom(bestiary[0][1][3][2]);
		bestiary[0][1][3][0].setEvolvesFrom(bestiary[0][1][2][0]);
		bestiary[0][1][3][1].setEvolvesFrom(bestiary[0][1][2][1]);
		bestiary[0][1][3][2].setEvolvesFrom(bestiary[0][1][2][2]);
		bestiary[0][1][2][0].setEvolvesFrom(bestiary[0][1][1][0]);
		bestiary[0][1][2][1].setEvolvesFrom(bestiary[0][1][1][0]);
		bestiary[0][1][2][1].setEvolvesFrom(bestiary[0][1][1][0]);
		bestiary[0][1][1][0].setEvolvesFrom(bestiary[0][1][0][0]);
		bestiary[0][2]=new MonsterType[5][];
		bestiary[0][2][0]=new MonsterType[1];
		bestiary[0][2][1]=new MonsterType[1];
		bestiary[0][2][2]=new MonsterType[3];
		bestiary[0][2][3]=new MonsterType[3];
		bestiary[0][2][4]=new MonsterType[3];
		bestiary[0][2][4][0]=new MonsterType("Great White Tyrant",0,2,4,0,"A great White tyrant is a larger version of the tyrant that is as white as bone. It also  has arm claws now, although why it needs them when it has that huge jaw is anyones guess. Its a reference to Jurassic World");
		bestiary[0][2][4][1]=new MonsterType("EdgeWinger",0,2,4,1,"The EdgeWinger is an evolved SteelWinger, that shaved off the edges of the steel so that its really really sharp, and a much lighter weight, so it can fly again");
		bestiary[0][2][4][2]=new MonsterType("Broncheospikesaur",0,2,4,2,"A gigantic spikesaur that has a mass of hp and can taunt all enemies at once, but its physical attack is very weak");
		bestiary[0][2][3][0]=new MonsterType("Tyrant",0,2,3,0,"A tyrant is a giant raptor with big teeth and skimpy arms",bestiary[0][2][4][0]);
		bestiary[0][2][3][1]=new MonsterType("SteelWinger",0,2,3,1,"A larger winger with a steel beak and wings. The winger thought it would be cool to have steel, but it didnt account for the weight, which slowed it down and keeps it from flying",bestiary[0][2][4][1]);
		bestiary[0][2][3][2]=new MonsterType("Spikevorsaur",0,2,3,2,"A Spikevorsaure is a large herbivour that got wise and grew spikes. Now it taunts enemies, and when they attack, a portion of the damage inflicted is returned to the enemy",bestiary[0][2][4][2]);
		bestiary[0][2][2][0]=new MonsterType("Raptor",0,2,2,0,"A small velociraptor that is very fast and knows the move Dinobite",bestiary[0][2][3][0]);
		bestiary[0][2][2][1]=new MonsterType("Winger",0,2,2,1,"A winger is a flying dinosaur that looks like a bat except it has a cone head. Yeah, brutally honest.",bestiary[0][2][3][1]);
		bestiary[0][2][2][2]=new MonsterType("Herbisaur",0,2,2,2,"A Herbisaur is large for in adolescent, and has a lot of hp. It can make itself look like a target, effectively taunting them.",bestiary[0][2][3][2]);
		bestiary[0][2][1][0]=new MonsterType("Salamander",0,2,1,0,"The salamander is a small dinosaur that can breathe fire.",bestiary[0][2][2][0],bestiary[0][2][2][1],bestiary[0][2][2][2]);
		bestiary[0][2][0][0]=new MonsterType("Dino Egg",0,2,0,0,"Call John Hammond, it finally happened, were going to be millionares!!",bestiary[0][2][1][0]);
		bestiary[0][2][4][0].setEvolvesFrom(bestiary[0][2][3][0]);
		bestiary[0][2][4][1].setEvolvesFrom(bestiary[0][2][3][1]);
		bestiary[0][2][4][2].setEvolvesFrom(bestiary[0][2][3][2]);
		bestiary[0][2][3][0].setEvolvesFrom(bestiary[0][2][2][0]);
		bestiary[0][2][3][1].setEvolvesFrom(bestiary[0][2][2][1]);
		bestiary[0][2][3][2].setEvolvesFrom(bestiary[0][2][2][2]);
		bestiary[0][2][2][0].setEvolvesFrom(bestiary[0][2][1][0]);
		bestiary[0][2][2][1].setEvolvesFrom(bestiary[0][2][1][0]);
		bestiary[0][2][2][2].setEvolvesFrom(bestiary[0][2][1][0]);
		bestiary[0][2][1][0].setEvolvesFrom(bestiary[0][2][0][0]);
		bestiary[0][3]=new MonsterType[5][];
		bestiary[0][3][0]=new MonsterType[1];
		bestiary[0][3][1]=new MonsterType[1];
		bestiary[0][3][2]=new MonsterType[3];
		bestiary[0][3][3]=new MonsterType[2];
		bestiary[0][3][4]=new MonsterType[1];
		bestiary[0][3][4][0]=new MonsterType("Fenghuang",0,3,4,0,"The Fenghuang is the king of phoenixes. It is a symbol of hope for the fallen that they may rise again");
		bestiary[0][3][3][0]=new MonsterType("Rock Cholk",0,3,3,0,"Large Chols are called Cholks. This one in particular loves its big rock, that it throws at people. It once paid a bill for a selfie, and was glad to do so",bestiary[0][3][4][0]);
		bestiary[0][3][3][1]=new MonsterType("FireEagle",0,3,3,1,"The Fire Eagle is an eagle on fire that can sream at its enemies",bestiary[0][3][4][0]);
		bestiary[0][3][2][0]=new MonsterType("Chol",0,3,2,0,"The Chol is a violent Phoenix with a six foot wingspan. It has red plumage underneath its wings and on its torso and head. the top of its wings are an orange flame. Also, it can light its claws afire when it is angry and defending its flock",bestiary[0][3][3][0]);
		bestiary[0][3][2][1]=new MonsterType("Firebird",0,3,2,1,"The firebird is based in slavic folklore and is known for generating a bonfire for lost travlers, pointing them to safety",bestiary[0][3][3][1]);
		bestiary[0][3][2][2]=new MonsterType("Fawke",0,3,2,2,"The fawkes, or flaming hawkes are descended from a legendary phoenix who gave a boy a hat. They are colored from orange to yellow on their torso and underwing, followed by red on the upper wing. Alone among the phoenixes, they cannot light themselves aflame, or simply choose not to. They often cry for the wounded",bestiary[0][3][3][1]);
		bestiary[0][3][1][0]=new MonsterType("Lesser Phoenix", 0,3,1,0,"The Lesser Phoenix has yet to gain much plumage, although its eye sparkles with understanding when you speak to it, and when you caress it, its eye closes with love, and you feel hope.",bestiary[0][3][2][0],bestiary[0][3][2][1],bestiary[0][3][2][2]);
		bestiary[0][3][0][0]=new MonsterType("Phoenix Egg", 0,3,0,0,"The egg hovers slightly above the ground and is lit aflame by a fire that gives no heat",bestiary[0][3][1][0]);
		bestiary[0][3][4][0].setEvolvesFrom(bestiary[0][3][3][0]);
		bestiary[0][3][4][0].setEvolvesFrom2(bestiary[0][3][3][1]);
		bestiary[0][3][3][0].setEvolvesFrom(bestiary[0][3][2][0]);
		bestiary[0][3][3][1].setEvolvesFrom(bestiary[0][3][2][1]);
		bestiary[0][3][3][1].setEvolvesFrom2(bestiary[0][3][2][2]);
		bestiary[0][3][2][0].setEvolvesFrom(bestiary[0][3][1][0]);
		bestiary[0][3][2][1].setEvolvesFrom(bestiary[0][3][1][0]);
		bestiary[0][3][2][1].setEvolvesFrom(bestiary[0][3][1][0]);
		bestiary[0][3][1][0].setEvolvesFrom(bestiary[0][3][0][0]);
		bestiary[0][4]=new MonsterType[5][];
		bestiary[0][4][0]=new MonsterType[1];
		bestiary[0][4][1]=new MonsterType[1];
		bestiary[0][4][2]=new MonsterType[2];
		bestiary[0][4][3]=new MonsterType[2];
		bestiary[0][4][4]=new MonsterType[2];
		bestiary[0][4][4][0]=new MonsterType("Zireal",0,4,4,0,"The Zireal is the angel of justice. Wears a white garb with a golden tassle. Blindfolded with a white cloth, but never misses. Weilds a sword in one hand and scales in the other");
		bestiary[0][4][4][1]=new MonsterType("Justicier",0,4,4,1,"The Justicier is a quiet robed figure, who can speak into the ears of the wicked. For her, the ends justify the means, and any means will be used to the betterment of mankind");
		bestiary[0][4][3][0]=new MonsterType("Ordinator",0,4,3,0,"The ordinator is a justicar who has served for its term as a city guard and now goes forth to right whatever wrong it sees. It stands in shining white steel platemail with a steel sheild edged in gold with a knee length white silk cape edgd in gold");
		bestiary[0][4][3][1]=new MonsterType("Anyr",0,4,3,1,"The Anyr is a judge that has been given the full authority of the church to act in the interest of the greater good in whatever way it thinks best. It can only be second guessed by a clergyman ranked bishop or higher. It has the ability to cast a spell that heals all light elementals and harms all dark elementals, but does not descriminate between friend and foe. It is loosely based on the amyr form Patrick Rothfuss' kingkiller chronicles. which you should read, by the way.");
		bestiary[0][4][2][0]=new MonsterType("Justicar",0,4,2,0,"The justicar appears as a lesser knight in shining chianmail and a golden crest upon its helm. It holds a wooden shield painted white in its left hand with an iron sword in its right. It has a cloth half cape edged in yellow. The justicar believes solidly in the rule of law and protects the weak. However, if it views the weak to be unvirtuous, it will leave them to suffer, believing that their karma will sort them out");
		bestiary[0][4][2][1]=new MonsterType("Ayurved",0,4,2,1,"The Ayurved is a healer that calls upon faith to direct the healing of its god. It is better at healing the virtuous, and refuses to touch the vile");
		bestiary[0][4][1][0]=new MonsterType("Angier",0,4,1,0,"The angier has a very sophomoric view of whats right and wrong, and when it percieves some slight against itself or its god, it runs up, quite childishly and demands satisfaction, regardless how much larger the villan is");
		bestiary[0][4][0][0]=new MonsterType("Justice Egg",0,4,0,0,"The egg white with a golden flame symbol in its center. When it is near you you are stronger in your convictions, and obsess over your sins, feeling regret and the desire to make things right");
		bestiary[0][4][4][0].setEvolvesFrom(bestiary[0][4][3][0]);
		bestiary[0][4][4][1].setEvolvesFrom(bestiary[0][4][3][1]);
		bestiary[0][4][3][0].setEvolvesFrom(bestiary[0][4][2][0]);
		bestiary[0][4][3][1].setEvolvesFrom(bestiary[0][4][2][1]);
		bestiary[0][4][2][0].setEvolvesFrom(bestiary[0][4][1][0]);
		bestiary[0][4][2][1].setEvolvesFrom(bestiary[0][4][1][0]);
		bestiary[0][4][1][0].setEvolvesFrom(bestiary[0][4][0][0]);
		bestiary[0][5]=new MonsterType[5][];
		bestiary[0][5][0]=new MonsterType[1];
		bestiary[0][5][1]=new MonsterType[1];
		bestiary[0][5][2]=new MonsterType[3];
		bestiary[0][5][3]=new MonsterType[2];
		bestiary[0][5][4]=new MonsterType[1];
		bestiary[0][5][4][0]=new MonsterType("Revenant",0,5,4,0,"The revenant wears black steel, outlined with sharp red lines. The full helm covers the entire head and has red horns, though wether these horns are a part of the helmet or the demon is unknown. It weilds a large sword that appears to be worn down and rusty, but shines when covered with the blood of the guilty. The helmet opens with a Y , where the top is curved.");
		bestiary[0][5][3][0]=new MonsterType("Halfrec",0,5,3,0,"A Halfrec is a female vengence demon with bat wings. It is unforgiving, and believes itself to be doing what is right. They are slowly coming back after a 'buff' vampire slayer killed most of them",bestiary[0][5][3][0]);
		bestiary[0][5][3][1]=new MonsterType("D'Hoffry",0,5,3,1,"The D'Hoffry are male vengence angels with red wings. They are crueler than their cousins, the Halfrecs.",bestiary[0][5][4][0]);
		bestiary[0][5][2][0]=new MonsterType("Jacobia",0,5,2,0,"The jacobia looks for all intents and purposes, a demon. It hates all the evil in the world with a passion. It represents the hotter, angrier side of vengence. It plans to kill them all but does not realize, after all the evil has been slain, it will still have one last murder to preform. It does bonus damage to creatures with a dark element, and less damage to creatures with a light element. Description inspiration: Death Note Season 1 episode 1",bestiary[0][5][4][0]);		
		bestiary[0][5][2][1]=new MonsterType("Letham",0,5,2,1,"A letham is a creature that once loved passionately and had its love taken away. It is patient and waits for the time to strike, resembling an emo teenager. Its name is an anagram of hamlet",bestiary[0][5][3][0],bestiary[0][5][3][1]);
		bestiary[0][5][2][2]=new MonsterType("Lizebet",0,5,2,2,"It is a play on the Elizabethean revenge tragedy. She has an obsidian curving circlet on her forhead, coming to a point in the center of her brow. Her skin is ashen, her hair bloodred, her eyes, that only open when she casts spells, are yellow. She represents the quiet revenge, cold and calculated, and speaks seldom, then only in a whisper. To tell her allies why they failed her, at the summit of their deffeat",bestiary[0][5][3][1]);
		bestiary[0][5][1][0]=new MonsterType("Spiten",0,5,1,0,"A spiten is a class of inferior imp that has needle like teeth, a bright red goblinesque body and black eyes.",bestiary[0][5][2][0],bestiary[0][5][2][1],bestiary[0][5][2][2]);
		bestiary[0][5][0][0]=new MonsterType("Vengence Egg",0,5,0,0,"The egg is split in half, half red, half black, with a symmetric crest in the center. On the black side, the crest is in red, on the red side, the crest is in black. The crest itself looks like a flame, except wider than possible, and the end of the flame flicks into a cruel point. When it is near, you remember all the things that you love that were taken from you, the egg incites you to claim vengence. If broken, it casts a lesser curse on the breaker",bestiary[0][5][1][0]);
		bestiary[0][5][4][0].setEvolvesFrom(bestiary[0][5][3][0]);
		bestiary[0][5][4][0].setEvolvesFrom2(bestiary[0][5][3][1]);
		bestiary[0][5][3][0].setEvolvesFrom(bestiary[0][5][2][0]);
		bestiary[0][5][3][0].setEvolvesFrom2(bestiary[0][5][2][1]);
		bestiary[0][5][3][1].setEvolvesFrom(bestiary[0][5][2][1]);
		bestiary[0][5][3][1].setEvolvesFrom2(bestiary[0][5][2][2]);
		bestiary[0][5][2][0].setEvolvesFrom(bestiary[0][5][1][0]);
		bestiary[0][5][2][1].setEvolvesFrom(bestiary[0][5][1][0]);
		bestiary[0][5][2][2].setEvolvesFrom(bestiary[0][5][1][0]);
		bestiary[0][5][1][0].setEvolvesFrom(bestiary[0][5][0][0]);
		bestiary[1][0]=new MonsterType[5][];
		bestiary[1][0][0]=new MonsterType[1];
		bestiary[1][0][1]=new MonsterType[1];
		bestiary[1][0][2]=new MonsterType[1];
		bestiary[1][0][3]=new MonsterType[1];
		bestiary[1][0][4]=new MonsterType[1];
		bestiary[1][0][4][0]=new MonsterType("Greater Steamlet",1,0,4,0,"The Greater steamlet is known only by the rare master that tries to collect them all, because its relatively useless and very hard to obtain. As you are reading this, you must have obtained it, so congradulations, you have found one of the most obscure elders. Sorry its not very useful in combat or anywhere else");
		bestiary[1][0][3][0]=new MonsterType("Steamlet",1,0,3,0,"The steamlet is a mature monster that no longer laughs at childish or raunchy jokes. As such, its soul is dead, and its not fun to be around, especially if its friends are older. It has uncommon yellow phosporous at its core",bestiary[1][0][4][0]);
		bestiary[1][0][2][0]=new MonsterType("Lesser Steamlet",1,0,2,0,"The lesser steamlet is a slightly older steamlet that can breifly dissapate and come back together. Is it strategically advantageous? Probably only if your delaying for the ressurection of a phoenix. A larger amount of white phosporus is in its core",bestiary[1][0][3][0]);
		bestiary[1][0][1][0]=new MonsterType("Minor Steamlet",1,0,1,0,"The lesser steamlet is a young demon made of steam. It cannot be harmed by physical attacks, but has very little health. A small amount of white phosporus drives its core, and if this phosporous is damaged, it will die quickly",bestiary[1][0][2][0]);
		bestiary[1][0][0][0]=new MonsterType("Steam Egg",1,0,0,0,"Steam continually rises off of this egg. A nest of them are often put underneath a spa. They're not very nice to carry, because they drench whatever they are carried in in hot water. It also may be an obscure refrence to the foglets from the witcher series",bestiary[1][0][1][0]);
		bestiary[1][0][4][0].setEvolvesFrom(bestiary[1][0][3][0]);
		bestiary[1][0][3][0].setEvolvesFrom(bestiary[1][0][2][0]);
		bestiary[1][0][2][0].setEvolvesFrom(bestiary[1][0][1][0]);
		bestiary[1][0][1][0].setEvolvesFrom(bestiary[1][0][0][0]);
		bestiary[1][1]=new MonsterType[5][];
		bestiary[1][1][0]=new MonsterType[1];
		bestiary[1][1][1]=new MonsterType[1];
		bestiary[1][1][2]=new MonsterType[3];
		bestiary[1][1][3]=new MonsterType[3];
		bestiary[1][1][4]=new MonsterType[3];
		bestiary[1][1][4][0]=new MonsterType("Blue Dragon",1,1,4,0,"A blue dragon that lives under the sea. It is scaleless and can breath a water pulse at its enemies");
		bestiary[1][1][4][1]=new MonsterType("Levithan",1,1,4,1,"A leviathan is a giant sea monster that can shoot a very pressured stream of water at its enemies. It grew from a huge collection of cuddlerfish that fused together");
		bestiary[1][1][4][2]=new MonsterType("Aqua Atronach",1,1,4,2,"An Aqua Atronach is a collection of Elementals, a large one in the center with the five other elements represented as smaller elementals around the edge. When the Atronach wants to cast spells from other elements, it pulls that elemental into the center and channels its magic energy though both");
		bestiary[1][1][3][0]=new MonsterType("SliceFinn",1,1,3,0,"Slicefinn is a shark. A hammerhead shark whose front finn is sharpened steel",bestiary[1][1][4][0]);
		bestiary[1][1][3][1]=new MonsterType("Snugglerfish",1,1,3,1,"The Snugglerfish is a pair of cuddlefish that have attached and grown large. Its move is snuggle",bestiary[1][1][4][1]);
		bestiary[1][1][3][2]=new MonsterType("Aqua Elemental",1,1,3,2,"The Aqua Elemental is a large aqua symbol that has six crystallized water droplets on each of its six points",bestiary[1][1][4][2]);
		bestiary[1][1][2][0]=new MonsterType("EdgeFinn",1,1,2,0,"EdgeFinn is a larger version of the Minnow with a serrated crest and finns, as well as small, razor sharp teeth. unlike most fish, its eyes  face forward to stalk its prey, like the carnivores on land",bestiary[1][1][3][0]);
		bestiary[1][1][2][1]=new MonsterType("Cuddlerfish",1,1,2,1,"A Cuddlerfish is shaped like a Cuttlefish but also loves cuddling. Thats why typically they come in pairs. They seperate infrequently, and when they do, both halves become very needy and inevitably float back together.",bestiary[1][1][3][1]);
		bestiary[1][1][2][2]=new MonsterType("Aqua Symbol",1,1,2,1,"A silver Taurus, with a sapphire sphere at its base. Etched on the Sapphire Sphere is the water Symbol. When it attacks, the crest apears in the center of the Taurus, and water drips from it. When one is near, calmness and complasency echoes in the mind.",bestiary[1][1][3][2]);
		bestiary[1][1][1][0]=new MonsterType("Minnow",1,1,1,0,"Minnow is a small blue fish with a green eye and finn. It floats in the air as if it were swimming in water. Why? How? Why did physics just suddenly stop working? BECAUSE I SAID SO. Thats why",bestiary[1][1][2][0],bestiary[1][1][2][1],bestiary[1][1][2][2]);
		bestiary[1][1][0][0]=new MonsterType("Aqua Egg",1,1,0,0,"The egg faintly glows cyan when left in water. It is a light blue perfect egg shape, with the water crest in dark blue emblazoned across it. When brought out of water it dries. If it dries enough to crack the monster inside may be close to death, however submerging it in water again and the shell will regenerate",bestiary[1][1][1][0],skillSet[2]);
		bestiary[1][1][4][0].setEvolvesFrom(bestiary[1][1][3][0]);
		bestiary[1][1][4][1].setEvolvesFrom(bestiary[1][1][3][1]);
		bestiary[1][1][4][2].setEvolvesFrom(bestiary[1][1][3][2]);
		bestiary[1][1][3][0].setEvolvesFrom(bestiary[1][1][2][0]);
		bestiary[1][1][3][1].setEvolvesFrom(bestiary[1][1][2][1]);
		bestiary[1][1][3][2].setEvolvesFrom(bestiary[1][1][2][2]);
		bestiary[1][1][2][0].setEvolvesFrom(bestiary[1][1][1][0]);
		bestiary[1][1][2][1].setEvolvesFrom(bestiary[1][1][1][0]);
		bestiary[1][1][2][2].setEvolvesFrom(bestiary[1][1][1][0]);
		bestiary[1][1][1][0].setEvolvesFrom(bestiary[1][1][0][0]);
		bestiary[1][2]=new MonsterType[5][];
		bestiary[1][2][0]=new MonsterType[1];
		bestiary[1][2][1]=new MonsterType[1];
		bestiary[1][2][2]=new MonsterType[3];
		bestiary[1][2][3]=new MonsterType[3];
		bestiary[1][2][4]=new MonsterType[3];
		bestiary[1][2][4][0]=new MonsterType("Tonguedancer",1,2,4,0,"Despite being unrelated to air, the Tonguedancer is very quick and agile, using all four limbs in addition to its tongue to manipulate the world around it");
		bestiary[1][2][4][1]=new MonsterType("Frogealer",1,2,4,1,"The Frogealer is a shifty frog whose slime has addictive hallucinogenic properties. When attacked with physical attacks, interesting things can happen");
		bestiary[1][2][4][2]=new MonsterType("Meititode",1,2,4,2,"The Meititode is constantly in meditation. It shields itself in a sphere of mud to protect itself. It is rightly considered the master of the natural elements, and can cast all levels of the natural magics. However, it is vulnerable to the moral elements");
		bestiary[1][2][3][0]=new MonsterType("Frogar",1,2,3,0,"The frogar is a giant toad witha spiked tongue that uses the tongue in combat. The tongue itself is as hard as iron. It wears a vest with an oriental 'Frog fu' symbol on it, which would make you think its great at martial arts, but its not. Its just trying to be cool",bestiary[1][2][4][0]);
		bestiary[1][2][3][1]=new MonsterType("Frogaudy",1,2,3,1,"The frogaudy is not only rainbow, it also sparkles. It found this fake diamond ring once, thought it was shiny and awesome, and its wardrobe has only gotten shinier since then. Now it has a golden hat and a monocole as well",bestiary[1][2][4][1]);
		bestiary[1][2][3][2]=new MonsterType("Esotoad",1,2,3,2,"The esotoads left arm is blue, and its right arm is green. With its left it has telekineic control over the water, with its right it has telekinetic control over the earth. It became too lazy to walk long ago, and now whenever it wants to go somewhere it will conjure a sphere of water to float in, or a mass of land to sit upon that it then guides to its destination",bestiary[1][2][4][2]);
		bestiary[1][2][2][0]=new MonsterType("Froget",1,2,2,0,"The Froget is a three foot tall frog that weilds a wooden spear. Its big black monochrome eyes stare into the deep darkness of the soul. Or so I've been told. I don't think its true actually, I just think its dumb.",bestiary[1][2][3][0]);
		bestiary[1][2][2][1]=new MonsterType("RainbowFrog",1,2,2,1,"The rainbow frog is a frog that is colored like a rainbow. It was nearly hunted to extinction by the leprechauns, but they gave up when they realized that it wasn't always sitting on a pot of gold. In fact, it never was. Poor dead rainbow Frogs...",bestiary[1][2][3][1]);
		bestiary[1][2][2][2]=new MonsterType("Frogami",1,2,2,2,"The frogami likes nothing better than to sit and meditate. It has mystic powers, and can see glimpses of the future. Licking its back is supposed to bring bad luck, which makes me wonder why anyone would do it, because its poisonous and causes hallucinations. And while your hallucinating, theres an angry magic frog annoyed that you licked its back. Or is that the hallucination? Little known fact: it was cut out of naruto because it was too cool for either jyria or Naruto to learn from",bestiary[1][2][3][2]);
		bestiary[1][2][1][0]=new MonsterType("Tapple",1,2,1,0,"The Tapple's parents were terrible at naming babies, so they asked the tapple what it would like to be called. It tried to say tadpole, but as it was a baby, it couldn't pronounce it properly. The name stuck. The tapple is blue-green and is very proud of its long double-finned tail. Its parents told it not to get too attached, but it did anyway",bestiary[1][2][2][0],bestiary[1][2][2][1],bestiary[1][2][2][2]);
		bestiary[1][2][0][0]=new MonsterType("Amphibious Egg",1,2,0,0,"The egg is a perfect sphere, blue and green with a lighter yolk in the center, seemingly unformed except for a black eve. the egg itself is happy in water or land, as the name implies",bestiary[1][2][1][0]);
		bestiary[1][2][4][0].setEvolvesFrom(bestiary[1][2][3][0]);
		bestiary[1][2][4][1].setEvolvesFrom(bestiary[1][2][3][1]);
		bestiary[1][2][4][2].setEvolvesFrom(bestiary[1][2][3][2]);
		bestiary[1][2][3][0].setEvolvesFrom(bestiary[1][2][2][0]);
		bestiary[1][2][3][1].setEvolvesFrom(bestiary[1][2][3][1]);
		bestiary[1][2][3][2].setEvolvesFrom(bestiary[1][2][3][2]);
		bestiary[1][2][2][0].setEvolvesFrom(bestiary[1][2][1][0]);
		bestiary[1][2][2][1].setEvolvesFrom(bestiary[1][2][1][0]);
		bestiary[1][2][2][2].setEvolvesFrom(bestiary[1][2][1][0]);
		bestiary[1][2][1][0].setEvolvesFrom(bestiary[1][2][0][0]);
		bestiary[1][3]=new MonsterType[5][];
		bestiary[1][3][0]=new MonsterType[1];
		bestiary[1][3][1]=new MonsterType[1];
		bestiary[1][3][2]=new MonsterType[3];
		bestiary[1][3][3]=new MonsterType[5];
		bestiary[1][3][4]=new MonsterType[2];
		bestiary[1][3][4][0]=new MonsterType("Thunderus",1,3,4,0,"The Thunderus is a lightening dragon that flies through the clouds. Its roar is frightening to behold");
		bestiary[1][3][4][1]=new MonsterType("Cumulonimbus",1,3,4,1,"The Cumulonimbus is a magical weather system that can cast two weather magics at once");
		bestiary[1][3][3][0]=new MonsterType("Nephol",1,3,3,0,"The nephol is a cloud dragon with a yellow head an claws and no wings because it can float. It breathes lightening at its enemies",bestiary[1][3][4][0]);
		bestiary[1][3][3][1]=new MonsterType("Cirricumulus",1,3,3,1,"The Cirricumulus is less concerned with rain and more concerned with air currents. It can cast air funnel which increases the damage of air-based attacks for the duration of the battle. In appearance its a greater wolf with a very long tail that is often wrapped around itself",bestiary[1][3][4][0]);
		bestiary[1][3][3][2]=new MonsterType("CumuloStratus",1,3,3,2,"The CumuloStratus can spread itself thin and use the water droplets that make up its mass as a lens to focus the sun on the battlefield, increasing fire and solar damage. However, it cannot attack while this is going on. In apperance it is rather formless, drifting high",bestiary[1][3][4][0],bestiary[1][3][4][1]);
		bestiary[1][3][3][3]=new MonsterType("Stratonimbus",1,3,3,3,"The StratoNimbus looks like an old goat when in corporeal form. It can change form to appear as a mist that surrounds the battlefield. When it does this, visibility is decreased for both sides, and water and ice attacks are strengthened",bestiary[1][3][4][1]);
		bestiary[1][3][3][4]=new MonsterType("NimbuloPonderant",1,3,3,4,"The Nimbuloponderant is a greater turtle that can cast heavy rain on the battlefield. The effect is the same as rain except 1.3 times stronger and weather attacks are strengthened",bestiary[1][3][4][1]);
		bestiary[1][3][2][0]=new MonsterType("Cumulus",1,3,2,0,"A towering cloud with a yellow wolfs head that has no compunction about gliding down and biting something with its thunderFang when annoyed",bestiary[1][3][3][0],bestiary[1][3][3][1],bestiary[1][3][3][2]);
		bestiary[1][3][2][1]=new MonsterType("Stratus",1,3,2,1,"The stratus is a cloud with a somber sheeps head that is very depressed and cries all the time. This is why it rains often when this particular cloud is out. It is highly against convective slavery, and even calls itself a free-convective.",bestiary[1][3][3][2],bestiary[1][3][3][3]);
		bestiary[1][3][2][2]=new MonsterType("Nimbus",1,3,2,2,"The nimbus basically looks like a floating turtle with glasses, except the shell is a cloud and the head is yellow with a lame curly loop for hair. Its glasses are black, how they float I don't know",bestiary[1][3][3][3],bestiary[1][3][3][4]);
		bestiary[1][3][1][0]=new MonsterType("Cirrus",1,3,1,0,"A small cloud that curves around like a snake. It has no mouth and a small blue diamond on its head, its body is covered by fog, and it is lighter than air.",bestiary[1][3][2][0],bestiary[1][3][2][1],bestiary[1][3][2][2]);
		bestiary[1][3][0][0]=new MonsterType("Weather Egg",1,3,0,0,"The weather egg has a grey surface with the weather crest (a circle with a cloud and thunderbold) emblazoned on the center. It will yeild if you push into it, it has a flexible shell, that seems to smoke, except the smoke is a very light color",bestiary[1][3][1][0]);
		bestiary[1][3][4][0].setEvolvesFrom1(bestiary[1][3][3][0]);
		bestiary[1][3][4][0].setEvolvesFrom2(bestiary[1][3][3][1]);
		bestiary[1][3][4][0].setEvolvesFrom3(bestiary[1][3][3][2]);
		bestiary[1][3][4][1].setEvolvesFrom1(bestiary[1][3][3][2]);
		bestiary[1][3][4][1].setEvolvesFrom2(bestiary[1][3][3][3]);
		bestiary[1][3][4][1].setEvolvesFrom3(bestiary[1][3][3][4]);
		bestiary[1][3][3][0].setEvolvesFrom1(bestiary[1][3][2][0]);
		bestiary[1][3][3][1].setEvolvesFrom1(bestiary[1][3][2][0]);
		bestiary[1][3][3][2].setEvolvesFrom1(bestiary[1][3][2][0]);
		bestiary[1][3][3][2].setEvolvesFrom2(bestiary[1][3][2][1]);
		bestiary[1][3][3][3].setEvolvesFrom1(bestiary[1][3][2][1]);
		bestiary[1][3][3][3].setEvolvesFrom2(bestiary[1][3][2][2]);
		bestiary[1][3][3][4].setEvolvesFrom1(bestiary[1][3][2][2]);
		bestiary[1][3][2][0].setEvolvesFrom(bestiary[1][3][1][0]);
		bestiary[1][3][2][1].setEvolvesFrom(bestiary[1][3][1][0]);
		bestiary[1][3][2][2].setEvolvesFrom(bestiary[1][3][1][0]);
		bestiary[1][3][1][0].setEvolvesFrom(bestiary[1][3][0][0]);
		bestiary[1][4]=new MonsterType[5][];
		bestiary[1][4][0]=new MonsterType[1];
		bestiary[1][4][1]=new MonsterType[1];
		bestiary[1][4][2]=new MonsterType[3];
		bestiary[1][4][3]=new MonsterType[5];
		bestiary[1][4][4]=new MonsterType[5];
		bestiary[1][4][4][0]=new MonsterType("Bearon",1,4,4,0,"The Beaorn is a great polar bear with silver plating chased blue.");
		bestiary[1][4][4][1]=new MonsterType("Emperorguin",1,4,4,1,"The Emperorguin is the unquestioned leader of the guins and has red and yellow plumage to symbolize its authority. It has a passive ability that icreases the damage done by all ice attacks for the attackers side");
		bestiary[1][4][4][2]=new MonsterType("WhiteRunner",1,4,4,2,"The white runner is one of the generals of the white army, and can move very quickly despite its monstrous size");
		bestiary[1][4][4][3]=new MonsterType("Freezer",1,4,4,3,"The Freezer is a demon that can move swiftly through ice the same way fish swim through water. It is sneaky and will often appear behind enemies and stab them with its icicle");
		bestiary[1][4][4][4]=new MonsterType("Ice Lich",1,4,4,4,"The Ice lich is the penultimate ice demon that has transformed itself into full lich form. As such, it is very hard to destroy");
		bestiary[1][4][3][0]=new MonsterType("Freki",1,4,3,0,"The freki is an ice wolf that has ice instead of fangs, its fur is white, and it is capable of using ice fang",bestiary[1][4][4][0]);
		bestiary[1][4][3][1]=new MonsterType("Kinguin",1,4,3,1,"The kinguin has distuinguished itself on the field of battle for the Emperorguin, and has been afforded territories as such. It has yellow plumage on its head that represents its crown, however it is nowhere near as robust as the Emperorguin's",bestiary[1][4][4][1]);
		bestiary[1][4][3][2]=new MonsterType("White Limper",1,4,3,2,"The white limper is an ice zombie that weilds a sword of ice and for some odd reason holds a grudge against people wearing black clothing, cloakes in particular",bestiary[1][4][4][2]);
		bestiary[1][4][3][3]=new MonsterType("Chiller",1,4,3,3,"the Chiller is a ice demon with a great ice trident, black horns and white-blue eyes that bore into the soul. Also a huge Michael Jackson fan, loves 'Thriller' in particular, but its rather tonedeaf, and thinks Michael is talking about it in the song.",bestiary[1][4][4][3]);
		bestiary[1][4][3][4]=new MonsterType("Ice Witch",1,4,3,4,"the Ice witch is exactly what it sounds like",bestiary[1][4][4][4]);
		bestiary[1][4][2][0]=new MonsterType("FauxIce",1,4,2,0,"The FauxIce is a timid ice fox with a white pelt. It often makes ice sculptures of itself to decoy enemies. It can only do this once per battle though",bestiary[1][4][3][0]);
		bestiary[1][4][2][1]=new MonsterType("Princeguin",1,4,2,1,"The Princeguin is a young emperor penguin that has yet to prove its worth. In penguin society, blood means little, so though the Princeguin was born in the royal family, he still has work to do before being a contender for the throne",bestiary[1][4][3][1]);
		bestiary[1][4][2][2]=new MonsterType("IceBreaker",1,4,2,2,"The icebreaker is an ice demon with a staff that has a large snowflake on its crest. It casts cold magic, and is great at starting conversations with women, especilly at parties. It knows lots of good pick up lines and even more bad ones",bestiary[1][4][3][2],bestiary[1][4][3][3],bestiary[1][4][3][4]);
		bestiary[1][4][1][0]=new MonsterType("Snoball",1,4,1,0,"The Snoball is a ball of snow, and no one can tell quite whats inside, as many different young snow creatures stay in the ball of snow until a teenager. It has the passive ability melt, which lessens the other teams fire abilities after it is slain",bestiary[1][4][2][0],bestiary[1][4][2][1],bestiary[1][4][2][2]);
		bestiary[1][4][0][0]=new MonsterType("Ice Egg",1,4,0,0,"The Ice Egg has a snow glyph on its belly. The top and bottom of the egg are crested in frost, and the rest of the shell is a cool blue. When dropped in water, it will float to the surface and create an ice island around itself, it cannot do this indefinately, as cooling the matter around it takes energy from the baby inside, who cannot live in conditions much beyond freezing",bestiary[1][4][1][0]);
		bestiary[1][4][4][0].setEvolvesFrom(bestiary[1][4][3][0]);
		bestiary[1][4][4][1].setEvolvesFrom(bestiary[1][4][3][1]);
		bestiary[1][4][4][2].setEvolvesFrom(bestiary[1][4][3][2]);
		bestiary[1][4][4][3].setEvolvesFrom(bestiary[1][4][3][3]);
		bestiary[1][4][4][4].setEvolvesFrom(bestiary[1][4][3][4]);
		bestiary[1][4][3][0].setEvolvesFrom(bestiary[1][4][2][0]);
		bestiary[1][4][3][1].setEvolvesFrom(bestiary[1][4][2][1]);
		bestiary[1][4][3][2].setEvolvesFrom(bestiary[1][4][2][2]);
		bestiary[1][4][3][3].setEvolvesFrom(bestiary[1][4][2][2]);
		bestiary[1][4][3][3].setEvolvesFrom(bestiary[1][4][2][2]);
		bestiary[1][4][2][0].setEvolvesFrom(bestiary[1][4][1][0]);
		bestiary[1][4][2][1].setEvolvesFrom(bestiary[1][4][1][0]);
		bestiary[1][4][2][2].setEvolvesFrom(bestiary[1][4][1][0]);
		bestiary[1][4][1][0].setEvolvesFrom(bestiary[1][4][0][0]);
		bestiary[1][5]=new MonsterType[5][];
		bestiary[1][5][0]=new MonsterType[1];
		bestiary[1][5][1]=new MonsterType[1];
		bestiary[1][5][2]=new MonsterType[3];
		bestiary[1][5][3]=new MonsterType[6];
		bestiary[1][5][4]=new MonsterType[5];
		bestiary[1][5][4][0]=new MonsterType("Kraken",1,5,4,0,"The Kraken is a sea monster that is capable of breaking ships with its limbs. Its a really dangerous giant squid. If you're having trouble picturing it, think Pirates of the Carribean, Dead mans chest");
		bestiary[1][5][4][1]=new MonsterType("Hitokiristar",1,5,4,1,"The Hitokiristar is a ninja starfish that has other starfish underneath it, which it throws at its enemies");
		bestiary[1][5][4][2]=new MonsterType("Abysstar",1,5,4,2,"The Abysstar moves through the water using magic that it puslates through its five arms. It can cast darkpressure on its enemies, who feel the hoplessness of being lost at the floor of the ocean being crushed by hundreds of thousands of pounds of water above them. It has many small places on the seafloor where it has placed  satanic rituals and it travels between them for unknown purposes");//TODO change to DeathStarFish
		bestiary[1][5][4][3]=new MonsterType("Hydoridolina",1,5,4,3,"The Hydoridolinia is actually a group of Hydroza and smaller jellyfish that comes together and is controlled by a single conscious mind.");
		bestiary[1][5][4][4]=new MonsterType("Trachylina",1,5,4,4,"The Trachylina is an ascendent deep magical user that can use pressure pulse on all enemies");
		bestiary[1][5][3][0]=new MonsterType("Vasquid",1,5,3,0,"The Vasquid is a full-fledged giant sqid that is the size of a house when under water and considerably smaller when over land. Its tentacles are very strong and hard and can break even the most resilient bones. The only way to survive this fish is to dodge it",bestiary[1][5][4][0]);
		bestiary[1][5][3][1]=new MonsterType("Ninjastar",1,5,3,1,"The Ninjastar is a starish that gained sharp blades on its arms. To attack it throws itself at its enemies.",bestiary[1][5][4][1]);
		bestiary[1][5][3][2]=new MonsterType("Darkstar",1,5,3,2,"The Darkstar is a starish that became interested in black magic. its flesh has turned black in response, and it casts magic from the end of its five arms. Each end appears to be lit aflame with blue flame, but it is actual a chemical reaction",bestiary[1][5][4][2]);
		bestiary[1][5][3][3]=new MonsterType("Hydroza",1,5,3,3,"The Hydroza is a translucent (and nearly invisible in dark water) large jellyfish that constricts its prey and eats them alive. As the fish is translucent, it is the only known monster in which you can see a prey species being digested. It has poisonous spikes on the mandibles with which it attacks its prey",bestiary[1][5][4][3]);
		bestiary[1][5][3][4]=new MonsterType("Stauroza",1,5,3,4,"The Stauroza is a large opaque black jellyfish that has a white star on the inside of the top of its bell. It can direct this light like a flashlight onto unsuspecting prey that swim towards the light, unaware that the Stauroze is about to devour them",bestiary[1][5][4][4]);
		bestiary[1][5][3][5]=new MonsterType("Scyphozoa",1,5,3,5,"The bell of the Scyphozoa is rings of Black and dark blue. It can form glyphs with its arms, with which it casts spells. The skill related to it is inksign, which lowers accuracy to water types, and deals damage",bestiary[1][5][4][4]);
		bestiary[1][5][2][0]=new MonsterType("Inker",1,5,2,0,"The inker is a baby giant squid (in other words, a squid) that squirts ink in the eyes of its enemies, lowering their accuracy",bestiary[1][5][3][0]);
		bestiary[1][5][2][1]=new MonsterType("Starish",1,5,2,1,"The Starish is called so because it is kinda like a star except its also a fish",bestiary[1][5][3][1],bestiary[1][5][3][2]);
		bestiary[1][5][2][2]=new MonsterType("jelly",1,5,2,2,"The jelly is a small fish that is bell shaped and floats around. It wraps its tail around its enemies to sting them",bestiary[1][5][3][3],bestiary[1][5][3][4],bestiary[1][5][3][5]);
		bestiary[1][5][1][0]=new MonsterType("Deepfish",1,5,1,0,"The deepfish is a small fish used to the echoes of the darkness. Its face is sunken, its scales are dark and ruddy, the spines of its fin are black, but the webbing is blue",bestiary[1][5][2][0],bestiary[1][5][2][1],bestiary[1][5][2][2]);
		bestiary[1][5][0][0]=new MonsterType("Deep Egg",1,5,0,0,"The deep egg is used to being shrouded in the darkness of the deep, and is nearly unbreakable, as it is used to the pressure on the bottom of the seafloor. It can regulate its internal pressure. When another primary water elemental is in play, its defense rises by half again",bestiary[1][5][1][0]);
		bestiary[1][5][4][0].setEvolvesFrom(bestiary[1][5][3][0]);
		bestiary[1][5][4][1].setEvolvesFrom(bestiary[1][5][3][1]);
		bestiary[1][5][4][2].setEvolvesFrom(bestiary[1][5][3][2]);
		bestiary[1][5][4][3].setEvolvesFrom(bestiary[1][5][3][3]);
		bestiary[1][5][4][4].setEvolvesFrom1(bestiary[1][5][3][4]);
		bestiary[1][5][4][4].setEvolvesFrom2(bestiary[1][5][3][5]);
		bestiary[1][5][3][0].setEvolvesFrom(bestiary[1][5][2][0]);
		bestiary[1][5][3][1].setEvolvesFrom(bestiary[1][5][2][1]);
		bestiary[1][5][3][2].setEvolvesFrom(bestiary[1][5][2][1]);
		bestiary[1][5][3][3].setEvolvesFrom(bestiary[1][5][2][2]);
		bestiary[1][5][3][4].setEvolvesFrom(bestiary[1][5][2][2]);
		bestiary[1][5][3][5].setEvolvesFrom(bestiary[1][5][2][2]);
		bestiary[1][5][2][0].setEvolvesFrom(bestiary[1][5][1][0]);
		bestiary[1][5][2][1].setEvolvesFrom(bestiary[1][5][1][0]);
		bestiary[1][5][2][2].setEvolvesFrom(bestiary[1][5][1][0]);
		bestiary[1][5][1][0].setEvolvesFrom(bestiary[1][5][0][0]);
		bestiary[2][0]=new MonsterType[5][];
		bestiary[2][0][0]=new MonsterType[1];
		bestiary[2][0][1]=new MonsterType[1];
		bestiary[2][0][2]=new MonsterType[3];
		bestiary[2][0][3]=new MonsterType[3];
		bestiary[2][0][4]=new MonsterType[3];
		bestiary[2][0][4][0]=new MonsterType("Metafilthy Poshprechaun",2,0,4,0,"The Poshprechaun is metaphorically filthy because its stinking rich. Instead of the classic black suit and bow tie duds, they're solid gold thread");
		bestiary[2][0][4][1]=new MonsterType("Elder Elf",2,0,4,1,"The elder elf also has long facial hair and is bald");
		bestiary[2][0][4][2]=new MonsterType("Shamage",2,0,4,2,"The Shamage has mastered hermitic magic and has vast experience delievering babies, healing livesock and curing curses on the farmsfolk that it lives near. Or is very good at pretending to anyway, very convincing. At least enough to keep getting money from them. Bastard");
		bestiary[2][0][3][0]=new MonsterType("Poshprechaun",2,0,3,0,"The Poshprechaun has gotten some money, and now wears a blazer with tails, a monocole and a tophat with a sash. Its attacks damage is based on how  much money the owner has",bestiary[2][0][4][0]);
		bestiary[2][0][3][1]=new MonsterType("Tallf",2,0,3,1,"The is an elf that is tall",bestiary[2][0][4][1]);
		bestiary[2][0][3][2]=new MonsterType("Shaman",2,0,3,2,"The shaman has a necklace of bones and a hat because hes bald",bestiary[2][0][4][2]);
		bestiary[2][0][2][0]=new MonsterType("Poorprechaun",2,0,2,0,"The poorprechaun is a leprechaun who has lost its pot of gold. As the leprechauns are a people who base worth on how much gold one has, this little guy is a little down on his luck",bestiary[2][0][3][0]);
		bestiary[2][0][2][1]=new MonsterType("Aos si",2,0,2,1, "The Aos si is a lesser elf about 4 foot tall that wears sage and whose skin has a greenish hue",bestiary[2][0][3][1]);
		bestiary[2][0][2][2]=new MonsterType("Shaboy",2,0,2,2,"The shaboy is an inexperienced shaman, whose collar of bones is unfinished and has only peach fuzz where the requisite beard should be.",bestiary[2][0][3][2]);
		bestiary[2][0][1][0]=new MonsterType("Sprite",2,0,1,0,"The sprite is about nine inches tall, and three of those inches are a ridiculously large brown hat, wizard style with a black belt and a golden buckle. it has a mischeveous face with a big red ruddy nose and is always smiling. It is wearing a green frock and brown pointed boots with a black strap and gold buckle. The hem of the green frock is cut into right angles. It can fly, obviously, and enjoys casting mischevious magic. Its personality is similar to everyone's annoying little brother",bestiary[2][0][2][0],bestiary[2][0][2][1],bestiary[2][0][2][2]);
		bestiary[2][0][0][0]=new MonsterType("Fairy Egg",2,0,0,0,"The fairy egg has mystical fey energy surrounding it in whisps and sparkling. The top 1/4 is green, the bottom 1/4 is red and in the middle is a gradient between the two. in the center of the egg is the fairy crest",bestiary[2][0][1][0]);
		bestiary[2][0][4][0].setEvolvesFrom(bestiary[2][0][3][0]);
		bestiary[2][0][4][1].setEvolvesFrom(bestiary[2][0][3][1]);
		bestiary[2][0][4][2].setEvolvesFrom(bestiary[2][0][3][2]);
		bestiary[2][0][3][0].setEvolvesFrom(bestiary[2][0][2][0]);
		bestiary[2][0][3][1].setEvolvesFrom(bestiary[2][0][2][1]);
		bestiary[2][0][3][2].setEvolvesFrom(bestiary[2][0][2][2]);
		bestiary[2][0][2][0].setEvolvesFrom(bestiary[2][0][1][0]);
		bestiary[2][0][2][1].setEvolvesFrom(bestiary[2][0][1][0]);
		bestiary[2][0][2][2].setEvolvesFrom(bestiary[2][0][1][0]);
		bestiary[2][0][1][0].setEvolvesFrom(bestiary[2][0][0][0]);
		bestiary[2][1]=new MonsterType[5][];
		bestiary[2][1][0]=new MonsterType[1];
		bestiary[2][1][1]=new MonsterType[1];
		bestiary[2][1][2]=new MonsterType[2];
		bestiary[2][1][3]=new MonsterType[2];
		bestiary[2][1][4]=new MonsterType[2];
		bestiary[2][1][4][0]=new MonsterType("Slougtter",2,1,4,0,"The Sloughtter is a huge Slough in the shape of an otter. And it once killed a lot of people.");
		bestiary[2][1][4][1]=new MonsterType("Wills of the Wisps",2,1,4,1,"The Wills o' the Wisps are a collection of Wills o' the Wisp. As an original Wills o' the Wisp is kinda flaky, the collection of them is frankly insane. It can inflict this on its enemies as well, at least when its cohescient");
		bestiary[2][1][3][0]=new MonsterType("Slough",2,1,3,0,"The Slough is an ogre that haunts in the swamp. It can sink underwater and often grabs enemies and pulls them down. It is covered in twigs and muck",bestiary[2][1][4][0]);
		bestiary[2][1][3][1]=new MonsterType("Wills o' the Wisp",2,1,3,1,"The Wills o' the Wisp is a rather unfortunate sprite that has lots of wills set in a single body. Its confusing to talk to, to say the least",bestiary[2][1][4][1]);
		bestiary[2][1][2][0]=new MonsterType("Otter",2,1,2,0,"The Otter is an otter, who viciously defends its territory and snarles at passers by. How does it typically defend its territory, by harshly laughing and snickering its opponents into submission.",bestiary[2][1][3][1]);
		bestiary[2][1][2][1]=new MonsterType("Will o' the Wisp",2,1,2,1,"The Will o' the Wisp is a swamp sprite that floats around and guides the wayward home. If its in a good mood. Otherwise, it just confuses them.",bestiary[2][1][3][0]);
		bestiary[2][1][1][0]=new MonsterType("Boggart",2,1,1,0,"The Boggart lives cheifly in bogs and haunts them",bestiary[2][1][2][0],bestiary[2][1][2][1]);
		bestiary[2][1][0][0]=new MonsterType("Swamp Egg",2,1,0,0,"The swamp egg is best left in brackish water",bestiary[2][1][1][0]);
		bestiary[2][1][4][0].setEvolvesFrom(bestiary[2][1][3][0]);
		bestiary[2][1][4][1].setEvolvesFrom(bestiary[2][1][3][1]);
		bestiary[2][1][3][0].setEvolvesFrom(bestiary[2][1][2][0]);
		bestiary[2][1][3][1].setEvolvesFrom(bestiary[2][1][2][1]);
		bestiary[2][1][2][0].setEvolvesFrom(bestiary[2][1][1][0]);
		bestiary[2][1][2][1].setEvolvesFrom(bestiary[2][1][1][0]);
		bestiary[2][1][1][0].setEvolvesFrom(bestiary[2][1][0][0]);
		bestiary[2][2]=new MonsterType[5][];
		bestiary[2][2][0]=new MonsterType[1];
		bestiary[2][2][1]=new MonsterType[3];
		bestiary[2][2][2]=new MonsterType[5];
		bestiary[2][2][3]=new MonsterType[6];
		bestiary[2][2][4]=new MonsterType[7];
		bestiary[2][2][4][0]=new MonsterType("Honey BadgeBear",2,2,4,0,"The only thing scarier than a Honey Badger is one that mutated into a huge bear that still has its markings. It really loves honey. Like crazy");
		bestiary[2][2][4][1]=new MonsterType("Sief",2,2,4,1,"Sief is a giant wolf with a scar over its right eye weilding a giant broadsword, and bears no relation to sif from Darksouls.");
		bestiary[2][2][4][2]=new MonsterType("Awarewolf",2,2,4,1,"The Awarewolf is an elder greenwolf with an eyepatch that spends its days meditating, contemplaing the complexities of life.");
		bestiary[2][2][4][3]=new MonsterType("Flourisyana",2,2,4,2,"The Flourisyana is a large pale green wolf that has magic bladed flowers that it thows at enemies");
		bestiary[2][2][4][4]=new MonsterType("Tenured Professtrig",2,2,4,1,"The professtrid has tenure, thus doesn't actually have to work anymore and can do whatever it wants. It also has a stare that can put someone in their place");
		bestiary[2][2][4][5]=new MonsterType("Tree Hugger Hugger Tree",2,2,4,4,"The Tree Hugger Hugger Tree is a tree that loves hugging, especially tree huggers, which is fortunate, because only tree huggers hug trees.");//TODO change to ygrdassil
		bestiary[2][2][4][6]=new MonsterType("Tera Atronach",2,2,4,5,"A large tera elemental surrounded by the elementals representing all other primary elements");
		bestiary[2][2][3][0]=new MonsterType("Honey Badger",2,2,3,0,"My only advice to you is not to mess with the honey badger. He was once locked up in vietcong prison for being a badass, and all they wanted him to do is poop. BUT HONEY BADGER DON'T CARE! HONEY BADGER DON'T GIVE A SHIT. credit for the idea belongs to: https://www.youtube.com/watch?v=4r7wHMg5Yjg",bestiary[2][2][4][0]);
		bestiary[2][2][3][1]=new MonsterType("Greenwolf",2,2,3,1,"The GreenWolf has hardened the ends of its vines into bark. Its fur has begun turning green",bestiary[2][2][4][1],bestiary[2][2][4][2]);
		bestiary[2][2][3][2]=new MonsterType("Flowering Aiyana",2,2,3,2,"The Aiyana now has flowers growing over its body. It attacks with fragrant fumes from its flowers. Its fur is all white",bestiary[2][2][4][3]);
		bestiary[2][2][3][3]=new MonsterType("Professtrig",2,2,3,1,"The trig went to college and became a professor which is why he has big white bushy eyebrows and moustache. His most damaging attack is assigning math homework which deals more damage the closer the intelligence is to 5 because if its much lower than that it doesn't care and much higher and its easy",bestiary[2][2][4][4]);
		bestiary[2][2][3][4]=new MonsterType("Hugger Tree",2,2,3,2,"The hugger tree is a tree with two dedicated branches toward hugging and protecting people. It looks like it has a smile carved in its bark, but it actually just grew that way",bestiary[2][2][4][5]);
		bestiary[2][2][3][5]=new MonsterType("Tera Elemental",2,2,3,2,"A large tera symbol surrounded by a dark symbol, a fire symbol and a water symbol",bestiary[2][2][4][6]);
		bestiary[2][2][2][0]=new MonsterType("BadgeBadger",2,2,2,0,"The BadgeBadger is really pround of it badge. It shines it every day until it almost sparkles. How did it get the badge? Dont ask questions, this is a fantasy. Maybe it found it. Or less likely beat up a cop and stole it. And that's unlikely because there are no cops in this universe",bestiary[2][2][3][0]);
		bestiary[2][2][2][1]=new MonsterType("VineWolf",2,2,2,1,"The vinewolf's bulb sprounted into vines that encircle it. Often while hunting it will use  the vines to hold down its prey while it goes in for the kill. It can also wrap its vines around an unsuspecting opponent, at a great cost to the agility of both creatures",bestiary[2][2][3][1]);
		bestiary[2][2][2][2]=new MonsterType("Aiyana",2,2,2,2,"The aiyana is a calm relaxed wolf with a flower on its back. In the center of the flower is the yin yang, a symbol for balance. It often lays in the grass, and enjoys watching the plants grow and flower around it. It has a passive ability that strengthens all moves by plant types by 10%",bestiary[2][2][3][2]);
		bestiary[2][2][2][3]=new MonsterType("Trig",2,2,2,3,"A small nerdy twig that just loves math. It can recite all of the mathematical properties up to vector calclus off of the top of its head, it especially loves sine, cosine and tangent. It always remembers to bring an apple for the teacher. It cant see very well (as it lacks eyes) and thus keeps its bifocals on at all times",bestiary[2][2][3][3],bestiary[2][2][3][4]);
		bestiary[2][2][2][4]=new MonsterType("Tera Symbol",2,2,2,5,"The Tera Symbol is a green taurus with the earth symbol it its center",bestiary[2][2][3][5]);
		bestiary[2][2][1][0]=new MonsterType("Babadger",2,2,1,0,"The Babadger lures its enemies close with its cuteness, and then slashes them viciously when they're exposed. But its only enemies are its fellow babadger pups, which is why its parents seperate them at birth",bestiary[2][2][2][0]);
		bestiary[2][2][1][1]=new MonsterType("Bulbapup",2,2,1,1,"A small, energetic puppy with a large bulb on its back, resembling an onion. It loves to jump around, but when it does so it is rather comical, as the weight of the bulb often makes it fall over. Its bark is adoable. And its not a refrence to Bulbasaur from Pokemon. At all.",bestiary[2][2][2][1],bestiary[2][2][2][2],bestiary[2][2][2][4]);
		bestiary[2][2][1][2]=new MonsterType("Stiket",2,2,1,2,"The sticket pretends to be magical but isn't. Its very depressing huh? Its basically just a small stick that can move on its own. But its very good at listening, probably because it cant talk. If it could though it would always advise revenge by saying 'Sticket to em!'",bestiary[2][2][2][3],bestiary[2][2][2][4]);		
		bestiary[2][2][0][0]=new MonsterType("Tera Egg",2,2,0,0,"A brown Egg that looks a lot like a clod of dirt except for the glowing green earth crest etched onto its surface. It is heavy and when placed in the grass, the grass grows and circles around it, as if coushining it. It is magical and can evolve into a baby badger, a puppy or a stick. 'But Puppies dont come from eggs!' you may think! Banish your logic, this is a video game, there is no place for it here!",bestiary[2][2][1][0],bestiary[2][2][1][1],bestiary[2][2][1][2],skillSet[2]);
		bestiary[2][2][4][0].setEvolvesFrom(bestiary[2][2][3][0]);
		bestiary[2][2][4][1].setEvolvesFrom(bestiary[2][2][3][1]);
		bestiary[2][2][4][2].setEvolvesFrom(bestiary[2][2][3][1]);
		bestiary[2][2][4][3].setEvolvesFrom(bestiary[2][2][3][2]);
		bestiary[2][2][4][4].setEvolvesFrom(bestiary[2][2][3][3]);
		bestiary[2][2][4][5].setEvolvesFrom(bestiary[2][2][3][4]);
		bestiary[2][2][4][6].setEvolvesFrom(bestiary[2][2][3][5]);
		bestiary[2][2][3][0].setEvolvesFrom(bestiary[2][2][2][0]);
		bestiary[2][2][3][1].setEvolvesFrom(bestiary[2][2][2][1]);
		bestiary[2][2][3][2].setEvolvesFrom(bestiary[2][2][2][2]);
		bestiary[2][2][3][3].setEvolvesFrom(bestiary[2][2][2][3]);
		bestiary[2][2][3][4].setEvolvesFrom(bestiary[2][2][2][3]);
		bestiary[2][2][2][0].setEvolvesFrom(bestiary[2][2][1][0]);
		bestiary[2][2][2][1].setEvolvesFrom(bestiary[2][2][1][1]);
		bestiary[2][2][2][2].setEvolvesFrom(bestiary[2][2][1][1]);
		bestiary[2][2][2][3].setEvolvesFrom(bestiary[2][2][1][2]);
		bestiary[2][2][2][4].setEvolvesFrom(bestiary[2][2][1][1]);
		bestiary[2][2][2][4].setEvolvesFrom(bestiary[2][2][1][2]);
		bestiary[2][2][1][0].setEvolvesFrom(bestiary[2][2][0][0]);
		bestiary[2][2][1][1].setEvolvesFrom(bestiary[2][2][0][0]);
		bestiary[2][2][1][2].setEvolvesFrom(bestiary[2][2][0][0]);
		bestiary[2][3]=new MonsterType[5][];
		bestiary[2][3][0]=new MonsterType[1];
		bestiary[2][3][1]=new MonsterType[1];
		bestiary[2][3][2]=new MonsterType[2];
		bestiary[2][3][3]=new MonsterType[2];
		bestiary[2][3][4]=new MonsterType[2];
		bestiary[2][3][4][0]=new MonsterType("Greater Pegasus",2,3,4,0,"This pegasus is fully awesome. If an ancient greek hero needs a flying steed, this guy shows up. But only if the hero is Bellerophon. BECAUSE HERCULES NEVER RODE PEGASUS DISNEY!!!");
		bestiary[2][3][4][1]=new MonsterType("Flying Forest",2,3,4,1,"The flying forest is a group of wingtrees. It doesnt' have enough lift from its levitation though, so it has birds hang on and flap as hard as they can");
		bestiary[2][3][3][0]=new MonsterType("Pegasus",2,3,3,0,"Pegasus is glad that its no longer a lesser pegasus, because lets face it, those teenage years sucked. Now he can fly but he cant carry anyone. Especially heores in armor. Are you kidding me? Its already areodynamically impossible for a horse to fly and now you want to add a two hundred pound hero with 300 pounds of armor? not to mention loot? Not on my back",bestiary[2][3][4][0]);
		bestiary[2][3][3][1]=new MonsterType("Wing Tree",2,3,3,1,"The wingTree loved watching WW1 films and always wanted to be a wingman. However, its not a man, its a tree. So it settled for the next best thing. Somehow he got ahold of some avatior goggles, and put them on his trunk because he doesnt have eyes. But it makes him look cool, so no one calls him on it. Also it bears saying that this is the guy you want to bring with you to tree parties, he can make you look SOOO good in front of the female trees.",bestiary[2][3][4][1]);
		bestiary[2][3][2][0]=new MonsterType("Lesser Pegasus",2,3,2,0,"Lesser Pegasus is a little depressed. I mean the baby pegases didn't mind that it was called minor becasuse its a baby. But Lesser pegasus knows what theyre saying, and its really akward and its just sad... But atleast its front hooves dont look like trees anymore! It also cant fly to its undending shame, all the other pegasus laugh at it... Its a hard life",bestiary[2][3][3][0]);
		bestiary[2][3][2][1]=new MonsterType("Sapwing",2,3,2,1,"The sapwing is a tree that wanted to be a bird. Now its converted its leaves into semi feathers and can hop along the ground some if it tries real hard.",bestiary[2][3][3][1]);
		bestiary[2][3][1][0]=new MonsterType("Minor Pegasus",2,3,1,0,"Half horse, half plant half bird... Or wait, is that too many halves? Its front two legs are treeish, while the torso, head and back legs are a horse and it has wings. Dont look at me, you've all seen Hercules! Its like that except the two front legs are treeish. And its the reaally cute baby form, obviously",bestiary[2][3][2][0],bestiary[2][3][2][1]);
		bestiary[2][3][0][0]=new MonsterType("Pegasus Egg",2,3,0,0,"The Pegasus egg shows a natural affinity for both the air and the earth. However, the part of it that is psyched about flying is on the bottom half, and the part that enjoys the ground is on the top half. So it balances upside down. People say it looks ridiculous, but eggs cant hear sooo...",bestiary[2][3][1][0]);
		bestiary[2][3][4][0].setEvolvesFrom(bestiary[2][3][3][0]);
		bestiary[2][3][4][1].setEvolvesFrom(bestiary[2][3][3][1]);
		bestiary[2][3][3][0].setEvolvesFrom(bestiary[2][3][2][0]);
		bestiary[2][3][3][1].setEvolvesFrom(bestiary[2][3][2][1]);
		bestiary[2][3][2][0].setEvolvesFrom(bestiary[2][3][1][0]);
		bestiary[2][3][2][1].setEvolvesFrom(bestiary[2][3][1][0]);
		bestiary[2][3][1][0].setEvolvesFrom(bestiary[2][3][0][0]);
		bestiary[2][4]=new MonsterType[5][];
		bestiary[2][4][0]=new MonsterType[1];
		bestiary[2][4][1]=new MonsterType[1];
		bestiary[2][4][2]=new MonsterType[2];
		bestiary[2][4][3]=new MonsterType[2];
		bestiary[2][4][4]=new MonsterType[2];
		bestiary[2][4][4][0]=new MonsterType("Shaolin",2,4,4,0,"The Sholin is an elder monk that can despense wisdom to buff allies");
		bestiary[2][4][4][1]=new MonsterType("Mother Theres",2,4,4,1,"A female elder monk that can sacrifice herself to heal all alies to full health, even if they are fallen");
		bestiary[2][4][3][0]=new MonsterType("Bodisatva",2,4,3,0,"The Bodisatva is now an experienced mond, that has a healing palm that deals damage to enemies and heals allies",bestiary[2][4][3][0]);
		bestiary[2][4][3][1]=new MonsterType("Theresatva",2,4,3,1,"The Theresatva is self sacrificing, and can give half of her own vital energy to ressurect the fallen to half health",bestiary[2][4][3][1]);
		bestiary[2][4][2][0]=new MonsterType("Bodisat",2,4,2,0,"The Bodisat is a young monk that was trained by the shaolin, and can strike with a sacred palm",bestiary[2][4][3][0]);
		bestiary[2][4][2][1]=new MonsterType("Theresat",2,4,2,1,"The Theresat is a bald young female healer that heals through forgiveness. She heals quite a bit, but a third is applied to the opposing team",bestiary[2][4][3][1]);
		bestiary[2][4][1][0]=new MonsterType("Buddi",2,4,1,0,"A Buddi is a young enlighted being who can heal through compassion, and will heal both the virtuous and the vengeful, it looks like a buddhist mask",bestiary[2][4][2][0],bestiary[2][4][2][1]);
		bestiary[2][4][0][0]=new MonsterType("Compassion Egg",2,4,0,0,"The Compassion Egg has a bright green cross on its shell to show that is will grow into a healer",bestiary[2][4][1][0]);
		bestiary[2][4][4][0].setEvolvesFrom(bestiary[2][4][3][0]);
		bestiary[2][4][4][1].setEvolvesFrom(bestiary[2][4][3][1]);
		bestiary[2][4][3][0].setEvolvesFrom(bestiary[2][4][2][0]);
		bestiary[2][4][3][1].setEvolvesFrom(bestiary[2][4][2][1]);
		bestiary[2][4][2][0].setEvolvesFrom(bestiary[2][4][1][0]);
		bestiary[2][4][2][1].setEvolvesFrom(bestiary[2][4][1][0]);
		bestiary[2][4][1][0].setEvolvesFrom(bestiary[2][4][0][0]);
		bestiary[2][5]=new MonsterType[5][];//TODO think about redoing this one
		bestiary[2][5][0]=new MonsterType[1];
		bestiary[2][5][1]=new MonsterType[1];
		bestiary[2][5][2]=new MonsterType[1];
		bestiary[2][5][3]=new MonsterType[1];
		bestiary[2][5][4]=new MonsterType[1];
		bestiary[2][5][4][0]=new MonsterType("BeePee",2,5,4,0,"The BeePee floods toxic sludge all over the opponents battlefield which ignites when hit with fire, dealing massive damage");
		bestiary[2][5][3][0]=new MonsterType("Flint",2,5,3,0,"The Flint coughs on its enemies and continually releases methane, it explodes when attacked by fire dealing a large amount of damage to all sides",bestiary[2][5][4][0]);
		bestiary[2][5][2][0]=new MonsterType("Smaugh",2,5,2,0,"The Smaugh is a Sewer demon covered in refuse",bestiary[2][5][3][0]);
		bestiary[2][5][1][0]=new MonsterType("Sewerat",2,5,1,0,"The Sewerat is a rather large rat that smells terrible.",bestiary[2][5][2][0]);
		bestiary[2][5][0][0]=new MonsterType("Rotten Egg",2,5,0,0,"The Rotten egg infects those around it with disease",bestiary[2][5][1][0]);
		bestiary[2][5][4][0].setEvolvesFrom(bestiary[2][5][3][0]);
		bestiary[2][5][3][0].setEvolvesFrom(bestiary[2][5][2][0]);
		bestiary[2][5][2][0].setEvolvesFrom(bestiary[2][5][1][0]);
		bestiary[2][5][1][0].setEvolvesFrom(bestiary[2][5][0][0]);
		bestiary[3][0]=new MonsterType[5][];
		bestiary[3][0][0]=new MonsterType[1];
		bestiary[3][0][1]=new MonsterType[1];
		bestiary[3][0][2]=new MonsterType[3];
		bestiary[3][0][3]=new MonsterType[3];
		bestiary[3][0][4]=new MonsterType[3];
		bestiary[3][0][4][0]=new MonsterType("Greater Sphynx",3,0,4,0,"The greater Sphynx is a very large sphyix with haunting eyes that also speaks in riddles and analogies but has large folded wings along its back. It cant fly with them, but when it spreads them out, it looks very intimidaing. The feathers also alternate between jade and torquoise, so the Greater Sphynx was once hunted for its wings. But then it killed and ate all the hunters, so that was over pretty quickly");
		bestiary[3][0][4][1]=new MonsterType("Scorpious",3,0,4,1,"The Scorpious is a descendant of the giant Scorpion that killed Orion.");
		bestiary[3][0][4][2]=new MonsterType("Bihump",3,0,4,2,"The Bihump has mystical powers and can cast greater sandstorm that does no damage to sand creatrues, small damage to fire and air primary creatures and more damage to all other creatures each turn");
		bestiary[3][0][3][0]=new MonsterType("Sphynx",3,0,3,0,"The Sphynx has the head of a man and the body of a lion, like the Slynx it evolved from, it speaks only in riddles, however these riddles are more difficult",bestiary[3][0][4][0]);
		bestiary[3][0][3][1]=new MonsterType("Scarpi",3,0,3,1,"A Scarpi is a large scorpion whose plates have turned into armor, although they do bear scars from its earlier encounters. It is named after the fabled storyteller who is credited for the creation of its myth. Obviously it wasn't a myth",bestiary[3][0][4][1]);
		bestiary[3][0][3][2]=new MonsterType("Unihump",3,0,3,2,"A unihump is a camel with a single hump. It stores water in this hump obviously and can cast sandstorm with its mind",bestiary[3][0][4][2]);
		bestiary[3][0][2][0]=new MonsterType("Slynx",3,0,2,0,"A Slynx is a mythical sand cat that has haunting eyes and can speak, but only speaks in riddles. Whenever asked a question, it anwsers with another question, usually pointing at the right answer. If the Slynx has no clue though, it will just repeat the question asked of it, it is about the size of a mountain lion",bestiary[3][0][3][0]);
		bestiary[3][0][2][1]=new MonsterType("Skorpi",3,0,2,1,"A Scorpi is a small scorpion that is red and very poisonous",bestiary[3][0][3][1]);
		bestiary[3][0][2][2]=new MonsterType("Humpless",3,0,2,2,"A humpless is a sad camel without a hump. It can magically control the sand with its mind, and keeps some in the gourd across its back",bestiary[3][0][3][2]);
		bestiary[3][0][1][0]=new MonsterType("Kangarat",3,0,1,0,"The Kangarat is a small rodent that can spend its whole life without having to drink any water. It takes no damage from sandstorm",bestiary[3][0][2][0],bestiary[3][0][2][1],bestiary[3][0][2][2]);
		bestiary[3][0][0][0]=new MonsterType("Sands Egg",3,0,0,0,"The Sands Egg has a sandy shell with the sand logo printed on it",bestiary[3][0][1][0]);
		bestiary[3][0][4][0].setEvolvesFrom(bestiary[3][0][3][0]);
		bestiary[3][0][4][1].setEvolvesFrom(bestiary[3][0][3][1]);
		bestiary[3][0][4][2].setEvolvesFrom(bestiary[3][0][3][2]);
		bestiary[3][0][3][0].setEvolvesFrom(bestiary[3][0][2][0]);
		bestiary[3][0][3][1].setEvolvesFrom(bestiary[3][0][2][1]);
		bestiary[3][0][3][2].setEvolvesFrom(bestiary[3][0][2][2]);
		bestiary[3][0][2][0].setEvolvesFrom(bestiary[3][0][1][0]);
		bestiary[3][0][2][1].setEvolvesFrom(bestiary[3][0][1][0]);
		bestiary[3][0][2][2].setEvolvesFrom(bestiary[3][0][1][0]);
		bestiary[3][0][1][0].setEvolvesFrom(bestiary[3][0][0][0]);
		bestiary[3][1]=new MonsterType[5][];
		bestiary[3][1][0]=new MonsterType[1];
		bestiary[3][1][1]=new MonsterType[1];
		bestiary[3][1][2]=new MonsterType[2];
		bestiary[3][1][3]=new MonsterType[2];
		bestiary[3][1][4]=new MonsterType[2];
		bestiary[3][1][4][0]=new MonsterType("Heligull",3,1,4,0,"The Heligull's wings rotate above it like a helicopter. It dives deep into the water to find prey. It can hold its breath for up to 4 hours, and spends almost as much time above water as within");
		bestiary[3][1][4][1]=new MonsterType("Soarfish",3,1,4,1,"The Soarfish has adapted gulls that allow it to breath both water and air. It has no need to go under water and preys on small birds. However it usually stays near the water to feed its children who cannot fly as well");
		bestiary[3][1][3][0]=new MonsterType("Peligull",3,1,3,0,"The pelligull is a large gull with  a great gullet. When there are fish near the surface of the water, it will dive in and open its large mouth. When it surfaces again it spits out the water but retains the fish in its mouth",bestiary[3][1][4][0]);
		bestiary[3][1][3][1]=new MonsterType("Flyfish",3,1,3,1,"The Flyfish can fly at low altitudes out of water and feasts on the small insects just above the waters surface.",bestiary[3][1][4][1]);
		bestiary[3][1][2][0]=new MonsterType("Guller",3,1,2,0,"The guller is a small gull with wide wings",bestiary[3][1][3][0]);
		bestiary[3][1][2][1]=new MonsterType("Skipfish",3,1,2,1,"The skipfish can't quite fly yet, but it loved the feeling when it was younger in the baby gulls claws. It can skip out of the water on its fins that are becoming like wings",bestiary[3][1][3][1]);
		bestiary[3][1][1][0]=new MonsterType("Gullfish",3,1,1,0,"The first fish a baby gull ever caught is still in its claws. Initially there was some fear between the baby gull and the fish, but they became fast friends when the fish found out how cool it is to fly",bestiary[3][1][2][0],bestiary[3][1][2][1]);
		bestiary[3][1][0][0]=new MonsterType("SeaBreeze Egg",3,1,0,0,"The SeaBreeze egg's parents often hold onto it for months at a time before they see dry land. SeaBreeze Monsters love flying above the ocean, so when a SeaBreeze egg is laid, it is caught by the father who holds it while they are flying, even when sleeping.",bestiary[3][1][1][0]);
		bestiary[3][1][4][0].setEvolvesFrom(bestiary[3][1][3][0]);
		bestiary[3][1][4][1].setEvolvesFrom(bestiary[3][1][3][1]);
		bestiary[3][1][3][0].setEvolvesFrom(bestiary[3][1][2][0]);
		bestiary[3][1][3][1].setEvolvesFrom(bestiary[3][1][2][1]);
		bestiary[3][1][2][0].setEvolvesFrom(bestiary[3][1][1][0]);
		bestiary[3][1][2][0].setEvolvesFrom(bestiary[3][1][1][0]);
		bestiary[3][1][1][0].setEvolvesFrom(bestiary[3][1][0][0]);
		bestiary[3][2]=new MonsterType[5][];
		bestiary[3][2][0]=new MonsterType[1];
		bestiary[3][2][1]=new MonsterType[1];
		bestiary[3][2][2]=new MonsterType[2];
		bestiary[3][2][3]=new MonsterType[2];
		bestiary[3][2][4]=new MonsterType[2];
		bestiary[3][2][4][0]=new MonsterType("Foursamcan",3,2,4,0,"The Foursamcan channels light from the sun that shines through its multicolored feathers to confuse its enemies");
		bestiary[3][2][4][1]=new MonsterType("Seusstruse",3,2,4,1,"When a Fabstruse comes to the realization that leather never goes out of style, it becomes a Seusstruse. When the Seusstruse lays eggs, they are green, and when it has access to ham, it places the ham near the eggs because it loves green eggs and ham.");
		bestiary[3][2][3][0]=new MonsterType("Threesamcan",3,2,3,0,"The Threesamcan is a much larger version of the Tusamcan, and is even more colorful",bestiary[3][2][4][0]);
		bestiary[3][2][3][1]=new MonsterType("Fabstruse",3,2,3,1,"The Fabstruse is a very strange black and purple bird that loves fashion, but always seems to be behind on the trends. I mean leather Jacket? Sooo Eighties",bestiary[3][2][4][1]);
		bestiary[3][2][2][0]=new MonsterType("Tusamcan",3,2,2,0,"The TuscamCan is a colorful blue bird with a rainbow beak that tells little children to eat healthy while giving them pure sugar for breakfast",bestiary[3][2][3][0]);
		bestiary[3][2][2][1]=new MonsterType("Abstruse",3,2,2,1,"The Abstruse is a brightly colorful bird that complicated and interesting... Or completely ridculous depending on how you look at it. It looks like a peacock, except every single feather is a different color, and they're not organized in any particular manner. When it walks, it takes its long storklike legs and pulls them up way higher than they need to go, giving it a ridiculous looking gait. Its long neck is a gradient from green to blue, and it has a yellow feather crown on the crest of its head",bestiary[3][2][3][1]);
		bestiary[3][2][1][0]=new MonsterType("Colour",3,2,1,0,"The Colour is a colorful hatchling.",bestiary[3][2][2][0],bestiary[3][2][2][1]);
		bestiary[3][2][0][0]=new MonsterType("Bird Egg",3,2,0,0,"The BirdEgg is a rainbow colored egg with the bird crest at its center",bestiary[3][2][1][0]);
		bestiary[3][2][4][0].setEvolvesFrom(bestiary[3][2][3][0]);
		bestiary[3][2][4][1].setEvolvesFrom(bestiary[3][2][3][1]);
		bestiary[3][2][3][0].setEvolvesFrom(bestiary[3][2][2][0]);
		bestiary[3][2][3][1].setEvolvesFrom(bestiary[3][2][2][1]);
		bestiary[3][2][2][0].setEvolvesFrom(bestiary[3][2][1][0]);
		bestiary[3][2][2][1].setEvolvesFrom(bestiary[3][2][1][0]);
		bestiary[3][2][1][0].setEvolvesFrom(bestiary[3][2][0][0]);
		bestiary[3][3]=new MonsterType[5][];
		bestiary[3][3][0]=new MonsterType[1];
		bestiary[3][3][1]=new MonsterType[1];
		bestiary[3][3][2]=new MonsterType[3];
		bestiary[3][3][3]=new MonsterType[3];
		bestiary[3][3][4]=new MonsterType[2];
		bestiary[3][3][4][0]=new MonsterType("Roc",3,3,4,0,"The Roc is a giant bald eagle with a thirty foot wingspan, it often sits on a golden dome");
		bestiary[3][3][4][1]=new MonsterType("Air Atronach",3,3,4,1,"Lightening often surrounds the Air Atronach whenever it is angry. It is surrounded by six elementals, three of which are aero, three of which determine the other types of spells it can cast");
		bestiary[3][3][3][0]=new MonsterType("Baldgul",3,3,3,0,"The Baldgul is a bald eagle that is actually bald. Not white feathers, no feathers",bestiary[3][3][4][0]);
		bestiary[3][3][3][1]=new MonsterType("Wings",3,3,3,1,"Byrdi hated the beatles, because the name made it hungry. And the problem with the rolling stones was, well, people would often try to kill it and another bird with a single one. But Once the beatles split up, it became Wings",bestiary[3][3][4][0]);
		bestiary[3][3][3][2]=new MonsterType("Aero Elemental",3,3,3,2,"The Aero Elemental is a suped up version of the AeroSymbol with more wings etc.",bestiary[3][3][4][1]);
		bestiary[3][3][2][0]=new MonsterType("toupeagle",3,3,2,0,"The toupeagle is a young eagle that went prematurely bald. Its very sensitive about its baldness and thus wears a toupee. Its a good toupee too, but it looks ridiculous because its not really on right because, well it has only wings and claws to work with",bestiary[3][3][3][0]);
		bestiary[3][3][2][1]=new MonsterType("Byrdi",3,3,2,1,"The Byrdi grew up in the seventies and fell in love with rock and roll. It gets dizzy when it acts out its favorite song",bestiary[3][3][3][1]);
		bestiary[3][3][2][2]=new MonsterType("AeroSymbol",3,3,2,3,"The AeroSymbol is a circle with six points that looks like the aero glyph. The six points are feathers",bestiary[3][3][3][2]);
		bestiary[3][3][1][0]=new MonsterType("Flapper",3,3,1,0,"The Flapper shows a ridiculous amount of leg, esspecially for this time period. It is very stylish, and wears a headband with a feather on it, even though its already a bird",bestiary[3][3][2][0],bestiary[3][3][2][1],bestiary[3][3][2][2]);
		bestiary[3][3][0][0]=new MonsterType("AeroEgg",3,3,0,0,"The aeroEgg hovers in the air, and is yellow with the bird crest on it. It was designed to hover just in case one of its parents accidentally knocks it out of the tree, so it can be rescued before it hits the ground",bestiary[3][3][1][0],skillSet[3]);
		bestiary[3][3][4][0].setEvolvesFrom(bestiary[3][3][3][0]);
		bestiary[3][3][4][0].setEvolvesFrom(bestiary[3][3][3][1]);
		bestiary[3][3][4][1].setEvolvesFrom(bestiary[3][3][3][2]);
		bestiary[3][3][3][0].setEvolvesFrom(bestiary[3][3][2][0]);
		bestiary[3][3][3][1].setEvolvesFrom(bestiary[3][3][2][1]);
		bestiary[3][3][3][2].setEvolvesFrom(bestiary[3][3][2][2]);
		bestiary[3][3][2][0].setEvolvesFrom(bestiary[3][3][1][0]);
		bestiary[3][3][2][1].setEvolvesFrom(bestiary[3][3][1][0]);
		bestiary[3][3][2][2].setEvolvesFrom(bestiary[3][3][1][0]);
		bestiary[3][3][1][0].setEvolvesFrom(bestiary[3][3][0][0]);
		bestiary[3][4]=new MonsterType[5][];
		bestiary[3][4][0]=new MonsterType[1];
		bestiary[3][4][1]=new MonsterType[1];
		bestiary[3][4][2]=new MonsterType[3];
		bestiary[3][4][3]=new MonsterType[3];
		bestiary[3][4][4]=new MonsterType[1];
		bestiary[3][4][4][0]=new MonsterType("CockaFour",3,4,4,0,"The Cockafour is the undisputed leader of the cockas. Its beak is lined with razors, and its dance can drive all birds crazy, and berserks all air primaries");
		bestiary[3][4][3][0]=new MonsterType("Cockadude",3,4,3,0,"The Cockadude is a super cool cocka who wears 8 bit glasses and raps. He is frequentle]y found on the street corner with a lit cigarette hanging out his mouth, whistling at passing women",bestiary[3][4][4][0]);
		bestiary[3][4][3][1]=new MonsterType("Cockathree",3,4,3,1,"The Cockathree is a pretty awesome cocka that often dances with its feathers and raises its crest",bestiary[3][4][4][0]);
		bestiary[3][4][3][2]=new MonsterType("Lovebird",3,4,3,2,"The Lovebird is a totally pink cocka that is eternally smiling. It can flirt with an air primary monster to occupy it for one turn",bestiary[3][4][4][0]);
		bestiary[3][4][2][0]=new MonsterType("Cockarude",3,4,2,0,"The Cockarude is a cocka that his very rude and often signals with its middle feather. It wears a backwards baseball cap, how it got one I dont know",bestiary[3][4][3][0]);
		bestiary[3][4][2][1]=new MonsterType("Cockatwo",3,4,2,1,"The Cockatwo is a regular cocka. And by regular I mean very strange",bestiary[3][4][3][1]);
		bestiary[3][4][2][2]=new MonsterType("Smilebird",3,4,2,2,"The Smilebird is a cocka who is using its smile feathers to smile. It is also blushing a vey delicate shade of pink.",bestiary[3][4][3][2]);
		bestiary[3][4][1][0]=new MonsterType("Cockaone",3,4,1,0,"A baby cockatoo that has yet to leave its shell. Its cracked and eveything, but it hasn't left. It wears the top of the shell like a helmet",bestiary[3][4][2][0],bestiary[3][4][2][1],bestiary[3][4][2][2]);
		bestiary[3][4][0][0]=new MonsterType("CockaEgg",3,4,0,0,"The CockaEgg is a pure white egg with the cocka crest on it",bestiary[3][4][1][0]);
		bestiary[3][4][4][0].setEvolvesFrom1(bestiary[3][4][3][0]);
		bestiary[3][4][4][0].setEvolvesFrom2(bestiary[3][4][3][1]);
		bestiary[3][4][4][0].setEvolvesFrom3(bestiary[3][4][3][2]);
		bestiary[3][4][3][0].setEvolvesFrom(bestiary[3][4][2][0]);
		bestiary[3][4][3][1].setEvolvesFrom(bestiary[3][4][2][1]);
		bestiary[3][4][3][2].setEvolvesFrom(bestiary[3][4][2][2]);
		bestiary[3][4][2][0].setEvolvesFrom(bestiary[3][4][1][0]);
		bestiary[3][4][2][1].setEvolvesFrom(bestiary[3][4][1][0]);
		bestiary[3][4][2][2].setEvolvesFrom(bestiary[3][4][1][0]);
		bestiary[3][4][1][0].setEvolvesFrom(bestiary[3][4][0][0]);
		bestiary[3][5]=new MonsterType[5][];
		bestiary[3][5][0]=new MonsterType[1];
		bestiary[3][5][1]=new MonsterType[1];
		bestiary[3][5][2]=new MonsterType[3];
		bestiary[3][5][3]=new MonsterType[3];
		bestiary[3][5][4]=new MonsterType[3];
		bestiary[3][5][4][0]=new MonsterType("Vampelder",3,5,4,0,"The Vampelder is an older vampire that can assume human form. It can dissipate into a crowd of bats to attack its enemies");
		bestiary[3][5][4][1]=new MonsterType("Lenoraven",3,5,4,1,"Because of the Lenoraven's intimite relationship with death, it can instantly kill a monster with less than 20% health");
		bestiary[3][5][4][2]=new MonsterType("Knowlowlegabel",3,5,4,1,"The Knowlowlegabel knows only that it does not know. It can cast logical contradiction that injures monsters scaling with their intellect");
		bestiary[3][5][3][0]=new MonsterType("Vampire",3,5,3,0,"The vampire can float around like a shadow in the night. It can vampire bite that heals 1/2 of the damage inflicted. It takes extra damage from fire and light.",bestiary[3][5][4][0]);
		bestiary[3][5][3][1]=new MonsterType("Skulltrure",3,5,3,1,"The Skullture is a vulture with the head of a skull, like its younger cousin, the Scanvegiar, it feeds on death, and has an ability to deal double damage the turn after a monster dies",bestiary[3][5][4][1]);
		bestiary[3][5][3][2]=new MonsterType("Wisowl",3,5,3,1,"The wiseowl is an older version of the rationowl that can expose the weaknesses of its enemies so that they take 25% extra damage for the rest of the battle. This effect does not stack with identify weakness",bestiary[3][5][4][2]);
		bestiary[3][5][2][0]=new MonsterType("ShadowWing",3,5,2,0,"The shadowing is a bat that has a vampire attack that heals for 1/4th of the attacks damage",bestiary[3][5][3][0]);
		bestiary[3][5][2][1]=new MonsterType("Scavengair",3,5,2,1,"The scavenger is a young vulture that feeds on death. For each creature that dies, it deals an additional 5% damage",bestiary[3][5][3][1]);
		bestiary[3][5][2][2]=new MonsterType("Rationowl",3,5,2,1,"The Rationowl is a thinker and percieves its enemies weaknesses before it strikes. It can cast identify which increases damage to an enemy by 15% for the rest of the battle",bestiary[3][5][3][2]);
		bestiary[3][5][1][0]=new MonsterType("Foreshadowwing",3,5,1,0,"Its very hard to tell what manner of winged beast this is, as it is covered by shadows and appears to have four wings",bestiary[3][5][2][0],bestiary[3][5][2][1],bestiary[3][5][2][2]);
		bestiary[3][5][0][0]=new MonsterType("NightWing Egg",3,5,0,0,"The NightWing egg is black and nearly hidden in the shadows of the cave where it is laid",bestiary[3][5][1][0]);
		bestiary[3][5][4][0].setEvolvesFrom(bestiary[3][5][3][0]);
		bestiary[3][5][4][1].setEvolvesFrom(bestiary[3][5][3][1]);
		bestiary[3][5][4][2].setEvolvesFrom(bestiary[3][5][3][2]);
		bestiary[3][5][3][0].setEvolvesFrom(bestiary[3][5][2][0]);
		bestiary[3][5][3][1].setEvolvesFrom(bestiary[3][5][2][1]);
		bestiary[3][5][3][2].setEvolvesFrom(bestiary[3][5][2][2]);
		bestiary[3][5][2][0].setEvolvesFrom(bestiary[3][5][1][0]);
		bestiary[3][5][2][1].setEvolvesFrom(bestiary[3][5][1][0]);
		bestiary[3][5][2][2].setEvolvesFrom(bestiary[3][5][1][0]);
		bestiary[3][5][1][0].setEvolvesFrom(bestiary[3][5][0][0]);
		bestiary[4][0]=new MonsterType[5][];
		bestiary[4][0][0]=new MonsterType[1];
		bestiary[4][0][1]=new MonsterType[1];
		bestiary[4][0][2]=new MonsterType[3];
		bestiary[4][0][3]=new MonsterType[3];
		bestiary[4][0][4]=new MonsterType[3];
		bestiary[4][0][4][0]=new MonsterType("Flarebear",4,0,4,0,"A Flarebear, as the name implies is a sun elemental bear");
		bestiary[4][0][4][1]=new MonsterType("FireTyrant",4,0,4,1,"A solar-elemental tyrant");
		bestiary[4][0][4][2]=new MonsterType("Sol",4,0,4,2,"A Sol is as bright as the sun, only smaller");
		bestiary[4][0][3][0]=new MonsterType("FlareWulf",4,0,3,0,"A FlareWulf is a glowing wolf that can breathe a solar flare",bestiary[4][0][4][0]);
		bestiary[4][0][3][1]=new MonsterType("Solaire",4,0,3,1,"A Solaire is a larger diurnal with big teeth and horns",bestiary[4][0][4][1]);
		bestiary[4][0][3][2]=new MonsterType("Antares",4,0,3,2,"Named after the third brighest star in the night sky, the Sirius is a brighter vega with more magic",bestiary[4][0][4][2]);
		bestiary[4][0][2][0]=new MonsterType("FireFaux",4,0,2,0,"A Firefaux is a fox that loves sitting in the sun and absorbing rays. It has a yellow coat, and is a reference to an awesome browser",bestiary[4][0][3][0]);
		bestiary[4][0][2][1]=new MonsterType("Diurnal",4,0,2,1,"A diurnal is a montser that is active only during the day. It looks like a saur made of flames",bestiary[4][0][3][1]);
		bestiary[4][0][2][2]=new MonsterType("Vega",4,0,2,2,"Named after the fifth brightest star in the sky, the vega is a spherical construct with rotating ray blades that resembles the sun",bestiary[4][0][3][2]);
		bestiary[4][0][1][0]=new MonsterType("Tona",4,0,1,0,"A tona is a floating orb that gains energy from the suns rays. At night it floats to rest and stops glowing, appearing a simple stone",bestiary[4][0][2][0],bestiary[4][0][2][1],bestiary[4][0][2][2]);
		bestiary[4][0][0][0]=new MonsterType("Solar egg",4,0,0,0,"The solar egg glows slightly in the night if left out in the sun all day, as if it absorbs the sun's rays",bestiary[4][0][1][0]);
		bestiary[4][0][4][0].setEvolvesFrom(bestiary[4][0][3][0]);
		bestiary[4][0][4][1].setEvolvesFrom(bestiary[4][0][4][1]);
		bestiary[4][0][4][2].setEvolvesFrom(bestiary[4][0][3][2]);
		bestiary[4][0][3][0].setEvolvesFrom(bestiary[4][0][2][0]);
		bestiary[4][0][3][1].setEvolvesFrom(bestiary[4][0][2][1]);
		bestiary[4][0][3][2].setEvolvesFrom(bestiary[4][0][2][2]);
		bestiary[4][0][2][0].setEvolvesFrom(bestiary[4][0][1][0]);
		bestiary[4][0][2][1].setEvolvesFrom(bestiary[4][0][1][0]);
		bestiary[4][0][2][2].setEvolvesFrom(bestiary[4][0][1][0]);
		bestiary[4][0][1][0].setEvolvesFrom(bestiary[4][0][0][0]);
		bestiary[4][1]=new MonsterType[5][];
		bestiary[4][1][0]=new MonsterType[1];
		bestiary[4][1][1]=new MonsterType[1];
		bestiary[4][1][2]=new MonsterType[2];
		bestiary[4][1][3]=new MonsterType[2];
		bestiary[4][1][4]=new MonsterType[2];
		bestiary[4][1][4][0]=new MonsterType("Lona",4,1,4,0,"Lona's are stronger when they have a Luna present. They are great white Wolves with ice colored eyes, their eyes seem to speak of their souls, human");
		bestiary[4][1][4][1]=new MonsterType("Luna",4,1,4,1,"Luna is a large moon appearing stone with a single large silver band surrounding it, that shows six phases of the moon");
		bestiary[4][1][3][0]=new MonsterType("Selen",4,1,3,0,"Selen is a greater wolf, pure white. It can preform moon beam which deals mainly light damage with water secondary.",bestiary[4][1][4][0]);
		bestiary[4][1][3][1]=new MonsterType("Mayari",4,1,3,1,"Mayari depicts a half full moon emblazoned on a cylindrical stone. The silver band surrounding it has spawned six crescents, all facing outwards",bestiary[4][1][4][1]);
		bestiary[4][1][2][0]=new MonsterType("Chia",4,1,2,0,"Chia is a small wolf that can howl at the moon to increase its attack",bestiary[4][1][3][0]);
		bestiary[4][1][2][1]=new MonsterType("Chandra",4,1,2,1,"Chandra is a cylindrical stone whose radius is 4 times its height, it shows the waning phase of the moon, if you were to project the waning moon on the rock, the rock cooresponding to the dark side of the moon is black and the lit side of the moon is white. It is surrounded by a simple silver bar with six crescents",bestiary[4][1][3][1]);
		bestiary[4][1][1][0]=new MonsterType("Lunapup",4,1,1,0,"The Lunapup is a small wolf born from a lunar egg on the full moon.",bestiary[4][1][2][0],bestiary[4][1][2][1]);
		bestiary[4][1][0][0]=new MonsterType("Lunar egg",4,1,0,0,"The Lunar egg appears to be a stone during the day, however when moonlight shines upon it, it is clearly an egg with the lunar symbol embossed upon it. The brightness of the symbol is determined by the phase the moon is in.",bestiary[4][1][1][0]);
		bestiary[4][1][4][0].setEvolvesFrom(bestiary[4][1][3][0]);
		bestiary[4][1][4][1].setEvolvesFrom(bestiary[4][1][3][1]);
		bestiary[4][1][3][0].setEvolvesFrom(bestiary[4][1][2][0]);
		bestiary[4][1][3][1].setEvolvesFrom(bestiary[4][1][2][1]);
		bestiary[4][1][2][0].setEvolvesFrom(bestiary[4][1][1][0]);
		bestiary[4][1][2][1].setEvolvesFrom(bestiary[4][1][1][0]);
		bestiary[4][1][1][0].setEvolvesFrom(bestiary[4][1][0][0]);
		bestiary[4][2]=new MonsterType[5][];
		bestiary[4][2][0]=new MonsterType[1];
		bestiary[4][2][1]=new MonsterType[1];
		bestiary[4][2][2]=new MonsterType[2];
		bestiary[4][2][3]=new MonsterType[2];
		bestiary[4][2][4]=new MonsterType[2];
		bestiary[4][2][4][0]=new MonsterType("Guardainus",4,2,4,0,"The Guardainus is a titan with a large amount of HP. He can cast a skill on a unit so that he dies instead of them when they are killed, transferring hp");
		bestiary[4][2][4][1]=new MonsterType("Halarial",4,2,4,1,"The Halarial is a greater angel. It can sacrifice itself to keep another from death for three turns");
		bestiary[4][2][3][0]=new MonsterType("Scardar",4,2,3,0,"The scardar has many scars, including one over his left eye, his visible skin is scarred and his shield is spiked which allows him to return a percentage of damage",bestiary[4][2][4][0]);
		bestiary[4][2][3][1]=new MonsterType("Halosses",4,2,3,1,"The Halosses is a fully adult angel cloaked in green. She can cast regen on an ally which heals it for some hp each turn",bestiary[4][2][4][1]);
		bestiary[4][2][2][0]=new MonsterType("Sheildar",4,2,2,0,"The Sheildar is an older Escutcheoner who has acquired metal guards, which is a plus. He can taunt enemies to force them to attack him",bestiary[4][2][3][0]);
		bestiary[4][2][2][1]=new MonsterType("Haloss",4,2,2,1,"The Haloss is a lesser angel that can cast shell on an ally, which acts as a temporary shield",bestiary[4][2][3][1]);
		bestiary[4][2][1][0]=new MonsterType("Escutcheoner",4,2,1,0,"The Escutcheoner is a small creature with a big shield that it is very proud of and shines on a daily basis. In combat he can attack as usual",bestiary[4][2][2][0],bestiary[4][2][2][1]);
		bestiary[4][2][0][0]=new MonsterType("Guardian Egg",4,2,0,0,"The guardian tree is hard as a rock, the guardian crest embossed on its center",bestiary[4][2][1][0]);
		bestiary[4][2][4][0].setEvolvesFrom(bestiary[4][2][3][0]);
		bestiary[4][2][4][1].setEvolvesFrom(bestiary[4][2][3][1]);
		bestiary[4][2][3][0].setEvolvesFrom(bestiary[4][2][2][0]);
		bestiary[4][2][3][1].setEvolvesFrom(bestiary[4][2][2][1]);
		bestiary[4][2][2][0].setEvolvesFrom(bestiary[4][2][1][0]);
		bestiary[4][2][2][1].setEvolvesFrom(bestiary[4][2][1][0]);
		bestiary[4][2][1][0].setEvolvesFrom(bestiary[4][2][0][0]);
		bestiary[4][3]=new MonsterType[5][];
		bestiary[4][3][0]=new MonsterType[1];
		bestiary[4][3][1]=new MonsterType[1];
		bestiary[4][3][2]=new MonsterType[2];
		bestiary[4][3][3]=new MonsterType[2];
		bestiary[4][3][4]=new MonsterType[2];
		bestiary[4][3][4][0]=new MonsterType("Archangel",4,3,4,0,"The Archangel  can buff all angels on the owners side");
		bestiary[4][3][4][1]=new MonsterType("Ultrangel",4,3,4,1,"The ultra angel is the epitome of an angel");
		bestiary[4][3][3][0]=new MonsterType("Onangel",4,3,3,0,"The Onangel has a passive buff that deals 15% bonus damage to dark elemental enemies",bestiary[4][3][4][0]);
		bestiary[4][3][3][1]=new MonsterType("Anangel",4,3,3,1,"The Anangel can promote its allies to do +20% damage versus dark primary enemies",bestiary[4][3][4][1]);		
		bestiary[4][3][2][0]=new MonsterType("Hemiangel",4,3,2,0,"The Hemiangel has a cherubic body and shoots from a bow",bestiary[4][3][3][0]);
		bestiary[4][3][2][1]=new MonsterType("Semiangel",4,3,2,1,"The Semiangel can annoint light primary allies, buffing their attack by 20%",bestiary[4][3][3][1]);
		bestiary[4][3][1][0]=new MonsterType("Demiangel",4,3,1,0,"The Demiangel is a small angel who left heaven in order to help the world (or its wings were not strong enough to keep it that high in the sky, depending on who you ask) its magical ability is to heal, however it refuses to heal anything with a dark or fire element",bestiary[4][3][2][0],bestiary[4][3][2][1]);
		bestiary[4][3][0][0]=new MonsterType("Holy Egg",4,3,0,0,"It is a golden egg. Unfortunately there are only a finite number of them because the people benefiting from the golden egg killed the goose that laid them thinking the goose must be made of diamonds. They were wrong.",bestiary[4][3][1][0]);
		bestiary[4][3][4][0].setEvolvesFrom(bestiary[4][3][3][0]);
		bestiary[4][3][4][1].setEvolvesFrom(bestiary[4][3][3][1]);
		bestiary[4][3][3][0].setEvolvesFrom(bestiary[4][3][2][0]);
		bestiary[4][3][3][1].setEvolvesFrom(bestiary[4][3][2][1]);
		bestiary[4][3][2][0].setEvolvesFrom(bestiary[4][3][1][0]);
		bestiary[4][3][2][1].setEvolvesFrom(bestiary[4][3][0][0]);
		bestiary[4][4]=new MonsterType[5][];
		bestiary[4][4][0]=new MonsterType[1];
		bestiary[4][4][1]=new MonsterType[1];
		bestiary[4][4][2]=new MonsterType[3];
		bestiary[4][4][3]=new MonsterType[3];
		bestiary[4][4][4]=new MonsterType[3];
		bestiary[4][4][4][0]=new MonsterType("Ascendenphage",4,4,4,0, "The Ascendenpage is a lage Argenphage whose armor glows a brilliant white, made of some opaque white metal, the symbols etched into the metal are likewise fancy");
		bestiary[4][4][4][1]=new MonsterType("Luminacier",4,4,4,1,"The Luminacier is a single Luminace surrounded by six smaller Candellas, representing faith, justice, mercy, compassion, forgiveness and redemption");
		bestiary[4][4][4][2]=new MonsterType("Light Atronach",4,4,4,2,"The light atronach is an ascendant light elemenal that is surrounded by six symbols, representing each of the six elements");
		bestiary[4][4][3][0]=new MonsterType("Argenphage",4,4,3,0,"The Argenphage is a larger phage with silver plates inlaid with complex designs. It is said that their eyes can see the balance of a soul",bestiary[4][4][4][0]);
		bestiary[4][4][3][1]=new MonsterType("Luminace",4,4,3,1,"The Luminace is a collection of three Candellas, representing faith, truth and service, the virtues of its holy order. It will often shirk from the control of a dark master, even rebelling at times",bestiary[4][4][4][1]);	
		bestiary[4][4][3][2]=new MonsterType("Light Elemental",4,4,3,2,"the light elemental is a large light symbol surrounded by three other symbols, water, air and earth. The elemental can channel any of the four energies",bestiary[4][4][4][2]);
		bestiary[4][4][2][0]=new MonsterType("Phage",4,4,2,0, "A phage is a glowing ball of light that is protected by golden armor. It is floating about three feet in the air and has three fingered golden claws that extend two feet from its shoulders. it has two asymmetric horns on its helmet that is not attached to its body, and light glows from the eye sockets",bestiary[4][4][3][0]);
		bestiary[4][4][2][1]=new MonsterType("Candella",4,4,2,1, "A Candella absorbs the light of the sun during the day and uses this light to attack its enemies at night. It can reveal the presence of monsters trying to stealth",bestiary[4][4][3][1]);
		bestiary[4][4][2][2]=new MonsterType("Light Symbol",4,4,2,2,"A Light symbol is the embodiment of the symbol of light and can cast lumimagia 1, the basic light attack spell",bestiary[4][4][3][2]);
		bestiary[4][4][1][0]=new MonsterType("Lumin",4,4,1,0,"A lesser lumin is a small hovering ball of light that can heal other light monsters",bestiary[4][4][2][0],bestiary[4][4][2][1],bestiary[4][4][2][2]);
		bestiary[4][4][0][0]=new MonsterType("Luxor Egg",4,4,0,0,"The luxor Egg glows a brilliant white and has the luxor symbol etched on its surface",bestiary[4][4][1][0],skillSet[4]);
		bestiary[4][5]=new MonsterType[5][];
		bestiary[4][5][0]=new MonsterType[1];
		bestiary[4][5][1]=new MonsterType[1];
		bestiary[4][5][2]=new MonsterType[3];
		bestiary[4][5][3]=new MonsterType[3];
		bestiary[4][5][4]=new MonsterType[3];
		bestiary[4][5][4][0]=new MonsterType("Atonement",4,5,4,0,"The Atonment is a very large muscluar ex-demon that is particularly enraged by sin, Its unique attack is the Redemption Cross Slash that can reduce all enemies health to at least 1 and deals more damage against dark elementals");
		bestiary[4][5][4][1]=new MonsterType("Redeemer",4,5,4,1,"The Redeemer's special attack temporarily changes the primary element of its target to light for the duration of the battle");
		bestiary[4][5][4][2]=new MonsterType("Enlighten",4,5,4,2,"The Enlighten looks like the Glowen except it has magestic black wings, in stark contrast with its white robe. It can cast an area of effect light attack that harms its enemies and heals its allies of blindness and casts regen on them");
		bestiary[4][5][3][0]=new MonsterType("Astone",4,5,3,0,"The Atonet is a large muscular ex-demon whose horn-stumps are clearly visible. It redeems itself by fighting for just causes. Its special will not end an enemies life, as it has sworn off killing, but will leave it with at lest 1 hp remaining",bestiary[4][5][4][0]);
		bestiary[4][5][3][1]=new MonsterType("Restit",4,5,3,1,"The Restit is an ex-demon that is very agile. It can speak words of hope to dark monsters that does average damage but costs no mp",bestiary[4][5][4][1]);
		bestiary[4][5][3][2]=new MonsterType("Glowen",4,5,3,2,"The Glowen is a redeemed fallen angel, whose cut wings are beginning to regrow. Its eyes caused it to sin, so it cast them aside, and wears a blindfold in their place. It cannot hit with phyiscal attacks, but it can cast repent, a spell that will attack all of the monsters on the other field",bestiary[4][5][4][2]);
		bestiary[4][5][2][0]=new MonsterType("Atonet",4,5,2,0,"The Astone is an ex-demon that is large and round for its age. It redeems itself by taking some of the damage from another. Like its predecessor form it is a shell of darkness engulfing an orb of light. however, it is much larger and fatter",bestiary[4][5][3][0]);
		bestiary[4][5][2][1]=new MonsterType("Reprate",4,5,2,1,"The Reperate is an ex-demon that is thin lanky and agile. It redeems itself by correcting its path, and zelously avoiding temptation. It has a sneak attack that does extra damage against dark elementals",bestiary[4][5][3][1]);
		bestiary[4][5][2][2]=new MonsterType("Dimmer",4,5,2,2,"The Dimmer is a young ex-demon that his small and angelic, with a cowl that covers much of its face, dirty white lined with black. It redeems itself through prayer and meditation, and can cast shine, a magic spell that shows the way through the darkness",bestiary[4][5][3][2]);
		bestiary[4][5][1][0]=new MonsterType("Guiltor",4,5,1,0,"The guiltor is a minor demon whose outer body is dark. However, a globe of light dwells within, that holds its hope of redemption. When it is near, mistakes are better remembered, although reparations are not always clear",bestiary[4][5][2][0],bestiary[4][5][2][1],bestiary[4][5][2][2]);
		bestiary[4][5][0][0]=new MonsterType("Redemption Egg",4,5,0,0,"The Redemption egg appears metallic, as if some base crude metals grime was scraped away, revealing an inner shine",bestiary[4][5][1][0]);
		bestiary[4][5][4][0].setEvolvesFrom(bestiary[4][5][3][0]);
		bestiary[4][5][4][1].setEvolvesFrom(bestiary[4][5][3][1]);
		bestiary[4][5][4][2].setEvolvesFrom(bestiary[4][5][3][2]);
		bestiary[4][5][3][0].setEvolvesFrom(bestiary[4][5][2][0]);
		bestiary[4][5][3][1].setEvolvesFrom(bestiary[4][5][2][1]);
		bestiary[4][5][3][2].setEvolvesFrom(bestiary[4][5][2][2]);
		bestiary[4][5][2][0].setEvolvesFrom(bestiary[4][5][1][0]);
		bestiary[4][5][2][1].setEvolvesFrom(bestiary[4][5][1][0]);
		bestiary[4][5][2][2].setEvolvesFrom(bestiary[4][5][1][0]);
		bestiary[4][5][1][0].setEvolvesFrom(bestiary[4][5][0][0]);
		bestiary[5][0]=new MonsterType[5][];
		bestiary[5][0][0]=new MonsterType[1];
		bestiary[5][0][1]=new MonsterType[1];
		bestiary[5][0][2]=new MonsterType[3];
		bestiary[5][0][3]=new MonsterType[3];
		bestiary[5][0][4]=new MonsterType[3];
		bestiary[5][0][4][0]=new MonsterType("Astaroth",5,0,4,0,"Astaroth is a bright red demon with large black horns fifteen feet tall. He weilds a large corrupted axe that has a living eye where the blade meets the haft");
		bestiary[5][0][4][1]=new MonsterType("Asag",5,0,4,1,"Asag is also known as the fear. He appears as a giant demon with the body of a bear and the head of a stag.");
		bestiary[5][0][4][2]=new MonsterType("Shedu",5,0,4,2,"The Shedu is a phantom witch that speaks only curses, whose eyeless sockets see through the dark and not");
		bestiary[5][0][3][0]=new MonsterType("Incubus",5,0,3,0,"The Incubus can take many forms, sometimes appearing as a poet, or perhaps an athelete to sexually corrupt women, when they feel excited as their prey is near, often their eyes will revert to their true form, but only for an instant, giving the virtuous their only warning",bestiary[5][0][4][0]);
		bestiary[5][0][3][1]=new MonsterType("Succubus",5,0,3,1,"The succubus is a beautiful female demon meant to provoke lust in the hearts of men. They catch their prey more ofthen than the Incubus, as men have weaker hearts when it comes to resisting beauty",bestiary[5][0][4][1]);
		bestiary[5][0][3][2]=new MonsterType("Grimiore",5,0,3,2,"A sentient black book that has the demon crest embossed on the cover. The spells and hexes within are written in both the blood of the slain and the blood of the conqueror",bestiary[5][0][4][2]);
		bestiary[5][0][2][0]=new MonsterType("Scamp",5,0,2,0,"A scamp is a minor demon with claws and long ears, it screams at its enemies to initiate combat",bestiary[5][0][3][0]);
		bestiary[5][0][2][1]=new MonsterType("Imp",5,0,2,1,"An imp is a small red demon carrying a pitchfork. It is aggressive but is wise enough not to initiate combat against a stronger opponent",bestiary[5][0][3][1]);
		bestiary[5][0][2][2]=new MonsterType("Jinn",5,0,2,2,"A Jinn attacks its enemies with mystical enemies, preying on the weak of mind. It is ephemeral, which greatly reduces the efficacy of physical attacks",bestiary[5][0][3][2]);
		bestiary[5][0][1][0]=new MonsterType("Fiend",5,0,1,0,"The fiend is a minor demon, colored dark red with black horns",bestiary[5][0][2][0],bestiary[5][0][2][1],bestiary[5][0][2][2]);
		bestiary[5][0][0][0]=new MonsterType("Demonic Egg",5,0,0,0,"The demonic egg is is a rusty black with the demonic symbol embossed on its center, it is painful to touch",bestiary[5][0][1][0]);
		bestiary[5][0][4][0].setEvolvesFrom(bestiary[5][0][3][0]);
		bestiary[5][0][4][1].setEvolvesFrom(bestiary[5][0][3][1]);
		bestiary[5][0][4][2].setEvolvesFrom(bestiary[5][0][3][2]);
		bestiary[5][0][3][0].setEvolvesFrom(bestiary[5][0][2][0]);
		bestiary[5][0][3][1].setEvolvesFrom(bestiary[5][0][2][1]);
		bestiary[5][0][3][2].setEvolvesFrom(bestiary[5][0][2][2]);
		bestiary[5][0][2][0].setEvolvesFrom(bestiary[5][0][1][0]);
		bestiary[5][0][2][1].setEvolvesFrom(bestiary[5][0][1][0]);
		bestiary[5][0][2][2].setEvolvesFrom(bestiary[5][0][1][0]);
		bestiary[5][0][1][0].setEvolvesFrom(bestiary[5][0][0][0]);
		bestiary[5][1]=new MonsterType[5][];
		bestiary[5][1][0]=new MonsterType[1];
		bestiary[5][1][1]=new MonsterType[1];
		bestiary[5][1][2]=new MonsterType[3];
		bestiary[5][1][3]=new MonsterType[3];
		bestiary[5][1][4]=new MonsterType[4];
		bestiary[5][1][4][0]=new MonsterType("Queen B",5,1,3,0,"Queen B is the younger sister of Queen A, however when they were in a beauty pagent, everyone chose Queen B, so she became the dominant Queen. She can summon Stingers to the empty allied positions");
		bestiary[5][1][4][1]=new MonsterType("King Rattle",5,1,3,1,"King Rattle has a large Rattle on the end of its tail. Not like a snakes, like a babies rattle, but really large. It also has a crown. Its scales are brown and it is very large");
		bestiary[5][1][4][2]=new MonsterType("Red Widow",5,1,3,2,"The Red Widow has gotten over her husbands death. The hourglass has turned black, and the rest of her has turned red. This color, and the scent given off from her hide, attracts insects to their doom. Her bright color does as well");
		bestiary[5][1][4][3]=new MonsterType("Cougar Spider",5,1,3,3,"The Cougar Spider is an older spider who still looks nice and knows how to treat men (spiders) right. She takes them to her web and then eats them.");
		bestiary[5][1][3][0]=new MonsterType("Wasplash",5,1,3,0,"The Wasplash is an oversized wasp with a stinger and it can latch onto a single enemy with the hooked blades on the end of its legs, stinging them multiple times",bestiary[5][1][4][0]);
		bestiary[5][1][3][1]=new MonsterType("Slyslyther",5,1,3,1,"The SlySlyther is a grown Slyther whose scales have turned black as night, it is very quiet and can sneak attack its enemies.",bestiary[5][1][4][1]);
		bestiary[5][1][3][2]=new MonsterType("Widow",5,1,3,2,"The Widow is a widowed spider that is really broken up about it, cries all the time. It looks like a black widow but larger and sad",bestiary[5][1][4][2],bestiary[5][1][4][3]);
		bestiary[5][1][2][0]=new MonsterType("Stinger",5,1,2,0,"The Stinger is an oversized wasp with a poisonous stinger",bestiary[5][1][3][0]);
		bestiary[5][1][2][1]=new MonsterType("Slyther",5,1,2,1,"The Slyther is a small snake that slides through the grass towards its prey. Its bite is venemous. Its green and has no rattle",bestiary[5][1][3][1]);
		bestiary[5][1][2][2]=new MonsterType("Creeper",5,1,2,2,"The creeper is a spider that can shoot webs at its enemies to slow them down.",bestiary[5][1][3][2]);
		bestiary[5][1][1][0]=new MonsterType("Fanger",5,1,1,0,"The fanger is a small scorpion that can lift its legs up and slither and has fangs",bestiary[5][1][2][0],bestiary[5][1][2][1],bestiary[5][1][2][2]);
		bestiary[5][1][0][0]=new MonsterType("Poison Egg",5,1,0,0,"The poison egg is black with a greenish hue. The symbol is embossed on its surface, and spikes extend from the shell, which defend itself. The spikes are of course dipped in poison",bestiary[5][1][1][0]);
		bestiary[5][1][4][0].setEvolvesFrom(bestiary[5][1][3][0]);
		bestiary[5][1][4][1].setEvolvesFrom(bestiary[5][1][3][1]);
		bestiary[5][1][4][2].setEvolvesFrom(bestiary[5][1][3][2]);
		bestiary[5][1][4][3].setEvolvesFrom(bestiary[5][1][3][2]);
		bestiary[5][1][3][0].setEvolvesFrom(bestiary[5][1][2][0]);
		bestiary[5][1][3][1].setEvolvesFrom(bestiary[5][1][2][1]);
		bestiary[5][1][3][2].setEvolvesFrom(bestiary[5][1][2][2]);
		bestiary[5][1][2][0].setEvolvesFrom(bestiary[5][1][1][0]);
		bestiary[5][1][2][1].setEvolvesFrom(bestiary[5][1][1][0]);
		bestiary[5][1][2][2].setEvolvesFrom(bestiary[5][1][1][0]);
		bestiary[5][1][1][0].setEvolvesFrom(bestiary[5][1][0][0]);
		bestiary[5][2]=new MonsterType[5][];//TODO redo this one
		bestiary[5][2][0]=new MonsterType[1];
		bestiary[5][2][1]=new MonsterType[1];
		bestiary[5][2][2]=new MonsterType[2];
		bestiary[5][2][3]=new MonsterType[2];
		bestiary[5][2][4]=new MonsterType[2];
		bestiary[5][2][4][0]=new MonsterType("Skulltyrant",5,2,4,0,"The Skulltyrant is a large undead T-rex. Very Scary");
		bestiary[5][2][4][1]=new MonsterType("Specter",5,2,4,1,"The Specter can possess an enemy for three turns after which it dies");
		bestiary[5][2][3][0]=new MonsterType("Skullclar",5,2,3,0,"The Skullclar is a larger Skullsaur with wings and horns",bestiary[5][2][4][0]);
		bestiary[5][2][3][1]=new MonsterType("Wraith",5,2,3,1,"The Phantom is still incorporeal and weilds a curved scepter",bestiary[5][2][4][1]);
		bestiary[5][2][2][0]=new MonsterType("Skullsaur",5,2,2,0,"The Skullsaur is a undead veloceraptor looking thing that has a badass attack called deathclaw",bestiary[5][2][3][0]);
		bestiary[5][2][2][1]=new MonsterType("Ghostet",5,2,2,1,"The Ghostet is a weak phantom that takes reduced physical damage",bestiary[5][2][3][1]);
		bestiary[5][2][1][0]=new MonsterType("Stull",5,2,1,0,"The stull is a floating skull with glowing green orbs in its eye sockets",bestiary[5][2][2][0],bestiary[5][2][2][1]);
		bestiary[5][2][0][0]=new MonsterType("Undead Egg",5,2,0,0,"Lifeless and cold, the egg is the color and consistency of bone, with the undead crest embossed on the center",bestiary[5][2][1][0]);
		bestiary[5][2][4][0].setEvolvesFrom(bestiary[5][2][3][0]);
		bestiary[5][2][4][1].setEvolvesFrom(bestiary[5][2][3][1]);
		bestiary[5][2][3][0].setEvolvesFrom(bestiary[5][2][2][0]);
		bestiary[5][2][3][1].setEvolvesFrom(bestiary[5][2][2][1]);
		bestiary[5][2][2][0].setEvolvesFrom(bestiary[5][2][1][0]);
		bestiary[5][2][2][1].setEvolvesFrom(bestiary[5][2][1][0]);
		bestiary[5][2][1][0].setEvolvesFrom(bestiary[5][2][0][0]);
		bestiary[5][3]=new MonsterType[5][];
		bestiary[5][3][0]=new MonsterType[1];
		bestiary[5][3][1]=new MonsterType[1];
		bestiary[5][3][2]=new MonsterType[1];
		bestiary[5][3][3]=new MonsterType[1];
		bestiary[5][3][4]=new MonsterType[1];
		bestiary[5][3][4][0]=new MonsterType("Thundragon",5,3,4,0,"The Thundragon is a fully formed dragon made of clouds. Its breath is a hurricane, its scream a thunderbolt");
		bestiary[5][3][3][0]=new MonsterType("Tempestor",5,3,3,0,"The Tempestor is a greater thunder wyvern with wings and rear claws. Its presence will darken the sky and call harsh gales",bestiary[5][3][4][0]);
		bestiary[5][3][2][0]=new MonsterType("Thundroar",5,3,2,0,"The Thundroar is a dragonlike snake in the clouds. Lightening storms occur when multiple Thundroars battle in the heavens. It is said that thunder is caused by their roaring",bestiary[5][3][3][0]);
		bestiary[5][3][1][0]=new MonsterType("Maltag",5,3,1,0,"Have you ever had a really bad day? So bad that even though there was a clear blue sky, it felt like a small dark cloud was following you around? This is that cloud",bestiary[5][3][2][0]);
		bestiary[5][3][0][0]=new MonsterType("Storm Egg",5,3,0,0,"The storm egg is solid black and appears to be made of obsidian, excepting, of course, the symbol embossed on its center",bestiary[5][3][1][0]);
		bestiary[5][3][4][0].setEvolvesFrom(bestiary[5][3][3][0]);
		bestiary[5][3][3][0].setEvolvesFrom(bestiary[5][3][2][0]);
		bestiary[5][3][2][0].setEvolvesFrom(bestiary[5][3][1][0]);
		bestiary[5][3][1][0].setEvolvesFrom(bestiary[5][3][0][0]);
		bestiary[5][4]=new MonsterType[5][];//TODO: maybe flesh this one out a bit more
		bestiary[5][4][0]=new MonsterType[1];
		bestiary[5][4][1]=new MonsterType[1];
		bestiary[5][4][2]=new MonsterType[2];
		bestiary[5][4][3]=new MonsterType[1];
		bestiary[5][4][4]=new MonsterType[1];
		bestiary[5][4][4][0]=new MonsterType("Avengeant",5,4,4,0,"The Avengeant once served God, but gien will, disagreed with his descision. When he went to resolve the conflict, God couldn't stand being questioned and excommunicated the Avengent, who has hated God and those loyal to him ever since");
		bestiary[5][4][3][0]=new MonsterType("Black Knight",5,4,3,0,"The black knight is sheilded in dark plate, that has rituals etched into the steel",bestiary[5][4][4][0]);
		bestiary[5][4][2][0]=new MonsterType("Dark Phage",5,4,2,0,"The dark phage is a corrupted phage that turned from the service of its creator",bestiary[5][4][3][0]);
		bestiary[5][4][2][1]=new MonsterType("Fallen HemiAngel",5,4,2,1,"The Fallen HemiAngel has larger wings both turned black",bestiary[5][4][3][0]);
		bestiary[5][4][1][0]=new MonsterType("Fallen DemiAngel",5,4,1,0,"The fallen demiAngel is an angel that followed the light bringer when he fell from heaven. It was weak then, and has yet to grow",bestiary[5][4][2][0],bestiary[5][4][2][1]);
		bestiary[5][4][0][0]=new MonsterType("Betrayer Eggs",5,4,0,0,"The betrayer egg is half black and half white its center embossed with the betrayers symbol, a back being stabbed",bestiary[5][4][1][0]);
		bestiary[5][4][4][0].setEvolvesFrom(bestiary[5][4][3][0]);
		bestiary[5][4][3][0].setEvolvesFrom(bestiary[5][4][2][0]);
		bestiary[5][4][3][0].setEvolvesFrom2(bestiary[5][4][2][1]);
		bestiary[5][4][2][0].setEvolvesFrom(bestiary[5][4][1][0]);
		bestiary[5][4][1][0].setEvolvesFrom(bestiary[5][4][0][0]);
		bestiary[5][5]=new MonsterType[5][];
		bestiary[5][5][0]=new MonsterType[1];
		bestiary[5][5][1]=new MonsterType[1];
		bestiary[5][5][2]=new MonsterType[3];
		bestiary[5][5][3]=new MonsterType[3];
		bestiary[5][5][4]=new MonsterType[3];
		bestiary[5][5][4][0]=new MonsterType("Eye Of Dis",5,5,4,0,"The Eye of Dis is one of the many eyes of the dark god Dis himself- it can see all aspects of you. Kill it before it speaks, as those that hear its voice turn mad");
		bestiary[5][5][4][1]=new MonsterType("Mang",5,5,4,1,"Mang appears as an old man with a walking stick. Attack it and see what happens");
		bestiary[5][5][4][2]=new MonsterType("Umbral Atronach",5,5,4,2,"The Umbral Atronach is a very large umbral symbol surrounded by Elementals representing every element. As such, it can cast greater darkness magics and regular magics of every other element");
		bestiary[5][5][3][0]=new MonsterType("Senistair",5,5,3,0,"The Senistair is a shadow in the form of a man whose eyeless sockets peer into your soul. It has an inhuman cheshire smile that can only elicit terror",bestiary[5][5][4][0]);
		bestiary[5][5][3][1]=new MonsterType("Caecus",5,5,3,1,"The caecus is a shadow warrior with a bandage wrapped around its eyes. It cannot see, but tracks its enemies by listening-often giving it a better picture of reality than sight",bestiary[5][5][4][1]);
		bestiary[5][5][3][2]=new MonsterType("Umbral Elemental",5,5,3,2,"The Umbral Elemental is a large umbral symbol surrounded by three lesser symbols of other elements. As such, it can cast lesser magics of those elements",bestiary[5][5][4][2]);
		bestiary[5][5][2][0]=new MonsterType("Shadeoss",5,5,2,0,"The Shadeoss is strongest in darkness. It appears to be the upper torso of a knight weilding a sword",bestiary[5][5][3][0]);
		bestiary[5][5][2][1]=new MonsterType("Screel",5,5,2,1,"The Screel is a black envy demon, desiring the desiring the form and life of a man. It is still young, so the result is obscene",bestiary[5][5][3][0]);
		bestiary[5][5][2][2]=new MonsterType("Umbral Symbol",5,5,2,2,"The Umbral Symbol is a floating symbol in the shape of the blinded eye that casts basic dark magic",bestiary[5][5][3][1]);
		bestiary[5][5][1][0]=new MonsterType("Umbress",5,5,1,0,"The umbress appears to bea small floating black flame, with two purple eyes",bestiary[5][5][2][0],bestiary[5][5][2][1],bestiary[5][5][2][2]);
		bestiary[5][5][0][0]=new MonsterType("Umbral Egg",5,5,0,0,"The umbral egg sucks light and appears to cast dark tendrils from its shell, but if you look again theyre gone. It seems weak and fragile when exposed to light, but during the dusk, when the light is weak, the blinded eye  can be seen embossed on its surface",bestiary[5][5][1][0],skillSet[5]);
		bestiary[5][5][4][0].setEvolvesFrom(bestiary[5][5][3][0]);
		bestiary[5][5][4][1].setEvolvesFrom(bestiary[5][5][3][1]);
		bestiary[5][5][4][2].setEvolvesFrom(bestiary[5][5][3][2]);
		bestiary[5][5][3][0].setEvolvesFrom(bestiary[5][5][2][0]);
		bestiary[5][5][3][1].setEvolvesFrom(bestiary[5][5][2][1]);
		bestiary[5][5][3][2].setEvolvesFrom(bestiary[5][5][2][2]);
		bestiary[5][5][2][0].setEvolvesFrom(bestiary[5][5][1][0]);
		bestiary[5][5][2][1].setEvolvesFrom(bestiary[5][5][1][0]);
		bestiary[5][5][2][2].setEvolvesFrom(bestiary[5][5][1][0]);
		bestiary[5][5][1][0].setEvolvesFrom(bestiary[5][5][0][0]);
		//TODO finish
		return bestiary;
	}
	public static MonsterType[] convertTo1d()
	{
		MonsterType[] bestiary1d=new MonsterType[358];
		int index=0;
		for(int i=0; i<bestiary.length;i++)
		{
			for(int j=0; j<bestiary[i].length; j++)
			{
				for(int k=0; k<bestiary[i][j].length; k++)
				{
					for(int m=0; m<bestiary[i][j][k].length; m++)
					{
						bestiary1d[index]=bestiary[i][j][k][m];
						index++;
					}
				}
			}
		}
		return bestiary1d;
	}
	public static Fourple[] generateMonsterIndexes()
	{
		MonsterType[] myArray=convertTo1d();
		Fourple[] myFourples=new Fourple[myArray.length];
		for(int i=0; i<myFourples.length;i++)
		{
			myFourples[i]=new Fourple();
		}
		int index=0;
		for(int i=0; i<bestiary.length;i++)
		{
			for(int j=0; j<bestiary[i].length;j++)
			{
				for(int k=0; k<bestiary[i][j].length;k++)
				{
					for(int m=0;m<bestiary[i][j][k].length;m++)
					{
						myFourples[index].m_a=i;
						myFourples[index].m_b=j;
						myFourples[index].m_c=k;
						myFourples[index].m_d=m;
						index++;
					}
				}
			}
		}
		return myFourples;
	}
	public static String[][] defineTypes()
	{
		String[][] typeNames = new String[6][6];
		
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
		
		return typeNames;
	}
	public static void travel()
	{
		exit=false;
		Fourple myFourple= new Fourple();
		int lookup;
		while(!exit)
		{	
			System.out.println("What would you like to do?\n1) Find monsters by element\n2) Look at random Monster\n3) Look up Monster by Index\n4) Look up Monster by Array position");
			choice=Main.verify(4);
			if(choice==1)
			{
				travelPrimary();
			}
			else if(choice==2)
			{
				int primaryElement=Main.randomNumber(0,bestiary.length-1);
				int secondaryElement=Main.randomNumber(0, bestiary[primaryElement].length-1);
				int evolutionStage=Main.randomNumber(0, bestiary[primaryElement][secondaryElement].length-1);
				int monsterSelect=Main.randomNumber(0, bestiary[primaryElement][secondaryElement][evolutionStage].length-1);
				myFourple.m_a=primaryElement;
				myFourple.m_b=secondaryElement;
				myFourple.m_c=evolutionStage;
				myFourple.m_d=monsterSelect;
				while(myFourple.m_a!=7)
				{
					myFourple=travelMonster(myFourple.m_a,myFourple.m_b,myFourple.m_c,myFourple.m_d);
				}
			}
			else if(choice==3)
			{
				System.out.println("What position in the 1d array would you like to lookup?");
				MonsterType[] bestiary1d=convertTo1d();
				Fourple[] IndexLookup=generateMonsterIndexes();
				lookup=Main.verify(bestiary1d.length);
				myFourple=IndexLookup[lookup];
				while(myFourple.m_a!=7)
				{
					myFourple=travelMonster(myFourple.m_a,myFourple.m_b,myFourple.m_c,myFourple.m_d);
				}
			}
		}
	}
	

	public static void travelPrimary()
	{
		exit=false;
		while(!exit)
		{
			System.out.println("What is the primary element of the monster you would like to look for?");
			System.out.println("1) Fire\n2) Water\n3) Earth\n4) Air\n5) Light\n6) Dark\n7)Exit Bestiary");
			choice=Main.verify(7);
			if(choice>0&&choice<7)
			{
				travelSecondary(choice-1);
			}
			else if(choice==7)
			{
				return;
			}
		}
	}
	public static void travelSecondary(int primary)
	{
		exit=false;
		while(!exit)
		{
			System.out.println("What is the secondary element of the monster you would like to look for?");
			for(int i=1; i<bestiary[primary].length+1;i++)
			{
				System.out.print(i + ") ");
				System.out.println(typeNames[primary][i-1]);
			}
			System.out.println("7) Go Back\n8) Exit");
			choice=Main.verify(bestiary[primary].length+2);
			if(choice>0&&choice<7)
			{
				travelEvolution(primary,choice-1);
			}
			else if(choice==7)
			{
				return;
			}
			else if(choice==8)
			{
				exit=true;//this sets the static value to true, which will kick the user out of all while loops in bestiary
				return;
			}
		}
		
	}
	public static void travelEvolution(int primary,int secondary)
	{
		Fourple next=new Fourple();
		next.m_a=0;
		exit=false;
		Fourple catcher;
		while(!exit)
		{
			System.out.println("Which monster sub-group for the " + typeNames[primary][secondary] + " monster group would you like to look at?");
			System.out.println("1) Show All\n2) Show Eggs\n3) Show Infants\n4) Show Adolescents\n5) Show Adults\n6) Show Elders\n7) Go Back\n8) Exit");
			choice=Main.verify(8);
			while(choice==1)
			{
				catcher=travelShowAllInGroup(primary,secondary);
				if(catcher.m_a==7)
				{
					choice=0;
				}
				else
				{
					while(catcher.m_a!=7)
					{
						catcher =travelMonster(catcher.m_a,catcher.m_b,catcher.m_c,catcher.m_d);
					}
				}
			}
			if(choice>1&&choice<7)
			{
				travelSelect(primary,secondary,choice-2);
			}
			else if(choice==7)
			{
				return;
			}
			else if(choice==8)
			{
				exit=true;
				return;
			}
			
		}
	}
	public static void travelSelect(int primary,int secondary, int evolution)
	{
		int length;
		Fourple next = new Fourple();
		next.m_a=0;
		exit=false;
		while(!exit)
		{
			length = bestiary[primary][secondary][evolution].length;
			System.out.println("Which monster type would you like to look at?");
			for(int i=1; i<bestiary[primary][secondary][evolution].length+1;i++)
			{
				System.out.println(i + ") " + bestiary[primary][secondary][evolution][i-1].getTypeName());
			}
			System.out.println((length+1) + ") Go Back\n" +(length+2)+ ") Exit");
			choice=Main.verify(length+2);
			next.m_a=primary;
			next.m_b=secondary;
			next.m_c=evolution;
			next.m_d=choice-1;
			if(choice>0 && choice<length)
			{
				while(next.m_a!=7)
				{
					next= travelMonster(next.m_a,next.m_b,next.m_c,next.m_d);
				}
			}
			else if(choice==length+1)
			{
				return;
			}
			else if(choice==length+2)
			{
				exit=true;
				return;
			}
		}
	}
	public static Fourple travelShowAllInGroup(int primary, int secondary)
	{
		exit=false;
		Fourple returner = new Fourple();
		int choice=0;
		int size=0;//the size of the array of tuples
		//This for loop determines the length of the tuple
		for(int i=0; i<bestiary[primary][secondary].length;i++)
		{
			for(int j=0;j<bestiary[primary][secondary][i].length;j++)
			{
				size++;
			}
		}
		
		Tuple[] choices = new Tuple[size]; 
		for(int i=0;i<size;i++)
		{
			choices[i]=new Tuple();
		}
		while(exit==false)//just mixing up the looping condition for some style points
		{
			System.out.println("Which Monster in the group would you like to look at?");
			for(int i=0; i<bestiary[primary][secondary].length;i++)
			{
				for(int j=0; j<bestiary[primary][secondary][i].length;j++)
				{
					System.out.println((choice+1) + ") " + bestiary[primary][secondary][i][j].getTypeName());
					choices[choice].m_a=i;
					choices[choice].m_b=j;
					choice++;
				}
			}
			choice++;
			System.out.println(choice + ") go Back");
			choice++;
			System.out.println(choice + ") Exit");
			tempi=Main.verify(choice+1);
			if(tempi>0&&tempi<choice-1)
			{
				returner.m_a=primary;
				returner.m_b=secondary;
				returner.m_c=choices[tempi-1].m_a;
				returner.m_d=choices[tempi-1].m_b;
				travelMonster(primary,secondary,choices[tempi-1].m_a,choices[tempi-1].m_b);
			}
			else if(tempi==choice-1)
			{
				returner.m_a=7;
				return returner;
			}
			else if(tempi==choice)
			{
				returner.m_a=7;
				exit=true;
				return returner;
			}
			choice=0;
		}
		returner.m_a=7;//unnecessary-added to get rid of warnings
		return returner;
	}
	public static Fourple travelMonster(int primary, int secondary, int evolution, int which)
	{
		if(primary==7)
		{
			Fourple x=new Fourple();
			x.m_a=7;
			return x;
		}
		MonsterType selected= bestiary[primary][secondary][evolution][which];//timesaver;
		System.out.println("Name:              " + selected.getTypeName());
		System.out.println("Primary Element:   " + getElementName(selected.getPrimaryElement()));
		System.out.println("Secondary Element: " + getElementName(selected.getSecondaryElement()));
		System.out.println("Derived Element:   " + typeNames[selected.getPrimaryElement()][selected.getSecondaryElement()]);
		System.out.println("Evolution Stage:   " + getStageName(selected.getEvolutionStage()));
		Main.SmartPrint("Description:\n" + selected.getDescription());
		
		System.out.println("num of evolutions is " +selected.getNumOfEvolutions());//debugging
		if(selected.getNumOfEvolutions()==0)
		{
			System.out.println("Evolves Into:        Does not Evolve into anything");
		}
		else if(selected.getNumOfEvolutions()==1)
		{
			System.out.println("Evolves Into:        " + selected.getEvolvesInto1().getTypeName());
		}
		else if(selected.getNumOfEvolutions()==2)
		{
			System.out.println("Physical Evolution:  " + selected.getEvolvesInto1().getTypeName());
			System.out.println("Magical  Evolution:  " + selected.getEvolvesInto2().getTypeName());
		}
		else if(selected.getNumOfEvolutions()==3)
		{
			System.out.println("Physical Evolution:  " + selected.getEvolvesInto1().getTypeName());
			System.out.println("Balanced Evolution:  " + selected.getEvolvesInto2().getTypeName());
			System.out.println("Magical  Evolution:  " + selected.getEvolvesInto3().getTypeName());
		}
		else
		{
			System.out.println("Incorrect value for get NUM of Evolutions");
		}
		
		if(selected.getNumEvolvesFrom()==0)
		{
			System.out.println("Does Not Evolve From anything");
		}
		else if(selected.getNumEvolvesFrom()==1)
		{
			System.out.println("EvolvesFrom: " + selected.getEvolvesFrom1().getTypeName());
		}
		else if(selected.getNumEvolvesFrom()==2)
		{
			System.out.println("Evolves From: " + selected.getEvolvesFrom1().getTypeName());
			System.out.println("and:          " + selected.getEvolvesFrom2().getTypeName());
		}
		else if(selected.getNumEvolvesFrom()==3)
		{
			System.out.println("Evolves From: " + selected.getEvolvesFrom1().getTypeName());
			System.out.println("and:          " + selected.getEvolvesFrom2().getTypeName());
			System.out.println("and           " + selected.getEvolvesFrom3().getTypeName());
		}
		
		exit=false;
		int size=selected.getNumEvolvesFrom()+selected.getNumOfEvolutions();
		Tuple[] indexer = new Tuple[size];
		for(int i=0;i<size;i++)
		{
			indexer[i]=new Tuple();
		}
		while(exit==false)
		{
			choice=0;
			System.out.println("What would you like to look at next?");
			if(selected.getNumEvolvesFrom()>0)			
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesFrom1().getTypeName());
				indexer[choice].m_a=selected.getEvolvesFrom1().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesFrom1().getEvolutionType();
				choice++;
			}
			if(selected.getNumEvolvesFrom()>1)
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesFrom2().getTypeName());
				indexer[choice].m_a=selected.getEvolvesFrom2().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesFrom2().getEvolutionType();
				choice++;
			}
			if(selected.getNumEvolvesFrom()>2)
			{
				System.out.println(choice+1 + ") " + selected.getEvolvesFrom3().getTypeName());
				indexer[choice].m_a=selected.getEvolvesFrom2().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesFrom2().getEvolutionType();
				choice++;
			}
			if(selected.getNumOfEvolutions()>0)
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesInto1().getTypeName());
				indexer[choice].m_a=selected.getEvolvesInto1().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesInto1().getEvolutionType();
				choice++;
			}
			if(selected.getNumOfEvolutions()>1)
			{	
				System.out.println(choice+1 + ") " + selected.getEvolvesInto2().getTypeName());
				indexer[choice].m_a=selected.getEvolvesInto2().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesInto2().getEvolutionType();
				choice++;
			}
			if(selected.getNumOfEvolutions()>2)
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesInto3().getTypeName());
				indexer[choice].m_a=selected.getEvolvesInto3().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesInto3().getEvolutionType();
				choice++;
			}
			System.out.println(choice+1 + ") Go Back");
			choice++;
			System.out.println(choice+1 + ") Exit");
			int decision = Main.verify(size+2);
			Fourple myFourple = new Fourple();
			myFourple.m_a = primary;
			myFourple.m_b = secondary;
			myFourple.m_c=7;
			myFourple.m_d=7;
			if(decision>0&decision<size)
			{
				myFourple.m_c=indexer[decision-1].m_a;
				myFourple.m_d=indexer[decision-1].m_b;
				travelMonster(primary,secondary,indexer[decision-1].m_a,indexer[decision-1].m_b);
				return myFourple;
			}
			else if(decision==choice)
			{
				myFourple.m_a=7;
				return myFourple;				
			}
			else if(decision==choice+1)
			{
				myFourple.m_a=7;
				exit=false;
				return myFourple;
			}
		}
		Fourple ple =new Fourple();
		ple.m_a=7;
		return ple;
	}

	
	
	
	public static void transverseBestiary(MonsterType[][][][] bestiary)
	{
		exit=false;
		String menuOptions="What would you like to do?\n1) Examine Bestiary based on element\n2) Look up a random monster\n3) Look up a monster by 4 digit index\n4) Look up a monster based on linear index";
		while(!exit)
		{
			System.out.println(menuOptions);
			choice=myScanner.nextInt();//TODO:fix this
			//if(choice)
		}
	}
	public static void transverseBestiary0(MonsterType[][][][] bestiary)
	{
		exit=false;
		String mainBestiaryMenuOptions="Choose primary element:\n1) Fire \n2) Water \n3) Earth \n4) Air \n5) Light \n6) Dark\n7) Back\n8) Exit";
		while(!exit)
		{
			System.out.println(mainBestiaryMenuOptions);
			choice=myScanner.nextInt();
			if(choice==1)
			{
				transverseBestiary1(0,bestiary);
			}
			else if(choice==2)
			{
				transverseBestiary1(1,bestiary);
			}
			else if(choice==3)
			{
				transverseBestiary1(2,bestiary);
			}
			else if(choice==4)
			{
				transverseBestiary1(3,bestiary);
			}
			else if(choice==5)
			{
				transverseBestiary1(4,bestiary);
			}
			else if(choice==6)
			{
				transverseBestiary1(5,bestiary);
			}
			else if(choice==7)
			{
//				exit=true;
				return;
			}
			else if(choice==8)
			{
				exit=true;
				return;
			}
			else
			{
				System.out.println(inputError);
			}
		}		
	}
	public static void transverseBestiary1(int primary,MonsterType[][][][] bestiary)
	{
		String[][] typeNames=Bestiary.defineTypes();
		String BestiaryMenuOptions1="Bestiary Secondary Menu, please choose the derived type you want to look at\n1) " + typeNames[primary][0] + "\n2) " + typeNames[primary][1] + "\n3) " + typeNames[primary][2] + "\n4) " + typeNames[primary][3] + 
				"\n5) " + typeNames[primary][4] + "\n6) " + typeNames[primary][5] + "\n7) Back\n8) Exit";
		exit=false;
		while(!exit)
		{
			System.out.println(BestiaryMenuOptions1);
			choice=myScanner.nextInt();
			if(choice==1)
			{
				transverseBestiary2(primary,0,bestiary);
			}
			else if(choice==2)
			{
				transverseBestiary2(primary,1,bestiary);
			}
			else if(choice==3)
			{
				transverseBestiary2(primary,2,bestiary);
			}
			else if(choice==4)
			{
				transverseBestiary2(primary,3,bestiary);
			}
			else if(choice==5)
			{
				transverseBestiary2(primary,4,bestiary);
			}
			else if(choice==6)
			{
				transverseBestiary2(primary,5,bestiary);
			}
			else if(choice==7)
			{
				return;
			}
			else if(choice==8)
			{
				exit=true;
				return;
			}
			else
			{
				System.out.println(inputError);
			}
		}
 	}
	public static void transverseBestiary2(int primary, int secondary, MonsterType[][][][] bestiary)
	{
//		System.out.println("secondary= " + secondary);
		String BestiaryMenuOptions2="Select monster's Age\n1) eggs\n2) infants\n3) adolescents\n4) adults\n5) elders\n6) Back\n7) Exit";
		exit=false;
		while(!exit)
		{
			System.out.println(BestiaryMenuOptions2);
			choice=myScanner.nextInt();
			if(choice==1)
			{
				transverseBestiaryMonsters(primary, secondary, 0,bestiary);
			}
			else if(choice==2)
			{
				transverseBestiaryMonsters(primary, secondary, 1,bestiary);
			}
			else  if(choice==3)
			{
				transverseBestiaryMonsters(primary, secondary, 2,bestiary);
			}
			else if(choice==4)
			{
				transverseBestiaryMonsters(primary, secondary, 3, bestiary);
			}
			else if(choice==5)
			{
				transverseBestiaryMonsters(primary, secondary, 4, bestiary);
			}
			else if(choice==6)
			{
				return;
			}
			else if(choice==7)
			{
				exit=true;
				return;
			}
			else
			{
				System.out.println(inputError);
			}
		}
	}
	public static int[] transverseBestiaryMonsters(int primary, int secondary, int age, MonsterType[][][][] bestiary)//TODO fix this
	{
		int length=bestiary[primary][secondary][age].length;
		exit=false;
		while(!exit)
		{	
			System.out.println("Your potential monster choices are:");
			for(int i=0; i<length; i++)
			{
				System.out.print((i+1) + ")");
				System.out.print(bestiary[primary][secondary][age][i].getTypeName());
				System.out.println();
			}
//			System.out.println("length= " + length);//debugging
			System.out.println(length+1 + ") See All\n" + (length+2) + ") Back\n" + (length+3) + ") Exit");
			choice=myScanner.nextInt();
			if(choice<=length&&choice>0)
			{
				transverseBestiaryMonsterSelected(primary,secondary,age,choice-1,bestiary);
			}
			else if(choice==length+1&&choice>0)
			{
//				transverseBestiaryShowAllMonstersInTree(primary,secondary,choice-1,bestiary);
			}
			else if(choice==length+2&&choice>0)
			{
				int[] array=new int[5];
				array[0]=0;
				array[1]=0;
				array[2]=0;
				array[3]=0;
				array[4]=0;
				return array;
			}
			else if(choice==length+3&&choice>0)
			{
				exit=true;
			}
			else
			{
				System.out.println(inputError);
			}
		}
		int[] array={1};
		return array;
	}
	public static void transverseBestiaryShowAllMonstersInTree(int primary, int secondary, MonsterType[][][][] bestiary, int count)
	{
		exit=false;
		while(!exit)
		{	
			if(count==1)
			{
				System.out.println("Please Select a monster to look at");
			}
			for(int i=0;i<bestiary[primary][secondary][0].length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary][0][i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary][1].length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary][1][i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary][2].length;i++)
			{	
				System.out.println(count + ") " + bestiary[primary][secondary][2][i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary][3].length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary][3][i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary][4].length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary][4][i].getTypeName());
				count++;
			}
			System.out.println(count+1 +") back" + count+2 + ") Exit");
			choice=myScanner.nextInt();
			if(choice<=bestiary[primary][secondary][0].length)
			{
				//TODO finish
			}
		}
	}
	public static void transverseBestiaryMonsterSelected(int primary, int secondary, int age, int selectedMonster, MonsterType[][][][] bestiary)
	{		
		String[][] typeNames=Bestiary.defineTypes();
		MonsterType selectedMonsterType=bestiary[primary][secondary][age][selectedMonster];//selects the monster from the bestiary based on the given information
		
		System.out.println("Monster Type:      " + selectedMonsterType.getTypeName());
		System.out.println("Primary Element:   " + getElementName(primary));
		System.out.println("Secondary Element: " + getElementName(secondary));
		System.out.println("Derived Element:   " + typeNames[primary][secondary]);
		System.out.println("num of evolutions is " +selectedMonsterType.getNumOfEvolutions());//debugging
		if(selectedMonsterType.getNumOfEvolutions()==0)
		{
			System.out.println("Evolves Into: Does not Evolve into anything");
		}
		else if(selectedMonsterType.getNumOfEvolutions()==1)
		{
			System.out.println("Evolves Into:" + selectedMonsterType.getEvolvesInto1().getTypeName());
		}
		else if(selectedMonsterType.getNumOfEvolutions()==2)
		{
			System.out.println("Physical Evolution: " + selectedMonsterType.getEvolvesInto1().getTypeName());
			System.out.println("Magical  Evolution:  " + selectedMonsterType.getEvolvesInto2().getTypeName());
		}
		else if(selectedMonsterType.getNumOfEvolutions()==3)
		{
			System.out.println("Physical Evolution: " + selectedMonsterType.getEvolvesInto1().getTypeName());
			System.out.println("Balanced Evolution: " + selectedMonsterType.getEvolvesInto2().getTypeName());
			System.out.println("Magical  Evolution: " + selectedMonsterType.getEvolvesInto3().getTypeName());
		}
		else
		{
			System.out.println("Incorrect value for get NUM of Evolutions");
		}
		if(selectedMonsterType.getNumEvolvesFrom()==0)
		{
			System.out.println("Does Not Evolve From anything");
		}
		Main.SmartPrint("Description: " + selectedMonsterType.getDescription());
		System.out.println();
		
		exit=false;
		while(!exit)
		{
			System.out.println("Please select what you would like to do next: ");
			System.out.println("1) Go back");
			if(selectedMonsterType.getNumOfEvolutions()==1)
			{
				System.out.println("2) Go to " + selectedMonsterType.getEvolvesInto1().getTypeName());
			}
			else if(selectedMonsterType.getNumOfEvolutions()==2)
			{
				System.out.println("2) Go to " + selectedMonsterType.getEvolvesInto1().getTypeName());
				System.out.println("3) Go to " + selectedMonsterType.getEvolvesInto2().getTypeName());
			}
			else if(selectedMonsterType.getNumOfEvolutions()==3)
			{
				System.out.println("2) Go to " + selectedMonsterType.getEvolvesInto1().getTypeName());
				System.out.println("3) Go to " + selectedMonsterType.getEvolvesInto2().getTypeName());
				System.out.println("4) Go to " + selectedMonsterType.getEvolvesInto3().getTypeName());
			}
			else
			{
				System.out.println("Incorrect value for getNumOfEvolutions, recorded value is : " + selectedMonsterType.getNumOfEvolutions());
			}
			choice=myScanner.nextInt();
			if(choice==1)
			{
				exit=true;
				return;
			}
			else if(choice==2&&selectedMonsterType.getNumOfEvolutions()>0)
			{
				//TODO finish
			}
			else if(choice==3&&selectedMonsterType.getNumOfEvolutions()>1)
			{
				//TODO finish
			}
			else if(choice==4&&selectedMonsterType.getNumOfEvolutions()==3)
			{
				//TODO finish
			}
		}
	}
	public static String getElementName(int element)
	{
		if(element==0)
		{
			return("Fire");
		}
		else if(element==1)
		{
			return("Water");
		}
		else if(element==2)
		{
			return("Earth");
		}
		else if(element==3)
		{
			return("Air");
		}
		else if(element==4)
		{
			return("Light");
		}
		else if(element==5)
		{
			return("Dark");
		}
		else 
		{
			return("Error: Invalid Argument");
		}
	}
	public static String getStageName(int stage)
	{
		if(stage==0)
		{
			return("Egg");
		}
		else if(stage==1)
		{
			return("Infant");
		}
		else if(stage==2)
		{
			return("Adolescent");
		}
		else if(stage==3)
		{
			return("Adult");
		}
		else if(stage==4)
		{
			return("Elder");
		}
		else
		{
			return("Error: invalid Argument");
		}
	}
	public static void run()
	{
		travel();
	}
}
