package com.fengmi.mac_keeper.mapper;

import com.fengmi.mac_keeper.bean.MacData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ETMacMapper {
    int insertMacData(MacData data);
    List<MacData> findAllMacData(int type);
}
