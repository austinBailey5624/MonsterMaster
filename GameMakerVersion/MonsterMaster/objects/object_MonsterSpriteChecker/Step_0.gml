/// @description Insert description here
// You can write your code in this editor
var imgspd = .5;
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
	image_speed=2.5*imgspd;
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
	image_speed = 2.5*imgspd;
}

else
{
	image_index=0;
	image_speed=0;
}