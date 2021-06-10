package tech.jour.cardstackview

import android.view.animation.AccelerateInterpolator
import android.view.animation.Interpolator

class PositiveSwipeAnimationSetting(
    override val direction: Direction = Direction.Right,
    override val duration: Int = 200,
    override val interpolator: Interpolator = AccelerateInterpolator()
) : BaseAnimationSetting()