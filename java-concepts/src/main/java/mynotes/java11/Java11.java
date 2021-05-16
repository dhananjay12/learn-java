package mynotes.java11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java11 {

    public static void main(String[] args) {

        List<String> myList = List.of("a", "b", "c");
        // myList.add("asd"); // Not possible as the collection produced by these are immutable

        //Local variable Type inference
        var list = new ArrayList<String>();
        list.add("a1");
        var stream = list.stream();

        Predicate<String> predicate = s -> s.isEmpty();

        //var ps = s -> s.isEmpty(); //Lambda expression needs an explicit target type;

        Supplier<Long> supplier = () -> System.currentTimeMillis();
        Callable<Long> callable = () -> 17L;
        //Cant use var in above 2 case cause then how would it know which is it supplier or callable.

    }

}
