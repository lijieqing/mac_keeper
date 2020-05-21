package com.fengmi.mac_keeper.service.impl;

import com.fengmi.mac_keeper.bean.MacData;
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
}
