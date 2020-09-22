package mynotes.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void test(String input) {
        String resultString = "";
        String regex = "/(draft|final)/api/token-converter/(?<remaining>.*)";

        Pattern regexPattern = Pattern.compile(regex);
        Matcher match = regexPattern.matcher(input);

        if (match.find()) {
            resultString = match.group(2);
        }

        //debug output
        System.out.println("input: " + input);
        System.out.println("regex: " + regex);
        System.out.println("group count: " + match.groupCount());
        System.out.println("group(1): " + resultString);

        String newPath = input.replaceAll(regex, resultString);
         System.out.println("newPath: " + newPath);
    }

    public static void main(String[] args) {

        test("/draft/api/token-converter/actuator/health");

    }

}
