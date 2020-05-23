package com.fengmi.mac_keeper.service;

import com.fengmi.mac_keeper.bean.MacData;
import com.fengmi.mac_keeper.bean.MacDataDetail;

import java.util.List;

public interface MacService {
    MacData insertMacData(MacData data);

    List<MacData> findAllMacData(int type);

    List<MacData> findAvailableMacData(int type,int org);

    MacData updateMacData(MacData data);

    MacDataDetail insertMacDataDetail(MacDataDetail detail);

    List<MacDataDetail> findMacDataDetail(int dataID);
}
