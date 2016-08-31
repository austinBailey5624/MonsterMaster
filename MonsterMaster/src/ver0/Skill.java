package ver0;

public class Skill 
{
	String m_name;
	int m_element;
	int m_index;
	boolean m_isPhysical;
	boolean m_isMagical;
	boolean m_castOnSingle;
	boolean m_castOnEnemy;
	Damage m_damage;
	public static Skill[] getAllSkills()
	{
		MonsterType[] bestiary=Bestiary.convertTo1d();
		Skill[] skillSet=new Skill[2];
		for(int i=0;i<skillSet.length;i++)
		{
			skillSet[i]=new Skill(i);
		}
		return skillSet;
	}
	public Skill(int index)
	{
		m_index=index;
		m_damage = new Damage();
		if(index==0)
		{
			m_name="PyroShell";
			m_isPhysical=true;
			m_isMagical=true;
			m_castOnSingle=true;
			m_castOnEnemy=false;
		}
	}
	public void execute(Actor[] target)
	{
		if(m_castOnSingle==true&&target.length!=1)
		{
			System.out.println("Warning! This skill is only meant to be used on one Actor at a time!");
		}
		if(m_index==0)
		{
			target[0].m_thornsDmg[0]=5;
		}
		else if(m_index==1)
		{
			
		}
	}
	public static String getElementName(int i)
	{
		if(i==0)
		{
			return "Physical";
		}
		else if(i==1)
		{
			return "Magical";
		}
		else if(i==2)
		{
			return "Fire";
		}
		else if(i==3)
		{
			return "Water";
		}
		else if(i==4)
		{
			return "Earth";
		}
		else if(i==5)
		{
			return "Air";
		}
		else if(i==6)
		{
			return "Light";
		}
		else if(i==7)
		{
			return "Dark";
		}
		return "Invalid index";
	}
}
