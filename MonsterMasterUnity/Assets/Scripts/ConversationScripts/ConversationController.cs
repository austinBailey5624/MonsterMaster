using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/** 
*   Class to control Conversations
*   Copyright 2022 Austin Bailey All rights Reserved
*/
public class ConversationController : MonoBehaviour
{
    public static ConversationController conversationController;

    private Color invisible = new Color(0f, 0f, 0f, 0f);

    private Color white = new Color(1f, 1f, 1f, 1f);

    private DesignColors colors;

    private GameObject statementBackground;

    private GameObject portraitBackground;

    private GameObject choice1Background;

    private GameObject choice2Background;

    private GameObject choice3Background;

    private GameObject choice4Background;

    private GameObject choice5Background;

    private GameObject choice6Background;

    private GameObject statementText;

    private GameObject choice1Text;

    private GameObject choice2Text;

    private GameObject choice3Text;

    private GameObject choice4Text;

    private GameObject choice5Text;

    private GameObject choice6Text;

    private GameObject speakerPortrait;

    private List<GameObject> backgrounds;

    private List<GameObject> texts;

    private SecondaryElement subElement;

    private IConversationNode conversationNode;

    private EDirection shouldMove = EDirection.Center;

    private float tolerance = .25f;

    private int selectedChoice = 1;

    private int wait = 120;

    private int curtime = 0;

    private bool isActive = false;

    private bool hasSubmitted = false;

    private void Awake()
    {
        if (conversationController == null)
        {
            conversationController = this;
        }
        else
        {
            Destroy(this.gameObject);
            return;
        }
    }

    void Start()
    {
        statementBackground = this.transform.GetChild(0).gameObject;
        portraitBackground = this.transform.GetChild(1).gameObject;
        choice1Background = this.transform.GetChild(2).gameObject;
        choice2Background = this.transform.GetChild(3).gameObject;
        choice3Background = this.transform.GetChild(4).gameObject;
        choice4Background = this.transform.GetChild(5).gameObject;
        choice5Background = this.transform.GetChild(6).gameObject;
        choice6Background = this.transform.GetChild(7).gameObject;
        statementText = this.transform.GetChild(8).gameObject;
        choice1Text = this.transform.GetChild(9).gameObject;
        choice2Text = this.transform.GetChild(10).gameObject;
        choice3Text = this.transform.GetChild(11).gameObject;
        choice4Text = this.transform.GetChild(12).gameObject;
        choice5Text = this.transform.GetChild(13).gameObject;
        choice6Text = this.transform.GetChild(14).gameObject;
        speakerPortrait = this.transform.GetChild(15).gameObject;
        backgrounds =
            new List<GameObject>()
            {
                statementBackground,
                portraitBackground,
                choice1Background,
                choice2Background,
                choice3Background,
                choice4Background,
                choice5Background,
                choice6Background
            };
        texts =
            new List<GameObject>()
            {
                statementText,
                choice1Text,
                choice2Text,
                choice3Text,
                choice4Text,
                choice5Text,
                choice6Text
            };
        for (int i = 0; i < backgrounds.Count; i++)
        {
            backgrounds[i].GetComponent<SpriteRenderer>().color = invisible;
        }
        for (int i = 0; i < texts.Count; i++)
        {
            texts[i].GetComponent<TMP_Text>().color = invisible;
            texts[i].GetComponent<TMP_Text>().text = "";
        }
        speakerPortrait.GetComponent<SpriteRenderer>().color = invisible;
    }

