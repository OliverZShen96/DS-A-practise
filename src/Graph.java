import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
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
	
	public void dijkstras(E startData) {
		// initialization
		Set<Node<E>> visited = new HashSet<Node<E>>();
		Set<Node<E>> unvisited = new HashSet<Node<E>>();
		unvisited.addAll(nodes);
		
		Map<Node<E>, Integer> dist = new HashMap<Node<E>, Integer>();
		Map<Node<E>, Node<E>> prev = new HashMap<Node<E>, Node<E>>();
		
		Node<E> first = getNodeByData(startData);
		visited.add(first);
		unvisited.remove(first);
		
		for (Node<E> n : nodes) {
			dist.put(n, Integer.MAX_VALUE);
			prev.put(n, null);
		}
		dist.put(first, 0);
		prev.put(first, null);
		
		while(!unvisited.isEmpty()) {
			int min = Integer.MAX_VALUE;
			Node<E> nextN = null;
			Node<E> prevN = null;
			
			for (Node<E> n : visited) {
				for (Edge<E> e : n.getEdges()) {
					if (unvisited.contains(e.getTo())) {
						if (e.getWeight() + dist.get(n) < min) {
							min = e.getWeight() + dist.get(n);
							nextN = e.getTo();
							prevN = e.getFrom();
						}
					}
				}
			}
			
			dist.put(nextN, min);
			prev.put(nextN, prevN);
			visited.add(nextN);
			unvisited.remove(nextN);
		}
		for (Node n : nodes) {
			if (prev.get(n) != null) System.out.println(n.getData() + "|dist " + dist.get(n) + "|prev " + prev.get(n).getData());
			else System.out.println(n.getData() + "|dist " + dist.get(n) + "|prev null");
		}
		
		
	}
	
	public void addNode(E data) {
		this.nodes.add(new Node<E>(data));
	}
	
	public boolean addDirectedConnection(E from, E to, int weight) {
		Node<E> fromNode = getNodeByData(from);
		Node<E> toNode = getNodeByData(to);
		
		if (fromNode != null && toNode != null) {
			fromNode.addEdge(toNode, weight);
			return true;
		}
		
		if (fromNode == null) System.out.println("Node with data " + from + " not found");
		if (fromNode == null) System.out.println("Node with data " + to + " not found");
		return false;
	}
	
	public boolean addUndirectedConnection(E first, E second, int weight) {
		return (addDirectedConnection(first, second, weight) && addDirectedConnection(second, first, weight));
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
				System.out.println(e.getFromData() + " -> " + e.getToData() + " " + e.getWeight());
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

