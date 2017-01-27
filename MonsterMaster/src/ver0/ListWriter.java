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
	//this method has been hijacked to help with the JayhawkZombie version of MonsterMaster
	public static void writeBestiary()
	{
		MonsterType[] myArray = Bestiary.bestiary1d;
		try
		{
			BufferedWriter myWriter = new BufferedWriter( new FileWriter("SFEngeineBestiary2.txt"));
			myWriter.write(String.valueOf(myArray.length));
			myWriter.newLine();
			for(int i=35; i<myArray.length; i++)
			{
				//handles the bestiary information for the monster itself
				myWriter.write(myArray[i].getTypeName());
				myWriter.newLine();
				myWriter.write(myArray[i].getDescription());
				myWriter.newLine();
				myWriter.write(String.valueOf(myArray[i].getPrimaryElement()));
				myWriter.newLine();
				myWriter.write(String.valueOf(myArray[i].getSecondaryElement()));
				myWriter.newLine();
				myWriter.write(String.valueOf(myArray[i].getEvolutionStage()));
				myWriter.newLine();
				myWriter.write(String.valueOf(myArray[i].getEvolutionType()));
				//4
				myWriter.newLine();
				//handles the texture assignment
				if(myArray[i].getPrimaryElement()==0 && myArray[i].getSecondaryElement()==3)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/LesserPhoenix12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==0 && myArray[i].getSecondaryElement()==4)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Angier12FSpriteSheet.png");	
				}
				else if(myArray[i].getPrimaryElement()==0 && myArray[i].getSecondaryElement()==5)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Spiten12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==1 && myArray[i].getSecondaryElement()==0)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/MinorSteamlet12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==1 && myArray[i].getSecondaryElement()==1)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Minnow12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==1 && myArray[i].getSecondaryElement()==2)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Tapple12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==1 && myArray[i].getSecondaryElement()==3)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Cirrus12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==1 && myArray[i].getSecondaryElement()==4)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Snoball12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==1 && myArray[i].getSecondaryElement()==5)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Deepfish12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==2 && myArray[i].getSecondaryElement()==0)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Sprite12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==2 && myArray[i].getSecondaryElement()==1)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Boggart12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==2 && myArray[i].getSecondaryElement()==2)
				{
					if(myArray[i].getEvolutionType()==0 && myArray[i].getEvolutionStage()>1)
					{
						myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Babadger12FSpriteSheet.png");
					}
					else if(myArray[i].getEvolutionType()>1 && myArray[i].getEvolutionStage()>1)
					{
						myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Sticket12FSpriteSheet.png");
					}
					else
					{
						myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Bulbapup12FSpriteSheet.png");
					}
				}
				else if(myArray[i].getPrimaryElement()==2 && myArray[i].getSecondaryElement()==3)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/MinorPegasus12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==2 && myArray[i].getSecondaryElement()==4)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Buddi12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==2 && myArray[i].getSecondaryElement()==5)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/SeweRat12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==3 && myArray[i].getSecondaryElement()==0)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Kangarat12FSpriteSheet.png");
				}
				else if(myArray[i].getPrimaryElement()==3 && myArray[i].getSecondaryElement()==1)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Gullfish.png");
				}
				else if(myArray[i].getPrimaryElement()==3 && myArray[i].getSecondaryElement()==2)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Colour.png");
				}
				else if(myArray[i].getPrimaryElement()==3 && myArray[i].getSecondaryElement()==3)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Flapper.png");
				}
				else if(myArray[i].getPrimaryElement()==3 && myArray[i].getSecondaryElement()==4)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/CockaOne.png");
				}
				else if(myArray[i].getPrimaryElement()==3 && myArray[i].getSecondaryElement()==5)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/FourShadoWing.png");
				}
				else if(myArray[i].getPrimaryElement()==4 && myArray[i].getSecondaryElement()==0)
				{
					if(myArray[i].getEvolutionType()==1)
					{
						myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/FireFaux.png");
					}
					else
					{
						myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Tona.png");
					}
				}
				else if(myArray[i].getPrimaryElement()==4 && myArray[i].getSecondaryElement()==1)
				{
					if(myArray[i].getEvolutionType()==0 && myArray[i].getEvolutionStage()>1)
					{
						myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Lunapup.png");
					}
					else
					{
						myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Lona.png");
					}
				}
				else if(myArray[i].getPrimaryElement()==4 && myArray[i].getSecondaryElement()==2)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Escutcheoner.png");
				}
				else if(myArray[i].getPrimaryElement()==4 && myArray[i].getSecondaryElement()==3)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/DemiAngel.png");
				}
				else if(myArray[i].getPrimaryElement()==4 && myArray[i].getSecondaryElement()==4)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Lumin.png");
				}
				else if(myArray[i].getPrimaryElement()==4 && myArray[i].getSecondaryElement()==5)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Guilt.png");
				}
				else if(myArray[i].getPrimaryElement()==5 && myArray[i].getSecondaryElement()==0)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Fiend.png");
				}
				else if(myArray[i].getPrimaryElement()==5 && myArray[i].getSecondaryElement()==1)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Stinger.png");
				}
				else if(myArray[i].getPrimaryElement()==5 && myArray[i].getSecondaryElement()==2)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Stull.png");
				}
				else if(myArray[i].getPrimaryElement()==5 && myArray[i].getSecondaryElement()==3)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Maltag.png");
				}
				else if(myArray[i].getPrimaryElement()==5 && myArray[i].getSecondaryElement()==4)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/FallenDemiAngel.png");
				}
				else if(myArray[i].getPrimaryElement()==5 && myArray[i].getSecondaryElement()==5)
				{
					myWriter.write("SFEngine/Samples/Animations/CharacterAnimations/Umbress.png");
				}
				myWriter.newLine();
				
				//handles the evolvesInto Assignment
				if(myArray[i].getEvolvesInto1()==null)
				{
					myWriter.write("NULL");
				}
				else
				{
					myWriter.write(myArray[i].getEvolvesInto1().getTypeName());
				}
				myWriter.newLine();
				
				if(myArray[i].getEvolvesInto2()==null)
				{
					myWriter.write("NULL");
				}
				else 
				{
					myWriter.write(myArray[i].getEvolvesInto2().getTypeName());
				}
				myWriter.newLine();
				
				if(myArray[i].getEvolvesInto3()==null)
				{
					myWriter.write("NULL");
				}
				else
				{
					myWriter.write(myArray[i].getEvolvesInto3().getTypeName());
				}
				//Clears a final line
				myWriter.newLine();
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
