package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArpashardexamandMehrdadsnaivecheat_CodeForces {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long n = Long.parseLong(br.readLine());
		if(n == 0)
			out.println(1);
		else
			out.println((int)Math.pow(8, n%4==0?4:n%4)%10);
		out.flush();
		out.close();
	}

}
