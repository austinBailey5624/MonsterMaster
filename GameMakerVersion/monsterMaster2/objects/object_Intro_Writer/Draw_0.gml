/// @description Insert description here
// You can write your code in this editor
//draw_text(72,72,m_set1Line1);
//	draw_text_ext_transformed(432,144,m_set1Line1,64,864,.9,.9,1);
//	draw_text_ext_transformed(432,432,m_set1Line2,64,864,.9,.9,1);
//	draw_text_ext_transformed(432,720,m_set1Line3,64,864,.9,.9,1);
draw_set_font(GWScript_60);
if(m_time<=m_cycleLength)
{
	draw_set_alpha(m_time/m_cycleLength);
	draw_text(432,144,m_set1Line1);
}
else if(m_time<2*m_cycleLength)
{
	draw_set_alpha(1);
	draw_text(432,144,m_set1Line1);
	draw_set_alpha(m_time%m_cycleLength/m_cycleLength);
	draw_text(432,432,m_set1Line2);
}
else if(m_time<3*m_cycleLength)
{
	draw_set_alpha(1);
	draw_text(432,144,m_set1Line1);
	draw_text(432,432,m_set1Line2);
	draw_set_alpha(m_time%m_cycleLength/m_cycleLength);
	draw_text(432,720,m_set1Line3);
}
else if(m_time<4*m_cycleLength)
{
//	draw_set_alpha(1-(m_time%m_cycleLength/m_cycleLength));
	draw_set_alpha(1-((m_time-3*m_cycleLength)/m_cycleLength));
	draw_text(432,144,m_set1Line1);
	draw_text(432,432,m_set1Line2);
	draw_text(432,720,m_set1Line3);
}
else if(m_time<5*m_cycleLength)
{	
	draw_set_alpha((m_time%m_cycleLength)/m_cycleLength);
	draw_text_ext_transformed(432,144,m_set2Line1, 76, 864, 1, 1, 0);
//	draw_text(432,144,m_set2Line1);

}
else if(m_time<6*m_cycleLength)
{
	draw_set_alpha(1);
//	draw_text(432,144,m_set2Line1);
	draw_text_ext_transformed(432,144,m_set2Line1, 76, 864, 1, 1, 0);
	draw_set_alpha(m_time%m_cycleLength/m_cycleLength);
//	draw_text(432,432,m_set2Line2);
	draw_text_ext_transformed(432,432,m_set2Line2, 76, 800, 1, 1, 0);
}
else if(m_time<7*m_cycleLength)
{
	draw_set_alpha(1);
	draw_text_ext_transformed(432,144,m_set2Line1, 76, 864, 1, 1, 0);
	draw_text_ext_transformed(432,432,m_set2Line2, 76, 800, 1, 1, 0);
	draw_set_alpha(m_time%m_cycleLength/m_cycleLength);
	draw_text_ext_transformed(432,720,m_set2Line3, 76, 800, 1, 1, 0);
}
else if(m_time<8*m_cycleLength)
{
	draw_set_alpha(1-((m_time-7*m_cycleLength)/m_cycleLength));
	draw_text_ext_transformed(432,144,m_set2Line1, 76, 864, 1, 1, 0);
	draw_text_ext_transformed(432,432,m_set2Line2, 76, 800, 1, 1, 0);
	draw_text_ext_transformed(432,720,m_set2Line3, 76, 800, 1, 1, 0);
}
else if(m_time<9*m_cycleLength)
{
	draw_set_alpha((m_time%m_cycleLength)/m_cycleLength);
	draw_text_ext_transformed(432,144,m_set3Line1, 76, 864, 1, 1, 0);
}
else if(m_time<10*m_cycleLength)
{
	draw_set_alpha(1);
	draw_text_ext_transformed(432,144,m_set3Line1, 76, 864, 1, 1, 0);
	draw_set_alpha(m_time%m_cycleLength/m_cycleLength);
	draw_text_ext_transformed(432,432,m_set3Line2, 76, 800, 1, 1, 0);
}
else if(m_time<11*m_cycleLength)
{
	draw_set_alpha(1);
	draw_text_ext_transformed(432,144,m_set3Line1, 76, 864, 1, 1, 0);
	draw_text_ext_transformed(432,432,m_set3Line2, 76, 800, 1, 1, 0);
	draw_set_alpha(m_time%m_cycleLength/m_cycleLength);
	draw_text_ext_transformed(432,720,m_set3Line3, 76, 800, 1, 1, 0);
}
else if(m_time<12*m_cycleLength)
{
	draw_set_alpha(1-((m_time-11*m_cycleLength)/m_cycleLength));
	draw_text_ext_transformed(432,144,m_set3Line1, 76, 864, 1, 1, 0);
	draw_text_ext_transformed(432,432,m_set3Line2, 76, 800, 1, 1, 0);
	draw_text_ext_transformed(432,720,m_set3Line3, 76, 800, 1, 1, 0);
}//intentional gap pause for dramatic effect
else if(m_time<14*m_cycleLength)
{
	room_goto(GetNameRoom);	
}