package com.yeyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.yeyu.common.Page;
import com.yeyu.common.R;
import com.yeyu.dao.UserMapper;
import com.yeyu.dao.ext.UserExtMapper;
import com.yeyu.model.ProjectConstants;
import com.yeyu.pojo.User;
import com.yeyu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: my-admin
 * @description: 用户接口实现类
 * @author: ganzj
 * @create: 2020-09-21 09:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserExtMapper userExtMapper;

    @Override
    public R login(HttpServletRequest request,String username, String password) {

        User user = userExtMapper.login(username);
        if(null!=user){
            if(password.equals(user.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute(ProjectConstants.SESSION_USER_NAME,user);
            }else {
                return R.fail("密码错误");
            }
        }else{
            return R.fail("用户名错误，无此用户！");
        }
        return R.ok();
    }

    @Override
    public void getAllUsers(User user, Page page) {
        int count = userExtMapper.getCountAllUsers(user);
        if(count>0){
            page.setDataCount(count);
            PageHelper.startPage(page.getPageNums(),page.getPageSize());
            List<User> roles = userExtMapper.getAllUsers(user);
            page.setData(roles);
        }
    }

    @Override
    public int uodateStateUserByIds(List<Integer> ids, Integer state) {
        return userExtMapper.uodateStateUserByIds(ids,state);
    }

    @Override
    public int deleteUserByIds(List<Integer> ids) {
        return userExtMapper.deleteUserByIds(ids);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User getUserById(Integer userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
