package com.bolean.controller;

import com.bolean.entity.*;
import com.bolean.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class ApiController extends BaseController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private EventService eventService;

    @Autowired
    private ArgsScoreService argsScoreService;

    @Autowired
    private MouldService mouldService;

    @Autowired
    private ExamService examService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainStudentService trainStudentService;

    @Autowired
    private TrainSettingService trainSettingService;

    @Autowired
    private ArgsService argsService;

    @Autowired
    private ArgsTypeService argsTypeService;


    /**
     * 客观操作统计数据提交
     * @param score springBoot @RequestBody 自动将json字符串转换/注入Score对象
     * @return
     */
    @ResponseBody
    @RequestMapping("submit_scores")
    public boolean submitScore(@RequestBody Score score){

        //JSON字符串转换为对象

       /* JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        Score score = (Score)JSONObject.toBean(jsonObject, Score.class);*/

        int res = 0;
        if(score.getUserIds().length()>1){
            String[] userIdArr = score.getUserIds().split(",");
            for (String s : userIdArr) {
                score.setUserId((long)Integer.parseInt(s));
                if(score.getId()!=null) score.setId(score.getId()+1);
                res = scoreService.insertSelective(score);
            }
        }else {
            score.setUserId((long)Integer.parseInt(score.getUserIds()));
            res = scoreService.insertSelective(score);
        }

        if(res>0) return true;
        else return false;
    }

    /**
     * 操作事件提交
     * @param events JSON字符串转换/注入Event
     * @return
     */
    @ResponseBody
    @RequestMapping("submit_events")
    public boolean submitEvent(@RequestBody List<Event> events){
        int res = eventService.insertList(events);
        if(res>0) return true;
        else return false;
    }

    /**
     * 提交客观评分分数
     * @param argsScores JSON字符串转换/注入ArgsScore
     * @return
     */
    @ResponseBody
    @RequestMapping("submit_args_scores")
    public boolean submitArgsScore(@RequestBody List<ArgsScore> argsScores){
        for (ArgsScore argsScore : argsScores) {
            Args args = argsService.selectByPrimaryKey(argsScore.getArgsId());
            argsScore.setArgsName(args.getArgsName());
        }
        int res = argsScoreService.insertList(argsScores);
        if(res>0) return true;
        else return false;
    }

    /**
     * 模拟人信息表获取
     * @return
     */
    @ResponseBody
    @RequestMapping("moulds")
    public List<Mould> getMoulds(){
        List<Mould> moulds = mouldService.selectAll();
        return moulds;
    }

    /**
     * 练考计划项的获取
     * @return
     */
    @ResponseBody
    @RequestMapping("projects")
    public List<Exam> getProjects(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> mapConditionExam = new HashMap<>();
        mapConditionExam.put("examStatus",1);
        List<Exam> exams = examService.selectByInfo(mapConditionExam);
        for (Exam exam : exams) {
            Map<String,Object> mapConditionTrain = new HashMap<>();
            mapConditionTrain.put("trainStatus",1);
            mapConditionTrain.put("examId",exam.getExamId());
            List<Train> trains = trainService.selectByInfo(mapConditionTrain);
            if(trains!=null){
                exam.setTrains(trains);
            }else{
                exams.remove(exam);
            }
        }
       return exams;
    }

    /**
     * 练考计划项的学员列表获取
     * @param project_id 练考计划ID
     * @return
     */
    @ResponseBody
    @RequestMapping("students")
    public List<TrainStudent> getStudents(String project_id){
        List<TrainStudent> trainStudents = trainStudentService.selectByTrainId(project_id);
        return trainStudents;
    }

    /**
     * 练考计划项目的操作参数获取
     * @param project_id 练考计划ID
     * @return
     */
    @ResponseBody
    @RequestMapping("train_settings")
    public TrainSetting getTrainSetting(String project_id){
        Map<String,Object> map = new HashMap<>();
        String argsVersion = argsService.selectArgsVersion();
        TrainSetting trainSettings = trainSettingService.selectByTrainId(project_id);
        trainSettings.setArgsVersion(argsVersion);
        return trainSettings;
    }

    /**
     * 主观评分表项获取
     * @return
     */
    @ResponseBody
    @RequestMapping("args")
    public List<ArgsType> getArgs(){
        List<ArgsType> argsTypes = argsTypeService.selectAll();
        for (ArgsType argsType : argsTypes) {
            List<Args> args = argsService.selectByArgsTypeId(argsType.getArgsTypeId()+"");
            argsType.setArgs(args);
        }
        return argsTypes;
    }
}