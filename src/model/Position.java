package model;

public class Position {
	double x, y;
	
	public Position(double x_, double y_) {
		x = x_;
		y = y_;
	}

	/*
	 * getters and setters
	 */
	public double getX() {return x;}
	
	public double getY() {return y;}
	
	protected void setX(double x_) {
		x = x_;
	}
	protected void setY(double y_) {
		y = y_;
	}
	
	/*
	 * prints the position as String
	 */
	@Override
	public String toString() {
		return getX()+", "+getY();
	}

}
