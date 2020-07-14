package team.hulu.cms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yurizhang
 * @date: 2020/7/13 10:24 下午
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "hello cms";
    }
}
