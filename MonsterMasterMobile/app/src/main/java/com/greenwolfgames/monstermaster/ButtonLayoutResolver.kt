package com.greenwolfgames.monstermaster

import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class ButtonLayoutResolver
{
    companion object
    {
        //Returns the ID of a given buttonLayoutAssignment for the provided choicesize, button index, and Layout Mode.
        public fun getButtonLayout(
            choiceSize: Int,
            buttonIndex: Int,
            layoutMode: ELayoutMode,
            buttons: List<Button>,
            parentId: Int
        ): Int
        {
            if (buttonIndex == 0)
            {
                return resolveTopLeftButton(choiceSize, layoutMode, buttons, parentId)
            }
            if (buttonIndex == 1)
            {
                return resolveTopRightButton(choiceSize, layoutMode, buttons, parentId)
            }
            if (buttonIndex == 2)
            {
                return resolveCenterLeftButton(choiceSize, layoutMode, buttons, parentId)
            }
            if (buttonIndex == 3)
            {
                return resolveCenterRightButton(choiceSize, layoutMode, buttons, parentId)
            }
            if (buttonIndex == 4)
            {
                return resolveBottomLeftButton(choiceSize, layoutMode, buttons, parentId)
            }
            return resolveBottomRightButton(choiceSize, layoutMode, buttons, parentId)
        }

        private fun resolveTopLeftButton(
            choiceSize: Int, layoutMode: ELayoutMode, buttons: List<Button>, parentId: Int
        ): Int
        {
            if (layoutMode == ELayoutMode.TOP_TO_TOP)
            {
                return parentId;
            }
            if (layoutMode == ELayoutMode.START_TO_START)
            {
                return parentId;
            }
            if (layoutMode == ELayoutMode.END_TO_START && choiceSize > 1)
            {
                return buttons[1].id
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_TOP && choiceSize > 2)
            {
                return buttons[2].id
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_BOTTOM && choiceSize < 3)
            {
                return parentId
            }
            return ConstraintLayout.LayoutParams.UNSET
        }

        private fun resolveTopRightButton(
            choiceSize: Int, layoutMode: ELayoutMode, buttons: List<Button>, parentId: Int
        ): Int
        {
            //if we shouldn't display this at all because we only have one button and this is the
            //second button shown
            if(choiceSize < 2)
            {
                return ConstraintLayout.LayoutParams.UNSET
            }
            if (layoutMode == ELayoutMode.TOP_TO_TOP)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.START_TO_END)
            {
                return buttons[0].id
            }
            if (layoutMode == ELayoutMode.END_TO_END)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_BOTTOM && choiceSize == 2)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_TOP && choiceSize == 3)
            {
                return buttons[2].id
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_TOP && choiceSize > 3)
            {
                return buttons[3].id
            }
            return ConstraintLayout.LayoutParams.UNSET
        }

        private fun resolveCenterLeftButton(
            choiceSize: Int, layoutMode: ELayoutMode, buttons: List<Button>, parentId: Int
        ): Int
        {
            if(choiceSize < 3)
            {
                return ConstraintLayout.LayoutParams.UNSET
            }
            if (layoutMode == ELayoutMode.TOP_TO_BOTTOM)
            {
                return buttons[0].id
            }
            if (layoutMode == ELayoutMode.START_TO_START)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.END_TO_END)
            {
                if (choiceSize == 3)
                {
                    return parentId;
                }
            }
            if (layoutMode == ELayoutMode.END_TO_START)
            {
                if(choiceSize > 3)
                {
                    return buttons[3].id
                }
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_BOTTOM && (choiceSize == 3 || choiceSize == 4))
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_TOP && choiceSize > 4)
            {
                return buttons[4].id
            }
            return ConstraintLayout.LayoutParams.UNSET
        }

        private fun resolveCenterRightButton(
            choiceSize: Int, layoutMode: ELayoutMode, buttons: List<Button>, parentId: Int
        ): Int
        {
            if(choiceSize < 4)
            {
                return ConstraintLayout.LayoutParams.UNSET
            }
            if (layoutMode == ELayoutMode.TOP_TO_BOTTOM)
            {
                return buttons[1].id
            }
            if (layoutMode == ELayoutMode.START_TO_END)
            {
                return buttons[2].id
            }
            if (layoutMode == ELayoutMode.END_TO_END)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_BOTTOM && choiceSize == 4)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_TOP && choiceSize > 4)
            {
                return buttons[5].id //4?
            }
            return ConstraintLayout.LayoutParams.UNSET
        }

        private fun resolveBottomLeftButton(
            choiceSize: Int, layoutMode: ELayoutMode, buttons: List<Button>, parentId: Int
        ): Int
        {
            if(choiceSize < 5)
            {
                return ConstraintLayout.LayoutParams.UNSET
            }
            if (layoutMode == ELayoutMode.TOP_TO_BOTTOM)
            {
                return buttons[2].id
            }
            if (layoutMode == ELayoutMode.START_TO_START)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.END_TO_END && choiceSize == 5)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.END_TO_START && choiceSize > 5)
            {
                return buttons[5].id
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_BOTTOM)
            {
                return parentId
            }
            return ConstraintLayout.LayoutParams.UNSET
        }

        private fun resolveBottomRightButton(
            choiceSize: Int, layoutMode: ELayoutMode, buttons: List<Button>, parentId: Int
        ): Int
        {
            if(choiceSize < 6)
            {
                return ConstraintLayout.LayoutParams.UNSET
            }
            if (layoutMode == ELayoutMode.TOP_TO_BOTTOM)
            {
                return buttons[3].id
            }
            if (layoutMode == ELayoutMode.START_TO_END)
            {
                return buttons[4].id
            }
            if (layoutMode == ELayoutMode.END_TO_END)
            {
                return parentId
            }
            if (layoutMode == ELayoutMode.BOTTOM_TO_BOTTOM)
            {
                return parentId
            }
            return ConstraintLayout.LayoutParams.UNSET
        }
    }
}