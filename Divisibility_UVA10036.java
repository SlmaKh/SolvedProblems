package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Divisibility_UVA10036 {
	static int N; // the number of values
	static int K; // the divisible by 
	static byte[][] memo;
	static int []num;
	public static boolean dp(int cur,int index){

		if(index==N){
			return Math.abs(cur)%K==0;
		}
		if(memo[Math.abs(cur%K)][index]!=-1)
			return memo[Math.abs(cur%K)][index]==1;
		boolean add=dp(cur+num[index],index+1);
		boolean sub=dp(cur-num[index],index+1);
		if(add||sub)
			memo[Math.abs(cur%K)][index]=1;
		else 
			memo[Math.abs(cur%K)][index]=0;
		return add||sub;
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		memo=new byte[200][10001];
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int M  = Integer.parseInt(br.readLine());
		for(int m=0;m<M;m++){
			String []r= br.readLine().split(" ");
			N=Integer.parseInt(r[0]);
			K=Integer.parseInt(r[1]);
			num=new int[N];
			r=br.readLine().split(" ");
			for(int i=0;i<N;i++)
				num[i]=Integer.parseInt(r[i]);
			for(int i=0;i<200;i++)
				Arrays.fill(memo[i],(byte)-1);
			System.out.println(dp(0,0)?"Divisible":"Not divisible");
			
		}
	}
}
