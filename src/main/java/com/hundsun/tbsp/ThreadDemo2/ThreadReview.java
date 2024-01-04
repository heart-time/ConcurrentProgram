package com.hundsun.tbsp.ThreadDemo2;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo2
 * @Description
 * @date 2023/12/7 15:34
 */
public class ThreadReview {
    private static final ThreadReview singleton = new ThreadReview();

    private ThreadReview() {

    }

    public static ThreadReview getInstance() {
        return singleton;
    }
}
