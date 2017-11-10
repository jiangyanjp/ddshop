package com.jy.ddshop.web;

import com.jy.ddshop.common.dto.Order;
import com.jy.ddshop.common.dto.Page;
import com.jy.ddshop.common.dto.Result;
import com.jy.ddshop.pojo.po.TbItem;
import com.jy.ddshop.pojo.vo.TbItemCustom;
import com.jy.ddshop.pojo.vo.TbItemQuery;
import com.jy.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 9:42
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;


    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId) {
        System.out.println(itemId);
        TbItem tbItem = itemService.getById(itemId);
        return tbItem;
    }


    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query){
        Result<TbItemCustom> list = null;
        try {
            list = itemService.listItemsByPage(page,order,query);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }


    //商品列表删除功能  其实只是修改状态，不是真的删除
    @ResponseBody
    @RequestMapping("/items/batch")
    public int updateBatch(@RequestParam("ids[]") List<Long> ids){
        int i = 0;
        try {
            i = itemService.updateBatch(ids);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }


    //商品列表下架功能
    @ResponseBody
    @RequestMapping(value = "/items/down",method = RequestMethod.POST)
    public int updateDown(@RequestParam("ids[]") List<Long> ids){
        int i = 0;
        try {
            i = itemService.updateDown(ids);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    //商品列表上架功能
    @ResponseBody
    @RequestMapping(value = "/items/up",method = RequestMethod.POST)
    public int updateUp(@RequestParam("ids[]") List<Long> ids){
        int i = 0;
        try {
            i = itemService.updateUp(ids);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

}
