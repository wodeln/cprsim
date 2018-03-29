package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Mould;
import com.bolean.entity.Student;
import com.bolean.service.MouldService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import utils.DateHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static utils.DateHelper.getCurrentYear;

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

    @RequestMapping("batch_add.html")
    public String batchAddStudentUI(){
        return "/mould/batch_add.html";
    }

    @ResponseBody
    @RequestMapping("import_excel")
    public Map<String,Object> importExcel(MultipartFile file) throws IOException {

        Map<String,Object> stateMap = upload(file);
        Map<String,Object> result = new HashMap<>();
        result.put("status",0);
        List<Mould> moulds = new ArrayList<>();
        if(file!=null){
            Workbook book = null;
            try {
                book = new XSSFWorkbook(new FileInputStream(ResourceUtils.getFile(stateMap.get("fileInfo")+"")));
//                book = new XSSFWorkbook(new FileInputStream(ResourceUtils.getFile("D:\\workspace\\analyse-parent\\analyse-student\\target\\classes\\upload\\20180202\\20180202150140247.xlsx")));
            } catch (Exception ex) {
                book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(stateMap.get("fileInfo")+"")));
//                book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("D:\\workspace\\analyse-parent\\analyse-student\\target\\classes\\upload\\20180202\\20180202150140247.xlsx")));
            }

            Sheet sheet = book.getSheetAt(0);

            List errorList = new ArrayList();
            String str = "";
            for(int i=2; i<sheet.getLastRowNum()+1; i++) {
                Mould mould = new Mould();
                Row row = sheet.getRow(i);

                if(row.getCell(0).getStringCellValue()==""){
                    str = "第"+i+"行"+"名称不能为空";
                    errorList.add(str);
                }else {
                    mould.setmName(row.getCell(0).getStringCellValue());
                }
                if(row.getCell(2).getStringCellValue()==""){
                    str = "第"+i+"行"+"型号不能为空";
                    errorList.add(str);
                }else {
                    mould.setmNo(row.getCell(2).getStringCellValue());
                }
                mould.setmVersion(row.getCell(1).getStringCellValue());
                mould.setmSerialNumber(row.getCell(3).getStringCellValue());
                mould.setmBuyTime(row.getCell(4).getDateCellValue());
                mould.setmRepairDays(row.getCell(5).getStringCellValue());
                mould.setmPlace(row.getCell(6).getStringCellValue());
                mould.setmUseTime(Integer.parseInt(row.getCell(7).getStringCellValue()));
                mould.setmRepairTel(row.getCell(8).getStringCellValue());
                moulds.add(mould);
            }

            if(errorList.size() == 0) {
                result.put("status",1);
                int res=mouldService.insertList(moulds);
                if(res ==0 )result.put("status",0);
            }else {
                result.put("status",2);
                result.put("errors",errorList);
            }

        }

        return result;
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
