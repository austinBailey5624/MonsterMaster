/// @description Draw the box

draw_sprite_ext(sprite_index,0,x,y,image_xscale,image_yscale,0,c_white,1);
draw_set_halign(fa_center);
draw_set_color(c_black);
draw_set_font(Arial_16);

//draw_text(x+5,y+5,string(m_text));
draw_text_ext_transformed(x+(sprite_width/2),y+(sprite_height*.2),string(m_text),20,sprite_width*image_xscale,image_xscale,image_yscale,0)
//if (m_isSelected == false)
//{
//	draw_sprite(sprite_index,1,x,y);
//}
