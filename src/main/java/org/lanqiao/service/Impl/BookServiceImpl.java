package org.lanqiao.service.Impl;

import org.lanqiao.dao.BookDao;
import org.lanqiao.model.Book;
import org.lanqiao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Primary
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao dao;

    //查询所有
    @Override
    public List<Book> queryAll() {
            List<Book> book=dao.queryall();
            return book;
    }
//根据类别查询
    @Override
    public List<Book> queryBookByLb(String category) {
        List<Book> book=dao.queryBookByLb(category);
        return book;
    }
//根据书名查询
    @Override
    public List<Book> queryBookByName(String bookName) {
        List<Book> book=dao.queryBookByName(bookName);
        return book;
    }

    //新增图书
    @Override
    public int bookAdd(Book book) {
        int row = dao.bookAdd(book);
        return row;
    }
//根据id查询图书
    @Override
    public List<Book> queryBookById(String bookId) {
        List<Book> book=dao.queryBookById(bookId);
        return book;
    }

    @Override
    public List<Book> queryList(Map<String, Object> map) {
        List<Book> book=dao.queryList(map);
        return book;
    }
//下架和上架图书
    @Override
    public int upBook(String bookId, Integer status) {
        int row=dao.upBook(bookId,status);
        return row;
    }
    //修改图书
    @Override
    public int updateBook(Book book) {
        int row =dao.updateBook(book);
        return row;
    }
//修改图片
    @Override
    public int photo(String bookId, String bookImg) {
        int row=dao.photo(bookId,bookImg);
        return row;
    }

}
