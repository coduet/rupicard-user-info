package com.sheets.db.sheetsasdb.util;

import com.google.api.services.sheets.v4.model.ValueRange;
import com.sheets.db.sheetsasdb.dao.UserInfoDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueRangeConverter {
    public static ValueRange toValueRange(UserInfoDAO userInfo) {
        List<Object> values = Arrays.asList(userInfo.getFirstName(), userInfo.getLastName(), userInfo.getMobileNumber(), userInfo.getEmailAddress());
        List<List<Object>> data = new ArrayList<>();
        data.add(values);

        return new ValueRange().setValues(data);
    }
}
