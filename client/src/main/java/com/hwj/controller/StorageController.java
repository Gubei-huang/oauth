package com.hwj.controller;

import com.hwj.pojo.Storage;
import com.hwj.service.StorageService;
import com.hwj.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Huang
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;

    /**
     * 查找所有入库信息
     * @return List<Storage>
     */
    @GetMapping("/selectStorage")
    public JsonUtils selectStorage(){
        List<Storage> storages = storageService.selectStorage();
        return JsonUtils.success().add("data",storages);
    }

    /**
     * 根据入库信息编号，查找入库信息
     * @return Storage
     */
    @GetMapping("/selectStorageById")
    public JsonUtils selectStorageById(@RequestParam("id") long id){
        Storage storage = storageService.selectStorageById(id);
        return JsonUtils.success().add("data",storage);
    }

    /**
     * 添加入库订单
     * 同时更新库存信息
     */
    @PostMapping("/insertStorage")
    public JsonUtils insertStorage(@RequestBody Storage storage){
        boolean b = storageService.insertStorage(storage);
        if (!b){
            return JsonUtils.fail();
        }
        return JsonUtils.success();
    }

    /**
     * 查找相关的入库信息
     * @param storage
     * @return List<Storage>
     */
    @GetMapping("/findStorage")
    public JsonUtils findStorage(@RequestBody Storage storage){
        List<Storage> storages = storageService.findStorage(storage);
        return JsonUtils.success().add("data",storages);
    }
}
