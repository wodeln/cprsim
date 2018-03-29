package com.bolean.service;

import com.bolean.entity.RoleFolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RoleFolderService extends BaseService<RoleFolder> {
    List<RoleFolder> selectByInfo(Map<String,Object> map);

    List<RoleFolder> selectByInfo(RoleFolder roleFolder);

    int deleteByRoleId(Long roleId);
}
