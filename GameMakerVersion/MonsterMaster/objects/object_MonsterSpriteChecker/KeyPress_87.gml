/// @description Change subElement
m_whichMonster=0;
if(m_whichSubelement==0)
{
	m_whichSubelement =1;
	m_curMonsterType = monsterType_Philammon;
	return;
}
else if(m_whichSubelement == 1)
{
		m_whichSubelement =0;
	m_curMonsterType = monsterType_Flarial;
	return;
}
