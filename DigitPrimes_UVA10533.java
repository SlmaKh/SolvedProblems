package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DigitPrimes_UVA10533 {
	static ArrayList<Integer>primes;
	static boolean []isPrime;
	static int [] primeDigit;
	public static void getPrimes(){ // generate all prime numbers less than 56 
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
	public static void getPrimeDigits(){ // sets the number of prime digits from 0 to a certain number up to 1000000 
		for(int i=2;i<=1000000;i++){
			if(isPrime[i]&& isPrime[sum(i)]){
				primeDigit[i]=primeDigit[i-1]+1;
			}
			else
				primeDigit[i]=primeDigit[i-1];
		}
	}
	public static int sum (int x){
		String s = x+"";
		int ans=0;
		for(int i=0;i<s.length();i++){
			ans+=Integer.parseInt(s.charAt(i)+"");
		}
		return ans;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		primes = new ArrayList<Integer>();
		isPrime=new boolean[1000000+1];
		primeDigit = new int[1000000+1];
		getPrimes();
		getPrimeDigits();
		for(int n=0;n<N;n++){
			String []temp  = br.readLine().split(" ");
			int ans=0;
			int t1 = Integer.parseInt(temp[0]);
			int t2 = Integer.parseInt(temp[1]);
			System.out.println(primeDigit[t2]-primeDigit[t1-1]);
		}
	}
}
