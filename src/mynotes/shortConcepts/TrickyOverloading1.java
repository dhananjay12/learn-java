package mynotes.shortConcepts;

public class TrickyOverloading1 {

    static String x = "";

    public static void main(final String... doYourBest) {
        executeAction(1);
        executeAction(1.0);
        executeAction(Double.valueOf("5"));
        executeAction(1L);

        System.out.println(x);
    }

    static void executeAction(final int... var) {
        x += "a";
    }

    static void executeAction(final Integer var) {
        x += "b";
    }

    static void executeAction(final Object var) {
        x += "c";
    }

    static void executeAction(final short var) {
        x += "d";
    }

    static void executeAction(final float var) {
        x += "e";
    }

    static void executeAction(final double var) {
        x += "f";
    }

}
