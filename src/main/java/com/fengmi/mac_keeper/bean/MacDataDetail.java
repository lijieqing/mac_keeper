package com.fengmi.mac_keeper.bean;

public class MacDataDetail {
    private int detailID;
    private int dataID;
    private String macStart;
    private String macEnd;
    private int macLen;
    private int factory;
    private String outputTime;

    public MacDataDetail() {
    }

    public MacDataDetail(int dataID, String macStart, String macEnd, int macLen, int factory) {
        this.dataID = dataID;
        this.macStart = macStart;
        this.macEnd = macEnd;
        this.macLen = macLen;
        this.factory = factory;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
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

    public int getMacLen() {
        return macLen;
    }

    public void setMacLen(int macLen) {
        this.macLen = macLen;
    }

    public int getFactory() {
        return factory;
    }

    public void setFactory(int factory) {
        this.factory = factory;
    }

    public String getOutputTime() {
        return outputTime;
    }

    public void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
    }

    @Override
    public String toString() {
        return "MacDataDetail{" +
                "detailID=" + detailID +
                ", dataID=" + dataID +
                ", macStart='" + macStart + '\'' +
                ", macEnd='" + macEnd + '\'' +
                ", macLen=" + macLen +
                ", factory=" + factory +
                ", outputTime='" + outputTime + '\'' +
                '}';
    }
}
