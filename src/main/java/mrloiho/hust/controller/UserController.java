/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.controller;

import java.io.IOException;
import java.util.List;
import mrloiho.hust.config.Config;
import mrloiho.hust.model.User;
import mrloiho.hust.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mr Loi Ho
 */
@RestController
@ResponseBody
public class UserController {

    @Autowired
    UserService userService;
    

    //-------------------Get All Users--------------------------------------------------------
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        List<User> user = userService.findAllUsers();
        return user;
    }

    //-------------------Get Single User--------------------------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") String id) throws IOException {
        return userService.findById(id);
    }

    //-------------------Create a User--------------------------------------------------------
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Boolean createUser(@RequestBody User user) {
        boolean rs = false;
        if (userService.isUserExist(user)) {
            return rs;
        }
        userService.saveUser(user);
        rs = true;
        return rs;
    }

    //------------------- Update a User --------------------------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Boolean updateUser(@PathVariable("id") String id, @RequestBody User user) {
        boolean rs = false;
        User currentUser = userService.findById(id);
        if (currentUser == null) {
            return rs;
        }
        currentUser.setId(user.getId());
        currentUser.setNameUser(user.getNameUser());
        currentUser.setPassword(user.getPassword());
        userService.updateUser(currentUser);
        rs = true;
        return rs;
    }

    //------------------- Delete a User --------------------------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable("id") String id) {
        User user = userService.findById(id);
        boolean rs = false;
        if (user == null) {
            return rs;
        }

        userService.deleteUserById(id);
        rs = true;
        return rs;
    }

    //------------------- Delete All User --------------------------------------------------------
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean deleteAllUsers() {
        boolean rs = false;
        {
            userService.deleteAllUsers();
            rs = true;
        }
        return rs;
    }
}
