package org.meditec.meditecserver.lists;

import  nodes.Node;

public class List <T>{
	
	private Node<T> _head;
	
	public List(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(T data){
		Node<T> newNode = new Node<T>(data);
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(T data){
		Node<T> newNode = new Node<T>(data);
		if (!(this.isEmpty())){
			Node<T> temp = _head;
			while (temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		else{
			this.setHead(newNode);
		}
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
				Node<T> temp = _head;
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
	
	public void delete(T element){
		if (!this.isEmpty()){
			if (_head.getData() == element && _head.getNext() == null){
				_head = null;
			}
			else if (_head.getData() == element){
				this.deleteFirst();
			}
			else{
				boolean flag = false;
				Node<T> temp = _head;
				while (temp.getNext() != null){
					if (temp.getNext().getData() == element){
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
	
	
	public void isInList(T element){
		Node<T> temp =  _head;
		boolean res = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getData()==element){
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
		Node<T> temp = _head;
		while (temp!=null){
			cont++;
			temp = temp.getNext();
		}
		return cont;
	}
	

	public Node<T> getHead() {
		return _head;
	}

	public void setHead(Node<T> _head) {
		this._head = _head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			Node<T> temp = _head;
			while (temp!=null){
				System.out.println(temp.getData());
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