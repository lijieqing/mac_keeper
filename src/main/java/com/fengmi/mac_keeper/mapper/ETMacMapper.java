package com.fengmi.mac_keeper.mapper;

import com.fengmi.mac_keeper.bean.MacData;
import com.fengmi.mac_keeper.bean.MacDataDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ETMacMapper {
    int insertMacData(MacData data);

    List<MacData> findAllMacData(int type);

    List<MacData> findAvailableMacData(int type,int org);

    void updateMacData(MacData data);

    void insertMacDataDetail(MacDataDetail detail);

    List<MacDataDetail> findMacDataDetail(int dataID);
}
