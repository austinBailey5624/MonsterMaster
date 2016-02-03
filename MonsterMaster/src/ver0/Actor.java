package ver0;

public class Actor 
{
	private String m_name;		//holds the name of the actor
	
	private int m_hpTrueMax;	//holds the actual Maximum Hp (health points)
	private int m_hpMax;		//holds the max that can be altered in battle
	private int m_hpCur;		//holds the current hp, if <=0 needs to die
	private int m_mpTrueMax;	//holds the actual Maximum Mp (Magic Points)
	private int m_mpMax;		//holds the max that can be altered in battle
	private int m_mpCur;		//holds the current mp that can be used in battle
	
	private int m_level;		//holds the level of the character
	//implement using 8 elements
	public int[] m_thornsDmg;	//holds the amount of damage the enemy takes when attacking
	public int[] m_status;		//holds the statuses of the Actor
	public int m_numPhysicalAttacks;//used in determining how monsters evolve
	public int m_numMagicalAttacks;//used in determining how monsters evolve
	
	//constructors
	
	public void takeDamage(Damage damage) //TODO: fix this later
	{
		for(int i=0;i<damage.m_normalDmg.length;i++)
		{
			m_hpCur-=damage.m_normalDmg[i];
		}
	}
	
	//getters
	/**
	 * @param(pre):		Actor object exists with initialized m_hpTrueMax
	 * @param(post):	does not change member variables
	 * @return:			int m_hpTrueMax
	 */
	public int getHpTrueMax()
	{
		return m_hpTrueMax;
	}
	
	/**
	 * @param(pre):		Actor object exists with initialized m_hpTrueMax
	 * @param(post):	does not change member variables
	 * @return:			int m_hpMax
	 */
	public int getHpMax()
	{
		return m_hpMax;
	}
	
	/**
	 * @param(pre):		Actor object exists with initialized m_hpTrueMax
	 * @param(post):	does not change member variables
	 * @return:			int m_hpCur
	 */
	public int getHpCur()
	{
		return m_hpCur;
	}
	
	/**
	 * @param(pre):		Actor object exists with initialized m_hpTrueMax
	 * @param(post):	does not change member variables
	 * @return:			int m_mpTrueMax
	 */
	public int getMpTrueMax()
	{
		return m_mpTrueMax;
	}
	
	/**
	 * @param(pre):		Actor object exists with initialized m_hpTrueMax
	 * @param(post):	does not change member variables
	 * @return:			int m_mpMax
	 */
	public int getMpMax()
	{
		return m_mpMax;
	}
	
	/**
	 * @param(pre):		Actor object exists with initialized m_hpTrueMax
	 * @param(post):	does not change member variables
	 * @return:			int m_mpCur
	 */
	public int getMpCur()
	{
		return m_mpCur;
	}
	
	/**
	 * @param(pre):		Actor object exists with initalized value m_name
	 * @param(post):	does not change member variables
	 * @return:			String m_name
	 */
	public String getName()
	{
		return m_name;
	}
	
	/**
	 * @param(pre):		Actor object exists with initialized value m_name
	 * @param(post):	does not change member variables
	 * @return:			int m_level
	 */
	public int getLevel()
	{
		return m_level;
	}
	
	
	
	//setters
	
	/**
	 * @param(pre):		Actor object exists
	 * @param(post):	sets m_hpTrueMax to parameter hpTrueMax
	 * @return:			void
	 */
	public void setHpTrueMax(int hpTrueMax)
	{
		m_hpTrueMax=hpTrueMax;
	}
	
	/**
	 * @param(pre):		Actor object exists
	 * @param(post):	sets m_hpMax to parameter hpMax
	 * @return:			void
	 */
	public void setHpMax(int hpMax)
	{
		m_hpMax=hpMax;
	}
	
	/**
	 * @param(pre):		Actor object exists
	 * @param(post):	sets m_curHp to paraeter curHp
	 * @return:			void
	 */
	public void setHpCur(int hpCur)
	{
		m_hpCur=hpCur;
	}
	
	/**
	 * @param(pre):		Actor object exists
	 * @param(post):	sets m_mpTrueMax to parameter mpTrueMax
	 * @return:			void
	 */
	public void setMpTrueMax(int mpTrueMax)
	{
		m_mpTrueMax=mpTrueMax;
	}
	
	/**
	 * @param(pre):		Actor object exists
	 * @param(post):	sets m_mpMax to parameter mpMax
	 * @return:			void
	 */
	public void setMpMax(int mpMax)
	{
		m_mpMax=mpMax;
	}
	
	/**
	 * @param(pre):		Actor object exists
	 * @param(post):	sets m_mpCur to parameter mpCur
	 * @return:			void
	 */
	public void setMpCur(int mpCur)
	{
		m_mpCur=mpCur;
	}
	
	/**
	 * @param(pre):		Actor object exists
	 * @param(post):	sets m_Level to parameter level
	 * @return:			void
	 */
	public void setLevel(int level)
	{
		m_level=level;
	}


}
