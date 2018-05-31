package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Exam;
import com.bolean.entity.Score;
import com.bolean.entity.Student;
import com.bolean.service.ExamService;
import com.bolean.service.ScoreService;
import com.bolean.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamService examService;

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/index.html")
    public String getAll(Model model){
        List<Exam> exams = examService.selectAll();
        model.addAttribute("exams", exams);
        return "/student/index.html";
    }

    @RequestMapping("/ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                            @RequestParam(required = false) String userTrueName,
                            @RequestParam(required = false) String examId,
                            @RequestParam(required = false) String userSex
    ){
        //组装搜索条件
        Map<String,Object> map=new HashMap<>();
        if(userTrueName!=null && userTrueName!="") map.put("userTrueName",userTrueName);
        if(examId!=null && examId!="") map.put("examId",examId);
        if(userSex!=null && userSex!="") map.put("userSex",userSex);

        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentService.selectByInfo(map);
        for (Student student : students) {
            Exam exam = examService.selectByPrimaryKey(student.getExamId());
            student.setTrainCount(scoreService.selectTrainCountByUserid(student.getUserId()+""));
            student.setExamName(exam.getExamName());
        }
        PageInfo<Student> pageInfo= new PageInfo<>(students);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/student/ajax_index.html";
    }

    @ResponseBody
    @RequestMapping("edit")
    public RSTFulBody edit(Student student){
        int res = studentService.updateByPrimaryKeySelective(student);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("edit.html")
    public String editUI(Model model,String studentId){
        Student student = studentService.selectByPrimaryKey((long)Integer.parseInt(studentId));
        model.addAttribute("obj",student);
        return "/student/edit.html";
    }
}
