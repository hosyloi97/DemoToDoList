/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrloiho.hust.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 *
 * @author Mr Loi Ho
 */
@Configuration
public class Config extends AbstractMongoConfiguration {

    public static final String DB_NAME = "newDB";
    public static final String USER_COLLECTION = "Users";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(MONGO_HOST);
    }
}
