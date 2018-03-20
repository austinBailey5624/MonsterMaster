/// @description Insert description here
// You can write your code in this editor
camera = camera_create();
var viewMatrix = matrix_build_lookat(72,72,-10,72,72,0,0,1,0);
//var pm = matrix_build_projection_ortho(800,800,1,9999);
var projectionMatrix = matrix_build_projection_ortho(144,144,1,9999);
camera_set_view_mat(camera,viewMatrix);
camera_set_proj_mat(camera,projectionMatrix);

view_camera[0] = camera;