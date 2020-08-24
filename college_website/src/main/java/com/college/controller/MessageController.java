package com.college.controller;

import com.college.domain.Message;
import com.college.service.MessageService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class MessageController {
    static{
        SetLogUtil.setLog(MessageController.class).info("== 进入MessageController ==");
    }
    @Autowired
    private MessageService messageService;
    @RequestMapping("/college/message/messagebyid")
    public String MessageTest(Model model){
        HashMap map = new HashMap();
        map.put("messageId",1);
        List<Message> messgae=messageService.getMessage(map);
        model.addAttribute("allmessage",messgae);

            SetLogUtil.setLog(MessageController.class).info("== 视图模型添加，MessageController准备转发至前端 ==");

        return "test";
    }
}
