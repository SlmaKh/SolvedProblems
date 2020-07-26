package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NightattheMuseum_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		char cur = 'a';
		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			total += Math.min(Math.abs(cur - s.charAt(i)),26 - Math.abs( cur - s.charAt(i))); 
			cur = s.charAt(i);
		}
		out.println(total);
		out.flush();
		out.close();
	}
}
