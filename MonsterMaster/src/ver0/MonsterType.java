/*
 * 		@FileName:		MonsterType.java
 * 		@Author:		Austin Bailey
 * 		@DateBegun:		12/7/2015
 */
package ver0;

public class MonsterType 
{
	static int monsterTypeNum=0;
	//constructors
	MonsterType(String typeName, int primaryElement, int secondaryElement, int evolutionStage, int evolutionType)
	{
		m_typeName = typeName;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
		monsterTypeNum++;
	}
	
	MonsterType(String typeName, int primaryElement, int secondaryElement, int evolutionStage, int evolutionType, String description)
	{
		m_typeName=typeName;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
		m_description=description;
		m_evolvesInto1=null;
		m_evolvesInto2=null;
		m_evolvesInto3=null;
		m_numOfEvolutions=0;
		monsterTypeNum++;
	}
	MonsterType(String typeName, int primaryElement, int secondaryElement, int evolutionStage, int evolutionType, String description, MonsterType evolvesInto1)
	{
		m_typeName=typeName;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
		m_description=description;
		m_evolvesInto1=evolvesInto1;
		m_evolvesInto2=null;
		m_evolvesInto3=null;
		m_numOfEvolutions=1;
		monsterTypeNum++;
	}
	MonsterType(String typeName,int primaryElement, int secondaryElement, int evolutionStage, int evolutionType, String description, MonsterType evolvesInto1, MonsterType evolvesInto2)
	{
		m_typeName=typeName;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
		m_description=description;
		m_evolvesInto1=evolvesInto1;
		m_evolvesInto2=evolvesInto2;
		m_evolvesInto3=null;
		m_numOfEvolutions=2;
		monsterTypeNum++;
	}
	MonsterType(String typeName,int primaryElement, int secondaryElement,int evolutionStage, int evolutionType, String description, MonsterType evolvesInto1, MonsterType evolvesInto2, MonsterType evolvesInto3)
	{
		m_typeName=typeName;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_evolutionStage=evolutionStage;
		m_evolutionType=evolutionType;
		m_description=description;
		m_evolvesInto1=evolvesInto1;
		m_evolvesInto2=evolvesInto2;
		m_evolvesInto3=evolvesInto3;
		m_numOfEvolutions=3;
		monsterTypeNum++;
	}
	
	
	//memberVariables
	private int m_numOfEvolutions;
	private MonsterType m_evolvesInto1;
	private MonsterType m_evolvesInto2;
	private MonsterType m_evolvesInto3;
	private String m_typeName;
	private String m_description;
	private int m_evolutionStage;
	private int m_evolutionType;
	private int m_primaryElement;//Note, Beast has this too... but i think itll be useful later
	private int m_secondaryElement;//Note same as above
	
	//getters and setters
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
}
