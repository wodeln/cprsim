package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Role;
import com.bolean.entity.User;
import com.bolean.entity.UserRole;
import com.bolean.service.RoleService;
import com.bolean.service.UserRoleService;
import com.bolean.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/index.html")
    public String getAllUser(Model model){

        //查询所有角色
        List<Role> roles = roleService.selectAll();

        model.addAttribute("roles",roles);
        return "/user/index.html";
    }

    @RequestMapping("/ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                            @RequestParam(required = false) String nut,
                            @RequestParam(required = false) String role
                            ){
//        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //组装搜索条件
        Map<String,Object> map=new HashMap<>();
        map.put("status",2);
        if(nut!=null && nut!="") map.put("nut",nut);
        if(role!=null && role!="") map.put("roleId",role);

        //分页查询用户
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.selectByInfo(map);
        PageInfo<User> pageInfo= new PageInfo<>(users);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/user/ajax_index.html";
    }

    @RequestMapping("add_user.html")
    public String addUI(Model model){
        List<Role> roles = roleService.selectAll();

        model.addAttribute("roles",roles);
        return "/user/add_user.html";
    }

    @ResponseBody
    @RequestMapping("add_user")
    public RSTFulBody addUser(User user){
        User sessionUser = getSessionUser();
        user.setCreateName(sessionUser.getRealName());
        user.setCreateId(sessionUser.getUserId());
        user.setPassword(MD5(user.getPassword()));
        int res=userService.insertSelective(user);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @RequestMapping("edit_user.html")
    public String editUI(Model model,String userId){
        User user = userService.selectByPrimaryKey((long)Integer.parseInt(userId));
        List<Role> roles = roleService.selectAll();

        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getUserId());

        model.addAttribute("roles",roles);
        model.addAttribute("iuser",user);
        return "/user/edit_user.html";
    }

    @ResponseBody
    @RequestMapping("edit_user")
    public RSTFulBody editUser(User user){
        User sessionUser = getSessionUser();
        user.setUpdateId(sessionUser.getUserId());
        user.setUpdateName(sessionUser.getRealName());
        user.setUpdateTime(new Date());
        if(user.getPassword()!="" && user.getPassword()!=null){
            user.setPassword(MD5(user.getPassword()));
        }
        int res = userService.updateByPrimaryKeySelective(user);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("del_user.html")
    public String delUser(User user){
        User sessionUser = getSessionUser();
        user.setUpdateName(sessionUser.getRealName());
        user.setUpdateId(sessionUser.getUserId());
        user.setUpdateTime(new Date());
        user.setStatus(0);

        int res = userService.updateByPrimaryKeySelective(user);
        return "redirect:/user/index.html";
    }

    @ResponseBody
    @RequestMapping("batch_del")
    public RSTFulBody batchDel(@RequestParam(required = true) String ids){
        User sessionUser = getSessionUser();
        Map<String, Object> map = new HashMap<>();
        map.put("ids",ids);
        map.put("updateName",sessionUser.getRealName());
        map.put("updateId",sessionUser.getUserId());
        map.put("updateTime",new Date());
        int res = userService.batchDel(map);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success(res);
        else  rstFulBody.fail("删除失败！");
        return rstFulBody;
    }

    private String MD5(String pwd) {
        //用于加密的字符
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = pwd.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {   //  i = 0
                byte byte0 = md[i];  //95
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5
                str[k++] = md5String[byte0 & 0xf];   //   F
            }

            //返回经过加密后的字符串
            return new String(str);

        } catch (Exception e) {
            return null;
        }
    }
}
