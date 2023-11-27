package com.shiyan.controller;

import com.shiyan.domain.User;
import com.shiyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/toMainPage")
    public String  toMainPage(){
        return "main";
    }
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest httpServletRequest){
        try{
            User user1 = userService.login(user);
            if(user1 != null){
                httpServletRequest.getSession().setAttribute("USER_SESSION",user1);
                return "redirect:/admin/main.jsp";
            }
            httpServletRequest.setAttribute("msg","用户名或密码错误");
            return "forward:/admin/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            httpServletRequest.setAttribute("msg","系统错误，请联系系统管理员");
            return "forward:/admin/login.jsp";
        }
    }
    /*
    注销登录
     */
    @RequestMapping("/logout")
    public String logout( HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            //销毁Session
            session.invalidate();
            return  "forward:/admin/login.jsp";
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msg","系统错误");
            return  "forward:/admin/login.jsp";
        }
    }
}
