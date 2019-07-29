package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatreSquare_CodeForces {
	public static void main(String []args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s1 = b.readLine();
		String []s=s1.split(" ");
		long n = Long.parseLong(s[0]);
		long m = Long.parseLong(s[1]);
		long a = Long.parseLong(s[2]);
		long x=(long) Math.ceil((double)n/a);
		long y =(long)Math.ceil((double)m/a);
		//System.out.println(n);
		//System.out.println(m);
		//System.out.println(a);
		System.out.println(x*y);
		
	}

}
