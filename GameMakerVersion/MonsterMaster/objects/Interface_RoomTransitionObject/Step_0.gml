/// @description Show transition Animation
if(m_transitionOccuring)
{
	
	sprite_index=m_transitionAnimation;
	//at last index stop
//	if(sprite_index.image_index == m_numFramesOfSprite-1)
	if(image_index > (image_number-1))
	{
		m_transitionOccuring=false;
//		layerId = layer_get_id(InvisibleMonsterTypeLayer);
		room_goto(m_targetRoom);
	}
}
