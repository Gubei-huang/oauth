package com.hwj.service.impl;

import com.hwj.dao.WarehouseDao;
import com.hwj.pojo.Warehouse;
import com.hwj.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseDao warehouseDao;

    @Override
    public List<Warehouse> selectWarehouse() {
        return warehouseDao.selectWarehouse();
    }

    @Override
    public Warehouse selectWarehouseById(long id) {
        return warehouseDao.selectWarehouseById(id);
    }

    @Override
    public boolean deleteWarehouseById(long id) {
        Warehouse warehouse = warehouseDao.selectWarehouseById(id);
        if (warehouse==null){
            return false;
        }
        warehouseDao.deleteWarehouseById(id);
        return true;
    }

    @Override
    public boolean insertWarehouse(Warehouse warehouse) {
        Warehouse w = warehouseDao.selectWarehouseById(warehouse.getId());
        if (w==null){
            return false;
        }
        warehouseDao.insertWarehouse(warehouse);
        return true;
    }

    @Override
    public boolean updateWarehouse(Warehouse warehouse) {
        Warehouse w = warehouseDao.selectWarehouseById(warehouse.getId());
        if (w==null){
            return false;
        }
        warehouseDao.updateWarehouse(warehouse);
        return true;
    }
}
