/// @description Handle party assignment logic, then go to previous room
//Handle Party Assignment Logic
if(object_MonsterMerger_PartyMonster1.m_Monster != noone)
{
	object_MainParty.m_Follow1 = object_MonsterMerger_PartyMonster1.m_Monster;
}
if(object_MonsterMerger_PartyMonster2.m_Monster != noone)
{
	object_MainParty.m_Follow2 = object_MonsterMerger_PartyMonster2.m_Monster;	
}
if(object_MonsterMerger_PartyMonster3.m_Monster != noone)
{
	object_MainParty.m_Follow3 = object_MonsterMerger_PartyMonster3.m_Monster;
}
//go to previous room
room_goto_previous();