/// @description Logic for moving party right
if(tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_right+32,m_Lead.bbox_top)!=0 || (tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_right+32,m_Lead.bbox_bottom)!=0) || !position_empty(x+32, y))
{
	return;
}
if(m_Lead.m_travelLeft>=32&&m_Lead.m_travelRight>=32&&m_Lead.m_travelUp>=32&&m_Lead.m_travelDown>=32)
{
	m_Lead.m_travelRight=0;	
}