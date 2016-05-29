package be.myitworld.smartkitchen.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Jorciney on 29/05/2016.
 */
public class LinearLayoutSlider extends LinearLayout{
    private float yFraction = 0;
    private ViewTreeObserver.OnPreDrawListener preDrawListener = null;


    public LinearLayoutSlider(Context context) {
        super(context);
    }

    public LinearLayoutSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutSlider(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setYFraction(float fraction) {

        this.yFraction = fraction;

        if (getHeight() == 0) {
            if (preDrawListener == null) {
                preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        getViewTreeObserver().removeOnPreDrawListener(preDrawListener);
                        setYFraction(yFraction);
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(preDrawListener);
            }
            return;
        }

        float translationY = getHeight() * fraction;
        setTranslationY(translationY);
    }

    public float getYFraction() {
        return this.yFraction;
    }
}
