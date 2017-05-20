package org.meditec.meditecserver.trees;

import java.util.ArrayList;

import org.meditec.meditecserver.model.MedicalTest;


public class BinarySearchMedicalTestTree {
	
	private MedicalTest root;	
	private int size;

	public BinarySearchMedicalTestTree() {
		this.root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

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


	public ArrayList<MedicalTest> toArray() {
		ArrayList<MedicalTest> result = new ArrayList<>();
		toArrayHelp(root, result);
		return result;
	}

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
