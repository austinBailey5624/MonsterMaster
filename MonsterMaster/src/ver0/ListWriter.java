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
}
