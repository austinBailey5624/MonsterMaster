/***
 * 		@filename:		main.java
 * 		@author:		Austin Bailey
 * 		@dateBegun:		12/6/2015
 **/
package ver0;
import java.util.*;
import java.io.*;
public class Main 
{
	static int tempi;//temporary int
	static String temps;//temporary String
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
//		int choice = myScanner.nextInt();
		
		
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
	public static void main(String[] args)
	{
//		String[][] typeNames=Bestiary.defineTypes();
		exit=false;
		String mainMenuOptions="Main menu\n1) Count Monsters\n2) Transverse Bestiary\n3) Test gridWalk\n4) Exit";
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
				//transverseBestiary(bestiary);
				Bestiary.run();
			}
			else if(choice==3)
			{
				testElementGridWalk();
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

	public static void testElementGridWalk()
	{
		exit=false;
		while(!exit)
		{
			System.out.println("1) Print regular\n2) Print Agile\n3) Exit");
			temps=myScanner.next();
			if(verifyInt(temps))//this block verifies that the given information is valid
			{
				choice=Integer.parseInt(temps);
			}
			else
			{
				choice=0;
			}
			if(choice==1)
			{
				GridWalkStaticDisplay();
			}
			else if(choice==2)
			{
				GridWalkAgileDisplay();
			}
			else if(choice==3)
			{
				return;
			}
			else
			{
				System.out.println("Sorry, we didn't understand your input");
			}
		}
	}
	public static void GridWalkStaticDisplay()
	{
		Place myPlace;
		exit=false;
		while(!exit)
		{
			System.out.println("Which place would you like to visit?\n1)Maxe\n2)Square"
					+ "\n3)inequalSides\n4)Exit");
			String input = myScanner.next();
			if(input.equals("1"))
			{
				myPlace = new Place(0,0);
				int exitnum=1;
				while(exitnum!=0)
				{
					exitnum=myPlace.transverse(false);
					if(exitnum==1)					{
						myPlace = new Place(2,1);
					}
					else if(exitnum==2)
					{
						myPlace = new Place(0,1);
					}
					else if(exitnum==3)
					{
						myPlace = new Place(1,1);
					}
					else if(exitnum==4)
					{
						myPlace= new Place(2,2);
					}
				}
			}
			else if(input.equals("2"))
			{
				myPlace=new Place(0,1);
				myPlace.transverse(true);
			}
			else if(input.equals("3"))
			{
				myPlace=new Place(2,1);
				myPlace.transverse(true);
			}
			else if(input.equals("4"))
			{
				return;
			}
			else
			{
				System.out.println("Sorry we didn't understand your input");
			}
		}
	}
	public static void GridWalkAgileDisplay()
	{
		Place myPlace= new Place(0,0);
		int exitnum=1;
		while(exitnum!=0)
		{
			exitnum=myPlace.transverse(true);
			if(exitnum==1)
			{
				myPlace = new Place(2,1);
			}
			else if(exitnum==2)
			{
				myPlace = new Place(0,1);
			}
			else if(exitnum==3)
			{
				myPlace = new Place(1,1);
			}
			else if(exitnum==4)
			{
				myPlace= new Place(2,2);
			}
		}
	}
	/**
	 * @author Tim Elvart
	 * @param s
	 * @pre instance of Battle exists
	 * @post none
	 * @return True if s is an int, otherwise false
	 */
	public static boolean verifyInt(String s)
	{
		try
		{
			int x=Integer.parseInt(s);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}
}