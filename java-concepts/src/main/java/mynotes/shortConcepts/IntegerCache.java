package main.java.mynotes.shortConcepts;

public class IntegerCache {
    public static void main(String[] args)
    {

        // Initializing variable a and b.
        // Java keeps a integer cache of integer
        // instances in range of -128 to 127.
        // Integer Cache works only on autoboxing.
        // Conversion from primitive type to object
        // reference is called autoboxing.

        // In range declaration (-128 to 127) then
        // object reference will be same.
        Integer a = 9;
        Integer b = 9;

        // Then it will be true because both value of
        // a and b will point to the same object reference.
        if (a == b)
        {
            System.out.println("a==b");
        }
        else {
            System.out.println("a!=b");
        }
        if(a.equals(b)){
            System.out.println("a.equals(b) works");
        }

        // Not in range declaration (-128 to 127)
        // then object reference will not be same in this
        // case.
        Integer x = 396;
        Integer y = 396;

        // Then it will be false because both value of
        // a and b will point to the different
        // memory location.
        if (x == y) {
            System.out.println("x==y");
        }
        else
        {
            System.out.println("x!=y");
        }

        if(x.equals(y)){
            System.out.println("x.equals(y) works");
        }


        int p = 396;
        int q = 396;

        if (p == q) {
            System.out.println("No effect when using primitives p==q");
        }


    }
}
