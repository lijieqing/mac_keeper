package com.fengmi.mac_keeper.response;

import com.fengmi.mac_keeper.bean.MacData;
import com.fengmi.mac_keeper.enums.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

public class MacDataResponse {
    private String status;
    private List<MacData> data;
    private String desc;

    public MacDataResponse(String status, String desc) {
        this.status = status;
        this.desc = desc;
        data = new ArrayList<>();
    }

    public MacDataResponse() {
        this(ResponseStatus.Init.status, "null");
    }

    public List<MacData> getData() {
        return data;
    }

    public void addMacData(MacData macData) {
        data.add(macData);
    }

    public void addAllMacData(List<MacData> macData) {
        data.addAll(macData);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
