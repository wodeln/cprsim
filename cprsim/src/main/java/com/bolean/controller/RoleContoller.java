package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.dao.RoleFolderMapper;
import com.bolean.entity.Folder;
import com.bolean.entity.Role;
import com.bolean.entity.RoleFolder;
import com.bolean.entity.User;
import com.bolean.service.FolderService;
import com.bolean.service.RoleFolderService;
import com.bolean.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Controller
@RequestMapping("/role")
public class RoleContoller extends BaseController{
    @Autowired
    private RoleService roleService;

    @Autowired
    private FolderService folderService;

    @Autowired
    private RoleFolderService roleFolderService;

    @RequestMapping("/index.html")
    public String index(Model model){
        return "/role/index.html";
    }

    @RequestMapping("/ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                            @RequestParam(required = false) String roleName
    ){
        //组装搜索条件
        Map<String,Object> map=new HashMap<>();
        map.put("status",2);
        if(roleName!=null) map.put("roleName",roleName);
        //分页查询角色
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = roleService.selectByInfo(map);
        PageInfo<Role> pageInfo= new PageInfo<>(roles);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/role/ajax_index.html";
    }

    @RequestMapping("add_role.html")
    public String addUI(Model model){
        List<Folder> folders = getFolders();
        model.addAttribute("menus",folders);
        return "/role/add_role.html";
    }

    @ResponseBody
    @RequestMapping("add_role")
    public RSTFulBody addRole(Role role, @RequestParam(value="rights[]") String[] rights){
        User sessionUser = getSessionUser();
        role.setCreateId(sessionUser.getUserId());
        role.setCreateName(sessionUser.getRealName());

        RSTFulBody rstFulBody=new RSTFulBody();
        List<RoleFolder> roleFolders = new ArrayList<>();

        for(int i=0;i<rights.length;i++){
            RoleFolder roleFolder = new RoleFolder();
            roleFolder.setFolderId((long)Integer.parseInt(rights[i]));
            roleFolders.add(roleFolder);
        }

        int res = roleService.insertRoleAndRights(role,roleFolders);
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");

        return rstFulBody;
    }

    @RequestMapping("edit_role.html")
    public String editUI(Model model,String roleId){
        Role role = roleService.selectByPrimaryKey((long)Integer.parseInt(roleId));

        Map<String,Object> map = new HashMap<>();
        map.put("roleId",role.getRoleId());
        List<RoleFolder> roleFolders=roleFolderService.selectByInfo(map);

        Map<String,Object> folderMap = new HashMap<>();
        folderMap.put("parentId",0);
        folderMap.put("roleFolders",roleFolders);
        List<Folder> folders=folderService.selectByRoleFolders((long)0,roleFolders);

        for (int i = 0; i < folders.size(); i++) {
            List<Folder> childFolders = folderService.selectByRoleFolders(folders.get(i).getFolderId(),roleFolders);
            if(childFolders.size()>0) folders.get(i).setChildFolders(childFolders);
            for(int j=0; j<childFolders.size(); j++){
                List<Folder> childFolders1 = folderService.selectByRoleFolders(childFolders.get(j).getFolderId(),roleFolders);
                if(childFolders1.size()>0) childFolders.get(j).setChildFolders(childFolders1);
            }
        }

        model.addAttribute("menus",folders);
        model.addAttribute("role",role);
        return "/role/edit_role.html";
    }

    @ResponseBody
    @RequestMapping("edit_role")
    public RSTFulBody editUser(Role role, @RequestParam(value="rights[]") String[] rights){
        User sessionUser = getSessionUser();
        role.setUpdateId(sessionUser.getUserId());
        role.setUpdateName(sessionUser.getRealName());
        role.setUpdateTime(new Date());

        RSTFulBody rstFulBody=new RSTFulBody();
        List<RoleFolder> roleFolders = new ArrayList<>();

        for(int i=0;i<rights.length;i++){
            RoleFolder roleFolder = new RoleFolder();
            roleFolder.setRoleId(role.getRoleId());
            roleFolder.setFolderId((long)Integer.parseInt(rights[i]));
            roleFolders.add(roleFolder);
        }
        int res = roleService.updateRoleAndRights(role,roleFolders);
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("del_role.html")
    public String delUser(Role role){
        User sessionUser = getSessionUser();
        role.setUpdateName(sessionUser.getRealName());
        role.setUpdateId(sessionUser.getUserId());
        role.setUpdateTime(new Date());
        role.setStatus(0);

        int res = roleService.updateByPrimaryKeySelective(role);
        return "redirect:/role/index.html";
    }

    private List<Folder> getFolders(){
        List<Folder> folders=folderService.selectByParentId((long)0);

        for (int i = 0; i < folders.size(); i++) {
            List<Folder> childFolders = folderService.selectByParentId(folders.get(i).getFolderId());
            if(childFolders.size()>0) folders.get(i).setChildFolders(childFolders);
            for(int j=0; j<childFolders.size(); j++){
                List<Folder> childFolders1 = folderService.selectByParentId(childFolders.get(j).getFolderId());
                if(childFolders1.size()>0) childFolders.get(j).setChildFolders(childFolders1);
            }
        }

        return folders;
    }
}
