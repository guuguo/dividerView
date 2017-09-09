package top.guuguo.dividerview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;


public class DividerLinearLayout extends LinearLayout {
    public DividerLinearLayout(Context context) {
        super(context);
        init(context, null);
    }

    public DividerLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DividerLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public DividerDelegate delegate;

    private void init(Context context, AttributeSet attrs) {
        delegate = new DividerDelegate();
        delegate.resolveDrawable(DividerLinearLayout.this, context, attrs);
    }
}
