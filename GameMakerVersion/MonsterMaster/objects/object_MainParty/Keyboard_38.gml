/// @description Insert description here
// You can write your code in this editor
if(tilemap_get_at_pixel(collisionLayer,m_lead.bbox_left,m_lead.bbox_top-16)!=0 || (tilemap_get_at_pixel(collisionLayer,m_lead.bbox_right,m_lead.bbox_top-16)!=0))
{
	return;
}
//object_MonsterSpriteChecker.y-=3;
if(m_lead.m_travelLeft>=16&&m_lead.m_travelRight>=16&&m_lead.m_travelUp>=16&&m_lead.m_travelDown>=16)
{
	m_lead.m_travelUp = 0;
}