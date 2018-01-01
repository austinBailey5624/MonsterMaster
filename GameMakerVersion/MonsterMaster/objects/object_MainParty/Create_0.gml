/// @description Insert description here
// You can write your code in this editor
object_MainParty.m_lead = object_MainCharacter;
object_MainCharacter.depth = object_MainParty.depth;
collisionLayer = layer_tilemap_get_id("Collision");
m_lead.x = object_MainParty.x;
m_lead.y = object_MainParty.y;