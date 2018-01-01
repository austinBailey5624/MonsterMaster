/// @description Insert description here
// You can write your code in this editor
draw_self();
draw_set_halign(fa_left);
draw_set_valign(fa_top);
draw_set_color(c_black);

//change size of font based on number of characters present
if(string_length(global.g_monsterTypeSelected.m_description)>460)
{
	draw_set_font(GWScript_24);
}
else
{
	draw_set_font(GWScript_36);
}
draw_text_ext(x+8,y+8,global.g_monsterTypeSelected.m_description,32,sprite_width-16);
//show_message(string_length(global.g_monsterTypeSelected.m_description));//for debugging sizes