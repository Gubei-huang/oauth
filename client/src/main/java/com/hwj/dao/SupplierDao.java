package com.hwj.dao;

import com.hwj.pojo.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huang
 */
@Repository
public interface SupplierDao {
    /**
     * @return List<Supplier>
     *     查询所有供应商
     */
    List<Supplier> selectSuppliers();
    Supplier selectSupplierById(long id);
    void deleteSupplierById(long id);
    void insertSupplier(Supplier supplier);
    void insertSupplierList(List<Supplier> supplierList);
    void updateSupplier(Supplier supplier);
}
