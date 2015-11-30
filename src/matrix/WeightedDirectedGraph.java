package matrix;

public class WeightedDirectedGraph extends GraphMatrixRepresentation<Double> {
	
	public WeightedDirectedGraph(int n_) {
		super(n_);
	}

	@Override
	public Double noEdge() {
		return Double.POSITIVE_INFINITY;
	}
	
	@Override
	public void setEdge(int i, int j, Double d) {
		super.setEdge(i, j, d);
		super.setEdge(j, i, d);
	}
	

}
