//@description Sprite for travelling left
if(tilemap_get_at_pixel(collisionLayer,m_lead.bbox_left-16,m_lead.bbox_top)!=0 || (tilemap_get_at_pixel(collisionLayer,m_lead.bbox_left-16,m_lead.bbox_bottom)!=0))
{
	return;
}

if(m_lead.m_travelLeft>=16&&m_lead.m_travelRight>=16&&m_lead.m_travelUp>=16&&m_lead.m_travelDown>=16)
{
	m_lead.m_travelLeft = 0;
}
