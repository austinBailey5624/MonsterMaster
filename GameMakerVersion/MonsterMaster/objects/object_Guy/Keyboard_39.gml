/// @description Insert description here
// You can write your code in this editor
if(tilemap_get_at_pixel(tilemap,bbox_right,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom)!=0))
{
	x=x-(x mod 16);//+15;	
	return;
}
object_Guy.x+=3;