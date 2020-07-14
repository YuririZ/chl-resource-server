package team.hulu.cms.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: yurizhang
 * @date: 2020/7/12 6:01 下午
 */
@Log4j2
@Component
public class MongoUtils {
    @Autowired
    private MongoTemplate mongoTemplate;
}
