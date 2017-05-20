package org.meditec.meditecserver.trees;

import java.util.ArrayList;

/**
 *@author Alejandro
 * 
 **/

import org.meditec.meditecserver.model.Appointment;

/**
 * 
 * @author Alejandro
 *
 */
public class AVLTreeAppointment {
	Appointment _root;

	/**
	 * Initialize the tree
	 **/
	public AVLTreeAppointment() {
		_root = null;
	}
	
	/** 
	 * @return the biggest data in the tree
	 */
	public String Maximum() {
		Appointment temp = this.getRoot();
		if (temp == null){
			return null;
		}
		while (temp.getRight() != null){
			temp = temp.getRight();
		}
		return temp.getPatientName();
	}
	
	/**
	 * 
	 * @return the minimum data in the tree
	 */
	public String Minimum() {
		Appointment temp = this.getRoot();
		if (temp == null){
			return null;
		}
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp.getPatientName();
	}


	/**
	 * 
	 * @param id
	 * @param patientName
	 * @param doctorId
	 * @param location
	 * @param date
	 * @param symptomps
	 * @param pay
	 * @param is_Active
	 * 
	 * @return the root of the tree
	 */
	public Appointment insert(int id, String patientName, String doctorId, 
			String location, String date, String symptomps, boolean pay, boolean is_Active) {
		
		this.setRoot(insert(this.getRoot(), id, patientName, doctorId, location, date, symptomps, pay, is_Active));
		
		switch (balanceNumber(this.getRoot())) {
		case 1:
			this.setRoot(rotateLeft(this.getRoot(), id, doctorId, location, date, symptomps, pay, is_Active));
			break;
		case -1:
			this.setRoot(rotateRight(this.getRoot(), id, doctorId, location, date, symptomps, pay, is_Active));
			break;
		default:
			break;
		}
		return this.getRoot();
	}
	
	/**
	 * 
	 * @param node
	 * @param id
	 * @param patientName
	 * @param doctorId
	 * @param location
	 * @param date
	 * @param symptomps
	 * @param pay
	 * @param is_Active
	 * 
	 * @return a node recursively to insert a new node
	 */
	private Appointment insert(Appointment node, int id, String patientName, String doctorId, 
			String location, String date, String symptomps, boolean pay, boolean is_Active) {
		if (node == null)
			return new Appointment(patientName, null, null, id, doctorId, location, date, symptomps, pay, is_Active);
		if (node.getId() > id) {
			node.setLeft(insert(node.getLeft(), id, patientName, doctorId, location, date, symptomps, pay, is_Active));
		} else if (node.getId() < id) {
			node.setRight(insert(node.getRight(), id, patientName, doctorId, location, date, symptomps, pay, is_Active)); 
		}
		// After insert the new node, check and rebalance the current node if
		// necessary.
		switch (balanceNumber(node)) {
		case 1:
			node = rotateLeft(node,id, doctorId, location, date, symptomps, pay, is_Active);
			break;
		case -1:
			node = rotateRight(node, id, doctorId, location, date, symptomps, pay, is_Active);
			break;
		default:
			return node;
		}
		return node;
	}

	/**
	 * 
	 * @param node
	 * 
	 * @return a integer that tells if the tree needs to be balance 
	 */
	private int balanceNumber(Appointment node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	/**
	 * 
	 * @param node
	 * @param id
	 * @param doctorId
	 * @param location
	 * @param date
	 * @param symptomps
	 * @param pay
	 * @param is_Active
	 * 
	 * @return a node so it rotates it's nodes recursively to the left
	 */
	private Appointment rotateLeft(Appointment node, int id , String doctorId,
			String location, String date, String symptomps, boolean pay, boolean is_Active) {
		Appointment q = node;
		Appointment p = q.getRight();
		Appointment c = q.getLeft();
		Appointment a = p.getLeft();
		Appointment b = p.getRight();
		q = new Appointment(q.getPatientName(), c, a,id, doctorId, location, date, symptomps, pay, is_Active);
		p = new Appointment(p.getPatientName(), q, b, id, doctorId, location, date, symptomps, pay, is_Active);
		return p;
	}
	
	/**
	 * 
	 * @param node
	 * @param id
	 * @param doctorId
	 * @param location
	 * @param date
	 * @param symptomps
	 * @param pay
	 * @param is_Active
	 * 
	 * @return a node so it rotates it's nodes recursively to the right
	 */
	private Appointment rotateRight(Appointment node, int id , String doctorId,
			String location, String date, String symptomps, boolean pay, boolean is_Active) {
		Appointment q = node;
		Appointment p = q.getLeft();
		Appointment c = q.getRight();
		Appointment a = p.getLeft();
		Appointment b = p.getRight();
		q = new Appointment(q.getPatientName(), b, c,id, doctorId, location, date, symptomps, pay, is_Active);
		p = new Appointment(p.getPatientName(), a, q,id, doctorId, location, date, symptomps, pay, is_Active);
		return p;
	}

	/**
	 * 
	 * @param id
	 * @return the node with the data that's been searched
	 */
	public Appointment search(int id) {
		Appointment local = this.getRoot();
		while (local != null) {
			if (local.getId() == id){
				return local;
			}
			else if (local.getId() > id){
				local = local.getLeft();
			}
			else{
				local = local.getRight();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param key
	 * @param appointment
	 * 
	 * @return a node with it's parameters updated
	 */
	public Appointment update(int key, Appointment appointment) {
		Appointment local = this.getRoot();
		while (local != null) {
			if (local.getId() == key){
				local.setId(appointment.getId());
				local.setPatientName(appointment.getPatientName());
				local.setDoctorId(appointment.getDoctorId());
				local.setSymptomps(appointment.getSymptomps());
				local.setDate(appointment.getDate());
				local.setLocation(appointment.getLocation());
				local.setPay(appointment.isPay());
				local.setIs_Active(appointment.isIs_Active());
				return local;
			}
			else if (local.getId() > key){
				local = local.getLeft();
			}
			else{
				local = local.getRight();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param node
	 * @return the depth of the sub-tree
	 */
	private int depth(Appointment node) {
		if (node == null){
			return 0;
		}
		return node.getDepth();
	}
	
	/**
	 * Calls a private method to print the tree
	 */
    public void inorder(){
        inorder(this.getRoot());
    }

    /**
     * Prints the tree inorder
     * @param r
     */
    private void inorder(Appointment r){
        if (r != null){
            inorder(r.getLeft());
            System.out.println( r.getDoctorId() );
            inorder(r.getRight());
        }
    }
    
    /**
     * Calls a private method
     * @return the array with the nodes of the tree
     */
    public ArrayList<Appointment> toArray() {
		ArrayList<Appointment> result = new ArrayList<>();
		toArrayHelp(_root, result);
		return result;
	}

    /**
     * Inserts the nodes of the tree in an array
     * @param ref
     * @param result
     */
	private void toArrayHelp(Appointment ref, ArrayList<Appointment> result) {
		if (ref == null) {
			return;
		}
		toArrayHelp(ref.getLeft(), result);
		result.add(ref);
		toArrayHelp(ref.getRight(), result);
	}

	
	public Appointment getRoot(){
		return _root;
	}
	
	public void setRoot(Appointment node){
		_root = node;
	}
	
}
