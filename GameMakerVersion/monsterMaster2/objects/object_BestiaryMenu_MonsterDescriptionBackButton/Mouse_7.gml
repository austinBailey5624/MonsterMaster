/// @description Transition level
var whichRoom = script_GetSubElementTreeType(global.g_subelementSelected);
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
