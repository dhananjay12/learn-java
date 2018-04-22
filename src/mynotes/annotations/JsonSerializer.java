package mynotes.annotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializer {
    public String serialize(final Object object) throws JsonSerializeException {
        try {
            final Class<?> objectClass = Objects.requireNonNull(object).getClass();
            final Map<String, String> jsonElements = new HashMap<>();
            for (final Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    jsonElements.put(getSerializedKey(field), (String) field.get(object));
                }
            }
            //System.out.println(toJsonString(jsonElements));
            return toJsonString(jsonElements);
        } catch (final IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    private String toJsonString(final Map<String, String> jsonMap) {
        final String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

    private static String getSerializedKey(final Field field) {
        final String annotationValue = field.getAnnotation(JsonField.class).value();
        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }
}
