package com.jy.ddshop.dao;

import com.jy.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {
    int countItemParams(Map<String, Object> map);

    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);
}
