package com.lhw.sion.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hjq.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 梁浩文, 日期： 2019/10/10.
 * 让代码更加美观
 */
public class Sion_BottonNav extends FrameLayout {
    Context mContext;
    private View mView;
    @BindView(R.id.m_BottomNavigationView)
    BottomNavigationView bottomNavigationView;
    public Sion_BottonNav(@NonNull Context context) {
        super(context);
        initview(context,null);
    }

    public Sion_BottonNav(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview(context,attrs);
    }

    public Sion_BottonNav(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview(context,attrs);
    }

    private void initview(Context context, AttributeSet attrs) {
        this.mContext=context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.layout_discovery_below, this, true);
        ButterKnife.bind(mView);
        // 不使用图标默认变色
        bottomNavigationView.setItemIconTintList(null);
        inititem();
    }
    public void inititem(){
        Menu menu = bottomNavigationView.getMenu();
        bottomNavigationView.setItemIconSize(70);
//        zoomInPicture(item1);
//        zoomInPicture(item2);

    }
    public void zoomInPicture(MenuItem item){
        Drawable icon = item.getIcon();
        Bitmap bitmap = drawableToBitmap(icon);
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        item.setIcon(bitmapDrawable);
    }
    public void setlabel(int position,String num){
        Menu menu = bottomNavigationView.getMenu();
        int size = menu.size();
        if(size>position){
            MenuItem item = menu.getItem(position);
            Drawable icon = item.getIcon();
            Bitmap bitmap =   drawIconText(drawableToBitmap(icon),num);
            Drawable bitmapDrawable = new BitmapDrawable(bitmap);
            item.setIcon(bitmapDrawable);

        }

//        bottomNavigationView.setItemBackground();
    }
    public final   Bitmap drawableToBitmap(Drawable drawable){
        if(drawable!=null){
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth()+50, drawable.getIntrinsicHeight()+50, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
             drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
             drawable.draw(canvas);
             return bitmap;

        }
        return null;
    }

    public final   Bitmap drawableToBitmap_noZoom(Drawable drawable){
        if(drawable!=null){
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;

        }
        return null;
    }
    public final Bitmap drawIconText(Bitmap bitmap,String text){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas=new Canvas(bitmap); //画架
        Paint paint=new Paint();//画笔
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setTextSize(50);
        //画圆点

        //画文字
        canvas.drawText(text,width/2,height/2,paint);
        return bitmap;

    }
}
