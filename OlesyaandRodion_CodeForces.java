package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OlesyaandRodion_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String [] r = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int t = Integer.parseInt(r[1]);
		if(t == 10 && n == 1)
			out.println(-1);
		else{
			out.print(t);
			int count = (t+"").length();
			while(count != n){
				out.print(0);
				count ++;
			}
			
		}
		
		out.flush();
		out.close();
	}
}
