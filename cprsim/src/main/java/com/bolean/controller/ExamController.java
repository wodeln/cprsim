package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Exam;
import com.bolean.entity.Student;
import com.bolean.service.ExamService;
import com.bolean.service.StudentService;
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
@RequestMapping("/exam")
public class ExamController extends BaseController{

    @Autowired
    private ExamService examService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/index.html")
    public String getAll(){

        return "/exam/index.html";
    }

    @RequestMapping("/ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                            @RequestParam(required = false) String examName,
                            @RequestParam(required = false) String examStatus,
                            @RequestParam(required = false) String examKind
                            ){
        //组装搜索条件
        Map<String,Object> map=new HashMap<>();
        if(examName!=null && examName!="") map.put("examName",examName);
        if(examStatus!=null && examStatus!="") map.put("examStatus",examStatus);
        if(examKind!=null && examKind!="") map.put("examKind",examKind);

        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Exam> exams = examService.selectByInfo(map);
        PageInfo<Exam> pageInfo= new PageInfo<>(exams);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/exam/ajax_index.html";
    }

    @RequestMapping("add.html")
    public String addUI(){
        return "/exam/add.html";
    }

    @ResponseBody
    @RequestMapping("add")
    public RSTFulBody add(Exam exam,
                          @RequestParam(required = false) String examTimes){
        Date examTime = DateHelper.getDate4StrDate(examTimes,"yyyy-MM-dd");
        exam.setExamTime(examTime);
        int res=examService.insertSelective(exam);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @ResponseBody
    @RequestMapping("changeStatus")
    public int changeStatus(Exam exam){
        int res = examService.updateByPrimaryKeySelective(exam);
        return res;
    }

    @RequestMapping("edit.html")
    public String editUI(Model model,String examId){
        Exam exam = examService.selectByPrimaryKey((long)Integer.parseInt(examId));
        model.addAttribute("obj",exam);
        return "/exam/edit.html";
    }

    @ResponseBody
    @RequestMapping("edit")
    public RSTFulBody edit(Exam exam,
                           @RequestParam(required = false) String examTimes){
        Date examTime = DateHelper.getDate4StrDate(examTimes,"yyyy-MM-dd");
        exam.setExamTime(examTime);
        int res = examService.updateByPrimaryKeySelective(exam);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("del.html")
    public String delUser(String examId){
        int res = examService.deleteByPrimaryKey((long)Integer.parseInt(examId));
        return "redirect:/exam/index.html";
    }

    @ResponseBody
    @RequestMapping("batch_del")
    public RSTFulBody batchDel(@RequestParam(required = true) String ids){

        Map<String, Object> map = new HashMap<>();
        map.put("ids",ids);
        int res = examService.batchDel(map);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success(res);
        else  rstFulBody.fail("删除失败！");
        return rstFulBody;
    }

    @RequestMapping("user_add.html")
    public String userAdd(Model model,String examId){
        model.addAttribute("examId",examId);
        return "/exam/user_list.html";
    }

    @RequestMapping("ajax_users")
    public String ajaxUsers(Model model,int pageNum, int pageSize,String examId){
        Map<String,Object> map = new HashMap<>();
        map.put("examId",(long)Integer.parseInt(examId));
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentService.selectByInfo(map);
        PageInfo<Student> pageInfo= new PageInfo<>(students);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/exam/ajax_users.html";
    }

    @RequestMapping("student_add.html")
    public String studentAdd(Model model,String examId){
        model.addAttribute("examId",examId);
        return "/exam/student_add.html";
    }

    @ResponseBody
    @RequestMapping("student_add")
    public RSTFulBody studentAdd(Student student){
        int res=studentService.insertSelective(student);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }
}
