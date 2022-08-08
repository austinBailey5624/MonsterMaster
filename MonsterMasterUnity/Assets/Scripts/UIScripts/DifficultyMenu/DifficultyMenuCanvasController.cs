using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class DifficultyMenuCanvasController : MonoBehaviour
{
    private static GameObject score;
    private static GameObject description;

    void Awake()
    {
        score = this.transform.GetChild(0).gameObject;
        description = this.transform.GetChild(1).gameObject;
    }

    void Update()
    {
        score.GetComponent<TMP_Text>().text = GameState.difficultyState.getScoreMultiplier() * 100 + "%";
        description.GetComponent<TMP_Text>().text = getText(DifficultyMenuState.selectedDifficultyType, GameState.difficultyState.getDifficultyLevel(DifficultyMenuState.selectedDifficultyType));
    }

    private string getText(DifficultyState.EDifficultyType type, DifficultyState.EDifficultyLevel level)
    {
        if (type == DifficultyState.EDifficultyType.Permadeath)
        {
            return getPermadeathText(level);
        }
        else if (type == DifficultyState.EDifficultyType.Combat)
        {
            return getCombatText(level);
        }
        else if (type == DifficultyState.EDifficultyType.Economy)
        {
            return getEconomyText(level);
        }
        else if (type == DifficultyState.EDifficultyType.MonsterStorage)
        {
            return getMonsterStorageText(level);
        }
        else if (type == DifficultyState.EDifficultyType.MonsterPartyLimit)
        {
            return getPartyLimitText(level);
        }
        else if (type ==  DifficultyState.EDifficultyType.ElementSelection)
        {
            return getElementSelectionText(level);
        }
        else if (type == DifficultyState.EDifficultyType.SelfVisibility)
        {
            return getSelfVisibilityText(level);
        }
        else //if (type == DifficultyState.EDifficultyType.DeityVisibility)
        {
            return getDeityVisibilityText(level);
        }
    }

    private string getPermadeathText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "Permadeath is disabled,\nYour fallen Monsters can be reclaimed at save points for free.\nYour score is reduced by 50%.";
        }
        else if (level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "Death is not permanent, but resurrection is expensive.\nYour score is unchanged.";
        }
        else
        {
            return "Death is permanent\nThe god of Death Thanatos smiles on you for your courage.\nYour score is increased by 100%.";
        }
    }

    private string getCombatText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "Combat is easy\nYour score is reduced by 50%.";
        }
        else if(level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "Combat is fair\nYour score is unchanged.";
        }
        else
        {
            return "Combat is brutal\nYour score is increased by 100%.";
        }
    }

    private string getEconomyText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "You make money quickly\nYour score is reduced by 20%.";
        }
        else if (level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "The economic game is challenging but fair\nYour score is unchanged.";
        }
        else
        {
            return "The economic game is difficult,\nrent is reduced making building an empire more difficult,\nYour score is increased by 40%";
        }
    }

    private string getMonsterStorageText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "Monster storage is unlimited,\n and they cost no upkeep\nYour score is reduced by 50%";
        }
        else if (level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "Monster storage is unlimited,\nbut each stored monster occurs a repeated expense\nYour score is unchanged";
        }
        else
        {
            return "You can only store up to your level of monsters,\nand each stored monster is greatly expensive\nYour score is increased by 30%";
        }
    }

    private string getPartyLimitText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "You can keep up to 6 monsters with no restrictions\nYour score is reduced by 50%.";
        }
        else if (level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "Your ability to keep monsters in your party is restricted by your level\nYour score is unchanged.";
        }
        else
        {
            return "Your ability to keep monsters is greatly limited based on your level\nYour score is increased by 80%";
        }
    }

    private string getElementSelectionText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "When combining monsters, the new monster is certain.\nReduce your score by 10%.";
        }
        else if (level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "There is an element of randomness when combining monsters.\nYour score is unchanged.";
        }
        else
        {
            return "When combining monsters, the new monster is very random.\nYour score is increasd by 15%";
        }
    }

    private string getSelfVisibilityText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "You know exaclty the value of each of your personality scores.\nYour score is reduced by 15%";
        }
        else if (level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "You have a vague idea of your personality scores.\nYour score is unchanged.";
        }
        else
        {
            return "There is no indication of your personality score.\nYour score is increased by 15%";
        }
    }

    private string getDeityVisibilityText(DifficultyState.EDifficultyLevel level)
    {
        if (level == DifficultyState.EDifficultyLevel.Easy)
        {
            return "You know exactly your relationship with all of the Gods and Factions.\n Your score is reduced by 15%.";
        }
        else if (level == DifficultyState.EDifficultyLevel.Medium)
        {
            return "You have a vague idea of your relationship with the Gods and Factions.\nYour score is unchanged.";
        }
        else
        {
            return "You have no indication of your relationship with the Gods and Factions.\nYour score is incresed by 20%\nPress Down to continue.";
        }
    }
}