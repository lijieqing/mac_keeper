package com.fengmi.mac_keeper.service.impl;

import com.fengmi.mac_keeper.bean.MacData;
import com.fengmi.mac_keeper.bean.MacDataDetail;
import com.fengmi.mac_keeper.mapper.ETMacMapper;
import com.fengmi.mac_keeper.service.MacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MacServiceImpl implements MacService {
    @Autowired
    private ETMacMapper etMacMapper;

    @Override
    public MacData insertMacData(MacData data) {
        etMacMapper.insertMacData(data);
        return data;
    }

    @Override
    public List<MacData> findAllMacData(int type) {
        return etMacMapper.findAllMacData(type);
    }

    @Override
    public List<MacData> findAvailableMacData(int type,int org) {
        return etMacMapper.findAvailableMacData(type,org);
    }

    @Override
    public MacData updateMacData(MacData data) {
        return etMacMapper.updateMacData(data);
    }

    @Override
    public MacDataDetail insertMacDataDetail(MacDataDetail detail) {
        return etMacMapper.insertMacDataDetail(detail);
    }

    @Override
    public List<MacDataDetail> findMacDataDetail(int dataID) {
        return etMacMapper.findMacDataDetail(dataID);
    }
}
