package cn.lee.demo.mongo;

import cn.lee.demo.mongo.annotation.TableName;
import cn.lee.demo.mongo.model.User;
import cn.lee.demo.mongo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-6
 * Time: PM2:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserService extends AbstractJUnit4SpringContextTests {
    @Resource
    private UserService userService;

    @Test
    public void saveTest() {
        User user = new User();
        user.setId("2");
        user.setBirthday(new Date());
        user.setName("test name");
        user.setPassword("password");
        this.userService.saveUser(user);
    }

    @Test
    public void queryTest() {
        System.out.println(this.userService.queryUserById("1"));
    }
}
