package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeTime_UVA10200 {
	static ArrayList<Integer>primes;
	static boolean []isPrime;
	static int [] numPrimes;
	static DecimalFormat df = new DecimalFormat("0.00");
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
	public static boolean isPrime(int N){
		if(N<=1000000)
			return isPrime[N];
		for(int x : primes){
			if(x*x>N)
				return true;
			if(N%x==0)
				return false;
		}
		return true;
	}
	public static void countPrimes(){
		numPrimes[0]=1;
		for(int i=1;i<=10000;i++){
			if(isPrime(formula(i))){
				numPrimes[i]=numPrimes[i-1]+1;
			}
			else
				numPrimes[i]=numPrimes[i-1];
		}
	}
	public static int formula(int n ){
		return (n*n)+n+41;
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		primes = new ArrayList<Integer>();
		isPrime=new boolean[1000001];
		numPrimes=new int[10001];
		getPrimes();
		countPrimes();
		while(br.ready()){
			String [] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);	
			if(b<40){
				System.out.println("100.00");
			}
			else{
				int real = b-a+1;		
				int count=numPrimes[b]-(a==0?0:numPrimes[a-1]);
				double p = ((double)((double)count/(double)real))*100;
				double percentage = Math.round(p*100.0)/100.0;
				if(real==count)
					System.out.println("100.00");
				else if(count==0)
					System.out.println("0.00");
				else{
					if((p+"").length()>5 &&(p+"").charAt(5)=='5'){
						df.setRoundingMode(RoundingMode.CEILING);
						System.out.println(df.format(p));
					}
					else
						System.out.println((percentage+"").length()==4?percentage+"0":percentage+"");
				}
			}
		}
	}
}
