package mynotes.collections.collectors.simple;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Optional;
import java.util.stream.Collector;

public class CustomCollectors {

    public static <T> Collector<T, ?, Optional<T>> findOne() {
        return findOne("More than one element found");
    }

    public static <T> Collector<T, ?, Optional<T>> findOne(String error) {
        return collectingAndThen(
            toList(),
            list -> {
                if (list.size() == 0) {
                    return Optional.empty();
                }

                if (list.size() == 1) {
                    return Optional.of(list.get(0));
                }

                throw new RuntimeException(error);
            }
        );
    }

    public static <T> Collector<T, ?, T> findJustOne(String error) {
        return collectingAndThen(
            toList(),
            list -> {
                if (list.size() == 0) {
                    throw new RuntimeException("Empty result");
                }

                if (list.size() == 1) {
                    return list.get(0);
                }

                throw new RuntimeException("More than one element found");
            }
        );
    }

}
