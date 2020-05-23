package com.fengmi.mac_keeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<Map<String,String>> tempMap = null;
        String logic = "R|-|B|>|3;B|-|G|<|5";
        String[] logics = logic.split(";");
        for (String l : logics) {
            if (!l.matches("^[RGBWLDC]\\|-\\|[RGBWLDC]\\|[><]\\|[0-9]{1,2}")){
                System.out.println("异常解析，直接退出");
                return;
            }
        }
        for (String l : logics) {
            if (tempMap==null){
                tempMap = new ArrayList<>();
            }
            String[] datas = l.split("\\|");
            String minuend = datas[0];
            String minus = datas[2];
            String standard = datas[4];
            String lg = datas[3];
            Map<String,String> map = new HashMap<>();
            map.put("minuend","todo 通过关键字获取指令");
            map.put("minus","todo 通过关键字获取指令");
            map.put("standard",standard);
            map.put("logic",lg);
            tempMap.add(map);
        }

        System.out.println("解析 OK");
    }
}
