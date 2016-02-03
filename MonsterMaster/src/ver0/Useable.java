package ver0;

public class Useable extends Item
{
	//static variables
	static final int numOfUseable = 10;
	
	//member variables
	//TODO make member variables private and write setters/getters
	boolean m_targetsMultiple;
	int[] m_damage;
	
	//constructors
	public Useable()
	{
		
	}
	public Useable(int which)
	{
		//sets these values to default values unless changed later
		m_targetsMultiple=false;
		m_description="";
		m_damage = new int[8];
		for(int i=0;i<m_damage.length;i++)
		{
			m_damage[i]=0;
		}
		if(which==0)
		{
			m_name = "lesser healing potion";
			m_value=25;
			m_damage[0]=-50;
		}
		else if(which==1)
		{
			m_name = "spike";
			m_value=20;
			m_damage[0]=25;
		}
		else if(which==2)
		{
			m_name = "pepperspice";
			m_damage[3]=20;
			m_value=20;
		}
		else if(which==3)
		{
			m_name = "ice water";
			m_damage[4]=20;
			m_value = 20;
		}
		else if(which==4)
		{
			m_name = "mystic dust";
			m_damage[5] = 20;
			m_value = 20;
		}
		else if(which==5)
		{
			m_name = "captured wind";
			m_damage[6]=20;
			m_value=20;
		}
		else if(which==6)
		{
			m_name = "reflected starlight";
			m_damage[7]=20;
			m_value=20;
		}
		else if(which==7)
		{
			m_name = "contained spite";
			m_damage[8]=20;
			m_value=20;
		}
		else if(which==8)
		{
			m_name = "Lesser firebomb";
			m_damage[0]=15;
			m_damage[2] = 15;
			m_value=30;
		}
	}
	
	//methods
	public static int getNum()
	{
		return numOfUseable;
	}
	
	public Useable[] get()
	{
		Useable[] array = new Useable[numOfUseable];
		for(int i=0; i<numOfUseable; i++)
		{
			array[i]=new Useable(i);
		}
		return array;
	}
	//setters/getters
	
	//tests
}
