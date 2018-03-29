package com.bolean.dao;

import com.bolean.entity.RoleFolder;
import mybatis.basemapper.BaseMapper;

public interface RoleFolderMapper extends BaseMapper<RoleFolder> {
    int deleteByRoleId(Long roleId);
}