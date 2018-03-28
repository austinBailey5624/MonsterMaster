/// @description Draw the text
draw_set_alpha(1); //set opaque
draw_set_color(c_black); // set color black
draw_set_halign(fa_center);
//draw_set_font(Arial_8);
//draw_text_ext_transformed(128,66,m_text,20,372,2,2,0)//actually draw the text
//draw_text_ext_transformed(432,66,m_text,20,372,2,2,0);
var which = 2;

if(which==1)
{
	draw_set_font(Arial_16);
	draw_text_ext_transformed(432,66,m_text,20,372,1,1,0);
}
else if(which==2)
{
	draw_set_font(GWScript_36);
	draw_text_ext_transformed(432,66,m_text,40,704,1,1,0);	
}