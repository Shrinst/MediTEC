package org.meditec.meditecserver.trees;

import java.util.ArrayList;

import org.meditec.meditecserver.model.MedicalTest;

/**
 * 
 * @author Alejandro
 *
 */
public class BinarySearchMedicalTestTree {
	
	private MedicalTest root;	
	private int size;

	/**
	 * Initializes the tree
	 */
	public BinarySearchMedicalTestTree() {
		this.root = null;
	}

	/**
	 * 
	 * @return true if tree is empty, false if it is not empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Inserts a new node to the tree 
	 * @param key
	 * @param medicalTest
	 */
	public void insert(String key, MedicalTest medicalTest) {
		MedicalTest newNode = new MedicalTest(medicalTest.getPatientName(),
				medicalTest.getType(), medicalTest.getResult(), medicalTest.getCost());

		if (root == null) {
			root = newNode;		
			size++;
		} else {
			MedicalTest aux = root;
			MedicalTest parent;

			while (true) {
				parent = aux;

				if (key.compareTo(aux.getPatientName()) < 0) {
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
	 * Searches for a node with one specific data
	 * @param key
	 * @return a node with an specific key
	 */
	public MedicalTest find(String key) {
		MedicalTest aux = root;

		while (!aux.getPatientName().equals(key)) {
			if (key.compareTo(aux.getPatientName()) < 0) {
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
	 * @param medicalTest
	 * @return the node with it's updated data
	 */
	public MedicalTest update(String key, MedicalTest medicalTest) {
		MedicalTest aux = root;

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
		
		aux.setPatientName(medicalTest.getPatientName());
		aux.setType(medicalTest.getType());
		aux.setResult(medicalTest.getResult());
		aux.setCost(medicalTest.getCost());

		return aux;
	}

	/**
	 * Deletes a node of the tree
	 * @param key
	 * @return true if it finds the node to delete,  else false
	 */
	public boolean delete(String key) {
		MedicalTest aux = root;
		MedicalTest parent = root;
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
			MedicalTest replacement = getReplacementNode(aux);
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
	
	/**
	 * Replaces a node in the tree
	 * @param replacementNode
	 * @return the new node
	 */
	private MedicalTest getReplacementNode(MedicalTest replacementNode) {
		MedicalTest parentReplacement = replacementNode;
		MedicalTest replacement = replacementNode;
		MedicalTest aux = replacementNode.get_right();

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
	 * 
	 * @return an array with the nodes of the tree
	 */
	public ArrayList<MedicalTest> toArray() {
		ArrayList<MedicalTest> result = new ArrayList<>();
		toArrayHelp(root, result);
		return result;
	}

	/**
	 * Inserts the nodes of the tree in the array
	 * @param ref
	 * @param result
	 */
	private void toArrayHelp(MedicalTest ref, ArrayList<MedicalTest> result) {
		if (ref == null) {
			return;
		}
		toArrayHelp(ref.get_left(), result);
		result.add(ref);
		toArrayHelp(ref.get_right(), result);
	}	
	
	public MedicalTest getRoot() {
		return this.root;
	}

	public int getSize() {
		return size;
	}	

}

