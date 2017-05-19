package org.meditec.meditecserver.lists;

import nodes.Doctor;

public class DoctorList {
	private Doctor _head;
	
	public DoctorList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(String id, String profileName, int points){
		Doctor newNode = new Doctor(id, profileName, points);
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(String id, String profileName, int points){
			Doctor newNode = new Doctor(id, profileName, points);
			Doctor temp = _head;
			while (temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}

	
	
	
	public void deleteFirst(){
		if (!(this.isEmpty())){
			this.setHead(this.getHead().getNext());
		}
		else{
			System.out.println("List is empty");
		}
	}
	
	
	public void deleteLast(){
		if (!(this.isEmpty())){
			if (this.len()!=1){
				Doctor temp = _head;
				while (temp.getNext().getNext()!=null){
					temp = temp.getNext();
				}
				temp.setNext(null);
			}
			else{
				this.setHead(null);
			}
		}
		else{
			System.out.println("List is empty");
		}
	}
	
	public void delete(String element){
		if (!this.isEmpty()){
			if (this.getHead().getId() == element && _head.getNext() == null){
				_head = null;
			}
			else if (this.getHead().getId() == element){
				this.deleteFirst();
			}
			else{
				boolean flag = false;
				Doctor temp = _head;
				while (temp.getNext() != null){
					if (temp.getNext().getId() == element){
						temp.setNext(temp.getNext().getNext());
						flag = true;
						break;
					}
					else{
						temp = temp.getNext();
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
	
	
	public void isInList(String element){
		Doctor temp =  _head;
		boolean res = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getId()==element){
					res = true;
					temp = null;
				}
				else{
					temp = temp.getNext();
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
		Doctor temp = _head;
		while (temp!=null){
			cont++;
			temp = temp.getNext();
		}
		return cont;
	}
	

	public Doctor getHead() {
		return _head;
	}

	public void setHead(Doctor _head) {
		this._head = _head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			Doctor temp = this.getHead();
			while (temp!=null){
				System.out.println(temp.getId());
	/*			System.out.println(" ");
				System.out.println("--> ");*/
				temp = temp.getNext();
			}
		}
		else{
			System.out.println("List is empty");
		}
	

	}

}
