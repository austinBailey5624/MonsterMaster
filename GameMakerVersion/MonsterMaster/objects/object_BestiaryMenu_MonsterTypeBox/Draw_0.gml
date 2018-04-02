/// @description Draw the background

//drawBackgorund
if(m_isSelected)
{
	draw_sprite(m_mouseOverSprite,image_index,x,y);
}
else
{
	draw_sprite(m_defaultSprite,image_index,x,y);
}

//drawMonsterType
if(m_monsterType!=noone)
{
	draw_sprite_stretched(m_monsterType.m_FrontSprite,image_index,x+6,y+6,96,96);
}