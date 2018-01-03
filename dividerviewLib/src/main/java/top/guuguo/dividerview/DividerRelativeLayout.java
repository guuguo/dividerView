package top.guuguo.dividerview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


public class DividerRelativeLayout extends RelativeLayout {
    public DividerRelativeLayout(Context context) {
        super(context);
        init(context, null);
    }

    public DividerRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DividerRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public DividerDelegate delegate;

    private void init(Context context, AttributeSet attrs) {
        delegate = new DividerDelegate();
        delegate.resolveDrawable(DividerRelativeLayout.this, context, attrs);
    }
}
