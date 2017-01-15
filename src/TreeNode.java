
public class TreeNode {
	public Integer data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(Integer data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void addChildLeft(Integer item) {
		this.left = new TreeNode(item);
	}
	
	public void addChildRight(Integer item) {
		this.right = new TreeNode(item);
	}
	
	public Integer getData() {
		return data;
	}
	
	public TreeNode getChildLeft() {
		return left;
	}
	
	public TreeNode getChildRight() {
		return right;
	}
}
