package com.lhw.sion.mvp.listning;

import com.lhw.sion.bean.BeanSelectUser;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public interface OnBaseMvpListning {
    /**
     * @param beanSelectUser 用户初始化数据
     */
    void userInitialization(BeanSelectUser beanSelectUser);

    /**
     * @param throwable 网络错误信息
     */
    void networkRequestFailed(Throwable throwable);

    /**
     * @param error 权限信息
     */
    void permissionFailed(String error);
}
