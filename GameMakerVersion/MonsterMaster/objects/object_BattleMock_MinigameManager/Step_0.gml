var alliesAlive=0;
var enemiesAlive=0;
if(MockBattleAlly1.m_healthCur>0)
{
	alliesAlive++;
}
if(MockBattleAlly2.m_healthCur>0)
{
	alliesAlive++;
}
if(MockBattleAlly3.m_healthCur>0)
{
	alliesAlive++;
}
if(MockBattleAlly4.m_healthCur>0)
{
	alliesAlive++;
}
if(MockBattleEnemy1.m_healthCur>0)
{
	enemiesAlive++;
}
if(MockBattleEnemy2.m_healthCur>0)
{
	enemiesAlive++;
}
if(MockBattleEnemy3.m_healthCur>0)
{
	enemiesAlive++;
}
if(MockBattleEnemy4.m_healthCur>0)
{
	enemiesAlive++;
}

if(alliesAlive<=0)
{
	room_goto(room_Defeat);
}
if(enemiesAlive<=0)
{
	room_goto(room_BattleMockVIctory);
}
m_clickPower=alliesAlive*3;
var difficulty = 200;
var AllyDam=difficulty*(enemiesAlive/alliesAlive)/fps_real;
var EnemyHeal=difficulty*enemiesAlive/fps_real;

if(MockBattleAlly1.m_healthCur>0)
{
	MockBattleAlly1.m_healthCur-=AllyDam;
}
if(MockBattleAlly2.m_healthCur>0)
{
	MockBattleAlly2.m_healthCur-=AllyDam;
}
if(MockBattleAlly3.m_healthCur>0)
{
	MockBattleAlly3.m_healthCur-=AllyDam;
}
if(MockBattleAlly4.m_healthCur>0)
{
	MockBattleAlly4.m_healthCur-=AllyDam;
}
if(MockBattleEnemy1.m_healthCur>0)
{
	MockBattleEnemy1.m_healthCur+=EnemyHeal;
}
if(MockBattleEnemy2.m_healthCur>0)
{
	MockBattleEnemy2.m_healthCur+=EnemyHeal;
}
if(MockBattleEnemy3.m_healthCur>0)
{
	MockBattleEnemy3.m_healthCur+=EnemyHeal;
}
if(MockBattleEnemy4.m_healthCur>0)
{
	MockBattleEnemy4.m_healthCur+=EnemyHeal;
}
//keyboard_check(vk_return)
//{
//	show_message(string(enemiesAlive));
//}