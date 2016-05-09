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
	static String inputError="Sorry we didn't understand your input, please only enter one of the numbers provided";
	static int choice;
	static FileInputStream fileIn=null;
	static FileOutputStream fileOut=null;
	static Scanner myScanner= new Scanner(System.in);
	static boolean exit;
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
	public static void printTypes()
	{
		String[][] typeNames=Bestiary.defineTypes();
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
		String[][] typeNames=Bestiary.defineTypes();
		exit=false;
		String mainMenuOptions="Main menu\n1) Count Monsters\n2) Transverse Bestiary\n3) Test gridWalk\n4) Exit";
		MonsterTree[][] bestiary=Bestiary.generateBestiary();
		while(!exit)
		{
			System.out.println(mainMenuOptions);
			choice=myScanner.nextInt();
			if(choice==1)
			{
				System.out.println("There are " + MonsterType.monsterTypeNum + " Monster types with definitions so far");
			}
			else if(choice==2)
			{
				transverseBestiary(bestiary);
			}
			else if(choice==3)
			{
				
			}
			else if(choice==4)
			{
				return;
			}
			else
			{
				System.out.println("Sorry we didn't understand your input, please enter a number");
			}
		}
	}
	public static void transverseBestiary(MonsterTree[][] bestiary)
	{
		exit=false;
		String mainBestiaryMenuOptions="Bestiry main menu, choose primary element:\n1) Fire \n2) Water \n3) Earth \n4) Air \n5) Light \n6) Dark\n7) Back\n8) Exit";
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
	public static void transverseBestiary1(int primary,MonsterTree[][] bestiary)
	{
		String[][] typeNames=Bestiary.defineTypes();
//		System.out.println("primary is : "+ primary);//debugging
//		System.out.println("typeNames[0][0]= " + typeNames[0][0]);//debugging
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
	public static void transverseBestiary2(int primary, int secondary, MonsterTree[][] bestiary)
	{
		System.out.println("secondary= " + secondary);
		String BestiaryMenuOptions2="Select monster's grade\n1) eggs\n2) infants\n3) adolescents\n4) adults\n5) elders\n6) Back\n7) Exit";
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
	public static void transverseBestiaryMonsters(int primary, int secondary, int age, MonsterTree[][] bestiary)
	{
		int length=0;
		if(age==0)
		{
			length = bestiary[primary][secondary].m_eggs.length;			
		}
		else if(age==1)
		{
			length = bestiary[primary][secondary].m_infants.length;
		}
		else if(age==2)
		{
			length = bestiary[primary][secondary].m_adolescents.length;
		}
		else if(age==3)
		{
			length = bestiary[primary][secondary].m_adults.length;
		}
		else if(age==4)
		{
			length = bestiary[primary][secondary].m_elders.length;
		}
		else
		{
			length=0;
			System.out.println("ERROR int controlling age is outside of bounds");
		}
		exit=false;
		while(!exit)
		{	
			System.out.println("Your potential monster choices are:");
			for(int i=0; i<length; i++)
			{
				System.out.print((i+1) + ")");
				
				if(age==0)
				{
					System.out.print(bestiary[primary][secondary].m_eggs[i].getTypeName());					
				}
				else if(age==1)
				{
					System.out.print(bestiary[primary][secondary].m_infants[i].getTypeName());
				}
				else if(age==2)
				{
					System.out.print(bestiary[primary][secondary].m_adolescents[i].getTypeName());
				}
				else if(age==3)
				{
					System.out.print(bestiary[primary][secondary].m_adults[i].getTypeName());
				}
				else if(age==4)
				{
					System.out.print(bestiary[primary][secondary].m_elders[i].getTypeName());
				}
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
				return;
			}
			else if(choice==length+3&&choice>0)
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
	public static void transverseBestiaryShowAllMonstersInTree(int primary, int secondary, MonsterTree[][] bestiary, int count)
	{
		exit=false;
		while(!exit)
		{	
			if(count==1)
			{
				System.out.println("Please Select a monster to look at");
			}
			for(int i=0;i<bestiary[primary][secondary].m_eggs.length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary].m_eggs[i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary].m_infants.length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary].m_infants[i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary].m_adolescents.length;i++)
			{	
				System.out.println(count + ") " + bestiary[primary][secondary].m_adolescents[i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary].m_adults.length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary].m_adults[i].getTypeName());
				count++;
			}
			for(int i=0;i<bestiary[primary][secondary].m_elders.length;i++)
			{
				System.out.println(count + ") " + bestiary[primary][secondary].m_adults[i].getTypeName());
				count++;
			}
			System.out.println(count+1 +") back" + count+2 + ") Exit");
			choice=myScanner.nextInt();
			if(choice<=bestiary[primary][secondary].m_eggs.length)
			{
				
			}
		}
	}
	public static void transverseBestiaryMonsterSelected(int primary, int secondary, int age, int selectedMonster, MonsterTree[][] bestiary)
	{		
		String[][] typeNames=Bestiary.defineTypes();
		MonsterType selectedMonsterType;//selects the monster from the bestiary based on the given information
		if(age==0)
		{
			selectedMonsterType=bestiary[primary][secondary].m_eggs[selectedMonster];			
		}
		else if(age==1)
		{
			selectedMonsterType=bestiary[primary][secondary].m_infants[selectedMonster];
		}
		else if(age==2)
		{
			selectedMonsterType=bestiary[primary][secondary].m_adolescents[selectedMonster];
		}
		else if(age==3)
		{
			selectedMonsterType=bestiary[primary][secondary].m_adults[selectedMonster];
		}
		else if(age==4)
		{
			selectedMonsterType=bestiary[primary][secondary].m_elders[selectedMonster];
		}
		else
		{
			System.out.println("ERRROR incorrect value for age, recorded value is: " + age);
			return;
		}

		
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
		System.out.println("Description: " + selectedMonsterType.getDescription());
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
}