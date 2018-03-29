package com.bolean.dao;

import com.bolean.entity.Folder;
import com.bolean.entity.RoleFolder;
import mybatis.basemapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface FolderMapper extends BaseMapper<Folder> {
    List<Folder> selectByParentId(Long parentId);

    List<Folder> selectByRoleFolders(Map<String,Object> map);
}