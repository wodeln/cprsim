package com.bolean.service.iml;

import com.bolean.dao.FolderMapper;
import com.bolean.entity.Folder;
import com.bolean.entity.RoleFolder;
import com.bolean.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("FolderService")
public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderMapper folderMapper;

    @Override
    public List<Folder> selectAll() {
        return folderMapper.selectAll();
    }

    @Override
    public List<Folder> select(Folder folder) {
        return folderMapper.select(folder);
    }

    @Override
    public Folder selectByPrimaryKey(Long id) {
        return folderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Folder selectOne(Folder folder) {
        return folderMapper.selectOne(folder);
    }

    @Override
    public int insert(Folder folder) {
        return folderMapper.insert(folder);
    }

    @Override
    public int insertSelective(Folder folder) {
        return folderMapper.insertSelective(folder);
    }

    @Override
    public int insertList(List<Folder> folders) {
        return folderMapper.insertList(folders);
    }

    @Override
    public int updateByPrimaryKey(Folder folder) {
        return folderMapper.updateByPrimaryKey(folder);
    }

    @Override
    public int updateByPrimaryKeySelective(Folder folder) {
        return folderMapper.updateByPrimaryKeySelective(folder);
    }

    @Override
    public int selectCount(Folder folder) {
        return folderMapper.selectCount(folder);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }


    @Override
    public List<Folder> selectByParentId(Long parentId) {
        return folderMapper.selectByParentId(parentId);
    }

    @Override
    public List<Folder> selectByInfo(Map<String, Object> map) {
        return folderMapper.selectByInfo(map);
    }

    @Override
    public List<Folder> selectByInfo(Folder folder) {
        return folderMapper.selectByInfo(folder);
    }

    @Override
    public List<Folder> selectByRoleFolders(Long parentId,List<RoleFolder> roleFolders) {
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",parentId);
        map.put("roleFolders",roleFolders);
        return folderMapper.selectByRoleFolders(map);
    }
}
