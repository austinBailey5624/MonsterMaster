/// @description Insert description here
// You can write your code in this editor
//if(tilemap_get_at_pixel(tilemap,bbox_left,bbox_top-3)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right,bbox_top-3)!=0))
if(tilemap_get_at_pixel(tilemap,bbox_left,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom)!=0))
{
//	y=y-(y mod 16);	
	return;
}
object_Guy.y-=3;