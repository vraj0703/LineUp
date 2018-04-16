package raj.first.view;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Random;

import raj.first.R;
import raj.first.view.textView.AnimationListener;
import raj.first.view.textView.HTextView;


/**
 * Created by vraj0 on 3/24/2018.
 */

public class FontTextView extends AppCompatTextView {


    public FontTextView(Context context) {
        this(context, null);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/aqua.ttf");
        setTypeface(type);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        @SuppressLint("ResourceType") AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(),
                R.anim.anim_fade_in);
        set.setTarget(this);
        set.start();
    }


}