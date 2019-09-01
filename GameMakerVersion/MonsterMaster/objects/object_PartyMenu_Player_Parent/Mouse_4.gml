/// @description Insert description here
// You can write your code in this editor

if(m_BattleActor != noone)
{
	m_BattleActor.m_health_Current -=20;
	event_perform(ev_draw,0);	
}