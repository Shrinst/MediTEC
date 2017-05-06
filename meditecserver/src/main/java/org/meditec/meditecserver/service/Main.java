package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.trees.BinarySearchTree;
import org.meditec.meditecserver.trees.NodeTree;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree binarySearch = new BinarySearchTree();
		
		binarySearch.insert("Gabriela", new ClinicalCase("Gabriela", "Alejandra", "Gripa"));
		binarySearch.insert("Gabriel", new ClinicalCase("Gabriel", "Alejandro", "Gripe"));
		binarySearch.insert("Gabi", new ClinicalCase("Gabi", "Alejo", "Gri"));
		binarySearch.insert("Ga", new ClinicalCase("Ga", "Ale", "Ge"));
		
		for (ClinicalCase case1 : binarySearch.toArray()) {
			System.out.println(case1.getPatientName());
		}
		
		for (ClinicalCase case1 : binarySearch.toArray()) {
			System.out.println(case1.getPatientName());
		}
	}
}
