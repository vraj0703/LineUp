package raj.first.view;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;

import raj.first.R;

/**
 * Created by vraj0 on 3/31/2018.
 */

public class FontTimeTextView extends FontEditText {


    public FontTimeTextView(Context context) {
        super(context);
        init();
    }

    public FontTimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(5);
        setFilters(fArray);
        setInputType(InputType.TYPE_CLASS_NUMBER);
        setHint("hh:mm");
        addTextChangedListener(new TextWatcher() {
            boolean _ignore = false;
            boolean add = true;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (before < start)
                    add = false;
                else
                    add = true;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (_ignore)
                    return;

                if (add)
                    if (s.length() == 3) {
                        _ignore = true;
                        setText(s.subSequence(0, 2) + ":" + s.charAt(2));
                        setSelection(4);
                        _ignore = false;
                    }

                /*if (!add) {
                    if (s.length() == 3) {
                        _ignore = true;
                        setText(s.subSequence(0, s.length() - 1));
                        setSelection(3);
                        _ignore = false;
                    }
                }*/
            }
        });
    }


}