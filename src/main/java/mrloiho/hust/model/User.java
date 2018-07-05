/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author Mr Loi Ho
 */
@Data
//the @Data cua lombok se giup khai bao getter, setter va constructor tu dong
@Document(collection = "Users")
public class User {

    @Id
    private String id;

    @Field("user_name") 
//    mapping giua bien nameUser va bien user_name trong database
    private String nameUser;
//    @Field("password")
    private String password;

    @Field("numTasks")
    private int numTasks;

    @Field("listTasks")
    List<Task> listTasks = new ArrayList<Task>();

    public User() {
    }

    public User(String id, String nameUser, String password, int numTasks, List<Task> list) {
        this.id = id;
        this.nameUser = nameUser;
        this.password = password;
        this.numTasks = numTasks;
        this.listTasks= list;
    }

    
   

    public User( String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
    }


}
