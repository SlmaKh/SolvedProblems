package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PoliceRecruits_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		br.readLine();
		String [] r = br.readLine().split(" ");
		int count = 0;
		int res = 0;
		for (int i = 0; i < r.length; i++) {
			int x = Integer.parseInt(r[i]);
			if(x > 0)
				count += x;
			else{
				if(count <= 0)
					res ++;
				else {
					count --;
				}
			}
		}
		out.println(res);
		out.flush();
		out.close();
		
		
	}

}
