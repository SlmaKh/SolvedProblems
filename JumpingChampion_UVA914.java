package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JumpingChampion_UVA914 {
	static ArrayList<Integer>primes;
	static boolean []isPrime;
	static int [] diff;
	static int max;
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
		for(int i=0;i<primes.size()-1;i++){
			int x = primes.get(i);
			int y = primes.get(i+1);
			int d =Math.abs(x-y);
			diff[d]++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		primes = new ArrayList<Integer>();
		isPrime=new boolean[1000000+1];
		diff=new int [1000000+1];
		getPrimes();
		for(int t=0;t<T;t++){
			String temp []=br.readLine().split(" ");
			int l = Integer.parseInt(temp[0]);
			int u = Integer.parseInt(temp[1]);
			int max=0;
			int [] cur = new int[Math.abs(u-l)+1];
			int idx=0;
			for(int x  : primes){
				if(x>u)
					break;
				if(x>=l && x<=u)
					cur[idx++]=x;
			}
			if(idx==0 || l>=u){
				System.out.println("No jumping champion");
			}
			else{
				int [] freq=new int [u-1+1];
				int maxDiff=0;
				for(int i=0;i<cur.length-1;i++){
					if(cur[i]==0 || cur[i+1]==0)
						break;
					int x=cur[i];
					int y=cur[i+1];

					int d= Math.abs(y-x);
					freq[d]++;
					if(freq[d]>max){
						max=freq[d];
						maxDiff=d;
						}
				}
				boolean flag = true;
				for(int i=0;i<freq.length;i++){
					if(freq[i]==max && i!=maxDiff){
						flag=false;
						break;
					}
				}
				if(!flag){
					System.out.println("No jumping champion");
				}
				else 
					System.out.println("The jumping champion is "+ maxDiff);
			}
		}
	}
}
