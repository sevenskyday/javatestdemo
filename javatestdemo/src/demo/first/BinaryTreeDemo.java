package demo.first;

import java.util.Arrays;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree<BinaryPerson> bt = new BinaryTree<BinaryPerson>();
		bt.add(new BinaryPerson("小C", 50));
		bt.add(new BinaryPerson("小A", 40));
		bt.add(new BinaryPerson("小B", 80));
		bt.add(new BinaryPerson("小R", 30));
		bt.add(new BinaryPerson("小U", 48));
		bt.add(new BinaryPerson("小H", 60));
		bt.add(new BinaryPerson("小L", 83));
		bt.add(new BinaryPerson("小O", 10));
		bt.add(new BinaryPerson("小N", 35));
		bt.add(new BinaryPerson("小T", 42));
		bt.add(new BinaryPerson("小K", 49));
		bt.add(new BinaryPerson("小W", 85));
		//bt.remove(new BinaryPerson("小A", 40));
		//bt.remove(new BinaryPerson("小L", 83));
		bt.remove(new BinaryPerson("小H", 60));
		bt.remove(new BinaryPerson("小R", 30));
		Object[] data = bt.toArray();
		System.out.println(Arrays.toString(data));
	}
}

/*
 * 链表 查询 的时间复杂度是O（n）。 或者排序可以使用2分查找方法。 最好的性能是O（logn）
 * 
 * 
 * 数结构定义 二叉树 中第一个数据是根节点 小于等于根节点的左子树。大于结点的 数据放在根结点的右子树。
 * 
 * 前序 中序 后序
 */

/**
 * @author XRNY 实现二叉树操作
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

	// ----------功能实现-------------------
	private Node root;
	private int count = 0;
	private Object[] returnData;
	private int foot = 0;// 角标

	public void add(Comparable<T> data) {
		if (data == null) {
			throw new NullPointerException("添加数据不允许为空");
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
					//父级的孩子关系断开
					if(removeNode.parent.left==removeNode)
					{
						removeNode.parent.left=null;
					}
					if(removeNode.parent.right==removeNode)
					{
						removeNode.parent.right=null;
					}
					//和父级的关系断开
					removeNode.parent = null;
					
				} else if (removeNode.left != null && removeNode.right == null) {
					//只有左子树
					if(removeNode.parent.left==removeNode)
					{
						//删除结点是父级的左子树。删除结点的左子树成为父级新的左子树
						removeNode.parent.left=removeNode.left;
					}
					if(removeNode.parent.right==removeNode)
					{    //删除结点是父级的右子树。删除结点的左子树成为父级新的右子树
						removeNode.parent.right=removeNode.left;
					}
					//左子树的父级变为删除节点的父级。
					removeNode.left.parent = removeNode.parent;
					
				} else if (removeNode.left == null && removeNode.right != null) {
					//只有右子树
					if(removeNode.parent.left==removeNode)
					{
						//删除结点是父级的左子树。删除结点的右子树成为父级新的左子树
						removeNode.parent.left=removeNode.right;
					}
					if(removeNode.parent.right==removeNode)
					{    //删除结点是父级的右子树。删除结点的右子树成为父级新的右子树
						removeNode.parent.right=removeNode.right;
					}
					//右子树的父级变为删除节点的父级。
					removeNode.right.parent = removeNode.parent;
				} else {
					Node moveNode = removeNode.right;
					// 寻找左子树的最大结点，或者右子树的最小结点。 
					//现在设置为寻找右子树的最小左结点
					while (moveNode.left != null) {
						moveNode = moveNode.left;
					}
					//移动结点的父级需要删除该左结点
					moveNode.parent.left = null;
					//删除结点的父级成为移动结点的父级
					moveNode.parent = removeNode.parent;
					//删除结点的右子树成为移动结点的右子树
					moveNode.right = removeNode.right;
					//删除结点的左子树成为移动结点的左子树
					moveNode.left = removeNode.left;
					if(removeNode.parent.left==removeNode)
					{
						//删除结点是父级的左子树。移动结点成为父级新的左子树
						removeNode.parent.left=moveNode;
					}
					if(removeNode.parent.right==removeNode)
					{    //删除结点是父级的右子树。移动结点成为父级新的右子树
						removeNode.parent.right=moveNode;
					}
				}
				//删除结点之后，总数递减
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
		return "姓名" + this.name + "、年龄" + this.age + "\n";
	}

	public int compareTo(BinaryPerson per) {
		// return this.age-per.age; //升序
		return per.age - this.age; // 降序
	}
}
