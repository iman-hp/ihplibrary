package com.ihplibrary.imanhp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class My_EditText extends AppCompatEditText {

    public My_EditText(Context context) {
        super(context);
        setFont(context);


    }

    public My_EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public My_EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face=Typeface.createFromAsset(context.getAssets(), "IRANSans.ttf");
        this.setTypeface(face);

    }
}
