package demo.first;

import java.util.Base64;

/**
 * ���ܴ���
 * 
 * @author XRNY
 *
 */
class StringUtil {
	//�����Ҫ�����ӣ������ȼ�����ֵ��
	//�������ö����ֵ
	//Խ�鷳��Խ�������ƽ�
	private static String SALT = "testdemosalt";//���� ��ֵ
	private static int REPEAT = 3;// ���ܴ���

	/**
	 * ͨ����ֵ���м��ܴ���
	 * 
	 * @param str Ҫ���ܵ�����
	 * @return ���ܺ�� ����
	 */
	public static String encode(String str) {
		// �����ֵ
		String temp = str + "{" + SALT + "}";
		// תΪ�ֽ�
		byte data[] = temp.getBytes();
		// ѭ����λ���
		for (int x = 0; x < REPEAT; x++) {
			data = Base64.getEncoder().encode(data);
		}
		// ���� ���ܺ�� �ַ���
		return new String(data);
	}

	/**
	 * �ַ������ܲ���
	 * 
	 * @param str Ҫ���ܵ��ַ���
	 * @return ���ܺ���ַ���
	 */
	public static String decode(String str) {
		// תΪ�ֽ�
		byte data[] = str.getBytes();
		// ѭ����λ���
		for (int x = 0; x < REPEAT; x++) {
			data = Base64.getDecoder().decode(data);
		}
		String salt="{" + SALT + "}";
		// �����ֵ
		String temp = new String(data);
		
		temp=temp.substring(0,temp.length()-salt.length());
		// ���� ���ܺ�� �ַ���
		return new String(temp);
	}
}

public class Base64Demo {
	public static void main(String args[]) {
		/*
		 * String msg="����������ܺã��ʺϳ�ȥ��ˣ"; String
		 * encMsg=Base64.getEncoder().encodeToString(msg.getBytes());
		 * System.out.println(encMsg); //String
		 * oriMsg=Base64.getDecoder().decode(encMsg).toString(); String oriMsg2=new
		 * String( Base64.getDecoder().decode(encMsg)); //System.out.println(oriMsg);
		 * System.out.println(oriMsg2); }
		 */
		String msg = "����������ܺã��ʺϳ�ȥ��ˣ";
		String encMsg=StringUtil.encode(msg);
		System.out.println(encMsg);
		String oriMsg=StringUtil.decode(encMsg);
		System.out.println(oriMsg); 

	}
}
