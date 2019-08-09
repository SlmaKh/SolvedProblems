package acm;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TheSuperPowers_UVA11752 {
	static ArrayList<Integer>primes;
	static boolean [] isPrime;


	public static void getPrimes(){
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;
		for(int i=2;i*i<64;i++){
			if(isPrime[i]){
				for(int j=i*i;j<=64&&j>=0;j+=i)
					isPrime[j]=false;
			}
		}
		for(int i=0;i<isPrime.length;i++)
			if(isPrime[i])
				primes.add(i);
	}
		public static int getPrimeFactors(int N){
			int i=N;
			int idx=0;
			int ans=0;
			int p = primes.get(idx++);
			while(p*p<=i){
				while(i%p==0){
					ans=p;
					i/=p;
				}
				if(ans!=0&&i!=1){
					return -1;
				}
			if(ans!=0 && i==1 && N==ans*ans)
					return -1;
				if(ans!=0 && i==1 && N!=ans*ans)
					return ans;
				p= primes.get(idx++);
			}
			return -1;
		}


	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		primes = new ArrayList<Integer>();
		isPrime = new boolean[65];
		TreeSet<BigInteger>ts = new TreeSet<BigInteger>();
		getPrimes();
		BigInteger base = new BigInteger("2");
		BigInteger upper = base.pow(64); // 2^64
		out.println(1);
			int x=2;
			while(true){
			BigInteger b =new BigInteger(x+"");
			BigInteger power = b.pow(4);
			if(power.compareTo(upper)>=0){
				break;
				}
			for(int i=4;i<64;i++){
				if(!isPrime[i]){
					b =new BigInteger(x+"");
					power = b.pow(i);
					if(power.compareTo(upper)>=0)
						break;
					ts.add(power);
				}
			}
			x++;
		}
		for(BigInteger g: ts)
			out.println(g);
		out.flush();
		out.close();
	}

}
