import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph<E> {
	public List<Node<E>> nodes;
	
	public Graph() {
		this.nodes = new ArrayList<Node<E>>();
	}
	
	public void dfs(E startData) {
		Node<E> start = getNodeByData(startData);
		System.out.println("////DFS START////");
		System.out.println("starting at " + start.getData());
		// initialization
		Stack<Node<E>> s = new Stack<Node<E>>();
		List<Node<E>> visited = new ArrayList<Node<E>>();
		visited.add(start);
		
		for (Edge<E> e : start.getEdges()) {
			s.push(e.getTo());
		}
		
		while (!s.isEmpty()) {
			Node<E> curr = s.pop();
			visited.add(curr);
			System.out.println("visiting " + curr.getData());
			for (Node<E> n : curr.getNeighbours()) {
				if (!visited.contains(n) && !s.contains(n)) s.push(n);
			}
		}
		System.out.println("////DFS END////");
		
	}
	public void bfs(E startData) {
		Node<E> start = getNodeByData(startData);
		System.out.println("////BFS START////");
		System.out.println("starting at " + start.getData());
		// initialization
		Queue<Node<E>> q = new LinkedList<Node<E>>();
		List<Node<E>> visited = new ArrayList<Node<E>>();
		visited.add(start);
		
		for (Edge<E> e : start.getEdges()) {
			q.add(e.getTo());
		}
		
		while (!q.isEmpty()) {
			Node<E> curr = q.remove();
			visited.add(curr);
			System.out.println("visiting " + curr.getData());
			for (Node<E> n : curr.getNeighbours()) {
				if (!visited.contains(n) && !q.contains(n)) q.add(n);
			}
		}
		System.out.println("////DFS END////");
		
	}
	
	public void addNode(E data) {
		this.nodes.add(new Node<E>(data));
	}
	
	public boolean addDirectedConnection(E from, E to) {
		Node<E> fromNode = getNodeByData(from);
		Node<E> toNode = getNodeByData(to);
		
		if (fromNode != null && toNode != null) {
			fromNode.addEdge(toNode);
			return true;
		}
		
		if (fromNode == null) System.out.println("Node with data " + from + " not found");
		if (fromNode == null) System.out.println("Node with data " + to + " not found");
		return false;
	}
	
	public boolean addUndirectedConnection(E first, E second) {
		return (addDirectedConnection(first, second) && addDirectedConnection(second, first));
	}
	
	public int size() {
		return nodes.size();
	}
	
	public void printNodes() {
		for (Node<E> n : nodes) {
			System.out.println(n.getData());
		}
	}
	
	public void printConnections() {
		for (Node<E> n : nodes) {
			for (Edge<E> e : n.getEdges()) {
				System.out.println(e.getFromData() + " -> " + e.getToData());
			}
		}
	}
	
	public Node<E> getNodeByData(E data) {
		for (Node<E> n : nodes) {
			if (n.getData() == data) return n;
		}
		return null;
	}
}

