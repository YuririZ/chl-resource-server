package team.hulu.cms.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author: yurizhang
 * @date: 2020/7/12 6:01 下午
 */
@Log4j2
@Component
public class MongoUtils {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存数据
     *
     * @param objectToSave
     * @param collectionName
     * @param <T>
     * @return
     */
    public <T> T save(T objectToSave, String collectionName) {
        if (objectToSave == null || StringUtils.isEmpty(collectionName)) {
            return null;
        }
        return mongoTemplate.save(objectToSave, collectionName);
    }

    /**
     * 根据条件获取一条数据
     *
     * @param key
     * @param value
     * @param clazz
     * @param collectionName
     * @param <T>
     * @return
     */
    public <T> T findOne(String key, Object value, Class<T> clazz, String collectionName) {
        if (StringUtils.isEmpty(key) || clazz == null || StringUtils.isEmpty(collectionName)) {
            return null;
        }
        Query query = Query.query(Criteria.where(key).is(value));
        return mongoTemplate.findOne(query, clazz, collectionName);
    }

    /**
     * 根据query获取一条数据
     *
     * @param query
     * @param clazz
     * @param collectionName
     * @param <T>
     * @return
     */
    public <T> T findOne(Query query, Class<T> clazz, String collectionName) {
        if (query == null || clazz == null || StringUtils.isEmpty(collectionName)) {
            return null;
        }
        return mongoTemplate.findOne(query, clazz, collectionName);
    }

    /**
     * 根据条件获取数据列表
     *
     * @param key
     * @param value
     * @param clazz
     * @param collectionName
     * @param <T>
     * @return
     */
    public <T> List<T> find(String key, Object value, Class clazz, String collectionName) {
        if (StringUtils.isEmpty(key) || clazz == null || StringUtils.isEmpty(collectionName)) {
            return null;
        }
        Query query = Query.query(Criteria.where(key).is(value));
        return mongoTemplate.find(query, clazz, collectionName);
    }

    /**
     * 根据query获取数据列表
     *
     * @param query
     * @param clazz
     * @param collectionName
     * @param <T>
     * @return
     */
    public <T> List<T> find(Query query, Class clazz, String collectionName) {
        if (query == null || clazz == null || StringUtils.isEmpty(collectionName)) {
            return null;
        }
        return mongoTemplate.find(query, clazz, collectionName);
    }
}
