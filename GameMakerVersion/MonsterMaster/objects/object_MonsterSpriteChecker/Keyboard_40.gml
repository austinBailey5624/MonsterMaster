/// @description sprite for walking down
// You can write your code in this editor
if(tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom+16)!=0 || (tilemap_get_at_pixel(tilemap,bbox_left,bbox_bottom+16)!=0))
{
	return;
}
//object_MonsterSpriteChecker.y+=3;
if(m_travelLeft>=16&&m_travelRight>=16&&m_travelUp>=16&&m_travelDown>=16)
{
	m_travelDown=0;
}