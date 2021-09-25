package com.mynotes.examples.java17.switchSyntax;

public class Gotchas {

    //Completeness of pattern labels
    //Compile error - the switch expression does not cover all possible input values
    //      return switch (o) {
    //             ^

//    static String completeness(Object o) {
//        return switch (o) {
//            case String s -> String.format("String value is %s", s);
//        };
//    }

    //Solution
    static String completeness(Object o) {
        return switch (o) {
            case String s -> String.format("String value is %s", s);
            default       -> o.toString();
        };
    }

    //Dominance of pattern labels
    //Compile error - error: this case label is dominated by a preceding case label
    //          case String s ->

//    static void dominance(Object o) {
//        switch(o) {
//            case CharSequence cs ->
//                    System.out.println("Sequence with length: " + cs.length());
//            case String s ->
//                    System.out.println("String with length: " + s.length());
//            default -> System.out.println("Unknown type");
//        }
//    }

    //Solution
    static void dominance(Object o) {
        switch(o) {
            case String s ->
                    System.out.println("String with length: " + s.length());
            case CharSequence cs ->
                    System.out.println("Sequence with length: " + cs.length());
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        System.out.println(completeness("test"));
        dominance("test");
    }
}
