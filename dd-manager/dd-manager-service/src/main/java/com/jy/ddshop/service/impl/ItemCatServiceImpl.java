package com.jy.ddshop.service.impl;

import com.jy.ddshop.common.dto.TreeNode;
import com.jy.ddshop.dao.TbItemCatMapper;
import com.jy.ddshop.pojo.po.TbItemCat;
import com.jy.ddshop.pojo.po.TbItemCatExample;
import com.jy.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        //创建查询模板
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria cirteria = example.createCriteria();
        cirteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = itemCatDao.selectByExample(example);
        List<TreeNode> resultList = new ArrayList<TreeNode>();
        //遍历原有集合
        for(int i=0;i<list.size();i++){
            TreeNode node = new TreeNode();
            node.setId(list.get(i).getId());
            node.setText(list.get(i).getName());
            node.setState(list.get(i).getIsParent() ? "closed":"open");
            resultList.add(node);
        }
        return resultList;
    }
}
