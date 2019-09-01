//@description Sprite for travelling left
if(tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_left-16,m_Lead.bbox_top)!=0 || (tilemap_get_at_pixel(collisionLayer,m_Lead.bbox_left-16,m_Lead.bbox_bottom)!=0))
{
	return;
}

if(m_Lead.m_travelLeft>=16&&m_Lead.m_travelRight>=16&&m_Lead.m_travelUp>=16&&m_Lead.m_travelDown>=16)
{
	m_Lead.m_travelLeft = 0;
}
