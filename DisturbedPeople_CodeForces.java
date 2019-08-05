package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisturbedPeople_CodeForces {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp [] = br.readLine().split(" ");
		int num[]=new int[n];
		for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(temp[i]);
		}
		int count=0;
		for(int i=1;i<n-2;i++){
			if(num[i]==0&& num[i-1]==1 && num[i+1]==1 && num[i+2]==0){
				num[i+1]=0;
				count++;
			}
			else 
				if(num[i]==0&& num[i-1]==1 && num[i+1]==1){
					num[i+1]=0;
					count++;
				}
		}
		if(num[n-3]==1 && num[n-2]==0 && num[n-1]==1){
			count++;
			}
		System.out.println(count);
	}
	

}
