package com.example.ssm.service;

import com.example.ssm.dao.ItemMapper;
import com.example.ssm.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemMapper itemMapper;

    public Item findById(int id) {
        return itemMapper.findById(id);
    }
}
