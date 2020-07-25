package org.lanqiao.controll;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.model.Book;
import org.lanqiao.model.orderForm;
import org.lanqiao.service.BookService;
import org.lanqiao.service.orderFormService;
import org.lanqiao.vo.Result;
import org.lanqiao.vo.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/api/order")
public class orderFormApi {
    @Autowired
    orderFormService impl;
    @Autowired
    BookService impls;
    private static final Logger logger = LoggerFactory.getLogger(orderFormApi.class);

    //下单
    @RequestMapping("/orderAdd")
    public Result orderAdd(String orderId,String userId,String bookId,String bookNames,String rentTime,Integer rentNum,Integer buyNum,String totalPrice,Integer orderStatus,String orderTime,String returnTime,String bookImg,String bookNum) {
        Result mess = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        try{
            orderForm order=new orderForm();
            order.setOrderId(UUIDUtil.get16UUID());
            order.setUserId(userId);
            order.setBookId(bookId);
            order.setBookNames(bookNames);
            order.setRentTime(rentTime);
            order.setRentNum(rentNum);
            order.setBuyNum(buyNum);
            order.setTotalPrice(totalPrice);
            order.setOrderStatus(1);
            if(buyNum != null && buyNum != 0){
                order.setFlag("");
            }else{
                order.setFlag("未还");
            }
            order.setOrderTime(df.format(new Date()));
            order.setReturnTime(returnTime);
            order.setBookImg(bookImg);
            //根据id查询图书信息，下单后修改图书数量
            List<Book> books = impls.queryBookById(bookId);
            for(Book b:books){
                if(rentNum != null && rentNum != 0){
                    Integer num=Integer.parseInt(b.getBookNum())-rentNum;
                    bookNum=num.toString();
                }else{
                    Integer num=Integer.parseInt(b.getBookNum())-buyNum;
                    bookNum=num.toString();
                }
            }
            Book book=new Book();
            book.setBookId(bookId);
            book.setBookNum(bookNum);
            impls.updateBook(book);
            int row = impl.orderAdd(order);
            if(row > 0){
                mess = new Result("200","下单成功",row);
            }else{
                mess = new Result("500","失败，请注意信息填写",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            mess = new Result("500","异常",e.getMessage());
        }
        return mess;
    }

    //查询所有订单
    @RequestMapping("/query")
    public Result queryall(){
        Result mess = null;
        try{
            PageHelper.startPage(1,1000);
            List<orderForm> order = impl.queryall();
            Map<String, Object> map = new HashMap<>();
            PageInfo pageInfo=new PageInfo(order);
            if(order != null){
                mess = new Result("200","查询成功",pageInfo);
            }else{
                mess = new Result("500","查询失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            mess = new Result("500","查询异常",e.getMessage());
        }
        return mess;
    }
    //多条件查询订单信息                                                                 //OK
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Result queryList(String userId,String orderId,String flag) throws IOException {
        Result mess = null;
        try{
            PageHelper.startPage(1,1000);
            Map<String,Object> map=new HashMap<>();
            if(userId !=null && userId !=""){
                map.put("userId",userId);
            }
            if(orderId !=null && orderId !=""){
                map.put("orderId",orderId);
            }
            if(flag != null && flag != ""){
                map.put("flag",flag);
            }
            List<orderForm> order = impl.queryList(map);
            PageInfo pageInfo=new PageInfo(order);
            if(order != null){
                mess = new Result("200","查询成功",pageInfo);
            }else{
                mess = new Result("404","用户id错误",null);
            }
        }catch (Exception e){
            mess = new Result("500","查询异常",e.getMessage());
        }
        return mess;
    }
    //删除订单
    @RequestMapping("/deleteOrder")
    public Result deleteOrder(String orderId){
        Result mess = null;
        try{
            int row = impl.deleteOrder(orderId);
            if(row > 0){
                mess = new Result("200","删除成功",row);
            }else{
                mess = new Result("500","删除失败",row);
            }
        }catch (Exception e){
            e.printStackTrace();
            mess = new Result("500","删除异常",e.getMessage());
        }
        return mess;
    }
    //归还图书                                                              //OK
    @RequestMapping(value = "/returnBook")
    public Result returnBook(String orderId) throws IOException {
        Result mess = null;
        try{
            int book = impl.returnBook(orderId);
            if(book >0){
                mess = new Result("200","成功",book);
            }else{
                mess = new Result("404","失败",null);
            }
        }catch (Exception e){
            mess = new Result("500","异常",e.getMessage());
        }
        return mess;
    }

}
