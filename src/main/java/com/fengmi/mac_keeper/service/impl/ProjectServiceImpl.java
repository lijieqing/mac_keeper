package com.fengmi.mac_keeper.service.impl;

import com.fengmi.mac_keeper.bean.Project;
import com.fengmi.mac_keeper.mapper.ProjectMapper;
import com.fengmi.mac_keeper.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectorMapper;

    @Override
    public List<Project> selectAllProject() {
        return projectorMapper.selectAllProject();
    }
}
