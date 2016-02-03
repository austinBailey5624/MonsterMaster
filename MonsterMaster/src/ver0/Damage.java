package ver0;

public class Damage 
{
	static int numStatuses=21;
	int[] m_normalDmg;
	int[] m_statusesDmg;
	
	public Damage()
	{
		m_normalDmg = new int[8];
		for(int i=0;i<m_normalDmg.length;i++)
		{
			m_normalDmg[i]=0;
		}
		m_statusesDmg=new int[numStatuses];
		for(int i=0;i<m_statusesDmg.length;i++)
		{
			m_statusesDmg[i]=0;
		}
	}
}
