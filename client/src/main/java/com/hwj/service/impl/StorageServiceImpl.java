package com.hwj.service.impl;

import com.hwj.dao.StorageDao;
import com.hwj.pojo.*;
import com.hwj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Huang
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private InventoryService inventoryService;

    /**
     * 查找所有入库信息
     * @return
     */
    @Override
    public List<Storage> selectStorage() {
        return storageDao.selectStorage();
    }


    /**
     * 根据入库信息编号，查找入库信息
     * @param id
     * @return
     */
    @Override
    public Storage selectStorageById(long id) {
        return storageDao.selectStorageById(id);
    }

    /**
     * 添加入库信息
     * 同时更新库存信息
     */
    @Override
    public boolean insertStorage(Storage storage) {
        Supplier supplier = supplierService.selectSupplierById(storage.getSupplierId());
        if (supplier == null){
            return false;
        }
        Warehouse warehouse = warehouseService.selectWarehouseById(storage.getWarehouseId());
        if (warehouse == null){
            return false;
        }
        Goods goods = goodsService.selectGoodsById(storage.getGoodsId());
        if (goods == null){
            return false;
        }

        Inventory inventory = new Inventory();
        inventory.setGoodsId(storage.getGoodsId());
        inventory.setWarehouseId(storage.getWarehouseId());
        inventory.setQuantity(storage.getQuantity());
//        商品入库
        inventoryService.warehousingGoods(inventory);
//        添加订单
        Date date = new Date();
        storage.setTime(date);
        storageDao.insertStorage(storage);
        return true;
    }

    /**
     * 查找相关的入库信息
     * @param storage
     * @return List<Storage>
     */
    @Override
    public List<Storage> findStorage(Storage storage) {
        return storageDao.findStorage(storage);
    }

}
