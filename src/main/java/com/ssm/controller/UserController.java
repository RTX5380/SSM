package com.ssm.controller;

import com.ssm.domain.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(HttpServletRequest request, @RequestBody User user){
        //查询数据库
        User userDB = userService.login(user);
        //如果没有查询到则返回登录失败结果
        if(userDB == null){
            return new Result(Code.LOGIN_ERR,null,"无该用户信息");
        }
        //密码比对，如果不一致则返回登录失败结果
        if(!userDB.getPassword().equals(user.getPassword())){
            return new Result(Code.PASSWORD_ERR,null,"密码错误");
        }
        //登录成功，将用户id存入Session并返回登录成功结果
        request.getSession().setAttribute("user",userDB.getId());
        return new Result(Code.LOGIN_OK,userDB,"登录成功");
    }
}
