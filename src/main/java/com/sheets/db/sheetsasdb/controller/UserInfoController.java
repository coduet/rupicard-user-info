package com.sheets.db.sheetsasdb.controller;

import com.sheets.db.sheetsasdb.dao.UserInfoDAO;
import com.sheets.db.sheetsasdb.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-info")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/addUserInfo")
    public ResponseEntity<?> addUserInfo(@RequestBody UserInfoDAO userInfo){
        try{
            userInfoService.addUserInfo(userInfo);
            return new ResponseEntity<>( HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
