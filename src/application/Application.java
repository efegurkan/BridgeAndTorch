package application;

import java.util.ArrayList;

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
		op.populateTree(testcases);
		// TODO Populate Tree
		// TODO Start algorithm
	}

}
