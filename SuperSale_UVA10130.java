package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuperSale_UVA10130 {
	static int prices[];
	static int weights[];
	static int people[];
	static int g; // no of people
	static int n;// no of items
	static int [][]memo;

	public static int dp (int index,int rem){
		if(rem<0)
			return Integer.MIN_VALUE;
		if(index==n)
			return 0;
		if(memo[index][rem]!=-1)
			return memo[index][rem];
		int take= prices[index]+dp(index+1,rem-weights[index]);
		int leave=dp(index+1,rem);
		return  memo[index][rem]=Math.max(take, leave);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			n=Integer.parseInt(br.readLine());
			prices=new int [n];
			weights=new int [n];
			for(int i=0;i<n;i++ ){
				String []temp=br.readLine().split(" ");
				prices[i]=Integer.parseInt(temp[0]);
				weights[i]=Integer.parseInt(temp[1]);
			}
			g=Integer.parseInt(br.readLine());
			people=new int[g];
			int max=0;
			for(int i=0;i<g;i++){
				people[i]=Integer.parseInt(br.readLine());
				if(people[i]>max)
					max=people[i];
			}
			memo=new int[n][max+1];
			for(int i=0;i<n;i++){
					Arrays.fill(memo[i], -1);
				}
			int total=0;
			for(int i=0;i<people.length;i++){
				total+=dp(0,people[i]);
				
			}
			System.out.println(total);
		}
	}
}

