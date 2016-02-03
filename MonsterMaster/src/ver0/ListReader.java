package ver0;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListReader 
{
	static BufferedReader reader;
	
	public static String[] readPlot()
	{
		String[] plot;
		plot=new String[1];//these two lines should be overwritten - this is just what will be passed if the exception happens
		plot[0]="Plot could not be read";
		try
		{
			reader = new BufferedReader(new FileReader("plot.list"));
			int size = Integer.parseInt(reader.readLine());
			plot = new String[size];
			for(int i=0; i<size; i++)
			{
				plot[i]=reader.readLine();
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("did you delete plot.list? We need that file for the program");

		}
		return plot;
	}
	public static void testPlot()
	{
		try
		{
			reader = new BufferedReader( new FileReader("plot.list"));
			String s =reader.readLine();
			System.out.println(s);
		}
		catch(Exception e)
		{
			System.out.println("File does not exist");
		}
		
	}
	public static String[] getNames()
	{
		String[] names;
		names = new String[0];//This line should be overwritten, the empty array is what will be returned in the exception case
		try
		{
			reader = new BufferedReader(new FileReader("bestiaryNames.txt"));
			int size = Integer.parseInt(reader.readLine());
			names = new String[size];
			for(int i=0;i<size;i++)
			{
				names[i]=reader.readLine();
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("File does not exist");
		}
		return names;
	}
	public static String[] getDescriptions()
	{
		String[] descriptions;
		descriptions = new String[0];
		try
		{
			reader = new BufferedReader(new FileReader("bestiaryDescriptions.txt"));
			int size = Integer.parseInt(reader.readLine());//picks up the first line which should be the size of the array
			descriptions = new String[size];
			for(int i=0;i<size;i++)
			{
				descriptions[i]=reader.readLine();
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("cannot detect bestiaryDescriptions.txt");
		}
		return descriptions;
	}
}
