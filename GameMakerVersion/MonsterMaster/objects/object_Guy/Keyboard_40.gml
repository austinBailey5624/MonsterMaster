/// @description Insert description here
// You can write your code in this editor
//Activates the animation for walking down
//if(tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom+3)!=0 || (tilemap_get_at_pixel(tilemap,bbox_left,bbox_bottom+3)!=0))
//if we're colliding,
if(tilemap_get_at_pixel(tilemap,bbox_right,bbox_bottom)!=0 || (tilemap_get_at_pixel(tilemap,bbox_left,bbox_bottom)!=0))
{
//	y=y-(y mod 16);//+15;
	//dont change y just return
	return;
}
object_Guy.y+=3;
