package raj.first.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import java.util.Random;

import raj.first.R;
import raj.first.view.textView.AnimationListener;
import raj.first.view.textView.HTextView;


/**
 * Created by vraj0 on 3/24/2018.
 */

public class FontTextView extends HTextView {

    public static final int INVALIDATE = 0x767;
    private Random random;
    private CharSequence mText;
    private Handler handler;
    private int charIncrease;
    private int typerSpeed;
    private AnimationListener animationListener;

    public FontTextView(Context context) {
        this(context, null);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
/*
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TyperTextView);
        typerSpeed = typedArray.getInt(R.styleable.TyperTextView_typerSpeed, 100);
        charIncrease = typedArray.getInt(R.styleable.TyperTextView_charIncrease, 2);
        typedArray.recycle();*/

        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/aqua.ttf");
        setTypeface(type);

        random = new Random();
        mText = getText();
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                int currentLength = getText().length();
                if (currentLength < mText.length()) {
                    if (currentLength + charIncrease > mText.length()) {
                        charIncrease = mText.length() - currentLength;
                    }
                    append(mText.subSequence(currentLength, currentLength + charIncrease));
                    long randomTime = typerSpeed + random.nextInt(typerSpeed);
                    Message message = Message.obtain();
                    message.what = INVALIDATE;
                    handler.sendMessageDelayed(message, randomTime);
                    return false;
                } else {
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(FontTextView.this);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void setAnimationListener(AnimationListener listener) {
        animationListener = listener;
    }


    public int getTyperSpeed() {
        return typerSpeed;
    }

    public void setTyperSpeed(int typerSpeed) {
        this.typerSpeed = typerSpeed;
    }

    public int getCharIncrease() {
        return charIncrease;
    }

    public void setCharIncrease(int charIncrease) {
        this.charIncrease = charIncrease;
    }

    @Override
    public void setProgress(float progress) {
        setText(mText.subSequence(0, (int) (mText.length() * progress)));
    }

    @Override
    public void animateText(CharSequence text) {
        if (text == null) {
            throw new RuntimeException("text must not  be null");
        }

        mText = text;
        setText("");
        Message message = Message.obtain();
        message.what = INVALIDATE;
        handler.sendMessage(message);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeMessages(INVALIDATE);
    }
}