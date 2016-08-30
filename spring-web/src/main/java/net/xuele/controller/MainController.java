package net.xuele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yejunjie on 2016/8/30.
 */
@Controller
@RequestMapping(value = "main")
public class MainController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "getPage1",method = RequestMethod.GET)
    public String getPage1() {
        return "page1";
    }
}
