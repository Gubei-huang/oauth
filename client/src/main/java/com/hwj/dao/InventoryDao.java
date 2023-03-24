package com.hwj.dao;

import com.hwj.pojo.Goods;
import com.hwj.pojo.Inventory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huang
 */
@Repository
public interface InventoryDao {
    List<Inventory> selectInventory();
    Inventory selectInventoryByGidAndWid(Inventory inventory);
    Inventory selectInventoryByGid(long goodsId);
    Inventory selectInventoryByWid(long warehouseId);
    int selectCountByGoodsId(long goodsId);
    int selectCountByWarehouseId(long warehouseId);
    void insertGoodsInventory(Inventory inventory);
    void updateGoodsQuantity(Inventory inventory);
}
