package tech.jour.cardstackview

import android.view.animation.AccelerateInterpolator
import android.view.animation.Interpolator

class NegativeSwipeAnimationSetting(
    override val direction: Direction = Direction.Left,
    override val duration: Int = 200,
    override val interpolator: Interpolator = AccelerateInterpolator()
) : BaseAnimationSetting()