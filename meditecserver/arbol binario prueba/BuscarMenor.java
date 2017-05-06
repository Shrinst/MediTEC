package arbol;

public class BuscarMenor extends BinaryTree {
	public Node findMin(){
		if(this.isEmpty()){
			return null;
		}else{
			return findMin(this.root);
		}
	}
	private Node findMin(Node node){
		if(node == null){
			return null;
		}else if(node.left == null){
			return null;
		}else{
			return findMin(node.left);
		}
	}
}
