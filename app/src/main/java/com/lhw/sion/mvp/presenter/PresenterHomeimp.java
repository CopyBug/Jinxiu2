package com.lhw.sion.mvp.presenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hjq.base.BaseDialog;
import com.hjq.base.BaseDialogFragment;
import com.hjq.demo.R;
import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.common.BindingListining;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractHome;
import com.lhw.sion.mvp.model.ModelHome;

import de.hdodenhof.circleimageview.CircleImageView;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class PresenterHomeimp implements ContractHome.Presenter {
    CircleImageView imageView;
    TextView username;
    RecyclerView recyclerView;
    private ContractHome.View view;
    private ContractHome.Model model;
    public View dialogView;
    private BindingListining listining;
    private BaseDialog show;

    public PresenterHomeimp(ContractHome.View view, BindingListining bindingListining) {
        this.view = view;
        this.model=new ModelHome();
        this.listining=bindingListining;
    }

    @Override
    public void SelectUserBean() {
        String jinxiuPhone = UserInfo.Phone;
        String jinxiuPassword = UserInfo.Password;
        this.model.getUserBean(jinxiuPhone, jinxiuPassword, new JinxiuListning<SelectUserBean>() {
            @Override
            public void SuccessRequest(SelectUserBean selectUserBean) {
                view.setSelectUserBean(selectUserBean);

            }

            @Override
            public void FailRequest(Throwable throwable) {

            }

            @Override
            public void OtherError(String error) {

            }
        });
    }

    @Override
    public void initDialogView(SelectUserBean selectUserBean) {
           View dialogView = this.view.getDialogView();
           imageView= dialogView.findViewById(R.id.dialog_image);
           username= dialogView.findViewById(R.id.dialog_username);
           recyclerView=dialogView.findViewById(R.id.dialog_recyclerView);
           GridLayoutManager gridLayoutManager = new GridLayoutManager(this.view.setActivity(), 5);
           recyclerView.setLayoutManager(gridLayoutManager);
           DataBindingRecyclerAdapter recyclerAdapter=new DataBindingRecyclerAdapter(model.getDatabingMenulist(), R.layout.item_recy_menu, com.hjq.demo.BR.menu);
           recyclerView.setAdapter(recyclerAdapter);
           if(listining!=null){
               recyclerAdapter.setBindingListining(listining);
           }
        if(selectUserBean!=null){
            Glide.with(dialogView.getContext())
                    .load(selectUserBean.getBean().getImghead())
                    .error(R.drawable.ic_error)
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                    .into(imageView);
            username.setText(selectUserBean.getBean().getUsername());
        }
           this.dialogView=dialogView;
           showdialog();

    }

    @Override
    public void showdialog() {
        if(dialogView!=null){
            show = new BaseDialogFragment.Builder(this.view.setActivity()).setContentView(dialogView).show();
            show.setWindowAnimations(R.style.dialogWubdiwAnim);
        }

    }

    @Override
    public void hidedialog() {
        if(show!=null){
            show.dismiss();

        }
    }


}
