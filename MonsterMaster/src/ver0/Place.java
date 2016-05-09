package ver0;
/**
 * @file	Place.java
 * @author 	Austin Bailey
 * @dateBegun:	5/8/2016
 * @lastUpdate:	5/9/2016
 */
public class Place 
{
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
		Terrain p = terrains[0];
		Terrain w = terrains[1];
		if(which==0)
		{
			int StartLocX=1;
			int StartLocY=1;
			curLocX=1;
			curLocY=1;
			prevLocX=1;
			prevLocY=2;
			content[0]=new Terrain[7];
			content[0][0]=p;
			content[0][1]=w;
			content[0][2]=w;
			content[0][3]=w;
			content[0][4]=w;
			content[0][5]=w;
			content[0][6]=w;
			content[1]=new Terrain[7];
			content[1][0]=p;
			content[1][1]=w;
			content[1][2]=p;
			content[1][3]=p;
			content[1][4]=p;
			content[1][5]=p;
			content[1][6]=p;
			content[2]=new Terrain[7];
			content[2][0]=p;
			content[2][1]=w;
			content[2][2]=p;
			content[2][3]=w;
			content[2][4]=w;
			content[2][5]=w;
			content[2][6]=p;
			content[3]=new Terrain[7];
			content[3][0]=p;
			content[3][1]=w;
			content[3][2]=p;
			content[3][3]=p;
			content[3][4]=p;
			content[3][5]=w;
			content[3][6]=p;
			content[4]=new Terrain[7];
			content[4][0]=p;
			content[4][1]=p;
			content[4][2]=w;
			content[4][3]=w;
			content[4][4]=p;
			content[4][5]=w;
			content[4][6]=p;
			content[5]=new Terrain[7];
			content[5][0]=w;
			content[5][1]=p;
			content[5][2]=p;
			content[5][3]=p;
			content[5][4]=p;
			content[5][5]=w;
			content[5][6]=p;
			content[6]= new Terrain[7];
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
	}
	public void transverse()
	{
		//code moving character here
		boolean exit=false;
		while(!exit)
		{
			printPlace();
			printChoices();
		}
	}
	public void printPlace()
	{
		for(int i=0; i<maxDimensionX;i++)
		{
			for(int j=0; j<maxDimensionY;j++)
			{
				if(i==curLocX&&j==curLocY)
				{
					System.out.print("@ ");
				}
				else
				{
					System.out.print(content[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	public void printChoices()
	{
		
	}
}
