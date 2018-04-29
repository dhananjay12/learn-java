package mynotes.overriding;

class Person {

    static int a = 10;

    public static void test() {
        System.out.println("Person static test");
    }

}

class Employee extends Person {

    static int a = 20;

    public static void test() {
        System.out.println("Person static test");
    }

}

public class TrickyOverloading1 {

    public static void main(final String[] args) {

        final Person p = new Employee();
        p.test();
        System.out.println(p.a);
    }

}
