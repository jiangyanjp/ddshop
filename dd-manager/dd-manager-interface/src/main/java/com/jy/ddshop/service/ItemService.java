package com.jy.ddshop.service;

import com.jy.ddshop.common.dto.Order;
import com.jy.ddshop.common.dto.Page;
import com.jy.ddshop.common.dto.Result;
import com.jy.ddshop.pojo.po.TbItem;
import com.jy.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 9:48
 * Version:V1.0
 */
public interface ItemService {
    TbItem getById(Long itemId);

    Result<TbItemCustom> listItemsByPage(Page page, Order order);

    int updateBatch(List<Long> ids);

    int updateDown(List<Long> ids);

    int updateUp(List<Long> ids);
}
