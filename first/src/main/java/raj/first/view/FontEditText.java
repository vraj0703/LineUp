package raj.first.view;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import raj.first.R;

/**
 * Created by vraj0 on 3/24/2018.
 */

public class FontEditText extends AppCompatEditText {
    public FontEditText(Context context) {
        super(context);
        init(context);
    }


    public FontEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/aqua.ttf");
        setTypeface(type);
    }

}
