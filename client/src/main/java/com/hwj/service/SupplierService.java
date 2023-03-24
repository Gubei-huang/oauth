package com.hwj.service;

import com.hwj.pojo.Supplier;

import java.util.List;

/**
 * @author Huang
 */
public interface SupplierService {
    List<Supplier> selectSuppliers();
    Supplier selectSupplierById(long id);
    boolean deleteSupplierById(long id);
    boolean insertSupplier(Supplier supplier);
    boolean updateSupplier(Supplier supplier);

}
