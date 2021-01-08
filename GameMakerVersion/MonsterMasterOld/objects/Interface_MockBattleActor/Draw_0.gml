/// @description Specialized draw that handles drawing health bars
// You can write your code in this editor

///draw_self();
var statusBarx;//the x position of where to draw the associated status bar
var statusBary;//the y position of where to draw the status bar

//This code chunk determines where to draw statusbar
if(m_isAlly)//since you're an ally, you're on the top row
{
	statusBarx=16;
}
else
{
	statusBarx=816;	
}

if(m_positionOnBattle==0)//if youre the leader
{
	statusBary=16;
}
else if(m_positionOnBattle==1)//second
{
	statusBary=224;	
}
else if(m_positionOnBattle==2)
{
	statusBary=432;	
}
else
{
	statusBary=640;	
}


//actually draw the status Bar
if(m_isSelected)
{

	if(m_healthCur<0)
	{
		m_healthCur=0;
		image_alpha=.5;
	}
	if(m_magicCur<0)
	{
		m_magicCur=0;
	}
	draw_self();
	if(m_isAlly)
	{
		draw_sprite_stretched(m_HealthBar,script_GetStatusBarSpriteIndex(m_healthCur,m_healthMax),16,48,832,128);
		draw_sprite_stretched(m_MagicBar,script_GetStatusBarSpriteIndex(m_magicCur,m_magicMax),16,48,832,128);
		draw_sprite_stretched(m_subElement.m_32bitSprite,sprite_index,16,48,128,128);
		draw_set_halign(fa_center);
		draw_set_valign(fa_middle);
		draw_set_font(GWScript_36);
		draw_text(432,82,string(ceil(m_healthCur))+" / "+string(m_healthMax));
		draw_text(432,146,string(ceil(m_magicCur))+" / "+string(m_magicMax));
		return;
	}
	else
	{
		draw_sprite_stretched(m_HealthBar,script_GetStatusBarSpriteIndex(m_healthCur,m_healthMax),16,688,832,128);
		draw_sprite_stretched(m_MagicBar,script_GetStatusBarSpriteIndex(m_magicCur,m_magicMax),16,688,832,128);
		draw_sprite_stretched(m_subElement.m_32bitSprite,sprite_index,16,688,128,128);
		draw_set_halign(fa_center);
		draw_set_valign(fa_middle);
		draw_set_font(GWScript_36);
		draw_text(432,728,string(ceil(m_healthCur))+" / "+string(m_healthMax));
		draw_text(432,808,string(ceil(m_magicCur))+" / "+string(m_magicMax));
		return;
	}
}
if(m_healthCur=0)
{
	image_alpha=.5;
}
draw_sprite_stretched(sprite_index,0,x,y,sprite_width,sprite_height);
draw_sprite(m_HealthBar,script_GetStatusBarSpriteIndex(m_healthCur,m_healthMax),statusBary,statusBarx);
draw_sprite(m_MagicBar,script_GetStatusBarSpriteIndex(m_magicCur,m_magicMax),statusBary,statusBarx);
draw_sprite(m_subElement.m_32bitSprite,sprite_index,statusBary+2,statusBarx);