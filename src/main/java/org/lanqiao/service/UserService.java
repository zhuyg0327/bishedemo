package org.lanqiao.service;

import org.lanqiao.dao.UserDao;
import org.lanqiao.model.Power;
import org.lanqiao.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
//    List<Power> userPower(String userId);
    //登录
   public User queryLogin(String username, String password,String power);
   //查询所有
   public  List<User> userAll(Map<String,Object> map);
    //根据id查询用户
   User queryUserById(String userId);
//注册
  //  int userAdd(String userId, String username, String password, String sex, String telephone, String userCard, Integer status, String power);
    int userAdd(User u);
    //注册时检查用户名是否重复
    User queryUsername(String username);
//修改用户
    int updateUser(User u);
    //逻辑删除用户
    int deleteUser(String userId);
    //修改头像
    int photo(String userId,String img);
//    int userDele(String uid);
//    int userUpdate(User user);
//    int photo(String photo , String uid);
    //   List<Role> queryByUserid(String id);
//    User queryUserById(String id);
    //int userAdd(String userid,String username,String userpassword,Byte sex,String usertelephone,String useraddress,String usercomment,String userimg,Byte userstatus);
}
