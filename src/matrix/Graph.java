package matrix;

import java.util.Iterator;

public abstract class Graph<Type> {
	protected int n;
	
	public Graph(int _n) {
		n = _n;
	}
	
	// Anzahl der Knoten
	public int getSize() {
		return n;
	}
	
	// l�scht eine Kante
	public void deleteEdge(int i, int j) {
		setEdge(i, j, noEdge());
	}
	
	// l�scht alle Kanten
	protected void initialize() {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				deleteEdge(i,j);
	}
	
	// true, wenn Kante existiert
	public boolean isEdge(int i, int j) {
		return !getEdge(i, j).equals(noEdge());
	}
	
	// Wert noEdge f�r Nicht-Kanten
	public abstract Type noEdge();
	// liefert Wichtung einer Kante
	public abstract Type getEdge(int i, int j);
	// setzt Wichtung einer Kante
	public abstract void setEdge(int i, int j, Type distance);
	//iteriert �ber alle Nachbarn von Knoten i
	public abstract Iterator<Integer> getNeighborIterator(int i);

}
