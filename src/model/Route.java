package model;

import java.util.ArrayList;
import ga.TaskManager;
import ga.VehicleManager;

public class Route {
	

	public void generateIndividual() {
		
		// Assign each Task to a random Vehicle
		for(Task t : TaskManager.getTaskList()) {
			int vehicleIndex = (int) Math.random()*VehicleManager.numberOfVehicles();
			VehicleManager.get(vehicleIndex).assignTask(t);
		}
		
		// Generate a valid Route for each Vehicle
		for(Vehicle v : VehicleManager.getVehicleList()) {
			v.generateVehicleRoute();
		}
		
	}

	public int getFitness() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
