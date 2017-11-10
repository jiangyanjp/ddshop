package com.jy.ddshop.web;

import com.jy.ddshop.common.dto.TreeNode;
import com.jy.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("prototype")
public class ItemCatAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemCatService itemCatService;


    @RequestMapping("/itemCats")
    @ResponseBody
    public List<TreeNode> listItemCats(@RequestParam("parentId") Long parentId){
        return itemCatService.listItemCats(parentId);
    }
}
