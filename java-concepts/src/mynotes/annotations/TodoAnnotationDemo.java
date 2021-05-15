package mynotes.annotations;

import java.lang.reflect.Method;

class MyClass {

    @Todo(priority = Todo.Priority.MEDIUM, description = "business logic", status = Todo.Status.STARTED)
    public void incompleteMethod1() {
        //Some business logic is written
        //But it�s not complete yet
    }

}

public class TodoAnnotationDemo {

    public static void main(final String[] args) {
        final Class myClass = MyClass.class;
        for (final Method method : myClass.getMethods()) {
            final Todo todoAnnotation = method.getAnnotation(Todo.class);
            if (todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Description : " + todoAnnotation.description());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
            }
        }
    }

}
