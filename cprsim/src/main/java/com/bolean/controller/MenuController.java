package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Folder;
import com.bolean.entity.RoleFolder;
import com.bolean.entity.User;
import com.bolean.service.FolderService;
import com.bolean.service.RoleFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{
    @Autowired
    private FolderService folderService;

    @Autowired
    private RoleFolderService roleFolderService;

    @RequestMapping("/index.html")
    public String index(Model model){
        //获取所有顶级菜单
        List<Folder> folders=folderService.selectByParentId((long) 0);

        for (int i = 0; i < folders.size(); i++) {
            List<Folder> childFolders = folderService.selectByParentId(folders.get(i).getFolderId());
            if(childFolders.size()>0) folders.get(i).setChildFolders(childFolders);
        }
        model.addAttribute("menus",folders);
        return "/menu/index.html";
    }

    @RequestMapping("add_menu.html")
    public String addUI(Model model){
        List<Folder> folders=folderService.selectByParentId((long)0);
        model.addAttribute("top_menus",folders);
        return "/menu/add_menu.html";
    }

    @ResponseBody
    @RequestMapping("add_menu")
    public RSTFulBody addMenu(Folder folder){
        User sessionUser = getSessionUser();
        folder.setCreateId(sessionUser.getUserId());
        folder.setCreateName(sessionUser.getRealName());
        int res=folderService.insertSelective(folder);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) {
            //分配新加菜单权限给ADMIN ROLE
            RoleFolder roleFolder = new RoleFolder();
            roleFolder.setRoleId((long)1);
            roleFolder.setFolderId(folder.getFolderId());
            roleFolderService.insert(roleFolder);
            rstFulBody.success("添加成功！");
        }
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @RequestMapping("edit_menu.html")
    public String editUI(Model model,String folderId){

        Folder folder=folderService.selectByPrimaryKey((long)Integer.parseInt(folderId));
        List<Folder> folders=folderService.selectByParentId((long)0);
        model.addAttribute("top_menus",folders);
        model.addAttribute("menu",folder);
        return "/menu/edit_menu.html";
    }

    @ResponseBody
    @RequestMapping("eidt_menu")
    public RSTFulBody editMenu(Folder folder){
        User sessionUser = getSessionUser();
        folder.setUpdateName(sessionUser.getRealName());
        folder.setUpdateId(sessionUser.getUserId());
        folder.setUpdateTime(new Date());
        int res = folderService.updateByPrimaryKeySelective(folder);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("del_menu.html")
    public String delMenu(Folder folder){
        User sessionUser = getSessionUser();
        folder.setUpdateName(sessionUser.getRealName());
        folder.setUpdateId(sessionUser.getUserId());
        folder.setUpdateTime(new Date());
        folder.setStatus(0);

        int res = folderService.updateByPrimaryKeySelective(folder);
        return "redirect:/menu/index.html";
    }
}
