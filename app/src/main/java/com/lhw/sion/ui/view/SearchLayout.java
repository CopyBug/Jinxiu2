package com.lhw.sion.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;

import com.hjq.demo.R;
import com.lhw.sion.mvp.listning.SearchListining;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class SearchLayout extends FrameLayout implements TextWatcher, View.OnTouchListener, View.OnClickListener {
    private int INPUIFFINISH=100;

    private String CLEANTEXT="";
    Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if(msg.what==INPUIFFINISH){

                if (!(input.getText() + "").equals("")) {

                    if(searchListining!=null){
                        searchListining.inputText(input.getText() + "");
                    }
                    clean.setVisibility(VISIBLE);


                }else{
                    if(searchListining!=null){
                        searchListining.nulltext();
                    }
                    clean.setVisibility(GONE);
                }
            handler.removeCallbacks(mRunnable);

        }
    }
};
    @BindView(R.id.search_input)
    AppCompatEditText input;
    @BindView(R.id.search_btn)
    AppCompatButton search;
    @BindView(R.id.search_speak)
    AppCompatImageView speak;
    @BindView(R.id.search_clean)
    AppCompatImageView clean;
    private Context mContext;
    private View mView;
    private SearchListining searchListining;

    public void setSearchListining(SearchListining searchListining) {
        this.searchListining = searchListining;
    }

    public SearchLayout(@NonNull Context context) {
        super(context);
        initView(context, null);
    }

    public SearchLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public SearchLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public void initView(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.layout_search, this, true);
        ButterKnife.bind(mView);
        //设置焦点监听
        input.addTextChangedListener(this);
        //语音长按事件
        speak.setOnTouchListener(this);
        //清空事件
        clean.setOnClickListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        //每次进来先清除
        handler.removeCallbacks(mRunnable);
        //800毫秒没有输入认为输入完毕
        handler.postDelayed(mRunnable,300);
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
        handler.sendEmptyMessage(INPUIFFINISH);
        }
    };

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(searchListining!=null){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    searchListining.speakClick(true);
                    break;
                case MotionEvent.ACTION_UP:
                    searchListining.speakClick(false);
                    break;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_clean:
                input.setText("");
                break;
        }
    }
    public void setinputtext(String string){
        if(string!=null){
            input.setText(string);
            input.setSelection(string.length());
        }
    }
}
