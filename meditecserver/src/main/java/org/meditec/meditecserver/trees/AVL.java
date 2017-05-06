package org.meditec.meditecserver.trees;

import java.util.LinkedList;
import java.util.Queue;

public class AVL<T extends Comparable<T>> {

	NodeBSAVL<T> _root;

	public AVL() {
		_root = null;
	}

	public T Maximum() {
		NodeBSAVL<T> temp = this.getRoot();
		if (temp == null) {
			return null;
		}
		while (temp.getRight() != null) {
			temp = temp.getRight();
		}
		return temp.getData();
	}

	public T Minimum() {
		NodeBSAVL<T> temp = this.getRoot();
		if (temp == null) {
			return null;
		}
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp.getData();
	}

	private int depth(NodeBSAVL<T> node) {
		if (node == null) {
			return 0;
		}
		return node.getDepth();
		// 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
	}

	public NodeBSAVL<T> insert(T data) {
		this.setRoot(insert(this.getRoot(), data));
		switch (balanceNumber(this.getRoot())) {
		case 1:
			this.setRoot(rotateLeft(this.getRoot()));
			break;
		case -1:
			this.setRoot(rotateRight(this.getRoot()));
			break;
		default:
			break;
		}
		return this.getRoot();
	}

	private NodeBSAVL<T> insert(NodeBSAVL<T> node, T data) {
		if (node == null)
			return new NodeBSAVL<T>(data);
		if (node.getData().compareTo(data) > 0) {
			node = new NodeBSAVL<T>(node.getData(), insert(node.getLeft(), data), node.getRight());
			// node.setLeft(insert(node.getLeft(), data));
		} else if (node.getData().compareTo(data) < 0) {
			// node.setRight(insert(node.getRight(), data));
			node = new NodeBSAVL<T>(node.getData(), node.getLeft(), insert(node.getRight(), data));
		}
		// After insert the new node, check and rebalance the current node if
		// necessary.
		switch (balanceNumber(node)) {
		case 1:
			node = rotateLeft(node);
			break;
		case -1:
			node = rotateRight(node);
			break;
		default:
			return node;
		}
		return node;
	}

	private int balanceNumber(NodeBSAVL<T> node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	private NodeBSAVL<T> rotateLeft(NodeBSAVL<T> node) {
		NodeBSAVL<T> q = node;
		NodeBSAVL<T> p = q.getRight();
		NodeBSAVL<T> c = q.getLeft();
		NodeBSAVL<T> a = p.getLeft();
		NodeBSAVL<T> b = p.getRight();
		q = new NodeBSAVL<T>(q.getData(), c, a);
		p = new NodeBSAVL<T>(p.getData(), q, b);
		return p;
	}

	private NodeBSAVL<T> rotateRight(NodeBSAVL<T> node) {
		NodeBSAVL<T> q = node;
		NodeBSAVL<T> p = q.getLeft();
		NodeBSAVL<T> c = q.getRight();
		NodeBSAVL<T> a = p.getLeft();
		NodeBSAVL<T> b = p.getRight();
		q = new NodeBSAVL<T>(q.getData(), b, c);
		p = new NodeBSAVL<T>(p.getData(), a, q);
		return p;
	}

	public boolean search(T data) {
		NodeBSAVL<T> local = this.getRoot();
		while (local != null) {
			if (local.getData().compareTo(data) == 0)
				return true;
			else if (local.getData().compareTo(data) > 0)
				local = local.getLeft();
			else
				local = local.getRight();
		}
		return false;
	}

	public String toString() {
		return this.getRoot().toString();
	}

	public void PrintTree() {
		this.getRoot().setLevel(0);
		Queue<NodeBSAVL<T>> queue = new LinkedList<NodeBSAVL<T>>();
		queue.add(this.getRoot());
		while (!queue.isEmpty()) {
			NodeBSAVL<T> node = queue.poll();
			System.out.println(node);
			int level = node.getLevel();
			NodeBSAVL<T> left = node.getLeft();
			NodeBSAVL<T> right = node.getRight();
			if (left != null) {
				left.setLevel(level + 1);
				queue.add(left);
			}
			if (right != null) {
				right.setLevel(level + 1);
				queue.add(right);
			}
		}
	}

	public NodeBSAVL<T> getRoot() {
		return _root;
	}

	public void setRoot(NodeBSAVL<T> node) {
		_root = node;
	}

}
