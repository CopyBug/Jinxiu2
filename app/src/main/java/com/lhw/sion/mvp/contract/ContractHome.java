package com.lhw.sion.mvp.contract;



import com.lhw.sion.bean.DatabingDialogmenu;

import java.util.List;

import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public interface ContractHome {
    interface View extends BaseContract.View{
        void setSelectUserBean(SelectUserBean selectUserBean);
        android.view.View getDialogView();
    }
    interface Model    {
       void getUserBean(String phone, String psw, JinxiuListning<SelectUserBean> listning);
       List<DatabingDialogmenu> getDatabingMenulist();
    }
    interface Presenter {
       void SelectUserBean();
       void initDialogView(SelectUserBean selectUserBean);
        void showdialog();
        void hidedialog();

    }
}
