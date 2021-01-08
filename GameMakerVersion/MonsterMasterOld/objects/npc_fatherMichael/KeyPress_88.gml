/// @description Turn the character, initiate Dialog
//face left
if(object_MainParty.x = x && object_MainParty.y = y-32)//face Up
{
	m_directionFacing = 1;//1:Up
}
else if(object_MainParty.x = x+32 && object_MainParty.y = y)//faceRight
{
	m_directionFacing = 2;//Right	
}
else if(object_MainParty.x = x && object_MainParty.y = y+32)//down/forwards
{
	m_directionFacing = 3;//down/forwards	
}
else if(object_MainParty.x == x-32 && object_MainParty.y = y)//face left
{
	m_directionFacing = 4;//4=left
}

