package ver0;
/**
 * @file	Place.java
 * @author 	Austin Bailey
 * @dateBegun:	5/8/2016
 * @lastUpdate:	5/9/2016
 */
import java.util.Scanner;
public class Place 
{
	//Static member variables
	static Scanner myScanner= new Scanner(System.in);
	
	//member variables
	String m_name;
	int maxDimensionX;
	int maxDimensionY;
	int startLocX;
	int startLocY;
	int curLocX;
	int curLocY;
	int prevLocX;
	int prevLocY;
	Terrain[][] content;
	
	
	//constructors
	public Place(int which,int exit)
	{
		Terrain p = new Terrain(0);
		Terrain w = new Terrain(1);
		Terrain x = new Terrain(0,1);
		Terrain y = new Terrain(0,2);
		Terrain z = new Terrain(0,3);
		Terrain v = new Terrain(0,4);
		if(which==0)
		{
			m_name="EasyMaze";
			if(exit==0)
			{
			curLocX=0;
			curLocY=0;
			prevLocX=0;
			prevLocY=0;
			}
			else if(exit==1)
			{
				curLocX=5;
				curLocY=6;
				prevLocX=6;
				prevLocY=6;
			}
			content=new Terrain[][]
			{
				{p,w,w,w,w,w,w},
				{p,w,p,p,p,p,p},
				{p,w,p,w,w,w,p},
				{p,w,p,p,p,w,p},
				{p,p,w,w,p,w,p},
				{w,p,p,p,p,w,p},
				{w,w,w,w,w,w,x}
			};
			maxDimensionX=6;
			maxDimensionY=6;
		}
		if(which==1)
		{
			m_name="box";
			content=new Terrain[][]
			{
				{w,w,w,v,w,w,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,w,w,w,w,w,w}
			};
			maxDimensionX=6;//decremented by 1 since count starts at 0
			maxDimensionY=6;
			if(exit==1)
			{
				curLocX=1;
				curLocY=3;
				prevLocX=3;
				prevLocY=0;
			}
		}
		if(which==2)//horizontal bridge
		{
			m_name="hallway";
			content=new Terrain[][]
			{
				{w,y,w},
				{w,p,w},
				{w,p,w},
				{w,p,w},
				{w,p,w},
				{w,p,w},
				{w,z,w}
			};
			maxDimensionX=6;//values decremented by one since count starts at 0
			maxDimensionY=2;
			if(exit==1)
			{
				curLocX=1;
				curLocY=1;
				prevLocX=0;
				prevLocY=1;
			}
			else if(exit==2)
			{
				curLocX=5;
				curLocY=1;
				prevLocX=6;
				prevLocY=1;
			}
		}
	}
	
