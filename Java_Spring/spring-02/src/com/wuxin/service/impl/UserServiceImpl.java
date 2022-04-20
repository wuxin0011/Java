package com.wuxin.service.impl;

import com.wuxin.dao.UserDao;
import com.wuxin.dao.impl.UserDaoImpl;
import com.wuxin.service.UserService;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:37
 * @Description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String username, String password) {
        UserDaoImpl userDao = new UserDaoImpl();
        return  userDao.login(username,password);
    }


}
