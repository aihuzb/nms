package com.andi.nms.business.utils;

import com.google.common.collect.Lists;

import java.util.List;

public class BusinessUtil {

    public static List<String> getAuthorityList(int authority){
        List<String> authorityList = Lists.newArrayList();
        if(getBit(authority,0)){
            authorityList.add("view");
        }
        if(getBit(authority,1)){
            authorityList.add("update");
        }
        if(getBit(authority,2)){
            authorityList.add("del");
        }
        if(getBit(authority,3)){
            authorityList.add("add");
        }
        return authorityList;
    }


    private static boolean getBit(int authority,int pst){
        return ((authority & (1 << pst)) != 0);
    }

}
