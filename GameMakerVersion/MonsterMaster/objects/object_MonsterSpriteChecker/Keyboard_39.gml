/// @description Sprite for walking right
// You can write your code in this editor
if(tilemap_get_at_pixel(tilemap,bbox_right,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom)!=0))
{
	return;
}
object_MonsterSpriteChecker.x+=3;