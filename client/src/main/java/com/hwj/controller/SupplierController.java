package com.hwj.controller;

import com.hwj.pojo.Supplier;
import com.hwj.service.SupplierService;
import com.hwj.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Huang
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/selectSuppliers")
    public JsonUtils selectSuppliers(){
        List<Supplier> suppliers = supplierService.selectSuppliers();
        return JsonUtils.success().add("data",suppliers);
    }

    @PostMapping("/deleteSupplier")
    public JsonUtils deleteSupplier(@RequestBody Supplier supplier){
        boolean b = supplierService.deleteSupplierById(supplier.getId());
        if (b){
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }

    @PostMapping("/insertSupplier")
    public JsonUtils insertSupplier(@RequestBody Supplier supplier){
        boolean b = supplierService.insertSupplier(supplier);
        if (b){
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }

    @PostMapping("/updateSupplier")
    public JsonUtils updateSupplier(@RequestBody Supplier supplier){
        boolean b = supplierService.updateSupplier(supplier);
        if (b){
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }
}
