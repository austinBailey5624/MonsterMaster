package com.greenwolfgames.monstermaster

import android.widget.ImageView
import android.widget.ImageView.ScaleType
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Class to handle the information needed to dynamically apply and run animations on images
 * @author: Austin Bailey
 * @date: 11/13/2024
 *
 * @Copyright 2024 All rights reserved
 */
class AnimationInfo(
    val imageId: Int,
    val animationId: Int,
    val imageScaleType: ImageView.ScaleType,
    val layoutParam: ConstraintLayout.LayoutParams
) //TODO: extend so we can select image placement behind and in front of text
{
    constructor(
        imageId: Int,
        animationId: Int,
        parentBackgroundId: Int,
        imageScaleType: ScaleType
    ) : this(
        imageId, animationId, imageScaleType, getDefaultLayoutParams(parentBackgroundId)
    )

    constructor(imageId: Int, animationId: Int, parentBackgroundId: Int) : this(
        imageId, animationId, parentBackgroundId, ImageView.ScaleType.FIT_XY
    )

    companion object
    {
        fun getDefaultLayoutParams(parentBackgroundId: Int): ConstraintLayout.LayoutParams
        {
            val layoutParam = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.UNSET, ConstraintLayout.LayoutParams.UNSET
            )

            layoutParam.width = 0
            layoutParam.height = 0
            layoutParam.matchConstraintDefaultWidth =
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
            layoutParam.matchConstraintPercentWidth = 0f
            layoutParam.matchConstraintDefaultHeight =
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
            layoutParam.matchConstraintPercentHeight = 0f
            layoutParam.startToStart = parentBackgroundId
            layoutParam.endToEnd = parentBackgroundId
            layoutParam.topToTop = parentBackgroundId
            layoutParam.bottomToBottom = parentBackgroundId
            layoutParam.startToEnd = ConstraintLayout.LayoutParams.UNSET
            layoutParam.endToStart = ConstraintLayout.LayoutParams.UNSET
            layoutParam.topToBottom = ConstraintLayout.LayoutParams.UNSET
            layoutParam.bottomToTop = ConstraintLayout.LayoutParams.UNSET

            return layoutParam
        }

        fun getDefaultLayoutParams(parentBackgroundId: Int, widthFactor: Float, heightFactor: Float): ConstraintLayout.LayoutParams
        {
            val layoutParam = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.UNSET, ConstraintLayout.LayoutParams.UNSET
            )

            layoutParam.width = 0
            layoutParam.height = 0
            layoutParam.matchConstraintDefaultWidth =
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
            layoutParam.matchConstraintPercentWidth = widthFactor
            layoutParam.matchConstraintDefaultHeight =
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
            layoutParam.matchConstraintPercentHeight = heightFactor
            layoutParam.startToStart = parentBackgroundId
            layoutParam.endToEnd = parentBackgroundId
            layoutParam.topToTop = parentBackgroundId
            layoutParam.bottomToBottom = parentBackgroundId
            layoutParam.startToEnd = ConstraintLayout.LayoutParams.UNSET
            layoutParam.endToStart = ConstraintLayout.LayoutParams.UNSET
            layoutParam.topToBottom = ConstraintLayout.LayoutParams.UNSET
            layoutParam.bottomToTop = ConstraintLayout.LayoutParams.UNSET

            return layoutParam
        }
    }
}