package tree;

public class Tree {
	private Node root;
	private Node current;
	
	public Tree() {
	}
	
	public void addNode(Node aNewChild) {
		current.getChildren().add(aNewChild);
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	public void setRoot(Node aNewRoot){
		this.root = aNewRoot;
	}
	
}
