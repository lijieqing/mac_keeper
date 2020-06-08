package com.fengmi.mac_keeper.enums;

public enum Factory {
    CVTE(0,"CVTE"), Wistron(1,"WISTRON");
    public final int value;
    public final String desc;

    Factory(int value,String desc) {
        this.value = value;
        this.desc = desc;
    }
}
