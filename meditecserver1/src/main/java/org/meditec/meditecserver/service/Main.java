package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.trees.BinarySearchClinicalTree;

public class Main {

	public static void main(String[] args) {
		BinarySearchClinicalTree binarySearch = new BinarySearchClinicalTree();
		
		binarySearch.insert("Gabriela", new ClinicalCase("Gabriela", "Alejandra", "Gripa"));
		binarySearch.insert("Gabriel", new ClinicalCase("Gabriel", "Alejandro", "Gripe"));
		binarySearch.insert("Gabi", new ClinicalCase("Gabi", "Alejo", "Gri"));
		binarySearch.insert("Ga", new ClinicalCase("Ga", "Ale", "Ge"));
		binarySearch.insert("Ga", new ClinicalCase("Ga", "Ale", "Ge"));
		
		//binarySearch.update("Ga", new ClinicalCase("Ga", "Alex", "Ge"));
		
		//binarySearch.inOrderWithoutRecursion();
		
		System.out.println(binarySearch.getSize());
		
		binarySearch.delete("Gabriela");
		binarySearch.delete("Ga");
		binarySearch.delete("Ga");
		binarySearch.delete("Gabriel");
		binarySearch.delete("Gabi");
		
		System.out.println(binarySearch.getSize());
		binarySearch.inOrder(binarySearch.getRoot());
		
	}
}
