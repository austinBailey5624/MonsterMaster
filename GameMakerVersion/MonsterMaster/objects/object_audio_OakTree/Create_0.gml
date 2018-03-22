/// @description Insert description here
// You can write your code in this editor
if(audio_is_playing(sound_MainTheme))
{
	audio_sound_gain(sound_MainTheme,1,0);
	audio_sound_gain(sound_MainTheme,0,800);
}
if(audio_is_playing(sound_Intro))
{
	audio_sound_gain(sound_Intro,1,0);
	audio_sound_gain(sound_Intro,0,800);	
}
if(!audio_is_playing(sound_OakTree))
{
	audio_stop_all();
	audio_play_sound(sound_OakTree,1,true);
}