package com.bolean.dao;

import com.bolean.entity.User;
import mybatis.basemapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    User selectByUserName(String userName);
}