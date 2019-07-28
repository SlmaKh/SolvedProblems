package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WrongSubtraction_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[]=br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		for(int i=0;i<k;i++){
			if(n%10==0)
				n/=10;
			else 
				n--;
		}
		System.out.println(n);
		
	}

}
