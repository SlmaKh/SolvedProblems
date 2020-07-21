package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class a_GoodString_CodeForces {
	static char [] alpha = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g' ,'h', 'i', 'j' ,'k' ,'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
	public static int calculateCost(String s ,int idx){
		if(s.length() == 1){
			if (s.charAt(0) == alpha[idx])
				return 0;
			else
				return 1;
		}
		if(s.length() == 0){
			return 0;
			}
		String s1 = s.substring(0, s.length() /2);
		String s2 = s.substring(s.length() /2);
		int x1 = 0;
		int x2 = 0;
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != alpha[idx])
				x1 ++;
			if(s2.charAt(i) != alpha[idx])
				x2 ++;
		}
		return 	Math.min(x1 +calculateCost(s2, idx + 1), x2 +calculateCost(s1, idx + 1));
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			out.println(calculateCost(s, 0));
			
			
		}
		out.flush();
		out.close();
	}
}
