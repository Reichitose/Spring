package com.reiuy.service.impl;

import com.reiuy.dao.GoodsDao;
import com.reiuy.dao.SaleDao;
import com.reiuy.entity.Goods;
import com.reiuy.entity.Sale;
import com.reiuy.exception.NotEnoughException;
import com.reiuy.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;
    //操作需要两个dao支持,声明并创建他们的set方法


    //通过注解定义事务和其属性,这些都是默认值,
    //如果使用这个设置,可以直接@Transactional使用全部事务控制的默认值
    //rollbackFor表示发生指定的异常时一定要回滚,其处理逻辑是
    //      spring会首先检查方法抛出的异常是不是在rollbackfor的属性值中
    //      如果你的异常在列表中,那么不管是什么类型异常,都会回滚
    //      如果你抛出的异常不在rollbackfor的列表中,spring会判断
    //      异常是不是RuntimeException,如果是,一定回滚
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }

    )
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("==buy方法start==");
        //记录销售信息,向销售表sale添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);


        saleDao.insertSale(sale);

        //更新库存
        Goods goods = goodsDao.selectGood(goodsId);
        //在更新前先对库存进行查询
        if(goods == null){
            //说明商品不存在
            throw new NullPointerException(goodsId+"号商品不存在");
        }else if(goods.getAmount() < nums){
            //说明商品库存不足
            throw new NotEnoughException(goodsId+"号的商品库存不够");
        }

        //修改库存
        //新建一个buyGoods来提交这次购买的信息
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);

        goodsDao.updateGoods(buyGoods);
        System.out.println("==buy方法end==");



    }




    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

}
