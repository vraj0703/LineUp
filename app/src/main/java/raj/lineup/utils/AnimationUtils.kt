package raj.lineup.utils

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.view.animation.Animation.AnimationListener
import android.widget.TextView


/**
 * Created by vraj0 on 3/25/2018.
 */
class AnimationUtils {


    companion object {
        fun moveAtoB(activity: AppCompatActivity, viewA: View, viewB: View) {
            val to_x = viewA.getX()
            val to_y = viewA.getY()


            val x_from = viewB.getX()
            val y_from = viewB.getY()
            //txtTwo.getLocationInWindow(fromLoc);
            //viewA.getLocationOnScreen(toLoc)

            val a = TranslateAnimation(x_from, to_x, y_from, to_y)
            a.duration = 700
            a.setAnimationListener(object : AnimationListener {

                override fun onAnimationStart(animation: Animation) {

                }

                override fun onAnimationRepeat(animation: Animation) {}

                override fun onAnimationEnd(animation: Animation) {
                    (viewB as TextView).text = (viewA as TextView).text.toString()
                }
            })
            viewA.startAnimation(a)
        }
    }
}