package model;

public class Task {
	
	// Specific Service Time may vary
	final static int SERVICE_TIME_PUT = 15, SERVICE_TIME_GET = 10;
	
	private int id = 0;
	private Step pickup, delivery = null;
	private double distance = 0;
	private double weight = 0;
	private boolean assigned = false;
	
	/*
	 * Constructor
	 */
	public Task(int id, Tool toolPickup, Tool toolDelivery, int priority) {
		
		setId(id);
		pickup = new Step(toolPickup, 1, SERVICE_TIME_GET);
		delivery = new Step(toolDelivery, -1, SERVICE_TIME_PUT);
		setDistance(toolPickup, toolDelivery);
		setWeight(priority);
	}


	/*
	 * Getters and setters
	 */
	public double getWeight() {
		return weight;
	}

	
	private void setId(int id_) {
		id = id_;
	}
	
	public int getPickupId() {
		return pickup.getId();
	}


	public int getDeliveryId() {
		return delivery.getId();
	}
	
	public Double getDistance() {
		return distance;
	}
	
	private void setDistance(Tool toolPickup, Tool toolDelivery) {
		
		//TODO wo kriege ich Fahrtzeit her?!?!
	}
	
	private void setWeight(int priority) {
		weight = Math.pow(2, priority/10);
	}

	public void setAssigned() {
		assigned = true;
	}


	public void setStepId(int id, int size) {
		
		pickup.setId(id);
		delivery.setId(id+size);
	}


}
