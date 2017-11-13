package com.jy.ddshop.service;

import com.jy.ddshop.common.dto.Order;
import com.jy.ddshop.common.dto.Page;
import com.jy.ddshop.common.dto.Result;
import com.jy.ddshop.pojo.po.TbItem;
import com.jy.ddshop.pojo.vo.TbItemCustom;
import com.jy.ddshop.pojo.vo.TbItemQuery;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 9:48
 * Version:V1.0
 */
public interface ItemService {
    TbItem getById(Long itemId);

    Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query);

    /**
     * 删除商品，实则是改变商品状态，不是真的删除
     * @param ids 要删除的商品id数组
     * @return
     */
    int updateBatch(List<Long> ids);

    /**
     * 下架
     * @param ids 要下架的商品id数组
     * @return
     */

    int updateDown(List<Long> ids);

    /**
     * 上架
     * @param ids 要上架的商品id数组
     * @return
     */
    int updateUp(List<Long> ids);

    /**
     * 新增商品
     * @param tbItem 商品信息
     * @param desc 商品描述
     * @return
     */
    int saveItem(TbItem tbItem, String desc);
}
