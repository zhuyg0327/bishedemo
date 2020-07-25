package org.lanqiao.controll;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.model.Book;
import org.lanqiao.service.BookService;
import org.lanqiao.vo.Result;
import org.lanqiao.vo.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/api/book")
public class BookApi {
    @Autowired
    BookService impl;
    private static final Logger logger = LoggerFactory.getLogger(BookApi.class);


    //查询所有
    @RequestMapping("/query")
    public Result queryall(){
        Result mess = null;
        try{
            PageHelper.startPage(1,1000);
            List<Book> books = impl.queryAll();
            PageInfo pageInfo=new PageInfo(books);
            if(books != null){
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
    //根据类别查询图书                                                                //OK
    @RequestMapping(value = "/queryBookByLb",method = RequestMethod.GET)
    public Result queryBookByLb(String category) throws IOException {
        Result mess = null;
        try{
            List<Book> book = impl.queryBookByLb(category);
            if(book != null){
                mess = new Result("200","查询成功",book);
            }else{
                mess = new Result("404","用户类别错误",null);
            }
        }catch (Exception e){
            mess = new Result("500","查询异常",e.getMessage());
        }
        return mess;
    }
    //根据名称查询图书                                                                //OK
    @RequestMapping(value = "/queryBookByName",method = RequestMethod.GET)
    public Result queryBookByName(String bookName) throws IOException {
        Result mess = null;
        try{
            List<Book> book = impl.queryBookByName(bookName);
            if(book != null){
                mess = new Result("200","查询成功",book);
            }else{
                mess = new Result("404","用户类别错误",null);
            }
        }catch (Exception e){
            mess = new Result("500","查询异常",e.getMessage());
        }
        return mess;
    }
    //根据id查询图书                                                                //OK
    @RequestMapping(value = "/queryBookById",method = RequestMethod.GET)
    public Result queryBookById(String bookId) throws IOException {
        Result mess = null;
        try{
            List<Book> book = impl.queryBookById(bookId);
            if(book != null){
                mess = new Result("200","查询成功",book);
            }else{
                mess = new Result("404","查询错误",null);
            }
        }catch (Exception e){
            mess = new Result("500","查询异常",e.getMessage());
        }
        return mess;
    }
    //新增图书
    @RequestMapping("/addBook")
    public Result bookAdd(String category,String bookImg,String bookName,String comment,String place,String price,String rentPrice,Integer status,String bookNum,String author) {
        Result mess = null;
        try{
            Book book=new Book();
            book.setBookId(UUIDUtil.get16UUID());
            book.setCategory(category);
            book.setBookImg(bookImg);
            book.setBookName(bookName);
            book.setComment(comment);
            book.setPlace(place);
            book.setPrice(price);
            book.setRentPrice(rentPrice);
            book.setStatus(1);
            book.setBookNum(bookNum);
            book.setAuthor(author);
            book.setImgStatus(1);
            int row = impl.bookAdd(book);
            if(row > 0){
                mess = new Result("200","成功",row);
            }else{
                mess = new Result("500","失败，请注意信息填写",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            mess = new Result("500","异常",e.getMessage());
        }
        return mess;
    }
    //查询图书是否有货(多条件）
    @RequestMapping("/queryList")
    public Result queryList(String isLack,String status){
        Result mess = null;
        try{
            Map<String,Object> map=new HashMap<>();
            if(isLack !=null && isLack !=""){
                map.put("isLack",isLack);
            }
            map.put("status",status);
            PageHelper.startPage(1,1000);
            List<Book> books = impl.queryList(map);
            PageInfo pageInfo=new PageInfo(books);
            if(books != null){
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
    //下架和上架图书                                                              //OK
    @RequestMapping(value = "/upBook",method = RequestMethod.GET)
    public Result upBook(String bookId,Integer status) throws IOException {
        Result mess = null;
        try{
            int book = impl.upBook(bookId,status);
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
    //修改图书
    @RequestMapping("/updateBook")
    public Result updateUser(String bookId,String category,String bookName,String bookImg,String comment,String place,String price,String rentPrice,String bookNum,String author,Integer imgStatus) {
        Result mess = null;
        try{
            Book book=new Book();
            book.setBookId(bookId);
//            book.setCategory(category);
//            book.setBookName(bookName);
//            book.setComment(comment);
//            book.setPlace(place);
//            book.setPrice(price);
//            book.setRentPrice(rentPrice);
//            book.setBookNum(bookNum);
//            book.setAuthor(author);
            book.setCategory(category !=null && category !="" ?category :"");
            book.setBookName(bookName !=null && bookName !="" ?bookName :"");
            book.setBookImg(bookImg !=null && bookImg !="" ?bookImg :"");
            book.setComment(comment !=null && comment !="" ?comment :"");
            book.setPlace(place !=null && place !="" ?place :"");
            book.setPrice(price !=null && price !="" ?price :"");
            book.setRentPrice(rentPrice !=null && rentPrice !="" ?rentPrice :"");
            book.setBookNum(bookNum !=null && bookNum !="" ?bookNum :"");
            book.setAuthor(author !=null && author !="" ?author :"");
            book.setImgStatus(imgStatus !=null ? imgStatus :null);
            int row = impl.updateBook(book);
            //           int row = impl.userAdd(UUIDUtil.get16UUID(),username,password,sex,telephone,userCard,1,power);
            if(row > 0){
                mess = new Result("200","修改成功",row);
            }else{
                mess = new Result("500","修改失败，请注意信息填写",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            mess = new Result("500","修改异常",e.getMessage());
        }
        return mess;
    }

        /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/headImg", method = RequestMethod.POST)
    public Result fileUpload2(@RequestParam("headimg") MultipartFile file,String bookId) throws IOException {
        Result js;
        if(file.isEmpty()){
            js = new Result("404","上传失败，未选择文件！");
            return js;
        }
        try {
            long  startTime=System.currentTimeMillis();
//                System.out.println("fileName："+file.getOriginalFilename());
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //String uuid= UUID.randomUUID().toString().replace("-","");
            String uuid= UUIDUtil.get4UUID();
            //重命名
            String newFilename = uuid + suffixName;
//            userService serviceImpl=new userService();
            //保存路径
            String path="F:\\images\\";
//            File newFile=new File(path+newFilename);
            File newFile=new File(path+fileName);
            file.transferTo(newFile);
            long  endTime=System.currentTimeMillis();
            String photoId=path+newFilename;
            int row=0;
            if(photoId!=null){
//                System.out.println(photoId+"值");
                if(bookId !=null && bookId !=""){
                    row=impl.photo(bookId,fileName);
                }
                System.out.println("有值");
            }
            js = new Result("200", "上传成功",row);
        }catch (Exception e){
            e.printStackTrace();
            js = new Result("500", "上传异常");
        }
        return js;
    }
}
