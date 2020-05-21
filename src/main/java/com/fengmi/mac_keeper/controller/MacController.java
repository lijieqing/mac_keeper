package com.fengmi.mac_keeper.controller;

import com.fengmi.mac_keeper.bean.MacData;
import com.fengmi.mac_keeper.service.MacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MacController {
    @Autowired
    private MacService macService;

    @RequestMapping(value = "/insertMacData", method = RequestMethod.POST)
    @ResponseBody
    public MacData insertMacData(MacData data) {
        System.out.println(data);
        String[] macStart = data.getMacStart().split(" ");
        String[] macEnd = data.getMacEnd().split(" ");
        if (macEnd.length != 2 && macStart.length != 2) {
            System.out.println("mac 参数不合法");
            return null;
        }
        int start = Integer.parseInt(macStart[1], 16);
        int end = Integer.parseInt(macEnd[1], 16);
        int size = end - start + 1;
        if (size == data.getMacLength()) {
            data.setMacCurrent(data.getMacStart());
            return macService.insertMacData(data);
        }
        System.out.println("Mac 起止段与事件数量不符");
        return null;
    }

    @RequestMapping(value = "/findAllMacData")
    @ResponseBody
    public List<MacData> findAllMacData(int macType) {
        return macService.findAllMacData(macType);
    }
}
