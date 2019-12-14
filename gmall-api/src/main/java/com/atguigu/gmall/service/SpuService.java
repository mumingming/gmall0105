package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsProductImage;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    //spu数据加载，根据三级分类查询该类下的所有数据
    List<PmsProductInfo> spuList(String catalog3Id);

    //保存功能
    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    //sku销售属性列表
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    // spu的图片列表
    List<PmsProductImage> spuImageList(String spuId);

    ////销售属性列表
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String id);
}
