package ver0;

public class Skill 
{
	String m_name;
	int m_element;
	int m_index;
	boolean m_isPhysical;		//determines if the physical counter is incremented after execution
	boolean m_isMagical;		//determines if the magical counter is incremented after execution 
	boolean m_castOnSelf;		//determines if the skill can only be used by the user on the user
	boolean m_castOnSingle;		//determines if the skill is cast on a single character or multiple
	boolean m_castOnEnemy;		//determines if the skill is cast on allies or enemies
	Damage m_damage;			//The damage quantity that will be inflicted on the target-can be empty
	public static Skill[] getAllSkills()
	{
		Skill[] skillSet=new Skill[9];
		for(int i=0;i<skillSet.length;i++)
		{
			skillSet[i]=new Skill(i);
		}
		return skillSet;
	}
	public Skill(int index)
	{
		m_castOnSelf=false;
		m_castOnSingle=false;
		m_castOnEnemy=false;
		m_index=index;
		m_damage = new Damage();
		if(index==0)
		{
			m_name="PyroShell";
			m_isPhysical=true;
			m_isMagical=true;
			m_castOnSelf=true;
		}
		else if(index==1)
		{
			m_name="AquaShell";
			m_isPhysical=true;
			m_isMagical=true;
			m_castOnSelf=true;
		}
		else if(index==2)
		{
			m_name="TeraShell";
			m_isPhysical=true;
			m_isMagical=true;
			m_castOnSelf=true;
		}
		else if(index==3)
		{
			m_name="AeroShell";
			m_isPhysical=true;
			m_isMagical=true;
			m_castOnSelf=true;
		}
		else if(index==4)
		{
			m_name="LuxorShell";
			m_isPhysical=true;
			m_isMagical=true;
			m_castOnSelf=true;
		}
		else if(index==5)
		{
			m_name="UmbralShell";
			m_isPhysical=true;
			m_isMagical=true;
			m_castOnSelf=true;
		}
		else if(index==6)//for flarial [0][0][1][0]
		{
			m_name="Fire Slam";
			m_isPhysical=true;
			m_isMagical=false;
			m_castOnSelf=false;
			m_castOnSingle=true;
			m_castOnEnemy=true;
		}
		else if(index==7)//for Pyrus
		{
			m_name="Burn Bite";
			m_isPhysical=true;
			m_isMagical=false;
			m_castOnSelf=false;
			m_castOnSingle=true;
			m_castOnEnemy=true;
		}
		else if(index==8)//for Pyros
		{
			m_name="Red Bull Charge";
			m_isPhysical=true;
			m_isMagical=false;
			m_castOnSelf=false;
			m_castOnSingle=true;
			m_castOnEnemy=true;
		}
		if(m_castOnSelf==true)
		{
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
			target[0].m_thornsDmg[2]=5;
		}
		else if(m_index==1)
		{
			target[0].m_thornsDmg[3]=5;
		}
		else if(m_index==2)
		{
			target[0].m_thornsDmg[4]=5;
		}
		else if(m_index==3)
		{
			target[0].m_thornsDmg[5]=5;
		}
		else if(m_index==4)
		{
			target[0].m_thornsDmg[6]=5;
		}
		else if(m_index==5)
		{
			target[0].m_thornsDmg[7]=5;
		}
		else if(m_index==6)
		{
			target[0].m_thornsDmg[8]=5;
		}
		else if(m_index==7)
		{
			Damage myDamage=new Damage();
			myDamage.m_firDmg=10;
			myDamage.m_phyDmg=10;
			target[0].takeDamage(myDamage);
		}
		else if(m_index==8)
		{
			Damage myDamage=new Damage();
			myDamage.m_firDmg=30;
			myDamage.m_phyDmg=20;
			myDamage.m_statusesDmg[0]=2;
			target[0].takeDamage(myDamage);
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
