package arbol;
public class Contains extends BinaryTree{
	public boolean Contains(int element){
		return this.Contains(element, this.root);
	}
	private boolean Contains(int element, Node node) {
		if (node == null){
			return false;
		}else{
			if(element < node.element){
				return this.Contains(element, node.left);
			}else if(element > node.element){
				return this.Contains(element, node.right);
			}else{
				return true;
			}
		}
	}
}
