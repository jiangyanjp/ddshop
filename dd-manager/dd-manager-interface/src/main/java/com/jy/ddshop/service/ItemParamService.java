package com.jy.ddshop.service;

import com.jy.ddshop.common.dto.Page;
import com.jy.ddshop.common.dto.Result;
import com.jy.ddshop.pojo.vo.TbItemParamCustom;
import org.springframework.stereotype.Service;

public interface ItemParamService {
    Result<TbItemParamCustom> listItemParamsByPage(Page page);
}
