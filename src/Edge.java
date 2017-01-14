
public class Edge<E> {
	public Node<E> to;
	public Node<E> from;
	public int weight;
	
	public Edge(Node<E> from, Node<E> to, int weight){
		this.to = to;
		this.from = from;
		this.weight = weight;
	}
	
	public E getToData() {
		return to.getData();
	}
	
	public E getFromData() {
		return from.getData();
	}
	
	public Node<E> getFrom() {
		return from;
	}
	
	public Node<E> getTo() {
		return to;
	}
	
	public int getWeight() {
		return weight;
	}
}
