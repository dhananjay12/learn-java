package mynotes.concurrency.frokjoin;

import mynotes.utils.LoggerUtil;
import mynotes.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StringUpperCaseParallelStream {

    public static void main(String[] args) {
        ThreadUtil.startTimer();
        List<String> input = ThreadData.getLowerCaseStrings();
        LoggerUtil.log("Input :" + input);

        List<String> resultList = new ArrayList<>();
        resultList =input.parallelStream()
                .map(data->transform(data))
                .collect(Collectors.toList());
        ThreadUtil.stopTimer();
        LoggerUtil.log("Result :"+ resultList);

    }

    private static String transform(String data) {
        ThreadUtil.delay(500);
        return data.toUpperCase(Locale.ROOT) ;
    }

}
