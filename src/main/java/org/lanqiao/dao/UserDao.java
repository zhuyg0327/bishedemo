package org.lanqiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.model.Power;
import org.lanqiao.model.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    //登录
     User queryLogin(@Param("username") String username, @Param("password") String password,@Param("power") String power);
     //查询所有用户
     List<User> queryall(Map<String,Object> map);
     //根据id查询用户
    User queryUserById(@Param("userId")String userId);
//     //注册用户
   // int userAdd(@Param("userId") String userId, @Param("username") String username, @Param("password") String password, @Param("sex") String sex, @Param("telphone") String telephone, @Param("userCard") String userCard, @Param("status") Integer status, @Param("power") String power);
    int userAdd(User u);
    //注册时检查用户名是否重复
    User queryUsername(@Param("username") String username);
//修改用户
    int updateUser(User u);
    //逻辑删除用户
    int deleteUser(@Param("userId") String userId);
    //修改头像
    int photo(@Param("userId") String userId,@Param("img") String img);
//    //删除用户
//    int userDele(String userid);
//    //查询用户权限
//     List<Power> userPower(String userId);
}
