package demo.first;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessagePropertiesUtil {

	public static void main(String[] args) {
		int choose = Integer.parseInt(args[0]);
		MessageUtil util = new MessageUtil();
		System.out.println(util.getMessage(choose));
	}

}

class MessageUtil {

	public static final int CHINA = 1;
	public static final int USA = 2;
	private static final String KEY = "info";
	private static final String BASENAME = "demo.resources.Message";

	public String getMessage(int num) {
		Locale loc = this.getLocale(num);
		if (loc == null) {
			return "Nothing";
		} else {
			return ResourceBundle.getBundle(BASENAME, loc).getString(KEY);
		}
	}

	private Locale getLocale(int num) {
		switch (num) {
		case CHINA:
			return new Locale("zh", "CN");
		case USA:
			return new Locale("en", "US");
		default:
			return null;
		}
	}
}