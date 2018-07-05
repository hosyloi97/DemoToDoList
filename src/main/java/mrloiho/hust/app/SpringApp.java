/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.app;

import java.util.List;
import mrloiho.hust.config.Config;
import mrloiho.hust.model.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 *
 * @author Mr Loi Ho
 */

public class SpringApp {



    public static void main(String[] args) {
        // For XML
        //ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
        // For Annotation
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        User u1= new User( "mrloiho", "haha123");
        User u2= new User( "haha", "haha123");
        User u3= new User( "hehe", "haha123");
        User u4= new User( "huhu", "heheh");
        User u5= new User( "hichic", "haha123");
        Controller c= new Controller();
//        c.saveUser(u1);
//        c.saveUser(u2);
//        c.saveUser(u3);
       c.updateUser("5b3df3d8e0da8bfbc1593626", u3);
        System.out.println(u1.toString());
        c.deleteUser("5b3df3d8e0da8bfbc1593627");
        
    }  
    
//    	public static void main(String[] args) {
//    
//    // For XML
//    //ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
//    
//    // For Annotation
//    ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
//    
//    User user = new User("mrloiho", "password123");
//    
//    // save
//    mongoOperation.save(user);
//    
//    // now user object got the created id.
//    System.out.println("1. user : " + user);
//    
//    // query to search user
//    Query searchUserQuery = new Query(Criteria.where("username").is("mrloiho"));
//    
//    // find the saved user again.
//    User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
//    System.out.println("2. find - savedUser : " + savedUser);
//    
//    // update password
//    mongoOperation.updateFirst(searchUserQuery, Update.update("password", "new password"),
//    User.class);
//    
//    // find the updated user object
//    User updatedUser = mongoOperation.findOne(
//    new Query(Criteria.where("username").is("mkyong")), User.class);
//    
//    System.out.println("3. updatedUser : " + updatedUser);
//    
//    // delete
//    mongoOperation.remove(searchUserQuery, User.class);
//    
//    // List, it should be empty now.
//    List<User> listUser = mongoOperation.findAll(User.class);
//    System.out.println("4. Number of user = " + listUser.size());
//	}
//        
//        
        

    }

