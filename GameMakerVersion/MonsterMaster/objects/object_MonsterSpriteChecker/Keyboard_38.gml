/// @description sprite for walking forwards
// You can write your code in this editor
if(tilemap_get_at_pixel(tilemap,bbox_left,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom)!=0))
{
	return;
}
object_MonsterSpriteChecker.y-=3;