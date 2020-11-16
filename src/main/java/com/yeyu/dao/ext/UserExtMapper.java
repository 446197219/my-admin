package com.yeyu.dao.ext;

import com.yeyu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserExtMapper {

    User login(String username);

    User getUserByOpenid(String openid);

    int updateStateByOpenid(String openid);

    int getCountAllUsers(User user);

    List<User> getAllUsers(User user);

    int uodateStateUserByIds(@Param("ids") List<Integer> ids,@Param("state") Integer state);

    int deleteUserByIds(List<Integer> ids);
}