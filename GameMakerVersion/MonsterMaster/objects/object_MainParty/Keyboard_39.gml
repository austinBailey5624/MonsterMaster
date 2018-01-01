/// @description Sprite Switching and follow following
// You can write your code in this editor
if(tilemap_get_at_pixel(collisionLayer,m_lead.bbox_right+16,m_lead.bbox_top)!=0 || (tilemap_get_at_pixel(collisionLayer,m_lead.bbox_right+16,m_lead.bbox_bottom)!=0))
{
	return;
}
//object_MonsterSpriteChecker.x+=3;
if(m_lead.m_travelLeft>=16&&m_lead.m_travelRight>=16&&m_lead.m_travelUp>=16&&m_lead.m_travelDown>=16)
{
	m_lead.m_travelRight=0;	
}