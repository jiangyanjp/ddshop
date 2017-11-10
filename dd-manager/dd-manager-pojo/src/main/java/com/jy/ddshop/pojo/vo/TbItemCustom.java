package com.jy.ddshop.pojo.vo;

import com.jy.ddshop.pojo.po.TbItem;

/**
 * 自定义的商品显示类(VO)
 * User: DHC
 * Date: 2017/11/7
 * Time: 15:32
 * Version:V1.0
 */
public class TbItemCustom extends TbItem{

    private String catName;

    private String priceView;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }
}
