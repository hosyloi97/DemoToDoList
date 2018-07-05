/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.services;

import java.util.List;
import mrloiho.hust.model.User;

/**
 *
 * @author Mr Loi Ho
 */
public interface UserService {

    User findById(String id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(String id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(User user);

}
