/// @description Change subElement
//goes 'up' through the subelement tree
m_whichSubelement ++;//step towards the end of the list
var numSubElements = 3;
if( m_whichSubelement >= numSubElements)//if we're at the end of the list
{
	m_whichSubelement = 0;//go back to the beginning
}
m_whichMonster=0;

if(m_whichSubelement==0)//pyro
{
	m_curMonsterType = 	monsterType_Flarial;
	return;
}
if(m_whichSubelement==1)//lava
{
	m_curMonsterType = monsterType_Philammon;
	return;
}
if(m_whichSubelement==2)//Dino
{
	m_curMonsterType = monsterType_Salamander;	
	return;
}

/*if(m_whichSubelement==0)//old pyro goto lava
{
	m_whichSubelement =1;
	m_curMonsterType = monsterType_Philammon;
	return;
}
else if(m_whichSubelement == 1)//old lava goto dino
{
	m_whichSubelement =2;
	m_curMonsterType = monsterType_Salamander;
	return;
}
else if(m_whichSubelement==2)//edge-back to lava
{
	m_whichSubelement = 0;
	m_curMonsterType = monsterType_Flarial;
	return;
}*/

