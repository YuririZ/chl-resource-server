package team.hulu.cms.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author: yurizhang
 * @date: 2020/6/16 10:40 下午
 */
@Log4j2
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 保存String类型的kv键值对
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setStringValue(String key, String value){
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)){
            return false;
        }
        try {
            stringRedisTemplate.opsForValue().set(key, value);
        } catch (Exception e){
            log.error("RedisUtils setStringValue error, key = {}, value = {}", key, value, e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 保存String类型的kv键值对
     *
     * @param key
     * @param value
     * @param expirationTime 缓存过期时间
     * @param timeUnit 时间单位
     * @return
     */
    public boolean setStringValue(String key, String value, long expirationTime , TimeUnit timeUnit){
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)){
            return false;
        }
        try {
            stringRedisTemplate.opsForValue().set(key, value, expirationTime, timeUnit);
        } catch (Exception e){
            log.error("RedisUtils setStringValue error, key = {}, value = {}", key, value, e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 根据key值获取String类型的value
     *
     * @param key
     * @return
     */
    public String getStringValue(String key){
        if (StringUtils.isEmpty(key)){
            return null;
        }
        try {
            return stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e){
            log.error("RedisUtils getStringValue error, key = {}. ", key, e.getMessage());
        }
        return null;
    }

    /**
     * 保存任意类型的kv键值对
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setValue(String key, Object value){
        if (StringUtils.isEmpty(key) || value == null){
            return false;
        }
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e){
            log.error("RedisUtils setValue error, key = {}, value = {}", key, value, e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 保存任意类型的kv键值对
     *
     * @param key
     * @param value
     * @param expirationTime 缓存过期时间
     * @param timeUnit 时间单位
     * @return
     */
    public boolean setValue(String key, Object value, long expirationTime , TimeUnit timeUnit){
        if (StringUtils.isEmpty(key) || value == null){
            return false;
        }
        try {
            redisTemplate.opsForValue().set(key, value, expirationTime, timeUnit);
        } catch (Exception e){
            log.error("RedisUtils setValue error, key = {}, value = {}", key, value, e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 根据key值获取任意类型的value
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getValue(String key, Class<T> clazz){
        if (StringUtils.isEmpty(key) || clazz == null){
            return null;
        }
        try {
            Object value = stringRedisTemplate.opsForValue().get(key);
            if (value == null){
                return null;
            }
            return JsonUtils.toBean(value.toString(), clazz);
        } catch (Exception e){
            log.error("RedisUtils getValue error, key = {}. ", key, e.getMessage());
        }
        return null;
    }

    /**
     * key值自增
     *
     * @param key
     * @return
     */
    public Long increment(String key){
        if (StringUtils.isEmpty(key)){
            return null;
        }
        try {
            return redisTemplate.opsForValue().increment(key);
        }catch (Exception e){
            log.error("RedisUtils increment error, key = {}. ", key, e.getMessage());
        }
        return null;
    }

    /**
     * key值自增
     *
     * @param key
     * @param step
     * @return
     */
    public Long increment(String key, Integer step){
        if (StringUtils.isEmpty(key) || step == null){
            return null;
        }
        try {
            return redisTemplate.opsForValue().increment(key, step);
        }catch (Exception e){
            log.error("RedisUtils increment error, key = {}. ", key, e.getMessage());
        }
        return null;
    }
}
