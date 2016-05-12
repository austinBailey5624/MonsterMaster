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
	static Scanner myScanner= new Scanner(System.in);
	int maxDimensionX;
	int maxDimensionY;
	int startLocX;
	int startLocY;
	int curLocX;
	int curLocY;
	int prevLocX;
	int prevLocY;
	Terrain[][] content;
	
	public Place(int which)
	{
		Terrain[] terrains = Terrain.getAllTerrain();
		Terrain p = new Terrain(0);
		Terrain w = new Terrain(1);
		if(which==0)
		{
			int StartLocX=0;
			int StartLocY=0;
			curLocX=0;
			curLocY=0;
			prevLocX=0;
			prevLocY=0;
			content=new Terrain[7][7];
			content[0][0]=p;
			content[0][1]=w;
			content[0][2]=w;
			content[0][3]=w;
			content[0][4]=w;
			content[0][5]=w;
			content[0][6]=w;
			content[1][0]=p;
			content[1][1]=w;
			content[1][2]=p;
			content[1][3]=p;
			content[1][4]=p;
			content[1][5]=p;
			content[1][6]=p;
			content[2][0]=p;
			content[2][1]=w;
			content[2][2]=p;
			content[2][3]=w;
			content[2][4]=w;
			content[2][5]=w;
			content[2][6]=p;
			content[3][0]=p;
			content[3][1]=w;
			content[3][2]=p;
			content[3][3]=p;
			content[3][4]=p;
			content[3][5]=w;
			content[3][6]=p;
			content[4][0]=p;
			content[4][1]=p;
			content[4][2]=w;
			content[4][3]=w;
			content[4][4]=p;
			content[4][5]=w;
			content[4][6]=p;
			content[5][0]=w;
			content[5][1]=p;
			content[5][2]=p;
			content[5][3]=p;
			content[5][4]=p;
			content[5][5]=w;
			content[5][6]=p;
			content[6][0]=w;
			content[6][1]=w;
			content[6][2]=w;
			content[6][3]=w;
			content[6][4]=w;
			content[6][5]=w;
			content[6][6]=p;
			maxDimensionX=7;
			maxDimensionY=7;
		}
		if(which==1)
		{
			content=new Terrain[][]
			{
				{w,w,w,w,w,w,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,p,p,p,p,p,w},
				{w,w,w,w,w,w,w}
			};
			maxDimensionX=7;
			maxDimensionY=7;
			curLocX=3;
			curLocY=3;
			prevLocX=3;
			prevLocY=3;
		}
	}
	public void transverse()
	{
		//code moving character here
		boolean exit=false;
		String input;
		while(!exit)
		{
			printPlace();
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
				System.out.print("Exiting");
				return;
			}
			else
			{
				System.out.print("Sorry, we couldn't understand your input, please input a 'w' 's' 'a' 'd' or 'e'");
			}
		}
	}
	public void printPlace()
	{
//		System.out.println("maxDimensionX: " + maxDimensionX);//Debugging
//		System.out.println("maxDimensionY: " + maxDimensionY);
		for(int j=maxDimensionY-1; j>=0;j--)
		{
			for(int i=0; i<maxDimensionX;i++)
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
	public void printChoices()
	{
		int minDimensionX=0;
		int minDimensionY=0;
		int choice=1;
		if((!(curLocY==maxDimensionY)||!content[curLocX][curLocY+1].m_transversible))
		{
			System.out.println("w) move North");
		}
		if(curLocX!=minDimensionX)
		{
			System.out.println("a) move West");
		}
		if(curLocY!=minDimensionY)
		{
			System.out.println("s) move South");
		}
		if(curLocX!=maxDimensionX)
		{
			System.out.println("d) move East");
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
