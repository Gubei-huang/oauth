package com.hwj.service;

import com.hwj.pojo.Warehouse;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> selectWarehouse();
    Warehouse selectWarehouseById(long id);
    boolean deleteWarehouseById(long id);
    boolean insertWarehouse(Warehouse warehouse);
    boolean updateWarehouse(Warehouse warehouse);
}
