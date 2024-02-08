package com.greenwolfgames.MonsterMaster;

import java.util.List;

import org.junit.Test;

public class MonsterManagerTest
{
	@Test
	public void testGetMonsterTypes()
	{
		MonsterManager manager = new MonsterManager();
		
		List<MonsterType> monsterTypes = manager.getMonsterTypes();
		System.out.println("size: " + monsterTypes.size());
		for(int i = 0; i< 100; i++)
		{
			System.out.println(monsterTypes.get(i).toString());
		}
				
	}
}
