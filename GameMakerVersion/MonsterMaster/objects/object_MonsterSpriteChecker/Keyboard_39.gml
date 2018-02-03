/// @description Sprite for walking right
// You can write your code in this editor
if(tilemap_get_at_pixel(tilemap,bbox_right+16,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right+16,bbox_bottom)!=0))
{
	return;
}
//object_MonsterSpriteChecker.x+=3;
if(m_travelLeft>=16&&m_travelRight>=16&&m_travelUp>=16&&m_travelDown>=16)
{
	m_travelRight=0;	
}