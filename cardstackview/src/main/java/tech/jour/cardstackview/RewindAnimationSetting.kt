package tech.jour.cardstackview

import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator

class RewindAnimationSetting(
    override val direction: Direction = Direction.Bottom,
    override val duration: Int = 200,
    override val interpolator: Interpolator = DecelerateInterpolator()
) : BaseAnimationSetting()