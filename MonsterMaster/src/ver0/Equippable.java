package ver0;

public class Equippable extends Item
{
	static public int numEquippable = 4;
	
	//member variables -make private
	String m_type;
	int[] m_dmgBonus;
	int[] m_defBonus;
	
	//constructors
	public Equippable()//this empty constructor is here for the benefit of the next one
	{
		
	}
	
	public Equippable(int which)
	{
		m_description="";
		m_dmgBonus = new int[8];
		m_defBonus = new int[8];
		for(int i=0; i<m_dmgBonus.length;i++)
		{
			m_dmgBonus[i]=0;//initializes all of the values to 0
			m_defBonus[i]=0;
		}
		if(which==0)
		{
			m_type="1h weapon";
			m_name="rusty iron dagger";
			m_dmgBonus[0]=5;
			m_description="This near useless iron dagger is so crusty, you imagine it could break at any moment.\n the edges of the blade are flaking off, and in the crevices\n there is a reddish orange rust.";
			m_value=3;
		}
		else if(which==1)
		{
			m_type="Sheild";
			m_name="flat log";
			m_defBonus[0]=5;
			m_description="Its not really much of a shield, just a log with a twig that makes it easy to hold.\n It can be easily broken through, and when hit, the log\n slacks against your arm painfully.";
			m_value=3;
		}
		else if(which==2)
		{
			m_type="Armor";
			m_name = "sackcloth shirt";
			m_defBonus[0]=3;
			m_description="What happens when the sacks that hold grain are no longer needen?\n Theyre turned into shirts apparently.";
			m_value=3;
		}
		else if(which==3)
		{
			m_type = "Ring";
			m_name = "Unadorned Iron ring";
			m_defBonus[0]=1;
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
