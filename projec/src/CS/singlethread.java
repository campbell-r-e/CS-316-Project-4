package CS;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class singlethread {
private static final long totalPoints =1000000;
static int pointsinCircle =0;
public static void main(String[] args) {
    Instant start= Instant.now();
  
    for(long i=0; i<totalPoints;i++){
      double x = ThreadLocalRandom.current().nextDouble(0,2);
      double y = ThreadLocalRandom.current().nextDouble(0,2);
      double distance = Math.sqrt((x-1)*(x-1)+(y-1)*(y-1));
      if(distance<=1){
       
        pointsinCircle++;
    }
    
}

double pi = pointsinCircle /(double)totalPoints*4;
Instant finish = Instant.now();
long TimeElapsed = Duration.between(start, finish).toMillis();
System.out.println("Pi="+pi);
System.out.println("Time Elapsed: "+TimeElapsed);
}

}
