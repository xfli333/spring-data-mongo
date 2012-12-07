package cn.lee.demo.mongo.service.impl;

import cn.lee.demo.mongo.dao.MongoDao;
import cn.lee.demo.mongo.model.base.Model;
import cn.lee.demo.mongo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-7
 * Time: PM2:58
 */
@Service
public class BaseServiceImpl implements BaseService {

    protected MongoOperations mongoOperations;

    @Autowired
    private MongoDao mongoDao;

    @Override
    public Model save(Model model) {
        return this.mongoDao.save(model);
    }

    @Override
    public Model save(Model model, String collection) {
        return this.mongoDao.save(model, collection);
    }

    @Override
    public void saveAll(List<Model> modelList) {
        this.mongoDao.saveAll(modelList);
    }

    @Override
    public void delete(Model model) {
        this.mongoDao.delete(model);
    }

    @Override
    public void deleteAll(Class clazz) {
        this.mongoDao.deleteAll(clazz);
    }

    @Override
    public void deleteAll(List<Model> modelList) {
        this.mongoDao.deleteAll(modelList);
    }

    @Override
    public Model update(Model model) {
        return this.mongoDao.update(model);
    }

    @Override
    public void updateAll(List<Model> modelList) {
        this.mongoDao.updateAll(modelList);
    }

    @Override
    public Model loadById(Class clazz, String id) {
        return this.mongoDao.loadById(clazz, id);
    }

    @Override
    public List<Model> loadAll(Class clazz) {
        return this.mongoDao.loadAll(clazz);
    }

    @Override
    public List<Model> query(Class clazz, Map<String, Object> parameter) {
        return this.mongoDao.query(clazz, parameter);
    }

    @Override
    public List<Model> query(Class clazz, Map<String, Object> parameter, String collection) {
        return this.mongoDao.query(clazz, parameter, collection);
    }

    @Override
    public MongoOperations getMongoOperations() {
        return this.mongoDao.getMongoOperations();
    }
}
