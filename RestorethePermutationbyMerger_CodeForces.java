package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RestorethePermutationbyMerger_CodeForces {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			int n = Integer.parseInt(br.readLine());
			String [] r = br.readLine().split(" ");
			int x[] = new int[r.length];
			StringBuilder res = new StringBuilder();
			boolean found [] = new boolean[n + 1]; 
			for(int i = 0; i < r.length ; i++){
				x[i] = Integer.parseInt(r[i]);
			}
			int count = 0;
			for(int i = 0; i < x.length; i++){
				if(!found[x[i]]){
					count ++;
					if(count < n)
						res.append(x[i]+" ");
					else
						res.append(x[i]);
					found[x[i]] = true;
				}
			}
			out.println(res);
			
		}
		out.flush();
		out.close();


	}
}