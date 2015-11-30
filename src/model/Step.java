package model;

public class Step {
	
	private int id = 0;
	private int demand = 0;
	private double serviceTime = 1;
	private Tool tool = new Tool();
	

	public Step(Tool tool_, int demand_, double serviceTime) {
		
		tool = tool_;
		demand = demand_;
		setServiceTime(serviceTime);
	}

	/*
	 * Getters and setters
	 */
	public int getId() {
		return id;
	}

	public int getDemand() {
		return demand;
	}

	public Position getPos() {
		return tool.getPos();
	}

	public double getServiceTime() {
		return serviceTime;
	}

	public void setId(int id_) {
		id = id_;
	}
	
	public void setServiceTime(double serviceTime_) {
		serviceTime = serviceTime_;
	}
}
