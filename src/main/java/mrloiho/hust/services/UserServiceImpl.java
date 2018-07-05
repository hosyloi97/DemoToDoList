/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import mrloiho.hust.model.Task;
import mrloiho.hust.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mr Loi Ho
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static List<User> users = arrayUsers();

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User findById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getNameUser().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(String id) {
        User user = findById(id);
        users.remove(user);

//        for (User user : users) {
//            if (user.getIdUser()== id){
//                users.remove(user);
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }

    @Override
    public boolean isUserExist(User user) {
        return findByName(user.getNameUser()) != null;
    }

    public static List<User> arrayUsers() {
        List<User> userarr = new ArrayList<User>();
//        SimpleDateFormat ft = new SimpleDateFormat ("yyyy:MM:dd");
//       
        Task t1 = new Task("learning English", true);
        Task t2 = new Task("marry wife", true);
        Task t3 = new Task("never give up", true);
        Task t4 = new Task("die", true);
        Task t5 = new Task("born", false);
        List<Task> l1 = new ArrayList<Task>();
        l1.add(t1);
        List<Task> l2 = new ArrayList<Task>();
        l2.add(t1);
        l2.add(t3);
        List<Task> l3 = new ArrayList<Task>();
        l3.add(t5);
        l3.add(t4);
        l3.add(t1);
        List<Task> l4 = new ArrayList<Task>();
        l4.add(t5);
        userarr.add(new User("10", "Hello", "3000", 1, l1));
        userarr.add(new User("11", "Hi", "4000", 2, l2));
        userarr.add(new User("12", "Hallo", "5000", 3, l3));
        userarr.add(new User("13", "Aloha", "6000", 1, l4));
        return userarr;
    }
}
