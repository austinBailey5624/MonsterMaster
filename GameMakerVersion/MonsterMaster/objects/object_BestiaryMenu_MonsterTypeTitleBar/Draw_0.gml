/// @description Insert description here
// You can write your code in this editor
draw_self();
var curSubElem = global.g_subelementSelected;
if (curSubElem == noone)
{
	curSubElem = subelement_Pyro;
}
draw_sprite_stretched(curSubElem.m_32bitSprite,image_index,x+6,y+6,96,96);
var subElem2 = global.g_monsterTypeSelected.m_subelement;
if(subElem2 == noone)
{
	subElem2 = subelement_Pyro;
}
draw_sprite_stretched(subElem2.m_32bitSprite,image_index,x+698,y+6,96,96);
draw_set_valign(fa_middle);
draw_set_halign(fa_center);
	if(curSubElem.m_primaryElement == element_Fire)
	{
		draw_set_color(c_red);	
	}
	else if(curSubElem.m_primaryElement == element_Water)
	{
		draw_set_color(c_blue);	
	}
	else if(curSubElem.m_primaryElement == element_Earth)
	{
		draw_set_color(c_green);	
	}
	else if(curSubElem.m_primaryElement == element_Air)
	{
		draw_set_color(c_yellow);
	}
	else if(curSubElem.m_primaryElement == element_Light)
	{
		draw_set_color(c_white);
	}
	else
	{
		draw_set_color(c_black);
	}
if(string_length(global.g_monsterTypeSelected.m_name)>14)
{
	draw_set_font(GWScript_60);
}
else
{
	draw_set_font(GWScript_96);
}
draw_text(x+400,y+54,global.g_monsterTypeSelected.m_name);