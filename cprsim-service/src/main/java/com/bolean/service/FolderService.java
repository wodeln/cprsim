package com.bolean.service;

import com.bolean.entity.Folder;
import com.bolean.entity.RoleFolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface FolderService extends BaseService<Folder> {
    List<Folder> selectByParentId(Long parentId);

    List<Folder> selectByInfo(Map<String,Object> map);

    List<Folder> selectByInfo(Folder folder);

    List<Folder> selectByRoleFolders(Long parentId,List<RoleFolder> roleFolders);
}
