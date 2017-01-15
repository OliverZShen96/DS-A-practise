import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public TreeNode root;
	
	public Tree(Integer item) {
		this.root = new TreeNode(item);
	}
	
	public void addNode(Integer item) {
		TreeNode curr = root;
		TreeNode parent = null;
		while (curr != null) {
			parent = curr;
			if (item < root.getData()) curr = curr.getChildRight();
			else curr = curr.getChildLeft();
		}
		
		if (item < root.getData()) parent.addChildRight(item);
		else parent.addChildLeft(item);
	}
	
	public void inOrderTraversal() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			System.out.println(curr.getData());
			if (curr.getChildLeft() != null) q.add(curr.getChildLeft());
			if (curr.getChildRight() != null) q.add(curr.getChildRight());
		}
	}
}
