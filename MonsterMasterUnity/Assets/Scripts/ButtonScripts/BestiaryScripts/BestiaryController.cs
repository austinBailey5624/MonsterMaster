using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class BestiaryController : MonoBehaviour
{
    public static BestiaryController bestiaryController;

    private SecondaryElement secondaryElement;

    private Color defaultColor;

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

        defaultColor = secondaryElement.getDefaultColor();
        Color highlightColor = secondaryElement.getHighlightColor();
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
        subElementNameText.GetComponent<TMP_Text>().color = defaultColor;
        subElementNameText.GetComponent<TMP_Text>().text =
            secondaryElement.getName();
        elderText.GetComponent<TMP_Text>().color = defaultColor;
        adultText.GetComponent<TMP_Text>().color = defaultColor;
        teenText.GetComponent<TMP_Text>().color = defaultColor;
        infantText.GetComponent<TMP_Text>().color = defaultColor;
        backText.GetComponent<TMP_Text>().color = defaultColor;

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
            adult0,
            adult1,
            adult2,
            adult3,
            adult4,
            adult5,
            elder0,
            elder1,
            elder2,
            elder3,
            elder4,
            elder5;

        baby = secondaryElement.getBaby();
        linkSlotAndType (babySlot, baby);
        List<MonsterType> babies = new List<MonsterType>() { baby };

        teen0 = baby.physicalEvolution;
        teen1 = baby.balancedEvolution;
        teen2 = baby.magicalEvolution;
        List<MonsterType> teens =
            new List<MonsterType>() { teen0, teen1, teen2 };

        for (int i = 0; i < teens.Count; i++)
        {
            linkSlotAndType(teenSlots[i], teens[i]);
        }
        // List<MonsterType> adults =
        //     new List<MonsterType>()
        //     { adult0, adult1, adult2, adult3, adult4, adult5 };
        // List<MonsterType> elders =
        //     new List<MonsterType>()
        //     { elder0, elder1, elder2, elder3, elder4, elder5 };

        //Assign values to adults
        if (teen0 != null)
        {
            adult0 =
                (teen0.physicalEvolution == null)
                    ? teen0.balancedEvolution
                    : teen0.physicalEvolution;

            if (adult0 != null)
            {
                linkSlotAndType(adult0Slot, adult0);
                elder0 = adult0.balancedEvolution;
                if (elder0 != null)
                {
                    linkSlotAndType(elder0Slot, elder0);
                }
            }

            adult1 = teen0.magicalEvolution;

            if (adult1 != null)
            {
                linkSlotAndType(adult1Slot, adult1);

                elder1 = adult1.balancedEvolution;
                if (elder1 != null)
                {
                    linkSlotAndType(elder1Slot, elder1);
                }
            }
        }
        if (teen1 != null)
        {
            adult2 =
                (teen1.physicalEvolution == null)
                    ? teen1.balancedEvolution
                    : teen1.physicalEvolution;

            if (adult2 != null)
            {
                adult2Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .monsterType = adult2;
                adult2Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .activate(defaultColor);
                elder2 = adult2.balancedEvolution;
                if (elder2 != null)
                {
                    elder2Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .monsterType = elder2;
                    elder2Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .activate(defaultColor);
                }
            }

            adult3 = teen1.magicalEvolution;

            if (adult3 != null)
            {
                adult3Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .monsterType = adult3;
                adult3Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .activate(defaultColor);

                elder3 = adult3.balancedEvolution;
                if (elder3 != null)
                {
                    elder3Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .monsterType = elder3;
                    elder3Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .activate(defaultColor);
                }
            }
        }
        if (teen2 != null)
        {
            adult4 =
                (teen2.physicalEvolution == null)
                    ? teen2.balancedEvolution
                    : teen2.physicalEvolution;
            if (adult4 != null)
            {
                adult4Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .monsterType = adult4;
                adult4Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .activate(defaultColor);
                elder4 = adult4.balancedEvolution;
                if (elder4 != null)
                {
                    elder4Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .monsterType = elder4;
                    elder4Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .activate(defaultColor);
                }
            }

            adult5 = teen2.magicalEvolution;
            if (adult5 != null)
            {
                adult5Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .monsterType = adult5;
                adult5Slot
                    .GetComponent<BestiaryMonsterTypeButton>()
                    .activate(defaultColor);
                elder5 = adult5.balancedEvolution;
                if (elder5 != null)
                {
                    elder5Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .monsterType = elder5;
                    elder5Slot
                        .GetComponent<BestiaryMonsterTypeButton>()
                        .activate(defaultColor);
                }
            }
        }

        babySlot.GetComponent<BestiaryMonsterTypeButton>().resolveLinks();

        resolve (teen0Slot);
        resolve (teen1Slot);
        resolve (teen2Slot);
        resolve (adult0Slot);
        resolve (adult1Slot);
        resolve (adult2Slot);
        resolve (adult3Slot);
        resolve (adult4Slot);
        resolve (adult5Slot);
        resolve (elder0Slot);
        resolve (elder1Slot);
        resolve (elder2Slot);
        resolve (elder3Slot);
        resolve (elder4Slot);
        resolve (elder5Slot);

        menuBackground.gameObject.GetComponent<SpriteRenderer>().color =
            defaultColor;
        leftElementSymbol.gameObject.GetComponent<SpriteRenderer>().sprite =
            elementSymbol;
        rightElementSymbol.gameObject.GetComponent<SpriteRenderer>().sprite =
            elementSymbol;
        bestiaryTitle.GetComponent<SpriteRenderer>().color = highlightColor;
        infantLabelBG.GetComponent<SpriteRenderer>().color = highlightColor;
        teenLabelBG.GetComponent<SpriteRenderer>().color = highlightColor;
        adultLabelBG.GetComponent<SpriteRenderer>().color = highlightColor;
        elderLabelBG.GetComponent<SpriteRenderer>().color = highlightColor;
        backButton.GetComponent<SpriteRenderer>().color = highlightColor;
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
