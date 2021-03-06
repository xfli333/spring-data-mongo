package cn.lee.demo.mongo.dao;

import cn.lee.demo.mongo.model.base.Model;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-6
 * Time: PM3:59
 */
public interface MongoDao {

    Model save(Model model);

    Model save(Model model, String collection);

    void saveAll(List<Model> modelList);

    void delete(Model model);

    void deleteAll(Class clazz);

    void deleteAll(List<Model> modelList);

    Model update(Model model);

    void updateAll(List<Model> modelList);

    Model loadById(Class clazz, String id);

    List<Model> loadAll(Class clazz);

    List<Model> query(Class clazz, Map<String, Object> parameter);

    List<Model> query(Class clazz, Map<String, Object> parameter, String collection);

    MongoOperations getMongoOperations();
}
