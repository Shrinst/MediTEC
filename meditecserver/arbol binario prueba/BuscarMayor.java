package arbol;

public class BuscarMayor extends BinaryTree{
	public Node findMax(){
		if(this.isEmpty()){
			return null;
		}else{
			return findMax(this.root);
		}
	}
	private Node findMax(Node node){
		if(node == null){
			return null;
		}else if(node.right == null){
			return null;
		}else{
			return findMax(node.right);
		}
	}
}

