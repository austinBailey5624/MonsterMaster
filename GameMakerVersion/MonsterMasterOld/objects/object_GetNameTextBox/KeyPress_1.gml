/// @description Insert description here
// You can write your code in this editor
if(m_isSelected==true)//&& string_length(keyboard_string)> m_maxLength)
{
	if(string_length(m_text)==m_maxLength-1)
	{
		m_text =string_delete(m_text,string_length(m_text)-1,1);
		keyboard_string = m_text;
		return;	
	}
	m_text = keyboard_string;
}
else
{
	keyboard_string=string_delete(m_text,m_maxLength-1,1);
}