package com.rockspin.androiddevtest;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CosmonautData {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String purpose;
    private Date date;

    public CosmonautData() { /* Required Empty Constructor */ }

    public String getPurpose() {
        return purpose;
    }

    public String getDate() {
        if (date == null) {
            return "No Data To Display";
        }

        return simpleDateFormat.format(date);
    }
}
