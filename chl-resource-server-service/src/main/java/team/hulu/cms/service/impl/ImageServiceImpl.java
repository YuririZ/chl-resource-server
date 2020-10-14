package team.hulu.cms.service.impl;

import lombok.extern.log4j.Log4j2;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.hulu.cms.pojo.ImageDO;
import team.hulu.cms.service.ImageService;
import team.hulu.cms.util.MongoUtils;

import java.io.IOException;
import java.time.LocalDateTime;

import static team.hulu.cms.constant.MongoConstant.IMAGE_COLLECTION_NAME;

/**
 * @author: yurizhang
 * @date: 2020/7/15 10:37 下午
 */
@Log4j2
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private MongoUtils mongoUtils;
    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @Override
    public boolean upload(MultipartFile file) {
        if (file == null){
            return false;
        }
        ImageDO imageDO = new ImageDO();
        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.split("\\.")[1];
        try {
            imageDO.setName(fileName).setFileExtension(fileExtension).setContent(new Binary(file.getBytes())).setCreateTime(LocalDateTime.now());
            upload(imageDO);
        } catch (IOException e) {
            log.error("ImageServiceImpl upload setContent error");
            return false;
        }
        return false;
    }

    /**
     * 上传图片
     *
     * @param imageDO
     * @return
     */
    @Override
    public boolean upload(ImageDO imageDO) {
        if (imageDO == null){
            return false;
        }
        try {
            mongoUtils.save(imageDO, IMAGE_COLLECTION_NAME);
        } catch (Exception e) {
            log.error("ImageServiceImpl upload mongo save error");
            return false;
        }
        return true;
    }
}
