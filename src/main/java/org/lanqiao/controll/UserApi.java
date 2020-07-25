package org.lanqiao.controll;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.model.Power;
import org.lanqiao.model.User;
import org.lanqiao.service.UserService;
import org.lanqiao.vo.Result;
import org.lanqiao.vo.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin.util.UIUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    UserService impl;
//   RedisTemplate redisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserApi.class);

////查询用户权限
//    @RequestMapping("/userPower")
//    public Result userPower(String userId){
//        Result mess = null;
////        //userService userService = new userService();
//        List<Power> userPower = null;
//        try{
//            userPower = impl.userPower(userId);
//            if(userPower != null){
//                mess = new Result("200","查询成功",userPower);
//            }else{
//                mess = new Result("500","查询失败",null);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            mess = new Result("500","查询异常",e.getMessage());
//        }
//        return mess;
//    }
    //登录                                                                 //OK
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result login(String username, String password,String power) throws IOException {
        Result mess = null;
        System.out.println(2);
        try{
            System.out.println(3);
            User user = impl.queryLogin(username,password,power);
            System.out.println(1);
            if(user != null){
                 mess = new Result("200","登陆成功",user);
                //将登录信息放到session，记录登录状态
              //  String token_jSessionId=SecurityUtl.getMd5String(username);
//                redisTemplate.opsForHash().put("loginUserKey",token_jSessionId,user.getUserId());
//                redisTemplate.opsForValue().set(token_jSessionId,user.getUserId());
//                redisTemplate.expire(token_jSessionId,24, TimeUnit.HOURS);
                //创建一个cookie来存储令牌
//                Cookie cookie=new Cookie("token",token_jSessionId);
//                cookie.setPath("/");
//                cookie.setMaxAge(60*60*60);
//                resp.addCookie(cookie);
//                mess=new Result("200","ok","user");
//                logger.info("{}已经成功登陆,密码是{}",username,password);
            }else{
                mess = new Result("404","用户名或密码错误",null);
            }
        }catch (Exception e){
            mess = new Result("500","登录异常",e.getMessage());
//            logger.error("登陆异常，原因是[{}]",e.getCause().getMessage());
        }
        return mess;
    }
    //根据id查询用户                                                                 //OK
    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public Result queryUserById(String userId) throws IOException {
        Result mess = null;
        try{
            User user = impl.queryUserById(userId);
            if(user != null){
                mess = new Result("200","查询成功",user);
            }else{
                mess = new Result("404","用户id错误",null);
            }
        }catch (Exception e){
            mess = new Result("500","查询异常",e.getMessage());
        }
        return mess;
    }
    //查询所有
    @RequestMapping("/query")
    public Result query(String username,String telephone,Integer status){
        Result mess = null;
        try{
            Map<String,Object> map=new HashMap<>();
            if(username !=null && username !=""){
                map.put("username",username);
            }
            if(telephone !=null && telephone !=""){
                map.put("telephone",telephone);
            }
            if(status !=null){
                map.put("status",status);
            }
            PageHelper.startPage(1,1000);
            List<User> users = impl.userAll(map);

            PageInfo pageInfo=new PageInfo(users);
            if(users != null){
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
//注册用户
    @RequestMapping("/regist")
    public Result regist(String userId,String username,String password,String sex,String telephone,String userCard,Integer status,String power) {
        Result mess = null;
        try{
            User u=new User();
            u.setUserId(UUIDUtil.get16UUID());
            u.setUsername(username);
            u.setPassword(password);
            u.setSex(sex);
            u.setTelephone(telephone);
            u.setUserCard(userCard);
            u.setStatus(1);
            u.setPower(power);
            System.out.println(u);
            User user=impl.queryUsername(username);
            if(user == null){
                int row = impl.userAdd(u);
                if(row > 0){
                    mess = new Result("200","注册成功",row);
                }else{
                    mess = new Result("500","注册失败，请注意信息填写",null);
                }
            }else{
                mess = new Result("501","用户名重复",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            mess = new Result("500","注册异常",e.getMessage());
        }
        return mess;
    }
    //修改用户
    @RequestMapping("/updateUser")
    public Result updateUser(String userId,String img,String username,String password,String sex,String telephone,String userCard,Integer status,String power) {
        Result mess = null;
        try{
            User u=new User();
            u.setUserId(userId !=null && userId !="" ?userId :"");
            u.setImg(img !=null && img !="" ?img :"");
            u.setUsername(username !=null && username !="" ?username :"");
            u.setPassword(password !=null && password !="" ?password :"");
            u.setSex(sex !=null && sex !="" ?sex :"");
            u.setTelephone(telephone !=null && telephone !="" ?telephone :"");
            u.setUserCard(userCard !=null && userCard !="" ?userCard :"");
            u.setStatus(status !=null ?status :null);
            u.setPower(power !=null && power !="" ?power :"");
            int row = impl.updateUser(u);
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
    //逻辑删除用户
    @RequestMapping("/deleteUser")
    public Result deleteUser(String userId) {
        Result mess = null;
        try{
            int row = impl.deleteUser(userId);
            if(row > 0){
                mess = new Result("200","删除成功",row);
            }else{
                mess = new Result("500","删除失败，请注意信息填写",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            mess = new Result("500","删除异常",e.getMessage());
        }
        return mess;
    }
    /**
     * 上传头像
     * @param file
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/headImg", method = RequestMethod.POST)
    public Result fileUpload2(@RequestParam("headimg") MultipartFile file,String userId) throws IOException {
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
                if(userId !=null && userId !=""){
                    row=impl.photo(userId,fileName);
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

//    //OK
//    //删除用户
//    @RequestMapping("/delete")
//    public Result del(String userId){
//        //userService userService = new userService();
//        Result mess = null;
//        try{
//            int row = impl.userDele(userId);
//            if (row > 0) {
//                mess = new Result("200","删除成功",row);
//            }    else{
//                mess = new Result("500","删除失败",null);
//            }
//        }catch (Exception e){
//            mess = new Result("500","删除异常",e.getMessage());
//        }
//        return mess;
//    }                                                                                          //OK

//    @RequestMapping("/logout")
//    public Result logout(String userId,HttpServletRequest req,HttpServletResponse resp){
//        HttpSession session=req.getSession(true);
//        Result mess = null;
//        try{
//            session.invalidate();
//            mess = new Result("200","退出登录成功","OK");
//        }catch(Exception e){
//            mess = new Result("500","退出失败","wrong");
//        }
//        return mess;
//    }
//    /**
//     * 上传文件
//     * @param file
//     * @return
//     * @throws IOException
//     */
//    @ResponseBody
//    @RequestMapping(value = "/headImg", method = RequestMethod.POST)
//    public Result fileUpload2(@RequestParam("headimg") MultipartFile file,
//                                  @RequestParam("userId") String userId) throws IOException {
//        Result js;
//        if(file.isEmpty()){
//            js = new Result(Constants.STATUS_NOT_FOUND,"上传失败，未选择文件！");
//            return js;
//        }
//        try {
//            long  startTime=System.currentTimeMillis();
////                System.out.println("fileName："+file.getOriginalFilename());
//            //获取文件名
//            String fileName = file.getOriginalFilename();
//            //获取后缀名
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            //String uuid= UUID.randomUUID().toString().replace("-","");
//            String uuid= UUIDUtil.get4UUID();
//            //重命名
//            String newFilename = uuid + suffixName;
////            userService serviceImpl=new userService();
//            //保存路径
//            String path="F:\\images\\";
//            File newFile=new File(path+newFilename);
//            file.transferTo(newFile);
//            long  endTime=System.currentTimeMillis();
//            String photoId=path+newFilename;
//            int row=0;
//            if(photoId!=null){
//                System.out.println(photoId+"值");
//                row=userServiceimpl.photo(newFilename,userId);
//                System.out.println("有值");
//            }
//            js = new Result(Constants.STATUS_SUCCESS, "上传成功",row);
//        }catch (Exception e){
//            e.printStackTrace();
//            js = new Result(Constants.STATUS_SUCCESS, "上传异常");
//        }
//        return js;
//    }

//    //OK

}
