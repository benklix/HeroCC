package model;

import java.util.ArrayList;

import matrix.WeightedDirectedGraph;

public class Vehicle {
	
	private int id;
	private int position;
	private ArrayList <Task> assignedTasks = new ArrayList<Task>();
	private ArrayList <Position> route = new ArrayList<Position>();
	private WeightedDirectedGraph distanceMatrix;
	
	
	
	/*
	 * Getters and setters
	 */
	public int getId() {
		return id;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int routeSize() {
		return route.size();
	}

	private void addStepToRoute(Step step) {
		route.add(step.getPos());
	}

	/*
	 * Assigns Task to Vehicle
	 */
	public void assignTask(Task t) {
		assignedTasks.add(t);
	}

	/*
	 * Generates a valid Route
	 */
	public void generateVehicleRoute() {
		
		initializeDistanceMatrix();
		
		
		
		int i = 0;
		Step bestStep = new Step();
		route.addAll(c)
		
		// TODO bessere Abbruchbedingung finden!!!
		while(route.size() != assignedTasks.size()*2) {
			
			
			
			route.add(bestStep.getPos());
			i++;
		}
	}

	private void initializeStepId() {
		
		for(int i=0, N=assignedTasks.size(); i<N; i++) {
			assignedTasks.get(i).setStepId(i, N);
		}
	}
	
	private void initializeDistanceMatrix() {
		
		distanceMatrix = new WeightedDirectedGraph(assignedTasks.size()*2);
		
		for(Task t : assignedTasks) {
			
			distanceMatrix.setEdge(t.getPickupId(), t.getDeliveryId(), t.getDistance());
		}
	}


}
