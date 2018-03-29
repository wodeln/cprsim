package com.bolean.service.iml;

import com.bolean.dao.UserRoleMapper;
import com.bolean.entity.UserRole;
import com.bolean.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public List<UserRole> selectAll() {
        return userRoleMapper.selectAll();
    }

    @Override
    public List<UserRole> select(UserRole userRole) {
        return userRoleMapper.select(userRole);
    }

    @Override
    public UserRole selectByPrimaryKey(Long id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserRole selectOne(UserRole userRole) {
        return userRoleMapper.selectOne(userRole);
    }

    @Override
    public int insert(UserRole userRole) {
        return userRoleMapper.insert(userRole);
    }

    @Override
    public int insertSelective(UserRole userRole) {
        return 0;
    }

    @Override
    public int insertList(List<UserRole> userRoles) {
        return userRoleMapper.insertList(userRoles);
    }

    @Override
    public int updateByPrimaryKey(UserRole userRole) {
        return userRoleMapper.updateByPrimaryKey(userRole);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole userRole) {
        return 0;
    }

    @Override
    public int selectCount(UserRole userRole) {
        return userRoleMapper.selectCount(userRole);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public List<UserRole> selectByInfo(Map<String, Object> map) {
        return userRoleMapper.selectByInfo(map);
    }

    @Override
    public List<UserRole> selectByInfo(UserRole userRole) {
        return userRoleMapper.selectByInfo(userRole);
    }
}
