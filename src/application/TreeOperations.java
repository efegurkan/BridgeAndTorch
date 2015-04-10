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
	
	public Tree tree() {
		Tree agac = new Tree();
		Node startNod = new Node();
		agac.setRoot(startNod);
		return agac;
	}
	
	public Tree populateTree(ArrayList<Integer> speed ){
		PriorityQueue<Integer> queueueueue = new PriorityQueue<Integer>();
//		ArrayList<Integer> eziqler = (ArrayList)speed.clone();
		int idCounter=0;
		Tree ret = new Tree();
		Node startNod = new Node();
		ret.setRoot(startNod);
		ArrayList<Node> leaflist = new ArrayList<Node>();
		
		DFSadd(speed, queueueueue, startNod,leaflist);
		
		System.out.println("Leaflist");
		for (Node node : leaflist) {
//			System.out.println(node);
//			System.out.println(node.getFunctional());
			Node current = node;
			int total = 0;
			int totheur = 0;
			while(current.getParent() != null){
				total += current.getFunctional();
				totheur += current.getHeuristic();
				current = current.getParent();
			}
//			System.out.println(node);
//			System.out.println(totheur);
//			System.out.println(total);
			System.out.println(totheur+total);
		}
		return ret;
	}
	public void DFSadd(ArrayList<Integer> kalanlar , PriorityQueue<Integer> gidenler, Node parent, ArrayList<Node> leaflist) {
		if(kalanlar.size()==2) {
			Node leaf = new Node();
			leaf.setLeaf(true);
			leaf.setParent(parent);
			leaf.setHeuristic(0);
			leaf.setFunctional(Math.max(kalanlar.get(0), kalanlar.get(1)));
			leaflist.add(leaf);
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

			current.setHeuristic(klongiden.peek());
			klonkalan.add(klongiden.poll());
			DFSadd(klonkalan, klongiden, current,leaflist);
			System.out.println("================================");
			System.out.println(current.getParent());
			System.out.println(current);
			System.out.println("================================");
			klonkalan = (ArrayList<Integer>) kalanlar.clone();
			klongiden = new PriorityQueue<>(gidenler);
				}
			
			}
		}
	}
	
	public Tree generateTree(){
		Tree ret = new Tree();
		
		Node startNode = new Node();
		ret.setRoot(startNode);
		
		// First child and its children
		Node first = new Node(2,1,startNode,false);
		Node firstBirBes = new Node(5,1,first,false);
		Node firstBirSekiz = new Node(8,1,first,false);
		Node firstBesSekiz = new Node(8,2,first,false);
		Node birSekizF = new Node(8,0,firstBirBes,true);
		Node birBesF = new Node(5,0,firstBirSekiz,true);
		Node birIkiF = new Node(2,0,firstBesSekiz,true);
		
		
		//Second child and its children
		Node second = new Node(5,1,startNode,false);
		Node secondBirIki = new Node(2,1,second,false);
		Node secondBirSekiz = new Node(8,1,second,false);
		Node secondIkiSekiz = new Node(8,2,second,false);
		Node birSekizS = new Node(8,0,secondBirIki,true);
		Node birIkiS = new Node(2,0,secondBirSekiz,true);
		Node birIkiSe = new Node(2,0,secondIkiSekiz,true);
		
		//Third child and its children
		Node third = new Node(8,1,startNode,false);
		Node thirdBirIki = new Node(2,1,third,false);
		Node thirdBirBes = new Node(5,1,third,false);
		Node thirdIkiBes = new Node(5,2,third,false);
		Node birBesT = new Node(5,0,thirdBirIki,true);
		Node birIkiT = new Node(2,0,thirdBirBes,true);
		Node birIkiTt = new Node(2,0,thirdIkiBes,true);
		
		//Forth child and its children
		Node forth = new Node(5,2,startNode,false);
		Node forthBirSekiz = new Node(8,1,forth,false);
		Node forthBirIki = new Node(2,1,forth,false);
		Node forthIkiSekiz = new Node(8,2,forth,false);
		Node birIkiFo = new Node(2,0,forthBirSekiz,true);
		Node birSekizFo = new Node(8,0,forthBirIki,true);
		Node birIkiFor = new Node(2,0,forthIkiSekiz,true);
		
		//Fifth child and its children
		Node fifth = new Node(8,2,startNode,false);
		Node fifthBirIki = new Node(2,1,fifth,false);
		Node fifthBirBes = new Node(5,1,fifth,false);
		Node fifthIkiBes = new Node(5,2,fifth,false);
		Node birBesFi = new Node(5,0,fifthBirIki,true);
		Node birIkiFi = new Node(2,0,fifthBirBes,true);
		Node birIkiFif = new Node(2,0,fifthIkiBes,true);
		
		//Sixth child and its children
		Node sixth = new Node(8,5,startNode,false);
		Node sixthBirIki = new Node(2,1,sixth,false);
		Node sixthIkiBes = new Node(5,2,sixth,false);
		Node sixthBirBes = new Node(5,1,sixth,false);
		Node birBesSix = new Node(5,0,sixthBirIki,true);
		Node birIkiSix = new Node(2,0,sixthIkiBes,true);
		Node birIkiSixth = new Node(2,0,sixthBirBes,true);
		
		
		
		
		return ret;
	}

}
