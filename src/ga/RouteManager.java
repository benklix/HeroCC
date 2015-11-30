package ga;

import java.util.ArrayList;
import model.Step;

/**
 * Manages the single steps of a Route
 * 
 * @author Benjamin Pietke
 */

public class RouteManager {
	
	private static ArrayList<Step> route = new ArrayList<Step>();

	
	
	/*
	 * Adds the next Step
	 */
    public static void addStep(Step step) {
        route.add(step);
    }
    
    /*
     * Gets a Step
     */
    public static Step getStep(int index){
        return (Step)route.get(index);
    }
    
    /*
     * Gets the number of Steps
     */
    public static int numberOfSteps(){
        return route.size();
    }
	
	
}
