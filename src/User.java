
public class User {
	public static void main(String[] args) {
		Graph<String> g = new Graph<String>();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		
		g.addUndirectedConnection("a", "b");
		g.addUndirectedConnection("a", "c");
		g.addUndirectedConnection("b", "d");
		
		g.printConnections();
		
		g.dfs("a");
		g.bfs("a");
		
	}
}
