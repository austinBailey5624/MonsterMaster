//Returns the correct sprite index given a maxHP and curHP for the bar
{
	var cur, maxi;
	cur = argument0;
	maxi = argument1;
	if(cur<1)
	{
		return(0);
	}
	if(cur>=maxi)
	{
		return(172);
	}
	return ceil((cur/maxi)*171);
}