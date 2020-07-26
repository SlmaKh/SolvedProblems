package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Word_CodeForces {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		int cap = 0;
		int small = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
				cap++;
			}
			else
				small++;
		}
		if(small >= cap)
			s = s.toLowerCase();
		else
			s=s.toUpperCase();
		out.println(s);
		out.flush();
		out.close();
		
		
	}
}
