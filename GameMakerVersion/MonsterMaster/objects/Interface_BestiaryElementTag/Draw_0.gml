/// @description Insert description here
// You can write your code in this editor
var m_text;
draw_self();
draw_set_halign(fa_center);
draw_set_valign(fa_middle);

if(m_element==0)
{
	draw_set_color(c_red);
	m_text="Fire";
}
else if(m_element==1)
{
	draw_set_color(c_blue);
	m_text="Water";
}
else if(m_element==2)
{
	draw_set_color(c_green);
	m_text="Earth";
}
else if(m_element==3)
{
	draw_set_color(c_yellow);
	m_text="Air";
}
else if(m_element==4)
{
	draw_set_color(c_white);
	m_text="Light";
}
else
{
	draw_set_color(c_black);
	m_text="Dark";
}

draw_set_font(GWScript_24);

if(m_isHorizontal)
{
	draw_text(x+sprite_width/2,y+sprite_height/2,m_text);
}	
else
{
	draw_text_transformed(x+sprite_width/2,y+sprite_height/2,m_text,1,1,90);	
}
