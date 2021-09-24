package com.mynotes.examples.java17.nullPointer;

public class Example {

    public static void main(String[] args) {

        Person person = null;
        System.out.println(person.getName());
        //will throw
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke
        // "com.mynotes.examples.java17.nullPointer.Person.getName()" because "person" is null
        //	at com.mynotes.examples.java17.nullPointer.HelpfulNullPointerExceptions.main(Example.java:8)
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
