
//java.lang.Comparable 在类定义的时候实现的 父接口。定义排序规则。主要是compareTo方法的实现。
//java.util.Comparator 需要单独设置比较器规则 类实现排序。主要方法是compare.
package demo.first;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author XRNY
 *
 */
class SortPerson implements Comparable<SortPerson> {
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

	public SortPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 *
	 */
	public String toString() {
		return "姓名" + this.name + "、年龄" + this.age + "\n";
	}

	public int compareTo(SortPerson per) {
		// return this.age-per.age; //升序
		return per.age - this.age; // 降序
	}
}

class PersonComparator implements Comparator<SortPerson> {

	@Override
	public int compare(SortPerson o1, SortPerson o2) {
		// TODO Auto-generated method stub
		//return o1.getAge() - o2.getAge(); // 升序
		return o2.getAge() - o1.getAge(); // 降序
	}
	
}


public class SortDemo {
	public static void main(String[] args) {
		SortPerson data[] = new SortPerson[] { new SortPerson("小A", 10), new SortPerson("小B", 11),
				new SortPerson("小C", 14), new SortPerson("小D", 13), new SortPerson("小E", 18) };
		Arrays.sort(data,new PersonComparator());
		// 对象比较 需要比较强设置比较规则。基于Comparable实现
		System.out.println(Arrays.toString(data));
	}

}
