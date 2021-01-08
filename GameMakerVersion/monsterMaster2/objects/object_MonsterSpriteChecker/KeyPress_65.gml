/// @description Switch Monster Costume back
// You can write your code in this editor
if(m_whichSubelement==0)//Pyro Subelement
{
	if(m_whichMonster==0)//old is Flarial, goto PyroAtronach
	{
		m_curMonsterType = monsterType_PyroAtronach;
		m_whichMonster = 12;
	}
	else if(m_whichMonster==1)//old is Pyrus goto Flarial
	{
		m_curMonsterType = monsterType_Flarial;	
	}
	else if(m_whichMonster==2)//old is Flarpup goto Pyrus
	{
		m_curMonsterType = monsterType_Pyrus;
	}
	else if(m_whichMonster==3)//old is PyroSymbol, goto Flarpup
	{
		m_curMonsterType = monsterType_Flarpup;
	}
	else if(m_whichMonster == 4)
	{
		m_curMonsterType = monsterType_PyroSymbol;
	}
	else if(m_whichMonster == 5)
	{
		m_curMonsterType = monsterType_Pyos;
	}
	else if(m_whichMonster == 6)
	{
		m_curMonsterType = monsterType_Comet;
	}
	else if(m_whichMonster == 7)
	{
		m_curMonsterType = monsterType_FireOpal;
	}
	else  if(m_whichMonster == 8)
	{
		m_curMonsterType = monsterType_PyroElemental;
	}
	else if(m_whichMonster == 9)
	{
		m_curMonsterType = monsterType_Pyres;
	}
	else if(m_whichMonster == 10)
	{
		m_curMonsterType = monsterType_Bolide;
	}
	else if(m_whichMonster == 11)
	{
		m_curMonsterType = monsterType_Ruby;
	}
	else
	{
		m_whichMonster=1;
		m_curMonsterType = monsterType_Flarial;
	}	
	m_whichMonster--;
}
else if(m_whichSubelement==1)
{
	if(m_whichMonster==0)//Old is Philammon, new is Vagrus
	{
		m_curMonsterType = monsterType_Vagrus;	
	}
	else if(m_whichMonster==1)//old is Crerops
	{
		m_curMonsterType = monsterType_Philammon;	
	}
	else if(m_whichMonster==2)//old is Corynetes
	{
		m_curMonsterType = monsterType_Crerops;
	}
	else if(m_whichMonster==3)
	{
		m_curMonsterType = monsterType_Corynetes;
	}
	else if(m_whichMonster==4)
	{
		m_curMonsterType = monsterType_Philottus;
	}
	else if(m_whichMonster==5)
	{
		m_curMonsterType = monsterType_Cercyon;
	}
	else if(m_whichMonster==6)
	{
		m_curMonsterType = monsterType_Vulcanous;
	}
	else
	{
		m_whichMonster=1;
		m_curMonsterType = monsterType_Philammon;
	}
	m_whichMonster--;
}
else if(m_whichSubelement ==2)//Dino
{
	m_whichMonster--;
	if(m_whichMonster<=-1)
	{
		m_whichMonster=9;//wrap around
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
