
public class Edge<E> {
	public Node<E> to;
	public Node<E> from;
	
	public Edge(Node<E> from, Node<E> to){
		this.to = to;
		this.from = from;
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
}
