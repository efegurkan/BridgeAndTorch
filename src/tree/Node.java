package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
//	private int nodeId;
	private Node parent;
	private ArrayList<Node> children;
	private int heuristic;
	private int functional;
	private boolean isLeaf;
	
	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Node() {
//		this.nodeId = -1;
		this.parent = null;
		this.children = new ArrayList<>();
		this.isLeaf = false;
	}
	
//	public Node(int aNodeId,
//			Node aParent) {
////		this.nodeId = aNodeId;
//		this.parent = aParent;
//		this.children = Collections.emptyList();
//			
//	}
//
//	
//	public Node(int aNodeId, 
//			Node aParent, 
//			List<Node> aChildren){
//		this.nodeId = aNodeId;
//		this.parent = aParent;
//		this.children = aChildren;
//		
//	}

	public Node(int functional, int heuristic,Node parent,boolean isLeaf ){
		this.functional=functional;
		this.heuristic=heuristic;
		this.parent=parent;
		this.isLeaf = isLeaf;
		this.children = new ArrayList<>();
		if(parent!= null){
			parent.addChild(this);
		}
		
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
	
//	public int getNodeId() {
//		return this.nodeId;
//	}
//	
//	public void setId(int iNewId){
//		this.nodeId = iNewId;
//	}
	
	public void setParent(Node aNewParent) {
		System.out.println("SetParent");
		System.out.println("$$$$$$$$$$");
		System.out.println(aNewParent);
		System.out.println(this.parent);
		
		this.parent =aNewParent;
		System.out.println(this.parent);
		System.out.println("$$$$$$$$$$$$");
		if(aNewParent != null)
		aNewParent.addChild(this);
	}
	
	public void addChild(Node aNewChild){
		this.children.add(aNewChild);
	}
	
	public void setChildren(ArrayList<Node> aNewChildren){
		this.children = aNewChildren;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}

	public int getFunctional() {
		return functional;
	}

	public void setFunctional(int functional) {
		this.functional = functional;
	}
	
}