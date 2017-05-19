package org.meditec.meditecserver.lists;

import nodes.Client;

public class ClientList {
	
	private Client _head;
	
	public ClientList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(String clientName, int id, String location, 
			String photo, boolean isRegister){
		Client newNode = new Client(clientName, id, location, photo, isRegister);
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(String clientName, int id, String location, 
			String photo, boolean isRegister){
			Client newNode = new Client(clientName, id, location, photo, isRegister);
			Client temp = _head;
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
				Client temp = _head;
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
			if (this.getHead().getClientName() == element && _head.getNext() == null){
				_head = null;
			}
			else if (this.getHead().getClientName() == element){
				this.deleteFirst();
			}
			else{
				boolean flag = false;
				Client temp = _head;
				while (temp.getNext() != null){
					if (temp.getNext().getClientName() == element){
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
		Client temp =  _head;
		boolean res = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getClientName()==element){
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
		Client temp = _head;
		while (temp!=null){
			cont++;
			temp = temp.getNext();
		}
		return cont;
	}
	

	public Client getHead() {
		return _head;
	}

	public void setHead(Client _head) {
		this._head = _head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			Client temp = _head;
			while (temp!=null){
				System.out.println(temp.getClientName());
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
