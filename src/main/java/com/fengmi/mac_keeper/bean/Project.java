package com.fengmi.mac_keeper.bean;

public class Project {
    private int projectID;
    private int projectCode;
    private String projectDesc;

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", projectCode=" + projectCode +
                ", projectDesc='" + projectDesc + '\'' +
                '}';
    }
}
