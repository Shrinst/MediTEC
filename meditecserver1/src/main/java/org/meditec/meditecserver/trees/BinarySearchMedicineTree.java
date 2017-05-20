package org.meditec.meditecserver.trees;

import java.util.ArrayList;

import org.meditec.meditecserver.model.Medicine;

public class BinarySearchMedicineTree {
	
	private Medicine root;	
	private int size;

	public BinarySearchMedicineTree() {
		this.root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(String key, Medicine medicine) {
		Medicine newNode = new Medicine(medicine.getPatient(), medicine.getName(), medicine.getCost(), medicine.getEffect(),
				medicine.getSchedule());

		if (root == null) {
			root = newNode;		
			size++;
		} else {
			Medicine aux = root;
			Medicine parent;

			while (true) {
				parent = aux;

				if (key.compareToIgnoreCase(aux.getPatient()) < 0) {
					aux = aux.get_left();
					if (aux == null) {
						parent.set_left(newNode);						
						size++;
						return;
					}
				} else {
					aux = aux.get_right();
					if (aux == null) {
						parent.set_right(newNode);						
						size++;
						return;
					}
				}
			}
		}
	}

	public Medicine find(String key) {
		Medicine aux = root;

		while (!aux.getPatient().equals(key)) {
			if (key.compareToIgnoreCase(aux.getName()) < 0) {
				aux = aux.get_left();
			} else {
				aux = aux.get_right();
			}

			if (aux == null) {
				return null;
			}
		}
		return aux;
	}

	public Medicine update(String key, Medicine medicine) {
		Medicine aux = root;

		while (!aux.getPatient().equals(key)) {
			if (key.compareToIgnoreCase(aux.getName()) < 0) {
				aux = aux.get_left();
			} else {
				aux = aux.get_right();
			}

			if (aux == null) {
				return null;
			}
		}

		aux.setPatient(medicine.getPatient());
		aux.setName(medicine.getName());
		aux.setEffect(medicine.getEffect());
		aux.setSchedule(medicine.getSchedule());

		return aux;
	}

	public boolean delete(String key) {
		Medicine aux = root;
		Medicine parent = root;
		boolean isLeftChild = true;

		while (!aux.getPatient().equals(key)) {
			parent = aux;

			if (key.compareToIgnoreCase(aux.getPatient()) < 0) {
				isLeftChild = true;
				aux = aux.get_left();
			} else {
				isLeftChild = false;
				aux = aux.get_right();
			}
			if (aux == null) {
				return false;
			}
		}
		if (aux.get_left() == null && aux.get_right() == null) {
			if (aux == root) {
				root = null;
			} else if (isLeftChild) {
				parent.set_left(null);
			} else {
				parent.set_right(null);
			}
		} else if (aux.get_right() == null) {
			if (aux == root) {
				root = aux.get_left();
			} else if (isLeftChild) {
				parent.set_left(aux.get_left());
			} else {
				parent.set_right(aux.get_left());
			}
		} else if (aux.get_left() == null) {
			if (aux == root) {
				root = aux.get_right();
			} else if (isLeftChild) {
				parent.set_left(aux.get_right());
			} else {
				parent.set_right(aux.get_left());
			}
		} else {
			Medicine replacement = getReplacementNode(aux);
			if (aux == root) {
				root = replacement;
			} else if (isLeftChild) {
				parent.set_left(replacement);
			} else {
				parent.set_right(replacement);
			}
			replacement.set_left(aux.get_left());
		}
		return true;
	}

	private Medicine getReplacementNode(Medicine replacementNode) {
		Medicine parentReplacement = replacementNode;
		Medicine replacement = replacementNode;
		Medicine aux = replacementNode.get_right();

		while (aux != null) {
			parentReplacement = replacement;
			replacement = aux;
			aux = aux.get_left();
		}

		if (replacement != replacementNode.get_right()) {
			parentReplacement.set_left(replacement.get_right());
			replacement.set_right(replacementNode.get_right());
		}

		return replacement;
	}

	public void inOrder(Medicine node) {
		if (node != null) {
			inOrder(node.get_left());
			System.out.println(node.getName());
			inOrder(node.get_right());
		}
	}	


	public ArrayList<Medicine> toArray() {
		ArrayList<Medicine> result = new ArrayList<>();
		toArrayHelp(root, result);
		return result;
	}

	private void toArrayHelp(Medicine ref, ArrayList<Medicine> result) {
		if (ref == null) {
			return;
		}
		toArrayHelp(ref.get_left(), result);
		result.add(ref);
		toArrayHelp(ref.get_right(), result);
	}	
	
	public Medicine getRoot() {
		return this.root;
	}

	public int getSize() {
		return size;
	}	
}
