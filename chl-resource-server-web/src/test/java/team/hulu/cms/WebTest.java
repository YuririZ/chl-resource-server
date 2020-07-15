package team.hulu.cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import team.hulu.cms.pojo.ImageDO;
import team.hulu.cms.util.MongoUtils;

/**
 * @author: yurizhang
 * @date: 2020/7/14 9:38 下午
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class WebTest {

    @Autowired
    private MongoUtils mongoUtils;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testMongo(){
//        ImageDO imageDO = new ImageDO();
//        imageDO.setName("test1");
//        mongoTemplate.insert(imageDO, "images");
        String key = "name";
        String value = "test1";
        Query query = Query.query(Criteria.where(key).is(value));
        ImageDO imageDO = mongoTemplate.findOne(query, ImageDO.class, "images");
        System.out.println(imageDO);
    }
}
