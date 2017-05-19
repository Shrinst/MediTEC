package org.meditec.meditecserver.trees;

import org.meditec.meditecserver.model.Doctor;

public class SplayTreeDoctor {
	private Doctor _root;

	public SplayTreeDoctor() {
		_root = null;
	}

	public boolean isEmpty() {
		return this.getRoot() == null;
	}

	public void clear() {
		this.setRoot(null);
	}

	/** function to insert element */

	public void insert(String data, String profileName, int points) {
		Doctor z = this.getRoot();
		Doctor p = null;
		while (z != null) {
			p = z;
			if (data.compareTo(p.getId()) < 0) {
				z = z.getLeft();
			} else {
				z = z.getRight();
			}
		}
		z = new Doctor();
		z.setId(data);
		z.setProfileName(profileName);
		z.setPoints(points);
		z.setParent(p);
		if (p == null) {
			this.setRoot(z);
		} else if (data.compareTo(p.getId()) > 0) {
			p.setRight(z);
		} else {
			p.setLeft(z);
		}
		Splay(z);

	}

	/** rotate **/

	public void makeLeftChildParent(Doctor c, Doctor p) {
		if ((c == null) || (p == null) || (p.getLeft() != c) || (c.getParent() != p)) {
			throw new RuntimeException("WRONG");
		}
		if (p.getParent() != null) {
			if (p == p.getParent().getLeft()) {
				p.getParent().setLeft(c);
			} else {
				p.getParent().setRight(c);
			}
		}
		if (c.getRight() != null) {
			c.getRight().setParent(p);
		}
		c.setParent(p.getParent());
		p.setParent(c);
		p.setLeft(c.getRight());
		c.setRight(p);
	}

	/** rotate **/

	public void makeRightChildParent(Doctor c, Doctor p) {
		if ((c == null) || (p == null) || (p.getRight() != c) || (c.getParent() != p)) {
			throw new RuntimeException("WRONG");
		}
		if (p.getParent() != null) {
			if (p == p.getParent().getLeft()) {
				p.getParent().setLeft(c);
			} else {
				p.getParent().setRight(c);
			}
		}
		if (c.getLeft() != null) {
			c.getLeft().setParent(p);
		}
		c.setParent(p.getParent());
		p.setParent(c);
		p.setRight(c.getLeft());
		c.setLeft(p);
	}

	/** function splay **/

	private void Splay(Doctor x) {
		while (x.getParent() != null) {
			Doctor Parent = x.getParent();
			Doctor GrandParent = Parent.getParent();
			if (GrandParent == null) {
				if (x == Parent.getLeft()) {
					makeLeftChildParent(x, Parent);
				} else {
					makeRightChildParent(x, Parent);
				}
			} else {
				if (x == Parent.getLeft()) {
					if (Parent == GrandParent.getLeft()) {
						makeLeftChildParent(Parent, GrandParent);
						makeLeftChildParent(x, Parent);
					} else {
						makeLeftChildParent(x, x.getParent());
						makeRightChildParent(x, x.getParent());
					}
				} else {
					if (Parent == GrandParent.getLeft()) {
						makeRightChildParent(x, x.getParent());
						makeLeftChildParent(x, x.getParent());
					} else {
						makeRightChildParent(Parent, GrandParent);
						makeRightChildParent(x, Parent);
					}
				}
			}
		}
		this.setRoot(x);
	}

	/** function to remove element **/

	public void remove(String ele) {
		Doctor node = this.find(ele);
		this.remove(node);
	}

	private void remove(Doctor node) {
		if (node == null) {
			return;
		}
		Splay(node);
		if ((node.getLeft() != null) && (node.getRight() != null)) {
			Doctor min = node.getLeft();

			while (min.getRight() != null) {
				min = min.getRight();
			}
			min.setRight(node.getRight());
			node.getRight().setParent(min);
			node.getLeft().setParent(null);
			this.setRoot(node.getLeft());
		} else if (node.getRight() != null) {
			node.getRight().setParent(null);
			this.setRoot(node.getRight());
		} else if (node.getLeft() != null) {
			node.getLeft().setParent(null);
			this.setRoot(node.getLeft());
		} else {
			this.setRoot(null);
		}
		node.setParent(null);
		node.setLeft(null);
		node.setRight(null);
		node = null;
	}

	public Doctor find(String ele) {
		Doctor z = this.getRoot();
		while (z != null) {
			if (ele.compareTo(z.getId()) > 0) {
				z = z.getRight();
			} else if (ele.compareTo(z.getId()) < 0) {
				z = z.getLeft();
			} else {
				this.Splay(z);
				return z;
			}
		}
		return null;
	}

	public Doctor update(String key, Doctor doctor) {
		Doctor z = this.getRoot();
		while (z != null) {
			if (key.compareTo(z.getId()) > 0) {
				z = z.getRight();
			} else if (key.compareTo(z.getId()) < 0) {
				z = z.getLeft();
			} else {
				this.Splay(z);
				z.setId(doctor.getId());
				z.setProfileName(doctor.getProfileName());
				z.setPoints(doctor.getPoints());
				return z;
			}
		}
		return null;
	}

	/** Function for inorder traversal **/

	public void inorder() {
		inorder(this.getRoot());
	}

	private void inorder(Doctor r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.println(r.getPoints());
			inorder(r.getRight());
		}
	}

	public Doctor getRoot() {
		return _root;
	}

	public void setRoot(Doctor root) {
		_root = root;
	}

}
