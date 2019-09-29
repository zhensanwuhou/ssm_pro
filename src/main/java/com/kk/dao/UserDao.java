package com.kk.dao;

import com.kk.po.User;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* Created by kk on 2019-1-25.
*/
public interface UserDao {

    int insert(User user);

    int delete(User user);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(User user);

    User getById(@Param("id") Integer id);

    List<User> list(User user);

    User getUserByName(String username);
}