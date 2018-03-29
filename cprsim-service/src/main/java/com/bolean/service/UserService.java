package com.bolean.service;


import com.bolean.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService extends BaseService<User>{
    List<User> selectByInfo(Map<String,Object> map);

    List<User> selectByInfo(User user);

    User selectByUserName(String userName);

    int insertSelective(User user);

    int batchDel(Map<String,Object> map);
}
