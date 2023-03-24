package com.hwj.service;

import com.hwj.pojo.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> selectInventory();

    /**
     * @param goodsId
     * @return 商品总库存量
     * 查询商品总库存量
     */
    int selectCountByGoodsId(long goodsId);

    /**
     * @param warehouseId
     * @return 一个仓库总库存量
     * 查询一个仓库总库存量
     */
    int selectCountByWarehouseId(long warehouseId);

    /**
     * @param inventory
     * @return
     * 实现物品入库
     */
    boolean warehousingGoods(Inventory inventory);
}
