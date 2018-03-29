package com.bolean.controller;

import com.bolean.entity.Folder;
import com.bolean.entity.User;
import com.bolean.service.CommonService;
import com.bolean.service.FolderService;
import com.bolean.service.StudentService;
import com.bolean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by dell on 2017/11/21.
 */
@Controller
public class IndexController{

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FolderService folderService;

    @Autowired
    private CommonService commonService;

    @RequestMapping("/")
    public  String index(Model model){

        User u = new User();
        u.setUserName("admin");
        User user = userService.selectOne(u);

        //获取所有顶级菜单
        Map<String,Object> map = new HashMap<>();
        map.put("parentId","0");
        map.put("folderType",1);
//        map.put('status',);
//        List<Folder> folders=folderService.selectByParentId(0);
        List<Folder> folders = folderService.selectByInfo(map);
        /*for (Folder folder : folders) {
            
        }*/
        for (int i = 0; i < folders.size(); i++) {
            Folder folder = new Folder();
            folder.setParentId(folders.get(i).getFolderId());
            folder.setFolderType(1);
//            List<Folder> childFolders = folderService.selectByParentId(folders.get(i).getFolderId());
            List<Folder> childFolders = folderService.selectByInfo(folder);
            if(childFolders.size()>0) folders.get(i).setChildFolders(childFolders);
        }
        model.addAttribute("menus",folders);
        //        folderService.select();
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/checkUnique")
    public Boolean checkUnique(HttpServletRequest request){
        List<String> fieldList = new ArrayList();
        Enumeration e = request.getParameterNames();
        String table = "";
        while(e.hasMoreElements()) {
            String parametName = (String)e.nextElement();
            if (parametName.equals("table")) {
                table = request.getParameter("table");
            } else if (parametName.equals("id")) {
                fieldList.add(request.getParameter("id"));
            }else if (parametName.equals("date_column")) {
                fieldList.add(request.getParameter("date_column"));
            } else {
                fieldList.add(parametName + "=" + "'" + request.getParameter(parametName) + "'");
            }
        }
        fieldList.remove(0);
        Map<String, Object> map = new HashMap();
        map.put("table", table);
        map.put("fieldArray", fieldList);

        boolean result = commonService.checkUnique(map);
        return result;
    }

    /**
     * 获取用户列表
     * @param
     * @return
     */
   /* @ApiOperation(value="获取用户列表", notes="分页获取用户列表")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping("getAllUser")
    public void getAllUser(){
        PageHelper.startPage(1, 5);
        *//*List<User> users=userService.getAllUser();
//        PageInfo
        System.out.println("-----------"+users);*//*
    }*/

    @RequestMapping("beetl.html")
    public String beetlTest(Model model){
        model.addAttribute("name","hello,world");
        return "/beetl.html";
    }
}
