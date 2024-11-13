package com.greenwolfgames.monstermaster

import android.widget.ImageView

/**
 * Class to handle the information needed to dynamically apply and run animations on images
 * @author: Austin Bailey
 * @date: 11/13/2024
 *
 * @Copyright 2024 All rights reserved
 */
class AnimationInfo(val imageId: Int, val animationId: Int, val parentBackgroundId: Int, val imageScaleType: ImageView.ScaleType)
//TODO: extend so we can select image placement behind and in front of text
{
    constructor(imageId: Int, animationId: Int, parentBackgroundId: Int) : this(imageId, animationId, parentBackgroundId, ImageView.ScaleType.FIT_XY)
}