package com.kk.controller;

import com.kk.service.UserService;
import com.kk.po.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by kk on 2019-1-25.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUser")
    public String getUser(Model model , Integer id) {
        if (id == null ) id = 1;
        System.out.println("s");
        model.addAttribute("user", userService.getById(id));
        return "user/showUser";
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public Object listUser() {
        User user = new User();
        return userService.list(user);
    }

    @RequestMapping(value = "getById")
    @ResponseBody
    public Object getByIdUser(Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "insert")
    @ResponseBody
    public Object insertUser(@RequestBody User user) {
        return userService.insert(user);
    }


    @RequestMapping(value = "update")
    @ResponseBody
    public Object updateUser(@RequestBody User user) {
        return userService.update(user);
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object deleteUser(@RequestBody User user) {
        return userService.delete(user);
    }

    @RequestMapping(value = "deleteByIds")
    @ResponseBody
    public Object deleteUserByIds(@RequestBody Integer[] ids) {
        return userService.deleteByIds(ids);
    }
}
