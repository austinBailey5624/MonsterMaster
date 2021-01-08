/// @description Insert description here
// You can write your code in this editor
if(audio_is_playing(sound_MainTheme))
{
	//fades the audio out
	audio_sound_gain(sound_MainTheme,1,0);
	audio_sound_gain(sound_MainTheme,0,800);	
}
if(!audio_is_playing(sound_Intro))
{
	//quiets all old sounds
	audio_stop_all();
	//plays MainTheme
	audio_play_sound(sound_Intro,1,false);
}