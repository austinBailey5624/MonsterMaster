package ver0;

public class Skill 
{
	String m_name;
	int m_element;
	int m_index;
	boolean m_generic;
	boolean m_isPhysical;		//determines if the physical counter is incremented after execution
	boolean m_isMagical;		//determines if the magical counter is incremented after execution 
	boolean m_castOnSelf;		//determines if the skill can only be used by the user on the user
	boolean m_castOnSingle;		//determines if the skill is cast on a single character or multiple
	boolean m_castOnEnemy;		//determines if the skill is cast on allies or enemies
	Damage m_damage;			//The damage quantity that will be inflicted on the target-can be empty
	static MonsterType selected;
	public static Skill[] getAllSkills()
	{
		Skill[] skillSet=new Skill[MonsterType.howMany()];
		for(int i=0;i<skillSet.length;i++)
		{
			skillSet[i]=new Skill(i);
		}
		return skillSet;
	}
	public Skill(int index)
	{
		m_isPhysical=false;
		m_isMagical=false;
		m_castOnSelf=false;
		m_castOnSingle=false;
		m_castOnEnemy=false;
		m_generic=true;
		m_index=index;
		m_damage = new Damage();
		selected=Bestiary.bestiary1d[index];
		
		String name=Bestiary.typeNames[selected.getPrimaryElement()][selected.getSecondaryElement()];
		if(selected.getEvolutionStage()==0)//This code handles constructing the skills associated with the eggs
		{
			m_name=name+"shell";
			m_castOnSelf=true;
		}
		else if(selected.getEvolutionStage()==1)//
		{
			m_name=name+" Strike";
			m_castOnSelf=false;
			m_castOnSingle=true;
			m_castOnEnemy=true;
		}
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==1)
		{
			//this code handles the Trees that have only one adolescent
			m_name=name + " Attack";
			m_castOnSelf=false;
			m_castOnSingle=true;
			m_castOnEnemy=true;
			m_isPhysical=true;
		}
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==2)
		{
			if(selected.getEvolutionType()==0)
			{
				m_name = name + " claw";
				m_isPhysical=true;
				m_castOnSelf=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
			else if(selected.getEvolutionType()==1)
			{
				m_name = name + " bolt";
				m_isMagical=true;
				m_castOnSelf=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
		}
		//TODO finish Constructor
		if(m_castOnSelf==true)
		{
			m_castOnSingle=true;
			m_castOnEnemy=false;
		}
	}
	public void execute(Actor[] target)
	{
		selected=Bestiary.bestiary1d[m_index];
		if(selected.getEvolutionStage()==0)//handles the execution for the Egg skills
		{
			if(selected.getPrimaryElement()==selected.getSecondaryElement())
			{
				target[0].m_thornsDmg[selected.getPrimaryElement()+2]=5;
			}
			else
			{
				target[0].m_thornsDmg[selected.getPrimaryElement()+2]=3;
				target[0].m_thornsDmg[selected.getSecondaryElement()+2]=2;
			}
		}
		else if(selected.getEvolutionStage()==1)//handles the execution for the infant skills
		{
			Damage myDamage = new Damage();
			if(selected.getPrimaryElement()==selected.getSecondaryElement())
			{
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]=10;
				myDamage.m_normalDmg[0]=10;
			}
			else
			{
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]=7;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]=3;
				myDamage.m_normalDmg[0]=10;
			}
			target[0].takeDamage(myDamage);
		}
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==1)
		{	//handles the execution for adolescent monsters that have no other same-stage monstertypes
			Damage myDamage = new Damage();
			if(selected.getPrimaryElement()==selected.getSecondaryElement())
			{
				myDamage.m_normalDmg[0]=10;
				myDamage.m_normalDmg[1]=10;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]=30;
			}
			else
			{
				myDamage.m_normalDmg[0]=10;
				myDamage.m_normalDmg[1]=10;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]=20;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]=10;
			}
			target[0].takeDamage(myDamage);
		}
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==2)
		{
			Damage myDamage = new Damage();
			if(selected.getEvolutionType()==0)
			{
				myDamage.m_normalDmg[0]=20;
				if(selected.getPrimaryElement()==selected.getSecondaryElement())
				{
					myDamage.m_normalDmg[selected.getPrimaryElement()+2]=30;
				}
				else
				{
					myDamage.m_normalDmg[selected.getPrimaryElement()+2]=20;
					myDamage.m_normalDmg[selected.getSecondaryElement()+2]=10;
				}
			}
			else if(selected.getEvolutionType()==1)
			{
				myDamage.m_normalDmg[1]=20;
				if(selected.getPrimaryElement()==selected.getSecondaryElement())
				{
					myDamage.m_normalDmg[selected.getPrimaryElement()+2]=30;
				}
				else
				{
					myDamage.m_normalDmg[selected.getPrimaryElement()+2]=20;
					myDamage.m_normalDmg[selected.getSecondaryElement()+2]=10;
				}
			}
		}
		
		
		
		
		
		
		
		
		
		if(m_castOnSingle==true&&target.length!=1)
		{
			System.out.println("Warning! This skill is only meant to be used on one Actor at a time!");
		}

		//TODO finish execute()
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
