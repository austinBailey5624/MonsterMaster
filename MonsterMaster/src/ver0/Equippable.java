package ver0;

public class Equippable extends Item
{
	static public int numEquippable = 4;
	
	//member variables
	String m_type;
	int m_phyDmg;
	int m_phyDef;
	int m_firDmg;
	int m_firDef;
	int m_wtrDmg;
	int m_wtrDef;
	int m_ertDmg;
	int m_ertDef;
	int m_airDef;
	int m_airDmg;
	int m_lgtDef;
	int m_lgtDmg;
	int m_drkDef;
	int m_drkDmg;
	
	//constructors
	public Equippable()
	{
		
	}
	
	public Equippable(int which)
	{
		m_description="";
		m_phyDmg=0;
		m_phyDef=0;
		m_firDmg=0;
		m_firDef=0;
		m_wtrDmg=0;
		m_wtrDef=0;
		m_ertDmg=0;
		m_ertDef=0;
		m_airDmg=0;
		m_airDef=0;
		m_lgtDmg=0;
		m_lgtDef=0;
		m_drkDmg=0;
		m_drkDef=0;
		if(which==0)
		{
			m_type="1h weapon";
			m_name="rusty iron dagger";
			m_phyDmg=5;
			m_description="This near useless iron dagger is so crusty, you imagine it could break at any moment.\n the edges of the blade are flaking off, and in the crevices\n there is a reddish orange rust.";
			m_value=3;
		}
		else if(which==1)
		{
			m_type="Sheild";
			m_name="flat log";
			m_phyDef=5;
			m_description="Its not really much of a shield, just a log with a twig that makes it easy to hold.\n It can be easily broken through, and when hit, the log\n slacks against your arm painfully.";
			m_value=3;
		}
		else if(which==2)
		{
			m_type="Armor";
			m_name = "sackcloth shirt";
			m_phyDef=3;
			m_description="What happens when the sacks that hold grain are no longer needen?\n Theyre turned into shirts apparently.";
			m_value=3;
		}
		else if(which==3)
		{
			m_type = "Ring";
			m_name = "Unadorned Iron ring";
			m_phyDef=1;
			m_description = "This Iron ring seems to be completely useless,\n certainly not a display of wealth, or station.\n Perhaps it serves to remind the bearer where they came from";
			m_value=10;
		}
	}
	
	//methods
	public static int getNum()
	{
		return numEquippable;
	}
	
	public Equippable[] get()
	{
		Equippable[] array = new Equippable[getNum()];
		for(int i=0; i<numEquippable;i++)
		{
			array[i]=new Equippable(i);
		}
		return array;
	}
	//getters/setters
	
	//tests
}
