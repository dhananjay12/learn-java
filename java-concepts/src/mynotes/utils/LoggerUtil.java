package mynotes.utils;

public class LoggerUtil {

    public static void log(String message) {

        System.out.println(message);

    }

    public static void logWithThread(String message) {

        System.out.println("[" + Thread.currentThread().getName() + "] - " + message);

    }
}
