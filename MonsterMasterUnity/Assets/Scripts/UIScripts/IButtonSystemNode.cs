using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/**
*   Interface to represent buttons that are part of a node system
*   Copyright 2022, Austin Bailey
*/
public interface IButtonSystemNode : IButton
{
    bool getIsSelected();
    void select();
    void unSelect();
    IButtonSystemNode getUpButton();
    IButtonSystemNode getDownButton();
    IButtonSystemNode getLeftButton();
    IButtonSystemNode getRightButton();
}
