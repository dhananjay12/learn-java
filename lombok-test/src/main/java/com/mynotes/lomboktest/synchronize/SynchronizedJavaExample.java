package com.mynotes.lomboktest.synchronize;

public class SynchronizedJavaExample {

    private static final Object lock = new Object();

    public static void test() {
        synchronized (lock) {
            System.out.println("test");
        }
    }

}
