package com.hwj.controller;

import com.hwj.pojo.Warehouse;
import com.hwj.service.WarehouseService;
import com.hwj.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/selectWarehouse")
    public JsonUtils selectWarehouse(){
        List<Warehouse> warehouseList = warehouseService.selectWarehouse();
        return JsonUtils.success().add("data",warehouseList);
    }
}
