package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ThreePairwiseMaximums_CodeForces {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			String [] r =  br.readLine().split(" ");
			long x = Long.parseLong(r[0]);
			long y = Long.parseLong(r[1]);
			long z = Long.parseLong(r[2]);
			long a = 0;
			long b = 0;
			long c = 0;
			String ans = "";
			if(x == z){
				b = x;
				if(y > x){
					ans = "NO";
				}
				else{
					ans = "YES";
					a = y;
					c = y;
				}
			}
			else if (x == y){
				a = x;
				if(z > x){
					ans = "NO";
				}
				else{
					ans = "YES";
					b = z;
					c = z;
				}
			}
			else if (y == z){
				c = y;
				if(x > y){
					ans = "NO";
				}
				else{
					ans = "YES";
					a = x;
					b = x;
				}
			}
			else{
				ans = "NO";
			}
			
			
			out.println(ans);
			if(ans.equals("YES")){
				StringBuilder res = new StringBuilder();
				res.append(a);
				res.append(" ");
				res.append(b);
				res.append(" ");
				res.append(c);
				out.println(res);
			}
			
		}
		out.flush();
		out.close();
	}
}
