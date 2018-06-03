package mynotes.java8.streams.parallel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void generateData(final int[] arr) {
        final Random aRandom = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aRandom.nextInt(10);
        }
    }

    public static void calculateAllOddOccurrence(final int[] arr) {
        final Map<Integer, Integer> mymap  = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (mymap.containsKey(arr[i])) {
                mymap.put(arr[i], mymap.get(arr[i]) + 1);
            } else {
                mymap.put(arr[i], 1);
            }
        }
        for (final Map.Entry<Integer, Integer> entry : mymap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

        }
    }

    public static void calculateAllOddOccurrenceStream( int[] arr) {
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().parallelStream().filter(e -> e.getValue() % 2 != 0).forEach(entry -> System.out.println(entry.getKey()+"="+ entry.getValue()));
    }

    public static void calculateAllOddOccurrenceStream(List<Integer> list) {
        list.parallelStream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().parallelStream().filter(e -> e.getValue() % 2 != 0).forEach(entry -> System.out.println(entry.getKey()+"="+ entry.getValue()));
    }

    public static void main(final String... doYourBest) {

        final int[] arr = new int[100000000];

        generateData(arr);
        long starttime = System.currentTimeMillis();
        calculateAllOddOccurrence(arr);
        System.out.println("Total time with simple map=" + (System.currentTimeMillis() - starttime));

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        starttime = System.currentTimeMillis();
        calculateAllOddOccurrenceStream(list);
        System.out.println("Total time Stream with list=" + (System.currentTimeMillis() - starttime));

        starttime = System.currentTimeMillis();
        calculateAllOddOccurrenceStream(arr);
        System.out.println("Total time Stream with array=" + (System.currentTimeMillis() - starttime));

    }}