package top.guuguo.dividerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class DividerDrawable extends Drawable {
    public static final int DEFAULT_DIVIDER_WIDTH = 1;
    public static final int DEFAULT_COLOR = 0xFFCCCCCC;

    public static final int dv_NO = 0;
    public static final int dv_TL = 1;
    public static final int dv_TC = 2;
    public static final int dv_TR = 3;
    public static final int dv_BL = 4;
    public static final int dv_BC = 5;
    public static final int dv_BR = 6;
    public static final int dv_LT = 7;
    public static final int dv_LC = 8;
    public static final int dv_LB = 9;
    public static final int dv_RT = 10;
    public static final int dv_RC = 11;
    public static final int dv_RB = 12;

    private ArrayList<DividerLine> dividerLines = new ArrayList();

    public void addDivider(DividerLine divider) {
        dividerLines.add(divider);
        invalidateSelf();
    }

    public void clearDivider() {
        dividerLines.clear();
        invalidateSelf();
    }

    public static class DividerLine {
        //        @AlignType
        private int alignType = dv_TL;
        private int dividerColor = DEFAULT_COLOR;
        private int dividerWidth = DEFAULT_DIVIDER_WIDTH;
        private int dividerLength = 0;
        private int startMargin = 0;
        private int endMargin = 0;
        private int margin = -1;

        public DividerLine setAlignType(int alignType) {
            this.alignType = alignType;
            return this;
        }

        public DividerLine setDividerColor(int dividerColor) {
            this.dividerColor = dividerColor;
            return this;
        }

        public DividerLine setDividerWidth(int dividerWidth) {
            this.dividerWidth = dividerWidth;
            return this;
        }

        public DividerLine setDividerLength(int dividerLength) {
            this.dividerLength = dividerLength;
            return this;
        }

        public DividerLine setStartMargin(int startMargin) {
            this.startMargin = startMargin;
            return this;
        }

        public DividerLine setEndMargin(int endMargin) {
            this.endMargin = endMargin;
            return this;

        }

        public DividerLine setMargin(int margin) {
            this.margin = margin;
            return this;

        }
    }
//
//    @IntDef({dv_NO, dv_TL, dv_TC, dv_TR, dv_BL, dv_BC, dv_BR, dv_LT, dv_LC, dv_LB, dv_RT, dv_RC, dv_RB})
//    @Retention(RetentionPolicy.SOURCE)
//    public @interface AlignType {
//    }

    private final Paint paint;
    private final Paint backgroundPaint;

    public DividerDrawable(int color) {
        paint = new Paint();
        backgroundPaint = new Paint();
        if (color != Integer.MAX_VALUE)
            backgroundPaint.setColor(color);
        else backgroundPaint.setColor(Color.TRANSPARENT);
    }


    @Override
    public void draw(Canvas canvas) {
        Rect rect = getBounds();
        canvas.drawRect(rect, backgroundPaint);
        for (DividerLine divider : dividerLines) {
            paint.setColor(divider.dividerColor);
            Rect layoutRect = layout(rect.right - rect.left, rect.bottom - rect.top, divider);
            canvas.drawRect(layoutRect, paint);
        }
    }

    /**
     * @return int[] {startX, startY, stopX, stopY}
     */
    public Rect layout(int width, int height, DividerLine divider) {
        int marginStart = getMarginStart(divider);
        int marginEnd = getMarginEnd(divider);
        Rect rect = new Rect();
        int realDividerLength = divider.dividerLength;
        if (realDividerLength == 0 && divider.alignType <= 6)//上或者下绘制
            realDividerLength = width - marginStart - marginEnd;
        else if (realDividerLength == 0 && divider.alignType > 6)//左或者右绘制
            realDividerLength = height - marginStart - marginEnd;
        int hCenterWidth = ((width - marginStart - marginEnd) - realDividerLength) / 2;
        if (hCenterWidth < 0)
            hCenterWidth = 0;

        int vCenterWidth = ((height - marginStart - marginEnd) - realDividerLength) / 2;
        if (vCenterWidth < 0)
            vCenterWidth = 0;

        switch (divider.alignType) {
            case dv_TL:
                rect.left = marginStart;
                rect.top = 0;
                rect.right = realDividerLength + marginStart;
                rect.bottom = divider.dividerWidth;
                break;
            case dv_TC:
                rect.left = marginStart + hCenterWidth;
                rect.top = 0;
                rect.right = realDividerLength + marginStart + hCenterWidth;
                rect.bottom = divider.dividerWidth;
                break;
            case dv_TR:
                rect.left = width - realDividerLength - marginEnd;
                rect.top = 0;
                rect.right = width - marginEnd;
                rect.bottom = divider.dividerWidth;
                break;
            case dv_BL:
                rect.left = marginStart;
                rect.top = height - divider.dividerWidth;
                rect.right = realDividerLength + marginStart;
                rect.bottom = height;
                break;
            case dv_BC:
                rect.left = marginStart + hCenterWidth;
                rect.top = height - divider.dividerWidth;
                rect.right = realDividerLength + marginStart + hCenterWidth;
                rect.bottom = height;
                break;
            case dv_BR:
                rect.left = width - realDividerLength - marginEnd;
                rect.top = height - divider.dividerWidth;
                rect.right = width - marginEnd;
                rect.bottom = height;
                break;
            case dv_LT:
                rect.left = 0;
                rect.top = marginStart;
                rect.right = divider.dividerWidth;
                rect.bottom = realDividerLength + marginStart;
                break;
            case dv_LC:
                rect.left = 0;
                rect.top = marginStart + vCenterWidth;
                rect.right = divider.dividerWidth;
                rect.bottom = realDividerLength + marginStart + vCenterWidth;
                break;
            case dv_LB:
                rect.left = 0;
                rect.top = height - realDividerLength - marginEnd;
                rect.right = divider.dividerWidth;
                rect.bottom = height - marginEnd;
                break;
            case dv_RT:
                rect.left = width - divider.dividerWidth;
                rect.top = marginStart;
                rect.right = width;
                rect.bottom = realDividerLength + marginStart;
                break;
            case dv_RC:
                rect.left = width - divider.dividerWidth;
                rect.top = marginStart + vCenterWidth;
                rect.right = width;
                rect.bottom = realDividerLength + marginStart + vCenterWidth;
                break;
            case dv_RB:
                rect.left = width - divider.dividerWidth;
                rect.top = height - realDividerLength - marginEnd;
                rect.right = width;
                rect.bottom = height - marginEnd;
                break;
        }
        return rect;
    }

    private int getMarginStart(DividerLine divider) {
        if (divider.margin == -1)
            return divider.startMargin;
        else return divider.margin;
    }

    private int getMarginEnd(DividerLine divider) {
        if (divider.margin == -1)
            return divider.endMargin;
        else return divider.margin;
    }

    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }


    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
