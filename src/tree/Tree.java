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
	
	public void printLeafs(){
		preorder(this.root, 0);
	}

	public void preorder(Node node, int gscore){
		
		gscore += node.getFunctional()+node.getHeuristic();
		if(node.isLeaf()){
			System.out.println("Leaf node reached gscore: "+ gscore);
		}
		for (Node child : node.getChildren()) {
			preorder(child,gscore);
		}
	}
}
