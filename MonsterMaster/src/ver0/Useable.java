package ver0;

public class Useable extends Item
{
	//static variables
	static final int numOfUseable = 10;
	
	//member variables
	//TODO make member variables private and write setters/getters
	boolean m_targetsMultiple;
	int m_phyDmg;
	int m_firDmg;
	int m_wtrDmg;
	int m_ertDmg;
	int m_airDmg;
	int m_lgtDmg;
	int m_drkDmg;
	
	//constructors
	public Useable()
	{
		
	}
	public Useable(int which)
	{
		//sets these values to default values unless changed later
		m_targetsMultiple=false;
		m_description="";
		m_phyDmg=0;
		m_firDmg=0;
		m_wtrDmg=0;
		m_ertDmg=0;
		m_airDmg=0;
		m_lgtDmg=0;
		m_drkDmg=0;
		if(which==0)
		{
			m_name = "lesser healing potion";
			m_value=25;
			m_phyDmg=-50;
		}
		else if(which==1)
		{
			m_name = "spike";
			m_value=20;
			m_phyDmg=25;
		}
		else if(which==2)
		{
			m_name = "pepperspice";
			m_firDmg=20;
			m_value=20;
		}
		else if(which==3)
		{
			m_name = "ice water";
			m_wtrDmg=20;
			m_value = 20;
		}
		else if(which==4)
		{
			m_name = "mystic dust";
			m_ertDmg = 20;
			m_value = 20;
		}
		else if(which==5)
		{
			m_name = "captured wind";
			m_airDmg=20;
			m_value=20;
		}
		else if(which==6)
		{
			m_name = "reflected starlight";
			m_lgtDmg=20;
			m_value=20;
		}
		else if(which==7)
		{
			m_name = "contained spite";
			m_drkDmg=20;
			m_value=20;
		}
		else if(which==8)
		{
			m_name = "Lesser firebomb";
			m_phyDmg=15;
			m_firDmg = 15;
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
