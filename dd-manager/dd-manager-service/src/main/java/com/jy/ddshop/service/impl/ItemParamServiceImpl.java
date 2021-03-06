package com.jy.ddshop.service.impl;

import com.jy.ddshop.common.dto.Page;
import com.jy.ddshop.common.dto.Result;
import com.jy.ddshop.dao.TbItemParamCustomMapper;
import com.jy.ddshop.pojo.vo.TbItemParamCustom;
import com.jy.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ItemParamServiceImpl implements ItemParamService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;

    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {
        Result<TbItemParamCustom> result = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page",page);

            //1 创建一个响应参数实体类
            result = new Result<TbItemParamCustom>();
            //2 对total进行设值(符合条件的总记录数)
            int total = itemParamCustomDao.countItemParams(map);
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<TbItemParamCustom> list = itemParamCustomDao.listItemParamsByPage(map);
            result.setRows(list);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }
}
