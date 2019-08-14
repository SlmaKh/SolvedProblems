package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BigMod_UVA374 {
	
	public static long modPow(int a , int e, int mod){ // to calculate ( (a^e)%mod )  
		a%=mod;
		long ans=1;
		while(e>0){
			if(e%2==1){ // if e is odd 
				ans=(ans*a)%mod;
			}
			a=(a*a)%mod;
			e>>=1;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		String s="";
		while(br.ready()){
			int b = Integer.parseInt(br.readLine());
			int p = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());	
			if(p==0)
				out.println(1%m);
			else
				out.println(modPow(b, p, m));
			if(br.ready())
				 s = br.readLine();
		}
		out.flush();
		out.close();
	}

}
