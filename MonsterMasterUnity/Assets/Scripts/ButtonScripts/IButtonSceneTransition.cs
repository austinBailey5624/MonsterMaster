using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public interface IButtonSceneTransition : IButton
{
    string getNextSceneName();
}
