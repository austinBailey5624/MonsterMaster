/// @description Logic for moving party Down
if(tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_left,m_Lead.bbox_top-16)!=0 || (tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_right,m_Lead.bbox_top-16)!=0))
{
	return;
}
if(m_Lead.m_travelLeft>=16&&m_Lead.m_travelRight>=16&&m_Lead.m_travelUp>=16&&m_Lead.m_travelDown>=16)
{
	m_Lead.m_travelUp = 0;
}