package com.example.buspass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class ExpendableListData {
    public static HashMap<String,List<String>> getData(){
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> One_month = new ArrayList<String>();

        One_month.add("Student pass= 200");
        One_month.add("Office pass= 300");
        One_month.add("Seniour pass= 150");

        List<String> Three_months = new ArrayList<String>();

        Three_months.add("Student pass= 600");
        Three_months.add("Office pass= 900");
        Three_months.add("Seniour pass= 450");


        List<String> Six_months = new ArrayList<String>();

        Six_months.add("Student pass= 1200");
        Six_months.add("Office pass= 1800");
        Six_months.add("Seniour pass= 900");


        expandableListDetail.put("One_month",One_month);
        expandableListDetail.put("Three_month",Three_months);
        expandableListDetail.put("Six_month",Six_months);

        return expandableListDetail;

    }
}
