/*
 * 		@FileName:		MonsterType.java
 * 		@Author:		Austin Bailey
 * 		@DateBegun:		12/7/2015
 */
package ver0;

public class MonsterType 
{
	//constructors
	MonsterType(int primaryElement, int secondaryElement, int evolutionStage, int evolutionType)
	{
		m_numEvolvesFrom=0;
		m_evolvesFrom1=null;
		m_evolvesFrom2=null;
		m_evolvesFrom3=null;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
		m_evolvesInto1=null;
		m_evolvesInto2=null;
		m_evolvesInto3=null;
		m_numOfEvolutions=0;
		m_skill=null;
	}
	MonsterType(int primaryElement, int secondaryElement, int evolutionStage, int evolutionType, MonsterType evolvesInto1)
	{
		m_numEvolvesFrom=0;
		m_evolvesFrom1=null;
		m_evolvesFrom2=null;
		m_evolvesFrom3=null;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
		//m_evolvesInto1=evolvesInto1;
		//m_evolvesInto2=null;
		m_evolvesInto1=null;
		m_evolvesInto2=evolvesInto1;
		m_evolvesInto3=null;
		m_numOfEvolutions=1;
		m_skill=null;
	}
	MonsterType(int primaryElement, int secondaryElement, int evolutionStage, int evolutionType, MonsterType evolvesInto1, MonsterType evolvesInto2)
	{
		m_numEvolvesFrom=0;
		m_evolvesFrom1=null;
		m_evolvesFrom2=null;
		m_evolvesFrom3=null;
//		m_typeName=typeName;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
//		m_description=description;
		m_evolvesInto1=evolvesInto1;
		//m_evolvesInto2=evolvesInto2;
		//m_evolvesInto3=null;
		m_evolvesInto2=null;
		m_evolvesInto3=evolvesInto2;
		m_numOfEvolutions=2;
		m_skill=null;
	}
	MonsterType(int primaryElement, int secondaryElement,int evolutionStage, int evolutionType, MonsterType evolvesInto1, MonsterType evolvesInto2, MonsterType evolvesInto3)
	{
		m_numEvolvesFrom=0;
		m_evolvesFrom1=null;
		m_evolvesFrom2=null;
		m_evolvesFrom3=null;
//		m_typeName=typeName;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
//		m_description=description;
		m_evolvesInto1=evolvesInto1;
		m_evolvesInto2=evolvesInto2;
		m_evolvesInto3=evolvesInto3;
		m_numOfEvolutions=3;
		m_skill=null;
	}
	
	//memberVariables
	private int m_numOfEvolutions;
	private int m_numEvolvesFrom;
	private MonsterType m_evolvesFrom1;
	private MonsterType m_evolvesFrom2;
	private MonsterType m_evolvesFrom3;
	private MonsterType m_evolvesInto1;
	private MonsterType m_evolvesInto2;
	private MonsterType m_evolvesInto3;
	private String m_typeName;
	private String m_description;
	private int m_evolutionStage;
	private int m_evolutionType;
	private int m_primaryElement;//Note, Beast has this too... but i think itll be useful later
	private int m_secondaryElement;//Note same as above
	Skill m_skill;
	
	public int indexLookup()
	{
		int keeper=0;
		for(int i=0; i<Bestiary.bestiary.length;i++)
		{
			for(int j=0; j<Bestiary.bestiary[i].length;j++)
			{
				for(int k=0; k<Bestiary.bestiary[i][j].length;k++)
				{
					for(int m=0; m<Bestiary.bestiary[i][j][k].length; m++)
					{
						if(this.m_primaryElement==i&&this.m_secondaryElement==j&&this.m_evolutionStage==k&&this.m_evolutionType==m)
						{
							return keeper;
						}
						keeper++;
					}
				}
			}
		}
		System.out.println("ERROR in index lookup!");
		return-1;
	}
	
	public static int howMany()//returns how many monster types there are
	{
		int keeper=0;
		for(int i=0; i<Bestiary.bestiary.length;i++)
		{
			for(int j=0; j<Bestiary.bestiary[i].length;j++)
			{
				for(int k=0; k<Bestiary.bestiary[i][j].length;k++)
				{
					for(int m=0; m<Bestiary.bestiary[i][j][k].length; m++)
					{
						keeper++;
					}
				}
			}
		}
		return keeper;
	}
	
	//getters and setters
	
	public int getNumEvolvesFrom()
	{
		return m_numEvolvesFrom;
	}
	public void setEvolvesFrom(MonsterType evolvesFrom)
	{
		if(m_evolvesFrom1==null)
		{
			m_numEvolvesFrom++;
		}
		m_evolvesFrom1=evolvesFrom;
	}
	public void setEvolvesFrom1(MonsterType evolvesFrom)
	{
		if(m_evolvesFrom1==null)
		{
			m_numEvolvesFrom++;
		}
		m_evolvesFrom1=evolvesFrom;
	}
	public MonsterType getEvolvesFrom1()
	{
		return m_evolvesFrom1;
	}
	public void setEvolvesFrom2(MonsterType evolvesFrom)
	{
		if(m_evolvesFrom2==null)
		{
			m_numEvolvesFrom++;
		}
		m_evolvesFrom2=evolvesFrom;
	}
	public MonsterType getEvolvesFrom2()
	{
		return m_evolvesFrom2;
	}
	public void setEvolvesFrom3(MonsterType evolvesFrom)
	{
		if(m_evolvesFrom3==null)
		{
			m_numEvolvesFrom++;
		}
		m_evolvesFrom3=evolvesFrom;
	}
	public MonsterType getEvolvesFrom3()
	{
		return(m_evolvesFrom3);
	}
	public MonsterType getEvolvesInto1()
	{
		return m_evolvesInto1;
	}
	public MonsterType getEvolvesInto2()
	{
		return m_evolvesInto2;
	}
	public MonsterType getEvolvesInto3()
	{
		return m_evolvesInto3;
	}
	public String getTypeName()
	{
		return m_typeName;
	}
	public void setTypeName(String newTypeName)
	{
		m_typeName=newTypeName;
	}
	public String getDescription()
	{
		return m_description;
	}
	public void setDescription(String newDescription)
	{
		m_description=newDescription;
	}
	public int getEvolutionStage()
	{
		return m_evolutionStage;
	}
	public void setEvolutionStage(int newEvolutionStage)
	{
		m_evolutionStage=newEvolutionStage;
	}
	public int getEvolutionType()
	{
		return m_evolutionType;
	}
	public void setEvolutionType(int newEvolutionType)
	{
		m_evolutionType=newEvolutionType;
	}
	public int getPrimaryElement()
	{
		return m_primaryElement;
	}
	public void setPrimaryElement(int newPrimaryElement)
	{
		m_primaryElement=newPrimaryElement;
	}
	public int getSecondaryElement()
	{
		return m_secondaryElement;
	}
	public void setSecondaryElement(int newSecondaryElement)
	{
		m_secondaryElement=newSecondaryElement;
	}
	public int getNumOfEvolutions()
	{
		return m_numOfEvolutions;
	}
}
