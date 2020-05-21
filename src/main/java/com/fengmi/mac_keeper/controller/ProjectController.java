package com.fengmi.mac_keeper.controller;

import com.fengmi.mac_keeper.bean.Project;
import com.fengmi.mac_keeper.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/allProject")
    @ResponseBody
    public List<Project> getAllProject() {
        List<Project> list = projectService.selectAllProject();
        for (Project project : list) {
            System.out.println(project);
        }
        return list;
    }
}
