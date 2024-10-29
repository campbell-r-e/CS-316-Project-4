package CS;

import java.util.concurrent.*;

import java.time.Duration;
import java.time.Instant;
public class multithread{

    private static final int TOTAL_POINTS=100_000_000;
    private static final int THREAD_COUNT=10;
    static class PiCalc implements Callable<Long>{
        private final int points;
        private Place time;
       
        public PiCalc(int points,Place time) {
            this.points=points;
            this.time = time;

        }
     
       
    public Long call() {
     
        
    long pointsInCircle = 0;
            Instant start= Instant.now();
            
            time.setstart(start);

           
           
            
  
    for(long i=0; i<points;i++){

      double x = ThreadLocalRandom.current().nextDouble(0,2);
      double y = ThreadLocalRandom.current().nextDouble(0,2);
      double distance = Math.sqrt((x-1)*(x-1)+(y-1)*(y-1));
      if(distance<=1){
       
       
        pointsInCircle++;
    }
   
}
    return pointsInCircle;


            
           
}
       
    }

    public static void main(String[] args) throws Exception {
       
        ExecutorService executor=Executors.newFixedThreadPool(THREAD_COUNT);
        int pointsInThread=TOTAL_POINTS/THREAD_COUNT;
        Future <Long>[]results=new Future[THREAD_COUNT];
        Place timeingPlace = new Place();
        for(int i=0;i<THREAD_COUNT;i++){
            results[i]= executor.submit(new PiCalc(pointsInThread,timeingPlace));
        }
        long inside=0;
        for(Future<Long> result:results){
            inside += result.get(); 
        }
        executor.shutdown();
        double pi = inside /(double)TOTAL_POINTS*4;
         Instant finish = Instant.now();
        
         Instant start=timeingPlace.getstart();
        long TimeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Pi="+pi);
        System.out.println("Time Elapsed: "+TimeElapsed);
    
    }
         


    }
