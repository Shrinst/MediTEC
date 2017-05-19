package org.meditec.meditecserver.lists;

import nodes.Message;

public class MessageList {
	
	private Message _head;
	
	public MessageList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(long id, String message, String author){
		Message newNode = new Message(id, message, author);
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(long id, String message, String author){
			Message newNode = new Message(id, message, author);
			Message temp = _head;
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
				Message temp = _head;
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
	
	public void delete(long element){
		if (!this.isEmpty()){
			if (this.getHead().getId() == element && _head.getNext() == null){
				_head = null;
			}
			else if (this.getHead().getId() == element){
				this.deleteFirst();
			}
			else{
				boolean flag = false;
				Message temp = _head;
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
	
	
	public void isInList(long element){
		Message temp =  _head;
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
		Message temp = _head;
		while (temp!=null){
			cont++;
			temp = temp.getNext();
		}
		return cont;
	}
	

	public Message getHead() {
		return _head;
	}

	public void setHead(Message _head) {
		this._head = _head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			Message temp = this.getHead();
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
