package demo.first;

import java.util.Locale;
import java.util.ResourceBundle;

/*  
 * \t ƥ�� �Ʊ��
 * \\ ƥ��\
 * \n ƥ�任�з�
 * [abc]  ƥ��a��b��c
 * [^abc] ƥ��
* [a-zA-Z]
* [0-9]  \d
* [^0-9] \D
* . �����ַ�
* \s �ո����� ���ո� ���� �Ʊ��
* \S ƥ������ķǿո�����
* \w ƥ����ĸ�����»���
* \W w����
* ^��ƥ��߽翪ʼ
* $ ƥ��߽����
* ���ʽ�� 0�λ�һ�γ���
* ���ʽ*  �����
* ���ʽ+ 1�λ�
* ���ʽ{n} ����n��
* ���ʽ{n,} ���ȴ��ڵ���n
* ���ʽ{n,m} ����n��m
* 
* XY ���ʽX֮����Y
* X|Y X��Y��һ��ͨ������
* (x) һ����
* 
* */


public class RegexDemo {

	public static void main(String[] args)throws Exception{
		/*
		 * String str="a"; String Regex="[abcABC]";
		 * System.out.println(str.matches(Regex)); Locale loc=Locale.getDefault();
		 * Locale loc1=Locale.UK; System.out.println(loc); System.out.println(loc1);
		 */
		ResourceBundle resource=ResourceBundle.getBundle("demo.resources.Demo");
		String val=resource.getString("message");
		System.out.println(val);
	}
}
