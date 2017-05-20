package org.meditec.meditecserver.trees;

import java.util.ArrayList;

import org.meditec.meditecserver.model.ClinicalCase;

/**
 * 
 * @author Alejandro
 *
 */
public class BinarySearchClinicalTree {

	private ClinicalCase root;	
	private int size;

	/**
	 * Initialize the tree
	 */
	public BinarySearchClinicalTree() {
		this.root = null;
	}

	/**
	 * 
	 * @return a boolean if the tree is empty or not 
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Inserts a new node in the tree
	 * @param key
	 * @param clinicalCase
	 */
	public void insert(String key, ClinicalCase clinicalCase) {
		ClinicalCase newNode = new ClinicalCase(clinicalCase.getPatientName(), clinicalCase.getMedicalTest(),
				clinicalCase.getMedicine());

		if (root == null) {
			root = newNode;		
			size++;
		} else {
			ClinicalCase aux = root;
			ClinicalCase parent;

			while (true) {
				parent = aux;

				if (key.compareToIgnoreCase(aux.getPatientName()) < 0) {
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
	
	/**
	 * Searches for a node with an specific key
	 * @param key
	 * @return the node with the specific key
	 */
	public ClinicalCase find(String key) {
		ClinicalCase aux = root;

		while (!aux.getPatientName().equals(key)) {
			if (key.compareToIgnoreCase(aux.getPatientName()) < 0) {
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

	/**
	 * Updates the data of a node
	 * @param key
	 * @param clinicalCase
	 * 
	 * @return the node with it's updated data
	 */
	public ClinicalCase update(String key, ClinicalCase clinicalCase) {
		ClinicalCase aux = root;

		while (!aux.getPatientName().equals(key)) {
			if (key.compareToIgnoreCase(aux.getPatientName()) < 0) {
				aux = aux.get_left();
			} else {
				aux = aux.get_right();
			}

			if (aux == null) {
				return null;
			}
		}

		aux.setPatientName(clinicalCase.getPatientName());
		aux.setMedicalTest(clinicalCase.getMedicalTest());
		aux.setMedicine(clinicalCase.getMedicine());

		return aux;
	}

	/**
	 * Deletes a node of the tree
	 * @param key
	 * @return false if there is no node in the tree with the data, true if it finds it
	 */
	public boolean delete(String key) {
		ClinicalCase aux = root;
		ClinicalCase parent = root;
		boolean isLeftChild = true;

		while (!aux.getPatientName().equals(key)) {
			parent = aux;

			if (key.compareToIgnoreCase(aux.getPatientName()) < 0) {
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
			size--;
		} else if (aux.get_right() == null) {
			if (aux == root) {
				root = aux.get_left();				
			} else if (isLeftChild) {
				parent.set_left(aux.get_left());				
			} else {
				parent.set_right(aux.get_left());				
			}
			size--;
		} else if (aux.get_left() == null) {
			if (aux == root) {
				root = aux.get_right();
			} else if (isLeftChild) {
				parent.set_left(aux.get_right());
			} else {
				parent.set_right(aux.get_left());
			}
			size--;
		} else {
			ClinicalCase replacement = getReplacementNode(aux);
			if (aux == root) {
				root = replacement;
			} else if (isLeftChild) {
				parent.set_left(replacement);
			} else {
				parent.set_right(replacement);
			}
			replacement.set_left(aux.get_left());
			size--;
		}
		return true;
	}
	/**
	 * 
	 * @param replacementNode
	 * @return the replacement node
	 */
	private ClinicalCase getReplacementNode(ClinicalCase replacementNode) {
		ClinicalCase parentReplacement = replacementNode;
		ClinicalCase replacement = replacementNode;
		ClinicalCase aux = replacementNode.get_right();

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

	/**
	 * prints the tree
	 * @param node
	 */
	public void inOrder(ClinicalCase node) {
		if (node != null) {
			inOrder(node.get_left());
			System.out.println(node.getPatientName());
			inOrder(node.get_right());
		}
	}	

	/**
	 * 
	 * @return an array with the nodes of the tree
	 */
	public ArrayList<ClinicalCase> toArray() {
		ArrayList<ClinicalCase> result = new ArrayList<>();
		toArrayHelp(root, result);
		return result;
	}

	/**
	 * Inserts the nodes of the tree in an array
	 * @param ref
	 * @param result
	 */
	private void toArrayHelp(ClinicalCase ref, ArrayList<ClinicalCase> result) {
		if (ref == null) {
			return;
		}
		toArrayHelp(ref.get_left(), result);
		result.add(ref);
		toArrayHelp(ref.get_right(), result);
	}	
	
	public ClinicalCase getRoot() {
		return this.root;
	}

	public int getSize() {
		return size;
	}
}

