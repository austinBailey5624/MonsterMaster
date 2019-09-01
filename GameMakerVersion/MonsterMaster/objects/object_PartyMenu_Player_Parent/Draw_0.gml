/// @description Insert description here
// You can write your code in this editor
if(m_BattleActor != noone)
{
	image_alpha=1;
    draw_set_alpha(1);
    draw_self();
	draw_sprite_stretched(m_BattleActor.m_FrontSprite,image_index,x+110,y+14,82,82);
	draw_sprite_stretched(m_BattleActor.m_subelement.m_32bitSprite,image_index,x+14,y+14,82,82);
	
/*	draw_sprite_stretched(sprite_PartyMenu_HealthBar,222,x+202, y+14, 528,42);
	draw_sprite_stretched(sprite_PartyMenu_MagicBar,222,x+202, y+56,528,42);*/
	
	//Determines the index of the helthBar sprite to retrieve
	var health_sprite_index = m_BattleActor.m_health_Current/m_BattleActor.m_health_Max*223;
	//health_sprite_index *= sprite_PartyMenu_HealthBar.sprite_get_number(sprite_PartyMenu_HealthBar.sprite_index);

	var magic_sprite_index = m_BattleActor.m_magic_Current/m_BattleActor.m_magic_Max*223;
//	magic_sprite_index = sprite_PartyMenu_MagicBar.sprite_get_number(sprite_PartyMenu_MagicBar.sprite_index);
	if(health_sprite_index < 1)
	{
		health_sprite_index = 1;	
	}
	if(health_sprite_index > 223)
	{
		health_sprite_index = 223;	
	}
	if(magic_sprite_index < 1)
	{
		health_sprite_index = 1;	
	}
	if(health_sprite_index > 223)
	{
		health_sprite_index = 223;	
	}
	draw_sprite_stretched(sprite_PartyMenu_HealthBar,health_sprite_index,x+202,y+14,528,42);
	draw_sprite_stretched(sprite_PartyMenu_MagicBar,magic_sprite_index,x+202,y+60,528,42);
}