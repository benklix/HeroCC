package input;

import java.util.ArrayList;
import model.Vehicle;

public class VehicleList {

	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public Vehicle get(int index) {
		
		return this.vehicleList.get(index);
	}

}
