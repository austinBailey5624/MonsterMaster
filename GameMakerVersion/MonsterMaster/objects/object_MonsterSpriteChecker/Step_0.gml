/// @description Insert description here
// You can write your code in this editor
var imgspd = 1;
if(m_travelLeft<16)
{
	object_MonsterSpriteChecker.x-=2;
	m_travelLeft+=2;
}
if(m_travelRight<16)
{
	object_MonsterSpriteChecker.x+=2;
	m_travelRight+=2;
}
if(m_travelUp<16)
{
	object_MonsterSpriteChecker.y-=2;
	m_travelUp+=2;
}
if(m_travelDown<16)
{
	object_MonsterSpriteChecker.y+=2;
	m_travelDown+=2;
}
if(x>xprevious)
{
	if(sprite_index!=m_curMonsterType.m_RightSprite)
	sprite_index = m_curMonsterType.m_RightSprite;
	image_speed = imgspd;

}
else if(x<xprevious)
{
	if(sprite_index!=m_curMonsterType.m_LeftSprite)
	sprite_index=m_curMonsterType.m_LeftSprite;
	image_speed=imgspd;
}	
else if(y<yprevious)
{
	if(sprite_index!=m_curMonsterType.m_BackSprite)
	sprite_index = m_curMonsterType.m_BackSprite;
	image_speed = imgspd;
}
else if(y>yprevious)
{
	if(sprite_index!=m_curMonsterType.m_FrontSprite)
	sprite_index = m_curMonsterType.m_FrontSprite;
	image_speed = imgspd;
}

else
{
	image_index=0;
	image_speed=0;
}