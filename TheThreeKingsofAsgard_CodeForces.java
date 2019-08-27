package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TheThreeKingsofAsgard_CodeForces {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new  PrintWriter(System.out);
		int T  = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			double n = Double.parseDouble(br.readLine());
			double c = (n+n/2.0)/2.0;
			double b = (n+c)/2.0;
			double a = (n/2.0)+b;
			
			if((long)a+(long)b+(long)c!=(3*n)||a<0||b<0||c<0)
				out.println("Impossible");
			else
				if((long)a!=a ||(long)b!=b ||(long)c!=c)
					out.println("Impossible");
					
			else
				out.println((long)a+" "+(long)b+" "+(long)c);
			
		}
		out.flush();
		out.close();
	}


}
