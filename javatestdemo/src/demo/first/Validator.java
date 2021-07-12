package demo.first;

public class Validator {

	private Validator() {
	};

	public static boolean isEmail(String email) {
		if (email == null || "".equals(email)) {
			return false;
		}
		String regex = "\\w+@\\w+\\.\\w+";
		return email.matches(regex);
	}

	public static boolean isIpAddr(String ip) {
		if (ip == null || "".equals(ip)) {
			return false;
		}
		String regex = "([12]?[0-9]?[0-9]\\.){3}([12]?[0-9]?[0-9])";
		if (ip.matches(regex)) {
			String result[] = ip.split("\\.");
			for (int x = 0; x < result.length; x++) {
				int temp = Integer.parseInt(result[x]);
				if (temp > 255) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
