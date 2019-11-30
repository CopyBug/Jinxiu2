package com.lhw.sion.mvp.model;

import com.hjq.demo.R;
import com.lhw.sion.bean.DatabingDialogmenu;
import com.lhw.sion.mvp.contract.ContractHome;

import java.util.ArrayList;
import java.util.List;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class ModelHome implements ContractHome.Model {

    @Override
    public void getUserBean(String phone, String psw, JinxiuListning<SelectUserBean> beanJinxiuListning) {
        if(phone!=null&&psw!=null){
            JinxiuImp.selectUser(phone,psw,beanJinxiuListning);
        }
    }

    @Override
    public List<DatabingDialogmenu> getDatabingMenulist() {
        List<DatabingDialogmenu> databingDialogmenus=new ArrayList<>();
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_person,"个人中心"));
                databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_recording,"统计中心"));
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_night,"夜间模式"));
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_video,"视频学习"));
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_tool,"工具箱"));
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_wrongbook,"错题本"));
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_search,"搜索"));
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_setting,"设置"));

        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_logout,"注销"));
        databingDialogmenus.add(new DatabingDialogmenu(R.drawable.menu_exit,"退出"));
        return databingDialogmenus;
    }

}
