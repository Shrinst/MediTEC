package org.meditec.meditecserver.lists;

import nodes.Medicine;

public class MedicineList {
	
	private Medicine _head;
	
	public MedicineList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(String patient, String name, long cost, 
			String effect, String schedule){
		Medicine newNode = new Medicine(patient, name, cost, effect, schedule);
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(String patient, String name, long cost,
				String effect, String schedule){
			Medicine newNode = new Medicine(patient, name, cost, effect, schedule);
			Medicine temp = _head;
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
				Medicine temp = _head;
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
			if (this.getHead().getName() == element && _head.getNext() == null){
				_head = null;
			}
			else if (this.getHead().getName() == element){
				this.deleteFirst();
			}
			else{
				boolean flag = false;
				Medicine temp = _head;
				while (temp.getNext() != null){
					if (temp.getNext().getName() == element){
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
		Medicine temp =  _head;
		boolean res = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getName()==element){
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
		Medicine temp = _head;
		while (temp!=null){
			cont++;
			temp = temp.getNext();
		}
		return cont;
	}
	

	public Medicine getHead() {
		return _head;
	}

	public void setHead(Medicine _head) {
		this._head = _head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			Medicine temp = this.getHead();
			while (temp!=null){
				System.out.println(temp.getName());
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
