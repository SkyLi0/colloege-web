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
    /*
    * 通过给出条件模糊查询接口,以下4个参数可单选或者多选
    * */
    @RequestMapping("/getMessage")
    public String getMessage(String messageType,String formatDate,String author,String messageTitle ) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        if(messageType.isEmpty()==false){  map.put("messageType",messageType);}//选填
        if(formatDate.isEmpty()==false){ map.put("formatDate",formatDate);}//选填
        if(author.isEmpty()==false){ map.put("author",author);}//选填
        if(messageTitle.isEmpty()==false){ map.put("messageTitle",messageTitle);}//选填
        List<Message> message=messageService.getMessage(map);
        ObjectMapper mapper=new ObjectMapper();
        String qmessage = mapper.writeValueAsString(message);
        return qmessage;
    }
/*
* //查询所有接口
* */
    @RequestMapping("/getAllMessage")
    public String getAllMessage() throws JsonProcessingException {
        List<Message> allMessage = messageService.getAllMessage();
        ObjectMapper mapper=new ObjectMapper();
        String all = mapper.writeValueAsString(allMessage);
        return all;
    }

    /*
    * 通过ID精确查询接口
    * */
    @RequestMapping("/getMessageById")
    public String getMessage(int messageId) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        List<Message> message = messageService.getMessage(map);
        ObjectMapper objectMapper = new ObjectMapper();
        String back = objectMapper.writeValueAsString(message);
        return back;
    }
    /*
    * //添加接口
    * */
@RequestMapping("/addMessage")
    public String addMessage(Message message){
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    HashMap<Object, Object> map = new HashMap<>();
    if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}//选填
    if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}//选填
    if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}//选填
    if (message.getMessageAddress().isEmpty()==false){ map.put("messageAddress",message.getMessageAddress());}//选填
    if (message.getMessageContent().isEmpty()==false){ map.put("messageContent",message.getMessageContent());}//选填
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
/*
* //根据ID更新接口
* */
@RequestMapping("/updateMessageById")
    public String updateMessage(Message message){
        HashMap<Object, Object> map = new HashMap<>();
    map.put("messageId",message.getMessageId());
    if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}//选填
    if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}//选填
    if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}//选填
    if (message.getMessageAddress().isEmpty()==false){ map.put("messageAddress",message.getMessageAddress());}//选填
    if (message.getMessageContent().isEmpty()==false){ map.put("messageContent",message.getMessageContent());}//选填
    int i = messageService.updateMessage(map);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    List<Message> message1 = messageService.getMessage(map);
    map.put("formatDate",sdf.format( message1.get(0).getCreateDate()));
    int j = messageService.updateMessage(map);
    if(j<1){
        return "更新失败！";
    }
    return "更新成功！";
    }
/*
* //根据ID精确删除接口
* */
    @RequestMapping("/deleteMessageById")
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