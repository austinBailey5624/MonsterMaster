/// @description Insert description here
// You can write your code in this editor
//checks if the main theme is not currently being played
if(!audio_is_playing(sound_MainTheme))
{
	//quiets all old sounds
	audio_stop_all();
	//plays MainTheme
	audio_play_sound(sound_MainTheme,1,false);
}