/// @description Switch Monster Costume
// You can write your code in this editor
if(m_whichSubelement == 0)
{
	if(m_whichMonster == 0)//old is Flarial
	{
		m_curMonsterType = monsterType_Pyrus;
	}
	else if(m_whichMonster ==1)//old is Pyrus
	{
		m_curMonsterType = monsterType_Flarpup;	
	}
	else if(m_whichMonster == 2)//old is Flarpup
	{
		m_curMonsterType = monsterType_PyroSymbol;
	}
	else if(m_whichMonster == 3)//old is PyroSymbol
	{
		m_curMonsterType = monsterType_Pyos;
	}
	else if(m_whichMonster == 4)//old is Pyos
	{
		m_curMonsterType = monsterType_Comet;
	}
	else if(m_whichMonster == 5)
	{
		m_curMonsterType = monsterType_FireOpal;
	}
	else if(m_whichMonster == 6)
	{
		m_curMonsterType = monsterType_PyroElemental;
	}
	else if(m_whichMonster == 7)
	{
		m_curMonsterType = monsterType_Pyres;
	}
	else if(m_whichMonster == 8)
	{
		m_curMonsterType = monsterType_Bolide;
	}
	else if(m_whichMonster == 9)
	{
		m_curMonsterType = monsterType_Ruby;
	}
	else if(m_whichMonster == 10)
	{
		m_curMonsterType = monsterType_PyroAtronach;
	}
	else
	{
		m_whichMonster = -1;
		m_curMonsterType = monsterType_Flarial
	}		
	m_whichMonster++;
}

var imgspd = 1;
if(x>xprevious)
{
	sprite_index = m_curMonsterType.m_RightSprite;
	image_speed = imgspd;

}
else if(x<xprevious)
{
	sprite_index=m_curMonsterType.m_LeftSprite;
	image_speed=imgspd;
}	
else if(y<yprevious)
{
	sprite_index = m_curMonsterType.m_BackSprite;
	image_speed = imgspd;
}
else if(y>yprevious)
{
	sprite_index = m_curMonsterType.m_FrontSprite;
	image_speed = imgspd;
}

else
{
	image_index=0;
	image_speed=0;
}