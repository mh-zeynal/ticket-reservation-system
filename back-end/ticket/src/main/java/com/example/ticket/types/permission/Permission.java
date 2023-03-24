package com.example.ticket.types.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.ticket.types.optionType.Option;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "permissions", schema = "reservation_schema")
public class Permission implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;
    @Column(name = "is_allowed", nullable = false)
    private boolean isAllowed;
    @Column(name = "permission_type", nullable = false)
    private String permissionType;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "option_id")
    private Option option;

    public Permission(){}

    public Permission(Option option, boolean isAllowed, PermTypes perm) {
        this.option = option;
        this.isAllowed = isAllowed;
        this.permissionType = perm.getVal();
    }

    public Option getOption() {
        return option;
    }

    public boolean isAllowed() {
        return isAllowed;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public String getOptionTitle(){
        return option.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAllowed(boolean allowed) {
        isAllowed = allowed;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
