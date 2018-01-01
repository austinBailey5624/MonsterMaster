/// @description transition to target room
object_Bestiary_BestiaryVariableHolder.m_subelementSelected=m_subElement;
global.g_subelementSelected = m_subElement;
var whichRoom = script_GetSubElementTreeType(m_subElement);
if(whichRoom == 1)
{
	room_goto(room_Bestiary_Spear);
}
else if(whichRoom ==2)
{
	room_goto(room_Bestiary_Bident);	
}
else if(whichRoom ==3)
{
	room_goto(room_Bestiary_Trident);	
}
else
{
	room_goto(room_Bestiary_Quadent);	
}
//room_goto(m_targetRoom);