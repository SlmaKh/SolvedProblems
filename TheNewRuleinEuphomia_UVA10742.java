package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TheNewRuleinEuphomia_UVA10742 {
	
	static ArrayList<Integer>primes;
	static boolean isPrime[];
	static int numPrimes[];
	public static void getPrimes(){
		primes = new ArrayList<Integer>();
		isPrime= new boolean[1000000+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;
		for(int i=2;i*i<=1000000;i++){
			if(isPrime[i]){
				for(int j=i*i;j<=1000000;j+=i){
					isPrime[j]=false;
				}
			}
		}
		for(int i=0;i<isPrime.length;i++)
			if(isPrime[i])
				primes.add(i);
	}
	
	public static void countPrimes(){
		numPrimes = new int [1000000+1];
		for(int i=2;i<numPrimes.length;i++){
			if(isPrime[i]){
				numPrimes[i]=numPrimes[i-1]+1;
			}
			else 
				numPrimes[i]=numPrimes[i-1];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new PrintWriter(System.out);
		int n =Integer.parseInt(br.readLine());
		getPrimes();
		countPrimes();
		int count=0;
		while(n!=0){
			count++;
			int ans=0;
			for(int x:primes){
				if(x>n || n-x < x)
					break;
				ans+=numPrimes[n-x]-numPrimes[x];
			}
			out.println("Case "+count+": "+ans);
			n =Integer.parseInt(br.readLine());	
		}
		out.flush();
		out.close();
	}

}
