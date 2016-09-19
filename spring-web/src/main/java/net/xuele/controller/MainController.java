package net.xuele.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yejunjie on 2016/8/30.
 */
@Controller
@RequestMapping(value = "main")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        System.out.print("ssss");
        return "index";


    }


    @RequestMapping(value = "getPage1",method = RequestMethod.GET)
    public String getPage1() {
        logger.info("get into page one");
        return "page1";
    }
}
