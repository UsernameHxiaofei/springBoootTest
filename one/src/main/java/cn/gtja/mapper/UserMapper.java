package cn.gtja.mapper;

import cn.gtja.model.User;

import java.util.List;

public interface UserMapper {
    /**
     * 分页查询user
     * @return
     */
    List<User> queryUserBypage();

}
