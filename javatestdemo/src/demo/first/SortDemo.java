
//java.lang.Comparable ���ඨ���ʱ��ʵ�ֵ� ���ӿڡ��������������Ҫ��compareTo������ʵ�֡�
//java.util.Comparator ��Ҫ�������ñȽ������� ��ʵ��������Ҫ������compare.
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
		return "����" + this.name + "������" + this.age + "\n";
	}

	public int compareTo(SortPerson per) {
		// return this.age-per.age; //����
		return per.age - this.age; // ����
	}
}

class PersonComparator implements Comparator<SortPerson> {

	@Override
	public int compare(SortPerson o1, SortPerson o2) {
		// TODO Auto-generated method stub
		//return o1.getAge() - o2.getAge(); // ����
		return o2.getAge() - o1.getAge(); // ����
	}
	
}


public class SortDemo {
	public static void main(String[] args) {
		SortPerson data[] = new SortPerson[] { new SortPerson("СA", 10), new SortPerson("СB", 11),
				new SortPerson("СC", 14), new SortPerson("СD", 13), new SortPerson("СE", 18) };
		Arrays.sort(data,new PersonComparator());
		// ����Ƚ� ��Ҫ�Ƚ�ǿ���ñȽϹ��򡣻���Comparableʵ��
		System.out.println(Arrays.toString(data));
	}

}
