package team.hulu.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import team.hulu.cms.service.ImageService;

/**
 * @author: yurizhang
 * @date: 2020/7/13 10:24 下午
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "hello cms";
    }

    @RequestMapping(value = "/upload/image")
    public String uploadImage(@RequestParam(value = "file", required = false) MultipartFile file){
        imageService.upload(file);
        return null;
    }
}
