package cn.lee.demo.mongo.model.base;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-6
 * Time: PM4:00
 */
public class Model implements Serializable {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
