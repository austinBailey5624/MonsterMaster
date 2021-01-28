function script_combineElements(argument0, argument1) {
	//logic for combining monsters by their subelements

	var first_primary = argument0.m_primaryElement;
	var first_secondary = argument0.m_secondaryElement;

	var second_primary = argument1.m_primaryElement;
	var second_secondary = argument1.m_secondaryElement;

	var tiebreaker = irandom(100);

	if (first_primary == second_primary)//(A,?),(A,?)
	{
		if(first_secondary == second_secondary)//(A,B),(A,B)
		{
			return (script_getSecondaryElementFromPrimaries(first_primary, second_primary));
		}
		if(first_primary == first_secondary)//(A,A),(A,?)
		{
			if(tiebreaker <70)
			{
				return (script_getSecondaryElementFromPrimaries(first_primary, first_secondary));
			}
			if(tiebreaker <90)
			{
				return (script_getSecondaryElementFromPrimaries(first_primary, second_secondary));
			}
			else
			{
				return (script_getSecondaryElementFromPrimaries(second_secondary,first_primary)); 
			}
		}
		if(first_primary == second_secondary)//(A,?),(A,A)
		{
			if(tiebreaker <60)
			{
				return (script_getSecondaryElementFromPrimaries(first_primary, first_secondary));
			}
			if(tiebreaker <80)
			{
				return (script_getSecondaryElementFromPrimaries(first_primary, second_secondary));
			}
			else
			{
				return (script_getSecondaryElementFromPrimaries(second_secondary,first_primary)); 
			}
		}
		//(A,B),(A,C)
		if(tiebreaker < 65)//(A,A) 65%
		{
			return (script_getSecondaryElementFromPrimaries(first_primary, second_primary));
		}
		if(tiebreaker < 85)//(A,B) 20%
		{
			return (script_getSecondaryElementFromPrimaries(first_primary, first_secondary));
		}
		else//(A,C) 15%
		{
			return (script_getSecondaryElementFromPrimaries(first_primary,second_secondary));
		}
	}
	//(A,?),(B,?)
	if(first_primary == second_secondary)//(A,?),(B,A)
	{
		if(first_primary == first_secondary)
		{
			if(first_secondary == second_primary)//(A,B),(B,A)
			{
				if(tiebreaker < 70)//(A,B) 70%
				{
					return script_getSecondaryElementFromPrimaries(first_primary, first_secondary);
				}
				else//(B,A) 30%
				{
					return script_getSecondaryElementFromPrimaries(first_secondary, first_primary);	
				}
			}
			if(first_primary == first_secondary)//(A,A),(B,A)
			{
				if(tiebreaker < 75)//(A,A) 75%
				{
					return script_getSecondaryElementFromPrimaries(first_primary, first_primary);	
				}
				if(tiebreaker < 95)//(A,B) 20%
				{
					return script_getSecondaryElementFromPrimaries(first_primary,second_primary);
				}
				else//(B,A) 5%
				{
					return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
				}
			}
		}
		//(A,C),(B,A)
		if(tiebreaker < 60)//(A,A) 60%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, first_primary);
		}
		if(tiebreaker < 85)//(A,B) 25%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, second_primary);
		}
		if(tiebreaker < 95)//(A,C) 10%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, first_secondary);
		}
		else//(B,A) 5%
		{
			return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
		}
	}
	//(A,B),(C,D) A!=C, A!=D

	if(first_primary = first_secondary)//(A,A),(?,?)
	{
		if(second_primary == second_secondary)//(A,A),(B,B)
		{
			if(tiebreaker < 80)//(A,B) 80%
			{
				return script_getSecondaryElementFromPrimaries(first_primary, second_primary);
			}		
			if(tiebreaker < 95)//(B,A) 15%
			{
				return script_getSecondaryElementFromPrimaries(second_primary, first_primary);
			}
			if(tiebreaker < 98)//(A,A) 3%
			{
				return script_getSecondaryElementFromPrimaries(first_primary, first_primary);
			}
			else//(B,B) 2%
			{
				return script_getSecondaryElementFromPrimaries(second_primary, second_primary);
			}
		}
		//(A,A),(B,C)
		if(tiebreaker < 60)//(A,B) 60%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, second_primary);
		}
		if(tiebreaker < 93)//(A,C) 33%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, second_secondary);
		}
		if(tiebreaker < 98)//(A,A) 5%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, first_secondary);
		}
		else//(B,C) 2%
		{
			return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
		}
	}
	//(A,B),(C,D) A!=B,C,D
	//check if secondary is pure
	if(second_primary == second_secondary)//(A,?),(B,B); A != 2
	{
		if(first_secondary = second_primary)//(A,B),(B,B)
		{
			if(tiebreaker < 70)//(B,B) 70%
			{
				return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
			}
			if(tiebreaker < 90)//(A,B) 20%
			{
				return script_getSecondaryElementFromPrimaries(first_primary, first_secondary);
			}
			else//(B,A) 10%
			{
				return script_getSecondaryElementFromPrimaries(second_primary, first_primary);
			}
		}
		//(A,C),(B,B)
	
		if(tiebreaker < 30)//(A,B)30%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, second_primary);
		}
		if(tiebreaker < 58)//(C,B)28%
		{
			return script_getSecondaryElementFromPrimaries(first_secondary, second_primary);
		}
		if(tiebreaker < 80)//(B,A)22%
		{
			return script_getSecondaryElementFromPrimaries(second_primary, first_primary);
		}
		if(tiebreaker < 92)//(A,C)12%
		{
			return script_getSecondaryElementFromPrimaries(first_primary,first_secondary);
		}
		else//(B,B)8%
		{
			return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
		}
	}
	//(A,B),(C,D) A!=B,C,D C!=D

	if(first_secondary == second_primary)//(A,B),(B,C)
	{
		if(tiebreaker < 50)//(A,B)50%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, second_primary);
		}
		if(tiebreaker < 75)//(A,C)25%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, second_secondary);
		}
		if(tiebreaker < 15)//(B,A)15%
		{
			return script_getSecondaryElementFromPrimaries(first_secondary, first_primary);
		}
		else//(B,C)10%
		{
			return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
		}
	}
	//(A,B),(C,D) A!=B,C,D; C!=D,B;

	if(first_secondary == second_secondary)//(A,B),(C,B)
	{
		if(tiebreaker < 55)//A,B 55%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, first_secondary);
		}
		if(tiebreaker < 90)//C,B 35%
		{
			return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
		}
		else//A,C 10%
		{
			return script_getSecondaryElementFromPrimaries(first_primary, second_primary);
		}
	}
	//(A,B),(C,D) all are different

	if(tiebreaker < 20)//A,C 20
	{
		return script_getSecondaryElementFromPrimaries(first_primary, second_primary);
	}
	if(tiebreaker < 37)//A,B 17
	{
		return script_getSecondaryElementFromPrimaries(first_primary, first_secondary);
	}
	if(tiebreaker < 52)//A,D 15
	{
		return script_getSecondaryElementFromPrimaries(first_primary, second_secondary);
	}
	if(tiebreaker < 65)//C,A 13
	{
		return script_getSecondaryElementFromPrimaries(second_primary, first_primary);
	}
	if(tiebreaker < 77)//C,B 12
	{
		return script_getSecondaryElementFromPrimaries(second_primary, first_secondary);
	}
	if(tiebreaker < 87)//C,D 10
	{
		return script_getSecondaryElementFromPrimaries(second_primary, second_secondary);
	}
	if(tiebreaker < 95)//B,A 8
	{
		return script_getSecondaryElementFromPrimaries(first_secondary, first_primary);
	}
	else//B,C 5
	{
		return script_getSecondaryElementFromPrimaries(first_secondary, second_primary);
	}



}
