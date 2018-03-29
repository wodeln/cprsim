package com.bolean.service.iml;

import com.bolean.dao.RoleFolderMapper;
import com.bolean.dao.RoleMapper;
import com.bolean.entity.Role;
import com.bolean.entity.RoleFolder;
import com.bolean.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleFolderMapper roleFolderMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> select(Role role) {
        return roleMapper.select(role);
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Role selectOne(Role role) {
        return roleMapper.selectOne(role);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int insertSelective(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public int insertList(List<Role> roles) {
        return roleMapper.insertList(roles);
    }

    @Override
    public int updateByPrimaryKey(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int updateByPrimaryKeySelective(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int selectCount(Role role) {
        return roleMapper.selectCount(role);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public List<Role> selectByInfo(Map<String, Object> map) {
        return roleMapper.selectByInfo(map);
    }

    @Override
    public List<Role> selectByInfo(Role role) {
        return roleMapper.selectByInfo(role);
    }

    @Override
    public int insertRoleAndRights(Role role, List<RoleFolder> roleFolders) {
        int res=0;
        int resRole=roleMapper.insertSelective(role);
        if(resRole != 0){
            for (RoleFolder roleFolder: roleFolders) {
                roleFolder.setRoleId(role.getRoleId());
            }
            res=roleFolderMapper.insertList(roleFolders);
        }

        return res;
    }

    @Override
    public int updateRoleAndRights(Role role, List<RoleFolder> roleFolders) {
        roleMapper.updateByPrimaryKeySelective(role);
        roleFolderMapper.deleteByRoleId(role.getRoleId());
        return roleFolderMapper.insertList(roleFolders);
    }
}
