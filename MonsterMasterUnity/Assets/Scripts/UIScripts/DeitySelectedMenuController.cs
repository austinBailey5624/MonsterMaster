using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class DeitySelectedMenuController : MonoBehaviour
{
    private Color invisible = new Color(0f, 0f, 0f, 0f);
    private Color white = new Color(1f, 1f, 1f, 1f);

    void Start()
    {
        Deity deity = DeityMenuState.selectedDeity;
        SecondaryElement element = deity.getSecondaryElement();
        DesignColors colors = GameState.designColorsController.getElementDesignColors(element);

        DifficultyState.EDifficultyLevel difficultyLevel = GameState.difficultyState.getDifficultyLevel(DifficultyState.EDifficultyType.DeityVisibility);

        GameObject rankBackground = this.transform.GetChild(2).gameObject;
        GameObject scoreBackground = this.transform.GetChild(8).gameObject;
        GameObject deitySymbol = this.transform.GetChild(9).gameObject;
        GameObject elementSprite = this.transform.GetChild(10).gameObject;
        GameObject alignmentBar = this.transform.GetChild(11).gameObject;
        GameObject selector = this.transform.GetChild(12).gameObject;

        for (int i = 0; i < 8; i++)
        {
            this.transform.GetChild(i).gameObject.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
        }

        GameObject backButton = this.transform.GetChild(7).gameObject;
        backButton.gameObject.GetComponent<DeitySelectedBackButton>().designColors = colors;

        deitySymbol.gameObject.GetComponent<SpriteRenderer>().sprite = deity.getDefaultSprite();
        elementSprite.gameObject.GetComponent<SpriteRenderer>().sprite = element.getDefaultSprite();
        GameObject canvas = this.transform.GetChild(13).gameObject;
        for (int i = 0; i<8; i++)
        {
            canvas.transform.GetChild(i).gameObject.GetComponent<TMP_Text>().color = colors.textColor;
        }

        GameObject rankText = canvas.transform.GetChild(1).gameObject;
        GameObject scoreText = canvas.transform.GetChild(7).gameObject;
        if (difficultyLevel == DifficultyState.EDifficultyLevel.Hard)
        {
            rankBackground.GetComponent<SpriteRenderer>().color = invisible;
            rankText.GetComponent<TMP_Text>().color = invisible;
            scoreBackground.GetComponent<SpriteRenderer>().color = invisible;
            scoreText.GetComponent<TMP_Text>().color = invisible;
            alignmentBar.GetComponent<SpriteRenderer>().color = invisible;
            selector.GetComponent<SpriteRenderer>().color = invisible;
        }
        else if (difficultyLevel == DifficultyState.EDifficultyLevel.Medium)
        {
            rankText.GetComponent<TMP_Text>().text = "Rank: " + deity.getTitle(GameState.getAffinity(deity));
            rankText.GetComponent<TMP_Text>().color = colors.textColor;
            scoreBackground.GetComponent<SpriteRenderer>().color = invisible;
            scoreText.GetComponent<TMP_Text>().color = invisible;
            alignmentBar.GetComponent<SpriteRenderer>().color = white;
            selector.GetComponent<SpriteRenderer>().color = white;
            Vector2 position = selector.transform.localPosition;
            position.x = getXValue(GameState.getAffinity(deity));
            selector.transform.localPosition = position;
        }
        else//Easy
        {
            rankText.GetComponent<TMP_Text>().text = deity.getTitle(GameState.getAffinity(deity));
            rankText.GetComponent<TMP_Text>().color = colors.textColor;
            scoreBackground.GetComponent<SpriteRenderer>().color = colors.backgroundColor;
            string msg = "" + GameState.getAffinity(deity);
            scoreText.GetComponent<TMP_Text>().text = msg;
            scoreText.GetComponent<TMP_Text>().color = colors.textColor;
            alignmentBar.GetComponent<SpriteRenderer>().color = white;
            selector.GetComponent<SpriteRenderer>().color = white;
            Vector2 position = selector.transform.localPosition;
            position.x = getXValue(GameState.getAffinity(deity));
            selector.transform.localPosition = position;
        }
        GameObject name = canvas.transform.GetChild(0).gameObject;
        name.GetComponent<TMP_Text>().text = deity.getName();
        name.GetComponent<TMP_Text>().color = colors.textColor;
        GameObject descriptionText = canvas.transform.GetChild(2).gameObject;
        descriptionText.GetComponent<TMP_Text>().text = deity.getDescription();
        descriptionText.GetComponent<TMP_Text>().color = colors.textColor;
        GameObject gainFavorText = canvas.transform.GetChild(3).gameObject;
        gainFavorText.GetComponent<TMP_Text>().text = deity.howToImproveRelationship;
        gainFavorText.GetComponent<TMP_Text>().color = colors.textColor;
        GameObject loseFavorText = canvas.transform.GetChild(4).gameObject;
        loseFavorText.GetComponent<TMP_Text>().text = deity.howToDamageRelationship;
        loseFavorText.GetComponent<TMP_Text>().color = colors.textColor;
        GameObject associatedElementText = canvas.transform.GetChild(6).gameObject;
        associatedElementText.GetComponent<TMP_Text>().text = "Element: " + element.getName();
        associatedElementText.GetComponent<TMP_Text>().color = colors.textColor;

    }

    private float getXValue(int affinityValue)
    {
        float keyValue = 5f;
        int maxValue = 1000;
        //-1000 and worse should be x=1.75
        //+1000 and better should be x=-1.75
        if (affinityValue <= -maxValue)
        {
            return keyValue;
        }
        if (affinityValue >= maxValue)
        {
            return -keyValue;
        }
        return (affinityValue * (-keyValue / maxValue));
    }
}
