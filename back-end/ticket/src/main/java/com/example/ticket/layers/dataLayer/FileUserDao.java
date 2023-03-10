package com.example.ticket.layers.dataLayer;

import com.example.ticket.types.userType.User;

public class FileUserDao extends FileDao<User> {
    public FileUserDao(String appPath) {
        super(appPath,"datas/users/");
    }

    @Override
    public String getPath(User user) {
        return defaultDirectory + user.hashCode() + fileExtension;
    }
}
