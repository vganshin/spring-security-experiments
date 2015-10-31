package me.vlad.controllers;

import me.vlad.dao.UserDao;
import me.vlad.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Контроллер для главной страницы приложения.
 */
@Controller
public class AppController {
    UserDao userDao = new UserDao();

    @RequestMapping("/")
    public @ResponseBody List<User> index() {
        return userDao.getAllUsers();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody User register(@RequestBody User user) {
        return userDao.saveUser(user);
    }

}