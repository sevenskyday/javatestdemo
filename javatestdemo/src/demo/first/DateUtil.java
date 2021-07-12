package demo.first;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private DateUtil() {};
	public static String ToyyyMMddHHmmss(Date date)
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	public static String ToyyyMMddHHmmss(long date)
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
}
