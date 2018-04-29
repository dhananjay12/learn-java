package mynotes.shortConcepts;

public class TrickyOverloading2 {

    public void method(final Object o) {
        System.out.println("Object Version");
    }

    public void method(final String s) {
        System.out.println("String Version");
    }

    public static void main(final String args[]) {
        final TrickyOverloading2 obj = new TrickyOverloading2();
        final StringBuffer sb1 = new StringBuffer("Test");
        final String s1 = new String("Test");
        obj.method("Test");
        obj.method(s1);
        obj.method(1);
        obj.method(sb1);
        //obj.method(null); // The method method(Object) is ambiguous
    }

}
