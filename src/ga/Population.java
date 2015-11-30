package ga;

import model.Route;

public class Population {
	
	/*
	 *  Holds population of Routes
	 */
    Route[] routes;

    /*
     *  Constructor
     */
    public Population(int populationSize, boolean initialise) {
        routes = new Route[populationSize];

        if (initialise) {
   
            for (int i = 0; i < populationSize(); i++) {
            	
                Route newRoute = new Route();
                newRoute.generateIndividual();
                saveRoute(i, newRoute);
            }
        }
    }
    
    /*
     * Saves a Route
     */
    public void saveRoute(int index, Route route) {
        routes[index] = route;
    }
    
    /*
     * Returns a Route from Population
     */
    public Route getRoute(int index) {
        return routes[index];
    }

    /*
     * Returns the best Route in the Population
     */
    public Route getFittest() {
    	Route fittest = routes[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getRoute(i).getFitness()) {
                fittest = getRoute(i);
            }
        }
        return fittest;
    }

    /*
     *  Returns Population size
     */
    public int populationSize() {
        return routes.length;
    }

}
