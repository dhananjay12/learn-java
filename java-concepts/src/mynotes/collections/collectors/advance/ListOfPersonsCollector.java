package mynotes.collections.collectors.advance;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ListOfPersonsCollector implements Collector<String, ListOfPersonsCollector.Container, List<Person>> {

    public static Collector<String, ?, List<Person>> toPersonList() {
        return new ListOfPersonsCollector();
    }

    @Override
    public Supplier<Container> supplier() {
        final Container container = new Container();
        container.list = new ArrayList<>();
        container.name = Optional.empty();
        return () -> container;
    }

    @Override
    public BiConsumer<Container, String> accumulator() {
        return ((container, args) -> {
            if (container.name.isEmpty()) {
                container.name = Optional.of(args);
            } else {
                final Person person = new Person(container.name.get(), args);
                container.list.add(person);
                container.name = Optional.empty();
            }
        });
    }

    @Override
    public Function<Container, List<Person>> finisher() {
        return container -> {
            if (container.name.isEmpty()) {
                return container.list;
            }

            throw new RuntimeException("Cannot create Persons with odd numbers of list.");
        };
    }

    @Override
    public BinaryOperator<Container> combiner() {
        return ($1, $2) -> {
            throw new RuntimeException("This collector doesn't support parallel streams.");
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED);
    }

    public static class Container {

        List<Person> list;
        Optional<String> name;
    }

}
