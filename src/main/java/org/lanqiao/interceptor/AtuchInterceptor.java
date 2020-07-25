package org.lanqiao.interceptor;


import org.lanqiao.vo.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//public class AtuchInterceptor implements HandlerInterceptor {
// RedisTemplate redisTemplate;
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
////        HttpServletRequest request1=(HttpServletRequest)httpServletRequest;
////        HttpSession session=request1.getSession(true);
////        System.out.println("权限拦截器");
////        Object user=session.getAttribute("loginUserKey");
////        if("3".equals(user)){
////            System.out.println(user+"-------"+"允许进入");
////            return true;
////        }else{
////            System.out.println("阻止进入");
////            return false;
////        }
//        Cookie[]  cookies=httpServletRequest.getCookies();
//        if(cookies!=null && cookies.length>0){
//            for(Cookie cookie:cookies){
//                if ("token".equals(cookie.getName())) {
//                    String token_jsessionId = cookie.getValue();
//                    Object obj = redisTemplate.opsForHash().get("loginUserKey", token_jsessionId);
//                    if (obj != null) {
//                        return true;
//                    }
//                }
//            }
//        }
//        Result result=new Result("250","没有令牌无法登陆");
//        httpServletResponse.setContentType("application/json:charset=UTF-8");
//        //httpServletResponse.getWriter().write(new Gson().toJson(result));
//        httpServletResponse.getWriter().flush();
//        return false;
//    }
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//}
