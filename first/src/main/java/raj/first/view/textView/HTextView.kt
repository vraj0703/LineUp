package raj.first.view.textView

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by vraj0 on 3/25/2018.
 */

abstract class HTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {

    abstract fun setAnimationListener(listener: AnimationListener)

    abstract fun setProgress(progress: Float)

    abstract fun animateText(text: CharSequence)
}
