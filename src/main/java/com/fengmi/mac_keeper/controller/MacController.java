package com.fengmi.mac_keeper.controller;

import com.fengmi.mac_keeper.bean.MacData;
import com.fengmi.mac_keeper.bean.MacDataDetail;
import com.fengmi.mac_keeper.enums.MacStatus;
import com.fengmi.mac_keeper.service.MacService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @RequestMapping(value = "/releaseMac", method = RequestMethod.POST)
    @ResponseBody
    public List<MacDataDetail> releaseMacData(int type, int size, int factory, int org) {
        List<MacDataDetail> macDataDetails = new ArrayList<>();

        List<MacData> availableDataList = macService.findAvailableMacData(type,org);
        for (MacData macData : availableDataList) {
            System.out.println(macData);
        }
        if (availableDataList.size() == 0) {
            System.out.println("无可用 Mac 地址，请立即申请备案!!  Mac type=" + type);
            return null;
        }
        MacData macdata = availableDataList.get(0);
        int cur = macdata.getMacCurrentInt();
        int end = macdata.getMacEndInt();
        int localAvaLen = end - cur + 1;
        String prefix = macdata.getMacPrefix();
        if (size < localAvaLen) {
            //当前数据余量可以满足切割
            int newCur = cur + size;
            int detailEnd = newCur - 1;
            MacDataDetail mdd = new MacDataDetail(
                    macdata.getDataID(),
                    prefix + " " + Integer.toHexString(cur).toUpperCase(),
                    prefix + " " + Integer.toHexString(detailEnd).toUpperCase(),
                    size,
                    factory
            );
            //insert detail data
            System.out.println(mdd);

            macdata.setDataStatus(MacStatus.PartialRelease.value);
            macdata.setMacCurrent(prefix + " " + Integer.toHexString(newCur).toUpperCase());

            //update mac data
            System.out.println(macdata);

            macDataDetails.add(mdd);
            return macDataDetails;

        } else if (size == localAvaLen) {
            //当余量刚刚好
            MacDataDetail mdd = new MacDataDetail(
                    macdata.getDataID(),
                    macdata.getMacCurrent(),
                    macdata.getMacEnd(),
                    size,
                    factory
            );
            //insert detail data
            System.out.println(mdd);

            macdata.setDataStatus(MacStatus.Released.value);
            macdata.setMacCurrent(macdata.getMacEnd());

            //update mac data
            System.out.println(macdata);

            macDataDetails.add(mdd);
            return macDataDetails;
        } else {
            if (availableDataList.size() == 1) {
                System.out.println("Mac 可用数量不足，请及时申请备案!  mac type = " + type);
                return null;
            }
            //当前数据不足以完成切割，寻找下一条数据
            int debtSize = size - localAvaLen;
            //定义接下来要处理的数据集合
            List<MacData> debtList = new ArrayList<>();
            debtList.add(macdata);
            for (int i = 1; i < availableDataList.size(); i++) {
                MacData temp = availableDataList.get(i);
                debtList.add(temp);

                int available = temp.getMacEndInt() - temp.getMacCurrentInt() + 1;
                debtSize = debtSize - available;
                if (debtSize < 0) {
                    //当前数据能够满足 Mac 切割，跳出循环
                    break;
                }
            }
            //判断是否能完成分配，如果可以完成，就生成 detail 对象，并更新数据库
            if (debtSize > 0) {
                System.out.println("库存 Mac 数量不足以完成分配，请及时申请备案");
            } else {
                int waitSize = size;
                MacData tempData;
                MacDataDetail mdd;
                for (int i = 0; i < debtList.size(); i++) {
                    tempData = debtList.get(i);

                    int avail = tempData.getMacEndInt() - tempData.getMacCurrentInt() + 1;
                    waitSize = waitSize - avail;
                    if (waitSize >= 0) {
                        mdd = new MacDataDetail(
                                tempData.getDataID(),
                                tempData.getMacCurrent(),
                                tempData.getMacEnd(),
                                avail,
                                factory);
                        macDataDetails.add(mdd);

                        tempData.setDataStatus(MacStatus.Released.value);
                        tempData.setMacCurrent(tempData.getMacEnd());
                    } else {
                        int usedSize = avail + waitSize;
                        int detailEnd = tempData.getMacCurrentInt() + usedSize - 1;
                        mdd = new MacDataDetail(
                                tempData.getDataID(),
                                tempData.getMacCurrent(),
                                tempData.getMacPrefix() + " " + Integer.toHexString(detailEnd).toUpperCase(),
                                usedSize, factory);
                        macDataDetails.add(mdd);

                        tempData.setDataStatus(MacStatus.PartialRelease.value);
                        tempData.setMacCurrent(tempData.getMacPrefix() + " " + Integer.toHexString(detailEnd + 1).toUpperCase());
                    }
                    //update MacData
                }

                for (MacDataDetail macDataDetail : macDataDetails) {
                    //insert MacDataDetail
                    System.out.println(macDataDetail);
                }
            }
            return macDataDetails;
        }
    }
}
