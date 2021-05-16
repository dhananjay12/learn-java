package mynotes.concurrency.frokjoin;

import mynotes.utils.LoggerUtil;
import mynotes.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StringUpperCase {

    public static void main(String[] args) {
        ThreadUtil.startTimer();
        List<String> input = ThreadData.getLowerCaseStrings();
        LoggerUtil.log("Input :" + input);

        List<String> resultList = new ArrayList<>();
        input.forEach(data->{
            resultList.add(transform(data));
        });
        ThreadUtil.stopTimer();
        LoggerUtil.log("Result :"+ resultList);

    }

    private static String transform(String data) {
        ThreadUtil.delay(500);
        return data.toUpperCase(Locale.ROOT) ;
    }

}
