/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.model;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Mr Loi Ho
 */
@Data
//the @Data cua lombok se giup khai bao getter, setter va constructor tu dong
public class Task {

    private String nameTask;
    private boolean status;
//    private Date dueDate;
//    private Date dateFinish;

//    public Task(String nameTask, Date dueDate, Date dateFinish) {
//        this.nameTask = nameTask;
//        this.dueDate = dueDate;
//        this.dateFinish = dateFinish;
//    }
    public Task(String nameTask, boolean status) {
        this.nameTask = nameTask;
        this.status = status;
    }

}
