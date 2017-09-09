package top.guuguo.dividerview.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import top.guuguo.dividerview.DividerDrawable;
import top.guuguo.dividerview.DividerLinearLayout;
import top.guuguo.dividerview.DividerTextView;

import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_YES;


public class MainActivity extends AppCompatActivity {
    int[] alignTypes = new int[]{DividerDrawable.dv_LC, DividerDrawable.dv_TC, DividerDrawable.dv_RC
            , DividerDrawable.dv_BC, DividerDrawable.dv_LB, DividerDrawable.dv_TR, DividerDrawable.dv_RT, DividerDrawable.dv_BL};
    int alignTypesPosition = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        final DividerTextView clickChangeView = (DividerTextView) findViewById(R.id.dtv_click_add_divider);
        clickChangeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alignTypesPosition == 4 || alignTypesPosition == 0) {
                    clickChangeView.delegate.clearDivider();
                }
                if (alignTypesPosition <= 3)
                    clickChangeView.delegate.addDivider(alignTypes[alignTypesPosition], dpToPx(2), 0, Color.WHITE, dpToPx(5));
                else
                    clickChangeView.delegate.addDivider(alignTypes[alignTypesPosition], dpToPx(2), dpToPx(30), Color.WHITE, 0);
                alignTypesPosition++;
                if (alignTypesPosition == 8) {
                    alignTypesPosition = 0;
                }
            }
        });
        DividerTextView tv4_2 = (DividerTextView) findViewById(R.id.text_4_2);
        tv4_2.delegate.addDivider(DividerDrawable.dv_RC, dpToPx(3), 0, Color.WHITE, dpToPx(3));
        DividerLinearLayout llB = (DividerLinearLayout) findViewById(R.id.dll_divider);
        llB.delegate.addDivider(DividerDrawable.dv_BR, dpToPx(3), dpToPx(120), Color.WHITE, dpToPx(16));

        DividerDrawable.DividerLine line = new DividerDrawable.DividerLine();
        line.setDividerColor(Color.WHITE)
                .setAlignType(DividerDrawable.dv_RB)
                .setDividerWidth(dpToPx(3))
                .setDividerLength(dpToPx(60))
                .setMargin(dpToPx(16));

        llB.delegate.addDivider(line);
    }

    int pxToDp(int px) {
        return (int) (px / getApplication().getResources().getDisplayMetrics().density + 0.5f);
    }

    int dpToPx(int dp) {
        return (int) (dp * getApplication().getResources().getDisplayMetrics().density + 0.5f);
    }
}
