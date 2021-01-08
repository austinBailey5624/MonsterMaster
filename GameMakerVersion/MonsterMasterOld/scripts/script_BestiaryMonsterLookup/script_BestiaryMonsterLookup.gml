//argument0-subelement
//argument1='age' of monster; infant 1; adolescent 2; adult 3; elder 4;
//argument2='index' of monster of that subelement and age- zero indexed

if(argument0 == subelement_Pyro)
{
	if(argument1 == 1 && argument2 == 0)//infants (only one)
	{
		return monsterType_Flarial;
	}
	else if(argument1 == 2)//adolescents
	{
		if(argument2 == 0)//first (most physical) adolescent
		{
			return monsterType_Pyrus;	
		}
		else if(argument2 == 1)//second (balanced) adolescent
		{
			return monsterType_Flarpup;
		}
		else if(argument2 == 2)//third (magical) adolescent
		{
			return monsterType_PyroSymbol;	
		}
	}
	else if(argument1 == 3)//adults
	{
		if(argument2 == 0)//first adult
		{
			return monsterType_Pyos;	
		}
		else if(argument2 == 1)
		{
			return monsterType_Comet;	
		}
		else if(argument2 ==2)
		{
			return monsterType_FireOpal;
		}
		else if(argument2 == 3)
		{
			return monsterType_PyroElemental;	
		}
	}
	else if(argument1 ==4)//elders
	{
		if(argument2 == 0)
		{
			return monsterType_Pyres;
		}
		else if(argument2 == 1)
		{
			return monsterType_Bolide;	
		}
		else if(argument2 == 2)
		{
			return monsterType_Ruby;	
		}
		else if(argument2 == 3)
		{
			return monsterType_PyroAtronach;	
		}
	}
	else
	{
		return monsterType_Flarial;	
	}
}
else if(argument0 = subelement_Lava)
{
	if(argument1 ==1)//infants
	{
		return monsterType_Philammon;	
	}
	else if(argument1 == 2)//adolescents
	{
		if(argument2 == 0)
		{
			return monsterType_Crerops;
		}
		else if(argument2 == 1)
		{
			return monsterType_Corynetes;
		}
	}
	else if(argument1 == 3)//adults
	{
		if(argument2 == 0)
		{
			return monsterType_Philottus;	
		}
		else 
		{
			return monsterType_Cercyon;	
		}
	}
	else if(argument1 == 4)//elders
	{
		if(argument2 == 0)
		{
			return monsterType_Vulcanous;
		}
		else
		{
			return monsterType_Vagrus;
		}
	}
	else
	{
		return monsterType_Philammon;
	}
}
else if(argument0 == subelement_Dino)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Salamander;
	}
	else if(argument1 == 2)//adolescents
	{
		if(argument2 == 0)
		{
			return monsterType_Raptor;
		}
		else if(argument2 == 1)
		{
			return monsterType_Winger;
		}
		else
		{
			return monsterType_Herbisaur;
		}
	}
	else if(argument1 == 3)//adult
	{
		if(argument2 ==0)
		{
			return monsterType_Tyrant;
		}
		else if(argument2 == 1)
		{
			return monsterType_SteelWinger;
		}
		else
		{
			return monsterType_Spikevorsaur;
		}
	}
	else if(argument1 == 4)//elder
	{
		if(argument2==0)
		{
			return monsterType_GreatWhiteTyrant;
		}
		else if(argument2==1)
		{
			return monsterType_EdgeWinger;
		}
		else
		{
			return monsterType_Broncheospikesaur;
		}
	}
}
else if(argument0 == subelement_Phoenix)
{
	if(argument1 == 1)
	{
		return monsterType_MinorPhoenix;
	}
	if(argument1 == 2)
	{
		if(argument2 == 0)
		{
			return monsterType_Chol;
		}
		if(argument2 == 1)
		{
			return monsterType_FireBird;
		}
	}
	if(argument1 == 3)
	{
		if(argument2 == 0)
		{
			return monsterType_Fawke;
		}
		if(argument2 == 1)
		{
			return monsterType_FireEagle;
		}
	}
	if(argument1 == 4)
	{
		if(argument2 ==0)
		{
			return monsterType_Fenghuang;
		}
		if(argument2 ==1)
		{
			return monsterType_Franzer;
		}
	}
	return monsterType_MinorPhoenix;
}
else if(argument0 == subelement_Justice)
{
	if(argument1 == 1)
	{
		return monsterType_Angier;
	}
	else if(argument1 == 2)
	{
		if(argument2 == 0)
		{
			return monsterType_Justicar;
		}
		if(argument2 == 1)
		{
			return monsterType_Ayurved;
		}
	}
	if(argument1 == 3)
	{
		if(argument2 == 0)
		{
			return monsterType_Ordinator;
		}
		if(argument2 == 1)
		{
			return monsterType_Anyr;
		}
	}
	if(argument1 == 4)
	{
		if(argument2 == 0)
		{
			return monsterType_Zireal;	
		}
		if(argument2 == 1)
		{
			return monsterType_Justicer;
		}
	}
	return monsterType_Angier;
}
else if(argument0 == subelement_Vengence)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Spiten;
	}
	if(argument1 == 2)//adolescents
	{
		if(argument2 ==0)
		{
			return monsterType_Jacobia;
		}
		if(argument2 == 1)
		{
			return monsterType_Lizbet;
		}
	}
	if(argument1 == 3)//adults
	{
		if(argument2 ==0)
		{
			return monsterType_Letham;
		}
		if(argument2 == 1)
		{
			return monsterType_DHoffry;
		}
	}
	if(argument1 == 4)
	{
		if(argument2 == 0)
		{
			return monsterType_Revenant;
		}
		if(argument2 == 1)
		{
			return monsterType_Halfrec;
		}
	}
	return monsterType_Spiten;
}
else if(argument0 == subelement_Steam)
{
	if(argument1==1)
	{
		return monsterType_MinorSteamlet;
	}
	if(argument1==2)
	{
		return monsterType_LesserSteamlet;
	}
	if(argument1==3)
	{
		return monsterType_Steamlet;
	}
	if(argument1 == 4)
	{
		return monsterType_GreaterSteamlet;	
	}
	return monsterType_MinorSteamlet;
}
else if(argument0 == subelement_Aqua)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Minnow;
	}
	else if(argument1 == 2)//adolescents
	{
		if(argument2 == 0)
		{
			return monsterType_Edgefinn;
		}
		if(argument2 == 1)
		{
			return monsterType_Cuddlerfish;
		}
		if(argument2 == 2)//AquaSymbol
		{
			return monsterType_AquaSymbol;
		}
	}
	else if(argument1 == 3)//adults
	{
		if(argument2 == 0)
		{
			return monsterType_Slicefinn;
		}
		if(argument2 == 1)
		{
			return monsterType_Snugglerfish;
		}
		if(argument2 == 2)
		{
			return monsterType_Torquoise;
		}
		else if(argument2 == 3)
		{
			return monsterType_AquaElemental;
		}
	}
	else if(argument1 == 4)//elders
	{
		if(argument2 == 0)
		{
			return monsterType_BlueDragon;
		}
		if(argument2 == 1)
		{
			return monsterType_Levithan;
		}
		if(argument2 == 2)
		{
			return monsterType_Sapphire;
		}
		else if(argument2 == 3)
		{
			return monsterType_AquaAtronach;
		}
	}
	return monsterType_Minnow;
}
else if(argument0 == subelement_Amphibious)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Tapple;
	}
	if(argument1 == 2)//adolescents
	{
		if(argument2 == 0)
		{
			return monsterType_Froget;
		}
		if(argument2 == 1)
		{
			return monsterType_Rainbowfrog;
		}
		if(argument2 == 2)
		{
			return monsterType_Frogami;
		}
	}
	if(argument1 == 3)//adults
	{
		if(argument2 == 0)
		{
			return monsterType_Frogar;
		}
		if(argument2 == 1)
		{
			return monsterType_Frogaudy;
		}
		if(argument2 == 2)
		{
			return monsterType_Esotoad;
		}
	}
	if(argument1 == 4)//elders
	{
		if(argument2 == 0)
		{
			return monsterType_Tonguedancer;
		}
		if(argument2 == 1)
		{
			return monsterType_Frogealer;
		}
		if(argument2 == 2)
		{
			return monsterType_Metitode;
		}
	}
	return monsterType_Tapple;
}
else if(argument0 == subelement_Weather)
{
	if(argument1==1)
	{
		return monsterType_Cirrus;
	}
	if(argument1 == 2)
	{
		if(argument2 == 0)
		{
			//return monsterType_Cirrus;
			return monsterType_Cumulus;	
		}
		if(argument2 == 1)
		{
			return monsterType_Stratus;	
		}
		if(argument2 == 2)
		{
			return monsterType_Nimbus;	
		}
	}
	if(argument1 == 3)
	{
		if(argument2 == 0)
		{
			return monsterType_Nephol;
		}
		if(argument2==1)
		{
			return monsterType_CumuloStratus;
		}
		if(argument2==2)
		{
			return monsterType_NimbuloPonderant;
		}
	}
	if(argument1==4)
	{
		if(argument2==0)
		{
			return monsterType_Thunderus;
		}
		if(argument2==1)
		{
			return monsterType_Cirricumulus;
		}
		if(argument2==2)
		{
			return monsterType_Cumulonimbus;
		}
	}
	return monsterType_Cirrus;
}
else if(argument0 == subelement_Ice)
{
	return monsterType_Snoball;
}
else if(argument0 == subelement_Deep)
{
	return monsterType_Deepfish;
}
else if(argument0 == subelement_Fey)
{
	return monsterType_Sprite;
}
else if(argument0 == subelement_Swamp)
{
	return monsterType_Boggart;
}
else if(argument0 == subelement_Terra)
{
	if(argument1 == 1)
	{
		if(argument2 == 0)
		{
			return monsterType_Babadger;
		}
		else if(argument2 == 1)
		{
			return monsterType_Bulbapup;
		}
		else if(argument2 == 2)
		{
			return monsterType_Stiket;
		}
	}
	else if(argument1 == 2)
	{
		if(argument2 == 0)//badgebadger
		{
			return monsterType_Babadger;
		}
		else if(argument2 == 1)//vinewolf
		{
			return monsterType_Bulbapup;
		}
		else if(argument2 == 2)//Trig
		{
			return monsterType_Stiket;
		}
		else if(argument2 ==3)//TerraSymbol
		{
			return monsterType_TerraSymbol;
		}
	}
	else if(argument1 == 3)
	{
		if(argument2 == 3)
		{
			return monsterType_Jade;
		}
		if(argument2 == 4)
		{
			return monsterType_TerraElemental;
		}
	}
	else if(argument1 == 4)//elders
	{
		if(argument2 == 4)
		{
			return monsterType_Emerald;
		}
		if(argument2 == 5)
		{
			return monsterType_TerraAtronach;
		}
	}
	
	if(argument2 == 0)
	{
		return monsterType_Babadger;
	}
	else if(argument2 == 1)
	{
		return monsterType_Bulbapup;
	}
	else if(argument2 == 2)
	{
		return monsterType_Stiket;
	}
	
	return monsterType_Bulbapup;
}
else if(argument0 == subelement_Pegasus)
{
	return monsterType_MinorPegasus;
}
else if(argument0 == subelement_Compassion)
{
	return monsterType_Suddi;	
}
else if(argument0 == subelement_Rotten)
{
	return monsterType_Sewerat;
}
else if(argument0 == subelement_Sand)
{
	return monsterType_Kangarat;
}
else if(argument0 == subelement_Seabreeze)
{
	return monsterType_Gullfish;
}
else if(argument0 == subelement_Bird)
{
	return monsterType_Colour;
}
else if(argument0 == subelement_Aero)
{
	if(argument1 == 1)
	{
		return monsterType_Flapper;
	}
	else if(argument1 == 2)
	{
		if(argument2 == 2)
		{
			return monsterType_AeroSymbol;
		}
	}
	else if(argument1 ==3)
	{
		if(argument2 == 2)
		{
			return monsterType_Quartz;		
		}
		else if(argument2 == 3)
		{
			return monsterType_AeroElemental;
		}
	}
	else if(argument1 ==4)//elders
	{
		if(argument2 == 2)
		{
			return monsterType_Topaz;
		}
		else if(argument2 == 3)
		{
			return monsterType_AeroAtronach;
		}
	}
	return monsterType_Flapper;
}
else if(argument0 == subelement_Cocka)
{
	return monsterType_Cockaone;
}
else if(argument0 == subelement_Nightwing)
{
	return monsterType_Fourshadowing;
}
else if(argument0 == subelement_Solar)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Tona;	
	}
	if(argument2 == 0)
	{
		return monsterType_Firefaux;
	}
	
	return monsterType_Tona;
}
else if(argument0 == subelement_Lunar)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Lona;
	}
	if(argument2 == 0)
	{
		return monsterType_Lunapup;
	}
	return monsterType_Lona;
}
else if(argument0 == subelement_Guardian)
{
	return monsterType_Escutcheoner;
}
else if(argument0 == subelement_Angel)
{
	return monsterType_Demiangel;
}
else if(argument0 == subelement_Luxor)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Lumin;
	}
	if(argument1 == 2)//adolescents
	{
		if(argument2 == 2)
		{
			return monsterType_LuxorSymbol;
		}
	}
	if(argument1 == 3)//adults
	{
		if(argument2 == 2)
		{
			return monsterType_Moonstone;
		}
		else if(argument2 == 3)
		{
			return monsterType_LuxorElemental;
		}
	}
	if(argument1 == 4)//elders
	{
		if(argument2 == 2)
		{
			return monsterType_Diamond;
		}
		if(argument2 == 3)
		{
			return monsterType_LuxorAtronach;	
		}
	}
	return monsterType_Lumin;
}
else if(argument0 == subelement_Redemption)
{
	return monsterType_Guilt;
}
else if(argument0 == subelement_Demon)
{
	return monsterType_Fiend;
}
else if(argument0 == subelement_Poison)
{
	return monsterType_Stinger;
}
else if(argument0 == subelement_Undead)
{
	return monsterType_Stull;
}
else if(argument0 == subelement_Storm)
{
	return monsterType_Maltag;
}
else if(argument0 == subelement_Betrayer)
{
	return monsterType_FallenDemiAngel;
}
else if(argument0 == subelement_Umbral)
{
	if(argument1 == 1)//infants
	{
		return monsterType_Umbress;
	}
	if(argument1 == 2)
	{
		if(argument2 == 2)
		{
			return monsterType_UmbralSymbol;
		}
	}
	if(argument1 == 3)
	{
		if(argument2 == 2)
		{
			return monsterType_Obsidian;
		}
		if(argument2 == 3)
		{
			return monsterType_UmbralElemental;
		}
	}
	if(argument1 == 4)
	{
		if(argument2 == 2)
		{
			return monsterType_Onyx;
		}
		if(argument2 == 3)
		{
			return monsterType_UmbralAtronach;
		}
	}
	
	return monsterType_Umbress;
}
else
{
	return (monsterType_Flarial);	
}