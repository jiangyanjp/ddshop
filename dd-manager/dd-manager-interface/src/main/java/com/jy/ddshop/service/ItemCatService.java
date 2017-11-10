package com.jy.ddshop.service;

import com.jy.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {

    List<TreeNode> listItemCats(Long parentId);
}
