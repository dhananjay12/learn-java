package mynotes.utils;

import org.apache.commons.lang3.time.StopWatch;

public class ThreadUtil {

    public static StopWatch stopWatch = new StopWatch();

    public static void delay(long delayMilliSeconds)  {
        try{
            Thread.sleep(delayMilliSeconds);
        }catch (Exception e){
            LoggerUtil.logWithThread("Exception is :" + e.getMessage());
        }
    }

    public static void startTimer(){
        stopWatch.reset();
        stopWatch.start();
    }

    public static void stopTimer(){
        stopWatch.stop();
        LoggerUtil.logWithThread("Total Time Taken : " +stopWatch.getTime());
    }
}
