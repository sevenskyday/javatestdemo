package demo.first;

import java.util.Base64;

/**
 * 加密处理
 * 
 * @author XRNY
 *
 */
class StringUtil {
	//如果想要更复杂，可以先加密盐值。
	//或者设置多个盐值
	//越麻烦，越不容易破解
	private static String SALT = "testdemosalt";//加密 盐值
	private static int REPEAT = 3;// 加密次数

	/**
	 * 通过盐值进行加密处理
	 * 
	 * @param str 要加密的数据
	 * @return 加密后的 数据
	 */
	public static String encode(String str) {
		// 添加盐值
		String temp = str + "{" + SALT + "}";
		// 转为字节
		byte data[] = temp.getBytes();
		// 循环多次机密
		for (int x = 0; x < REPEAT; x++) {
			data = Base64.getEncoder().encode(data);
		}
		// 返回 加密后的 字符串
		return new String(data);
	}

	/**
	 * 字符串解密操作
	 * 
	 * @param str 要解密的字符串
	 * @return 解密后的字符串
	 */
	public static String decode(String str) {
		// 转为字节
		byte data[] = str.getBytes();
		// 循环多次机密
		for (int x = 0; x < REPEAT; x++) {
			data = Base64.getDecoder().decode(data);
		}
		String salt="{" + SALT + "}";
		// 添加盐值
		String temp = new String(data);
		
		temp=temp.substring(0,temp.length()-salt.length());
		// 返回 加密后的 字符串
		return new String(temp);
	}
}

public class Base64Demo {
	public static void main(String args[]) {
		/*
		 * String msg="今天的天气很好，适合出去玩耍"; String
		 * encMsg=Base64.getEncoder().encodeToString(msg.getBytes());
		 * System.out.println(encMsg); //String
		 * oriMsg=Base64.getDecoder().decode(encMsg).toString(); String oriMsg2=new
		 * String( Base64.getDecoder().decode(encMsg)); //System.out.println(oriMsg);
		 * System.out.println(oriMsg2); }
		 */
		String msg = "今天的天气很好，适合出去玩耍";
		String encMsg=StringUtil.encode(msg);
		System.out.println(encMsg);
		String oriMsg=StringUtil.decode(encMsg);
		System.out.println(oriMsg); 

	}
}
