package org.lanqiao.service;

import org.lanqiao.model.Book;
import org.lanqiao.model.orderForm;

import java.util.List;
import java.util.Map;

public interface orderFormService {

    //下单
    int orderAdd(orderForm book);
    //查询所有订单
    List<orderForm> queryall();
    //多条件查询订单信息
    List<orderForm> queryList(Map<String,Object> map);
    //删除订单
    int deleteOrder(String orderId);
    //归还图书
    int returnBook(String orderId);
}
