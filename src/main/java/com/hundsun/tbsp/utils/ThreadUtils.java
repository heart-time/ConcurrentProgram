package com.hundsun.tbsp.utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {

    public static void sleep(long time)  {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
