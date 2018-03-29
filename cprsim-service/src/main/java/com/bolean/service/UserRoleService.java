package com.bolean.service;

import com.bolean.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface UserRoleService extends BaseService<UserRole> {
    List<UserRole> selectByInfo(Map<String, Object> map);

    List<UserRole> selectByInfo(UserRole userRole);
}
