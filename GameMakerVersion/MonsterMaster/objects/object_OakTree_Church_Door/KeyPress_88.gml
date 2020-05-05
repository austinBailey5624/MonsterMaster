/// @description Room Transition
if(object_MainParty.x >= x && object_MainParty.x <x+64 && object_MainParty.y >= y+64 && object_MainParty.y < y+96)
{
	room_goto(m_targetRoom);	
}
