package com.hwj.service.impl;

import com.hwj.dao.SupplierDao;
import com.hwj.pojo.Supplier;
import com.hwj.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huang
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    @Override
    public List<Supplier> selectSuppliers() {
        return supplierDao.selectSuppliers();
    }

    @Override
    public Supplier selectSupplierById(long id) {
        return supplierDao.selectSupplierById(id);
    }

    @Override
    public boolean deleteSupplierById(long id) {
        Supplier supplier = supplierDao.selectSupplierById(id);
        if(supplier==null){
            return false;
        }
        supplierDao.deleteSupplierById(id);
        return true;
    }

    @Override
    public boolean insertSupplier(Supplier supplier) {
        Supplier s = supplierDao.selectSupplierById(supplier.getId());
        if(s==null){
            return false;
        }
        supplierDao.insertSupplier(supplier);
        return true;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        Supplier s = supplierDao.selectSupplierById(supplier.getId());
        if(s==null){
            return false;
        }
        supplierDao.updateSupplier(supplier);
        return true;
    }
}
