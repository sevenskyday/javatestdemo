package demo.first;

import java.util.Arrays;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree<BinaryPerson> bt = new BinaryTree<BinaryPerson>();
		bt.add(new BinaryPerson("СC", 50));
		bt.add(new BinaryPerson("СA", 40));
		bt.add(new BinaryPerson("СB", 80));
		bt.add(new BinaryPerson("СR", 30));
		bt.add(new BinaryPerson("СU", 48));
		bt.add(new BinaryPerson("СH", 60));
		bt.add(new BinaryPerson("СL", 83));
		bt.add(new BinaryPerson("СO", 10));
		bt.add(new BinaryPerson("СN", 35));
		bt.add(new BinaryPerson("СT", 42));
		bt.add(new BinaryPerson("СK", 49));
		bt.add(new BinaryPerson("СW", 85));
		//bt.remove(new BinaryPerson("СA", 40));
		//bt.remove(new BinaryPerson("СL", 83));
		bt.remove(new BinaryPerson("СH", 60));
		bt.remove(new BinaryPerson("СR", 30));
		Object[] data = bt.toArray();
		System.out.println(Arrays.toString(data));
	}
}

/*
 * ���� ��ѯ ��ʱ�临�Ӷ���O��n���� �����������ʹ��2�ֲ��ҷ����� ��õ�������O��logn��
 * 
 * 
 * ���ṹ���� ������ �е�һ�������Ǹ��ڵ� С�ڵ��ڸ��ڵ�������������ڽ��� ���ݷ��ڸ�������������
 * 
 * ǰ�� ���� ����
 */

/**
 * @author XRNY ʵ�ֶ���������
 * @param <T>
 */
class BinaryTree<T extends Comparable<T>> {
	private class Node {

		private Comparable<T> data;
		private Node parent;
		private Node left;
		private Node right;

		public Node(Comparable<T> data) {
			this.data = data;
		}

		public void addNode(Node newNode) {
			if (newNode.data.compareTo((T) this.data) <= 0) {
				if (this.left == null) {
					this.left = newNode;
					newNode.parent = this;
				} else {
					this.left.addNode(newNode);
				}
			} else {
				if (this.right == null) {
					this.right = newNode;
					newNode.parent = this;
				} else {
					this.right.addNode(newNode);
				}
			}
		}

		/**
		 * 
		 */
		public void toArrayNode() {
			System.out.println(BinaryTree.this.count);
			System.out.println(BinaryTree.this.foot);
			System.out.println(this.data.toString());
			
			if (this.left != null) {
				this.left.toArrayNode();
			}
			BinaryTree.this.returnData[BinaryTree.this.foot++] = this.data;
			if (this.right != null) {
				this.right.toArrayNode();
			}
		}
		
		public void toArrayNodeleft() {
			BinaryTree.this.returnData[BinaryTree.this.foot++] = this.data;
			if (this.left != null) {
				this.left.toArrayNodeleft();
			}
			if (this.right != null) {
				this.right.toArrayNodeleft();
			}
		}
		
		public void toArrayNoderight() {
			if (this.left != null) {
				this.left.toArrayNoderight();
			}
			if (this.right != null) {
				this.right.toArrayNoderight();
			}
			BinaryTree.this.returnData[BinaryTree.this.foot++] = this.data;
		}

		public Node getRemoveNode(Comparable<T> data) {
			if (data.compareTo((T) this.data) == 0) {
				return this;
			}

			else if (data.compareTo((T) this.data) < 0) {
				if (this.left != null) {
					return this.left.getRemoveNode(data);
				} else {
					return null;
				}
			} else {
				if (this.right != null) {
					return this.right.getRemoveNode(data);
				} else {
					return null;
				}
			}
		}

		public boolean ContainsNode(Comparable<T> data) {
			// TODO Auto-generated method stub
			if (data.compareTo((T) this.data) == 0) {
				return true;
			}

			else if (data.compareTo((T) this.data) < 0) {
				if (this.left != null) {
					return this.left.ContainsNode(data);
				} else {
					return false;
				}
			} else {
				if (this.right != null) {
					return this.right.ContainsNode(data);
				} else {
					return false;
				}
			}
		}
	}

