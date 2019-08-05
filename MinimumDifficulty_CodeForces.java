package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumDifficulty_CodeForces {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] num = new int [n];
		String [] temp = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			num[i]= Integer.parseInt(temp[i]);
		}
		if(n==3){
			System.out.println(num[2]-num[0]);
			System.exit(0);
			}
		int min=Integer.MAX_VALUE;
		for(int i=1;i<n-1;i++){
			int y = num[i];
			num[i]=num[i-1];
			int x = calc(num);
			if(x<min)
				min=x;
			num[i]=y;
		}
		System.out.println(min);
	}
	
	
	public static int calc(int []num){
		int x=0;
		int max=0;
		for(int i=0;i<num.length-1;i++){
			if(num[i+1]-num[i]>max)
				max=num[i+1]-num[i];
		}
		return max;
	}

}
