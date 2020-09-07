package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IWannaBetheGuy_CodeForces {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		boolean[]found = new boolean[n + 1];
		String []r = br.readLine().split(" ");
		for (int i = 1; i < r.length; i++) {
			found[Integer.parseInt(r[i])] = true;
		}
		r = br.readLine().split(" ");
		for (int i = 1; i < r.length; i++) {
			found[Integer.parseInt(r[i])] = true;
		}
		String res = "";
		for (int i = 1; i <= n; i++) {
			if(!found[i]){
				res = "Oh, my keyboard!";
			}
		}
		if(res.isEmpty()){
			res = "I become the guy.";
		}
		out.println(res);
		out.flush();
		out.close();
	}

}
