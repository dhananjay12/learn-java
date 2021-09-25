package com.mynotes.examples.java17.switchSyntax;

public class HandlingNull {

    static void before(String s) {
        if (s == null) {
            System.out.println("Value is null");
            return;
        }

        switch (s) {
            case "test", "java" -> System.out.println("Conditional value");
            default               -> System.out.println("Other value");
        }
    }

    static void after(String s) {
        switch (s) {
            case null             -> System.out.println("Value is null");
            case "test", "java" -> System.out.println("Conditional value");
            default               -> System.out.println("Other value");
        }
    }

    public static void main(String[] args) {

        System.out.println("==BEFORE==");
        before(null);
        before("test");
        before("java");
        before("other");
        System.out.println("==AFTER==");
        after(null);
        after("test");
        after("java");
        after("other");

    }
}
