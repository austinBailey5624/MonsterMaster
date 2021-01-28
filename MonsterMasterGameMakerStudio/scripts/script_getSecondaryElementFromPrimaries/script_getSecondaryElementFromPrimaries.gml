function script_getSecondaryElementFromPrimaries(argument0, argument1) {
	if(argument0 == element_Fire && argument1 == element_Fire)
	{
		return subelement_Pyro;	
	}
	if(argument0 == element_Fire && argument1 == element_Water)
	{
		return subelement_Lava;
	}
	if(argument0 == element_Fire && argument1 == element_Earth)
	{
		return subelement_Dino;	
	}
	if(argument0 == element_Fire && argument1 == element_Air)
	{
		return subelement_Phoenix;
	}
	if(argument0 == element_Fire && argument1 == element_Light)
	{
		return subelement_Justice;	
	}
	if(argument0 == element_Fire && argument1 == element_Dark)
	{
		return subelement_Vengence;
	}
	if(argument0 == element_Water && argument1 == element_Fire)
	{
		return subelement_Steam;
	}
	if(argument0 == element_Water && argument1 == element_Water)
	{
		return subelement_Aqua;
	}
	if(argument0 == element_Water && argument1 == element_Earth)
	{
		return subelement_Amphibious;
	}
	if(argument0 == element_Water && argument1 == element_Air)
	{
		return subelement_Weather;
	}
	if(argument0 == element_Water && argument1 == element_Light)
	{
		return subelement_Ice;	
	}
	if(argument0 == element_Water && argument1 == element_Dark)
	{
		return subelement_Deep;
	}
	if(argument0 == element_Earth && argument1 == element_Fire)
	{
		return subelement_Fey;
	}
	if(argument0 == element_Earth && argument1 == element_Water)
	{
		return subelement_Swamp;
	}
	if(argument0 == element_Earth && argument1 == element_Earth)
	{
		return subelement_Terra;
	}
	if(argument0 == element_Earth && argument1 == element_Air)
	{
		return subelement_Pegasus;
	}
	if(argument0 == element_Earth && argument1 == element_Light)
	{
		return subelement_Compassion;	
	}
	if(argument0 == element_Earth && argument1 == element_Dark)
	{
		return subelement_Rotten;
	}
	if(argument0 == element_Air && argument1 == element_Fire)
	{
		return subelement_Sand;
	}
	if(argument0 == element_Air && argument1 == element_Water)
	{
		return subelement_Seabreeze;
	}
	if(argument0 == element_Air && argument1 == element_Earth)
	{
		return subelement_Bird;
	}
	if(argument0 == element_Air && argument1 == element_Air)
	{
		return subelement_Aero;	
	}
	if(argument0 == element_Air && argument1 == element_Light)
	{
		return subelement_Cocka;
	}
	if(argument0 == element_Air && argument1 == element_Dark)
	{
		return subelement_Nightwing;
	}
	if(argument0 == element_Light && argument1 == element_Fire)
	{
		return subelement_Solar;
	}
	if(argument0 == element_Light && argument1 == element_Water)
	{
		return subelement_Lunar;
	}
	if(argument0 == element_Light && argument1 == element_Earth)
	{
		return subelement_Guardian;
	}
	if(argument0 == element_Light && argument1 == element_Air)
	{
		return subelement_Angel;
	}
	if(argument0 == element_Light && argument1 == element_Light)
	{
		return subelement_Luxor;
	}
	if(argument0 == element_Light && argument1 == element_Dark)
	{
		return subelement_Redemption;
	}
	if(argument0 == element_Dark && argument1 == element_Fire)
	{
		return subelement_Demon;
	}
	if(argument0 == element_Dark && argument1 == element_Water)
	{
		return subelement_Poison;
	}
	if(argument0 == element_Dark && argument1 == element_Earth)
	{
		return subelement_Undead;
	}
	if(argument0 == element_Dark && argument1 == element_Air)
	{
		return subelement_Storm;
	}
	if(argument0 == element_Dark && argument1 == element_Light)
	{
		return subelement_Betrayer;
	}
	if(argument0 == element_Dark && argument1 == element_Dark)
	{
		return subelement_Umbral;
	}


}
