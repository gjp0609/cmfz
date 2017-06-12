package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gjp06 on 17.6.12.
 */
@Controller("menuController")
@RequestMapping("/menu")
public class MenuController {

    @Resource(name = "menuService")
    private MenuService service;

    @RequestMapping("/getMenus")
    @ResponseBody
    public Menu[] getMenus() {
        List<Menu> menus = service.queryMenu();
        Menu[] mms = new Menu[menus.size()];
        for (int i = 0; i < menus.size(); i++) {
            mms[i] = menus.get(i);
        }
        return mms;
    }


}