    void Update()
    {
        if (isActive && curtime > wait)
        {
            if (conversationNode == null)
            {
                isActive = false;
                return;
            }
            List<ConversationChoiceImpl> choices =
                conversationNode.getConversationChoices();
            if (choices.Count >= 1)
            {
                choice1Background.GetComponent<SpriteRenderer>().color =
                    colors.backgroundColor;
                choice1Text.GetComponent<TMP_Text>().text =
                    choices[0].getFlavorText();
                choice1Text.GetComponent<TMP_Text>().color =
                    colors.textColor;
            }
            if (choices.Count >= 2)
            {
                choice2Background.GetComponent<SpriteRenderer>().color =
                    colors.backgroundColor;
                choice2Text.GetComponent<TMP_Text>().text =
                    choices[1].getFlavorText();
                choice2Text.GetComponent<TMP_Text>().color =
                    colors.textColor;
            }
            if (choices.Count >= 3)
            {
                choice3Background.GetComponent<SpriteRenderer>().color =
                    colors.backgroundColor;
                choice3Text.GetComponent<TMP_Text>().text =
                    choices[2].getFlavorText();
                choice3Text.GetComponent<TMP_Text>().color =
                    colors.textColor;
            }
            if (choices.Count >= 4)
            {
                choice4Background.GetComponent<SpriteRenderer>().color =
                    colors.backgroundColor;
                choice4Text.GetComponent<TMP_Text>().text =
                    choices[3].getFlavorText();
                choice4Text.GetComponent<TMP_Text>().color =
                    colors.textColor;
            }
            if (choices.Count >= 5)
            {
                choice5Background.GetComponent<SpriteRenderer>().color =
                    colors.backgroundColor;
                choice5Text.GetComponent<TMP_Text>().text =
                    choices[4].getFlavorText();
                choice5Text.GetComponent<TMP_Text>().color =
                    colors.textColor;
            }
            if (choices.Count >= 6)
            {
                choice6Background.GetComponent<SpriteRenderer>().color =
                    colors.backgroundColor;
                choice6Text.GetComponent<TMP_Text>().text =
                    choices[5].getFlavorText();
                choice6Text.GetComponent<TMP_Text>().color =
                    colors.textColor;
            }
            if (selectedChoice == 1)
            {
                choice1Background.GetComponent<SpriteRenderer>().color =
                    colors.selectedColor;
            }
            if (selectedChoice == 2)
            {
                choice2Background.GetComponent<SpriteRenderer>().color =
                    colors.selectedColor;
            }
            if (selectedChoice == 3)
            {
                choice3Background.GetComponent<SpriteRenderer>().color =
                    colors.selectedColor;
            }
            if (selectedChoice == 4)
            {
                choice4Background.GetComponent<SpriteRenderer>().color =
                    colors.selectedColor;
            }
            if (selectedChoice == 5)
            {
                choice5Background.GetComponent<SpriteRenderer>().color =
                    colors.selectedColor;
            }
            if (selectedChoice == 6)
            {
                choice6Background.GetComponent<SpriteRenderer>().color =
                    colors.selectedColor;
            }
            float horizontal = Input.GetAxis("Horizontal");
            float vertical = Input.GetAxis("Vertical");
            float submit = Input.GetAxis("Submit");
            if (horizontal > tolerance)
            {
                shouldMove = EDirection.Right;
            }
            else if (horizontal < -tolerance)
            {
                shouldMove = EDirection.Left;
            }
            else if (vertical > tolerance)
            {
                shouldMove = EDirection.Up;
            }
            else if (vertical < -tolerance)
            {
                shouldMove = EDirection.Down;
            }
            if (submit > tolerance)
            {
                hasSubmitted = true;
            }
            if (
                Mathf.Abs(horizontal) < .001f &&
                Mathf.Abs(vertical) < .001f &&
                Mathf.Abs(submit) < .001f
            )
            {
                if (shouldMove == EDirection.Right)
                {
                    if (selectedChoice == 1 && choices.Count > 1)
                    {
                        selectedChoice = 2;
                    }
                    else if (selectedChoice == 2 && choices.Count > 2)
                    {
                        selectedChoice = 3;
                    }
                    else if (selectedChoice == 4 && choices.Count > 4)
                    {
                        selectedChoice = 5;
                    }
                    else if (selectedChoice == 5 && choices.Count > 5)
                    {
                        selectedChoice = 6;
                    }
                }
                else if (shouldMove == EDirection.Left)
                {
                    if (selectedChoice == 2 && choices.Count >= 1)
                    {
                        selectedChoice = 1;
                    }
                    else if (selectedChoice == 3 && choices.Count >= 3)
                    {
                        selectedChoice = 2;
                    }
                    else if (selectedChoice == 5 && choices.Count >= 5)
                    {
                        selectedChoice = 4;
                    }
                    else if (selectedChoice == 6 && choices.Count >= 6)
                    {
                        selectedChoice = 5;
                    }
                }
                else if (shouldMove == EDirection.Up)
                {
                    if (selectedChoice == 4 && choices.Count >= 4)
                    {
                        selectedChoice = 1;
                    }
                    else if (selectedChoice == 5 && choices.Count >= 5)
                    {
                        selectedChoice = 2;
                    }
                    else if (selectedChoice == 6 && choices.Count >= 6)
                    {
                        selectedChoice = 3;
                    }
                }
                else if (shouldMove == EDirection.Down)
                {
                    if (selectedChoice == 1 && choices.Count >= 4)
                    {
                        selectedChoice = 4;
                    }
                    else if (selectedChoice == 2 && choices.Count >= 5)
                    {
                        selectedChoice = 5;
                    }
                    else if (selectedChoice == 3 && choices.Count >= 6)
                    {
                        selectedChoice = 6;
                    }
                }
                if (hasSubmitted)
                {
                    if (choices.Count == 0)
                    {
                        this.Deactivate();
                        GameState.isFrozen = false;
                        curtime = 0;
                        hasSubmitted = false;
                        shouldMove = EDirection.Center;
                        return;
                    }
                    ConversationChoiceImpl selectedConvoChoice =
                        choices[selectedChoice - 1];
                    selectedConvoChoice.getEffect();
                    if (
                        selectedConvoChoice.getTerminatesConversation() ||
                        selectedConvoChoice.getNextNode() == null
                    )
                    {
                        this.Deactivate();
                        GameState.isFrozen = false;
                    }
                    else
                    {
                        selectedChoice = 1;
                        this.Deactivate();
                        this
                            .Activate(selectedConvoChoice.getNextNode(),
                            subElement, speakerPortrait.GetComponent<SpriteRenderer>().sprite);
                    }
                    curtime = 0;
                    hasSubmitted = false;
                }
                shouldMove = EDirection.Center;
            }
            curtime = 0;
        }
        curtime++;
    }

