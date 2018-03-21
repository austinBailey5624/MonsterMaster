/// @description Insert description here
var imgspd = 1;
/*
if(m_lead.m_travelLeft<16)
{
	m_lead.x-=2;
	m_lead.m_travelLeft+=2;
}
if(m_lead.m_travelRight<16)
{
	m_lead.x+=2;
	m_lead.m_travelRight+=2;
}
if(m_lead.m_travelUp<16)
{
	m_lead.y-=2;
	m_lead.m_travelUp+=2;
}
if(m_lead.m_travelDown<16)
{
	m_lead.y+=2;
	m_lead.m_travelDown+=2;
}*/
if(m_lead.m_travelLeft<16)
{
	m_lead.x-=1;
	m_lead.m_travelLeft++;
}
else if(m_lead.m_travelRight<16)
{
	m_lead.x++;
	m_lead.m_travelRight++;
}
else if(m_lead.m_travelUp<16)
{
	m_lead.y--;
	m_lead.m_travelUp++;
}
else if(m_lead.m_travelDown<16)
{
	m_lead.y++;
	m_lead.m_travelDown++;
}
x=m_lead.x;
y=m_lead.y;
if(m_lead.x>m_lead.xprevious)
{
	if(m_lead.sprite_index!=m_lead.m_RightSprite)
	m_lead.sprite_index = m_lead.m_RightSprite;
	m_lead.image_speed = imgspd;

}
else if(m_lead.x<m_lead.xprevious)
{
	if(m_lead.sprite_index!=m_lead.m_LeftSprite)
	m_lead.sprite_index=m_lead.m_LeftSprite;
	m_lead.image_speed=imgspd;
}	
else if(m_lead.y<m_lead.yprevious)
{
	if(m_lead.sprite_index!=m_lead.m_BackSprite)
	m_lead.sprite_index = m_lead.m_BackSprite;
	m_lead.image_speed = imgspd;
}
else if(m_lead.y>m_lead.yprevious)
{
	if(m_lead.sprite_index!=m_lead.m_FrontSprite)
	m_lead.sprite_index = m_lead.m_FrontSprite;
	m_lead.image_speed = imgspd;
}
else
{
	m_lead.image_index=0;
	m_lead.image_speed=0;
}