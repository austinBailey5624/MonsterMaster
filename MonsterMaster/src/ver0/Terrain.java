package ver0;
/**
 * @file Terrain.java
 * @author Austin Bailey <a604b997@gmail.com>
 * @dateBegun 5/8/2016
 * @lastUpdated 5/8/2016
 */
public class Terrain 
{
	String m_name;
	boolean m_transversible;
	char m_show;
	int m_exitNumber;
	static int totTerrainNum=2;
	public Terrain(int which)
	{
		m_exitNumber=0;
		if(which==0)
		{
			m_name="Path";
			m_transversible=true;
			m_show='P';
		}
		else if(which==1)
		{
			m_name="Wall";
			m_transversible=false;
			m_show='W';
		}
	}
	public Terrain(int which, int exitNo)
	{
		m_name="Exit";
		m_transversible=true;
		m_show='E';
		m_exitNumber=exitNo;
	}
	public static Terrain[] getAllTerrain()
	{
		Terrain[] TerrainArray = new Terrain[totTerrainNum];
		for(int i=0; i<TerrainArray.length;i++)
		{
			TerrainArray[i]= new Terrain(i);
		}
		return TerrainArray;
	}
}
