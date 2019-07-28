package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class KefaandDishes_CodeForces{
	static int[][]rules;
	static int sat[];// satisfaction of each dish 
	static int n ;// no of dishes on the menu 
	static int m ; // the number of portions Kefa needs to eat to get full 
	static int k;// the number of eating rules 
	static long [][]memo2;
	
	public static long dp2 (int last,int mask, int numDish){   // last is the last dish taken 
		if(numDish==0)
			return 0;
		if (memo2[last][mask]!=-1){
			return memo2[last][mask];
			}
	
		long max =0;
		for(int i=0;i<n;i++){
			if((mask & (1<<i))==0) 
				max= Math.max(max,(rules[last][i]+sat[i]+dp2(i,mask|(1<<i),numDish-1)));
		}
		return memo2[last][mask]=max;

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String []r = br.readLine().split(" ");
		n = Integer.parseInt(r[0]); 
		m = Integer.parseInt(r[1]); 
		k = Integer.parseInt(r[2]); 
		memo2=new long[n+1][(1<<n)+1];
		for(int i=0;i<n+1;i++){
			Arrays.fill(memo2[i],-1);
		}
		r= br.readLine().split(" ");  //the satisfaction he gets from the i-th dish.
		sat=new int [n]; 
		rules=new int [19][19];
		for (int i=0;i<n;i++){
			sat[i]=Integer.parseInt(r[i]);
		}
		for(int i=0;i<k;i++){
			r= br.readLine().split(" ");
			int n1 = Integer.parseInt(r[0]);
			int n2 =  Integer.parseInt(r[1]);
			rules[n1-1][n2-1]= Integer.parseInt(r[2]);			
		}
		
	    System.out.println(dp2(n,0,m));


	}
}
