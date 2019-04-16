package com.ihplibrary.imanhp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class My_Bold_TextView extends AppCompatTextView {
    Context context;

    public My_Bold_TextView(Context context) {

        super(context);
        this.context = context;
        setPersianInteger();
        setLetterSpacing();
        setFont(context);

    }

    private void setPersianInteger() {
        String a = this.getText().toString();


        String[] pNum = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        a = a.replace("0", pNum[0]);
        a = a.replace("1", pNum[1]);
        a = a.replace("2", pNum[2]);
        a = a.replace("3", pNum[3]);
        a = a.replace("4", pNum[4]);
        a = a.replace("5", pNum[5]);
        a = a.replace("6", pNum[6]);
        a = a.replace("7", pNum[7]);
        a = a.replace("8", pNum[8]);
        a = a.replace("9", pNum[9]);
        this.setText(a + "");
    }

    @Override
    public void setText(final CharSequence text, final BufferType type) {
        String a = (String) text;
        String[] pNum = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        if (a != null && !a.isEmpty()) {
            a = a.replace("0", pNum[0]);
            a = a.replace("1", pNum[1]);
            a = a.replace("2", pNum[2]);
            a = a.replace("3", pNum[3]);
            a = a.replace("4", pNum[4]);
            a = a.replace("5", pNum[5]);
            a = a.replace("6", pNum[6]);
            a = a.replace("7", pNum[7]);
            a = a.replace("8", pNum[8]);
            a = a.replace("9", pNum[9]);
        }
        super.setText(a, BufferType.SPANNABLE);
    }

    public My_Bold_TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPersianInteger();
        setLetterSpacing();
        setFont(context);

    }

    public My_Bold_TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setPersianInteger();
        setLetterSpacing();
        setFont(context);

    }


    private void setFont(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "IRANSans_Bold.ttf");
        this.setTypeface(face);
    }

    private void setLetterSpacing() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            this.setLetterSpacing((float) 1.0);
//        }
        this.setScaleX(1);

    }
}
