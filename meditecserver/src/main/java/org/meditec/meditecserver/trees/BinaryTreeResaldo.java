package org.meditec.meditecserver.trees;

public class BinaryTreeResaldo {
	
	private NodeTree root;
	private int size;

	public BinaryTreeResaldo() {
		this.root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int d, String nom) {
		NodeTree newNode = new NodeTree(d, nom);				
		
		if (root == null) {
			root = newNode;
		} else {
			NodeTree aux = root;
			NodeTree parent;
			
			while (true) {
				parent = aux;
				
				if (d < aux.data) {
					aux = aux.leftChild;
					if (aux == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					aux = aux.rightChild;
					if (aux == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}	
	}
	
	public NodeTree find(int d) {
		NodeTree aux = root;
		
		while (aux.data != d) {
			if (d < aux.data) {
				aux = aux.leftChild;
			} else {
				aux = aux.rightChild;
			}
			
			if (aux == null) {
				return null;
			}
		}
		return aux;
	}
	
	public boolean eliminar(int d) {
		NodeTree aux = root;
		NodeTree parent = root;		
		boolean isLeftChild = true;
		
		while (aux.data != d) {
			parent = aux;
			
			if (d < aux.data) {
				isLeftChild = true;
				aux = aux.leftChild;
			} else {
				isLeftChild = false;
				aux = aux.rightChild;
			}			
			if (aux == null) {
				return false;
			}
		}
		if (aux.leftChild == null && aux.rightChild == null) {
			if (aux == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (aux.rightChild == null) {
			if (aux == root) {
				root = aux.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = aux.leftChild;
			} else {
				parent.rightChild = aux.leftChild;
			}
		} else if (aux.leftChild == null) {
			if (aux == root) {
				root = aux.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = aux.rightChild;
			} else {
				parent.rightChild = aux.leftChild;
			}
		} else {
			NodeTree replacement = getReplacementNode(aux);
			if (aux == root) {
				root = replacement;
			} else if (isLeftChild) {
				parent.leftChild = replacement;
			} else {
				parent.rightChild = replacement;
			}
			replacement.leftChild = aux.leftChild;
		}
		return true;
	}
	
	private NodeTree getReplacementNode(NodeTree replacementNode) {
		NodeTree parentReplacement = replacementNode;
		NodeTree replacement = replacementNode;
		NodeTree aux = replacementNode.rightChild;
		
		while (aux != null) {
			parentReplacement = replacement;
			replacement = aux;
			aux = aux.leftChild;
		}
		
		if (replacement != replacementNode.rightChild) {
			parentReplacement.leftChild = replacement.rightChild;
			replacement.rightChild = replacementNode.rightChild;
		}
		
		return replacement;
	}
	
	public void inOrder(NodeTree node) {
		if (node != null) {
			inOrder(node.leftChild);
			System.out.println(node.name);
			inOrder(node.rightChild);
		}
	}
	
	public NodeTree getRoot() {
		return this.root;
	}
	
	public int getSize() {
		return size;
	}
}
