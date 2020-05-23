package com.fengmi.mac_keeper.bean;

public class MacData {
    private int dataID = -1;
    private int macType;
    private String macStart;
    private String macEnd;
    private String macCurrent;
    private int recordOrganization;
    private int projectID;
    private int dataStatus;
    private String importDate;
    private int macLength;

    public MacData() {
    }

    public MacData(
            int macType, String macStart, String macEnd,
            int recordOrganization, int projectID, int dataStatus,
            int macLength
    ) {
        this.macType = macType;
        this.macStart = macStart;
        this.macEnd = macEnd;
        this.recordOrganization = recordOrganization;
        this.projectID = projectID;
        this.dataStatus = dataStatus;
        this.macLength = macLength;
    }

    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

    public int getMacType() {
        return macType;
    }

    public void setMacType(int macType) {
        this.macType = macType;
    }

    public String getMacStart() {
        return macStart;
    }

    public void setMacStart(String macStart) {
        this.macStart = macStart;
    }

    public String getMacEnd() {
        return macEnd;
    }

    public void setMacEnd(String macEnd) {
        this.macEnd = macEnd;
    }

    public String getMacCurrent() {
        return macCurrent;
    }

    public void setMacCurrent(String macCurrent) {
        this.macCurrent = macCurrent;
    }

    public int getRecordOrganization() {
        return recordOrganization;
    }

    public void setRecordOrganization(int recordOrganization) {
        this.recordOrganization = recordOrganization;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(int dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public int getMacLength() {
        return macLength;
    }

    public void setMacLength(int macLength) {
        this.macLength = macLength;
    }

    @Override
    public String toString() {
        return "MacData{" +
                "dataID=" + dataID +
                ", macType=" + macType +
                ", macStart='" + macStart + '\'' +
                ", macEnd='" + macEnd + '\'' +
                ", macCurrent='" + macCurrent + '\'' +
                ", recordOrganization=" + recordOrganization +
                ", projectID=" + projectID +
                ", dataStatus=" + dataStatus +
                ", importDate=" + importDate +
                ", macLength=" + macLength +
                '}';
    }

    public int getMacStartInt() {
        String[] macStart = getMacStart().split(" ");
        if (macStart.length != 2) {
            System.out.println(" mac 数据异常，请核对数据库数据:" + this);
            return -1;
        }
        return Integer.parseInt(macStart[1], 16);
    }

    public int getMacEndInt() {
        String[] macEnd = getMacEnd().split(" ");
        if (macEnd.length != 2) {
            System.out.println(" mac 数据异常，请核对数据库数据:" + this);
            return -1;
        }
        return Integer.parseInt(macEnd[1], 16);
    }

    public int getMacCurrentInt() {
        String[] macCur = getMacCurrent().split(" ");
        if (macCur.length != 2) {
            System.out.println(" mac 数据异常，请核对数据库数据:" + this);
            return -1;
        }
        return Integer.parseInt(macCur[1], 16);
    }

    public String getMacPrefix() {
        String[] macEnd = getMacEnd().split(" ");
        String[] macStart = getMacEnd().split(" ");
        if (macEnd.length != 2 || macStart.length != 2) {
            System.out.println(" mac 数据异常，请核对数据库数据:" + this);
            return null;
        }
        if (macEnd[0].equals(macStart[0])) {
            return macStart[0];
        } else {
            System.out.println(" mac 数据异常，请核对数据库数据:" + this);
            return null;
        }
    }
}
