package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextRound_CodeForces {
	public static void main(String []args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s= b.readLine();
		String[] a= s.split(" ");
		int n = Integer.parseInt(a[0]);
		int k = Integer.parseInt(a[1]);
		String s1=b.readLine();
		String []arr=s1.split(" ");
		int count=0;
		int lim=Integer.parseInt(arr[k-1]);
		//System.out.println(k);
		//System.out.println(lim);
		for(int i=0;i<n;i++){
			int x = Integer.parseInt(arr[i]);
			if(x>=lim&&x>0)
				count++;
		}
		System.out.println(count);


	}

}
