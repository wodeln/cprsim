package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Args;
import com.bolean.entity.ArgsType;
import com.bolean.service.ArgsService;
import com.bolean.service.ArgsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/args")
public class ArgsController extends BaseController {

    @Autowired
    private ArgsTypeService argsTypeService;

    @Autowired
    private ArgsService argsService;

    @RequestMapping("/index.html")
    public String index(Model model){
        List<ArgsType> argsTypes = argsTypeService.selectAll();
        for (ArgsType argsType : argsTypes) {
            List<Args> args = argsService.selectByArgsTypeId(argsType.getArgsTypeId()+"");
            argsType.setArgs(args);
        }
        model.addAttribute("args",argsTypes);
        return "/args/index.html";
    }

    @RequestMapping("/add_type.html")
    public String addTypeUI(){
        return "/args/add_type.html";
    }

    @RequestMapping("/add.html")
    public String addUI(Model model){
        List<ArgsType> argsTypes = argsTypeService.selectAll();
        model.addAttribute("args",argsTypes);
        return "/args/add.html";
    }

    @ResponseBody
    @RequestMapping("/add_type")
    public RSTFulBody addType(ArgsType argsType){
        int res = argsTypeService.insertSelective(argsType);
        RSTFulBody rstFulBody = new RSTFulBody();
        if (res > 0) {
            rstFulBody.success("添加成功！");
            updateVersion();
        }
        else rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @ResponseBody
    @RequestMapping("/add")
    public RSTFulBody add(Args args){
        int res = argsService.insertSelective(args);
        RSTFulBody rstFulBody = new RSTFulBody();
        if (res > 0) {
            rstFulBody.success("添加成功！");
            updateVersion();
        }
        else rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @RequestMapping("/edit.html")
    public String editUI(Model model,String argsId){
        Args Args = argsService.selectByPrimaryKey((long) Integer.parseInt(argsId));
        List<ArgsType> argsTypes = argsTypeService.selectAll();
        model.addAttribute("args",argsTypes);
        model.addAttribute("obj", Args);
        return "/args/edit.html";
    }

    @ResponseBody
    @RequestMapping("/edit")
    public RSTFulBody edit(Args args){
        int res = argsService.updateByPrimaryKeySelective(args);
        RSTFulBody rstFulBody = new RSTFulBody();
        if (res > 0) {
            rstFulBody.success("编辑成功！");
            updateVersion();
        }
        else rstFulBody.fail("编辑失败！");
        return rstFulBody;
    }

    @RequestMapping("del.html")
    public String del(String argsId) {
        int res = argsService.deleteByPrimaryKey((long) Integer.parseInt(argsId));
        if(res>0) updateVersion();
        return "redirect:/args/index.html";
    }

    @RequestMapping("/edit_type.html")
    public String editTypeUI(Model model,String argsTypeId){
        ArgsType argsType = argsTypeService.selectByPrimaryKey((long) Integer.parseInt(argsTypeId));
        model.addAttribute("obj", argsType);
        return "/args/edit_type.html";
    }

    @ResponseBody
    @RequestMapping("/edit_type")
    public RSTFulBody editType(ArgsType argsType){
        int res = argsTypeService.updateByPrimaryKeySelective(argsType);
        RSTFulBody rstFulBody = new RSTFulBody();
        if (res > 0) {
            rstFulBody.success("编辑成功！");
            updateVersion();
        }
        else rstFulBody.fail("编辑失败！");
        return rstFulBody;
    }

    @RequestMapping("del_type.html")
    public String delType(String argsTypeId) {
        int res = argsTypeService.deleteByPrimaryKey((long) Integer.parseInt(argsTypeId));
        if(res>0) updateVersion();
        return "redirect:/args/index.html";
    }

    private boolean updateVersion(){
        int res = argsService.updateVersion();
        if(res>0) return true;
        else return false;
    }
}
