package cn.gtja.controller;

import cn.gtja.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/queryUser")
    public User queryUser () {
        logger.info("请求到达controller");
        User user = new User();
        user.setAge(18);
        user.setName("zs");
        logger.info("请求返回的结果是[{}]",user);
        return user;
    }
}
