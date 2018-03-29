package com.bolean.service.iml;

import com.bolean.dao.RoleFolderMapper;
import com.bolean.entity.RoleFolder;
import com.bolean.service.RoleFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service("RoleFolderService")
public class RoleFolderServiceImpl implements RoleFolderService {
    @Autowired
    private RoleFolderMapper roleFolderMapper;

    @Override
    public List<RoleFolder> selectByInfo(Map<String, Object> map) {
        return roleFolderMapper.selectByInfo(map);
    }

    @Override
    public List<RoleFolder> selectByInfo(RoleFolder roleFolder) {
        return roleFolderMapper.selectByInfo(roleFolder);
    }

    @Override
    public int deleteByRoleId(Long roleId) {
        return roleFolderMapper.deleteByRoleId(roleId);
    }

    @Override
    public List<RoleFolder> selectAll() {
        return roleFolderMapper.selectAll();
    }

    @Override
    public List<RoleFolder> select(RoleFolder roleFolder) {
        return roleFolderMapper.select(roleFolder);
    }

    @Override
    public RoleFolder selectByPrimaryKey(Long id) {
        return roleFolderMapper.selectByPrimaryKey(id);
    }

    @Override
    public RoleFolder selectOne(RoleFolder roleFolder) {
        return roleFolderMapper.selectOne(roleFolder);
    }

    @Override
    public int insert(RoleFolder roleFolder) {
        return roleFolderMapper.insert(roleFolder);
    }

    @Override
    public int insertSelective(RoleFolder roleFolder) {
        return 0;
    }

    @Override
    public int insertList(List<RoleFolder> roleFolders) {
        return roleFolderMapper.insertList(roleFolders);
    }

    @Override
    public int updateByPrimaryKey(RoleFolder roleFolder) {
        return roleFolderMapper.updateByPrimaryKey(roleFolder);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleFolder roleFolder) {
        return 0;
    }

    @Override
    public int selectCount(RoleFolder roleFolder) {
        return roleFolderMapper.selectCount(roleFolder);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

}
