package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class CowsandPrimitiveRoots_CodeForces {

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int p = Integer.parseInt(br.readLine());
		if(p==2){
			System.out.println(1);
			System.exit(0);}
		int count=p-2;

		for(int i=2;i<p;i++){
			if((modPow(i,p-1,p)-1)%p==0){
				for(int j=1;j<=p-2;j++){
					if((modPow(i,j,p)-1)%p==0){
						count--;
						break;
					}
				}
			}
			else{
				count--;
			}
		}
		out.println(count);
		out.flush();
		out.close();

	}

}


