package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Isitrated_CodeForces {
	public static void main(String[]args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s1 = b.readLine();
		int n = Integer.parseInt(s1);
		int []arr=new int[n];
		for(int i=0;i<n;i++){
			String s = b.readLine();
			String []a=s.split(" ");
			if(!(a[0].equals(a[1]))){
				System.out.println("rated");
				System.exit(0);
			}
			arr[i]=Integer.parseInt(a[0]);
		}
		for(int i=0;i<n-1;i++){
			if(arr[i]<arr[i+1]){
				System.out.println("unrated");
				System.exit(0);
			}
		}
		System.out.println("maybe");
		System.exit(0);
	}

}
