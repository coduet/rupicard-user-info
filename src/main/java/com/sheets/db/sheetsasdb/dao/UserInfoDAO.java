package com.sheets.db.sheetsasdb.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserInfoDAO {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailAddress;
}
