
public class User {
	public static void main(String[] args) {
		Graph<String> g = new Graph<String>();
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		
		g.addUndirectedConnection("a", "b", 5);
		g.addUndirectedConnection("a", "c", 2);
		g.addUndirectedConnection("b", "d", 3);
		g.addUndirectedConnection("c", "e", 3);
		g.addUndirectedConnection("b", "e", 7);
		
		g.dijkstras("a");
		
	}
}
