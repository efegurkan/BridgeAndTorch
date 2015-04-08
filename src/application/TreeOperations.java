package application;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.MathUtils;

import tree.Node;
import tree.Tree;

public class TreeOperations {
	public TreeOperations(){
	}
	
	public Tree populateTree(ArrayList<Integer> speed ){
		PriorityQueue<Integer> queueueueue = new PriorityQueue<Integer>();
//		ArrayList<Integer> eziqler = (ArrayList)speed.clone();
		int idCounter=0;
		Tree ret = new Tree();
		Node startNod = new Node();
		ret.setRoot(startNod);

		DFSadd(speed, queueueueue, startNod);
		
		return ret;
	}
	public void DFSadd(ArrayList<Integer> kalanlar , PriorityQueue<Integer> gidenler, Node parent) {
		if(kalanlar.size()==2) {
			Node leaf = new Node();
			leaf.setParent(parent);
			leaf.setHeuristic(0);
			leaf.setFunctional(Math.max(kalanlar.get(0), kalanlar.get(1)));
			return;
		}
		int sayi = (int) CombinatoricsUtils.binomialCoefficient(kalanlar.size(), 2);

		ArrayList<Integer> klonkalan = (ArrayList<Integer>) kalanlar.clone();
		PriorityQueue<Integer> klongiden = new PriorityQueue<>(); 
		klongiden.retainAll(gidenler); 
		
		for(int i=0;i<sayi;i++) {
			
			for(int j= 0; j<kalanlar.size(); ++j){
				for(int k = j+1; k<kalanlar.size(); k++){
					
					
			Node current = new Node();
			current.setParent(parent);
			current.setFunctional(Math.max(klonkalan.get(j), klonkalan.get(k)));

			klongiden.add(klonkalan.remove(j));
			klongiden.add(klonkalan.remove(k-1));

			current.setHeuristic(klongiden.poll());
			DFSadd(klonkalan, klongiden, current);
			System.out.println("================================");
			System.out.println(current.getParent());
			System.out.println(current);
			System.out.println("================================");
			klonkalan = (ArrayList<Integer>) kalanlar.clone();
			klongiden.retainAll(gidenler);
				}
			
			}
		}
	}
}
