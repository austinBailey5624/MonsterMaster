/// @description Insert description here
// You can write your code in this editor
draw_self();
draw_set_halign(fa_center);
draw_set_valign(fa_middle);
draw_set_color(c_black);
if(sprite_height > 86)//Draw in 64 px
{
draw_set_font(Arial_64);	
}
else if(sprite_height >= 43)
{
draw_set_font(Arial_32);	
}
else if(sprite_height >= 22)
{
draw_set_font(Arial_16);	
}
else
{
	draw_set_font(Arial_8);
}
draw_text(x+sprite_width/2,y+sprite_height/2,m_text);
