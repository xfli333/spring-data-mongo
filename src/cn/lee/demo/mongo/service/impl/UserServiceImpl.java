package cn.lee.demo.mongo.service.impl;

import cn.lee.demo.mongo.model.User;
import cn.lee.demo.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-6
 * Time: PM2:09
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {


    @Override
    public User saveUser(User user) {
        return (User) this.save(user);
    }

    @Override
    public User queryUserById(String id) {
        return (User) this.loadById(User.class, id);
    }
}
