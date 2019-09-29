package com.kk.service;

import com.kk.po.User;
import java.util.List;

/**
* Created by kk on 2019-1-25.
*/
public interface UserService {

    int insert(User user);

    int delete(User user);

    int deleteByIds(Integer[] ids);

    int update(User user);

    User getById(Integer id);

    List<User> list(User user);

    User getUserByName(String username);
}