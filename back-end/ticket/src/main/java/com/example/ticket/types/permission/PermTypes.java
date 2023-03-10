package com.example.ticket.types.permission;

import java.io.Serializable;

public enum PermTypes implements Serializable {
    ADMIN("admin"),
    NORMAL("normal"),
    VIP("vip"),
    NOT_ADMIN("both");
    private final String val;

    PermTypes(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
