/// @description Assign Monster if Father empty, combine else

//If a monster has been selected
if(object_MonsterMerger_MonsterSelectedHandler.m_Selected_Monster != noone)
{	//And there is no monster selected for the father
	if(object_MonsterMerger_Father_Right.m_Monster == noone)
	{	//Assign the selected monster to the mother
		m_Monster = object_MonsterMerger_MonsterSelectedHandler.m_Selected_Monster;
	}
	else //And there is a monster selected for the father
	{	//Combine monsters logic
		var motherSubelement = m_Monster.m_subelement;
		var fatherSubelement = object_MonsterMerger_Father_Right.m_Monster.m_subelement;
		var childSubelement = script_combineElements(motherSubelement, fatherSubelement);
		var childMonsterType = script_returnInfantFromSubelement(childSubelement);
		
		//Make new infant Monster
		object_MonsterMerger_MergedMonster.m_MonsterType = childMonsterType;
		object_MonsterMerger_MergedMonster.m_subelement = childSubelement;
		object_MonsterMerger_MergedMonster.m_primary_element = childSubelement.m_primaryElement;
		object_MonsterMerger_MergedMonster.m_secondary_element = childSubelement.m_secondaryElement;

		//Kill the parents
		m_Monster = noone;
		object_MonsterMerger_Father_Right.m_Monster = noone;
	}
}