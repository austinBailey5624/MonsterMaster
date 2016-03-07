/*
 * 		@fileName		Monster.java
 * 		@Author			AustinBailey
 * 		@DateBegun		12/6/2015
 */
package ver0;
public class Monster 
{
	//constructors
	public Monster(String name, int primaryElement, int secondaryElement, MonsterType type)
	{
		m_name=name;
		m_primaryElement=primaryElement;
		m_secondaryElement=secondaryElement;
		m_type=type;
	}
	public Monster(Monster father, Monster mother)
	{
		if(father.m_generation>mother.m_generation)
		{
			m_generation=father.m_generation;
		}
		else 
		{
			m_generation=mother.m_generation;
		}
		
		if(father.m_primaryElement==mother.m_primaryElement&&father.m_secondaryElement==mother.m_secondaryElement)
		{
			m_primaryElement=father.m_primaryElement;
			m_secondaryElement=father.m_secondaryElement;
		}
		m_primaryElement=father.m_primaryElement;
		m_secondaryElement=mother.m_primaryElement;
	}
	//member variables
	private int m_level;
	private int m_generation;
	private Monster m_mother;
	private Monster m_father;
	private String m_name;
	private MonsterType m_type;
	private int m_primaryElement;//Want to be const but cant get syntax to work
	private int m_secondaryElement;//same as above
	private int m_hpMax;//health points, primarily based on vitality, secondarily on strength
	private int m_hpCur;//current HP
	private int m_mpMax;//magic points primarily based on intelligence, then secondarily on (light+dark)/2
	private int m_mpCur;
	private int m_str;//strength related to fire
	private int m_int;//intelligence related to water
	private int m_vit;//vitality related to earth
	private int m_agl;//agility related to wind
	private int m_acc;//accuracy related to light
	private int m_dog;//reistance realted to dark
	
	//public setters and getters
	public int getLevel()
	{
		return m_level;
	}
	public void setLevel(int updateLevel)
	{
		m_level=updateLevel;
	}
	public int getGeneration()
	{
		return m_generation;
	}
	public void setGeneration(int updateGeneration)
	{
		m_generation=updateGeneration;
	}
	public Monster getMother()
	{
		return m_mother;
	}
	public void setMother(Monster updateMother)
	{
		m_mother=updateMother;
	}
	public Monster getFather()
	{
		return m_father;
	}
	public void setFather(Monster updateFather)
	{
		m_father=updateFather;
	}
	public String getName()
	{
		return m_name;
	}
	public void setName(String updateName)
	{
		m_name =updateName;
	}
	public MonsterType getMonsterType()
	{
		return m_type;
	}
	public void setMonsterType(MonsterType updateMonsterType)
	{
		m_type=updateMonsterType;
	}
	//No getters or setters for primary or secondary element because I don't want them to change.
	public int getHpMax()
	{
		return m_hpMax;
	}
	public void setHpMax(int val)
	{
		m_hpMax=val;
	}
	public int getHpCur()
	{
		return m_hpCur;
	}
	public void setHpCur(int val)
	{
		m_hpCur=val;
	}
	public int getMpMax()
	{
		return m_mpMax;
	}
	public void setMpMax(int val)
	{
		m_mpMax=val;
	}
	public int getMpCur()
	{
		return m_mpCur;
	}
	public void setMpCur(int val)
	{
		m_mpCur=val;
	}
	public int getStr()
	{
		return m_str;
	}
	public void setStr(int val)
	{
		m_str=val;
	}
	public int getInt()
	{
		return m_int;
	}
	public void setInt(int val)
	{
		m_int=val;
	}
	public int getVit()
	{
		return m_vit;
	}
	public void setVit(int val)
	{
		m_vit=val;
	}
	public int getAgl()
	{
		return m_agl;
	}
	public void setAgl(int val)
	{
		m_agl=val;
	}
	public int getAcc()
	{
		return m_acc;
	}
	public void setAcc(int val)
	{
		m_acc=val;
	}
	public int getdog()
	{
		return m_dog;
	}
	public void setDog(int val)
	{
		m_dog=val;
	}
}
