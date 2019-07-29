package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VityaintheCountryside_CodeForces {
		public static void main(String []args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s1 = b.readLine();
		int n = Integer.parseInt(s1);
		String s=b.readLine();
		String a[]=s.split(" ");
		if(a[n-1].equals("0"))
			System.out.println("UP");
		else if(a[n-1].equals("15"))
			System.out.println("DOWN");
		else if(a.length==1){
			System.out.println(-1);
			System.exit(0);
		}
		else if(Integer.parseInt(a[n-2])<Integer.parseInt(a[n-1]))
			System.out.println("UP");
		else 
			System.out.println("DOWN");


		
		
	}

}
