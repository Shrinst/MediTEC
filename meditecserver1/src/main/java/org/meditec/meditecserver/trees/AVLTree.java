package org.meditec.meditecserver.trees;

public class AVLTree {
	
	private NodeTreeAVL root;
	
	public AVLTree() {
		this.root = null;
	}
	
	public NodeTreeAVL find(int d, NodeTreeAVL r) {
		if (root == null) {
			return null;
		} else if (r.getData() == d) {
			return r;
		} else if (r.getData() < d) {
			return find(d, r.getLeftChild());
		} else {
			return find(d, r.getRightChild());
		}
	}
	
	public int getBalanceFactor(NodeTreeAVL x) {
		if (x == null) {
			return -1;
		} else {
			return x.getBalanceFactor();
		}
	}
	
	public NodeTreeAVL simpleLeftRotation(NodeTreeAVL c) {
		NodeTreeAVL aux = c.getLeftChild();
		c.setLeftChild(aux.getRightChild());
		aux.setRightChild(c);
		c.setBalanceFactor(Math.max(getBalanceFactor(c.getLeftChild()), getBalanceFactor(c.getRightChild())) + 1);
		aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeftChild()), getBalanceFactor(aux.getRightChild())) + 1);
		return aux;
	}
	
	public NodeTreeAVL simpleRightRotation(NodeTreeAVL c) {
		NodeTreeAVL aux = c.getRightChild();
		c.setRightChild(aux.getLeftChild());
		aux.setLeftChild(c);
		c.setBalanceFactor(Math.max(getBalanceFactor(c.getLeftChild()), getBalanceFactor(c.getRightChild())) + 1);
		aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeftChild()), getBalanceFactor(aux.getRightChild())) + 1);
		return aux;
	}
	
	public NodeTreeAVL doubleLeftRotation(NodeTreeAVL c) {
		NodeTreeAVL temp;
		c.setLeftChild(simpleRightRotation(c.getLeftChild()));
		temp = simpleLeftRotation(c);
		return temp;
	}
	
	public NodeTreeAVL doubleRightRotation(NodeTreeAVL c) {
		NodeTreeAVL temp;
		c.setRightChild(simpleLeftRotation(c.getRightChild()));
		temp =  simpleRightRotation(c);
		return temp;
	}
	
	public NodeTreeAVL insert(NodeTreeAVL newNode, NodeTreeAVL subTree) {
		NodeTreeAVL newParent = subTree;
		
		if (newNode.getData() < subTree.getData()) {
			if (subTree.getLeftChild() == null) {
				subTree.setLeftChild(newNode);
			} else {
				subTree.setLeftChild(insert(newNode, subTree.getLeftChild()));
				if ((getBalanceFactor(subTree.getLeftChild()) - getBalanceFactor(subTree.getRightChild())) == 2) {
					if (newNode.getData() < subTree.getLeftChild().getData()) {
						newParent = simpleLeftRotation(subTree);
					} else {
						newParent = doubleLeftRotation(subTree);
					}
				}
			}
		} else if(newNode.getData() > subTree.getData()) {
			if (subTree.getRightChild() == null) {
				subTree.setRightChild(newNode);
			} else {
				subTree.setLeftChild(insert(newNode, subTree.getRightChild()));
				if ((getBalanceFactor(subTree.getRightChild()) - getBalanceFactor(subTree.getLeftChild())) == 2) {
					if (newNode.getData() > subTree.getRightChild().getData()) {
						newParent = simpleRightRotation(subTree);
					} else {
						newParent = doubleRightRotation(subTree);
					}
				}
			}
		} else {
			System.out.println("Duplicated Node");
		}
		
		// Update height
		if ((subTree.getLeftChild() == null) && (subTree.getRightChild() != null)) {
			subTree.setBalanceFactor(subTree.getRightChild().getBalanceFactor() + 1);
		} else if ((subTree.getRightChild() == null) && (subTree.getLeftChild() != null)) {
			subTree.setBalanceFactor(subTree.getLeftChild().getBalanceFactor() + 1);
		} else {
			subTree.setBalanceFactor(Math.max(getBalanceFactor(subTree.getLeftChild()), getBalanceFactor(subTree.getRightChild())) + 1);
		}
		
		return newNode;
	}
	
	public void insert(int d) {
		NodeTreeAVL newNode = new NodeTreeAVL(d);
		
		if (root == null) {
			root = newNode;
		} else {
			root = insert(newNode, root);
		}
	}
	
	public void inOrder(NodeTreeAVL r) {
		if (r != null) {
			inOrder(r.getLeftChild());
			System.out.println(r.getData() + ", ");
			inOrder(r.getRightChild());
		}		
	}
	
	public void preOrder(NodeTreeAVL r) {
		if (r != null) {
			System.out.println(r.getData() + ", ");
			preOrder(r.getLeftChild());
			preOrder(r.getRightChild());
		}
	}
	
	public void postOrder(NodeTreeAVL r) {
		if (r != null) {
			postOrder(r.getLeftChild());
			postOrder(r.getRightChild());
			System.out.println(r.getData() + ", ");
		}
	}
	
	public NodeTreeAVL getRoot() {
		return root;
	}
}
