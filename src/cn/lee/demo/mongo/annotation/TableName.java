package cn.lee.demo.mongo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-6
 * Time: PM4:30
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TableName {
    String value();
}
