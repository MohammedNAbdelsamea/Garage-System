package Garage;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDetector {
	
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    
    private LocalDateTime parkInTime,parkOutTime;
    Instant start,end;
    public long duration ; 
    public TimeDetector () {
    	
    	start = Instant.now();
    	
    	parkInTime = LocalDateTime.now();  
    }
    
    public void parkOut() {
    	parkOutTime = LocalDateTime.now();
    	
    	System.out.println(dtf.format(parkOutTime));      	
    	end = Instant.now();
    }
    void duration (Vehicle vehicle) {
    	duration = Duration.between(start, end).toSeconds();
    	FeezCalculate.ticket(parkInTime,parkOutTime,duration,vehicle);
//    	System.out.println(duration);
    }
	
}
