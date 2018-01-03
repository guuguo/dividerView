package top.guuguo.dividerview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;


public class DividerFrameLayout extends FrameLayout {
    public DividerFrameLayout(Context context) {
        super(context);
        init(context, null);
    }

    public DividerFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DividerFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public DividerDelegate delegate;

    private void init(Context context, AttributeSet attrs) {
        delegate = new DividerDelegate();
        delegate.resolveDrawable(DividerFrameLayout.this, context, attrs);
    }
}
