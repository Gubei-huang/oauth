package com.hwj.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwj.dao.GoodsDao;
import com.hwj.mybatisplustest.GoodsMapper;
import com.hwj.pojo.Goods;
import com.hwj.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author Huang
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectGoods() {
        return goodsDao.selectGoods();
    }

    @Override
    public boolean insertGoods(Goods goods) {
        Goods g = goodsDao.selectGoodsById(goods.getId());
        if (g!=null){
            return false;
        }
        goodsDao.insertGoods(goods);
        return true;
    }

    @Override
    public Goods selectGoodsById(long id) {
        return goodsDao.selectGoodsById(id);
    }

    @Override
    public boolean deleteGoodsById(long id) {
        Goods goods = goodsDao.selectGoodsById(id);
        if (goods==null){
            return false;
        }
        goodsDao.deleteGoodsById(id);
        return true;
    }

    @Override
    public boolean updateGoodsById(Goods goods) {
        Goods g = goodsDao.selectGoodsById(goods.getId());
        if (g==null){
            return false;
        }
        goodsDao.updateGoodsById(goods);
        return true;
    }


    /**
     * 尝试 mybatis plus
     * 分页
     * @param current
     * @param size
     * @return
     */
    @Override
    public Page<Goods> pageGoods(int current, int size) {
        Page<Goods> goodsPage = goodsMapper.selectPage(new Page<>(current, size),null);
        return goodsPage;
    }
}
