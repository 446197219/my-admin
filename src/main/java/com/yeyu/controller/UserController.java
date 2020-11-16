package com.yeyu.controller;

import com.yeyu.common.Page;
import com.yeyu.common.R;
import com.yeyu.pojo.User;
import com.yeyu.service.UserService;
import com.yeyu.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: my-admin
 * @description: 用户控制类
 * @author: ganzj
 * @create: 2020-09-21 10:02
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("userLogin")
    public R login(HttpServletRequest request, @RequestParam(value = "username" , required = true) String username, @RequestParam(value="password",required = true) String password){

        //获取subject
        Subject subject = SecurityUtils.getSubject();

        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            R.ok();
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return R.fail("用户名错误，无此用户！");
        }catch (IncorrectCredentialsException e){
            return R.fail("密码错误");
        }


        //引入shiro去掉原有登录
//        return userService.login(request, username, password);
        return R.ok();
    }


    /***
     * 退出登录 返回登录页面
     * @return
     */
    @RequestMapping("logout")
    public String logout(){

        //获取subject
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "/page/login";
    }

    /**
     * 分页查询所有用户信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllUsers")
    public R getAllUsers(User user, Page page){
        System.out.println(page.toString());
        userService.getAllUsers(user,page);
        return R.ok().put("page",page);
    }

    @ResponseBody
    @RequestMapping("saveUser")
    public R saveUser(User user){
        user.setCreateTime(DateUtil.getCurrentDay(DateUtil.DATE_TIME));
        user.setState("1");
        user.setPassword("123456");
        user.setUserType("1");
        int count = userService.saveUser(user);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("新增失败，服务异常");
        }
    }

    /**
     * 注销用户 修改用户状态
     * @param ids
     * @param state
     * @return
     */
    @ResponseBody
    @RequestMapping("updateStateUserByIds")
    public R deleteRoleByIds(@RequestParam(value = "ids[]") List<Integer> ids,@RequestParam(value = "state") Integer state){
        int count = userService.uodateStateUserByIds(ids,state);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("注销失败，该用户已被注销");
        }
    }

    /**
     * 删除用户数据
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteUserByIds")
    public R deleteUserByIds(@RequestParam(value = "ids[]") List<Integer> ids){
        int count = userService.deleteUserByIds(ids);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("删除失败，该用户已被删除");
        }
    }

    /**
     * 根据ID获得用户
     * @param userid
     * @return
     */
    @ResponseBody
    @RequestMapping("getUserById")
    public R getUserById(@RequestParam(value = "userid") Integer userid){
        User user = userService.getUserById(userid);
        return R.ok().put("user",user);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("updateUser")
    public R updateUser(User user){
        int count = userService.updateUser(user);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("修改失败，无对应数据");
        }
    }
}
