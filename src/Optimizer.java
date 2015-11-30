import java.util.ArrayList;

import input.*;
import model.*;
import matrix.*;

public class Optimizer {
	

	static final double SERVICE_TIME_GET = 5;
	static final double SERVICE_TIME_PUT = 5;
	
	private static int origin = -1; //bei Ersten Durchlauf ist Startpunkt nicht bekannt
	
	private static ToolList toolList;
	private static TaskList taskList;
	private static VehicleList vehicleList;
	private static WeightedDirectedGraph distanceMatrix;
	private static WeightedDirectedGraph weightMatrix;
	
	public static void main(String[] args) {
		
		// Input Daten initialisieren
		toolList = new ToolList();
		taskList = new TaskList();
		vehicleList = new VehicleList();
		
		distanceMatrix = new WeightedDirectedGraph(taskList.size()*2);
		// die Distanz zwischen zwei Tools ergibt sich aus der Fahrtzeit plus der Servicezeit (tGet bzw tPut)
		// TODO automatisch einlesen
		// alle nicht zulässigen Paare werden mit POS_INFINITY initialisiert
		distanceMatrix.setEdge(0, 0, SERVICE_TIME_GET);
		distanceMatrix.setEdge(0, 1, 15.0+SERVICE_TIME_GET);
		distanceMatrix.setEdge(0, 2, 30.0+SERVICE_TIME_PUT);
		distanceMatrix.setEdge(0, 3, 25.0+SERVICE_TIME_PUT);
		distanceMatrix.setEdge(1, 0, 15.0+SERVICE_TIME_GET);
		distanceMatrix.setEdge(1, 1, SERVICE_TIME_GET);
		distanceMatrix.setEdge(1, 2, 25.0+SERVICE_TIME_PUT);
		distanceMatrix.setEdge(1, 3, 15.0+SERVICE_TIME_PUT);
		distanceMatrix.setEdge(2, 1, 25.0+SERVICE_TIME_GET);
		distanceMatrix.setEdge(2, 2, SERVICE_TIME_PUT);
		distanceMatrix.setEdge(2, 3, 20.0+SERVICE_TIME_PUT);
		distanceMatrix.setEdge(3, 0, 15.0+SERVICE_TIME_GET);
		distanceMatrix.setEdge(3, 2, 20.0+SERVICE_TIME_PUT);
		distanceMatrix.setEdge(3, 3, SERVICE_TIME_PUT);
		
		WeightedDirectedGraph weightMatrix = new WeightedDirectedGraph(taskList.size()*2);
		// BEACHTE das passende Vorzeichen muss bei der Berechnung berücksichtigt werden
		weightMatrix.setEdge(0, 1, taskList.get(1).getWeight());
		weightMatrix.setEdge(0, 2, taskList.get(2).getWeight());
		weightMatrix.setEdge(0, 3, taskList.get(3).getWeight());
		weightMatrix.setEdge(1, 0, taskList.get(0).getWeight());
		weightMatrix.setEdge(1, 2, taskList.get(2).getWeight());
		weightMatrix.setEdge(1, 3, taskList.get(3).getWeight());
		weightMatrix.setEdge(2, 1, taskList.get(1).getWeight());
		weightMatrix.setEdge(2, 3, taskList.get(3).getWeight());
		weightMatrix.setEdge(3, 0, taskList.get(0).getWeight());
		weightMatrix.setEdge(3, 2, taskList.get(2).getWeight());
		
		
		// objective function: minimize the total weighted execution time
		Route vehicleRoute = new Route();
		
		
		for(int i=0, N=taskList.size()*2; i<N; i++) {
			
			Step bestStep = findBestStep(origin);
			
			vehicleRoute.add(bestStep);
			
			if(bestStep.getDemand() > 0) {
				// die Spalten dürfen gar nicht mehr zugänglich sein, damit keine Rechenzeit verschwendet wird!!!
				distanceMatrix.writeColumn(false, bestStep.getId());
				distanceMatrix.writeColumn(true, bestStep.getId()+taskList.size());
			}
			else {
				distanceMatrix.writeColumn(false, bestStep.getId()+taskList.size());
				taskList.get(bestStep.getId()).setAssigned();
			}
		}
		
		vehicleRoute.assignVehicle(vehicleList);

	}


	private static Step findBestStep(int origin) {
		
		double pendingWeight = taskList.getTotalWeight();
		double loadedWeight = 0.0;
		double bestCost = Double.POSITIVE_INFINITY;
		int bestStepIndex = 0;
		double stepCost = 0.0;
		
		// TODO was macht der NeighborIterator der distanceMatrix???
		// pending und loaded weight anpassen
		for(int i=0, N=distanceMatrix.getSize(); i<N; i++) {
			
			stepCost = distanceMatrix.getEdge(origin,i)*pendingWeight/loadedWeight;
			
			if(stepCost<bestCost) {
				bestCost = stepCost;
				bestStepIndex = i;
			}
		
		}
		
		setOrigin(bestStepIndex);
		
		return (new Step(taskList.get(bestStepIndex)));
	}


	private static void setOrigin(int newOrigin) {
		
		origin = newOrigin;
	}

}
