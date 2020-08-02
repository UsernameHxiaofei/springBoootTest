package cn.gtja.service.impl;

import cn.gtja.mapper.UserMapper;
import cn.gtja.model.PageBean;
import cn.gtja.model.User;
import cn.gtja.service.UserService;
import cn.gtja.utils.MD5;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean<User> queryUserBypage(Integer page, Integer pageSize) {
        //开始分页
        PageHelper.startPage(page,pageSize);
        // 查询结果
       List<User> list = this.userMapper.queryUserBypage();
       // 创建分页信息对象
       PageInfo<User> userPageInfo = new PageInfo<>(list);
       // 创建分页结果对象
       PageBean<User> pageBean = new PageBean<>();
       //  分装数据
       pageBean.setData(userPageInfo.getList());
       int total = (int)userPageInfo.getTotal();
       pageBean.setTotalNum(total);
       pageBean.setPage(page);
       pageBean.setPageSize(pageSize);
       return pageBean;
    }

    @Override
    public Boolean addUser(User user) throws Exception {
        // 组织user是实体
        String salt = MD5.generateSalt();
        user.setSolt(salt);
        String psd = MD5.md5(user.getPassword(), salt);
        user.setPassword(psd);
        Date date = new Date();
        user.setCreated(date);
        user.setUpdated(user.getCreated());
        // 插入数据库
        return null;
    }

}
