package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class EvenOdds_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[]r = br.readLine().split(" ");
		BigInteger n = new BigInteger(r[0]);
		BigInteger k = new BigInteger(r[1]);
		BigInteger n1 = new BigInteger("1");
		BigInteger n2 = new BigInteger("2");
		BigInteger mid = n.divide(n2);
		
		if(n.mod(n2).equals(n1))
			mid = mid.add(n1);
		if(k.compareTo(mid) <= 0)
			out.println(k.multiply(n2).subtract(n1));
		else{
			k = k.subtract(mid);
			out.println(k.multiply(n2));
		}
		

		out.flush();
		out.close();
	}
}
