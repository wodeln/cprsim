package com.bolean.service;

import com.bolean.entity.Role;
import com.bolean.entity.RoleFolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public interface RoleService extends BaseService<Role> {
    List<Role> selectByInfo(Map<String, Object> map);

    List<Role> selectByInfo(Role role);

    @Transactional
    int insertRoleAndRights(Role role,List<RoleFolder> roleFolders);

    @Transactional
    int updateRoleAndRights(Role role,List<RoleFolder> roleFolders);
}
