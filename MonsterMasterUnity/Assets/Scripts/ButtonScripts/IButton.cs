using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public interface IButton : ISpritedObject
{
    Sprite getSelectedSprite();
    void actionWhenSelected();
}