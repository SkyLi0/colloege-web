package com.college.controller;

import com.college.domain.Party_Affairs_Organization_Member;
import com.college.service.Party_Affairs_Organization_MemberService;
import com.college.utils.SetLogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/college/Party_Affairs_Organization_Member")
public class Party_Affairs_Organization_MemberController {
    static{
        SetLogUtil.setLog(Party_Affairs_Organization_MemberController.class).info("== 进入Party_Affairs_Organization_MemberController ==");
    }
    @Autowired
    private Party_Affairs_Organization_MemberService party_affairs_organization_memberService;
    /*
    * 给出了得到所有党支部成员的接口
    * */
    @RequestMapping("/getAll")
    public String getAll() throws JsonProcessingException {
        List<Party_Affairs_Organization_Member> all = party_affairs_organization_memberService.getAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(all);
        return s;
    }
}
