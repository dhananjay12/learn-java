package mynotes.annotations;

public class JsonSerializerTest {

    public static void main(final String[] args) throws JsonSerializeException {
        final Car car = new Car("Ford", "F150", "2018");
        final JsonSerializer serializer = new JsonSerializer();
        System.out.println(serializer.serialize(car));
    }

}
