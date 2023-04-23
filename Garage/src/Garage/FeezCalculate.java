package Garage;

import java.time.LocalDateTime;

public class FeezCalculate {
	static long ticketPrice ; 
	static final long hourlyRate = 5;
	public static long  totalIncome ;
	
	static void ticket (LocalDateTime parkInTime,LocalDateTime parkOutTime,long duration,Vehicle vehicle){
		
		long durationInHours = (duration+(60*60-1))/(60*60);
		double convertInHours = (double) duration/(60*60);
		ticketPrice = durationInHours * hourlyRate;
		totalIncome +=ticketPrice;
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("Start date: ");
		System.out.print(parkInTime);
		System.out.print("\tEnd date: ");
		System.out.println(parkOutTime);
		System.out.println();
		
		System.out.print("Duration: ");
		System.out.print(convertInHours+" H");
		System.out.print("\t\tThe ticket price is :");
		System.out.print(ticketPrice);
		System.out.println(" EGP\n");

		System.out.print("Model year: ");
		System.out.print(vehicle.modelYear);
		System.out.print("\t\t\t\t\t Model name: ");
		System.out.println(vehicle.modelName);
		System.out.println();
	
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
