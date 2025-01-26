# MonsterMaster
## Overview
MonsterMaster is a Monster Catching RPG *cough* Pokemon Clone *cough* Developed by Austin Bailey. I've had this dream for this game Monster Master since 2016, the mechanics are very loosely based on https://figverse.fandom.com/wiki/Beast_Signer by Tobias Cornwall, although there are major differences, and the plot is based on my own DND campaign, which I will add to this repository at a later date. 

## How the repo is organized

Monster master has gone through many iterations in its alpha development, as I find a technology that works for a while, then abandon it due to its limitations (like with the old game maker studio version), or for unities new marketing strategy I could not abide in the case of the Unity version (deleted, in commit history if you're interested). I've also had various version of Java, which is now mainly used to manage the sql aspect of the game. The version currently under development is in android studio, which you can find in MonsterMasterMobile.

## What are the components doing?

1. Assets: this folder is to organize the assets being used by the projects, abandoned assets (assets no longer being used) are in Assets/Old 

2. MonsterMasterIncrementalJava (currently in development) this java project is using JDBC to read (and help me organize and clean up) the raw information from the ServerProject

3. MonsterMasterMobile (currently in development) This Android project reads from the files generated in MonsterMasterIncrementalJava and is the current version of the game

## Vision of the future 

I would like to get the first town and sequence as a playable demo in the mobile version of the game, then the first sixth will be available to play for free, with the following five chapters bringing enhancements that will be modestly expensive (perhaps 2.99 per additional chapter is the idea). Then (and this is a crazy dream stretch goal), I'll redo it using what I've learned to make a better version for the xbox and playstation stores.

## Differences from Pokemon
1. **The player matters** In Pokemon Games the user really doesnt matter at all other than as a way to move yourself around the screen. In MonsterMaster as the character you are an active participant in the battle and defeat occurs when you are knocked out, not just when the monster representing you is defeated *it also bears noting that monsters gain experience much faster than humans.
2. **There is player choice** that shapes the world around you.
3. **There isn't a single way to win the game.** There are factions that you side with and gain ranks and reputation with that determine how you play and end the game.
4. **The world is open.** Although there are gates to certain areas, (and certain areas are much more difficult than others) you can directly open them by sacrifice a monster with certain stats
5. **You can Combine monsters.** Part of the game is combining your monsters to make better monsters.
6. **Level Cap.** The level of monsters is capped based on how many monsters are in its family tree. A second generation will be more powerful and have a higher level cap than a first generation etc
7. **You don't catch monsters with pokeballs.** Instead, you try and impose your will over it and your success will be determined by your level differential and also the decisions you've made in the game - an aggressive player will be better at catching fire monsters, a passive player water monsters etc.
8. **Monster evolution isn't linear.** How you use the monster will determine how it evolves-usually. A monster that attacks physically will have a different evolution than if that same monster used only magical attacks.
9. **Monsters are Expensive** There is no infinite box to hold the monsters, keeping them costs money - higher for stronger revolutions/generations. You cant simply catch all of them, because you probably cant afford it-unless you own the world.

## FAQ

1. Q: Help I'm seeing discrepancies between versions! A: As this is a pre alpha project there are changes (and hopefully those changes can be considered improvements) all the time. The 'source of truth' is the sql project, which holds the raw data all versions SHOULD be based on.
  
2. Q: What is sc.sh? A: a script I wrote a while ago to simplify and standardize adding commits.

3. Q: How many monsters are there? A: Right now 339, though I may expand that in future releases

@Copyright 2016-2025 Austin Bailey all rights reserved