package Garage;

public class Vehicle {
	public static int totalNumberOfVehicle ;
	public String modelYear;
	public String modelName;
	public double width ; 
	public double depth ;
	private int id; 
	public TimeDetector time;
	Vehicle(double cw,double cp,String modelYear,int id,String modelName){
		totalNumberOfVehicle++;
		this.width = cw;
		this.depth = cp; 
		this.modelYear = modelYear; 
		this.modelName = modelName; 
		this.id = id; 
		time = new TimeDetector();
	}
	public int getID(){
		return id; 
	}
}
