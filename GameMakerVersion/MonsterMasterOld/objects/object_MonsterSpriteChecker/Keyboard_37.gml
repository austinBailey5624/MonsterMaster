/// @description sprite for walking left
// You can write your code in this editor
if(tilemap_get_at_pixel(tilemap,bbox_left-16,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_left-16,bbox_bottom)!=0))
{
	return;
}
//if(sprite_index!=m_curMonsterType.m_LeftSprite)
//sprite_index=m_curMonsterType.m_LeftSprite;
//object_MonsterSpriteChecker.x-=3;
if(m_travelLeft>=16&&m_travelRight>=16&&m_travelUp>=16&&m_travelDown>=16)
{
	m_travelLeft = 0;
}