package com.fengmi.mac_keeper.service;

import com.fengmi.mac_keeper.bean.MacData;

import java.util.List;

public interface MacService {
    MacData insertMacData(MacData data);
    List<MacData> findAllMacData(int type);
}
