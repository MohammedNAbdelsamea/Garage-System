package Garage;

public class ParkOut {
	
	static void parkOut(int slotID ){
		ParkIn.slots[slotID].departure();
	}
}
