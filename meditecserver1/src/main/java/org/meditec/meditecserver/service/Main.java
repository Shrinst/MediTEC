package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.trees.BinarySearchClinicalTree;
import org.meditec.meditecserver.trees.SplayTreeDoctor;

public class Main {

	public static void main(String[] args) {
		
		SplayTreeDoctor splayTreeDoctor = new SplayTreeDoctor();
		
		splayTreeDoctor.insert("1A", "FNSG", 23);
		splayTreeDoctor.insert("1C", "NGKL", 10);
		
		System.out.println(splayTreeDoctor.find("1C").getProfileName());
		
	}
}
