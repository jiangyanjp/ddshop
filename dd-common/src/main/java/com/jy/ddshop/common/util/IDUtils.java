package com.jy.ddshop.common.util;

import java.util.Random;

public class IDUtils {
    public static long getItemId(){
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end2 = random.nextInt(99);
        String str = millis+String.format("%02d",end2);
        long id = new Long(str);
        return id;
    }
}
