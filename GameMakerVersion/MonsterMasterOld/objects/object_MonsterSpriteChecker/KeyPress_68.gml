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
		m_curMonsterType = monsterType_Flarial;
	}		
	m_whichMonster++;
}
else if(m_whichSubelement==1)
{
	if(m_whichMonster==0)//old is Philammon
	{
		m_curMonsterType = monsterType_Crerops;
	}
	else if(m_whichMonster==1)
	{
		m_curMonsterType = monsterType_Corynetes;
	}
	else if(m_whichMonster==2)
	{
		m_curMonsterType = monsterType_Philottus;
	}
	else if(m_whichMonster==3)
	{
		m_curMonsterType = monsterType_Cercyon;
	}
	else if(m_whichMonster==4)
	{
		m_curMonsterType = monsterType_Vulcanous;
	}
	else if(m_whichMonster==5)
	{
		m_curMonsterType = monsterType_Vagrus;
	}
	else
	{
		m_whichMonster=-1;
		m_curMonsterType = monsterType_Philammon;
	}
	m_whichMonster++;
}
else if(m_whichSubelement==2)//Dino
{
	m_whichMonster++;
	
	if(m_whichMonster>=10)
	{
		m_whichMonster=0;	
	}
	
	if(m_whichMonster==0)//Salamander
	{
		m_curMonsterType = monsterType_Salamander;
	}
	else if(m_whichMonster==1)//Raptor
	{
		m_curMonsterType = monsterType_Raptor;
	}
	else if(m_whichMonster==2)//Winger
	{
		m_curMonsterType = monsterType_Winger;
	}
	else if(m_whichMonster==3)//Herbisaur
	{
		m_curMonsterType = monsterType_Herbisaur;
	}
	else if(m_whichMonster==4)//Tyrant
	{
		m_curMonsterType = monsterType_Tyrant;
	}
	else if(m_whichMonster==5)//SteelWinger
	{
		m_curMonsterType = monsterType_SteelWinger;
	}
	else if(m_whichMonster==6)//Spikevorsaur
	{
		m_curMonsterType = monsterType_Spikevorsaur;
	}
	else if(m_whichMonster==7)//GreatWhiteTyrant;
	{
		m_curMonsterType = monsterType_GreatWhiteTyrant;
	}
	else if(m_whichMonster==8)//EdgeWinger
	{
		m_curMonsterType = monsterType_EdgeWinger;
	}
	else if(m_whichMonster==9)//BroncheoSpikeSaur
	{
		m_curMonsterType = monsterType_Broncheospikesaur;
	}
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