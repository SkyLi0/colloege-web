package com.college.controller;

import com.college.domain.Address;
import com.college.service.AddressService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class AddressController {
    static{
        SetLogUtil.setLog(AddressController.class).info("== 进入AddressController ==");
    }
    @Autowired
    private AddressService addressService;
    @RequestMapping("/college/address/addressbystatus")
    public String addressTest(Model model){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status","未审核");
        List<Address> address = addressService.getAddress(map);
        model.addAttribute("address",address);
        SetLogUtil.setLog(AddressController.class).info("==视图模型添加，AddressController准备转发至前端 ==");
        return "";
    }
}
