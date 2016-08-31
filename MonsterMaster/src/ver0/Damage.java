package ver0;

public class Damage 
{
	static int numStatuses=21;
	int m_phyDmg;
	int m_magDmg;
	int m_firDmg;
	int m_wtrDmg;
	int m_ertDmg;
	int m_airDmg;
	int m_lgtDmg;
	int m_drkDmg;
	int[] m_statusesDmg;
	
	public Damage()
	{
		m_phyDmg=0;
		m_magDmg=0;
		m_firDmg=0;
		m_wtrDmg=0;
		m_ertDmg=0;
		m_airDmg=0;
		m_lgtDmg=0;
		m_drkDmg=0;
		m_statusesDmg=new int[numStatuses];
		for(int i=0;i<m_statusesDmg.length;i++)
		{
			m_statusesDmg[i]=0;
		}
	}
	public Damage(int phyDmg)
	{
		m_phyDmg=phyDmg;
		m_magDmg=0;
		m_firDmg=0;
		m_wtrDmg=0;
		m_ertDmg=0;
		m_airDmg=0;
		m_lgtDmg=0;
		m_drkDmg=0;
		m_statusesDmg=new int[numStatuses];
		for(int i=0;i<m_statusesDmg.length;i++)
		{
			m_statusesDmg[i]=0;
		}
	}
}