	// ----------����ʵ��-------------------
	private Node root;
	private int count = 0;
	private Object[] returnData;
	private int foot = 0;// �Ǳ�

	public void add(Comparable<T> data) {
		if (data == null) {
			throw new NullPointerException("������ݲ�����Ϊ��");
		}
		Node newNode = new Node(data);
		if (this.root == null) {
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
		this.count++;
	}

	public Object[] toArray() {
		if (this.count == 0) {
			return null;
		}
		this.returnData = new Object[this.count];
		this.foot = 0;
		this.root.toArrayNode();
		return this.returnData;
	}

	public void remove(Comparable<T> data) {
		if (this.contains(data)) {
			Node removeNode = this.root.getRemoveNode(data);

			if (removeNode != null) {
				if (removeNode.left == null && removeNode.right == null) {
					//�����ĺ��ӹ�ϵ�Ͽ�
					if(removeNode.parent.left==removeNode)
					{
						removeNode.parent.left=null;
					}
					if(removeNode.parent.right==removeNode)
					{
						removeNode.parent.right=null;
					}
					//�͸����Ĺ�ϵ�Ͽ�
					removeNode.parent = null;
					
				} else if (removeNode.left != null && removeNode.right == null) {
					//ֻ��������
					if(removeNode.parent.left==removeNode)
					{
						//ɾ������Ǹ�������������ɾ��������������Ϊ�����µ�������
						removeNode.parent.left=removeNode.left;
					}
					if(removeNode.parent.right==removeNode)
					{    //ɾ������Ǹ�������������ɾ��������������Ϊ�����µ�������
						removeNode.parent.right=removeNode.left;
					}
					//�������ĸ�����Ϊɾ���ڵ�ĸ�����
					removeNode.left.parent = removeNode.parent;
					
				} else if (removeNode.left == null && removeNode.right != null) {
					//ֻ��������
					if(removeNode.parent.left==removeNode)
					{
						//ɾ������Ǹ�������������ɾ��������������Ϊ�����µ�������
						removeNode.parent.left=removeNode.right;
					}
					if(removeNode.parent.right==removeNode)
					{    //ɾ������Ǹ�������������ɾ��������������Ϊ�����µ�������
						removeNode.parent.right=removeNode.right;
					}
					//�������ĸ�����Ϊɾ���ڵ�ĸ�����
					removeNode.right.parent = removeNode.parent;
				} else {
					Node moveNode = removeNode.right;
					// Ѱ��������������㣬��������������С��㡣 
					//��������ΪѰ������������С����
					while (moveNode.left != null) {
						moveNode = moveNode.left;
					}
					//�ƶ����ĸ�����Ҫɾ��������
					moveNode.parent.left = null;
					//ɾ�����ĸ�����Ϊ�ƶ����ĸ���
					moveNode.parent = removeNode.parent;
					//ɾ��������������Ϊ�ƶ�����������
					moveNode.right = removeNode.right;
					//ɾ��������������Ϊ�ƶ�����������
					moveNode.left = removeNode.left;
					if(removeNode.parent.left==removeNode)
					{
						//ɾ������Ǹ��������������ƶ�����Ϊ�����µ�������
						removeNode.parent.left=moveNode;
					}
					if(removeNode.parent.right==removeNode)
					{    //ɾ������Ǹ��������������ƶ�����Ϊ�����µ�������
						removeNode.parent.right=moveNode;
					}
				}
				//ɾ�����֮�������ݼ�
				this.count--;
			}
		}
	}

	public boolean contains(Comparable<T> data) {
		// TODO Auto-generated method stub
		if (this.count == 0) {
			return false;
		}
		return this.root.ContainsNode(data);
	}
}

/**
 * @author XRNY
 *
 */
class BinaryPerson implements Comparable<BinaryPerson> {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BinaryPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 *
	 */
	public String toString() {
		return "����" + this.name + "������" + this.age + "\n";
	}

	public int compareTo(BinaryPerson per) {
		// return this.age-per.age; //����
		return per.age - this.age; // ����
	}
}
