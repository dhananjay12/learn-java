package com.mynotes.examples.java17.switchSyntax;

public class TypePatterns {

    static String before(Object o) {

        String result = "";

        if (o instanceof Double) {
            result = String.format("Double value is %f", o);
        } else if (o instanceof Integer) {
            result = String.format("Integer value is %d", o);
        } else if (o instanceof Long) {
            result = String.format("Long value is %d", o);
        } else if (o instanceof String) {
            result = String.format("String value is %s", o);
        } else {
            result = o.toString();
        }

        return result;

    }

    // Switch expressions can now return a value.
    // And you can use a lambda-style syntax for your expressions, without the fall-through/break issues.
    static String after(Object o){
        return switch (o) {
            case Double d  -> String.format("Double value is %f", d);
            case Integer i -> String.format("Integer value is %d", i);
            case Long l    -> String.format("Long value is %d", l);
            case String s  -> String.format("String value is %s", s);
            default        -> o.toString();
        };
    }

    public static void main(String[] args) {
        System.out.println("==BEFORE==");
        System.out.println(before(1));
        System.out.println(before(10l));
        System.out.println(before("mystring"));
        System.out.println(before(10.0));
        System.out.println("==AFTER==");
        System.out.println(after(1));
        System.out.println(after(10l));
        System.out.println(after("mystring"));
        System.out.println(after(10.0));

    }
}
