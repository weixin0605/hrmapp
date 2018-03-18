package com.sws.hrmapp.service;


import com.sws.hrmapp.mapper.UserMapper;
import com.sws.hrmapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
//@Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class UserService{

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public User login(String loginname, String password){
        return userMapper.selectByLOginnameAndPassword(loginname,password);
    }

    @Transactional(readOnly = true)
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

//    @Transactional(readOnly = true)
//    public List<User> findUser(User user, PageModel pageModel) {
//        Map<String,Object> params = new HashMap<String, Object>();
//        params.put("user",user);
//        int recordCount = userDao.count(params);
//        pageModel.setRecordCount(recordCount);
//        if(recordCount>0){
//            params.put("pageModel",pageModel);
//        }
//        List<User> users = userDao.selectByPage(params);
//        return users;
//    }

    public void removeUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void modifyUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    public List<User> searchAllUser() {
        return userMapper.selectAllUsers();
    }
}
