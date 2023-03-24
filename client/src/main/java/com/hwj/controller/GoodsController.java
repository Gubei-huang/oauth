package com.hwj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwj.pojo.Goods;
import com.hwj.service.GoodsService;
import com.hwj.util.JsonUtils;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Huang
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/selectGoods")
    @ApiImplicitParam(name = "Authorization",paramType = "header",dataType = "String")
    public JsonUtils selectGoods(){
        List<Goods> goodsList = goodsService.selectGoods();
        return JsonUtils.success().add("data",goodsList);
    }

    @GetMapping("/selectGoodsById")
    public JsonUtils selectGoodsById(@RequestParam long id){
        Goods goods = goodsService.selectGoodsById(id);
        if (goods == null){
            return JsonUtils.fail();
        }
        return JsonUtils.success().add("data",goods);
    }

    @PostMapping("/insertGoods")
    public JsonUtils insertGoods(@RequestBody Goods goods){
        boolean b = goodsService.insertGoods(goods);
        if (b){
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }

    @PostMapping("/deleteGoodsById")
    public JsonUtils deleteGoodsById(@RequestBody Goods goods){
        boolean b = goodsService.deleteGoodsById(goods.getId());
        if (b){
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }

    @PostMapping("/updateGoodsById")
    public JsonUtils updateGoodsById(@RequestBody Goods goods){
        boolean b = goodsService.updateGoodsById(goods);
        if (b){
            return JsonUtils.success();
        }
        return JsonUtils.fail();
    }

    /**
     * 分页查询
     * 初次尝试 Mybatis plus
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/pageGoods")
    public JsonUtils pageGoods(@RequestParam("current")int current,
                               @RequestParam("size")int size){
        Page<Goods> goodsPage = goodsService.pageGoods(current, size);
        return JsonUtils.success().add("data",goodsPage);
    }
}
