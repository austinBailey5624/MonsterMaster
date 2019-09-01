/// @description Sprite Switching and follow following
// You can write your code in this editor
if(tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_right+16,m_Lead.bbox_top)!=0 || (tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_right+16,m_Lead.bbox_bottom)!=0))
{
	return;
}
//object_MonsterSpriteChecker.x+=3;
if(m_Lead.m_travelLeft>=16&&m_Lead.m_travelRight>=16&&m_Lead.m_travelUp>=16&&m_Lead.m_travelDown>=16)
{
	m_Lead.m_travelRight=0;	
}