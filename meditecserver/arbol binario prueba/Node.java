package arbol;

public class Node {
	int element;
	Node left;
	Node right;
	public Node (int element){
		this(element, null, null);
	}
	public Node (int element, Node left, Node right){
		this.element = element;
		this.left = left;
		this.right = right;
	}

}
