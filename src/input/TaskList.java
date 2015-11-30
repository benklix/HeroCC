package input;

import java.util.ArrayList;
import model.Task;

public class TaskList {

	private ArrayList<Task> taskList;
	
	public int size() {

		return taskList.size();
	}

	public Task get(int index) {
		
		return taskList.get(index);
	}

	public double getTotalWeight() {
		
		double totalWeight = 0.0;
		
		for(Task t : taskList) {
			totalWeight += t.getWeight();
		}
		
		return totalWeight;
	}

}
