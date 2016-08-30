package net.xuele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yejunjie on 2016/8/30.
 */
@Controller
public class MainController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
