package cn.lee.demo.mongo.model;

import cn.lee.demo.mongo.annotation.TableName;
import cn.lee.demo.mongo.model.base.ModelT;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-6
 * Time: PM2:01
 */
@Document(collection = "users")
public class User extends ModelT implements Serializable {

    private String name;
    private String password;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("User");
        sb.append("{name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }
}
