/// @description Movement Logic
if(global.CanWalk)
{
var imgspd = 1;
if(m_Lead.m_travelLeft<32)
{
	m_Lead.x-=1;
	m_Lead.m_travelLeft++;
}
else if(m_Lead.m_travelRight<32)
{
	m_Lead.x++;
	m_Lead.m_travelRight++;
}
else if(m_Lead.m_travelUp<32)
{
	m_Lead.y--;
	m_Lead.m_travelUp++;
}
else if(m_Lead.m_travelDown<32)
{
	m_Lead.y++;
	m_Lead.m_travelDown++;
}
x=m_Lead.x;
y=m_Lead.y;
if(m_Lead.x>m_Lead.xprevious)
{
	if(m_Lead.sprite_index!=m_Lead.m_RightSprite)
	m_Lead.sprite_index = m_Lead.m_RightSprite;
	m_Lead.image_speed = imgspd;

}
else if(m_Lead.x<m_Lead.xprevious)
{
	if(m_Lead.sprite_index!=m_Lead.m_LeftSprite)
	m_Lead.sprite_index=m_Lead.m_LeftSprite;
	m_Lead.image_speed=imgspd;
}	
else if(m_Lead.y<m_Lead.yprevious)
{
	if(m_Lead.sprite_index!=m_Lead.m_BackSprite)
	m_Lead.sprite_index = m_Lead.m_BackSprite;
	m_Lead.image_speed = imgspd;
}
else if(m_Lead.y>m_Lead.yprevious)
{
	if(m_Lead.sprite_index!=m_Lead.m_FrontSprite)
	m_Lead.sprite_index = m_Lead.m_FrontSprite;
	m_Lead.image_speed = imgspd;
}
else
{
	m_Lead.image_index=0;
	m_Lead.image_speed=0;
}
}