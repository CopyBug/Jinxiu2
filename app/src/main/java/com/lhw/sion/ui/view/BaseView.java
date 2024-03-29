package com.lhw.sion.ui.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BaseView extends RelativeLayout{
	
	public Context context;
	
	public BaseView(Context context) {
		super(context);
		this.context = context;
	}
	
	public BaseView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public BaseView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
	}

	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}
}
