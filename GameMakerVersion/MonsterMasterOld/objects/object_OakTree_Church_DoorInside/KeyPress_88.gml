/// @description Transition room if appropriate
if(object_MainParty.x = x && object_MainParty.y = y-32)
{
	room_goto(m_targetRoom);
	object_MainParty.x = m_targetx;
	object_MainParty.y = m_targety;
	object_MainParty.m_Lead.x = m_targetx;
	object_MainParty.m_Lead.y = m_targety;
}
