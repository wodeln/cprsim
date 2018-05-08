package com.bolean.controller;

import com.bolean.entity.Event;
import com.bolean.entity.Score;
import com.bolean.service.EventService;
import com.bolean.service.ScoreService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController extends BaseController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private EventService eventService;


    @ResponseBody
    @RequestMapping("submit_score.html")
    public boolean submitScore(String jsonStr){

        //JSON字符串转换为对象
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        Score score = (Score)JSONObject.toBean(jsonObject, Score.class);

        int res = 0;
        if(score.getUserIds().length()>1){
            String[] userIdArr = score.getUserIds().split(",");
            for (String s : userIdArr) {
                score.setUserId((long)Integer.parseInt(s));
                res = scoreService.insertSelective(score);
            }
        }else {
            score.setUserId((long)Integer.parseInt(score.getUserIds()));
            res = scoreService.insertSelective(score);
        }

        if(res>0) return true;
        else return false;
    }

    @ResponseBody
    @RequestMapping("submit_event.html")
    public boolean submitEvent(String jsonStr){
        int res = 0;
        JSONArray array = JSONArray.fromObject(jsonStr);
        List<Event> list=(List<Event>)JSONArray.toList(array,new Event(),new JsonConfig());
        res = eventService.insertList(list);
        if(res>0) return true;
        else return false;
    }
}
