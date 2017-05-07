/// Animation
if(x>xprevious)
{
	if(sprite_index!=GuyRight)
	sprite_index = GuyRight;
	image_speed = .15;
}
else if(x<xprevious)
{
	if(sprite_index!=GuyLeft)
	sprite_index=GuyLeft;
	image_speed=.15;
}	
else if(y>yprevious)
{
	if(sprite_index!=GuyForwards)
	sprite_index=GuyForwards;
	image_speed=.15;
}
else if(y<yprevious)
{
	if(sprite_index!=GuyForwards)
	sprite_index = GuyBack;
	image_speed=.15;
}

else
{
	image_index=0;
	image_speed=0;
}