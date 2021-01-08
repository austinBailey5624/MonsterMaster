/// @description Assign the clicked monster to monster_selected
//If the handler dosen't have a monster
if(object_MonsterMerger_MonsterSelectedHandler.m_Selected_Monster == noone)
{
	//And we have a monster
	if(m_Monster != noone)
	{	//assign that monster to the handler
		object_MonsterMerger_MonsterSelectedHandler.m_Selected_Monster = m_Monster;
	}//And we don't have a monster
	else
	{	//leave
		return;
	}
}
//Handler already has monster
var temp = object_MonsterMerger_MonsterSelectedHandler.m_Selected_Monster;
object_MonsterMerger_MonsterSelectedHandler.m_Selected_Monster = m_Monster;
m_Monster = temp;