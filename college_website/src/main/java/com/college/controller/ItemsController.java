package com.college.controller;


import com.college.domain.Items;
import com.college.service.ItemsService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/findDetail")
    public String findDetail(Model model){
        Items items = itemsService.findById(1);
        model.addAttribute("item", items);
        SetLogUtil.setLog(ItemsController.class).info("==设置成功item的视图模型，准备传递至前端==");
        return "itemDetail";
    }
}
