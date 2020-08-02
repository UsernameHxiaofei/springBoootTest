package cn.gtja.controller;

import cn.gtja.model.PageBean;
import cn.gtja.model.Response;
import cn.gtja.model.User;
import cn.gtja.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

        private Logger logger = LoggerFactory.getLogger(UserController.class);

        @Autowired
        private UserService userService;

        @GetMapping("/queryUserBypage")
        public PageBean<User> queryUserBypage (
                @RequestParam("page") Integer page,
                @RequestParam("pageSize") Integer pageSize
        ) {
            PageBean<User> pageBean =  this.userService.queryUserBypage(page,pageSize);
            if (null != pageBean) {
                return pageBean;
            }
            return null;
        }

        @PostMapping("/addUser")
        public Response addUser (@RequestBody User user) {
            Boolean flag =  this.userService.addUser(user);
            if (flag) {
              return   new Response(flag,"", null);
            } else {
              return   new Response(flag,"添加用户失败", null);
            }

        }



}
