package com.greenwolfgames.MonsterMaster;

import java.awt.Color;

public class ColorUtilities 
{
	public static Color readColorFromString(String name)
	{
		if("red".equals(name.toLowerCase()))
		{
			return Color.red;
		}
		if("blue".equals(name.toLowerCase()))
		{
			return Color.blue;
		}
		if("green".equals(name.toLowerCase()))
		{
			return Color.green;
		}
		if("yellow".equals(name.toLowerCase()))
		{
			return Color.yellow;
		}
		if("white".equals(name.toLowerCase()))
		{
			return Color.white;
		}
		if("black".equals(name.toLowerCase()))
		{
			return Color.black;
		}
		if("grey".equals(name.toLowerCase()) || "gray".equals(name.toLowerCase()))
		{
			return Color.gray;
		}
		if("brown".equals(name.toLowerCase()))
		{
			return Color.getHSBColor(.4f, 1, .5f);//#805500;128,85,0
		}
		if("purple".equals(name.toLowerCase()))
		{
			return Color.getHSBColor(280f,1f,1f);//#AA00FF;170,0,255
		}

		return null;
	}
}
