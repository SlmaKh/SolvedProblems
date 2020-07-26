package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Product_UVA10106 {
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(1500);
		while(br.ready()){
			String a = br.readLine();
			String b = br.readLine();
			BigInteger x = new BigInteger(a);
			BigInteger y = new BigInteger(b);
			out.println(x.multiply(y));
		}
		out.flush();
		out.close();
	}
}
