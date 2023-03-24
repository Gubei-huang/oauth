package com.hwj.controller;

import com.hwj.pojo.Inventory;
import com.hwj.service.InventoryService;
import com.hwj.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Huang
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/selectInventory")
    public JsonUtils selectInventory(){
        List<Inventory> inventories = inventoryService.selectInventory();
        return JsonUtils.success().add("data",inventories);
    }

    @GetMapping("/selectCountByGoodsId")
    public JsonUtils selectCountByGoodsId(@RequestParam("goodsId") long goodsId){
        int i = inventoryService.selectCountByGoodsId(goodsId);
        if (i == -1){
            return JsonUtils.fail().msg("没有此物品");
        }
        if (i == 0){
            return JsonUtils.fail().msg("仓库无库存");
        }
        return JsonUtils.success().add("data",i);
    }

    @GetMapping("/selectCountByWarehouseId")
    public JsonUtils selectCountByWarehouseId(@RequestParam("warehouseId") long warehouseId){
        int i = inventoryService.selectCountByWarehouseId(warehouseId);
        if (i == -1){
            return JsonUtils.fail().msg("没有此仓库");
        }
        if (i == 0){
            return JsonUtils.fail().msg("仓库无库存");
        }
        return JsonUtils.success().add("data",i);
    }

    /**
     * 商品入库接口
     * 存在商品则修改数量，在原有数量上加上入库数
     * 不存在则添加库存
     */
    @PostMapping("/warehousingGoods")
    public JsonUtils warehousingGoods(@RequestBody Inventory inventory){
        boolean b = inventoryService.warehousingGoods(inventory);
        if(!b){
            return JsonUtils.success().msg("添加到库存");
        }
        return JsonUtils.success().msg("更新数量");
    }
}
