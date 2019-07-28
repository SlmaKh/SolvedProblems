package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class CoatofAnticubism_CodeForces{
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max=0;
		String temp[]=br.readLine().split(" ");
		int []num=new int[n];
		int maxIndex=0;
		for(int i=0;i<n;i++){
			num[i]= Integer.parseInt(temp[i]);
			if(num[i]>max){
				maxIndex=i;
				max=num[i];
				}
		}
		num[maxIndex]=0;
		int rest =IntStream.of(num).sum();
		int diff = max-rest;
		System.out.println(diff+1);
		
		
	}

}
