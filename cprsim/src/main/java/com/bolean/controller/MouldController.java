package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Mould;
import com.bolean.service.MouldService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DateHelper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mould")
public class MouldController extends BaseController{

    @Autowired
    private MouldService mouldService;

    @RequestMapping("/index.html")
    public String getAll(){

        return "/mould/index.html";
    }

    @RequestMapping("/ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                            @RequestParam(required = false) String mouldNo,
                            @RequestParam(required = false) String mouldStatus
                            ){
        //组装搜索条件
        Map<String,Object> map=new HashMap<>();
        if(mouldNo!=null && mouldNo!="") map.put("mSerialNumber",mouldNo);
        if(mouldStatus!=null && mouldStatus!="") map.put("mStatus",mouldStatus);

        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Mould> moulds = mouldService.selectByInfo(map);
        PageInfo<Mould> pageInfo= new PageInfo<>(moulds);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/mould/ajax_index.html";
    }

    @RequestMapping("add.html")
    public String addUI(){
        return "/mould/add.html";
    }

    @ResponseBody
    @RequestMapping("add")
    public RSTFulBody add(Mould mould,
                          @RequestParam(required = true) String mBuyTimes){
        Date buyTime = DateHelper.getDate4StrDate(mBuyTimes,"yyyy-MM-dd");
        mould.setmBuyTime(buyTime);
        int res=mouldService.insertSelective(mould);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @ResponseBody
    @RequestMapping("changeStatus")
    public int changeStatus(Mould mould){
        int res = mouldService.updateByPrimaryKeySelective(mould);
        return res;
    }

    @RequestMapping("edit.html")
    public String editUI(Model model,String mId){
        Mould mould = mouldService.selectByPrimaryKey((long)Integer.parseInt(mId));
        model.addAttribute("obj",mould);
        return "/mould/edit.html";
    }

    @ResponseBody
    @RequestMapping("edit")
    public RSTFulBody edit(Mould mould,
                           @RequestParam(required = true) String mBuyTimes){
        Date buyTime = DateHelper.getDate4StrDate(mBuyTimes,"yyyy-MM-dd");
        mould.setmBuyTime(buyTime);
        int res = mouldService.updateByPrimaryKeySelective(mould);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("del.html")
    public String delUser(String mId){
        int res = mouldService.deleteByPrimaryKey((long)Integer.parseInt(mId));
        return "redirect:/mould/index.html";
    }

    @ResponseBody
    @RequestMapping("batch_del")
    public RSTFulBody batchDel(@RequestParam(required = true) String ids){

        Map<String, Object> map = new HashMap<>();
        map.put("ids",ids);
        int res = mouldService.batchDel(map);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success(res);
        else  rstFulBody.fail("删除失败！");
        return rstFulBody;
    }

    /*private String MD5(String pwd) {
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
    }*/
}
