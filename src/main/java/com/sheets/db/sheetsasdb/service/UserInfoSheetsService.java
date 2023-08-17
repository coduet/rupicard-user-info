package com.sheets.db.sheetsasdb.service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.sheets.db.sheetsasdb.configuration.UserInfoSheetConfiguration;
import com.sheets.db.sheetsasdb.dao.UserInfoDAO;
import com.sheets.db.sheetsasdb.util.ValueRangeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class UserInfoSheetsService implements UserInfoService {
    @Autowired
    @Qualifier("googleSheetsInstance")
    private Sheets sheetsService;
    @Autowired
    UserInfoSheetConfiguration sheetConfig;

    @Override
    public void addUserInfo(UserInfoDAO userInfo) throws IOException {
        try{
            ValueRange valueRange = ValueRangeConverter.toValueRange(userInfo);
            sheetsService.spreadsheets().values().append(sheetConfig.getSpreadSheetId(),sheetConfig.getRange(), valueRange)
                    .setValueInputOption("RAW")
                    .execute();
        }catch(Exception ex){
            log.error("Error while adding user to spreadsheet",ex.getMessage());
            throw ex;
        }
    }
}