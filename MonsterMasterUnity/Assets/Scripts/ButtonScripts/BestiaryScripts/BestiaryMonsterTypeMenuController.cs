using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/**
*   Class to control the behavior of the Bestiary Monster Type Menu
*   Copyright 2022 Austin Bailey All Rights Reserved.
*/
public class BestiaryMonsterTypeMenuController : MonoBehaviour
{
    private static BestiaryMonsterTypeMenuController bestiaryController;

    private SecondaryElement secondaryElement;

    private MonsterType monsterType;

    private Color defaultColor;

    private Color secondaryColor;

    private Color invisible = new Color(1f, 1f, 1f, 0f);

    private void Awake()
    {
        if (bestiaryController == null)
        {
            bestiaryController = this;
        }
        else
        {
            Destroy(this.gameObject);
            return;
        }

        secondaryElement = GameState.selectedBestiaryElement;
        monsterType = GameState.selectedBestiaryMonsterType;
        defaultColor = secondaryElement.defaultColor;
        secondaryColor = secondaryElement.highlightColor;
    }

    void Start()
    {
        GameObject canvas = this.transform.GetChild(0).gameObject;
        GameObject menuBackground = this.transform.GetChild(1).gameObject;
        GameObject monsterTypeTitle = this.transform.GetChild(2).gameObject;
        GameObject subElementSymbolLeft = this.transform.GetChild(3).gameObject;
        GameObject subElementSymbolRight =
            this.transform.GetChild(4).gameObject;
        GameObject monsterView = this.transform.GetChild(5).gameObject;
        GameObject description = this.transform.GetChild(6).gameObject;
        GameObject previousEvolutionTag = this.transform.GetChild(7).gameObject;
        GameObject physicalEvolutionTag = this.transform.GetChild(8).gameObject;
        GameObject balancedEvolutionTag = this.transform.GetChild(9).gameObject;
        GameObject magicalEvolutionTag = this.transform.GetChild(10).gameObject;
        GameObject backButton = this.transform.GetChild(11).gameObject;

        GameObject unchangingTextGroup =
            canvas.transform.GetChild(0).gameObject;
        GameObject monsterTypeNameText =
            unchangingTextGroup.transform.GetChild(0).gameObject;
        GameObject previousText =
            unchangingTextGroup.transform.GetChild(1).gameObject;
        GameObject physicalText =
            unchangingTextGroup.transform.GetChild(2).gameObject;
        GameObject balancedText =
            unchangingTextGroup.transform.GetChild(3).gameObject;
        GameObject magicalText =
            unchangingTextGroup.transform.GetChild(4).gameObject;
        GameObject backText =
            unchangingTextGroup.transform.GetChild(5).gameObject;
        GameObject descriptionText =
            unchangingTextGroup.transform.GetChild(6).gameObject;

        monsterTypeNameText.GetComponent<TMP_Text>().color = defaultColor;
        monsterTypeNameText.GetComponent<TMP_Text>().text =
            monsterType.getName();
        descriptionText.GetComponent<TMP_Text>().text =
            monsterType.getDescription();
        descriptionText.GetComponent<TMP_Text>().color = defaultColor;
        monsterView.GetComponent<BestiaryMonsterViewController>().monsterType =
            monsterType;

        backText.GetComponent<TMP_Text>().color = defaultColor;

        menuBackground.GetComponent<SpriteRenderer>().color = secondaryColor;
        monsterTypeTitle.GetComponent<SpriteRenderer>().color = secondaryColor;
        monsterView.GetComponent<SpriteRenderer>().color = secondaryColor;
        description.GetComponent<SpriteRenderer>().color = secondaryColor;

        if (monsterType.getPreviousEvolution() == null)
        {
            previousText.GetComponent<TMP_Text>().color = invisible;
            previousEvolutionTag.GetComponent<SpriteRenderer>().color =
                invisible;
        }
        else
        {
            previousText.GetComponent<TMP_Text>().color = defaultColor;
            previousEvolutionTag.GetComponent<SpriteRenderer>().color =
                secondaryColor;
            previousEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .monsterType = monsterType.getPreviousEvolution();
            previousEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .activate(secondaryColor);
        }

        if (monsterType.getPhysicalEvolution() == null)
        {
            physicalText.GetComponent<TMP_Text>().color = invisible;
            physicalEvolutionTag.GetComponent<SpriteRenderer>().color =
                invisible;
        }
        else
        {
            physicalText.GetComponent<TMP_Text>().color = defaultColor;
            physicalEvolutionTag.GetComponent<SpriteRenderer>().color =
                secondaryColor;
            physicalEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .monsterType = monsterType.getPhysicalEvolution();
            physicalEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .activate(secondaryColor);
        }

        if (monsterType.getBalancedEvolution() == null)
        {
            balancedText.GetComponent<TMP_Text>().color = invisible;
            balancedEvolutionTag.GetComponent<SpriteRenderer>().color =
                invisible;
        }
        else
        {
            balancedText.GetComponent<TMP_Text>().color = defaultColor;
            balancedEvolutionTag.GetComponent<SpriteRenderer>().color =
                secondaryColor;
            balancedEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .monsterType = monsterType.getBalancedEvolution();
            balancedEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .activate(secondaryColor);
        }

        if (monsterType.getMagicalEvolution() == null)
        {
            magicalText.GetComponent<TMP_Text>().color = invisible;
            magicalEvolutionTag.GetComponent<SpriteRenderer>().color =
                invisible;
        }
        else
        {
            magicalText.GetComponent<TMP_Text>().color = defaultColor;
            magicalEvolutionTag.GetComponent<SpriteRenderer>().color =
                secondaryColor;
            magicalEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>()
            .monsterType = monsterType.getMagicalEvolution();
            magicalEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>()
            .activate(secondaryColor);
        }

        backButton.GetComponent<SpriteRenderer>().color = secondaryColor;

        if (
            previousEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .isInContext
        )
        {
            previousEvolutionTag
                .GetComponent<BestiaryMonsterTypeMenuButton>()
                .resolveLinks();
        }
        if ( physicalEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>().isInContext)
        {
            physicalEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>().resolveLinks();
        }
        if ( balancedEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>().isInContext)
        {
            balancedEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>().resolveLinks();
        }
        if ( magicalEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>().isInContext)
        {
            magicalEvolutionTag.GetComponent<BestiaryMonsterTypeMenuButton>().resolveLinks();
        }

        backButton.GetComponent<BestiaryMonsterTypeMenuBackButton>().resolveLinks();

        monsterView.GetComponent<BestiaryMonsterViewController>().activate();
        subElementSymbolLeft.GetComponent<SpriteRenderer>().sprite =
            monsterType.getSecondaryElement().getDefaultSprite();
        subElementSymbolRight.GetComponent<SpriteRenderer>().sprite =
            monsterType.getSecondaryElement().getDefaultSprite();
    }
}