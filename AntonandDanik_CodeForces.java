package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AntonandDanik_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		br.readLine();
		String s = br.readLine();
		int A = 0;
		int D = 0;
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)=='A')
				A++;
			else
				D++;
		}
		if(A > D)
			out.println("Anton");
		else if (D > A)
			out.println("Danik");
		else
			out.println("Friendship");
		out.flush();
		out.close();
	}

}
