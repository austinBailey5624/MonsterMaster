using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ButtonSystemNode : MonoBehaviour
{
    public bool isSelected;

    protected Sprite defaultSprite;

    public Sprite hoverSprite;

    public string buttonName;

    public ButtonSystemNode upButton;

    public ButtonSystemNode rightButton;

    public ButtonSystemNode leftButton;

    public ButtonSystemNode downButton;

    public string nextSceneName;

    private float tolerance = .25f;

    private int shouldMove = 0;

    void Start()
    {
        defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
    }

    void Update()
    {
        if (isSelected)
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite = hoverSprite;
        }
        else
        {
            this.gameObject.GetComponent<SpriteRenderer>().sprite =
                defaultSprite;
        }
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
        float cancel = Input.GetAxis("Cancel");
        float submit = Input.GetAxis("Submit");
        if (isSelected)
        {
            if (horizontal > tolerance && rightButton != null)
            {
                shouldMove = 1;
            }
            else if (horizontal < -tolerance && leftButton != null)
            {
                shouldMove = 2;
            }
            else if (vertical > tolerance && upButton != null)
            {
                shouldMove = 3;
            }
            else if (vertical < -tolerance && downButton != null)
            {
                shouldMove = 4;
            }
            else if (submit > tolerance)
            {
                sceneTransition();
            }
            if (
                Mathf.Abs(horizontal) < .001f &&
                Mathf.Abs(vertical) < .001f &&
                Mathf.Abs(cancel) < .001f &&
                Mathf.Abs(submit) < .001f 
            )
            {
                if (shouldMove == 1)
                {
                    rightButton.isSelected = true;
                    this.isSelected = false;
                }
                else if (shouldMove == 2)
                {
                    leftButton.isSelected = true;
                    this.isSelected = false;
                }
                else if (shouldMove == 3)
                {
                    upButton.isSelected = true;
                    this.isSelected = false;
                }
                else if (shouldMove == 4)
                {
                    downButton.isSelected = true;
                    this.isSelected = false;
                }
                shouldMove = 0;
            }
        }
    }

    private void sceneTransition()
    {
        string tempPrevPlace = GameState.previousPlaceName;
        string tempPrevMenu = GameState.previousMenuName;
        string activeSceneName = SceneManager.GetActiveScene().name;
        if (activeSceneName.Contains("Menu") || activeSceneName.Contains("menu")
        )
        {
            GameState.previousMenuName = activeSceneName;
        }
        else
        {
            GameState.previousPlaceName = activeSceneName;
        }

        if (nextSceneName.Equals("previousPlace"))
        {
            SceneManager.LoadScene (tempPrevPlace);
        }
        else if (nextSceneName.Equals("previousMenu"))
        {
            SceneManager.LoadScene (tempPrevMenu);
        }
        else if (nextSceneName.Length > 1)
        {
            SceneManager.LoadScene (nextSceneName);
        }
    }
}
