/// @description Insert description here
// You can write your code in this editor
//if(tilemap_get_at_pixel(tilemap,bbox_right+3,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right+3,bbox_bottom)!=0))
//if(tilemap_get_at_pixel(tilemap,bbox_left+16,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_left+16,bbox_bottom)!=0))
//if we're colliding, do nothing
if(tilemap_get_at_pixel(tilemap,bbox_right,bbox_top)!=0 || (tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom)!=0))
{
	//x=x-(x mod 16);//+15;	
	return;
}
//else travel by 3 pixels
object_Guy.x+=3;