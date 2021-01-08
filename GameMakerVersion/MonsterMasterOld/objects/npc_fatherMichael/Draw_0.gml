/// @description Draw Michael
if(m_directionFacing == 1)//up
{
	draw_sprite(m_BackSprite,2,x,y);
}
else if(m_directionFacing == 2)//Right
{
	draw_sprite(m_RightSprite,2,x,y);
}
else if(m_directionFacing == 3)//forwards/down
{
	draw_sprite(m_FrontSprite,2,x,y);
}
else if(m_directionFacing == 4)//left
{
	draw_sprite(m_LeftSprite,2,x,y);
}