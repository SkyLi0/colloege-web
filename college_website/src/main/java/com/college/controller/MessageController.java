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
    *采用动态sql
    * 给出通过给出条件模糊查询得到文档的接口,以下4个参数作为条件可单选或者多选
    * 比如：只通过messageType查询、通过author和messageType查询等等
    * */
    @RequestMapping("/getMessage")
    public String getMessage(String messageType,String formatDate,String author,String messageTitle ) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        if(messageType.isEmpty()==false){  map.put("messageType",messageType);}
        if(formatDate.isEmpty()==false){ map.put("formatDate",formatDate);}
        if(author.isEmpty()==false){ map.put("author",author);}
        if(messageTitle.isEmpty()==false){ map.put("messageTitle",messageTitle);}
        List<Message> message=messageService.getMessage(map);
        ObjectMapper mapper=new ObjectMapper();
        String qmessage = mapper.writeValueAsString(message);
        return qmessage;
    }
/*
* 给出得到所有文档的接口
* */
    @RequestMapping("/getAllMessage")
    public String getAllMessage() throws JsonProcessingException {
        List<Message> allMessage = messageService.getAllMessage();
        ObjectMapper mapper=new ObjectMapper();
        String all = mapper.writeValueAsString(allMessage);
        return all;
    }

    /*
    * 给出通过ID精确得到文档的接口
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
    * 给出添加文档的接口，用法同以上getMessage（）方法
    * */
@RequestMapping("/insertMessage")
    public String addMessage(Message message){
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    HashMap<Object, Object> map = new HashMap<>();
    if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}
    if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}
    if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}
    if (message.getMessageAddress().isEmpty()==false){ map.put("messageAddress",message.getMessageAddress());}
    if (message.getMessageContent().isEmpty()==false){ map.put("messageContent",message.getMessageContent());}
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
* 给出根据ID更新相应文档的接口，更新的内容采用动态sql,用法同以上getMessage（）方法
* */
@RequestMapping("/updateMessageById")
    public String updateMessage(Message message){
        HashMap<Object, Object> map = new HashMap<>();
    map.put("messageId",message.getMessageId());
    if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}
    if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}
    if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}
    if (message.getMessageAddress().isEmpty()==false){ map.put("messageAddress",message.getMessageAddress());}
    if (message.getMessageContent().isEmpty()==false){ map.put("messageContent",message.getMessageContent());}
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
* 给出根据ID精确删除文档的接口
* */
    @RequestMapping("/deleteMessageById")
    public String deleteMessage(int messageId){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        int i = messageService.deleteMessage(map);
        if (i>0){
            return "删除成功！";
        }
        else {
            return "删除失败！";
        }
    }
/*
*采用动态sql
* 给出模糊删除的接口，通过作者、文章标题、文章类型、格式化时间进行删除
* 比如：只通过作者删除、通过作者和格式化时间为条件删除、以全部为条件删除等等
* */
@RequestMapping("/deleteMessage")
public String deleteMessage(Message message){
    HashMap<Object, Object> map = new HashMap<>();
    if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}
    if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}
    if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}
    if(message.getFormatDate().isEmpty()==false){ map.put("formatDate",message.getFormatDate());}
    int i = messageService.deleteMessage(map);
    if (i<1){
        return "删除失败！";
    }
    return "删除成功！";
}
}