package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.model.Book;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookDao {
     //查询所有图书
     List<Book> queryall();
     //根据类别查询图书
     List<Book> queryBookByLb(@Param("category")String category);
    //根据书名查询图书
    List<Book> queryBookByName(@Param("bookName")String bookName);
     //新增图书
    int bookAdd(Book book);
    //根据id查询图书
    List<Book> queryBookById(@Param("bookId")String bookId);
    //查询图书是有货
    List<Book> queryList(Map<String,Object> map);
    //下架和上架图书
    int upBook(@Param("bookId") String bookId,@Param("status") Integer status);
    //修改图书
    int updateBook(Book book);
    //修改图片
    int photo(@Param("bookId") String bookId,@Param("bookImg") String bookImg);
}
