/// @description Draw element sprite with selector if selected
draw_sprite_stretched(m_subElement.m_32bitSprite,image_index,x,y,sprite_width,sprite_height);
if(m_isSelected)
{
	draw_sprite_stretched(m_mouseOverSprite,image_index,x,y,sprite_width,sprite_height);
	draw_sprite(sprite_Bestiary_SubElementPopUpLabel,image_index,x-44,y-64);
	draw_set_halign(fa_center);
	draw_set_valign(fa_middle);
	if(m_subElement.m_primaryElement == element_Fire)
	{
		draw_set_color(c_red);	
	}
	else if(m_subElement.m_primaryElement == element_Water)
	{
		draw_set_color(c_blue);	
	}
	else if(m_subElement.m_primaryElement == element_Earth)
	{
		draw_set_color(c_green);	
	}
	else if(m_subElement.m_primaryElement == element_Air)
	{
		draw_set_color(c_yellow);
	}
	else if(m_subElement.m_primaryElement == element_Light)
	{
		draw_set_color(c_white);
	}
	else
	{
		draw_set_color(c_black);
	}
	//handles changing text size if name is so long it drops off edge
	if(m_subElement == subelement_Amphibious|| m_subElement == subelement_Compassion || m_subElement==subelement_Seabreeze || m_subElement==subelement_Nightwing||m_subElement == subelement_Redemption|| m_subElement = subelement_Vengence)
	{
		draw_set_font(GWScript_36);
	}
	else
	{
	draw_set_font(GWScript_48);
	}
	draw_text(x+48,y-32,m_subElement.m_name);
}