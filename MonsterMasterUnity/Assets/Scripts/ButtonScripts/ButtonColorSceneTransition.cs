using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ButtonColorSceneTransition : ButtonSceneTransition
{
    public Color objectColor;

    private Color currentColor;
    private Material materialColored;

    void Start()
    {
        if (objectColor != currentColor)
        {
            //helps stop memory leaks
            if (materialColored != null)
            {
//                UnityEditor.AssetDatabase.DeleteAsset(UnityEditor.AssetDatabase.GetAssetPath(materialColored));
            }


 //           materialColored = new Material(Shader.Find("Diffuse"));
 //           materialColored.color = currentColor = objectColor;
 //           this.GetComponent<Renderer>().material = materialColored;
        }

   //     defaultSprite = this.gameObject.GetComponent<SpriteRenderer>().sprite;
  //      this.gameObject.GetComponent<SpriteRenderer>().color = objectColor;
    }
    void OnMouseEnter()
    {
 //       this.gameObject.GetComponent<SpriteRenderer>().sprite = hoverSprite;
   ///     this.gameObject.GetComponent<SpriteRenderer>().color = objectColor;
    }
}
