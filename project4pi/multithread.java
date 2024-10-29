import java.util.concurrent.*;
import java.util.Random;
public class multithread {

    private static final int TOTAL_POINTS=100_000_000;
    private static final int THREAD_COUNT=10;

    public static void main(String[] args) throws Exception {
        ExecutorService executor=Executors.newFixedThreadPool(THREAD_COUNT);
        int pointsInThread=TOTAL_POINTS/THREAD_COUNT;
        Future <Long>[]results=new Future[THREAD_COUNT];
        for(int i=0;i<THREAD_COUNT;i++){
            results[i]= executor.submit(new PiCalc(pointsInThread));
        }
        long inside=0;
        for(Future<Long> result:results){

        }


    }
}
