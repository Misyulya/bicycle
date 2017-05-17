package com.example.dmitry.bicycle.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.dmitry.bicycle.R;


public class TabView extends LinearLayout {

    private boolean mDisplayImage;

    public TabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(attrs);
        inflate(context, R.layout.tab_view, null);
    }

    private void setupAttributes(AttributeSet attrs) {
        TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.TabView, 0, 0);
        try {
            mDisplayImage = array.getBoolean(R.styleable.TabView_displayImage, false);
        } finally {
            array.recycle();
        }
    }

    public boolean isDisplayingImage(){
        return mDisplayImage;
    }

    public void setDisplayingImage(boolean state){
        mDisplayImage = state;
        invalidate();
        requestLayout();
    }

}
