/// @description Logic for moving party down
if(tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_right,m_Lead.bbox_bottom+32)!=0 || (tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_left,m_Lead.bbox_bottom+32)!=0) || !position_empty(x, y+32))
{
	return;
}
if(m_Lead.m_travelLeft>=32&&m_Lead.m_travelRight>=32&&m_Lead.m_travelUp>=32&&m_Lead.m_travelDown>=32)
{
	m_Lead.m_travelDown=0;
}