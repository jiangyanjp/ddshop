package com.jy.ddshop.service.impl;

import com.jy.ddshop.dao.TbItemMapper;
import com.jy.ddshop.pojo.po.TbItem;
import com.jy.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 9:48
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }
}
