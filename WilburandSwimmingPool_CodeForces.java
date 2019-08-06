package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WilburandSwimmingPool_CodeForces{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==1){
			System.out.println(-1);
			System.exit(0);
		}
		int [] x= new int [n];
		int [] y= new int [n];
		for(int i=0;i<n;i++){
			String temp[]= br.readLine().split(" ");
			x[i]=Integer.parseInt(temp[0]);
			y[i]=Integer.parseInt(temp[1]);
		}
		if(n==2){
			if(x[0]==x[1]||y[0]==y[1]){
				System.out.println(-1);
				System.exit(0);
			}
			int w = Math.abs(x[0]-x[1]);
			int h = Math.abs(y[0]-y[1]);
			System.out.println(w*h);
			System.exit(0);
		}
		if(n==3|| n==4){
			Arrays.sort(x);
			Arrays.sort(y);
			int w = x[n-1]-x[0];
			int h = y[n-1]-y[0];
			System.out.println(w*h);
			System.exit(0);
		}
	}

}
