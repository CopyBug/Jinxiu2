package com.lhw.sion.until.BindingAdapter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

import com.lhw.sion.ui.activity.LearnActivity;
import com.lhw.sion.until.BuilderManager;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

/**
 * 作者： 梁浩文, 日期： 2019/9/28.
 * 让代码更加美观
 */
public class BoomMenuButtonAdapter {
    @BindingAdapter({"initBoom"})
    public static void backDrawable(BoomMenuButton boomMenuButton,int cpunt) {
if(boomMenuButton!=null){
    assert boomMenuButton != null;
//    PiecePlaceEnum[] placeEnums={PiecePlaceEnum.DOT_2_1,PiecePlaceEnum.DOT_2_2,PiecePlaceEnum.DOT_3_1,PiecePlaceEnum.DOT_3_2,PiecePlaceEnum.DOT_3_3,PiecePlaceEnum.DOT_3_4,PiecePlaceEnum.DOT_4_1};
//    boomMenuButton.setButtonEnum(ButtonEnum.TextInsideCircle);
//    for (int i = 0; i <cpunt ; i++) {
//        boomMenuButton.setPiecePlaceEnum(placeEnums[i]);
//    }
////        boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.SC_2_1);
//    for (int i=0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
//        addBuilder(boomMenuButton);
//    }
    boomMenuButton.setButtonEnum(ButtonEnum.TextInsideCircle);
    boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);
    boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_2);
    for (int i=0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
        addBuilder(boomMenuButton);
    }
}
    }
    private static void addBuilder(BoomMenuButton boomMenuButton) {
        boomMenuButton.addBuilder(new TextInsideCircleButton.Builder()
                .normalImageRes(BuilderManager.getImageResource())
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Toast.makeText(boomMenuButton.getContext(), index+"", Toast.LENGTH_SHORT).show();
                    }

                }));

    }
}
