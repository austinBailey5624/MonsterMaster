/// Animation

var imgspd = .5;
if(x>xprevious)
{
	if(sprite_index!=GuyRight)
	sprite_index = GuyRight;
	image_speed = imgspd;

}
else if(x<xprevious)
{
	if(sprite_index!=GuyLeft)
	sprite_index=GuyLeft;
	image_speed=imgspd;
}	
else if(y>yprevious)
{
	if(sprite_index!=GuyForwards)
	sprite_index=GuyForwards;
	image_speed=imgspd;
}
else if(y<yprevious)
{
	if(sprite_index!=GuyForwards)
	sprite_index = GuyBack;
	image_speed=imgspd;
}

else
{
	image_index=0;
	image_speed=0;
}