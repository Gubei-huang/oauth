package com.hwj.dao;

import com.hwj.pojo.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseDao {
    List<Warehouse> selectWarehouse();
    Warehouse selectWarehouseById(long id);
    void deleteWarehouseById(long id);
    void insertWarehouse(Warehouse warehouse);
    void updateWarehouse(Warehouse warehouse);
}
