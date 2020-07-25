package org.lanqiao.service.Impl;


import org.lanqiao.dao.orderFormDao;
import org.lanqiao.model.orderForm;
import org.lanqiao.service.orderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Primary
public class orderFormServiceImpl implements orderFormService {
    @Autowired
    orderFormDao dao;

//下单
    @Override
    public int orderAdd(orderForm dd) {
        int row=dao.orderAdd(dd);
        return row;
    }
//查询所有订单
    @Override
    public List<orderForm> queryall() {
        List<orderForm> order=dao.queryall();
        return order;
    }
    //多条件查询订单信息
    @Override
    public List<orderForm> queryList(Map<String, Object> map) {
        List<orderForm> order=dao.queryList(map);
        return order;
    }
//删除订单
    @Override
    public int deleteOrder(String orderId) {
       int row=dao.deleteOrder(orderId);
       return row;
    }
//归还图书
    @Override
    public int returnBook(String orderId) {
        int row=dao.returnBook(orderId);
        return row;
    }
}
