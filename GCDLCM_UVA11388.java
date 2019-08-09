package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GCDLCM_UVA11388 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t  =0 ;t<T ; t++){
			String [] temp = br.readLine().split(" ");
			long g = Integer.parseInt(temp[0]); // gcd 
			long l = Integer.parseInt(temp[1]); // lcm 
			if(l%g!=0){
				out.println(-1);
			}
			else{
				out.println(g+" "+l);
			}
				
		}
		out.flush();
		out.close();
		
	}

}
