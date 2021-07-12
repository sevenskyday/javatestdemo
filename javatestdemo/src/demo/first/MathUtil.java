package demo.first;

public class MathUtil {
	private MathUtil() {};
	public static double round(double num ,int scale)
	{
		return Math.round(Math.pow(10, scale)*num/Math.pow(10, scale));
	}

}
