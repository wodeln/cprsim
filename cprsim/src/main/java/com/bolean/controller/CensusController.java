package com.bolean.controller;

import com.bolean.entity.EcChats;
import com.bolean.entity.Exam;
import com.bolean.entity.Score;
import com.bolean.entity.TrainSetting;
import com.bolean.service.ExamService;
import com.bolean.service.ScoreService;
import com.bolean.service.TrainService;
import com.bolean.service.TrainSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/census")
public class CensusController extends BaseController{

    @Autowired
    private ExamService examService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private TrainSettingService trainSettingService;

    private final Map<String,Object> namesMap = new HashMap<String,Object>(){{
                put("op_time", "操作超时错误");
                put("interrupt_time", "中断时间错误");
                put("ccf", "按压时间占比错误");
                put("pressure_pce", "按压百分比错误");
                put("breath_pce", "吹气百分比错误");
                put("p_rate_pce", "按压频率百分比错误");
    }};

    @RequestMapping("/index.html")
    public String getAll(Model model,String trainId){

        List<Exam> exams = examService.selectAll();
        model.addAttribute("exams",exams);
        model.addAttribute("trainId",trainId);
        return "/census/index.html";
    }

    @ResponseBody
    @RequestMapping("pass_error_percent")
    public Map<String,Object> passErrorPercent(String trainId){
        Map<String,Object> resMap = new HashMap<>();
        Map<String,Object> passMap = this.getPass(trainId);
        Map<String,Object> errorMap = this.getErrors(trainId);

        resMap.put("pass",passMap);
        resMap.put("error",errorMap);
        return resMap;
    }

    /**
     * ecChats 合格率饼图数据
     * @param trainId 练考计划ID
     * @return
     */
    private Map<String,Object> getPass(String trainId){
        //合格数量
        Score rightScore = new Score();
        rightScore.setProjectId((long)Integer.parseInt(trainId));
        rightScore.setOpSuccess(true);
        int rightCount = scoreService.selectCount(rightScore);

        //挂掉数量
        Score errorScore = new Score();
        errorScore.setProjectId((long)Integer.parseInt(trainId));
        errorScore.setOpSuccess(false);
        int errorCount = scoreService.selectCount(errorScore);

//        if(rightCount==0 && errorCount==0) return
        //ecChates series data 数据
        List<EcChats> passErrors = new ArrayList<>();

        //挂
        Map<String,Object> errorStyleMap = new HashMap<>();
        Map<String,Object> errorColorMap = new HashMap<>();
        EcChats errorItem = new EcChats();
        errorColorMap.put("color","#c23531");
        errorStyleMap.put("normal",errorColorMap);
        errorItem.setName("不达标");
        errorItem.setValue(errorCount);
        errorItem.setItemStyle(errorStyleMap);
        passErrors.add(errorItem);

        //合格
        Map<String,Object> rithtStyleMap = new HashMap<>();
        Map<String,Object> rightColorMap = new HashMap<>();
        EcChats rightItem = new EcChats();
        rightColorMap.put("color","#61a0a8");
        rithtStyleMap.put("normal",rightColorMap);
        rightItem.setName("达标");
        rightItem.setValue(rightCount);
        rightItem.setItemStyle(rithtStyleMap);
        passErrors.add(rightItem);

        //ecChates legend data 数据
        String[] names = {"不达标","达标"};

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("names",names);
        resMap.put("items",passErrors);
        return resMap;
    }

    /**
     * ecChats 错误人数饼图数据
     * @param trainId 练考计划ID
     * @return
     */
    private Map<String,Object> getErrors(String trainId){
        Map<String,Object> fildsInfo = scoreService.selectSetFilds(trainId);
        ArrayList names = new ArrayList();

        List<EcChats> ecChats = new ArrayList<>();

        if(fildsInfo.size()>0){
            for (String key : fildsInfo.keySet()) {
                names.add(namesMap.get(key));
                Map<String,Object> dataMap = new HashMap<>();
                dataMap.put("field",key);
                dataMap.put("value",fildsInfo.get(key));
                dataMap.put("projectId",trainId);

                EcChats ecChat = new EcChats();
                ecChat.setName(namesMap.get(key)+"");
                if(key == "op_time") ecChat.setValue(scoreService.selectCountGteVaule(dataMap));
                else ecChat.setValue(scoreService.selectCountGtVaule(dataMap));
                ecChats.add(ecChat);

            }
        }

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("names",names);
        resMap.put("items",ecChats);
        return resMap;
    }

    @ResponseBody
    @RequestMapping("students")
    public List<Map<String,Object>> getStudents(String trainId){
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> userScore = scoreService.selectStudentByTrainid(trainId);

        return userScore;
    }

    @RequestMapping("user_report")
    public String userReport(String sid,Model model){
        Score score = scoreService.selectByPrimaryKey((long)Integer.parseInt(sid));
        TrainSetting trainSetting = trainSettingService.selectByTrainId(score.getProjectId()+"");
        model.addAttribute("score",score);
        model.addAttribute("trainSetting",trainSetting);
        return "/user/report.html";
    }

    @RequestMapping("census_info")
    public String censusInfo(String sid,Model model){
        Score score = scoreService.selectByPrimaryKey((long)Integer.parseInt(sid));
        TrainSetting trainSetting = trainSettingService.selectByTrainId(score.getProjectId()+"");
        model.addAttribute("score",score);
        model.addAttribute("trainSetting",trainSetting);
        return "/census/census_info.html";
    }
}
