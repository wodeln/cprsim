package com.bolean.util;

import com.bolean.entity.EcChats;
import com.bolean.entity.Score;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUitl {

    /**
     * 按压深度PIE数据
     * @param score
     * @return
     */
    public Map<String,Object> getPressDeepPie(Score score){

        ArrayList names = new ArrayList();
        List<EcChats> ecChats = new ArrayList<>();

        if(score.getpRight()>0) {
            EcChats ecChat = new EcChats();
            ecChat.setName("充足");
            ecChat.setValue(score.getpRight());
            ecChats.add(ecChat);
            names.add("充足");
        }

        if(score.getbLower()>0) {
            EcChats ecChat = new EcChats();
            ecChat.setName("不足");
            ecChat.setValue(score.getbLower());
            ecChats.add(ecChat);
            names.add("不足");
        }

        if(score.getbOver()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("过大");
            ecChat.setValue(score.getbOver());
            ecChats.add(ecChat);
            names.add("过大");
        }
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("names",names);
        resMap.put("items",ecChats);
        return resMap;
    }

    /**
     * 按压位置PIE数据
     * @param score
     * @return
     */
    public Map<String,Object> getPressPositionPie(Score score){

        ArrayList names = new ArrayList();
        List<EcChats> ecChats = new ArrayList<>();

        if(score.getbSumNum() - score.getPosError()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("中心");
            ecChat.setValue(score.getbSumNum() - score.getPosError());
            ecChats.add(ecChat);
            names.add("中心");
        }

        if(score.getPosT()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("上部");
            ecChat.setValue(score.getPosT());
            ecChats.add(ecChat);
            names.add("上部");
        }

        if(score.getPosB()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("下部");
            ecChat.setValue(score.getPosB());
            ecChats.add(ecChat);
            names.add("下部");
        }

        if(score.getPosL()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("左部");
            ecChat.setValue(score.getPosL());
            ecChats.add(ecChat);
            names.add("左部");
        }

        if(score.getPosR()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("右部");
            ecChat.setValue(score.getPosR());
            ecChats.add(ecChat);
            names.add("右部");
        }

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("names",names);
        resMap.put("items",ecChats);
        return resMap;
    }

    /**
     * 按压PIE数据
     * @param score
     * @return
     */
    public Map<String,Object> getPressPie(Score score){

        ArrayList names = new ArrayList();
        List<EcChats> ecChats = new ArrayList<>();

        if(score.getbSumNum() - score.getReleaseError()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("释放正确");
            ecChat.setValue(score.getbSumNum() - score.getReleaseError());
            ecChats.add(ecChat);
            names.add("释放正确");
        }

        if(score.getReleaseError()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("释放不足");
            ecChat.setValue(score.getReleaseError());
            ecChats.add(ecChat);
            names.add("释放不足");
        }

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("names",names);
        resMap.put("items",ecChats);
        return resMap;
    }


    /**
     * 吹气正确PIE数据
     * @param score
     * @return
     */
    public Map<String,Object> getBreathPie(Score score){

        ArrayList names = new ArrayList();
        List<EcChats> ecChats = new ArrayList<>();

        if(score.getVentilaTimeRight()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("吹气适当");
            ecChat.setValue(score.getVentilaTimeRight());
            ecChats.add(ecChat);
            names.add("吹气适当");
        }

        if(score.getVentilaTimeShort()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("吹气不足");
            ecChat.setValue(score.getVentilaTimeShort());
            ecChats.add(ecChat);
            names.add("吹气不足");
        }

        if(score.getVentilaTimeLong()>0){
            EcChats ecChat = new EcChats();
            ecChat.setName("吹气过量");
            ecChat.setValue(score.getVentilaTimeLong());
            ecChats.add(ecChat);
            names.add("吹气过量");
        }

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("names",names);
        resMap.put("items",ecChats);
        return resMap;
    }

}
