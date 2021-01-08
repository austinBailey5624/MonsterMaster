/// @description Change subelement down
m_whichSubelement--;//step towards the beginning of the list
var numSubElements = 3;
if(m_whichSubelement<=-1)//if weve stepped to before the beginning of the list
{
	m_whichSubelement = numSubElements-1;//wrap around to the end (-1 since zero indexed)
}

m_whichMonster=0;//makes sure we're at the beginning of the new list


if(m_whichSubelement==0)//pyro, start at Flarial
{
	m_curMonsterType = monsterType_Flarial;
	return;
}
if(m_whichSubelement==1)//Lava, start at Philammon
{
	m_curMonsterType = monsterType_Philammon;	
	return;
}
if(m_whichSubelement==2)//Dino, start at Salamander
{
	m_curMonsterType = monsterType_Salamander;
	return;
}
//if(m_whichSubelement ==1)//old lava back to pyro
//{
//	m_whichSubelement =0;
//	m_curMonsterType = monsterType_Flarial;
//	return;
//}
//if(m_whichSubelement == 0)//old pyro back to Dino
//{
//	m_whichSubelement =2;
//	m_curMonsterType = monsterType_Philammon;
//	return;
//}