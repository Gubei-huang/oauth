package com.hwj.service.impl;

import com.hwj.dao.GoodsDao;
import com.hwj.dao.InventoryDao;
import com.hwj.dao.WarehouseDao;
import com.hwj.pojo.Goods;
import com.hwj.pojo.Inventory;
import com.hwj.pojo.Warehouse;
import com.hwj.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryDao inventoryDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private WarehouseDao warehouseDao;

    @Override
    public List<Inventory> selectInventory() {
        return inventoryDao.selectInventory();
    }

    @Override
    public int selectCountByGoodsId(long goodsId) {
        Goods goods = goodsDao.selectGoodsById(goodsId);
        if (goods==null){
            return -1;
        }
        Inventory i = inventoryDao.selectInventoryByGid(goodsId);
        if (i == null){
            return 0;
        }
        int count = inventoryDao.selectCountByGoodsId(goodsId);
        return count;
    }

    @Override
    public int selectCountByWarehouseId(long warehouseId) {
        Warehouse warehouse = warehouseDao.selectWarehouseById(warehouseId);
        if(warehouse == null){
            return -1;
        }
        Inventory i = inventoryDao.selectInventoryByWid(warehouseId);
        if (i == null){
            return 0;
        }
        int count = inventoryDao.selectCountByWarehouseId(warehouseId);
        return count;
    }

    @Override
    public boolean warehousingGoods(Inventory inventory) {
//        获取物品库存信息
        Inventory i = inventoryDao.selectInventoryByGidAndWid(inventory);
//        没有存在物品库存信息，添加新的物品库存信息
        if(i==null){
            inventoryDao.insertGoodsInventory(inventory);
            return false;
        }
//        修改库存数量，之前库存数+入库数
        inventory.setQuantity(inventory.getQuantity()+i.getQuantity());
        inventoryDao.updateGoodsQuantity(inventory);
        return true;
    }
}
