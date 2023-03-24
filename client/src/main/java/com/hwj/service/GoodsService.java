package com.hwj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwj.pojo.Goods;

import java.util.List;

/**
 * @author Huang
 */
public interface GoodsService {
    List<Goods> selectGoods();
    boolean insertGoods(Goods goods);
    Goods selectGoodsById(long id);
    boolean deleteGoodsById(long id);
    boolean updateGoodsById(Goods goods);
    Page<Goods> pageGoods(int current, int size);
}
