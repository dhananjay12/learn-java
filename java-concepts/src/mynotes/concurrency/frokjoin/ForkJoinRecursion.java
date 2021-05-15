package mynotes.concurrency.frokjoin;

import mynotes.utils.LoggerUtil;
import mynotes.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursion extends RecursiveTask<List<String>> {

    private List<String> input;

    public ForkJoinRecursion(List<String> input){
        this.input = input;
    }
    @Override
    protected List<String> compute() {

        if(input.size()<=1){
            List<String> resultList = new ArrayList<>();
            input.forEach(data->{
                resultList.add(transform(data));
            });
            return resultList;
        }

        int midPoint = input.size() / 2;
        //Left side of list. .fork() arranges this in the Deque async
        ForkJoinTask<List<String>> leftInputList = new ForkJoinRecursion(input.subList(0, midPoint)).fork();
        //Right side of list
        input = input.subList(midPoint, input.size()); //right side of the list
        //Recursion
        List<String> rightResult = compute();
        List<String> leftResult = leftInputList.join();
        leftResult.addAll(rightResult);
        return leftResult;
    }

    private static String transform(String data) {
        ThreadUtil.delay(500);
        return data.toUpperCase(Locale.ROOT) ;
    }

    public static void main(String[] args) {
        ThreadUtil.startTimer();
        List<String> input = ThreadData.getLowerCaseStrings();
        LoggerUtil.log("Input :" + input);

        List<String> resultList = new ArrayList<>();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinRecursion forkJoinRecursion = new ForkJoinRecursion(input);
        //invoke
        resultList = forkJoinPool.invoke(forkJoinRecursion);
        ThreadUtil.stopTimer();
        LoggerUtil.log("Result :"+ resultList);
    }
}
