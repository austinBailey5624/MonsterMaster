using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Combiner : MonoBehaviour
{
    void Update()
    {
        if (Input.GetAxis("Submit") > .1f && GameState.isFrozen == false)
        {

            Vector3 position = this.transform.position;
            Vector3 belowPosition =
                new Vector3(position.x, position.y - tilesize, position.z);
            Vector3 abovePosition =
                new Vector3(position.x, position.y + tilesize, position.z);
            Vector3 leftPosition =
                new Vector3(position.x - tilesize, position.y, position.z);
            Vector3 rightPosition = new Vector3(position.x + tilesize, position.y, position.z);
            if (
                (belowPosition - adjacentTransform.position).sqrMagnitude <
                tolerance
            )
            {
                setSprite(0, EDirection.Down);
                Action();
            }
            else if ((abovePosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0, EDirection.Up);
                Action();
            }
            else if ((rightPosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0, EDirection.Right);
                Action();
            }
            else if ((leftPosition - adjacentTransform.position).sqrMagnitude < tolerance)
            {
                setSprite(0, EDirection.Left);
                Action();
            }
        }
    }
}
