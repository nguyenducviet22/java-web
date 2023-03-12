package util;

import java.util.Random;

public class VerifiedCode {
	public static String getVerifiedCode() {
		Random rd = new Random();
		String s1 = rd.nextInt(100, 1000) + "";
		String s2 = rd.nextInt(100, 1000) + "";
		String s = s1 + s2;
		
		System.out.println(s);
		return s;
				
	}
}
