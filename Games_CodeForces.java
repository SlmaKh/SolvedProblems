package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Games_CodeForces {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		int home [] = new int[101];
		int guest [] = new int[101];
		int count = 0;
		for (int i = 0; i < n; i++) {
			String [] r = br.readLine().split(" ");
			int h = Integer.parseInt(r[0]);
			int g = Integer.parseInt(r[1]);
			if(home[g] > 0){
				count += home[g];
			}
			if(guest[h] > 0){
				count += guest[h];
			}
			guest[g] ++;
			home[h] ++;
		}
		out.println(count);
		out.flush();
		out.close();
		
	}
}
