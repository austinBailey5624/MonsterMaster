using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public interface IDescribedObject : INamedObject
{
    string getDescription();
}
