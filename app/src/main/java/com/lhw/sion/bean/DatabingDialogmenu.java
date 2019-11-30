package com.lhw.sion.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class DatabingDialogmenu {
    private int menu_image;
    private String menu_title;

    public DatabingDialogmenu() {

    }

    public DatabingDialogmenu(int menu_image, String menu_title) {
        this.menu_image = menu_image;
        this.menu_title = menu_title;
    }

    public int getMenu_image() {
        return menu_image;
    }

    public void setMenu_image(int menu_image) {
        this.menu_image = menu_image;
    }

    public String getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(String menu_title) {
        this.menu_title = menu_title;
    }
}
