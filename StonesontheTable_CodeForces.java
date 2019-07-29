package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StonesontheTable_CodeForces {
	
	public static void main(String []args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s1 = b.readLine();
		int n = Integer.parseInt(s1);
		String s= b.readLine();
		int count=0;
		for(int i=0; i<n-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				count++;	
			}
		}
		System.out.println(count);
		
		
	}

}
