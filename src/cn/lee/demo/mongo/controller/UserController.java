package cn.lee.demo.mongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-11
 * Time: PM3:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Integer i = 0;

    @RequestMapping(value = "/test.frm", method = RequestMethod.GET)
    public void testThread(@RequestParam(value = "id", required = false) String id) {
        double sleepTime = Math.random() * 10;
        System.out.println(id + "==sleep==" + sleepTime + "====i===" + i);
        try {
            TimeUnit.SECONDS.sleep(Math.round(sleepTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        System.out.println(id + "====" + sleepTime + "====i===" + i);
    }
}
