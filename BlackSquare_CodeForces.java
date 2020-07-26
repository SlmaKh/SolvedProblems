package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BlackSquare_CodeForces {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String []r = br.readLine().split(" ");
		String s =  br.readLine();
		int []val = new int[4];
		for(int i = 0; i< r.length; i++){
			val[i] = Integer.parseInt(r[i]);
		}
		long res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += val[Integer.parseInt(s.charAt(i)+"") - 1];
		}
		out.println(res);
		out.flush();
		out.close();
		 
		
	}

}
