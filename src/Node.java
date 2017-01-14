import java.util.ArrayList;
import java.util.List;

public class Node<E> {
	public E data;
	public List<Edge<E>> edges;
	
	public Node(E data) {
		this.data = data;
		this.edges = new ArrayList<Edge<E>>();
	}
	
	public void addEdge(Node<E> other, int weight) {
		this.edges.add(new Edge<E>(this, other, weight));
	}
	
	public List<Edge<E>> getEdges() {
		return this.edges;
	}
	
	public E getData() {
		return this.data;
	}
	
	public List<Node<E>> getNeighbours() {
		List<Node<E>> neighbours = new ArrayList<Node<E>>();
		for (Edge<E> e : edges) {
			neighbours.add(e.getTo());
		}
		return neighbours;
	}
}
