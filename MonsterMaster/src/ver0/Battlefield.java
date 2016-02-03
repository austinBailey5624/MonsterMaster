/**
 * @fileName:		Battlefield.java
 * @author:			Austin Bailey <austin5624@gmail.com>
 * @dateBegun:		5/8/2016
 * @LatestUpdate:	5/8/2016
 */
package ver0;
import java.util.Random;


public class Battlefield 
{
	Actor[] m_allies;
	Actor[] m_enemies;
	int m_alliesIndexNext;
	int m_enemiesIndexNext;
	boolean alliesGoFirst;
	int m_curWeather=0;
	public Battlefield(Actor[]allies, Actor[] enemies)
	{
		m_allies = allies;
		m_enemies = enemies;
		m_alliesIndexNext=0;
		m_enemiesIndexNext=0;
		if(randomNumber(0,1)==1)//Determines who goes first
		{
			alliesGoFirst=true;
		}
		else
		{
			alliesGoFirst=false;
		}
	}
//	public Party fight()
	//{
		
	//}
	
	public int randomNumber(int min, int max)
	{	
		Random r= new Random(System.currentTimeMillis());//creates a "random" number seeded by the current time
		return r.nextInt(max-min+1)+min;
	}
}
