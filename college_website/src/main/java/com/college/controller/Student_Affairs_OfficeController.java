package com.college.controller;

import com.college.domain.Student_Affairs_Office;
import com.college.service.Student_Affairs_OfficeService;
import com.college.utils.SetLogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/college/Student_Affairs_Office")
public class Student_Affairs_OfficeController {
    static {
        SetLogUtil.setLog(Student_Affairs_OfficeController.class).info("== 进入Student_Affairs_OfficeController ==");
    }

    @Autowired
    private Student_Affairs_OfficeService student_affairs_officeService;

    /*
     * 给出得到所有学工部成员的接口
     * */
    @RequestMapping("/getAll")
    public String getAll() throws JsonProcessingException {
        List<Student_Affairs_Office> allS_a_o = student_affairs_officeService.getAllS_A_O();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(allS_a_o);
        return s;
    }

    /*
     * 给出了根据条件模糊查询得到相应学工部成员的接口
     * */
    @RequestMapping("/get")
    public String get(Student_Affairs_Office student_affairs_office) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getMotto().isEmpty() == false) {
            map.put("motto", student_affairs_office.getMotto());
        }
        if (student_affairs_office.getEmail().isEmpty() == false) {
            map.put("email", student_affairs_office.getEmail());
        }
        if (student_affairs_office.getLocation().isEmpty() == false) {
            map.put("location", student_affairs_office.getLocation());
        }
        if (student_affairs_office.getPhone().isEmpty() == false) {
            map.put("phone", student_affairs_office.getPhone());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        List<Student_Affairs_Office> s_a_o = student_affairs_officeService.getS_A_O(map);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(s_a_o);
        return s;
    }
    /*
    * 给出了根据ID精确查询得到学工部成员的接口
    * */
    @RequestMapping("/getById")
    public String getById(int ID) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("ID",ID);
        List<Student_Affairs_Office> s_a_o = student_affairs_officeService.getS_A_O(map);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(s_a_o);
        return s;
    }
    /*
    * 给出了添加学工部成员的接口
    * */
    @RequestMapping("/insert")
    public String insert(Student_Affairs_Office student_affairs_office){
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getMotto().isEmpty() == false) {
            map.put("motto", student_affairs_office.getMotto());
        }
        if (student_affairs_office.getEmail().isEmpty() == false) {
            map.put("email", student_affairs_office.getEmail());
        }
        if (student_affairs_office.getLocation().isEmpty() == false) {
            map.put("location", student_affairs_office.getLocation());
        }
        if (student_affairs_office.getPhone().isEmpty() == false) {
            map.put("phone", student_affairs_office.getPhone());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        int i = student_affairs_officeService.insertS_A_O(map);
        if (i<1){
            return "添加失败！";
        }
        return "添加成功！";
    }
    /*
    * 给出了根据id修改相应学工部成员的接口
    * */
    @RequestMapping("/updateById")
    public String updateById(Student_Affairs_Office student_affairs_office){
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getMotto().isEmpty() == false) {
            map.put("motto", student_affairs_office.getMotto());
        }
        if (student_affairs_office.getEmail().isEmpty() == false) {
            map.put("email", student_affairs_office.getEmail());
        }
        if (student_affairs_office.getLocation().isEmpty() == false) {
            map.put("location", student_affairs_office.getLocation());
        }
        if (student_affairs_office.getPhone().isEmpty() == false) {
            map.put("phone", student_affairs_office.getPhone());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        map.put("ID",student_affairs_office.getID());
        int i = student_affairs_officeService.updateS_A_O(map);
        if (i<1){
            return "修改失败！";
        }
        return "修改成功！";
    }
    /*
    * 给出了根据条件模糊查询得到相应的学工部员工后删除的接口
    * */
    @RequestMapping("/delete")
    public String delete(Student_Affairs_Office student_affairs_office){
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        int i = student_affairs_officeService.deleteS_A_O(map);
        if (i<1){
            return "删除失败！";
        }
        return "删除成功！";
    }
    /*
    * 给出了根据ID精确删除相应学工部员工的接口
    * */
    @RequestMapping("/deleteById")
    public String deleteById(int ID){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("ID",ID);
        int i = student_affairs_officeService.deleteS_A_O(map);
        if (i<1){
            return "删除失败！";
        }
        return "删除成功！";
    }

}
