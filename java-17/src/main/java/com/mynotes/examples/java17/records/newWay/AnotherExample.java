package com.mynotes.examples.java17.records.newWay;


import java.util.ArrayList;
import java.util.List;

public class AnotherExample {

    // I can put the record in the method scope and create classes outside, which just might pollute because many
    //classes use have same with slightly different properties. Useful is tests or object mappings etc.
    static void test() {

        record Employee(String name, int salary){}

        List employeeList = new ArrayList<>();
        employeeList.add(new Employee("test1",123123));
        employeeList.add(new Employee("test2",234234));

        System.out.println(employeeList.size());
    }

    public static void main(String[] args) {

        test();

    }

}
