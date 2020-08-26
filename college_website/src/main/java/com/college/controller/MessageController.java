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

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/college/message")
public class MessageController{
    static{
        SetLogUtil.setLog(MessageController.class).info("== 进入MessageController ==");
    }
    @Autowired
    private MessageService messageService;
    @RequestMapping("/getMessage")//按条件查询接口
    public String getMessage(int id) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("author","信息学院");
        map.put("messageId",id);
        List<Message> message=messageService.getMessage(map);
        ObjectMapper mapper=new ObjectMapper();
        String qmessage = mapper.writeValueAsString(message);
        return qmessage;
    }




    @RequestMapping("/getAllMessage")//查询所有接口
    public String getAllMessage() throws JsonProcessingException {
        List<Message> allMessage = messageService.getAllMessage();
        ObjectMapper mapper=new ObjectMapper();
        String all = mapper.writeValueAsString(allMessage);
        return all;
    }

@RequestMapping("/addMessage")//添加接口
    public String addMessage(Message message){
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    HashMap<Object, Object> map = new HashMap<>();
    map.put("messageTitle",message.getMessageTitle());
    map.put("messageType",message.getMessageType());
    map.put("author",message.getAuthor());
    map.put("messageAddress",message.getMessageAddress());
    map.put("messageContent",message.getMessageContent());
    int i = messageService.insertMessage(map);
    List<Message> message1 = messageService.getMessage(map);
    map.put("formatDate",sdf.format( message1.get(0).getCreateDate()));
    map.put("messageId",message1.get(0).getMessageId());
    int j = messageService.updateMessage(map);
    if(j<1){
        return "添加失败！";
    }
    return "添加成功！";
    }

@RequestMapping("/updateMessage")//更新接口
    public String updateMessage(Message message){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("messageTitle",message.getMessageTitle());
        map.put("messageType",message.getMessageType());
        map.put("status",message.getStatus());
        map.put("messageId",message.getMessageId());
        map.put("messageContent",message.getMessageContent());
        map.put("messageAddress",message.getMessageAddress());
        map.put("author",message.getAuthor());
    int i = messageService.updateMessage(map);
    if(i<1){
        return "更新失败！";
    }
    return "更新成功！";
    }

    @RequestMapping("/deleteMessage")//删除接口
    public String deleteMessage(int id){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("messageId",id);
        int i = messageService.deleteMessage(map);
        if (i>0){
            return "删除成功！";
        }
        else {
            return "删除失败！";
        }
    }
}