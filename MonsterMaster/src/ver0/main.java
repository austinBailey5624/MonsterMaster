/***
 * 		@filename:		main.java
 * 		@author:		Austin Bailey
 * 		@dateBegun:		12/6/2015
 **/
package ver0;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Random;
//import java.io.*;
public class Main 
{
	static Random r;
	static int tempi;//temporary int
	static String temps;//temporary String
	static String inputError="Sorry we didn't understand your input, please only enter one of the numbers provided";
	static int choice;
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
		exit=false;
		String mainMenuOptions="Main menu\n1) Count Monsters\n2) Transverse Bestiary\n3) Test gridWalk\n4) Access ListWriter\n5) Exit";
		while(!exit)
		{
			System.out.println(mainMenuOptions);
			choice=myScanner.nextInt();
			if(choice==1)
			{
				System.out.println("There are " + MonsterType.howMany() + " Monster types with definitions so far");
			}
			else if(choice==2)
			{
				Bestiary.run();
			}
			else if(choice==3)
			{
				testElementGridWalk();
			}
			else if(choice==4)
			{
				ListWriter.menu();
			}
//			else if(choice==4)
//			{
//				String[] plot = ListReader.readPlot();
//				for(int i=0; i<plot.length;i++)
//				{
//					System.out.println(plot[i]);
//				}
//			}
//			else if(choice==5)
//			{
//				ListWriter.writeDescriptionList();
//			}
			else if(choice==5)
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
			choice=verify(3);
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
		int temp;
		exit=false;
		while(!exit)
		{
			System.out.println("Which place would you like to visit?\n1)Maxe\n2)Square"
					+ "\n3)inequalSides\n4)Exit");
			temp=verify(4);
			if(temp==1)
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
			else if(temp==2)
			{
				myPlace=new Place(0,1);
				myPlace.transverse(true);
			}
			else if(temp==3)
			{
				myPlace=new Place(2,1);
				myPlace.transverse(true);
			}
			else if(temp==4)
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
			if(x==0)
			{
				
			}
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}
	public static void SmartPrint(String s)
	{
		int stop=s.length();
		for(int i=0; i<stop;)
		{
			for(int j=0; j<56&&i<stop;j++)
			{
				System.out.print(s.charAt(i));
				i++;
			}
			System.out.println();
		}
		
	}
	public static int verify(int answerCeiling)//the answerCeiling refers to the larges acceptable integer that will be accepted//when you call this it needs to be in a while loop
	{
		String num=myScanner.next();
		try
		{
			int choice=Integer.parseInt(num);//tries to parse the string as an integer, if it fails, the catch clause is triggered, which returns a 0 for bad value
			if(choice<1||choice>answerCeiling)
			{
				System.out.println("Please enter a number between 1 and " + answerCeiling);
				return 0;
			}
			else
			{
				return choice;
			}
		}
		catch(Exception e)
		{
			System.out.println("Please only input the numbers cooresponding to the choices");
			return 0;//stands for error
		}
	}
	/**
	 * @author: Tim Elvart
	 * @param min
	 * @param max
	 * @pre instance of Battle exists
	 * @post none
	 * @return Int that has value inclusively between min and max
	 */
	public static int randomNumber(int min, int max)
	{
		Calendar c = Calendar.getInstance();
		
		r=new Random(c.getTimeInMillis());//used time to generate 'random' number
		return r.nextInt(max-min+1)+min;
	}
}