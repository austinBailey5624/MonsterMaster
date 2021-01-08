/// @description Insert description here
// You can write your code in this editor
camera = camera_create();
var viewMatrix = matrix_build_lookat(x,y,-10,x,y,0,0,1,0);
//var pm = matrix_build_projection_ortho(800,800,1,9999);
var projectionMatrix = matrix_build_projection_ortho(288,288,1,9999);
camera_set_view_mat(camera,viewMatrix);
camera_set_proj_mat(camera,projectionMatrix);

view_camera[0] = camera;

//follow = object_Guy;
//follow = object_MonsterSpriteChecker;
follow = object_MainParty.m_Lead;
x2 = x;   //x coordinate we're moving to
y2 = y;   //y coordinate we're moving to 
//if(follow = noone)
