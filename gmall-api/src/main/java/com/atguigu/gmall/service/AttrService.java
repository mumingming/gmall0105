package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;

import java.util.List;


public interface AttrService {

    //三级分类查询
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    //平台属性添加
    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    //平台属性修改查询一个平台属性值的集合（点击修改查询数据展示）
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    //spu销售属性名称下拉框数据查询展示
    List<PmsBaseSaleAttr> baseSaleAttrList();
}
