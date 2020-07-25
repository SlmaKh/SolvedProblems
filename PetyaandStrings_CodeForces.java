package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PetyaandStrings_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s1 = br.readLine().toLowerCase();
		String s2 = br.readLine().toLowerCase();
		if(s1.compareTo(s2) < 0)
			out.println(-1);
		else  if(s1.compareTo(s2) > 0)
			out.println(1);
		else
			out.println(0);
	
		out.flush();
		out.close();
	}

}
