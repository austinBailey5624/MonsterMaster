using System.Collections;
using System.Collections.Generic;
using System.Linq;
using TMPro;
using UnityEngine;

/**
*    Class to control the Behavior of the bestiary Subelement Menu
*    Copyright 2022 Austin Bailey All rights reserved.
*/
public class BestiaryController : MonoBehaviour
{
    public static BestiaryController bestiaryController;

    private SecondaryElement secondaryElement;

    private Color defaultColor;

    private DesignColors designColors;

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
        secondaryElement = BestiaryMenuState.selectedBestiaryElement;
        designColors = GameState.designColorsController.getElementDesignColors(secondaryElement);
    }

    // Start is called before the first frame update
    void Start()
    {
        GameObject canvas = this.transform.GetChild(0).gameObject;
        GameObject menuBackground = this.transform.GetChild(1).gameObject;
        GameObject leftElementSymbol = this.transform.GetChild(2).gameObject;
        GameObject rightElementSymbol = this.transform.GetChild(3).gameObject;
        GameObject bestiaryTitle = this.transform.GetChild(4).gameObject;
        GameObject infantLabelBG = this.transform.GetChild(5).gameObject;
        GameObject teenLabelBG = this.transform.GetChild(6).gameObject;
        GameObject adultLabelBG = this.transform.GetChild(7).gameObject;
        GameObject elderLabelBG = this.transform.GetChild(8).gameObject;
        GameObject backButton = this.transform.GetChild(9).gameObject;

        defaultColor = designColors.backgroundColor;
        Color highlightColor = designColors.selectedColor;
        Color textColor = designColors.textColor;
        Sprite elementSymbol = secondaryElement.getDefaultSprite();

        GameObject unchangingTextGroup =
            canvas.transform.GetChild(0).gameObject;
        GameObject subElementNameText =
            unchangingTextGroup.transform.GetChild(0).gameObject;
        GameObject elderText =
            unchangingTextGroup.transform.GetChild(1).gameObject;
        GameObject adultText =
            unchangingTextGroup.transform.GetChild(2).gameObject;
        GameObject teenText =
            unchangingTextGroup.transform.GetChild(3).gameObject;
        GameObject infantText =
            unchangingTextGroup.transform.GetChild(4).gameObject;
        GameObject backText =
            unchangingTextGroup.transform.GetChild(5).gameObject;
        subElementNameText.GetComponent<TMP_Text>().color = textColor;
        subElementNameText.GetComponent<TMP_Text>().text =
            secondaryElement.getName();
        elderText.GetComponent<TMP_Text>().color = textColor;
        adultText.GetComponent<TMP_Text>().color = textColor;
        teenText.GetComponent<TMP_Text>().color = textColor;
        infantText.GetComponent<TMP_Text>().color = textColor;
        backText.GetComponent<TMP_Text>().color = textColor;

        GameObject babySlot = this.transform.GetChild(10).gameObject;
        GameObject teen0Slot = this.transform.GetChild(11).gameObject;
        GameObject teen1Slot = this.transform.GetChild(12).gameObject;
        GameObject teen2Slot = this.transform.GetChild(13).gameObject;
        GameObject adult0Slot = this.transform.GetChild(14).gameObject;
        GameObject adult1Slot = this.transform.GetChild(15).gameObject;
        GameObject adult2Slot = this.transform.GetChild(16).gameObject;
        GameObject adult3Slot = this.transform.GetChild(17).gameObject;
        GameObject adult4Slot = this.transform.GetChild(18).gameObject;
        GameObject adult5Slot = this.transform.GetChild(19).gameObject;
        GameObject elder0Slot = this.transform.GetChild(20).gameObject;
        GameObject elder1Slot = this.transform.GetChild(21).gameObject;
        GameObject elder2Slot = this.transform.GetChild(22).gameObject;
        GameObject elder3Slot = this.transform.GetChild(23).gameObject;
        GameObject elder4Slot = this.transform.GetChild(24).gameObject;
        GameObject elder5Slot = this.transform.GetChild(25).gameObject;

        List<GameObject> babySlots = new List<GameObject>() { babySlot };
        List<GameObject> teenSlots =
            new List<GameObject>() { teen0Slot, teen1Slot, teen2Slot };
        List<GameObject> adultSlots =
            new List<GameObject>()
            {
                adult0Slot,
                adult1Slot,
                adult2Slot,
                adult3Slot,
                adult4Slot,
                adult5Slot
            };
        List<GameObject> elderSlots =
            new List<GameObject>()
            {
                elder0Slot,
                elder1Slot,
                elder2Slot,
                elder3Slot,
                elder4Slot,
                elder5Slot
            };

        MonsterType
            baby,
            teen0,
            teen1,
            teen2,
            adult0 = null,
            adult1 = null,
            adult2 = null,
            adult3 = null,
            adult4 = null,
            adult5 = null,
            elder0 = null,
            elder1 = null,
            elder2 = null,
            elder3 = null,
            elder4 = null,
            elder5 = null;

        baby = secondaryElement.getBaby();
        linkSlotAndType (babySlot, baby);
        List<MonsterType> babies = new List<MonsterType>() { baby };

        teen0 = baby.physicalEvolution;
        teen1 = baby.balancedEvolution;
        teen2 = baby.magicalEvolution;
        List<MonsterType> teens =
            new List<MonsterType>() { teen0, teen1, teen2 };
        List<MonsterType> adults =
            new List<MonsterType>()
            { adult0, adult1, adult2, adult3, adult4, adult5 };
        List<MonsterType> elders =
            new List<MonsterType>()
            { elder0, elder1, elder2, elder3, elder4, elder5 };

        for (int i = 0; i < teens.Count; i++)
        {
            linkSlotAndType(teenSlots[i], teens[i]);
            if (teens[i] != null)
            {
                adults[i * 2] =
                    (teens[i].physicalEvolution == null)
                        ? teens[i].balancedEvolution
                        : teens[i].physicalEvolution;
                if (adults[i * 2] != null)
                {
                    linkSlotAndType(adultSlots[i * 2], adults[i * 2]);
                    elders[i * 2] = adults[i * 2].balancedEvolution;
                    if (elders[i * 2] != null)
                    {
                        linkSlotAndType(elderSlots[i * 2], elders[i * 2]);
                    }
                }
                adults[i * 2 + 1] = teens[i].magicalEvolution;
                if (adults[i * 2 + 1] != null)
                {
                    linkSlotAndType(adultSlots[i * 2 + 1], adults[i * 2 + 1]);
                    elders[i * 2 + 1] = adults[i * 2 + 1].balancedEvolution;
                    if (elders[i * 2 + 1] != null)
                    {
                        linkSlotAndType(elderSlots[i * 2 + 1],
                        elders[i * 2 + 1]);
                    }
                }
            }
        }

        //Resolve Links for all slots
        List<GameObject> allSlots =
            babySlots
                .Concat(teenSlots)
                .Concat(adultSlots)
                .Concat(elderSlots)
                .ToList();

        foreach (GameObject slot in allSlots)
        {
            resolve (slot);
        }

        menuBackground.gameObject.GetComponent<SpriteRenderer>().color =
            defaultColor;
        leftElementSymbol.gameObject.GetComponent<SpriteRenderer>().sprite =
            elementSymbol;
        rightElementSymbol.gameObject.GetComponent<SpriteRenderer>().sprite =
            elementSymbol;
        bestiaryTitle.GetComponent<SpriteRenderer>().color = defaultColor;
        infantLabelBG.GetComponent<SpriteRenderer>().color = defaultColor;
        teenLabelBG.GetComponent<SpriteRenderer>().color = defaultColor;
        adultLabelBG.GetComponent<SpriteRenderer>().color = defaultColor;
        elderLabelBG.GetComponent<SpriteRenderer>().color = defaultColor;
        backButton.GetComponent<SpriteRenderer>().color = defaultColor;
        backButton.GetComponent<DynamicButtonSystemNode>().setDesignColors(designColors);

        //if we have one teen
        if (
            !teen0Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext &&
            teen1Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext &&
            !teen2Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
        )
        {
            //If that one teen has one parent
            if (
                adult2Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                !adult3Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext
            )
            {
                //Straighten that parents x position
                Vector2 adult2SlotPosition = adult2Slot.transform.position;
                Vector2 teen1SlotPosition = teen1Slot.transform.position;
                adult2SlotPosition.x = teen1SlotPosition.x;
                adult2Slot.transform.position = adult2SlotPosition;

                //If the adult only has one parent
                if (
                    elder2Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext &&
                    !elder3Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder2SlotPosition = elder2Slot.transform.position;
                    elder2SlotPosition.x = adult2SlotPosition.x;
                    elder2Slot.transform.position = elder2SlotPosition;
                }
            }
        } //if we have two teens
        else if (
            teen0Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext &&
            !teen1Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext &&
            teen2Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
        )
        {
            Vector2 teen0SlotPosition = teen0Slot.transform.position;
            teen0SlotPosition.x = -1.5f;
            teen0Slot.transform.position = teen0SlotPosition;
            Vector2 teen2SlotPosition = teen2Slot.transform.position;
            teen2SlotPosition.x = 1.5f;
            teen2Slot.transform.position = teen2SlotPosition;

            //If Teen 0 has one parent
            if (
                adult0Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                !adult1Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext
            )
            {
                Vector2 adult0SlotPosition = adult0Slot.transform.position;
                adult0SlotPosition.x = teen0SlotPosition.x;
                adult0Slot.transform.position = adult0SlotPosition;
                if (
                    elder0Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder0SlotPosition = elder0Slot.transform.position;
                    elder0SlotPosition.x = adult0SlotPosition.x;
                    elder0Slot.transform.position = elder0SlotPosition;
                }
            }

            //If Teen 0 has two parents
            if (
                adult0Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                adult1Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
            )
            {
                Vector2 adult0SlotPosition = adult0Slot.transform.position;
                adult0SlotPosition.x = teen0SlotPosition.x - .75f;
                adult0Slot.transform.position = adult0SlotPosition;
                Vector2 adult1SlotPosition = adult1Slot.transform.position;
                adult1SlotPosition.x = teen0SlotPosition.x + .75f;
                adult1Slot.transform.position = adult1SlotPosition;
                if (
                    elder0Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder0SlotPosition = elder0Slot.transform.position;
                    elder0SlotPosition.x = adult0SlotPosition.x;
                    elder0Slot.transform.position = elder0SlotPosition;
                }
                if (
                    elder1Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder1SlotPosition = elder1Slot.transform.position;
                    elder1SlotPosition.x = adult1SlotPosition.x;
                    elder1Slot.transform.position = elder1SlotPosition;
                }
            }

            //If Teen 2 has one parent
            if (
                adult4Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                !adult5Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext
            )
            {
                Vector2 adult4SlotPosition = adult4Slot.transform.position;
                adult4SlotPosition.x = teen2SlotPosition.x;
                adult4Slot.transform.position = adult4SlotPosition;
                if (
                    elder4Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder4SlotPosition = elder4Slot.transform.position;
                    elder4SlotPosition.x = adult4SlotPosition.x;
                    elder4Slot.transform.position = elder4SlotPosition;
                }
            }

            //If Teen 2 has two parents
            if (
                adult4Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                adult5Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
            )
            {
                Vector2 adult4SlotPosition = adult4Slot.transform.position;
                adult4SlotPosition.x = teen2SlotPosition.x - .75f;
                adult4Slot.transform.position = adult4SlotPosition;
                Vector2 adult5SlotPosition = adult5Slot.transform.position;
                adult5SlotPosition.x = teen2SlotPosition.x + .75f;
                adult5Slot.transform.position = adult5SlotPosition;
                if (
                    elder4Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder4SlotPosition = elder4Slot.transform.position;
                    elder4SlotPosition.x = adult4SlotPosition.x;
                    elder4Slot.transform.position = elder4SlotPosition;
                }
                if (
                    elder5Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder5SlotPosition = elder5Slot.transform.position;
                    elder5SlotPosition.x = adult5SlotPosition.x;
                    elder5Slot.transform.position = elder5SlotPosition;
                }
            }
        } //if we have three teens
        else if (
            teen0Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext &&
            teen1Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext &&
            teen2Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
        )
        {
            Vector2 teen0SlotPosition = teen0Slot.transform.position;
            Vector2 teen1SlotPosition = teen1Slot.transform.position;
            Vector2 teen2SlotPosition = teen2Slot.transform.position;

            //If Teen 0 has one parent
            if (
                adult0Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                !adult1Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext
            )
            {
                Vector2 adult0SlotPosition = adult0Slot.transform.position;
                adult0SlotPosition.x = teen0SlotPosition.x;
                adult0Slot.transform.position = adult0SlotPosition;
                if (
                    elder0Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder0SlotPosition = elder0Slot.transform.position;
                    elder0SlotPosition.x = adult0SlotPosition.x;
                    elder0Slot.transform.position = elder0SlotPosition;
                }
            }

            //If Teen 0 has two parents
            if (
                adult0Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                adult1Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
            )
            {
                Vector2 adult0SlotPosition = adult0Slot.transform.position;
                adult0SlotPosition.x = teen0SlotPosition.x - .75f;
                adult0Slot.transform.position = adult0SlotPosition;
                Vector2 adult1SlotPosition = adult1Slot.transform.position;
                adult1SlotPosition.x = teen0SlotPosition.x + .75f;
                adult1Slot.transform.position = adult1SlotPosition;
                if (
                    elder0Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder0SlotPosition = elder0Slot.transform.position;
                    elder0SlotPosition.x = adult0SlotPosition.x;
                    elder0Slot.transform.position = elder0SlotPosition;
                }
                if (
                    elder1Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder1SlotPosition = elder1Slot.transform.position;
                    elder1SlotPosition.x = adult1SlotPosition.x;
                    elder1Slot.transform.position = elder1SlotPosition;
                }
            }

            //if Teen1 has one parent
            if (
                adult2Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                !adult3Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext
            )
            {
                Vector2 adult2SlotPosition = adult2Slot.transform.position;
                adult2SlotPosition.x = teen1SlotPosition.x;
                adult2Slot.transform.position = adult2SlotPosition;
                if (
                    elder2Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder2SlotPosition = elder2Slot.transform.position;
                    elder2SlotPosition.x = adult2SlotPosition.x;
                    elder2Slot.transform.position = elder2SlotPosition;
                }
            }

            //If teen2 has two parents
            if (
                adult2Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                adult3Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
            )
            {
                Vector2 adult2SlotPosition = adult2Slot.transform.position;
                adult2SlotPosition.x = teen1SlotPosition.x - .75f;
                adult2Slot.transform.position = adult2SlotPosition;
                Vector2 adult3SlotPosition = adult3Slot.transform.position;
                adult3SlotPosition.x = teen1SlotPosition.x + .75f;
                adult3Slot.transform.position = adult3SlotPosition;
                if (
                    elder2Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder2SlotPosition = elder2Slot.transform.position;
                    elder2SlotPosition.x = adult2SlotPosition.x;
                    elder2Slot.transform.position = elder2SlotPosition;
                }
                if (
                    elder3Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder3SlotPosition = elder3Slot.transform.position;
                    elder3SlotPosition.x = adult3SlotPosition.x;
                    elder3Slot.transform.position = elder3SlotPosition;
                }
            }

            //If Teen 2 has one parent
            if (
                adult4Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                !adult5Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext
            )
            {
                Vector2 adult4SlotPosition = adult4Slot.transform.position;
                adult4SlotPosition.x = teen2SlotPosition.x;
                adult4Slot.transform.position = adult4SlotPosition;
                if (
                    elder4Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder4SlotPosition = elder4Slot.transform.position;
                    elder4SlotPosition.x = adult4SlotPosition.x;
                    elder4Slot.transform.position = elder4SlotPosition;
                }
            }

            //If Teen 2 has two parents
            if (
                adult4Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .isInContext &&
                adult5Slot.GetComponent<BestiaryMonsterTypeButton>().isInContext
            )
            {
                Vector2 adult4SlotPosition = adult4Slot.transform.position;
                adult4SlotPosition.x = teen2SlotPosition.x - .75f;
                adult4Slot.transform.position = adult4SlotPosition;
                Vector2 adult5SlotPosition = adult5Slot.transform.position;
                adult5SlotPosition.x = teen2SlotPosition.x + .75f;
                adult5Slot.transform.position = adult5SlotPosition;
                if (
                    elder4Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder4SlotPosition = elder4Slot.transform.position;
                    elder4SlotPosition.x = adult4SlotPosition.x;
                    elder4Slot.transform.position = elder4SlotPosition;
                }
                if (
                    elder5Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .isInContext
                )
                {
                    Vector2 elder5SlotPosition = elder5Slot.transform.position;
                    elder5SlotPosition.x = adult5SlotPosition.x;
                    elder5Slot.transform.position = elder5SlotPosition;
                }
            }
        }
        //Adjust Xposition of Slots according to how many evolutions the previous monster type has
    }

    private void resolve(GameObject monsterTypeSlot)
    {
        if (
            monsterTypeSlot
                .GetComponent<BestiaryMonsterTypeButton>()
                .isInContext
        )
        {
            monsterTypeSlot
                .GetComponent<BestiaryMonsterTypeButton>()
                .resolveLinks();
        }
    }

    private void linkSlotAndType(GameObject slot, MonsterType monster)
    {
        if (monster != null)
        {
            slot.GetComponent<BestiaryMonsterTypeButton>().monsterType =
                monster;
            slot
                .GetComponent<BestiaryMonsterTypeButton>()
                .activate(defaultColor);
        }
    }
}
