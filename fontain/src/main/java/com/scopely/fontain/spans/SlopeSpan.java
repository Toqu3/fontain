/*
 * Copyright (c) 2014 Scopely, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scopely.fontain.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

import com.scopely.fontain.enums.Slope;
import com.scopely.fontain.interfaces.Font;

import static com.scopely.fontain.Fontain.getFont;

/**
 * A span that sets the spanned text to the provided slope while maintaining weight and width
 */
public class SlopeSpan extends MetricAffectingSpan {
    private Slope slope;

    public SlopeSpan(Slope slope) {
        this.slope = slope;
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        apply(p);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        apply(tp);
    }

    private void apply(TextPaint p) {
        Typeface oldTypeFace = p.getTypeface();
        Font font = getFont(oldTypeFace);
        Typeface typeface = font.getFamily().getFont(font.getWeight(), font.getWidth(), slope.value).getTypeFace();
        p.setTypeface(typeface);
    }
}
