package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WetSharkAndOddAndEven_CodeForces {
	public static void main(String[]args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s1= b.readLine();
		int n =Integer.parseInt(s1);
		String s= b.readLine();
	//	System.out.println(s1+"    "+s);
		String [] a=s.split(" ");
		long result=0;
		for(int i=0;i<n;i++){
			long t=Long.parseLong(a[i]);
			result+=t;
		}
		if(result%2==0){
			System.out.println(result);
		}
		else{
			long min=Long.MAX_VALUE;
			for(int i =0 ;i<n;i++){
				long t=Long.parseLong(a[i]);
				if(t%2!=0){
					if(t<min)
						min=t;
				}
			}
			result-=min;
			//System.out.println(min);
			System.out.println(result);
		}

	}

}
