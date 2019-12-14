package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsSkuInfo;

import java.util.List;

public interface SkuService {
    //后台管理sku保存
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    //通过skuId查看数据
    PmsSkuInfo getSkuById(String skuId);

    // 查询当前sku的spu的其他sku的集合的hash表
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);

    //search测试类代码  查询sku全部数据添加为es数据结构
    List<PmsSkuInfo> getAllSku(String s);
}
