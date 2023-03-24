package com.hwj;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwj.mybatisplustest.GoodsMapper;
import com.hwj.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ClientApplicationTests {
    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    void contextLoads() {
        Goods g = new Goods();
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();

        wrapper.like(g.getName()!=null,"name",g.getName());
        List<Goods> goodsList = goodsMapper.selectList(wrapper);
        goodsList.forEach(goods -> {
            System.out.println(goods);
        });
    }
}
