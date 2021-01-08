/// @description Insert description here
// You can write your code in this editor
if(tilemap_get_at_pixel(tilemap,bbox_left,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_left,bbox_bottom)!=0))
//if(tilemap_get_at_pixel(tilemap,bbox_left-3,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_left-3,bbox_bottom)!=0))
{
//	x=x-(x mod 16);	
	return;
}
object_Guy.x-=3;