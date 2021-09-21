package com.reiuy.dao;

import com.reiuy.entity.Goods;

public interface GoodsDao {
    //更新库存
    //goods是表示本次用户购买的商品信息,包括id,商品名,数量
    int updateGoods(Goods goods);

    //查询商品信息
    Goods selectGood(Integer id);
}
