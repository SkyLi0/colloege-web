package com.college.controller;

import com.college.domain.Party_Affairs_Organization;
import com.college.service.Party_Affairs_OrganizationService;
import com.college.utils.SetLogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college/Party_Affairs_Organization")
public class Party_Affairs_OrganizationController {
    static{
        SetLogUtil.setLog(Party_Affairs_OrganizationController.class).info("== 进入Party_Affairs_OrganizationController ==");
    }
    @Autowired
    private Party_Affairs_OrganizationService P_A_OService;
    /*
    * 给出得到所有党支部的接口
    * */
    @RequestMapping("/getAllP_A_O")
    public String getAllP_A_O() throws JsonProcessingException {
        List<Party_Affairs_Organization> allP_a_o = P_A_OService.getAllP_A_O();
        ObjectMapper objectMapper = new ObjectMapper();
        String back = objectMapper.writeValueAsString(allP_a_o);
        return back;

    }
    /*
    * 给出通过模糊查询得到相应党支部的接口
    * */
    @RequestMapping("/getP_A_O")
    public String getP_A_O(String party_name,String party_honor) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        List<Party_Affairs_Organization> p_a_o = P_A_OService.getP_A_O(map);
        ObjectMapper objectMapper = new ObjectMapper();
        String back = objectMapper.writeValueAsString(p_a_o);
        return back;
    }
    /*
    * 给出通过ID精确查询的得到相应学工部的接口
    * */
    @RequestMapping("/getP_A_OById")
    public String getP_A_OById(int party_ID) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("party_ID",party_ID);
        List<Party_Affairs_Organization> p_a_o = P_A_OService.getP_A_O(map);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(party_ID);
        return s;
    }
    /*
    * 给出添加学工部的接口
    * */
    @RequestMapping("/insertP_A_O")
    public String insertP_A_O(String party_name,String party_honor){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        int i = P_A_OService.insertP_A_O(map);
        if (i<1){
            return "添加失败！";
        }
        return "添加成功！";
    }
    /*
    * 给出根据ID修改相应党支部资料的接口
    * */
    @RequestMapping("/updateP_A_OById")
    public String updateP_A_OById(String party_name,String party_honor,int party_ID){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("party_ID",party_ID);
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        int i = P_A_OService.updateP_A_O(map);
        if (i<1){
            return "修改失败！";
        }
        return "修改成功！";
    }
    /*
    * 给出通过ID精确删除相应党支部的接口
    * */
    @RequestMapping("/deleteP_A_OById")
    public String deleteByID(int party_ID){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("party_ID",party_ID);
        int i = P_A_OService.deleteP_A_O(map);
        if (i<1){
            return "删除失败！";
        }
        return "删除成功！";
    }
    /*
    * 给出通过模糊查询删除相应党支部的接口
    * */
    @RequestMapping("/deleteP_A_O")
    public String deleteP_A_O(String party_name,String party_honor){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        int i = P_A_OService.deleteP_A_O(map);
        if (i<0){
            return "删除失败！";
        }
        return "删除成功！";
    }
}