    public void Activate(
        IConversationNode conversationNode,
        SecondaryElement element,
        Sprite conversationSprite
    )
    {
        GameState.isFrozen = true;
        curtime = 0;
        this.conversationNode = conversationNode;
        isActive = true;
        subElement = element;
        colors = GameState.designColorsController.getElementDesignColors(element);
        statementBackground.GetComponent<SpriteRenderer>().color =
            colors.backgroundColor;
        statementText.GetComponent<TMP_Text>().text =
            conversationNode.getConversationText();
        statementText.GetComponent<TMP_Text>().color =
            colors.textColor;


        if(conversationSprite != null)
        {
            portraitBackground.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            speakerPortrait.GetComponent<SpriteRenderer>().sprite = conversationSprite;
            speakerPortrait.GetComponent<SpriteRenderer>().color = white;
        }


        List<ConversationChoiceImpl> choices =
            conversationNode.getConversationChoices();

        if (choices.Count == 0)
        {
            choice1Background.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            choice1Text.GetComponent<TMP_Text>().text = "Continue";
            choice1Text.GetComponent<TMP_Text>().color =
                colors.textColor;
        }
        if (choices.Count >= 1)
        {
            choice1Background.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            choice1Text.GetComponent<TMP_Text>().text =
                choices[0].getFlavorText();
            choice1Text.GetComponent<TMP_Text>().color =
                colors.textColor;
        }
        if (choices.Count >= 2)
        {
            choice2Background.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            choice2Text.GetComponent<TMP_Text>().text =
                choices[1].getFlavorText();
            choice2Text.GetComponent<TMP_Text>().color =
                colors.textColor;
        }
        if (choices.Count >= 3)
        {
            choice3Background.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            choice3Text.GetComponent<TMP_Text>().text =
                choices[2].getFlavorText();
            choice3Text.GetComponent<TMP_Text>().color =
                colors.textColor;
        }
        if (choices.Count >= 4)
        {
            choice4Background.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            choice4Text.GetComponent<TMP_Text>().text =
                choices[3].getFlavorText();
            choice4Text.GetComponent<TMP_Text>().color =
                colors.textColor;
        }
        if (choices.Count >= 5)
        {
            choice5Background.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            choice5Text.GetComponent<TMP_Text>().text =
                choices[4].getFlavorText();
            choice5Text.GetComponent<TMP_Text>().color =
                colors.textColor;
        }
        if (choices.Count >= 6)
        {
            choice6Background.GetComponent<SpriteRenderer>().color =
                colors.backgroundColor;
            choice6Text.GetComponent<TMP_Text>().text =
                choices[5].getFlavorText();
            choice6Text.GetComponent<TMP_Text>().color =
                colors.textColor;
        }
        configureButtons(choices.Count);
    }

