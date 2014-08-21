package com.scopely.fontain.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import static com.scopely.fontain.Fontain.getFontManager;
import static com.scopely.fontain.utils.FontViewUtils.initialize;


/**
 *
 * Behaves exactly like TextView, except it provides extra XML attributes to set the CapsMode, FontFamily, Weight and Width (Slope is taken from Android's native Italic support in android.R.attr.textStyle)
 *
 */
public class FontTextView extends TextView {
    public FontTextView(Context context) {
        super(context);
        initialize(this, context, null, getFontManager());
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(this, context, attrs, getFontManager());
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(this, context, attrs, getFontManager());
    }
}
