package model;

public class Tool {
	
	String name;
	int id;
	Position pos;
	
	/*
	 * constructors
	 */
	public Tool() {
	}

	public Tool(String name_, int id_, double xCoord, double yCoord) {
		
		name = name_;
		id = id_;
		pos = new Position(xCoord, yCoord);
	}
	
	/*
	 * getter and setters
	 */
	public String getName() {return name;}
	
	public int getId() {return id;}
	
	public Position getPos() {return pos;}
	
	public void setId(int id_) {
		this.id = id_;
	}
	
	public void setPosition(Position pos_) {
		
		pos.setX(pos_.getX());
		pos.setY(pos_.getY());
	}
	
	/*
	 * calculates the distance to given Tool
	 */
	public double getDistance(Tool tool) {
		
		double distX = getPos().getX() - tool.getPos().getX();
		double distY = getPos().getY() - tool.getPos().getY();
		
		return Math.sqrt(Math.pow(distX, 2)+Math.pow(distY, 2));
	}
	
	/*
	 * prints the tool as String
	 */
	@Override
	public String toString() {
		return getId()+"-"+getName()+": ("+getPos().toString()+")";
	}
}