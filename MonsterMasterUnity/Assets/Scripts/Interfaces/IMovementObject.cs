using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public interface IMovementObject : ISpritedObject
{
    Sprite Face(EDirection direction);

    Sprite Walk(EDirection direction, int index);
}
