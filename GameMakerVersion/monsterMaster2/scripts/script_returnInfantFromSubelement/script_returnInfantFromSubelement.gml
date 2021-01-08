function script_returnInfantFromSubelement(argument0) {
	if(argument0 == subelement_Pyro)
	{
		return monsterType_Flarial;
	}
	if(argument0 == subelement_Lava)
	{
		return monsterType_Philammon;
	}
	if(argument0 == subelement_Dino)
	{
		return monsterType_Salamander;
	}
	if(argument0 == subelement_Phoenix)
	{
		return monsterType_MinorPhoenix;
	}
	if(argument0 == subelement_Justice)
	{
		return monsterType_Angier;
	}
	if(argument0 == subelement_Vengence)
	{
		return monsterType_Spiten;
	}

	if(argument0 == subelement_Steam)
	{
		return monsterType_MinorSteamlet;
	}
	if(argument0 == subelement_Aqua)
	{
		return monsterType_Minnow;
	}
	if(argument0 == subelement_Amphibious)
	{
		return monsterType_Tapple;
	}
	if(argument0 == subelement_Weather)
	{
		return monsterType_Cirrus;
	}
	if(argument0 == subelement_Ice)
	{
		return monsterType_Snoball;
	}
	if(argument0 == subelement_Deep)
	{
		return monsterType_Deepfish;
	}

	if(argument0 == subelement_Fey)
	{
		return monsterType_Sprite;
	}
	if(argument0 == subelement_Swamp)
	{
		return monsterType_Boggart;
	}
	if(argument0 == subelement_Terra)
	{
		var rand = irandom(2);
		if(rand == 0)
		{
			return monsterType_Babadger;
		}
		if(rand == 1)
		{
			return monsterType_Bulbapup;
		}
		if(rand == 2)
		{
			return monsterType_Stiket;
		}
	}
	if(argument0 == subelement_Pegasus)
	{
		return monsterType_MinorPegasus;
	}
	if(argument0 == subelement_Compassion)
	{
		return monsterType_Suddi;
	}
	if(argument0 == subelement_Rotten)
	{
		return monsterType_Sewerat;
	}

	if(argument0 == subelement_Sand)
	{
		return monsterType_Kangarat;
	}
	if(argument0 == subelement_Seabreeze)
	{
		return monsterType_Gullfish;
	}
	if(argument0 == subelement_Bird)
	{
		return monsterType_Colour;
	}
	if(argument0 == subelement_Aero)
	{
		return monsterType_Flapper;
	}
	if(argument0 == subelement_Cocka)
	{
		return monsterType_Cockaone;
	}
	if(argument0 == subelement_Nightwing)
	{
		return monsterType_Fourshadowing;
	}

	if(argument0 == subelement_Solar)
	{
		return monsterType_Tona;
	}
	if(argument0 == subelement_Lunar)
	{
		return monsterType_Lona;
	}
	if(argument0 == subelement_Guardian)
	{
		return monsterType_Escutcheoner;
	}
	if(argument0 == subelement_Angel)
	{
		return monsterType_Demiangel;
	}
	if(argument0 == subelement_Luxor)
	{
		return monsterType_Lumin;
	}
	if(argument0 == subelement_Redemption)
	{
		return monsterType_Guilt;
	}
	if(argument0 == subelement_Demon)
	{
		return monsterType_Fiend;
	}
	if(argument0 == subelement_Poison)
	{
		return monsterType_Stinger;
	}
	if(argument0 == subelement_Undead)
	{
		return monsterType_Stull;
	}
	if(argument0 == subelement_Storm)
	{
		return monsterType_Maltag;
	}
	if(argument0 == subelement_Betrayer)
	{
		return monsterType_FallenDemiAngel;
	}
	if(argument0 == subelement_Umbral)
	{
		return monsterType_Umbress;
	}


}
