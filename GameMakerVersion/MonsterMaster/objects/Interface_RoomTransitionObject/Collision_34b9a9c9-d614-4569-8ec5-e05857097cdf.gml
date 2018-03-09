/// @description Room Transition
if(m_transitionAnimation==noone)
{
	room_goto(m_targetRoom);
}
else
{
	sprite_index = m_transitionAnimation;
	m_transitionOccuring=true;
}