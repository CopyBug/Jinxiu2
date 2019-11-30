package com.lhw.sion.mvp.contract;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.hjq.base.BaseLazyFragment;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.common.MyLazyFragment;
import com.lhw.sion.mvp.model.ModelSearchImp;
import com.lhw.sion.ui.activity.EnSearchActivity;

import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.WordStars;

/**
 * 作者： 梁浩文, 日期： 2019/10/16.
 * 让代码更加美观
 */
public interface ContractRecommentFragment {
    interface View extends BaseContract.View{
        MyLazyFragment getActivity();
        void requestSuccess(boolean isSuccess);
      default   void JumpSearchActivity(JinsanTransation jinsanTransation){
          Intent intent=new Intent(getActivity().getActivity(), EnSearchActivity.class);
          intent.putExtra("translation",jinsanTransation);
          getActivity().startActivityForResult(intent,null);
      }
        void reflushView(SelectVideo.BeanBean selectVideo);
        ViewGroup getviewGroup();
    }

    interface Presenter{
        void SearchWord(android.view.View view,String word);
        void reflushView(int title_id);
        void AddStar(android.view.View view, int title_id);

        void showEnjoy(android.view.View view,SelectVideo.BeanBean beanBean);
        void ShowCommentMsg(android.view.View mView, SelectVideo.BeanBean beanBean);
    }
}
