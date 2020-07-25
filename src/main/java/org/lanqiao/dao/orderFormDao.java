package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.model.Book;
import org.lanqiao.model.orderForm;

import java.util.List;
import java.util.Map;

@Mapper
public interface orderFormDao {
    //下单
    int orderAdd(orderForm dd);
    //查询所有
    List<orderForm> queryall();
    //多条件查询订单信息
    List<orderForm> queryList(Map<String,Object> map);
    //删除订单
    int deleteOrder(@Param("orderId")String orderId);
    //归还图书
    int returnBook(@Param("orderId")String orderId);
}
