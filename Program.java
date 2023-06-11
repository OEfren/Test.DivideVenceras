package mx.com.test.uag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

class Node {
	
	public String source;
	public Stack<Node> stack = new Stack<Node>();
	public Set<String> childs = new HashSet<String>();
	
	public Node(String source) {
		this.source = source;
	}
	
	public void addChild(Node node) {
		if (!childs.contains(node.source)) {
			childs.add(node.source);
			stack.add(node);
		}
	}
	
}

class Graph {
	
	HashMap<String, Node> nodes = new HashMap<>();
	
	public void addElement(String source, String edge) {
		if (nodes.containsKey(source)) {
			if (nodes.containsKey(edge)) {
				nodes.get(source).addChild(nodes.get(edge));
				nodes.get(edge).addChild(nodes.get(source));	
			}
			else {
				addElement(edge, source);
			}
		}
		else {	
			nodes.put(source, new Node(source));
			addElement(source, edge);
		}
	}
	
}

public class Program {
	
	public static void main(String[] args) {
		Graph gragh = new Graph();
		gragh.addElement("v","a");gragh.addElement("v","b");gragh.addElement("v","c");
		gragh.addElement("a","v");gragh.addElement("a","b");gragh.addElement("a","d");
		gragh.addElement("a","f");gragh.addElement("b","v");gragh.addElement("b","a");
		gragh.addElement("b","c");gragh.addElement("b","d");gragh.addElement("b","e");
		gragh.addElement("b","g");gragh.addElement("c","v");gragh.addElement("c","b");
		gragh.addElement("c","g");gragh.addElement("e","b");gragh.addElement("e","d");
		gragh.addElement("e","f");gragh.addElement("e","g");gragh.addElement("e","k");
		gragh.addElement("f","a");gragh.addElement("f","e");gragh.addElement("f","k");
		gragh.addElement("g","b");gragh.addElement("g","c");gragh.addElement("g","e");
		gragh.addElement("g","h");gragh.addElement("h","g");gragh.addElement("h","k");
		gragh.addElement("k","e");gragh.addElement("k","f");gragh.addElement("k","h");
		
		for (Entry<String, Node> entry : gragh.nodes.entrySet()) {
			System.out.println("Padre " + entry.getKey() + "");
			entry.getValue().stack.forEach(item -> System.out.println( item.source ));
			System.out.println();
			System.out.println();	
		}
		
		gragh = new Graph();
		gragh.addElement("0", "29");gragh.addElement("0", "46");gragh.addElement("0", "21");
		gragh.addElement("0", "14");gragh.addElement("0", "38");gragh.addElement("0", "31");
		gragh.addElement("1", "41");gragh.addElement("1", "31");gragh.addElement("1", "21");
		gragh.addElement("1", "17");gragh.addElement("2", "9");gragh.addElement("2", "26");
		gragh.addElement("2", "5");gragh.addElement("2", "25");gragh.addElement("2", "4");
		gragh.addElement("3", "18");gragh.addElement("3", "30");gragh.addElement("3", "47");
		gragh.addElement("4", "28");gragh.addElement("4", "9");gragh.addElement("4", "8");
		gragh.addElement("5", "44");gragh.addElement("5", "12");gragh.addElement("6", "37");
		gragh.addElement("6", "10");gragh.addElement("7", "23");gragh.addElement("7", "22");
		gragh.addElement("7", "39");gragh.addElement("9", "19");gragh.addElement("9", "28");
		gragh.addElement("9", "27");gragh.addElement("11", "33");gragh.addElement("13", "25");
		gragh.addElement("13", "38");gragh.addElement("13", "29");gragh.addElement("14", "26");
		gragh.addElement("14", "28");gragh.addElement("14", "39");gragh.addElement("15", "22");
		gragh.addElement("15", "31");gragh.addElement("15", "19");gragh.addElement("15", "41");
		gragh.addElement("16", "46");gragh.addElement("16", "26");gragh.addElement("16", "38");
		gragh.addElement("16", "27");gragh.addElement("17", "40");gragh.addElement("17", "29");
		gragh.addElement("18", "45");gragh.addElement("18", "42");gragh.addElement("18", "35");
		gragh.addElement("18", "33");gragh.addElement("18", "47");gragh.addElement("20", "36");
		gragh.addElement("20", "49");gragh.addElement("20", "42");gragh.addElement("22", "26");
		gragh.addElement("22", "34");gragh.addElement("23", "31");gragh.addElement("23", "32");
		gragh.addElement("23", "40");gragh.addElement("24", "31");gragh.addElement("24", "44");
		gragh.addElement("25", "38");gragh.addElement("26", "31");gragh.addElement("27", "32");
		gragh.addElement("29", "48");gragh.addElement("29", "41");gragh.addElement("30", "47");
		gragh.addElement("30", "37");gragh.addElement("33", "36");gragh.addElement("33", "49");
		gragh.addElement("34", "48");gragh.addElement("35", "45");gragh.addElement("36", "45");
		gragh.addElement("37", "49");gragh.addElement("37", "45");gragh.addElement("37", "47");
		gragh.addElement("38", "41");gragh.addElement("40", "48");gragh.addElement("41", "44");
		gragh.addElement("42", "49");gragh.addElement("43", "48");gragh.addElement("45", "47");
				
		for (Entry<String, Node> entry : gragh.nodes.entrySet()) {
			System.out.println("Padre " + entry.getKey() + "");
			entry.getValue().stack.forEach(item -> System.out.println( item.source ));
			System.out.println();
			System.out.println();	
		}
	}
}
