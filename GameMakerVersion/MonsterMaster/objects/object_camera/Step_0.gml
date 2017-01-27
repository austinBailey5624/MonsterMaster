/// @description Insert description here
// You can write your code in this editor
//code for smooth transition
/*
x += (x2-x)/25;//move a 25th of the distance between where we want to be (x2) and where we are
y += (y2-y)/25;
*/

x += (x2-x);
y += (y2-y);
if(follow != noone)//if we aren't following anyone
{
	x2 = follow.x;
	y2 = follow.y;
}

var viewMatrix = matrix_build_lookat(x,y,-10,x,y,0,0,1,0);//same as before
camera_set_view_mat(camera,viewMatrix);