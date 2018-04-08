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
			return monsterType_Vulcanous
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
	return monsterType_MinorPhoenix;
}
else
{
	return (monsterType_Flarial);	
}