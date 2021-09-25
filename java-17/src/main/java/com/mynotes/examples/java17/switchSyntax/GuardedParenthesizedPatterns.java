package com.mynotes.examples.java17.switchSyntax;

public class GuardedParenthesizedPatterns {

    static String before(Object o){
        switch (o) {
            case String s:
                if (s.length() >= 1) {
                    return String.format("String value is %s", s);
                } else {
                    return "Empty string";
                }
            default:
                return o.toString();
        }
    }

    //A guarded pattern is of the form p && e, where p is a pattern and e is a boolean expression.
    // With guarded patterns, the conditional logic can be moved to the case label.
    static String after1(Object o){
        return switch (o) {
            case String s && s.length() >= 1  -> String.format("String value is %s", s);
            case String s                     -> String.format("Empty string");
            default                           -> o.toString();
        };
    }

    //A parenthesized pattern is of the form (p), where p is a pattern.
    //With parenthesized pattern, you can add parentheses around s.contains("@") || s.contains("!"),
    // so that it will be evaluated first.
    static String after2(Object o) {
        return switch (o) {
            case String s && s.length() >= 2 && (s.contains("@") || s.contains("!"))  -> String.format("Valid string value is %s", s);
            default                                                                   -> "Invalid value";
        };
    }

    public static void main(String[] args) {
        System.out.println("==BEFORE==");
        System.out.println(before("mystring"));
        System.out.println(before(10.0));
        System.out.println("==AFTER==");
        System.out.println(after1("mystring"));
        System.out.println(after1(10.0));
    }
}
