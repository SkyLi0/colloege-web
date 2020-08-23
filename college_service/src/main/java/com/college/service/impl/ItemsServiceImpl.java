package com.college.service.impl;


import com.college.dao.ItemsDao;
import com.college.domain.Items;
import com.college.service.ItemsService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    public Items findById(Integer id) {
        SetLogUtil.setLog(ItemsServiceImpl.class).info("==准备执行findById方法===");
        return itemsDao.findById(id);
    }
}
