package application;

import java.util.ArrayList;

import tree.Tree;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		
		// TODO Populate Test Nodes 1,2,5,8
		ArrayList<Integer> testcases = new ArrayList<Integer>();
		testcases.add(1);
		testcases.add(2);
		testcases.add(5);
		testcases.add(8);
		TreeOperations op = new TreeOperations();
		System.out.println("Populated by aStar");
		op.populateTree(testcases);
		// TODO Populate Tree
		// TODO Start algorithm
		
		System.out.println("Handcreated");
		Tree handcreated = op.generateTree();
		System.out.println(handcreated);
		handcreated.printLeafs();
		
	}

}
