package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Exam;
import com.bolean.entity.Train;
import com.bolean.service.ExamService;
import com.bolean.service.TrainService;
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

@Controller
@RequestMapping("/train")
public class TrainController extends BaseController{

    @Autowired
    private TrainService trainService;

    @Autowired
    private ExamService examService;

    @RequestMapping("/index.html")
    public String getAll(Model model){
        List<Exam> exams = examService.selectAll();
        model.addAttribute("exams",exams);
        return "/train/index.html";
    }

    @RequestMapping("/ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                            @RequestParam(required = false) String trainName,
                            @RequestParam(required = false) String trainStatus,
                            @RequestParam(required = false) String trainType,
                            @RequestParam(required = false) String examId
                            ){
        //组装搜索条件
        Map<String,Object> map=new HashMap<>();
        if(trainName!=null && trainName!="") map.put("trainName",trainName);
        if(trainStatus!=null && trainStatus!="") map.put("trainStatus",trainStatus);
        if(trainType!=null && trainType!="") map.put("trainType",trainType);
        if(examId!=null && examId!="") map.put("examId",examId);

        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Train> trains = trainService.selectByInfo(map);
        PageInfo<Train> pageInfo= new PageInfo<>(trains);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/train/ajax_index.html";
    }

    @RequestMapping("add.html")
    public String addUI(Model model){
        List<Exam> exams = examService.selectAll();
        model.addAttribute("exams",exams);
        return "/train/add.html";
    }

    @ResponseBody
    @RequestMapping("add")
    public RSTFulBody add(Train train,
                          @RequestParam(required = true) String trainBeginTimes){
        Date trainBeginTime = DateHelper.getDate4StrDate(trainBeginTimes,"yyyy-MM-dd");
        train.setTrainBeginTime(trainBeginTime);
        int res=trainService.insertSelective(train);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @ResponseBody
    @RequestMapping("changeStatus")
    public int changeStatus(Train train){
        int res = trainService.updateByPrimaryKeySelective(train);
        return res;
    }

    @RequestMapping("edit.html")
    public String editUI(Model model,String trainId){
        Train train = trainService.selectByPrimaryKey((long)Integer.parseInt(trainId));
        List<Exam> exams = examService.selectAll();
        model.addAttribute("exams",exams);
        model.addAttribute("obj",train);
        return "/train/edit.html";
    }

    @ResponseBody
    @RequestMapping("edit")
    public RSTFulBody edit(Train train,
                           @RequestParam(required = true) String trainBeginTimes){
        Date trainBeginTime = DateHelper.getDate4StrDate(trainBeginTimes,"yyyy-MM-dd");
        train.setTrainBeginTime(trainBeginTime);
        int res = trainService.updateByPrimaryKeySelective(train);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("del.html")
    public String delUser(String mId){
        int res = trainService.deleteByPrimaryKey((long)Integer.parseInt(mId));
        return "redirect:/train/index.html";
    }

    @ResponseBody
    @RequestMapping("batch_del")
    public RSTFulBody batchDel(@RequestParam(required = true) String ids){

        Map<String, Object> map = new HashMap<>();
        map.put("ids",ids);
        int res = trainService.batchDel(map);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success(res);
        else  rstFulBody.fail("删除失败！");
        return rstFulBody;
    }
}
