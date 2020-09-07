package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Football_CodeForces {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String s1 = "";
		String s2 = "";
		int c1 = 0;
		int c2 = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if(s1 == ""){
				s1 = s;
			}
			else if(s2 == "" && !s.equals(s1)){
				s2 = s;
			}
			if(s.equals(s1))
				c1++;
			else
				if(s.equals(s2))
					c2++;
		}
		out.println(c1 > c2 ? s1 : s2);
		out.flush();
		out.close();
	}
}
