/*
 * 	@file:		ListWriter.java
 * 	@author:	Austin Bailey
 * 	@date:		9.7.2016
 * 	@purpose: 	Store Hard-Coded strings into a file so code becomes dynamic
 */
package ver0;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class ListWriter 
{
	static int choice;
	public static void menu()
	{
		boolean exit=false;
		while(!exit)
		{
			System.out.println("Which List would you like to write?");
			System.out.println("1) Name List\n2) Description List\n3) Evolves Into 1 List\n4) Evolves Into 2 List\n5) Evolves Into 3 list\n6) Evolves From 1\n7) Evolves From 2\n8) Evolves From 3\n9) Combined List\n10) Return");	
			choice =Main.verify(10);
			if(choice==1)
			{
				writeNameList();
			}
			else if(choice==2)
			{
				writeDescriptionList();
			}
			else if(choice==3)
			{
				writeEvolvesInto1List();
			}
			else if(choice==4)
			{
				writeEvolvesInto2List();
			}
			else if(choice==5)
			{
//				System.out.println("Not implemented yet");
				writeEvolvesInto3List();
			}
			else if(choice==6)
			{
//				System.out.println("Not implemented yet");
				writeEvolvesFrom1List();
			}
			else if(choice==7)
			{
//				System.out.println("Not implemented yet");
				writeEvolvesFrom2List();
			}
			else if(choice==8)
			{
//				System.out.println("Not implemented yet");
				writeEvolvesFrom3List();
			}
			else if(choice==9)
			{
				writeBestiary();
			}
			else if(choice==10)
			{
				return;
			}
		}
	}
	public static void writeNameList()
	{
		MonsterType[] myArray=Bestiary.bestiary1d;
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("bestiaryNames.txt"));
			myWriter.write(String.valueOf(myArray.length));
			myWriter.newLine();
			for(int i=0;i<myArray.length;i++)
			{
				myWriter.write(myArray[i].getTypeName());
				myWriter.newLine();
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer didn't work!");
		}
		
	}
	public static void writeDescriptionList()
	{
		MonsterType[] myArray = Bestiary.bestiary1d;
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("bestiaryDescriptions.txt"));
			myWriter.write(String.valueOf(myArray.length));
			myWriter.newLine();
			for(int i=0;i<myArray.length;i++)
			{
				myWriter.write(myArray[i].getDescription());
				myWriter.newLine();
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer: writeDescriptionList() didn't work!");
		}
	}
	public static void writeEvolvesInto1List()
	{
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("BestiaryEvolvesInto1List.txt"));
			int count =0;
			//This loop is going to tell us how many pairs are coming-that we write to the top of the file
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesInto1()!=null)
				{
					count++;
				}
			}
			myWriter.write(String.valueOf(count));
			myWriter.newLine();
			//This loop actually writes the data
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesInto1()!=null)
				{
					//The first four lines write the information of the Monster that is being evolved from
					myWriter.write(Bestiary.bestiary1d[i].getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionType() + "  ");
					//the second four lines writer the information of the monster that is being evolved to
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto1().getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto1().getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto1().getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto1().getEvolutionType() + " ");
					myWriter.newLine();
				}
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer: writeEvolvesInto1List() didn't work!");
		}
	}	
	public static void writeEvolvesInto2List()
	{
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("BestiaryEvolvesInto2List.txt"));
			int count =0;
			//This loop is going to tell us how many pairs are coming-that we write to the top of the file
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesInto2()!=null)
				{
					count++;
				}
			}
			myWriter.write(String.valueOf(count));
			myWriter.newLine();
			//This loop actually writes the data
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesInto2()!=null)
				{
					//The first four lines write the information of the Monster that is being evolved from
					myWriter.write(Bestiary.bestiary1d[i].getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionType() + "  ");
					//the second four lines writer the information of the monster that is being evolved to
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto2().getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto2().getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto2().getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto2().getEvolutionType() + " ");
					myWriter.newLine();
				}
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer: writeEvolvesInto2List() didn't work!");
		}
	}
	public static void writeEvolvesInto3List()
	{
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("BestiaryEvolvesInto3List.txt"));
			int count =0;
			//This loop is going to tell us how many pairs are coming-that we write to the top of the file
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesInto3()!=null)
				{
					count++;
				}
			}
			myWriter.write(String.valueOf(count));
			myWriter.newLine();
			//This loop actually writes the data
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesInto3()!=null)
				{
					//The first four lines write the information of the Monster that is being evolved from
					myWriter.write(Bestiary.bestiary1d[i].getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionType() + "  ");
					//the second four lines writer the information of the monster that is being evolved to
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto3().getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto3().getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto3().getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesInto3().getEvolutionType() + " ");
					myWriter.newLine();
				}
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer: writeEvolvesInto3List() didn't work!");
		}
	}
	public static void writeEvolvesFrom1List()
	{
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("BestiaryEvolvesFrom1List.txt"));
			int count =0;
			//This loop is going to tell us how many pairs are coming-that we write to the top of the file
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesFrom1()!=null)
				{
					count++;
				}
			}
			myWriter.write(String.valueOf(count));
			myWriter.newLine();
			//This loop actually writes the data
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesFrom1()!=null)
				{
					//The first four lines write the information of the Monster that is being evolved from
					myWriter.write(Bestiary.bestiary1d[i].getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionType() + "  ");
					//the second four lines writer the information of the monster that is being evolved to
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom1().getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom1().getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom1().getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom1().getEvolutionType() + " ");
					myWriter.newLine();
				}
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer: writeEvolvesFrom1List() didn't work!");
		}
	}	
	public static void writeEvolvesFrom2List()
	{
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("BestiaryEvolvesFrom2List.txt"));
			int count =0;
			//This loop is going to tell us how many pairs are coming-that we write to the top of the file
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesFrom2()!=null)
				{
					count++;
				}
			}
			myWriter.write(String.valueOf(count));
			myWriter.newLine();
			//This loop actually writes the data
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesFrom2()!=null)
				{
					//The first four lines write the information of the Monster that is being evolved from
					myWriter.write(Bestiary.bestiary1d[i].getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionType() + "  ");
					//the second four lines writer the information of the monster that is being evolved to
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom2().getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom2().getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom2().getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom2().getEvolutionType() + " ");
					myWriter.newLine();
				}
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer: writeEvolvesFrom2List() didn't work!");
		}
	}
	public static void writeEvolvesFrom3List()
	{
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("BestiaryEvolvesFrom3List.txt"));
			int count =0;
			//This loop is going to tell us how many pairs are coming-that we write to the top of the file
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesFrom3()!=null)
				{
					count++;
				}
			}
			myWriter.write(String.valueOf(count));
			myWriter.newLine();
			//This loop actually writes the data
			for(int i=0;i<Bestiary.bestiary1d.length;i++)
			{
				if(Bestiary.bestiary1d[i].getEvolvesFrom3()!=null)
				{
					//The first four lines write the information of the Monster that is being evolved from
					myWriter.write(Bestiary.bestiary1d[i].getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolutionType() + "  ");
					//the second four lines writer the information of the monster that is being evolved to
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom3().getPrimaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom3().getSecondaryElement() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom3().getEvolutionStage() + " ");
					myWriter.write(Bestiary.bestiary1d[i].getEvolvesFrom3().getEvolutionType() + " ");
					myWriter.newLine();
				}
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Buffered Writer: writeEvolvesFrom3List() didn't work!");
		}
		
	}
	public static void writeBestiary()
	{
		MonsterType[] myArray = Bestiary.bestiary1d;
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("bestiary.txt"));
			myWriter.write(String.valueOf(myArray.length));
			myWriter.newLine();
			for(int i=0; i<myArray.length; i++)
			{
				myWriter.write(String.valueOf(myArray[i].getPrimaryElement()));
				myWriter.newLine();
				myWriter.write(String.valueOf(myArray[i].getSecondaryElement()));
				myWriter.newLine();
				myWriter.write(String.valueOf(myArray[i].getEvolutionStage()));
				myWriter.newLine();
				myWriter.write(String.valueOf(myArray[i].getEvolutionType()));
				myWriter.newLine();
				myWriter.write(myArray[i].getTypeName());
				myWriter.newLine();
				myWriter.write(myArray[i].getDescription());
				myWriter.newLine();
			}
			myWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("BufferedWriter didnt' work1");
		}
		
	}

}
