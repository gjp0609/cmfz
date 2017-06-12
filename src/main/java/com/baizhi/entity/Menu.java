package com.baizhi.entity;

import java.util.List;

/**
 * menu
 * Created by gjp06 on 17.6.12.
 */
public class Menu {
    private String id;
    private String text;
    private String url;
    private String icon;
    private List<Menu> sonMenus;
    private Menu parentMenu;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", sonMenus=" + sonMenus +
                ", parentMenu=" + parentMenu +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getSonMenus() {
        return sonMenus;
    }

    public void setSonMenus(List<Menu> sonMenus) {
        this.sonMenus = sonMenus;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }
}
