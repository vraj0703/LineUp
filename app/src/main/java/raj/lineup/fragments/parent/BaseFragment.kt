package raj.lineup.fragments.parent

import android.support.v4.app.Fragment
import android.content.ContentValues.TAG
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils


/**
 * Created by vraj0 on 3/24/2018.
 */

abstract class BaseFragment : Fragment() {
    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {

        val anim = AnimationUtils.loadAnimation(activity, nextAnim)

        anim.setAnimationListener(object : AnimationListener {

            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                animationEnd(enter)
            }
        })

        return anim
    }

    abstract fun animationEnd(id: Boolean)
}
