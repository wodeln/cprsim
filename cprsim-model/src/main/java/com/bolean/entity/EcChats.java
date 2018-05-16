package com.bolean.entity;

import java.util.Map;

public class EcChats {
    private String name;

    private int value;

    private Map<String,Object> itemStyle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Map<String, Object> getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(Map<String, Object> itemStyle) {
        this.itemStyle = itemStyle;
    }
}
