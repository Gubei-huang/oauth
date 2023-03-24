package com.hwj.dao;

import com.hwj.pojo.Goods;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huang
 */
@Repository
public interface GoodsDao {
    List<Goods> selectGoods();
    void insertGoods(Goods goods);
    void insertGoodsList(List<Goods> goodsList);
    Goods selectGoodsById(long id);
    void deleteGoodsById(long id);
    void updateGoodsById(Goods goods);

    List<Goods> selectGoodsByLimit(@Param("pageBegin")int pageBegin,
                                   @Param("pageSize")int pageSize);
    /**
     * 模糊查询
     */
    List<Goods> findGoods(Goods goods);

}
