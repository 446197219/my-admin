package com.yeyu.service;

import com.yeyu.common.Page;
import com.yeyu.common.R;
import com.yeyu.pojo.Role;
import com.yeyu.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 用户登录业务类
     * @param username
     * @param password
     * @return
     */
    R login(HttpServletRequest request, String username, String password);

    void getAllUsers(User user, Page page);

    int uodateStateUserByIds(List<Integer> ids, Integer state);

    int deleteUserByIds(List<Integer> ids);

    int saveUser(User user);

    User getUserById(Integer userid);

    int updateUser(User user);
}
