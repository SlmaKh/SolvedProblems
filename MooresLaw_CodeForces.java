package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
public class MooresLaw_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp [] = br.readLine().split(" ");
		int n =Integer.parseInt(temp[0]);
		BigDecimal N = new BigDecimal(n);
		int t = Integer.parseInt(temp[1]);
		BigDecimal inc = new BigDecimal(Math.pow(1.000000011,t));
		BigDecimal ans =inc.multiply(N);
		System.out.println(ans.stripTrailingZeros());
	}

}
	