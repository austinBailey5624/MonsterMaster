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
}*//*
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
}*/
if(m_Lead.m_travelLeft<16)
{
	m_Lead.x-=1;
	m_Lead.m_travelLeft++;
}
else if(m_Lead.m_travelRight<16)
{
	m_Lead.x++;
	m_Lead.m_travelRight++;
}
else if(m_Lead.m_travelUp<16)
{
	m_Lead.y--;
	m_Lead.m_travelUp++;
}
else if(m_Lead.m_travelDown<16)
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