    public void Deactivate()
    {
        isActive = false;
        for (int i = 0; i < backgrounds.Count; i++)
        {
            backgrounds[i].GetComponent<SpriteRenderer>().color = invisible;
        }
        for (int i = 0; i < texts.Count; i++)
        {
            texts[i].GetComponent<TMP_Text>().color = invisible;
            texts[i].GetComponent<TMP_Text>().text = "";
        }
        speakerPortrait.GetComponent<SpriteRenderer>().color = invisible;
    }

    /**
     * Responsible for reformatting the buttons in the conversation to their
     * appropriate sizes based on the nubmer of buttons
     */
    private void configureButtons(int numChoices)
    {
        if(numChoices < 2)
        {
            configure1Button();
            return;
        }
        if(numChoices == 2)
        {
            configure2Buttons();
            return;
        }
        if(numChoices == 3)
        {
            configure3Buttons();
            return;
        }
        if(numChoices < 7)
        {
            configure6Buttons();
            return;
        }
        Debug.Log("Conversation has more than 6 choices, this should not be allowed");
    }

    private void configure1Button()
    {
        configureButton(new Vector3(0, -350, 0), new Vector3(150, 100, 0), new Vector2(1300, 200), 1);
    }

    private void configure2Buttons()
    {
        Vector3 choiceScale = new Vector3(80, 110, 1);
        Vector2 textSizeDelta = new Vector2(750, 200);
        configureButton(new Vector3(-410, -350, 0), choiceScale, textSizeDelta, 1);
        configureButton(new Vector3(410,  -350, 0), choiceScale, textSizeDelta, 2);
    }

    private void configure3Buttons()
    {
        Vector3 choiceScale = new Vector3(53, 100, 1);
        Vector2 textSizeDelta = new Vector2(500, 200);
        configureButton(new Vector3(-540, -350, 0), choiceScale, textSizeDelta, 1);
        configureButton(new Vector3(0,    -350, 0), choiceScale, textSizeDelta, 2);
        configureButton(new Vector3(540,  -350, 0), choiceScale, textSizeDelta, 3);
    }

    private void configure6Buttons()
    {
        Vector3 choiceScale = new Vector3(53, 45, 1);
        Vector2 textSizeDelta = new Vector3(535, 110);
        int left   = -540;
        int center = 0;
        int right  = 540;
        int top    = -265;
        int bottom = -383;
        int zPos   = 0;
        configureButton(new Vector3(left,   top,    zPos), choiceScale, textSizeDelta, 1);
        configureButton(new Vector3(center, top,    zPos), choiceScale, textSizeDelta, 2);
        configureButton(new Vector3(right,  top,    zPos), choiceScale, textSizeDelta, 3);
        configureButton(new Vector3(left,   bottom, zPos), choiceScale, textSizeDelta, 4);
        configureButton(new Vector3(center, bottom, zPos), choiceScale, textSizeDelta, 5);
        configureButton(new Vector3(right,  bottom, zPos), choiceScale, textSizeDelta, 6);

    }

    private void configureButton(Vector3 choicePosition, Vector3 choiceScale, Vector2 textSizeDelta, int which)
    {
        backgrounds[which + 1].GetComponent<RectTransform>().transform.localPosition = choicePosition;
        backgrounds[which + 1].GetComponent<RectTransform>().transform.localScale = choiceScale;
        texts[which].GetComponent<RectTransform>().transform.localPosition = choicePosition;
        texts[which].GetComponent<RectTransform>().sizeDelta = textSizeDelta;
    }
}
