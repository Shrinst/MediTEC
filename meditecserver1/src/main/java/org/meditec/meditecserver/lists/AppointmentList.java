package org.meditec.meditecserver.lists;

import org.meditec.meditecserver.model.Appointment;

public class AppointmentList {
	
	private Appointment _head;
	
	public AppointmentList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
//Appointment(int id, String patientName, String doctorId, 
//				String location, String date, String symptomps, boolean pay) {

	public void insertFirst(String patientName, int id, String doctorId, 
			String location, String date, String symptomps){
		Appointment newNode = new Appointment(id, patientName, doctorId, location, date, symptomps, false);
		if  (!(this.isEmpty())){
			newNode.set_right(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(String patientName, int id, String doctorId, 
			String location, String date, String symptomps){
		Appointment newNode = new Appointment(id, patientName, doctorId, location, date, symptomps, false);
		if (!(this.isEmpty())){
			Appointment temp = _head;
			while (temp.get_right()!=null){
				temp = temp.get_right();
			}
			temp.set_right(newNode);
		}
		else{
			this.setHead(newNode);
		}
	}
	
	
	public void deleteFirst(){
		if (!(this.isEmpty())){
			this.setHead(this.getHead().get_right());
		}
		else{
			System.out.println("List is empty");
		}
	}
	
	
	public void deleteLast(){
		if (!(this.isEmpty())){
			if (this.len()!=1){
				Appointment temp = _head;
				while (temp.get_right().get_right()!=null){
					temp = temp.get_right();
				}
				temp.set_right(null);
			}
			else{
				this.setHead(null);
			}
		}
		else{
			System.out.println("List is empty");
		}
	}
	
	public void delete(int element){
		if (!this.isEmpty()){
			if (this.getHead().get_right().getId() == element && _head.get_right() == null){
				_head = null;
			}
			else if (this.getHead().getId() == element){
				this.deleteFirst();
			}
			else{
				boolean flag = false;
				Appointment temp = _head;
				while (temp.get_right() != null){
					if (temp.get_right().getId() == element){
						temp.set_right(temp.get_right().get_right());
						flag = true;
						break;
					}
					else{
						temp = temp.get_right();
					}
				}
				if (!flag){
					System.out.println("Element hasn't been found in the list");
				}
			}
		}
		
		else{
			System.out.println("List is empty");
		}
	}
	
	
	public void isInList(int element){
		Appointment temp =  _head;
		boolean res = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getId()==element){
					res = true;
					temp = null;
				}
				else{
					temp = temp.get_right();
				}
			}
			System.out.println(res);
		}
		else{
			System.out.println(res);
		}
	}
	
	public int len(){
		int cont = 0;
		Appointment temp = _head;
		while (temp!=null){
			cont++;
			temp = temp.get_right();
		}
		return cont;
	}
	

	public Appointment getHead() {
		return _head;
	}

	public void setHead(Appointment _head) {
		this._head = _head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			Appointment temp = _head;
			while (temp!=null){
				System.out.println(temp.getPatientName());
	/*			System.out.println(" ");
				System.out.println("--> ");*/
				temp = temp.get_right();
			}
		}
		else{
			System.out.println("List is empty");
		}
	}

}
