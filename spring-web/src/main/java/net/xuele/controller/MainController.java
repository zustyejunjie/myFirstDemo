package net.xuele.controller;

import net.xuele.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public String getPage1(ModelAndView modelAndView) {
        logger.info("get into page one");
        modelAndView.addObject("sss","ss");
        return "page1";
    }


    @RequestMapping(value = "getData",method = RequestMethod.GET)
    public Student getData(ModelAndView modelAndView) {

        Student student = new Student();

        student.setId("id1");
        student.setName("yjj");

        modelAndView.addObject("attr1","attr1");

        return student;

    }

}
