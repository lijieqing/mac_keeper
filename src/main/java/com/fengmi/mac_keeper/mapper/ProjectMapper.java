package com.fengmi.mac_keeper.mapper;

import com.fengmi.mac_keeper.bean.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<Project> selectAllProject();
}
