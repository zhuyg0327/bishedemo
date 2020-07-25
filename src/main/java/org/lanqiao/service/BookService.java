package org.lanqiao.service;

import org.lanqiao.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
   //查询所有
   public  List<Book> queryAll();
   //根据类别查询图书
   public  List<Book> queryBookByLb(String category);
    //根据书名查询图书
    public  List<Book> queryBookByName(String bookName);
    //新增图书
    int bookAdd(Book book);
    //根据类别查询图书
    public  List<Book> queryBookById(String bookId);
    //查询图书是否有货
    public  List<Book> queryList(Map<String,Object> map);
    //下架和上架图书
    int upBook(String bookId,Integer status);
    //修改图书
    int updateBook(Book book);
    //修改图片以及上传图片
    int photo(String bookId,String bookImg);
}
