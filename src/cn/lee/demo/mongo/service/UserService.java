package cn.lee.demo.mongo.service;

import cn.lee.demo.mongo.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-6
 * Time: PM2:07
 */
public interface UserService extends BaseService {
    User saveUser(User user);

    User queryUserById(String id);
}
