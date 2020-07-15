package team.hulu.cms.service;

import org.springframework.web.multipart.MultipartFile;
import team.hulu.cms.pojo.ImageDO;

/**
 * @author: yurizhang
 * @date: 2020/7/15 10:36 下午
 */
public interface ImageService {
    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    boolean upload(MultipartFile file);

    /**
     * 上传图片
     *
     * @param imageDO
     * @return
     */
    boolean upload(ImageDO imageDO);
}
