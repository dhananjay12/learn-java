package com.mynotes.examples.java17.instanceOf;

public class Example {

    private static void before(Object obj) {
        System.out.println("==BEFORE==");
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("Length="+s.length());
        }
        //Risk casting it directly.
        String s = (String) obj;
        System.out.println("Length="+s.length());
    }

    private static void after(Object obj) {
        System.out.println("==AFTER==");

        if (obj instanceof String s) {
            //No need to cast inside
            System.out.println("Length="+s.length());
        }
        //If using outside, still have to use cast.
        String s = (String) obj;
        System.out.println("Length="+s.length());
    }

    public static void main(String[] args) {

        before("hello");
        after("hello");

    }
}
