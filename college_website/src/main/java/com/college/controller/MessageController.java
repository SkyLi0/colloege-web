package com.college.controller;

import com.college.domain.Message;
import com.college.service.MessageService;
import com.college.utils.SetLogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController
public class MessageController{
    static{
        SetLogUtil.setLog(MessageController.class).info("== 进入MessageController ==");
    }
    @Autowired
    private MessageService messageService;
//        @RequestMapping("/college/message/getMessage")//按条件查询文章页面
////    public String getMessage(Model model,int id){
////        HashMap map = new HashMap();
////        map.put("author","信息学院");
////        map.put("messageId",id);
////        List<Message> messgae=messageService.getMessage(map);
////        model.addAttribute("message",messgae);
////            SetLogUtil.setLog(MessageController.class).info("== getMessage视图模型添加，准备转发至前端 ==");
////
////        return "message";
////    }



//测试，为了方便写了3个前后端不分离的测试功能：

    @RequestMapping("/college/message/getAllMessage")//查询所有文章（括号内为映射路径）
    public String getAllMessage(Model model) throws JsonProcessingException {
        List<Message> allMessage = messageService.getAllMessage();
//        ObjectMapper mapper=new ObjectMapper();
//        String str = mapper.writeValueAsString(allMessage);
        model.addAttribute("allMessage", allMessage);
        SetLogUtil.setLog(MessageController.class).info("== getAllMessage视图模型添加，准备转发至前端 ==");
        return "allMessage";//去allMessage.jsp页面 "allMessage"
    }
@RequestMapping("/college/message/toAddMessage")//去添加文章
    public String toAddMessage(){

            return "addMessage";
    }
@RequestMapping("/college/message/addMessage")//添加文章
    public String addMessage(String messageTitle,String messageType){
    HashMap<Object, Object> map = new HashMap<>();
    map.put("messageTitle",messageTitle);
    map.put("messageType",messageType);

    messageService.insertMessage(map);
    return "redirect:/college/message/getAllMessage";//去复用getAllMessage(Model model)方法
    }
    @RequestMapping("/college/message/toUpdateMessage")//去更新文章
    public String toUpdateMessage(int id,Model model){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("messageId",id);
        List<Message> messageList=messageService.getMessage(map);
        model.addAttribute("Qmessage",messageList.get(0));
            return"updateMessage";
    }
@RequestMapping("/college/message/updateMessage")//更新文章
    public String updateMessage(Message message){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("messageTitle",message.getMessageTitle());
        map.put("messageType",message.getMessageType());
        map.put("messageId",message.getMessageId());
        messageService.updateMessage(map);
        return "redirect:/college/message/getAllMessage";
    }
}