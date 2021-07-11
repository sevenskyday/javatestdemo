package demo.first;

public class JavaAPIDemo {
	public static void main(String args[]) { 
		StringBuffer buf= new StringBuffer("Hello ");
		String sb=new String("yes");
		change(buf);
		change(buf);
		buf.insert(2, 100);
		buf.insert(6, "www");
		buf.delete(3, 5);
		buf.reverse();
		change(sb);
		System.out.println(buf);
		System.out.println(sb);
	}
	public static void change(StringBuffer temp)
	{
		temp.append(" World! ");
	}
	public static void change(String temp)
	{
		temp=" World! ";
	}

}
