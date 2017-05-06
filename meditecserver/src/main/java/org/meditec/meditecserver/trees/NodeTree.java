package org.meditec.meditecserver.trees;

public class NodeTree {
	
	public int data;
	String name;
	NodeTree leftChild, rightChild;
	
	public NodeTree(int d, String name) {
		this.data = d;
		this.name = name;
		this.leftChild = null;
		this.rightChild = null;
	}
}
