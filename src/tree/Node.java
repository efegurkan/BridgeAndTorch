package tree;

import java.util.List;

public class Node {
	private Node parent;
	private List<Node> children;
	
	public Node getParent() {
		return this.parent;
	}
	
	public List<Node> getChildren(){
		return this.children;
	}
	
	public Node getFirstChildren(){
		return this.children.get(0);
	}
}