package Garage;

public class Slot {
	public double width ; 
	public double depth ;
	public boolean isActive;
	public Vehicle vehicle ;
	private int id; 
	Slot(int id){
		this.id = id; 
	}
	public int getID(){
		return id; 
	}
	public void departure() {
		vehicle.time.parkOut();
		vehicle.time.duration(vehicle);
		isActive = false;
	}
}
