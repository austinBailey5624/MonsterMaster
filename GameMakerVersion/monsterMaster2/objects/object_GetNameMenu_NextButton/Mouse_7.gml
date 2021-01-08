/// @description Check/Assign string
if(object_GetNameTextBox.m_text!="")//if the player wrote a name
{
	object_MainCharacter.m_name=object_GetNameTextBox.m_text;//assign the name
}
else//If the player didn't write a name
{
	object_MainCharacter.m_name="Hero";//Name hero "Hero", I know original right?
}
if(m_targetRoom!=noone)//checks that there is a room before transitioning
{
	object_MainCharacter.m_FrontSprite=GuyForwards;
	object_MainCharacter.m_BackSprite=GuyBack;
	object_MainCharacter.m_RightSprite=GuyRight;
	object_MainCharacter.m_LeftSprite=GuyLeft;
	object_MainParty.m_lead = object_MainCharacter;
	room_goto(m_targetRoom);
}