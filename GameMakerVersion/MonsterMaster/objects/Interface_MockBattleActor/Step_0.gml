/// @description Decrease/Increase Health
if(m_healthCur>m_healthMax)
{
	m_healthCur=m_healthMax;	
}

if(m_healthCur<=0)
{
	image_alpha=.5
}