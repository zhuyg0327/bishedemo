package org.lanqiao.service.Impl;

import org.lanqiao.dao.UserDao;
import org.lanqiao.model.Power;
import org.lanqiao.model.User;
import org.lanqiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class UserServiceImpl implements UserService {
    @Autowired
    //@Qualifier("userDao")
    UserDao dao;
    //登录
    @Override
    public User queryLogin(String username, String password,String power){
        User user =dao.queryLogin(username,password,power);
        return user;
    }
    //查询所有
    @Override
//    @Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)

    public List<User> userAll(Map<String,Object> map) {
            List<User> user=dao.queryall(map);
            return user;
    }
    //根据id查询用户
    @Override
    public User queryUserById(String userId) {
        User user=dao.queryUserById(userId);
        return user;
    }
//    //注册用户
//    @Override
//        public int userAdd(String userId,String username,String password,String sex,String telephone,String userCard,Integer status,String power) {
//        int row = dao.userAdd(userId,username,password,sex,telephone,userCard,status,power);
//        return row;
//    }
//注册用户
@Override
public int userAdd(User u) {
    int row = dao.userAdd(u);
    return row;
}
//注册时检查用户名是否重复
    @Override
    public User queryUsername(String username) {
        User user=dao.queryUsername(username);
        return user;
    }

    //修改用户
    @Override
    public int updateUser(User u) {
        int row =dao.updateUser(u);
        return row;
    }
//逻辑删除用户
    @Override
    public int deleteUser(String userId) {
        int row=dao.deleteUser(userId);
        return row;
    }
//修改头像
    @Override
    public int photo(String userId, String img) {
        int row=dao.photo(userId,img);
        return row;
    }
////删除用户
//        public int userDele(String uid) {
//        return dao.userDele(uid);
//    }
// //查询用户权限
//    public List<Power> userPower(String userId){
//        List<Power> list = dao.userPower(userId);
//        List<Power> list2  =new ArrayList<>();
//        Power power = null;
//        System.out.println(000000000000000000000000000000000000);
//        System.out.println(list);
//        for (Power powers : list) {
//            if((powers.getPowerType() == 1) && ((powers.getPowerFather().equals("0")))){
//                power = powers;
//                List<Power> ll = new ArrayList<>();
//                for (Power power1 : list) {
//                    Power power2 = null;
//                    if(power1.getPowerFather().equals(power.getPowerId())){
//                        power2 = power1;
//                        ll.add(power1);
//                    }
//                    power.setPowerChild(ll);
//                }
//                list2.add(power);
//            }
//        }
//        System.out.println(list2);
//        return list;
//
//    }
    //


//    public List<Role> queryByUserid(String id) {
//        UserDao userDao = new UserDao();
//        return userDao.queryByUserid(id);
//    }
//
//    public User queryUserById(String id) {
//        UserDao userDao = new UserDao();
//        User user = userDao.queryById(id);
//        return user;
//    }


//    public int userUpdate(User user) {
//        String uid = user.getUserId();
//        String uname = user.getUserName();
//        String password = user.getUserPassword();
//        String tel = user.getuserTelephone();
//        String address = user.getUserAddress();
//        String comment = user.getUserComment();
//        UserDao userDao = new UserDao();
//        userDao.userUpdate(user);
//        int row = userDao.userUpdate(user);
//        return row;
//    }
//    public int photo(String photo , String uid){
//        UserDao userDao = new UserDao();
//        return userDao.photo(photo,uid);
//    }
}
