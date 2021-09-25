package com.mynotes.examples.java17.records.oldWay;


//Sometimes we need immutable data. We do something like this
//There is a lot of boilerplate code
//While IDEs can automatically generate many of these classes, they fail to automatically update our classes when we add a new field.
//For example, if we add a new field, we have to update our equals method to incorporate this field.
public class Person {

    private final String name;
    private final int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
