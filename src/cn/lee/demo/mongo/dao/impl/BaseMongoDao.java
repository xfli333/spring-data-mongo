package cn.lee.demo.mongo.dao.impl;

import cn.lee.demo.mongo.dao.MongoDao;
import cn.lee.demo.mongo.model.base.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-7
 * Time: PM2:01
 */
@Component()
public class BaseMongoDao implements MongoDao {

    @Autowired
    private MongoOperations mongoTemplate;

    @Override
    public Model save(Model model) {
        this.mongoTemplate.save(model);
        return model;
    }

    @Override
    public Model save(Model model, String collection) {
        this.mongoTemplate.save(model, collection);
        return model;
    }


    @Override
    public void saveAll(List<Model> modelList) {
        for (Model model : modelList) {
            this.mongoTemplate.save(model);
        }
    }

    @Override
    public void delete(Model model) {
        this.mongoTemplate.remove(model);
    }

    @Override
    public void deleteAll(Class clazz) {
        this.mongoTemplate.dropCollection(clazz);
    }

    @Override
    public void deleteAll(List<Model> modelList) {
        for (Model model : modelList) {
            this.mongoTemplate.remove(model);
        }
    }

    @Override
    public Model update(Model model) {
        return save(model);
    }

    @Override
    public void updateAll(List<Model> modelList) {
        saveAll(modelList);
    }

    @Override
    public Model loadById(Class clazz, String id) {
        return (Model) this.mongoTemplate.findById(id, clazz);
    }

    @Override
    public List<Model> loadAll(Class clazz) {
        return this.mongoTemplate.findAll(clazz);
    }

    @Override
    public List<Model> query(Class clazz, Map<String, Object> parameter) {
        return this.query(clazz, parameter, null);
    }

    @Override
    public List<Model> query(Class clazz, Map<String, Object> parameter, String collection) {
        Query query = new Query();
        for (Map.Entry<String, Object> entry : parameter.entrySet()) {
            query.addCriteria(Criteria.where(entry.getKey()).is(entry.getKey()));
        }
        if (null == collection) {
            return this.mongoTemplate.find(query, clazz);
        }
        return this.mongoTemplate.find(query, clazz, collection);
    }

    @Override
    public MongoOperations getMongoOperations() {
        return this.mongoTemplate;
    }
}
