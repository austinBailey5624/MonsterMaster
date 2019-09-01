/// @description Insert description here
// You can write your code in this editor
object_MainParty.m_Lead = object_MainCharacter;
object_MainCharacter.depth = object_MainParty.depth;
collisionLayer = layer_tilemap_get_id("Collision");
if(object_MainParty.x mod 16 !=0)
{
	object_MainParty.x = object_MainParty.x mod 16;	
}
if(object_MainParty.y mod 16 != 0)
{
	object_MainParty.y = object_MainParty.y mod 16;
}
m_Lead.x = object_MainParty.x;
m_Lead.y = object_MainParty.y;