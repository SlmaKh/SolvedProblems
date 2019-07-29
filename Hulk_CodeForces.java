package acm;
//package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hulk_CodeForces {
	
	public static void main (String[]args) throws IOException{
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
		String n=b.readLine();
		int m = Integer.parseInt(n);
		int count=1;
		String s="I hate";
		while(count!=m){
			if(count%2!=0)
				s+=" that I love";
			else
				s+=" that I hate";
			count+=1;
		}
		s+=" it";
		System.out.println(s);
		
	}

}