	//methods
	public int transverse(boolean agile)
	{
		//code moving character here
		boolean exit=false;
		String input;
		while(!exit)
		{
			if(content[curLocX][curLocY].m_show=='E')
			{
				return(content[curLocX][curLocY].m_exitNumber);
			}
			if(agile)
			{
				printAgile(3);
			}
			else
			{
				printPlace();
			}
			printChoices();
			input=myScanner.next();
			if(input.equals("w"))
			{
				tryMove(1);
			}
			else if(input.equals("a"))
			{
				tryMove(2);
			}
			else if(input.equals("s"))
			{
				tryMove(3);
			}
			else if(input.equals("d"))
			{
				tryMove(4);
			}
			else if(input.equals("e"))
			{
				System.out.println("Exiting");
				return(0);
			}
			else
			{
				System.out.println("Sorry, we couldn't understand your input, please input a 'w' 's' 'a' 'd' or 'e'");
			}
		}
		return 0;
	}
	public void printPlace()
	{
//		System.out.println("maxDimensionX: " + maxDimensionX);//Debugging
//		System.out.println("maxDimensionY: " + maxDimensionY);
		for(int j=maxDimensionY; j>=0;j--)
		{
			for(int i=0; i<=maxDimensionX;i++)
			{
				if(i==curLocX&&j==curLocY)
				{
					System.out.print("@ ");
				}
				else
				{
					System.out.print(content[i][j].m_show + " ");
//					System.out.print((i+7*(j)) + " "); //debugging
				}
			}
			System.out.println();
		}
		System.out.println("Current coordinate x:" + curLocX + " y:" +  curLocY);
	}
	public void printAgile(int sight)
	{
		if(sight<3)
		{
			sight=3;
		}
		System.out.println("curLocX: " + curLocX + "\ncurLocY: " + curLocY);
		for(int j=curLocY+sight; j>=curLocY-sight; j--)
		{
			for(int i=curLocX-sight; i<=curLocX+sight; i++)
			{
				try
				{
					if(i==curLocX&&j==curLocY)
					{
						System.out.print("@ ");
					}
					else
					{
						System.out.print(content[i][j].m_show + " ");
					}
				}
				catch(Exception e)
				{
					System.out.print("W ");//if array error, print a wall in the space
				}
			}
			System.out.println();
		}
	}
	public void printChoices()
	{
		int minDimensionX=0;
		int minDimensionY=0;
		if(curLocY!=maxDimensionY)//checks to make sure not on edge
		{
			if(content[curLocX][curLocY+1].m_transversible)//checks that tile north is transversible
			{
				System.out.println("w) move North");
			}
		}
		if(curLocX!=minDimensionX)
		{
			if(content[curLocX-1][curLocY].m_transversible)
			{
				System.out.println("a) move West");
			}
		}
		if(curLocY!=minDimensionY)
		{
			if(content[curLocX][curLocY-1].m_transversible)
			{
				System.out.println("s) move South");
			}
		}
		if(curLocX!=maxDimensionX)
		{
//			System.out.println("curLocx= " + curLocX + "\nmaxDimensionX= " + maxDimensionX);
			if(content[curLocX+1][curLocY].m_transversible)//Now we know this test won't be out of bounds
			{
				System.out.println("d) move East");
			}
		}
		System.out.println("e) Exit");
	}
	public void tryMove(int direction)
	{
		int minDimensionX=0;//holds minimum value, used for readibility
		int minDimensionY=0;//holds minimum value, used for readibility
		if(direction==1)//checking move north
		{
			if(curLocY==maxDimensionY)//checks to make sure there is no out of bounds exception
			{
				System.out.println("Sorry, that move is out of bounds");
			}
			else if(!content[curLocX][curLocY+1].m_transversible)//checks to make sure the tile can be walked over
			{
				System.out.println("Sorry, you cant move across " + content[curLocX][curLocY+1].m_name);
			}
			else
			{
				move(direction);
			}
			return;
		}
		else if(direction==2)//checking move west
		{
			if(curLocX==minDimensionX)//checks to make sure there is no out of bounds exception
			{
				System.out.println("Sorry, that move is out of bounds");
			}
			else if(!content[curLocX-1][curLocY].m_transversible)//checks to make sure the tile can be walked over
			{
				System.out.println("Sorry, you cant move across " + content[curLocX-1][curLocY].m_name);
			}
			else
			{
				move(direction);
			}
		}
		else if(direction==3)//checking move south
		{
			if(curLocY==minDimensionY)//checks to make sure there is no out of bounds exception
			{
				System.out.println("Sorry, that move is out of bounds");
			}
			else if(!content[curLocX][curLocY-1].m_transversible)//checks to make sure the tile can be walked over
			{
				System.out.println("Sorry, you cant move across " + content[curLocX][curLocY-1].m_name);
			}
			else
			{
				move(direction);
			}
		}
		else if(direction==4)//checking move east
		{
			if(curLocX==maxDimensionX)//checks to make sure there are no out of bounds exceptions
			{
				System.out.println("Sorry, that move is out of bounds");
			}
			else if(!content[curLocX+1][curLocY].m_transversible)//checks to see if tile can be walked over
			{
				System.out.println("Sorry, you cant move across " + content[curLocX+1][curLocY].m_name);
			}
			else
			{
				move(direction);
			}
		}
	}
	public void move(int direction)
	{
		if(direction==1)//moving north
		{
			prevLocY=curLocY;
			curLocY++;
		}
		else if(direction==2)//moving West
		{
			prevLocX=curLocX;
			curLocX--;
		}
		else if(direction==3)
		{
			prevLocY=curLocY;
			curLocY--;
		}
		else if(direction==4)
		{
			prevLocX=curLocX;
			curLocX++;
		}
	}
}
