/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.app;

import java.util.List;
import mrloiho.hust.config.Config;
import mrloiho.hust.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Controller {

    @Autowired
    // For XML
    //ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
    // For Annotation
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");


    public boolean saveUser(User user) {
        boolean result = false;
        // save
        mongoOperation.save(user);
        result = true;
        return result;
    }

    public User searchUserId(String id) {

        // query to search user
        Query searchUserQuery = new Query(Criteria.where("id").is(id));

        // find the saved user again.
        User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
        return savedUser;
    }

    public boolean updateUser(String id, User u) {
        boolean result = false;

        Query searchUserQuery = new Query(Criteria.where("id").is(id));

        // find the saved user again.
        User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
        mongoOperation.updateFirst(searchUserQuery, Update.update("user_name", u.getNameUser()),
				User.class);
        mongoOperation.updateFirst(searchUserQuery, Update.update("password", u.getPassword()),
				User.class);
       
        return result;
    }

    public boolean deleteUser(String id){
        boolean result= false;
        Query searchUserQuery = new Query(Criteria.where("id").is(id));
    // delete
		mongoOperation.remove(searchUserQuery, User.class);
    // List, it should be empty now.
    List<User> listUser = mongoOperation.findAll(User.class);
    result= true;
    return result;

    
    }
}
