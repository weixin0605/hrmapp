package com.sws.hrmapp.service.impl;


import com.sws.hrmapp.dao.UserMapper;
import com.sws.hrmapp.entity.User;
import com.sws.hrmapp.service.HrmService;
import com.sws.hrmapp.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("hrmService")
@Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class HrmServiceImpl implements HrmService {

    @Autowired
    private UserMapper userDao;

    @Transactional(readOnly = true)
    public User login(String loginname, String password){
        return userDao.selectByLOginnameAndPassword(loginname,password);
    }

    @Transactional(readOnly = true)
    public User findUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
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
        userDao.deleteByPrimaryKey(id);
    }

    public void modifyUser(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    public void addUser(User user) {
        userDao.insertSelective(user);
    }
}
