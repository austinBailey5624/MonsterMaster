/// @description Specialized draw that handles drawing health bars
// You can write your code in this editor

draw_self()
var statusBarx;//the x position of where to draw the associated status bar
var statusBary;//the y position of where to draw the status bar

//This code chunk determines where to draw statusbar
if(m_isAlly)//since you're an ally, you're on the top row
{
	statusBarx=16;
}
else
{
	statusBarx=816;	
}

if(m_positionOnBattle==0)//if youre the leader
{
	statusBary=16;
}
else if(m_positionOnBattle==1)//second
{
	statusBary=224;	
}
else if(m_positionOnBattle==2)
{
	statusBary=432;	
}
else
{
	statusBary=640;	
}


//actually draw the status Bar

draw_sprite(m_HealthBar,-1,statusBarx,statusBary);
draw_sprite(m_HealthBar,-1,statusBarx,statusBary);
