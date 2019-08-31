package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RoundCorridor_CodeForces {

	public static long  gcd(long a , long b){
		if(b==0)
			return a;
		else 
			return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String []temp= br.readLine().split(" ");
		long n = Long.parseLong(temp[0]);
		long m = Long.parseLong(temp[1]);
		int q = Integer.parseInt(temp[2]);
		long gcd=gcd(n,m);
		long g1=n/gcd;
		long g2=m/gcd;
		for (int i = 0; i < q; i++) {
			temp= br.readLine().split(" ");
			int sx= Integer.parseInt(temp[0]);
			long sy = Long.parseLong(temp[1]);
			int ex = Integer.parseInt(temp[2]);
			long ey = Long.parseLong(temp[3]);
			sy--;
			ey--;
			if(sx==1){
				sy/=g1;
			}
			else
				sy/=g2;
			if(ex==1)
				ey/=g1;
			else
				ey/=g2;
			if(sy==ey)
				out.println("YES");
			else
				out.println("NO");
		}

		out.flush();
		out.close();
	}

}
