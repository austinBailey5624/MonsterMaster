/*
 * 		@FileName:		MonsterTree.java
 * 		@Author:		Austin Bailey
 * 		@DateBegun:		12/7/2015
 */
package ver0;

public class MonsterTree 
{
	//Monster monsters[][];
	//monsters= new Monster[3][];
	//monsters[0]= new Monster[1];
	//monsters[1]= new Monster[1];
	//monsters[2]= new Monster[3];
	MonsterTree(int assignPrimaryElement, int assignSecondaryElement, String assignTypeName)
	{
		primaryElement=assignPrimaryElement;
		secondaryElement=assignSecondaryElement;
		m_typeName=assignTypeName;
	}
	int m_MonsterNum=0;
	private int primaryElement;
	private int secondaryElement;
	MonsterType[] m_eggs;
	MonsterType[] m_infants;
	MonsterType[] m_adolescents;
	MonsterType[] m_adults;
	MonsterType[] m_elders;
	private String m_typeName;
	
	
	//getters and setters
	public String getTypeName()
	{
		return m_typeName;
	}
	public void setTypeName(String updateTypeName)
	{
		m_typeName=updateTypeName;
	}
}
