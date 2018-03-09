/// @description Show transition Animation
if(m_transitionOccuring)
{
	
	sprite_index=m_transitionAnimation;
	//at last index stop
//	if(sprite_index.image_index == m_numFramesOfSprite-1)
	if(image_index > (image_number-1))
	{
		m_transitionOccuring=false;
		room_goto(m_targetRoom);
	}
}
