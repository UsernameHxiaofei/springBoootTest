package cn.gtja.service;

import cn.gtja.model.PageBean;
import cn.gtja.model.User;

public interface UserService {
    /**
     * 分页查询用户
     * @return
     */
    PageBean<User> queryUserBypage(Integer page, Integer pageSize);

    Boolean addUser(User user) throws Exception;
}
