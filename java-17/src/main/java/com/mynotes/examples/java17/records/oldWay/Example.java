package com.mynotes.examples.java17.records.oldWay;

public class Example {

    public static void main(String[] args) {
        Person person1 = new Person("john", 25);
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1);

        Person person2 = new Person("john", 25);

        System.out.println("Is person1 equal to person2=="+ person1.equals(person2));
        System.out.println("Hashcode person1=="+ person1.hashCode());
        System.out.println("Hashcode person2=="+ person2.hashCode());
    }
}
