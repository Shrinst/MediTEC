package org.meditec.meditecserver.trees;

public class NodeTreeAVL {
	
	private int data;
	private int balanceFactor;
	private NodeTreeAVL leftChild;
	private NodeTreeAVL rightChild;
	
	public NodeTreeAVL(int data) {
		this.data = data;
		this.balanceFactor = 0;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

	public NodeTreeAVL getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeTreeAVL leftChild) {
		this.leftChild = leftChild;
	}

	public NodeTreeAVL getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeTreeAVL rightChild) {
		this.rightChild = rightChild;
	}
}
