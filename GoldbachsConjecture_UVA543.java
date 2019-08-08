package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class GoldbachsConjecture_UVA543 {
	static ArrayList<Integer>primes;
	static boolean []isPrime;
	static HashSet<Integer>p;
	public static void getPrimes(){ // generate all prime numbers less than 1000000  
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;
		for(int i=2;i*i<1000000;i++){
			if(isPrime[i]){
				for(int j=i*i;j<1000000&&j>=0;j+=i)
					isPrime[j]=false;
			}
		}
		for(int i=0;i<isPrime.length;i++)
			if(isPrime[i])
				primes.add(i);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans=new StringBuilder("");
		int n = Integer.parseInt(br.readLine());
		primes = new ArrayList<Integer>();
		isPrime=new boolean[1000000+1];
		getPrimes();
		while(n!=0){ // don't forget to read n again;
			int max=0;
			StringBuilder temp = new StringBuilder("");
			for(int x: primes){
				int y = n-x;
				if(isPrime[y]){
					temp.append(n+" = "+x+" + "+y+"\n");
					break;
				}
			}
			if(temp.equals(""))
				ans.append("Goldbach's conjecture is wrong."+"\n");
			else 
				ans.append(temp);
			n = Integer.parseInt(br.readLine());
		}
		System.out.print(ans);

	}

}
