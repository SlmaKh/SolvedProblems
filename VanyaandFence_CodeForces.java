package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class VanyaandFence_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String [] r = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int h = Integer.parseInt(r[1]);
		int total = 0;
		r = br.readLine().split(" ");
		for(int i=0; i < r.length;i++){
			int x = Integer.parseInt(r[i]);
			if(x > h)
				total += 2;
			else
				total += 1;
		}
		out.println(total);
		out.flush();
		out.close();
	
	}

}
