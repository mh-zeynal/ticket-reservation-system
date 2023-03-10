package com.example.ticket.layers.dataLayer;

import com.example.ticket.types.permission.Permission;

public class FilePermissionDao extends FileDao<Permission> {
    public FilePermissionDao(String appPath) {
        super(appPath, "datas/permissions/");
    }

    @Override
    public String getPath(Permission permission) {
        return defaultDirectory + permission.getOptionTitle() + fileExtension;
    }
}
