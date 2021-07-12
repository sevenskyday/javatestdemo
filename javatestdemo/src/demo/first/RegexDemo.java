package demo.first;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*  
 * \t 匹配 制表符
 * \\ 匹配\
 * \n 匹配换行符
 * [abc]  匹配a或b或c
 * [^abc] 匹配
* [a-zA-Z]
* [0-9]  \d
* [^0-9] \D
* . 任意字符
* \s 空格数据 ：空格 换行 制表符
* \S 匹配任意的非空格数据
* \w 匹配字母数字下划线
* \W w的求反
* ^：匹配边界开始
* $ 匹配边界结束
* 表达式？ 0次或一次出现
* 表达式*  任意次
* 表达式+ 1次或
* 表达式{n} 长度n次
* 表达式{n,} 长度大于等于n
* 表达式{n,m} 长度n到m
* 
* XY 表达式X之后是Y
* X|Y X和Y有一个通过即可
* (x) 一个组
* 
* */

public class RegexDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * String str="a"; String Regex="[abcABC]";
		 * System.out.println(str.matches(Regex)); Locale loc=Locale.getDefault();
		 * Locale loc1=Locale.UK; System.out.println(loc); System.out.println(loc1);
		 */
//		ResourceBundle resource=ResourceBundle.getBundle("demo.resources.Demo");
//		String val=resource.getString("message");
//		System.out.println(val);

		String str = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";
		String regex = "\\w+=\"[a-zA-Z0-9,\\+]+\"";
		Matcher matcher = Pattern.compile(regex).matcher(str);
		while (matcher.find()) {
			String temp = matcher.group(0);
			String result[] = temp.split("=");
			System.out.println(result[0] + "\t" + result[1].replace("\"", ""));
		}
	}
}
