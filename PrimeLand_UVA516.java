package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class PrimeLand_UVA516 {
	static boolean isPrime[];
	static ArrayList<Integer> primes;
	public static void Sieve(){
		isPrime=new boolean[1000000+1];
		primes= new ArrayList<Integer>();
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;
		for(int i=2;i*i<=1000000;i++){
			if(isPrime[i]){
				for(int j=i*i;j<=1000000;j+=i)
					isPrime[j]=false;
			}
		}
		for(int i=0;i<=1000000;i++){
			if(isPrime[i])
				primes.add(i);
		}
	}

	public static int pow(int a , int e){ // calculates a power e
		int ans = 1;
		while(e>0){
			if(e%2==1)
				ans*=a;
			a*=a;
			e>>=1;
		}
		return ans;
	}
	public static int [] primeFactorPower(int N){ // returns an array of powers of prime factors of N
		int idx=0;
		int[]powers= new int[primes.get(primes.size()-1)+1];// last and largest prime less than or equal to N 
		int p=primes.get(idx++);
		while(p*p<=N){
			while(N%p==0){
				powers[p]++;
				N/=p;
			}
			p=primes.get(idx++);
		}
		if(N!=1)
			powers[N]++;
		return powers;
	}
	public static TreeSet<Integer> primeFactors (int N){ // get all the prime factors of N
		int idx=0;
		int p = primes.get(idx++); // get the first prime then increment the index
		TreeSet<Integer>factors = new TreeSet<Integer>();
		while(p*p<=N){ // loop until the root of N
			while (N%p==0){
				factors.add(p);
				N/=p;
			}
			p=primes.get(idx++);
		}
		if(N!=1) //there is another prime factor which is larger than root N  
			factors.add(N);
		return factors;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		Sieve();
		while(!s.equals("0")){ //reread S   
			String temp []  =s.split(" ");
			int [] num =new int [temp.length];
			for(int i=0;i<temp.length;i++){
				num[i]=Integer.parseInt(temp[i]);
			}
			int x=1;
			for(int i=0;i<num.length;i+=2){
				x*=(pow(num[i],num[i+1]));
			}
			x-=1;
			int []powers = primeFactorPower(x);
			int y=1;
			StringBuilder ans = new StringBuilder("");
			TreeSet<Integer> ts = primeFactors(x);
			for(int c : ts){
				StringBuilder tempo=new StringBuilder(c+" "+powers[c]+" ");
				ans=tempo.append(ans);
			}
			String a = ans.toString();
			a=a.substring(0, ans.length()-1);
			out.println(a);
			s = br.readLine();
		}
		out.flush();
		out.close();
	}

}
