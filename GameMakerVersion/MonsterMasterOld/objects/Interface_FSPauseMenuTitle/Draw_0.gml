/// @description Insert description here
// You can write your code in this editor
image_alpha=1;
draw_set_alpha(1);

draw_self();
draw_set_halign(fa_center);
draw_set_valign(fa_middle);
draw_set_color(c_black);
if(sprite_height > 128)//draw in 96 px
{
	draw_set_font(GWScript_96);	
}
if(sprite_height > 86)//Draw in 64 px
{

  draw_set_font(GWScript_60);
}
else if(sprite_height >= 43)
{

	draw_set_font(GWScript_24);
}
else
{
	draw_set_font(GWScript_12);	
}
draw_text(x+sprite_width/2,y+sprite_height/2,m_text);
draw_set_alpha(1);