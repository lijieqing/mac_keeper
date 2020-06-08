package com.fengmi.mac_keeper.enums;

public enum ResponseStatus {
    Success("success"), Fail("fail"), Init("init");
    public String status;
    ResponseStatus(String status) {
        this.status = status;
    }
}
