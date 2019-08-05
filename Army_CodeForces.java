package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Army_CodeForces {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] years = new int [n-1];
		String []temp = br.readLine().split(" ");
		for(int i=0;i<n-1;i++){
			years[i]=Integer.parseInt(temp[i]);
		}
		temp = br.readLine().split(" ");
		int cur = Integer.parseInt(temp[0]);
		int goal = Integer.parseInt(temp[1]);
		
		int sum =0; 
		for(int i=cur-1;i<=goal-2;i++)
			sum+=years[i];
		System.out.println(sum);
 
	}

}
