package ga;

import java.util.ArrayList;
import model.Vehicle;

public class VehicleManager {
	
	private static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public static int numberOfVehicles() {
		
		return vehicleList.size();
	}

	public static Vehicle get(int vehIndex) {
		
		return vehicleList.get(vehIndex);
	}

	public static ArrayList<Vehicle> getVehicleList() {
		
		return vehicleList;
	}

}
