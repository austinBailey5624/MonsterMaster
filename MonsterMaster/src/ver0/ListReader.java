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
}
