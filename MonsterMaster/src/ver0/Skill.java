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
		selected=Bestiary.bestiary1d[index];//selected stands for the monster cooresponding to the skill being created
		
		String name=Bestiary.typeNames[selected.getPrimaryElement()][selected.getSecondaryElement()];
		
		//The following code consructs the generic skills associated with each monster
		if(selected.getEvolutionStage()==0)//This code handles constructing the skills associated with the eggs
		{
			m_name=name+"shell";
			m_castOnSelf=true;
		}
		else if(selected.getEvolutionStage()==1)//This code handles the skills associated with the infant stage (yes the Tera's all get the same skill)
		{
			m_name=name+" Strike";
			m_castOnSelf=false;
			m_castOnSingle=true;
			m_castOnEnemy=true;
		}//This else if statement handles creating the skills associated with trees that have only one adolescent
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==1)
		{
			//this code handles the Trees that have only one adolescent
			m_name=name + " Attack";
			m_castOnSelf=false;
			m_castOnSingle=true;
			m_castOnEnemy=true;
			m_isPhysical=true;
		}//This else if handles creating the skills associated with the trees that have two adolescents (hence length==2)
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==2)
		{
			if(selected.getEvolutionType()==0)//for the physical monster
			{
				m_name = name + " claw";
				m_isPhysical=true;
				m_castOnSelf=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
			else if(selected.getEvolutionType()==1)//for the magical monster
			{
				m_name = name + " bolt";
				m_isMagical=true;
				m_castOnSelf=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
		}//This else if handles creating the skills associated with the trees that have more than two adolsecents -if the tree has more than three some are unassigned
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length>2)
		{
			if(selected.getEvolutionType()==0)//for the physcial monster
			{
				m_name = name + " claw";
				m_isPhysical=true;
				m_castOnSelf=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
			else if(selected.getEvolutionType()==1)//for the 'balanced' monster
			{
				m_name = "Strong" + name + " strike";
				m_isPhysical=true;
				m_isMagical=true;
				m_castOnSelf=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}//This skill is associated with the 'magical' monster
			else if(selected.getEvolutionType()==Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length-1)
			{
				m_name = name + " bolt";
				m_isMagical=true;
				m_castOnSelf=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
		}//This handles the Adults on single branch trees
		else if(selected.getEvolutionStage()==3&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==1)
		{
			m_name = name + " Super Attack";
			m_isMagical=true;
			m_castOnSelf=false;
			m_castOnSingle=false;//attacks mutliple
			m_castOnEnemy=true;
			
		}//Handles the adults on two branch trees
		else if(selected.getEvolutionStage()==3&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==2)
		{
			if(selected.getEvolutionType()==0)//this is for the physical side of the tree
			{
				m_name = name + " bite";
				m_isPhysical = true;
				m_isMagical=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
			else//this is for the magical side of the tree
			{
				m_name = name + " Wide Blast";
				m_isPhysical = false;
				m_isMagical = true;
				m_castOnSingle=false;
				m_castOnEnemy=true;
			}
		}//Handles the adults on three or more branch trees
		else if(selected.getEvolutionStage()==3&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length>2)
		{	
			if(selected.getEvolutionType()==0)//this is for the physical side of the tree
			{
				m_name = name + " bite";
				m_isPhysical = true;
				m_isMagical=false;
				m_castOnSingle=true;
				m_castOnEnemy=true;
			}
			else if(selected.getEvolutionType()==1)//balanced side of the tree
			{
				m_name = name + " Super Attack";
				m_isMagical=true;
				m_castOnSelf=false;
				m_castOnSingle=false;//attacks mutliple
				m_castOnEnemy=true;
			}//magical side of the tree
			else if(selected.getEvolutionType()==Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length-1)
			{
				m_name = name + " Wide Blast";
				m_isPhysical = false;
				m_isMagical = true;
				m_castOnSingle=false;
				m_castOnEnemy=true;
			}
		}//handles the case of an elder single sibling
		else if(selected.getEvolutionStage()==4&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==1)
		{
			m_name = name + " Ultra Attack";
			m_isMagical=true;
			m_isPhysical=true;
			m_castOnSingle=false;
			m_castOnEnemy=true;
		}
		else if(selected.getEvolutionStage()==4&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==2)
		{
			if(selected.getEvolutionType()==0)
			{
				m_name = name = " Wide Claw";
				m_isPhysical=true;
				m_castOnSingle=false;
				m_castOnEnemy=true;
			}
			else
			{
				m_name = name + " Ultra Wide Blast";
				m_isMagical = true;
				m_castOnSingle=false;
				m_castOnEnemy=true;
			}
		}
		else if(selected.getEvolutionStage()==4&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length>2)
		{
			if(selected.getEvolutionType()==0)
			{
				m_name = name + " Wide Claw";
				m_isPhysical=true;
				m_castOnSingle=false;
				m_castOnEnemy=true;
			}
			else if(selected.getEvolutionType()==Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length-1)
			{
				m_name = name + " Ultra Wide Blast";
				m_isMagical = true;
				m_castOnSingle=false;
				m_castOnEnemy=true;
			}
			else
			{
				m_name = name + " Ultra Attack";
				m_isMagical=true;
				m_isPhysical=true;
				m_castOnSingle=false;
				m_castOnEnemy=true;
			}
		}
			
			//TODO finish Constructor
		
		//This handles some member booleans - if the skill is cast on yourself then it is cast on single and not cast on enemy
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
				target[0].m_thornsDmg[selected.getPrimaryElement()+2]=5;//the target will be the monster casting it -as its member variable m_self=true
				//The thorns damage array begins with physical damage then magical damage, which is why the element is staggered by two
			}
			else
			{
				target[0].m_thornsDmg[selected.getPrimaryElement()+2]=3;//the primary element thorns damage is slightly higher than the secondary element thorns damage
				target[0].m_thornsDmg[selected.getSecondaryElement()+2]=2;
			}
		}
		else if(selected.getEvolutionStage()==1)//handles the execution for the infant skills
		{//in all cases but one, there is only one infan
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
		}//This else if handles the execution for skills associated with adolescent monsters who have 2 monsters in their type
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
			target[0].takeDamage(myDamage);//actually applies the object to the target
		}//This else if handles the execution for skills associated with monsters who live in trees with more than two adolescent monsters
		else if(selected.getEvolutionStage()==2&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length>2)
		{
			Damage myDamage = new Damage();//creates the damage object-common to all generic skills
			if(selected.getEvolutionType()==0)//means that the monster selected is the physical evolution
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
			else if(selected.getEvolutionType()==1)//means that the corresponding monster is some kind of "balanced" evolution
			{
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
			}//this if ensures that the cooresponding monster is the "magical" evolution
			else if(selected.getEvolutionType()==Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length-1)
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
			target[0].takeDamage(myDamage);
		}
		//This handles the Adults on single branch trees
		else if(selected.getEvolutionStage()==3&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==1)
		{
			Damage myDamage = new Damage();
			for(int i=0;i<myDamage.m_normalDmg.length;i++)
			{
				myDamage.m_normalDmg[i]=0;
			}
			myDamage.m_normalDmg[0]=20;
			myDamage.m_normalDmg[selected.getPrimaryElement()+2]+=12;
			myDamage.m_normalDmg[selected.getSecondaryElement()+2]+=18;
			for(int i=0;i<target.length;i++)
			{
				target[i].takeDamage(myDamage);
			}
					
		}//Handles the adults on two branch trees
		else if(selected.getEvolutionStage()==3&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length==2)
		{
			Damage myDamage = new Damage();
			for(int i=0;i<myDamage.m_normalDmg.length;i++)
			{
				myDamage.m_normalDmg[i]=0;
			}
			if(selected.getEvolutionType()==0)//this is for the physical side of the tree
			{
	
				myDamage.m_normalDmg[0]=70;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]+=20;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]+=10;
				target[0].takeDamage(myDamage);
			}
			else//this is for the magical side of the tree
			{
				myDamage.m_normalDmg[1]=15;
				myDamage.m_normalDmg[selected.getPrimaryElement()]+=20;
				myDamage.m_normalDmg[selected.getSecondaryElement()]+=15;
				for(int i=0;i<target.length;i--)
				{
					target[i].takeDamage(myDamage);
				}
			}
		}
		else if(selected.getEvolutionStage()==3&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length>2)
		{
			Damage myDamage = new Damage();
			for(int i=0;i<myDamage.m_normalDmg.length;i++)
			{
				myDamage.m_normalDmg[i]=0;
			}
			if(selected.getEvolutionType()==0)//this is for the physical side of the tree
			{
				myDamage.m_normalDmg[0]=70;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]+=20;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]+=10;
				target[0].takeDamage(myDamage);
			}
			else if(selected.getEvolutionType()==1)//balanced side of the tree
			{
				for(int i=0;i<myDamage.m_normalDmg.length;i++)
				{
					myDamage.m_normalDmg[i]=0;
				}
				myDamage.m_normalDmg[0]=20;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]+=12;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]+=18;
				for(int i=0;i<target.length;i++)
				{
					target[i].takeDamage(myDamage);
				}
			}//magical side of the tree
			else if(selected.getEvolutionType()==Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length-1)
			{

				myDamage.m_normalDmg[1]=15;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]+=20;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]+=15;
				for(int i=0;i<target.length;i++)
				{
					target[i].takeDamage(myDamage);
				}
			}
		}
		else if(selected.getEvolutionStage()==4&&Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length>2)
		{
			Damage myDamage = new Damage();
			if(selected.getEvolutionType()==0)
			{
				myDamage.m_normalDmg[0]=70;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]+=20;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]+=10;
				for(int i=0; i<target.length;i++)
				{
					target[0].takeDamage(myDamage);
				}
			}
			else if(selected.getEvolutionType()==Bestiary.bestiary[selected.getPrimaryElement()][selected.getSecondaryElement()][selected.getEvolutionStage()].length-1)
			{
				myDamage.m_normalDmg[1]=30;
				myDamage.m_normalDmg[selected.getPrimaryElement()+2]+=40;
				myDamage.m_normalDmg[selected.getSecondaryElement()+2]+=30;
				for(int i=0; i<target.length;i++)
				{
					target[i].takeDamage(myDamage);
				}
			}
			//TODO finish
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
