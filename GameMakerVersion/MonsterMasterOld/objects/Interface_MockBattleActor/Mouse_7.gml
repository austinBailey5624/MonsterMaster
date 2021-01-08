/// @description Insert description here
// You can write your code in this editor
if(m_isAlly)
{
	if(m_magicCur==0)//if there is no mana to convert to health
	{
		return;
	}//if only some mana can be converted
	if(m_magicCur<object_BattleMock_MinigameManager.m_clickPower*2)
	{
		m_healthCur+=ceil(m_magicCur/2);
		m_magicCur=0;
	}
	else
	{
		m_healthCur+=object_BattleMock_MinigameManager.m_clickPower;
		m_magicCur-=object_BattleMock_MinigameManager.m_clickPower*2;
	}
	
	if(m_healthCur>m_healthMax)
	{
		m_healthCur=m_healthMax;
	}
}
else
{
	m_healthCur-=object_BattleMock_MinigameManager.m_clickPower;
}