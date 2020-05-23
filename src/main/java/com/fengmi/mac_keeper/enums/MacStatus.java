package com.fengmi.mac_keeper.enums;

public enum MacStatus {
    NotRelease(0),PartialRelease(1),Released(2);
    public final int value;
    MacStatus(int value) {
        this.value = value;
    }
}
