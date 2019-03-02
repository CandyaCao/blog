package com.github.candyacao.web;

import java.util.List;

import com.github.candyacao.config.Config;
import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.mapper.UserMapper;
import com.github.candyacao.service.UserService;
import com.github.candyacao.utils.Misc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/signin")
    public void signin(String id, HttpServletRequest request) {
        UserEntity me = userService.signin(id);
        if (me == null) {
            // error msg
        } else {
            // session
            HttpSession session = request.getSession();
            session.setAttribute(Config.SESSION_LOGINED_KEY, me);
        }
    }

    @RequestMapping("/me")
    public UserEntity meProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity me = (UserEntity) session.getAttribute(Config.SESSION_LOGINED_KEY);
        return me;
    }

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(String id) {
        UserEntity user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(UserEntity user) {
        user.setId(Misc.UUID());
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(UserEntity user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        userMapper.delete(id);
    }


}