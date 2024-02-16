package com.greenwolfgames.MonsterMaster;

/**
 * 
 * @author Austin Bailey
 * @Date 2/16/2024
 *
 */
public enum ETraitType {
	CORPOREALITY, AGE, TRAVERSAL, EVOLUTIONARY, INHERITED, ELEMENTALMAGIC, STATMODIFIER;
	
	public static ETraitType getEnum(String value)
	{
		for(ETraitType type : values())
		{
			if(type.toString().equalsIgnoreCase(value))
			{
				return type;
			}
		}
		throw new IllegalArgumentException("No matching Enum in ETraitType to String: " + value);
	}
}
