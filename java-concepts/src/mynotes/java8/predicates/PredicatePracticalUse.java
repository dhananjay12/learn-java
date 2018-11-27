package mynotes.java8.predicates;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePracticalUse {

    private String transformCore(String s, Predicate<String> predicate) {
        String[] strArr = s.split(" ");

        return Arrays.stream(strArr)
            .map(str -> {
                if (predicate.test(str)) {
                    return str.toUpperCase();
                }
                return str;
            })
            .collect(Collectors.joining(" "));
    }

    public String transformString(String s) {
        return transformCore(s, p -> p.length() == 3);
    }

    public String transformString(String s, int sizeToUpperCase) {
        return transformCore(s, p -> p.length() == sizeToUpperCase);
    }

    public String transformString(String s, int sizeToUpperCase, String startingChar) {
        return transformCore(s, p -> p.startsWith(startingChar));
    }

    public static void main(String... strings) {
        PredicatePracticalUse obj = new PredicatePracticalUse();
        System.out.println(obj.transformString("The quick brown fox jumps over the lazy dog"));
        System.out.println(obj.transformString("The quick brown fox jumps over the lazy dog", 4));
        System.out.println(obj.transformString("The quick brown fox jumps over the lazy dog", 0, "l"));

    }

}
