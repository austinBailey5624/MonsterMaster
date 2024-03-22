package com.greenwolfgames.MonsterMaster;

import java.util.Comparator;
import java.util.Map;

public class TraitIntensityComparator implements Comparator<Map.Entry<Trait, Integer>>
{
	@Override
	public int compare(Map.Entry<Trait,Integer> entry1, Map.Entry<Trait,Integer> entry2)
	{
		return entry1.getKey().getIndex() - (entry2.getKey().getIndex());
	}
}
