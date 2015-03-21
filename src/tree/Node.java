package tree;

import java.util.Collections;
import java.util.List;

public class Node {
	private int nodeId;
	private Node parent;
	private List<Node> children;
	
	public Node() {
		this.nodeId = -1;
		this.parent = null;
		this.children = Collections.emptyList();
	}
	
	public Node(int aNodeId,
			Node aParent) {
		this.nodeId = aNodeId;
		this.parent = aParent;
		this.children = Collections.emptyList();
			
	}

	
	public Node(int aNodeId, 
			Node aParent, 
			List<Node> aChildren){
		this.nodeId = aNodeId;
		this.parent = aParent;
		this.children = aChildren;
		
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public List<Node> getChildren(){
		return this.children;
	}
	
	public Node getFirstChild(){
		return this.children.get(0);
	}
	
	public Node getLastChild (){
		return this.children.get(this.children.size()-1);
	}
	
	public int getNodeId() {
		return this.nodeId;
	}
	
	public void setId(int iNewId){
		this.nodeId = iNewId;
	}
	
	public void setParent(Node aNewParent) {
		this.parent =aNewParent;
	}
	
	public void setChildren(List<Node> aNewChildren){
		this.children = aNewChildren;
	}
}