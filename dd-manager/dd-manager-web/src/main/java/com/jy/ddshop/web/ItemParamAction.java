package com.jy.ddshop.web;

import com.jy.ddshop.common.dto.Page;
import com.jy.ddshop.common.dto.Result;
import com.jy.ddshop.pojo.vo.TbItemParamCustom;
import com.jy.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class ItemParamAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemParamService itemParamService;


    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParams(Page page){
        Result<TbItemParamCustom> list = null;
        try {
            list = itemParamService.listItemParamsByPage(page);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }

}
