package com.sheets.db.sheetsasdb.service;

import com.sheets.db.sheetsasdb.dao.UserInfoDAO;

import java.io.IOException;

public interface UserInfoService {
    void addUserInfo(UserInfoDAO userInfo) throws IOException;
}
