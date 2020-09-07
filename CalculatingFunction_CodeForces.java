package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class CalculatingFunction_CodeForces {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		BigInteger n = new BigInteger(br.readLine());
		BigInteger c1 = new BigInteger("1");
		BigInteger c2 = new BigInteger("2");
		if(!n.mod(c2).equals(c1)){
			out.println(n.divide(c2));
		}
		else{
			out.print("-");
			out.println(n.divide(c2).add(c1));
		}
		out.flush();
		out.close();
	}
}
